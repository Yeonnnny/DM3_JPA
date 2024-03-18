--jpa01 프로젝트용 DDL

drop table myuser;
create table myuser
(
    USERNAME      VARCHAR2(20)
    ,EMAIL        VARCHAR2(50)
    ,JOIN_DATE    DATE
);
