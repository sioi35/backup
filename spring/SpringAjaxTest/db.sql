
--db.sql

drop table tblAjaxUser;
drop sequence seqAjaxUser;
create table tblAjaxUser(
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    address varchar2(300) not null,
    birthday varchar2(10) not null
);

create sequence seqAjaxUser;

insert into tblAjaxUser (seq, name, age, address, birthday) values (seqAjaxUser.nextVal, '홍길동', 20, '서울시 강남구', '2001-01-01');
insert into tblAjaxUser (seq, name, age, address, birthday) values (seqAjaxUser.nextVal, '아무개', 25, '서울시 강북구', '1997-05-09');
insert into tblAjaxUser (seq, name, age, address, birthday) values (seqAjaxUser.nextVal, '테스트', 23, '서울시 강동구', '1999-10-01');
insert into tblAjaxUser (seq, name, age, address, birthday) values (seqAjaxUser.nextVal, '하하하', 22, '서울시 동작구', '2000-12-06');
insert into tblAjaxUser (seq, name, age, address, birthday) values (seqAjaxUser.nextVal, '호호호', 21, '서울시 은평구', '2001-03-26');

select * from tblAjaxUser;
select count(*) from tblAjaxUser;

commit;

--진행 순서
--: 의식의 흐름대로..
--: 업무의 실행 순서대로 구현..

select * from tblAjaxUser order by seq asc;


-- DML
-- 업무에 필요한 SQL를 작성
-- 1. 유저 목록 보기
select * from tblAjaxUser order by name asc;


-- 2. 유저 등록하기
insert into tblAjaxUser (seq, name, age, address, birthday) values (seqAjaxUser.nextVal, '홍길동', 20, '서울시 강남구', '2001-01-01');


-- 3. 특정 유저 가져오기
select * from tblAjaxUser where seq = 1;


--4. 유저 수정하기
update tblAjaxUser set name = '', age= 0, address='', birthday='' where seq = 1;


--5. 유저 삭제
delete from tblAjaxUser where seq = 1;


--6. 유저 검색하기(주소)
select * from tblAjaxUser where address like '%검색어%';



commit;


----------------------------

drop table tblAjaxMemo;
drop sequence seqAjaxMemo;

create table tblAjaxMemo(
    seq number primary key,                     --번호
    id varchar2(10) not null,                   --아이디
    memo varchar2(1000) null,                   --메모
    regdate date default sysdate not null,      --작성시간
    left number default 0 not null,             --좌표(X)
    top number default 0 not null,              --좌표(Y)
    background varchar2(2) not null,            --배경
    zindex number default 0 not null            --zindex
);

create sequence seqAjaxMemo;

select * from tblAjaxMemo;

delete from tblAjaxMemo where seq = 1;

select background from tblAjaxMemo where id = (select max(id) from tblAjaxMemo);

commit;


