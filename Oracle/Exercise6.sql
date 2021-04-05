CREATE TABLE STUDENT
(
    studentId   int primary key,
    studentName varchar2(20) not null,
    studentDept varchar2(10) not null
);

INSERT INTO STUDENT
VALUES (200, 'AA', 'Computer');
INSERT INTO STUDENT
VALUES (201, 'BB', 'Korean');
INSERT INTO STUDENT
VALUES (202, 'CC', 'English');
INSERT INTO STUDENT
VALUES (203, 'DD', 'Management');
INSERT INTO STUDENT
VALUES (204, 'EE', 'Computer');
INSERT INTO STUDENT
VALUES (205, 'FF', 'English');

CREATE TABLE CIRCLE
(
    circleId   int primary key,
    circleName varchar2(10) not null
);

INSERT INTO CIRCLE
VALUES (100, 'Band');
INSERT INTO CIRCLE
VALUES (101, 'Read');
INSERT INTO CIRCLE
VALUES (102, 'Run');
INSERT INTO CIRCLE
VALUES (103, 'Bike');
INSERT INTO CIRCLE
VALUES (104, 'Acting');
INSERT INTO CIRCLE
VALUES (105, 'UFC');

select *
from CIRCLE;

CREATE TABLE CIRCLE_JOIN
(
    joinId    int primary key,
    studentId int not null REFERENCES STUDENT (studentId),
    circleId  int REFERENCES CIRCLE (circleId)
);

INSERT INTO CIRCLE_JOIN
VALUES (1, 200, 100);
INSERT INTO CIRCLE_JOIN
VALUES (2, 200, 101);
INSERT INTO CIRCLE_JOIN
VALUES (3, 201, 102);
INSERT INTO CIRCLE_JOIN
VALUES (4, 202, 102);
INSERT INTO CIRCLE_JOIN
VALUES (5, 203, 103);
INSERT INTO CIRCLE_JOIN
VALUES (6, 204, 104);

select *
from CIRCLE_JOIN;

SELECT C.circleId as CircleName, S.studentName as StudentName, S.studentId as StudentID
from CIRCLE C, STUDENT S, CIRCLE_JOIN CJ
where CJ.studentId = S.STUDENTID and C.circleId = CJ.CIRCLEID;

SELECT studentName
from STUDENT
where studentId NOT IN (SELECT STUDENTID from CIRCLE_JOIN);

SELECT circleName
from CIRCLE
where circleId NOT IN (SELECT CIRCLEID from CIRCLE_JOIN);


CREATE TABLE BOOK
(
    bookId    char(4) primary key,
    bookTitle varchar2(20) NOT NULL
);

INSERT INTO BOOK
VALUES ('0001', 'Java');
INSERT INTO BOOK
VALUES ('0002', 'Oracle');
INSERT INTO BOOK
VALUES ('0003', 'Html');
INSERT INTO BOOK
VALUES ('0004', 'JSP');

CREATE TABLE BOOK_RENT
(
    rentNo    number primary key,
    studentId int  not null REFERENCES STUDENT (studentId),
    bookId    char(4) REFERENCES BOOK (bookId),
    rentDate  date not null
);

INSERT INTO BOOK_RENT
VALUES (1, '200', '0001', '2016-12-01');
INSERT INTO BOOK_RENT
VALUES (2, '201', '0002', '2016-12-02');

SELECT S.studentId, S.studentName, B.bookTitle, BR.rentDate
from STUDENT S,
     BOOK B,
     BOOK_RENT BR
where B.bookId = BR.bookId
  and BR.studentId = S.studentId;

SELECT *
from BOOK
where bookId not in (select BOOKID from BOOK_RENT)
order by bookId;
