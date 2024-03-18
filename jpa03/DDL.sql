--jpa03와 연동하는 테이블 생성
drop table mem;
create table mem
(
     email varchar2(50) primary key
    ,username varchar2(50) not null
    ,birthday date
    ,age number(3)
);

select * from mem;