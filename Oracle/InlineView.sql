select *
from EMPLOYEES;

select *
from DEPARTMENTS;

create VIEW v_employees_departments
as
select employees.EMPLOYEE_ID, employees.FIRST_NAME, DEPARTMENTS.DEPARTMENT_NAME
from EMPLOYEES
         join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;

select *
from v_employees_departments;

select vv.*
from (select employees.EMPLOYEE_ID, employees.FIRST_NAME, DEPARTMENTS.DEPARTMENT_NAME
      from EMPLOYEES
               join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID
     ) vv;

WITH VVE as (select employees.EMPLOYEE_ID, employees.FIRST_NAME, DEPARTMENTS.DEPARTMENT_NAME
             from EMPLOYEES
                      join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID
)
select ROWNUM, VVE.*
from VVE
where ROWNUM < 4;
-- ROWNUM은 자동적으로 행의 번호를 매겨줌

SELECT ROWNUM, EMPLOYEES.*
from EMPLOYEES
ORDER BY SALARY DESC;
-- ROWNUM은 SELECT절에 맞춰서만 행번호를 처리하고 order by로는 정렬이 안됨.

SELECT ROWNUM, vv.*
from (Select * from EMPLOYEES order by SALARY DESC) vv
where ROWNUM = 1;
-- 이런식으로 from절에서 인라인뷰를 적용해야 select의 rownum이 정렬된 순서로 표시가능
