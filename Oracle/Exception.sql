DECLARE
    v_wrong NUMBER;
BEGIN
    select DNAME
    into v_wrong
    from DEPT
    where deptno = 10;

    DBMS_OUTPUT.PUT_LINE('실행됨');
EXCEPTION
    WHEN VALUE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('수치 또는 값 오류 발생');
end;