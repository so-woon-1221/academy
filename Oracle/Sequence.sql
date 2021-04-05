create table DEPT_SEQUENCE
as
select *
from DEPT
where 1 <> 1;

create SEQUENCE seq_dept_sequence
    increment by 10 -- 10씩 증가
    start with 10 -- 10부터 시작
    maxvalue 90
    minvalue 0
    nocycle
    cache 2;

INSERT INTO DEPT_SEQUENCE(DEPTNO, DNAME, LOC)
values (SEQ_DEPT_SEQUENCE.nextval, 'DATABASE', 'SEOUL');
-- DEPTNO를 SEQUENCE의 nextval(다음값으로 지정)

select *
from DEPT_SEQUENCE;

select SEQ_DEPT_SEQUENCE.currval
from DUAL;
-- 현재값

ALTER SEQUENCE seq_dept_sequence
    increment by 3
    maxvalue 99
    cycle;
-- 시퀀스 수정

INSERT INTO DEPT_SEQUENCE
values (seq_dept_sequence.nextval, 'DATABASE', 'SEOUL');

select *
from DEPT_SEQUENCE;

DROP SEQUENCE SEQ_DEPT_SEQUENCE;
