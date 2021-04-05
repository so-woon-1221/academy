--컬렉션은 레코드와 달리 여러행을 저장 가능

DECLARE
TYPE ITAB_EX IS TABLE OF VARCHAR2(20)
    INDEX BY PLS_INTEGER;

text_arr ITAB_EX;

    BEGIN
    text_arr(-1) := 'Test Data';
    text_arr(0) := 'Data';
    text_arr(1) := '1st Data';
    text_arr(2) := '2nd Data';
    text_arr(3) := '3rd Data';

    DBMS_OUTPUT.PUT_LINE('text_arr(1): ' || text_arr(1));
    DBMS_OUTPUT.PUT_LINE('text_arr(0): ' || text_arr(0));
    DBMS_OUTPUT.PUT_LINE('text_arr(-1): ' || text_arr(-1));
end;
-- 컬렉션의 인덱스값은 숫자면 아무거나 되는듯...

select * from EMP;