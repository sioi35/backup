--C:\class\server\JSPTest\db.sql

drop table tblAddress;
drop sequence seqAddress;

create table tblAddress(
    seq number primary key,                                 --PK
    name varchar2(30) not null,                             --이름
    age number(2) not null,                                 --나이
    gender char(1) not null check (gender in ('m', 'f')),   --성별
    address varchar2(500) not null                          --주소
);

create sequence seqAddress;

insert into tblAddress (seq, name, age, gender, address ) values (seqAddress.nextVal, '홍길동', 20, 'm', '서울시 강남구 역삼동');

select * from tblAddress;

delete from tblAddress where name= '홍길동';

select name from tblAddress where name= '홍길동';
select name from tblAddress order by name asc;
commit;

insert into tblAddress (seq, name, age, gender, address ) values (seqAddress.nextVal, '홍길동', 20, 'm', '서울시 강남구 역삼동');
insert into tblAddress (seq, name, age, gender, address ) values (seqAddress.nextVal, '아무개', 23, 'm', '서울시 강남구 대치동');
insert into tblAddress (seq, name, age, gender, address ) values (seqAddress.nextVal, '김당근', 22, 'f', '서울시 강남구 논현동');



-- m1()
create or replace procedure proc_m1
is
begin
    delete from tblAddress;
end;


-- m2()
create or replace procedure proc_m2(
    pname in varchar2,
    page in number,
    pgender in varchar2,
    paddress in varchar2
)
is
begin

    insert into tblAddress (seq, name, age, gender, address ) 
                    values (seqAddress.nextVal, pname, page, pgender, paddress);

end proc_m2;


-- m3()
create or replace procedure proc_m3(
    pname in varchar2,
    page in number,
    pgender in varchar2,
    paddress in varchar2,
    presult out number
)
is
begin

    insert into tblAddress (seq, name, age, gender, address) 
                    values (seqAddress.nextVal, pname, page, pgender, paddress);

    presult := 1;
    
exception
    when others then
        presult := 0;

end proc_m3;


-- m4()
create or replace procedure proc_m4(
    pseq in number,
    pname out varchar2, 
    page out number,
    pgender out varchar2,
    paddress out varchar2
)
is
begin

    select name, age, gender, address 
        into pname, page, pgender, paddress 
            from tblAddress where seq = pseq;
    
end;




-- m5()
create or replace procedure proc_m5(
    pgender in varchar2,
    pcursor out sys_refcursor
)
is
begin

    open pcursor for
        select * from tblAddress where gender = pgender;

end proc_m5;



select * from tblAddress;



--인증 테이블(계정)
drop table tblUser;
select * from tblUser;



select * from tblUser1;

create table tblUser1(
    id varchar2(30) primary key,            --아이디
    pw varchar2(30) not null,               --암호
    name varchar2(30) not null,             --이름
    lv number(1) default (1) not null,      --등급(1,2,3)
    regdate date default sysdate not null   --가입일
);


insert into tblUser1 values ('hong', '1111', '홍길동', default, default);
insert into tblUser1 values ('test', '1111', '테스트', default, default);
insert into tblUser1 values ('admin', '1111', '관리자', 3, default);


--명함

create table tblCard(
    seq number primary key,             --PK
    korname varchar2(50) not null,      --이름(한글)
    engname varchar2(50) not null,      --이름(영문)
    tel varchar2(15) not null,          --연락처
    email varchar2(50) not null,        --이메일
    company varchar2(50) not null,      --회사
    position varchar2(50) not null      --직급

);

create sequence seqCard;

insert into tblCard(seq, korname, engname, tel, email, company, position)
    values (seqCard.nextVal, '홍길동', 'Hong gil dong', '010-1234-5678', 'hong.java@gmail.com', '쌍용 OO 솔루션', '제 1개발팀 팀장');


commit;

select * from tblCard order by seq asc;



--practice 회원목록 tblMember

create table tblMember1(
    id varchar2(30) primary key,            --아이디
    pw varchar2(30) not null,               --암호
    name varchar2(30) not null,             --이름
    tel varchar2(30) not null,
    birth varchar2(30) not null
);


drop table tblMember;
select * from tblMember1;

insert into tblMember1(id,pw, name, tel, birth)
    values ('hong', '1234', '홍길동', '010-1234-5678', '1997-07-02');


