-- ex13_DDL.sql

/*

DDL
- 데이터 정의어
- 데이터베이스 객체를 생성, 수정, 삭제한다.
- 데이터베이스 객체: 테이블, 뷰, 인덱스, 트리거, 프로시저, 제약 사항, 계정 등...
- create, alter, drop

DDL + 테이블(제약사항)

테이블 생성하기 -> 테이블을 구성하는 컬럼을 생성하기(컬럼 정의)

create table 테이블명
(
    컬럼 정의,
    컬럼 정의,
    컬럼 자료형(길이) null표기 제약사항
);


제약 사항, Constraint
- ************************
- 해당 컬럼에 들어갈 데이터(값)에 대한 조건(규제 사항)
    -> 조건을 만족하면 데이터 통과, 조건을 만족하지 못하면 데이터 거부 -> 에러 발생 -> 유효성 검사 도구    
- 6가지

1. not null
    - 해당 컬럼이 반드시 값을 가져야 한다.
    - 해당 컬럼이 값이 없으면 에러
    - 필수값(***)
    - null을 가지지 못한다.
    
2. primary key, PK
    - 해당 컬럼이 모든 레코드 중에 유일한 값을 가져야 한다.
    - 다른 레코드와 같은 값을 가질 수 없다.
    - 유일하다. + 필수값 *******
    - 주로 식별자로 사용합니다**********
    - 테이블의 모든 행들을 유일하게 구분하는 역할의 키(컬럼)
    - 반드시 테이블엔 PK가 존재해야 한다. (PK가 없는 테이블을 만들 수 있다. -> 비권장)
    - 기본키의 형태
        a. 단일 기본키 > 기본키 : 1개의 컬럼이 PK 역할
        b. 복합 기본키 > 복합키 : 2개 이상의 컬럼이 모여서 PK 역할, Composite Key

3. foreign key
    - 참조키, 외래키
    - 나중에 수업
    
4. unique
    - primary key - not null
    - 중복값을 가질 수 없는데 null은 가질 수 있다.

5. check
    - 사용자 정의 제약 조건
    - where절에서 조건을 거는것과 동일


6. default
    - 기본값 설정
    - 해당 컬럼값이 null이면 대신 미리 기본값을 대입한다.

*/

-- 메모 테이블
create table tblMemo(
    
    seq number(3),          --메모 번호
    name varchar2(30),      --작성자
    memo varchar2(1000) null,    --메모내용
    regdate date null          --작성 날짜
);
-- null이 생략되어있음

select * from tblMemo;


--데이터 추가하기
--insert into tblMemo(컬럼리스트) vales (값리스트);
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo) values (1, '홍길동', '메모입니다.');  -- 날짜 생략
insert into tblMemo(seq, name, memo, regdate) values (1, null, '메모입니다.', sysdate);

drop table tblMemo;

create table tblMemo(
    
    seq number(3) not null,      --메모 번호
    name varchar2(30) not null,  --작성자
    memo varchar2(1000) null,    --메모내용
    regdate date null            --작성 날짜
);



select * from tblMemo;

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', null, sysdate);


--ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."NAME")  -- NULL을 ("HR"."TBLMEMO"."NAME") 안에 삽입할 수 없음
insert into tblMemo(seq, name, memo, regdate) values (1, null, '메모입니다', sysdate);
insert into tblMemo(seq, memo, regdate) values (1, '메모입니다', sysdate);


-- 기본키, PK
drop table tblMemo;

create table tblMemo(
    
    --모든 테이블에는 PK가 반드시 있어야 한다. -> 의미하는 것!???
    seq number(3) primary key, -- 기본키(PK) -> 중복값을 가질 수 없다(Unique) + Not Null -> 완벽한 식별자
    name varchar2(30),
    memo varchar2(1000),
    regdate date
    
);

-- 현재 상태는 레코드를 구분할 방법이 없다*****
-- ORA-00001: unique constraint (HR.SYS_C007067) violated -- 무결성 제약조건에 위배됩니다.
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '아무개', '테스트~', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (3, '아무개', '테스트~', sysdate);

--ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."SEQ") --seq컬럼에는 null값 못 들어감
insert into tblMemo(seq, name, memo, regdate) values (null, '아무개', '테스트~', sysdate);

