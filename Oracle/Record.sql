CREATE TABLE DEPT_RECORD
AS
select *
from DEPT;

select *
from DEPT_RECORD;

DECLARE
    TYPE REC_DEPT is record
                     (
                         deptno NUMBER(2) NOT null := 99,
                         dname  DEPT.DNAME%TYPE,
                         loc    DEPT.LOC%TYPE
                     );
    dept_rec REC_DEPT;
BEGIN
    dept_rec.deptno := 99;
    dept_rec.dname := 'DATABASE';
    dept_rec.loc := 'SEOUL';

    INSERT INTO DEPT_RECORD values dept_rec;
--     dept_rec라는 레코드를 이용해서 한번에 데이터 삽입
end;

DECLARE
    TYPE REC_DEPT is record
                     (
                         deptno NUMBER(2) NOT null := 99,
                         dname  DEPT.DNAME%TYPE,
                         loc    DEPT.LOC%TYPE
                     );
    dept_rec REC_DEPT;
BEGIN
    dept_rec.deptno := 50;
    dept_rec.dname := 'DB';
    dept_rec.loc := 'SEOUL';

    UPDATE DEPT_RECORD
    SET ROW = dept_rec
    where DEPTNO = 99;
    -- 이번엔 dept_rec을 이용해서 데이터 업데이트
end;

--procedure 절차 -> PL/SQL로 작성된 코드집합을 프로시저라고 함

DECLARE
    TYPE REC_DEPT IS RECORD
                     (
                         deptno DEPT.DEPTNO%TYPE,
                         dname  DEPT.DNAME%TYPE,
                         loc    DEPT.LOC%TYPE
                     );
    TYPE REC_EMP IS RECORD
                    (
                        empno EMP.EMPNO%TYPE,
                        ename EMP.ENAME%TYPE,
                        dinfo REC_DEPT
                    );
    emp_rec REC_EMP;
BEGIN
    SELECT E.EMPNO, E.ENAME, D.DEPTNO, D.DNAME, D.LOC

    INTO emp_rec.empno, emp_rec.ename, emp_rec.dinfo.deptno, emp_rec.dinfo.dname, emp_rec.dinfo.loc
    from EMP E,
         DEPT D
    WHERE E.DEPTNO = D.DEPTNO
      AND E.EMPNO = 7788;

    DBMS_OUTPUT.PUT_LINE('DEPTNO: ' || emp_rec.empno);
end;
--레코드 중첩

