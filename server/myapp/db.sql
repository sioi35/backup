
--db.sql

--회원 테이블
select * from tblUser1;

--게시판 테이블 > 단계 + 확장
drop table tblBoard1;
drop sequence seqBoard;

select * from tblBoard1;

create table tblBoard1(
    seq number primary key,                             --글번호(PK)
    id varchar2(30) not null references tblUser1(id),   --아이디(FK)
    subject varchar2(500) not null,                     --제목
    content varchar2(4000) not null,                    --내용
    regdate date default sysdate not null,              --작성시각
    readcount number default 0 not null,                --조회수
    tag varchar2(1) not null check(tag in ('y', 'n'))   --글 내용에 HTML 태그 허용 유무    
);

create sequence seqBoard;

select seq, (select name from tblUser1 where id = tblBoard1.id) as name, subject, readcount, regdate from tblBoard1 order by seq desc;

create or replace view vwBoard
as
select 
    seq, id, 
    (select name from tblUser1 where id = tblBoard1.id) as name, 
    subject, readcount, regdate,
    (sysdate - regdate) as isnew,
    content,
    (select count(*) from tblComment where pseq = tblBoard1.seq) as ccnt
from tblBoard1;

select * from vwBoard;
drop table tblComment;
drop sequence seqComment;
select * from tblComment;

--댓글 테이블
create table tblComment(
    seq number primary key,                             --댓글번호
    id varchar2(30) not null references tblUser1(id),   --아이디(FK)
    content varchar2(2000) not null,                    --댓글내용
    regdate date default sysdate not null,              --작성날짜
    pseq number not null references tblBoard1(seq)      --부모글번호(FK)
);

create sequence seqComment;


select * from tblComment;

-- 페이징
-- 게시물을 일정 단위로 끊어서 가져오는 기법
select * from vwBoard 조건;


select subject, rownum from vwBoard v where rownum > 11 and rownum < 20;


create or replace view vwBoard
as
select a.*, rownum as rnum from 
    (select 
        seq, id, 
        (select name from tblUser1 where id = tblBoard1.id) as name, 
            subject, readcount, regdate,
            (sysdate - regdate) as isnew,
            content,
            (select count(*) from tblComment where pseq = tblBoard1.seq) as ccnt,
            thread, depth
         from tblBoard1 order by thread desc) a;

select * from vwBoard where rnum = 5;

select * from vwBoard where rnum > 5 and rnum < 10;


drop table tblComment;
drop sequence seqComment;

drop table tblBoard1;
drop sequence seqBoard;


create table tblBoard1(
    seq number primary key,                             --글번호(PK)
    id varchar2(30) not null references tblUser1(id),   --아이디(FK)
    subject varchar2(500) not null,                     --제목
    content varchar2(4000) not null,                    --내용
    regdate date default sysdate not null,              --작성시각
    readcount number default 0 not null,                --조회수
    tag varchar2(1) not null check(tag in ('y', 'n')),  --글 내용에 HTML 태그 허용 유무    
    thread number not null,                             --정렬 기준
    depth number not null                               --출력
);

create sequence seqBoard;

select * from tblBoard1;
select * from tblUser1;



select * from tblUser1;


--유저별 게시글 수 
--유저별 댓글수
--group by

select name, (select count(*) from tblBoard1 where id = tblUser1.id) as cnt from tblUser1;

select name, (select count(*) from tblComment where id = tblUser1.id) as cnt from tblUser1;






























    