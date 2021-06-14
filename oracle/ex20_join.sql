--ex20_join.sql


/*
모델링
 - 테이블의 관계
 - ERD
 - ..

직원 정보 테이블
- 직원번호, 직원명, 급여, 거주지, 담당 프로젝트
*/
drop table tblStaff;
create table tblStaff(

    seq number primary key,         --직원번호(PK)
    name varchar2(30) not null,     --직원명
    salary number not null,         --급여
    address varchar2(300) not null, --거주지
    project varchar2(300) null      --담당프로젝트

);

insert into tblStaff(seq, name, salary, address, project) values (1, '홍길동', 300, '서울시', '홍콩수출');
insert into tblStaff(seq, name, salary, address, project) values (2, '아무개', 250, '부산시', 'TV광고');
insert into tblStaff(seq, name, salary, address, project) values (3, '하하하', 280, '대전시', '매출분석');

insert into tblStaff(seq, name, salary, address) values (1, '홍길동', 300, '서울시');

--홍길동 + 프로젝트 1건 추가(고객관리)
insert into tblStaff(seq, name, salary, address, project) values (4, '홍길동', 300, '서울시', '고객관리');

--호호호 + 2개 프로젝트 담당
insert into tblStaff(seq, name, salary, address, project) values (5, '호호호', 270, '의정부시', '홍콩수출,고객관리');



--1명의 직원이 2개 이상의 프로젝트를 담당했을떄
-- Case A. 홍길동
--      - 프로젝트 1개당 레코드 1개
--      - 직원 정보가 계속 반복(***)
-- Case B. 호호호
--      - 프로젝트 전부를 1개의 컬럼에 누적
--      - 직원 정보가 유일(1개 레코드)

--홍길동 + 프로젝트 추가
insert into tblStaff(seq, name, salary, address, project) values (6, '홍길동', 300, '서울시', '반품처리');

--호호호 + 프로젝트 추가
update tblStaff set project = project || ', 반품처리' where seq = 5;


--홍길동 고객관리 -> 담당 해제
delete from tblStaff where seq = 4;

--호호호 고객관리 -> 담당 해제
update tblStaff set project = replace(project, '고객관리,', '') where seq = 5; 

select * from tblStaff;

drop table tblStaff;


create table tblStaff(

    seq number primary key,         --직원번호(PK)
    name varchar2(30) not null,     --직원명
    salary number not null,         --급여
    address varchar2(300) not null  --거주지

);

drop table tblProject;

create table tblProject(

    seq number primary key,                                 --프로젝트번호(PK)
    project varchar2(300) null,                             --담당프로젝트
    staff_seq number not null references tblStaff(seq)      --직원번호(FK, Foreign Key, 외래키, 참조키) 
        
);

-- tblStaff     - tblProject
-- PK(부모키)    - FK(자식키)
-- 부모         - 자식
-- 부모테이블   - 자식테이블


