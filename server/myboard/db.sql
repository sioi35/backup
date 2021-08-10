--게시판 연습용

drop table tblBoard;
drop sequence seqBoard1;
drop table tblUser;


create table tblUser(
    id varchar2(30) primary key,
    pw varchar2(30) not null,
    name varchar2(50) not null

);


insert into tblUser values ('hong', '1111', '홍길동');
insert into tblUser values ('test', '1111', '테스트');
insert into tblUser values ('admin', '1111', '관리자');

create table tblBoard(
    seq number primary key,                             --글번호(PK)
    id varchar2(30) not null references tblUser(id),    --아이디(FK)
    subject varchar2(500) not null,                     --제목
    content varchar2(4000) not null,                    --내용
    thread number not null,                             --정렬 기준
    depth number not null                               --출력
);

create sequence seqBoard1;



select * from tblUser;
select * from tblBoard;


--지도
create table tblPlace(
    seq number primary key,         --PK
    name varchar2(100) not null,    --장소명
    lat number not null,            --위도(Latitude)
    lng number not null             --경도(Longitude)            
);

create sequence seqPlace;

select * from tblPlace;



create user web identified by java1234;

show user;
grant connect, resource to web;

grant create view to web;









