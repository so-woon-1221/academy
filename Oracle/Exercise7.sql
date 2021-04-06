select *
from EMPTEST;

CREATE OR REPLACE PROCEDURE increaseSal
    IS
    v_increaseRate number := 1.1;
BEGIN
    UPDATE EMPTEST SET SAL = SAL * v_increaseRate;
end;

call increaseSal();

select *
from EMP;
select *
from EMPTEST;



create table EMPTEST2
as
select *
from EMP;

CREATE OR REPLACE PROCEDURE increaseSal2(
    p_increaseRate IN NUMBER
) IS
BEGIN
    update EMPTEST2 SET SAL = SAL + (SAL * p_increaseRate / 100);
end;

call increaseSal2(10);

select *
from EMPTEST2 order by DEPTNO;


CREATE TABLE EMPTEST3
as
select *
from EMP;

CREATE OR REPLACE PROCEDURE increaseSal3(
    p_deptNo IN number,
    p_increaseRate IN number
) IS
BEGIN
    UPDATE EMPTEST3 SET SAL = SAL + (SAL * p_increaseRate / 100) where DEPTNO = p_deptNo;
end;

call increaseSal3(10, 10);
call increaseSal3(20, 20);
call increaseSal3(30, 30);
call increaseSal3(40, 40);

select *
from EMPTEST3
order by DEPTNO;