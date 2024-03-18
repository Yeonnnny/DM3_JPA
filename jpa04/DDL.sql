-- jpa04에서 사용할 객체 DDL

drop table product;
drop SEQUENCE prod_seq;

create table product -- 의류로 가정
(
    prod_id number primary key  -- 일련번호
    ,prod_name varchar2(50)
    ,season varchar2(100) -- 봄, 여름, 가을, 겨울
    ,unit_price number
);

create SEQUENCE prod_seq;
