<?php

header("access-control-allow-origin: *");

header("Content-Type: text/json; charset=UTF-8");



if(!isset($_POST['name']) ||

!isset($_POST['address'])) exit;



$user_name = $_POST['name'];

$user_address = $_POST['address'];



// DB에서 member테이블 update

$mysql_hostname = 'localhost';

$mysql_username = 'janus1221';

$mysql_password = 'wlgns7359';

$mysql_database = 'janus1221';

$mysql_port = '3307';

$mysql_charset = 'utf8';



//1. DB 연결

$connect = @mysql_connect($mysql_hostname.':'.$mysql_port, $mysql_username, $mysql_password);



if(!$connect){

    echo '[연결실패] : '.mysql_error().'<br>';

    die('MySQL 서버에 연결할 수 없습니다.');



}

//2. DB 선택

@mysql_select_db($mysql_database, $connect) or die('DB 선택 실패');



//3. 문자셋 지정

mysql_query(' SET NAMES '.$mysql_charset);



//4. 쿼리 생성

$query = "update member set name='".$user_name."',address='".$user_address."' where id='".$_POST["id"]."';";



//5. 쿼리 실행

$result = mysql_query($query);



//6. 연결 종료

mysql_close($connect);



echo '{

    "message":"수정되었습니다"

}';



?>