--ex25_alter.sql

/*

DDL
- 객체 생성: create
- 객체 삭제: drop
- 객체 수정: alter

DML
- 데이터 생성: insert
- 데이터 삭제: delete
- 데이터 수정: update


테이블 수정하기, alter table
- 테이블 구조 수정하기 > 컬럼 정의 수정하기
- 되도록 테이블을 수정하는 상황이 발생하면 안된다.(**************)


1. alter 사용 > 기존 테이블의 구조를 변경
    a. 기존 테이블에 데이터 없었을 경우 > 빈테이블 > 아무일 없음
    b. 기존 테이블에 데이터 있었을 경우 > 미리 데이터 백업 > 수정 > 변수
        - 서비스 운영 중 사용

2. 테이블 삭제 > 수정된 테이블 생성
    a. 기존 테이블에 데이터 없었을 경우 > 빈테이블
    b. 기존 테이블에 데이터 있었을 경우 > 미리 데이터 백업 > 테이블 삭제 > 테이블 생성 > 데이터 복구
        - 서비스 운영 중 사용
        - 개발 중에 사용


테이블 수정하기
1. 새로운 컬럼 추가하기 : 무난 + 고민(X)
2. 기존 컬럼 삭제하기: 무난 + 고민(데이터 삭제, FK)
3. 기존 컬럼의 정의 수정하기
    - 컬럼명 바꾸기: 무난 + 고민(기존 데이터X, 기존 쿼리..)
    - 컬럼의 길이 바꾸기: 무난 + 고민(기존 데이터의 길이)
    - 컬럼의 자료형 바꾸기: 무난 + 고민(기존 데이터)
    - 컬럼의 제약사항 바꾸기: 무난 + 고민(기존 데이터)

*/

drop table tblEdit;

create table tblEdit(
    seq number primary key,
    data varchar2(20) not null
);

select * from tblEdit;

insert into tblEdit values(1, '마우스');
insert into tblEdit values(2, '키보드');
insert into tblEdit values(3, '모니터');


-- 1. 새로운 컬럼 추가하기 > 가격 컬럼
--alter table tblEdit add (추가 컬럼 정의);
alter table tblEdit
    add(price number(5) null);  -- null 컬럼 추가
    
-- null -> optional
-- not null -> madatory


--ORA-01758: table must be empty to add mandatory (NOT NULL) column
alter table tblEdit
    add(description varchar2(100) not null);  -- not null 컬럼 추가

--1.
alter table tblEdit
    add(description varchar2(100) default '임시' not null); -- not null 컬럼 추가

--2.
delete from tblEdit;

alter table tblEdit
    add (etc varchar2(100) not null); -- not null 컬럼추가

select * from tblEdit;


--2. 기존 컬럼 삭제하기
alter table tblEdit
    drop column etc;

alter table tblEdit
    drop column description;

alter table tblEdit
    drop column seq; --심각하게 고민.. PK > 되도록 금지 


--3. 기존 컬럼의 정의 수정하기
select * from tblEdit;

insert into tblEdit values(4, '올해 새롭게 출시된 초경량 노트북');


-- 3.a 컬럼의 길이 수정하기(확장, 축소)
--alter table tblEdit modify(컬럼 정의);
alter table tblEdit 
    modify(data varchar2(100));

--ORA-01441: cannot decrease column length because some value is too big
alter table tblEdit 
    modify(data varchar2(50BYTE));

desc tblEdit;

--3.b 컬럼의 자료형 바꾸기
select * from tblEdit;

--01439. 00000 -  "column to be modified must be empty to change datatype"
delete from tblEdit;

alter table tblEdit
    modify(seq varchar2(100));


-- 3.c 제약 사항 바꾸기
alter table tblEdit
    modify (data varchar2(20) null);

desc tblEdit;

--3.d 컬럼명 바꾸기
alter table tblEdit
    rename column data to name;


-- 기존 테이블 + 기존 컬럼에 새로운 제약 사항 추가하기
desc tblEdit;

alter table tblEdit
    add(color varchar2(100) null);

select * from tblEdit;

alter table tblEdit
    add constraint tbledit_color_ck check (color in ('red', 'yellow', 'blue'));


insert into tblEdit values (4, '핸드폰', 'yellow');
insert into tblEdit values (5, '태블릿', 'black');


drop table tblEdit2;
create table tblEdit2(
    seq number, --PK
    data varchar2(30) not null, --CK
    pseq number not null -- FK
);

alter table tblEdit2
    add constraint tbledit2_seq_pk primary key(seq);

alter table tblEdit2
    add constraint tbledit2_data_ck check(length(data) >= 5);

alter table tblEdit2
    add constraint tbledit2_pseq_fk foreign key(pseq) references tblEdit(seq);
