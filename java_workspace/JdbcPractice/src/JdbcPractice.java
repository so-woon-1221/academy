import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPractice {
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    //DB 접속 아이디, 비밀번호.
    private static final String USER = "ora_user"; //아이디
    private static final String PASS = "hong"; //비밀번호

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();

            System.out.println("연결완료");

            System.out.println('a');
            statement.executeUpdate("delete from student where id = '0851111'");
            System.out.println("aa");
            ResultSet resultSet = statement.executeQuery("select * from STUDENT");

            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
            }

//            statement.executeUpdate("INSERT into STUDENT values ('0893012', '아무개', '컴퓨터공학')");
//            statement.executeUpdate("UPDATE STUDENT set id = '0851111' where name = '아무개'");
//            statement.executeUpdate("delete from STUDENT where id='0851111'");
//            ResultSet resultSet = statement.executeQuery("select * from STUDENT");
//            while( resultSet.next()){
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
//            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