insert into tblStaff(seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff(seq, name, salary, address) values (2, '아무개', 250, '부산시');
insert into tblStaff(seq, name, salary, address) values (3, '하하하', 280, '대전시');


insert into tblProject(seq, project, staff_seq) values (1, '홍콩수출', 1);
insert into tblProject(seq, project, staff_seq) values (2, 'TV광고', 2);
insert into tblProject(seq, project, staff_seq) values (3, '매출분석', 3);

--홍길동 + 프로젝트 1개 추가
insert into tblProject(seq, project, staff_seq) values (4, '노조협상', 1);

--홍길동 + 프로젝트 1개 해제
delete from tblProject where seq = 1;


select * from tblStaff; --3
select * from tblProject; --3


-- 위의 2개의 테이블의 문제점!!
--A. 신입 사원 입사 > 신규 프로젝트 담당
--A.1 신입 사원 추가
insert into tblStaff(seq, name, salary, address) values (4, '호호호', 200, '서울시');

--A.2 신규 프로젝트 추가
insert into tblProject(seq, project, staff_seq) values (5, '자재매입', 4);

--A.3 신규 프로젝트 추가(X) 
--ORA-02291: integrity constraint (HR.SYS_C007141) violated - parent key not found
--무결성 제약조건이 위배- 부모 키가 없습니다.
insert into tblProject(seq, project, staff_seq) values (6, '고객유치', 5);


--B. '홍길동' 퇴사
--B.1 '홍길동' 삭제(X)
--ORA-02292: integrity constraint (HR.SYS_C007141) violated - child record found
--무결성 제약조건이 위배 - 자식 레코드가 발견됨
delete from tblStaff where seq = 1;

--B.2 '홍길동'의 모든 업무 > 위임(업무 인수인계)
update tblProject set staff_seq = 2 where staff_seq = 1;


--B.3 '홍길동' 퇴사(O)
delete from tblStaff where seq = 1;



/*
관계를 맺고 있는 2개의 테이블을 조작하면 발생하는 일
- 이 규칙이 깨지면 데이터 무결성(유효성)이 깨진다. > 데이터 가치 상실
- 반드시 지켜야 하는 상황

1. 부모 테이블 조작. tblStaff
    a. 행추가(insert) : 아무 영향 없음
    b. 행수정(update) : 아무 영향 없음
    c. 행삭제(delete) : 자식 테이블에 자신을 참조하는 행이 존재하는지 반드시 사전 체크 요망 !!! > FK 존재 유무 체크!!! > child record found

2. 자식 테이블 조작. tblProject
    a. 행추가(insert) : 자신이 참조하는 대상이 실제로 부모테이블에 존재하는 값인지 사전 체크 요망 !!! > parent record not found
    b. 행수정(update) : 수정할 컬럼이 FK컬럼> 부모 테이블에 존재하는 값인지 사전 체크 요망!!! > parent record not found
    c. 행삭제(delete) : 아무 영향 없음
*/


/*
관계를 맺고 있는 테이블 생성하기 
- 2개의 테이블 중 누가 부모 테이블이 되고, 누가 자식 테이블이 되야하는지??
- 2개의 테이블의 데이터 중 시간 흐름 순서상 누가 먼저 생겨나야하는지? 먼저 생성할 데이터(부모 테이블), 나중 생성할 데이터(자식 테이블) 
*/


-- 고객 <-> 판매

-- 1. 고객이 회원가입 > sseq를 비워둔채 가입
-- 2. 구매 > insert(tblSales) + update(tblCustomer)
-- 3. 구매 > insert(tblSales) + update(tblCustomer) -> "1,2"

-- 1. 고객이 회원가입
-- 2. 구매 > insert(tblSales)
-- 3. 구매 > insert(tblSales)

-- 고객 테이블
create table tblCustomer(
    seq number primary key,                         --고객번호(PK)
    name varchar2(30) not null,                     --고객명
    tel varchar2(15) not null,                      --연락처
    address varchar2(100) not null                  --주소
    --sseq number null reference tblSales(seq)      --참조키(판매번호)
);

drop table tblSales;
-- 판매내역 테이블
create table tblSales(
    seq number primary key,                         --판매번호(PK)
    item varchar2(50) not null,                     --제품명
    qty number not null,                            --수량
    regdate date default sysdate not null,          --판매날짜
    cseq number not null references tblCustomer(seq) --고객번호(FK)
);

select * from tblCustomer;
select * from tblSales;
-- 사원 테이블(자식)
-- 부서 테이블(부모)


-- 비디오 대여점
-- *** 관계를 맺구 있는 테이블들의 생성과 삭제
-- 1. 생성: 부모 테이블 생성 -> 자식 테이블 생성
-- 2. 삭제: 자식 테이블 삭제 -> 부모 테이블 삭제

-- ORA-02449: unique/primary keys in table referenced by foreign keys
-- 자식테이블에 의해 참조되므로 지울 수 없음.

-- 장르 테이블
create table tblGenre(
    seq number primary key,             --장르번호(PK)
    name varchar2(30) not null,         --장르명
    price number not null,              --대여가격
    period number not null              --대여기간(일) 
);

-- 비디오 테이블
--ORA-00942: table or view does not exist 존재하지 않는 테이블 or 뷰
create table tblVideo(
    seq number primary key,                         --비디오번호(PK)
    name varchar2(100) not null,                    --제목
    qty number not null,                            --보유 수량
    company varchar2(50) null,                      --제작사
    director varchar2(50) null,                     --감독
    major varchar2(50) null,                        --주연배우
    genre number not null references tblGenre(seq)  --장르(FK)
);
-- 고객 테이블
create table tblMember(
    seq number primary key,                         --회원번호(PK)
    name varchar2(30) not null,                     --회원명
    grade number(1) not null,                       --회원등급(1,2,3)
    byear number(4) not null,                       --생년
    tel varchar2(15) not null,                      --연락처
    address varchar2(300) not null,                 --주소
    money number not null                           --예치금
);

-- 대여 테이블
create table tblRent(
    seq number primary key,                             --대여번호(PK)
    member number not null references tblMember(seq),   --회원번호(FK)
    video number not null references tblVideo(seq),     --비디오번호(FK)
    rentdate date default sysdate not null,             --대여시각
    retdate date null,                                  --반납시각
    remark varchar2(500) null                           --비고
);


drop table tblGenre;
drop table tblVideo;
drop table tblRent;
drop table tblMember;

-- 시퀀스
create sequence genreSeq;
create sequence videoSeq;
create sequence memberSeq;
create sequence rentSeq;

create sequence genreSeq;
create sequence videoSeq;
create sequence memberSeq;
create sequence rentSeq;

select * from tblGenre; --6개
select * from tblVideo; --11개
select * from tblMember; --8개
select * from tblRent; --6개


/*
조인, Join
- (서로 관계를 맺고 있는) 2개(1개) 이상의 테이블의 내용을 동시에 가져와서 1개의 결과셋을 만드는 작업
- 조인에서 컬럼은 반드시 테이블명(소유주)을 적는게 좋다.(충돌 발생)


조인의 종류(ANSI_SQL)
1. 단순 조인, cross join
    - 사용을 거의 안함 > 결과셋에 유효한 레코드와 유효하지 않은 레코드가 뒤섞여 있기 때문에
    - 가끔씩 개발자가 테스트 용도의 큰 데이터가 필요한 경우에 사용(더미 데이터 - 유효성과 무관한)
    - select * from tableA cross join tableB;
    - select * from tableA, tableB;
    
2. 내부 조인, inner join (*****)
    - 단순 조인의 결과셋에서 유효한 레코드만 추출한 조인
    - 두 테이블의 교집합같은 성질
    - select * from tableA inner join tableB on tabkeA.PK = tableB.FK;
    
3. 외부 조인, outer join (*****)
    - 내부 조인 + 부모 테이블
    - 내부 조인 + 차집합(부모 테이블)
    - 내부 조인의 결과셋에 참조되지 않은 부모 레코드를 더한 결과셋
    - 일반적으로 부모 테이블을 가르킨다.(left or right)
    - select + from tableA left outer join tableB on tableA.PK = tableB.FK;
    
4. 셀프 조인, self join
    - 1개의 테이블을 사용해서 조인 
    - 셀프 조인 + 단순 조인
    - 셀프 조인 + 내부 조인
    - 셀프 조인 + 외부 조인
    
5. 전체 외부 조인, full outer join
    - left outer join + right outer join
*/

-- 1. 단순 조인, cross join
select * from tblCustomer; --3건
select * from tblSales; --9건

select * from tblCustomer cross join tblSales;  --27건 --ANSI-SQL
select * from tblCustomer, tblSales; -- Oracle

select * from tblAddressBook cross join tblComedian cross join tblCountry;

-- 2. 내부 조인, inner join (*****)

--고객정보와 판매내역을 동시에 가져오기
select * from tblCustomer
    inner join tblSales 
        on tblCustomer.seq = tblSales.cseq; --9건 -- 어떤 레코드만 남길지에 대한 조건(부모테이블.PK = 자식테이블.FK)

-- ORA-00918: column ambiguously defined 
-- 열의 정의가 애매합니다.
-- 조인을 할 때 자주 발생하는 현상

select tblCustomer.seq, tblSales.seq from tblCustomer
    cross join tblSales
        where tblCustomer.seq = tblSales.cseq;  --사용안함


select
    tblCustomer.name,
    tblCustomer.address,
    tblSales.item,
    tblSales.qty
from tblCustomer
    inner join tblSales 
        on tblCustomer.seq = tblSales.cseq;


select 
    *
from tblCustomer c
    inner join tblSales s
        --ORA-00904: "TBLCUSTOMER"."SEQ": invalid identifier --부적절한 식별자
        on tblCustomer.seq = tblSales.cseq;



select 
    c.name,
    c.address,
    s.item,
    s.qty
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;


select * from tblCustomer; --고객명, 연락처
select * from tblSales; --제품명, 수량

-- Sub Query vs Join

--Join
select 
    c.name,
    c.tel,
    s.item,
    s.qty
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;
        
        
-- sub query(상관 서브 쿼리)    
select 
    item,
    qty,
    cseq,
    (select name from tblCustomer where seq = tblSales.cseq) as name, 
    (select tel from tblCustomer where seq = tblSales.cseq) as tel 
from tblSales;


select * from tblStaff;
select * from tblProject;

select 
    s.name as 직원명,
    s.salary as 급여,
    p.project as 프로젝트명
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq;

select * from tblMen;
select * from tblWomen;

select m.name as 남자, f.name as 여자 
    from tblMen m 
        inner join tblWomen f
            on m.couple = f.name;


select * from tblAddressBook;
select * from tblComedian;

select * from tblAddressBook a
    inner join tblComedian c
        on a.height = c.height;

select * from departments;

select
    first_name,
    department_id,
    (select department_name from departments where department_id = employees.department_id) as department_name
from employees;

select
    e.first_name || ' ' || e.last_name as name,
    d.department_name,
    l.city || ' ' || l.street_address as city_address
from employees e
    inner join departments d
        on d.department_id = e.department_id
            inner join locations l
                on l.location_id = d.location_id;


select * from departments;
select * from locations;


select * from tblGenre;
select * from tblVideo;
select * from tblRent;
select * from tblMember;

-- tblGenre + tblVideo
select 
    *
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre;


-- tblGenre + tblVideo + tblRent
select 
    *
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video ;
            

-- tblGenre + tblVideo + tblRent + tblMember
select 
    g.price as 대여가격,
    g.period as 대여기간,
    v.name as 비디오제목,
    m.name as 회원명,
    r.rentdate as 대여날짜,
    r.rentdate + g.period as 반납마감날짜
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video 
                    inner join tblMember m
                        on m.seq = r.member;
                
                
insert into tblStaff(seq, name, salary, address) values (5, '후후후', 250, '서울시');

select * from tblStaff;    --5명, 부모 테이블
select * from tblProject;  --4명, 자식 테이블

-- 내부 조인(inner join)
-- : 2개 테이블에 on 조건을 만족하는 레코드만 반환
-- : 내부 조인의 결과는 대부분 자식 레코드 수만큼 나온다.

select
    *
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq;  --4개



-- 비디오 가게 사장
-- : 출근 > 어떤 회원? 뭘 대여? 반납O,X

select
    m.name as 이름,
    v.name as 타이틀,
    r.retdate as 반납여부
from tblMember m
    inner join tblRent r
        on m.seq = r.member
            inner join tblVideo v
                on v.seq = r.video;

select * from tblMember;
select * from tblVideo;
select * from tblRent;

select * from tblCustomer; --3건
select * from tblSales; --9건

--신규 가입 회원은 아직 구매 이력이 없다(*****)
insert into tblCustomer values (4, '호호호', '010-8745-9652', '서울시');

-- 구매 이력과 구매 이력이 있는 회원 정보를 가져오세요.
select * from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;



-- 3. 외부 조인, outer join (*****)

-- 구매 이력과 상관없이 모든 회원 정보를 가져오되, 구매 이력이 있으면 구매 이력도 같이 가져오시오.
select * from tblCustomer c 
    left outer join tblSales s
        on c.seq = s.cseq;


--대여 유무 이력과 상관없이 모든 회원 정보 + 대여기록
select
    distinct
    m.name as 이름,
    case
        when r.rentdate is not null then '우량 회원'
        when r.rentdate is null then '불량 회원'
    end as 종류
from tblMember m
    left outer join tblRent r
        on m.seq = r.member
            order by 종류 desc, name asc;


-- 어떤 비디오를 몇번 빌려갔는지?
select
    v.name,
    count(r.rentdate) as 대여횟수
from tblVideo v
    left outer join tblRent r
        on v.seq = r.video
            group by v.name
                order by count(r.rentdate) desc, v.name asc;



-- 5. 전체 외부 조인, full outer join
select * from tblMen;
select * from tblWomen;

-- 커플인 남자와 여자를 가져오시오.
select 
    m.name as 남자, w.name as 여자
from tblMen m
    inner join tblWomen w
        on m.couple = w.name;

-- 모든 남자 + 여자친구가 잇으면 여자친구 이름도 같이
select 
    m.name as 남자, w.name as 여자
from tblMen m
    left outer join tblWomen w
        on m.couple = w.name;
        

-- 모든 남자 + 모든 여자 + 커플이 있으면 커플이름도 같이
select
    m.name as 남자, w.name as 여자
from tblMen m
    full outer join tblWomen w
        on m.couple = w.name
            order by m.name asc, w.name asc;


-- 4. 셀프 조인, self join

--직원 테이블
create table tblSelf(
    seq number primary key,                         --직원번호(PK)
    name varchar2(30) not null,                     --직원명
    department varchar2(50) null,                   --부서명
    super number null references tblSelf(seq)       --상사번호(FK). 자기참조   
);


insert into tblSelf values(1, '홍사장', null, null);

insert into tblSelf values(2, '김부장', '영업부', 1);
insert into tblSelf values(3, '이과장', '영업부', 2);
insert into tblSelf values(4, '정대리', '영업부', 3);
insert into tblSelf values(5, '최사원', '영업부', 4);

insert into tblSelf values(6, '박부장', '개발부', 1);
insert into tblSelf values(7, '하과장', '개발부', 6);


select * from tblSelf;

--직원명, 소속부서, 상사명을 가져오시오.

select
    s1.name as직원명,
    s1.department as 소속부서,
    s2.name as 상사명
from tblSelf s1 --직원(부하)
    --inner join tblSelf s2  --상사
    left outer join tblSelf s2  --사장 포함(모든 직원)
        on s1.super = s2.seq; -- *********중요!

