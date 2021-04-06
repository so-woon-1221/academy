create Table EMP_TRG as
select *
from emp;

-- 주말에는 dml이 작동하지 않도록
create or replace trigger trg_emp_nodml_weekend
    before
        insert or update or delete
    on EMP_TRG
begin
    if TO_CHAR(SYSDATE, 'DY') IN ('토', '일') then
        if inserting then
            raise_application_error(-20000, '주말 사원정보 추가 불가');
        elsif updating then
            raise_application_error(-20001, '주말 사원정보 수정 불가');
        elsif deleting then
            raise_application_error(-20002, '주말 사원정보 삭제 불가');
        else
            raise_application_error(-20003, '주말 사원정보 변경 불가');
        end if;
    end if;
end;

update EMP_TRG
set SAL =3500
where EMPNO = 7788;



CREATE TABLE EMP_TRG_LOG
(
    TABLENAME   VARCHAR2(10), --DML 수행된 테이블
    DML_TYPE    VARCHAR2(10), -- DML 명령어 종류
    EMPNO       NUMBER(4),    -- 대상 사원번호
    USER_NAME   VARCHAR2(30), -- 수행한 user 이름
    CHANGE_DATE DATE          -- 수행한 날짜
);

-- dml을 작동시키면 로그 테이블에 로그를 기록함
create or replace trigger trg_emp_log
    after
        insert or update or delete
    on EMP_TRG
    for each row

begin
    if inserting then
        insert into EMP_TRG_LOG
        values ('EMP_TRG', 'INSERT', :new.empno, SYS_CONTEXT('USERENV', 'SESSION_USER'), SYSDATE);
    elsif updating then
        insert into EMP_TRG_LOG
        values ('EMP_TRG', 'UPDATE', :old.empno, SYS_CONTEXT('USERENV', 'SESSION_USER'), SYSDATE);
    elsif Deleting then
        insert into EMP_TRG_LOG
        values ('EMP_TRG', 'DELETE', :old.empno, SYS_CONTEXT('USERENV', 'SESSION_USER'), SYSDATE);
    end if;
end;

select *
from EMP_TRG;

insert into EMP_TRG
values (9999, 'hi', 'CLERK', 7788, TO_DATE('2018-03-03', 'YYYY-MM-DD'), 1200, null, 20);

select * from EMP_TRG_LOG;

UPDATE EMP_TRG set SAL=1300 where MGR=7788

-- 트리거나 트리거를 유발한 트랙잭션이나 모두 기록이 됨.
commit;