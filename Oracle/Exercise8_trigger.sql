CREATE TABLE PRODUCT
(
    productID     number(4) primary key,
    productName   varchar2(20)        not null,
    productPrice  number(10)          not null,
    productAmount number(5) default 0 not null
);

CREATE TABLE ITEMIN
(
    inID     number(4) primary key,
    productID REFERENCES PRODUCT (productId) not null,
    inAmount number(5)                       not null,
    inDate   Date
);

CREATE TABLE ITEMOUT
(
    outID    number(4) primary key,
    productID REFERENCES PRODUCT (productID) not null,
    outAmout number(5)                       not null,
    outDate  Date
);

insert into PRODUCT
values (0000, 'IPHONE', 10000, 100);
insert into PRODUCT
values (0001, 'IPad', 20000, 10);
insert into PRODUCT
values (0002, 'WATCH', 5000, 150);
insert into PRODUCT
values (0003, 'AIRPOD', 7000, 30);
insert into PRODUCT
values (0004, 'MACBOOK', 50000, 120);
insert into PRODUCT
values (0005, 'IMAC', 80000, 5);

CREATE OR REPLACE TRIGGER item_in_product_increase
    AFTER
        INSERT
    on ITEMIN
    FOR EACH ROW

BEGIN
    IF INSERTING THEN
        UPDATE PRODUCT SET productAmount = (productAmount + :new.inAmount) where productID = :new.productID;
    end if;
end;

INSERT INTO ITEMIN
values (0001, 0005, 15, SYSDATE);

select *
from ITEMIN;
select *
from PRODUCT
where productID = 0005;


CREATE OR REPLACE TRIGGER item_out_product_decrease
    AFTER
        INSERT
    on ITEMOUT
    FOR EACH ROW

BEGIN
    IF INSERTING THEN
        UPDATE PRODUCT SET productAmount = (productAmount - :new.outAmout) where productID = :new.productID;
    end if;
end;


INSERT INTO ITEMOUT values (0001, 0005, 10, SYSDATE);

select *
from PRODUCT
where productID = 0005;
select *
from ITEMOUT;

commit;