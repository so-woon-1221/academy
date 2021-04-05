-- 저장 프로시저(stored Procedure) / 사용자정의 함수 / 트리거
-- PL/SQL에서 작성한 장문의 코드들을 저장해서 재사용을 용이하게 하려는것
-- 프로시저는 begin ... end문으로 이루어진 모든것을 프로시저라고 부름

CREATE OR REPLACE PROCEDURE pro_noparam
    is
    v_empno number(4) := 7788;
    v_ename varchar2(10);
begin
    v_ename := 'scott';
    DBMS_OUTPUT.PUT_LINE('V_EMPNO : ' || v_empno);
    DBMS_OUTPUT.PUT_LINE('V_ENAME : ' || v_ename);
end;

call pro_noparam();

begin
    pro_noparam;
end;

select *
from USER_SOURCE;

CREATE OR REPLACE PROCEDURE pro_param_in(
    param1 IN NUMBER,
    param2 NUMBER,
    --param2 OUT NUMBER, --이렇게 하면 프로시저가 out이 붙은 param2를 리턴함
    param3 NUMBER := 3,
    param4 NUMBER DEFAULT 4
) IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('param1 : ' || param1);
    DBMS_OUTPUT.PUT_LINE('param2 : ' || param2);
    DBMS_OUTPUT.PUT_LINE('param3 : ' || param3);
    DBMS_OUTPUT.PUT_LINE('param4 : ' || param4);
end;

call pro_param_in(1, 2, 5, 6);

-- 회원탈퇴를 하면 탈퇴한 회원을 exit 테이블에 넣고 원본테이블에서 삭제
-- 이러한 작업을 프로시저로 처리할 수 있음.
create table memberTest
(
    id   varchar2(20) primary key,
    name varchar2(30) not null
);
insert into memberTest
values ('hkd', '홍길동');
insert into memberTest
values ('lss', '이순신');

create table memberTestExit as
select *
from memberTest
where 1 <> 1;

insert into memberTestExit
select *
from memberTest
where id = 'lss';

delete
from memberTest
where id = 'lss';

CREATE or replace PROCEDURE memberDelete(
    deleteID IN memberTest.id%TYPE
) IS
BEGIN
    insert into memberTestExit
    select *
    from memberTest
    where id = deleteID;

    delete from memberTest where id = deleteID;
end;

call memberDelete('lss');

select *
from memberTestExit;
select *
from memberTest;

commit;

-- out 모드를 사용하는 parameter
create or replace procedure pro_param_out(
    in_emp In EMP.EMPNO%TYPE,
    out_ename out EMP.ENAME%TYPE,
    out_sal out EMP.SAL%TYPE) IS

BEGIN
    select ename, sal
    INTO out_ename, out_sal
    from EMP
    where EMPNO = in_emp;
end;

DECLARE
    v_ename EMP.ENAME%TYPE;
    v_sal   EMP.SAL%TYPE;
BEgin
    pro_param_out(7788, v_ename, v_sal);
    DBMS_OUTPUT.PUT_LINE(v_ename);
    DBMS_OUTPUT.PUT_LINE(v_sal);
end;