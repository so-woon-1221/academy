-- 커서는 행의 위치를 가르치는 것. / select 문의 결과에서 한행을 가리키는 역할
-- 한 행씩 처리하기위해 사용 -> 상호연관 쿼리와 유사
-- 자바에서는 ResultSet클래스를 사용해서 구현 ( 클라이언트 측에서 처리 ) <-> 커서는 서버에서 처리

DECLARE
    V_DEPT_ROW DEPT%ROWTYPE;
    CURSOR c1 IS
        SELECT *
        FROM DEPT
        WHERE DEPTNO = 40;
BEGIN
    OPEN c1;

    FETCH c1 INTO V_DEPT_ROW;

    DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || V_DEPT_ROW.DEPTNO);

    CLOSE c1;
end;

-- 커서를 이용한 다중 행 처리
DECLARE
    V_DEPT_ROW DEPT%ROWTYPE;
    CURSOR c1 IS
        SELECT *
        FROM DEPT;
BEGIN
    OPEN c1;

    LOOP
        FETCH c1 INTO V_DEPT_ROW;

        EXIT WHEN c1%NOTFOUND;
        -- 이거 없으면 40에서 계속 돌음

        DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || V_DEPT_ROW.DEPTNO);

    end loop;
    CLOSE c1;
end;


-- 커서를 for loop문으로 하는 것 -> 자동 open, fetch, close
DECLARE
    CURSOR c1 IS
        SELECT *
        FROM DEPT;
BEGIN
    -- c1_rec은 모든 타입을 가진 레코드 타입이여야함.
    FOR c1_rec in c1
        Loop
            DBMS_OUTPUT.PUT_LINE('DEPTNO : ' || c1_rec.DEPTNO);
        end loop;
end;

--파라미터를 갖는 커서 만들기
DECLARE
--     V_DEPT_ROW DEPT%ROWTYPE;
    v_deptno DEPT.DEPTNO%TYPE;
    CURSOR c1(p_detno DEPT.DEPTNO%TYPE) IS
        SELECT *
        from DEPT D
        WHERE D.DEPTNO = p_detno;

-- BEGIN
-- --         OPEN c1(10);
-- --
-- --     LOOP
-- --         FETCH c1 INTO V_DEPT_ROW;
-- --
-- --         EXIT WHEN c1%NOTFOUND;
-- --         DBMS_OUTPUT.PUT_LINE(V_DEPT_ROW.DEPTNO);
-- --         DBMS_OUTPUT.PUT_LINE(V_DEPT_ROW.LOC);
-- --
-- --     end loop;
-- --     CLOSE c1;
--
-- end;

    --값 입력받아서 커서 파라미터 처리
BEGIN
    v_deptno := &INPUT_DEPT;
    for c1_rec in C1(v_deptno) loop
        DBMS_OUTPUT.PUT_LINE(c1_rec.DEPTNO);
        end loop;
end;