select
    seq, name, memo, to_char(regdate, 'yyyy-mm-dd hh24:mi:ss')
from tblMemo
    where seq = 2;


select * from tblInsa; -- num(PK)
select * from tblMen; --name(PK)
select * from tblCountry; --name(PK)
select * from tblComedian; 




drop table tblMemo;

create table tblMemo(
    
    seq number(3) primary key, 
    name varchar2(30) unique, -- 중복값 금지, 식별자로는 사용할 수 없다.(null을 허용하기 때문에)
    memo varchar2(1000),
    regdate date
    
);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '아무개', '메모입니다.', sysdate);

--ORA-00001: unique constraint (HR.SYS_C007069) violated
insert into tblMemo(seq, name, memo, regdate) values (3, '홍길동', '또 다른 메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (3, '하하하', '또 다른 메모입니다.', sysdate);

insert into tblMemo(seq, name, memo, regdate) values (4, null, '또 다른 메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (5, null, '또 다른 메모입니다.', sysdate);


select
    *
from tblMemo;



drop table tblMemo;

create table tblMemo(
    
    seq number(3) primary key, 
    name varchar2(30), 
    memo varchar2(1000),
    regdate date,
    --lv number not null check(lv >=1 and lv <=5) -- 숫자(메모 중요도, 1 ~ 5)
    --color varchar2(30) not null check(color = 'red' or color = 'blue' or color = 'yellow')
    lv number not null check(lv between 1 and 5),
    color varchar2(30) not null check(color in ('red', 'blue', 'yellow')),
    updatedate date check(to_char(updatedate, 'd') = 2)
);


insert into tblMemo(seq, name, memo, regdate, lv) values (1, '홍길동', '메모입니다.', sysdate, 1);

--ORA-02290: check constraint (HR.SYS_C007071) violated -- 체크 제약조건 위배
insert into tblMemo(seq, name, memo, regdate, lv) values (2, '홍길동', '메모입니다.', sysdate, 10);
insert into tblMemo(seq, name, memo, regdate, lv) values (2, '아무개', '메모입니다.', sysdate, 13);

select * from tblMemo;



drop table tblMemo;

create table tblMemo(
    
    seq number(3) primary key, 
    name varchar2(30) default '익명', 
    memo varchar2(1000) default '메모없음',
    regdate date
    
);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, regdate) values (2, sysdate);

select * from tblMemo;
insert into tblMemo(seq, name, memo, regdate) values (seqNum.nextVal, '홍길동', '메모입니다.', sysdate);


/*
제약사항을 만드는 방법

1. 컬럼 수준에서 만드는 방법
    - 현재 방법
    - 컬럼 1개를 정의할 때 제약사항도 같이 정의하는 방법
    - 컬럼명 자료형(길이) [constraint 제약명] 제약조건

2. 테이블 수준에서 만드는 방법

*/


drop table tblMemo;

create table tblMemo(
    
    seq number(3) constraint tblmemo_seq_pk primary key, 
    name varchar2(30) constraint tblmemo_name_ck check(length(name) between 9 and 30), 
    memo varchar2(1000) constraint tblmemo_memo_ck check(length(memo) > 30),
    regdate date
    
);

--ORA-02290: check constraint (HR.SYS_C007075) violated -- (HR.SYS_C007075)-제약사항의 이름
--ORA-02290: check constraint (HR.TBLMEMO_MEMO_CK) violated
--ORA-02290: check constraint (HR.TBLMEMO_NAME_CK) violated
--ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길', '테스트 메모입니다. 하하하하하테스트 메모입니다. 하하하하하테스트 메모입니다. 하하하하하테스트 메모입니다. 하하하하하테스트 메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동아무개하하하', '테스트 메모입니다. 하하하하하테스트 메모입니다. 하하하하하테스트 메모입니다. 하하하하하테스트 메모입니다. 하하하하하테스트 메모입니다.', sysdate);

select * from tblMemo;



drop table tblMemo;

create table tblMemo(
    
    seq number(3), 
    name varchar2(30), 
    memo varchar2(1000),
    regdate date,
    
    --제약 사항 추가 -> 가독성 차이
    constraint tblmemo_seq_pk primary key(seq),
    constraint tblmemo_name_ck check(length(name) between 9 and 30),
    constraint tblmemo_memo_ck check(length(memo) > 30)
    
);
