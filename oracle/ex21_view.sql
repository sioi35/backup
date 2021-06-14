--ex21_view.sql


/*
뷰,View
- DB Object 중 하나(테이블, 시퀀스, 제약사항, 뷰) -> 데이터베이스 영구 저장
- 가상 테이블, 뷰 테이블
- 일종의 테이블의 복사본
- 뷰는 테이블처럼 취급한다.
- 자주 사용하는 select의 결과를 저장하는 객체(******)
- 테이블을 직접 사용하는 것에 비해 간편함(구문 단축)
- 뷰는 읽기 전용이다.(***)

- 뷰는 select의 결과를 저장하는 객체(X) -> select문을 저장하는 객체(O)

create view 뷰이름
as
select문

뷰의 종류
1. 단순 뷰
- 하나의 기본 테이블을 사용해서 만든 뷰
- CRUD 가능O > R만 사용

2. 복합 뷰
- 두개 이상의 기본 테이블을 사용해서 만든 뷰(subquery, join, union...)
- R만 가능

*/

--ORA-00955: name is already used by an existing object
-- 기존의 객체가 이름을 사용하고 있다. - 동일한 이름의 Object를 만들 수 없음
create view vwInsa
as
select * from tblInsa;


select * from tblInsa;
select * from vwInsa;

select * from tblInsa where buseo = '기획부';
select * from vwInsa where buseo = '개발부';

drop view vwInsa;


-- 없으면 만들고, 있으면 수정
create or replace view vwInsa
as
select * from tblInsa;


----?

create or replace view vwInsaMaleSeoul
as
select * from tblInsa where substr(ssn, 8, 1) = '1' and city = '서울';


select * from vwInsaMaleSeoul;

--ORA-00942: table or view does not exist
select * from tblInsa;

select * from hr.tblInsa;
select * from hr.vwInsaMaleSeoul;

create or replace view vwVideo
as
select
    m.name as 회원명,
    v.name as 비디오제목,
    r.rentdate as 대여날짜,
    case
        when r.retdate is null then '반납안함'
        when r.retdate is not null then '반납완료'
    end as 반납상태
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblMember m
                        on m.seq = r.member;


select * from vwVideo;

insert into vwVideo (회원명, 비디오제목, 대여날짜, 반납상태) values ('홍길동', '해리포터', '2021-05-30', null);

--서울 직원 뷰
create or replace view vwSeoul
as
select * from tblInsa where city = '서울';

select * from vwSeoul;

commit;
rollback;

select * from tblInsa;

update tblInsa set city = '제주' where num = 1001;

delete from tblInsa where city = '서울';



----- 뷰 사용시 주의할 점
--: 뷰는 절대로 읽기 전용으로 사용한다.
--: 뷰로 insert, update, delete 작업은 금지한다. -> 테이블로 할것!!

commit;
rollback;


create or replace view vwMen
as
select * from tblMen;


-- 1. select
select * from vwMen;

-- 2. insert
insert into vwMen (name, age, height, weight, couple) values ('테스트', 20, 175, 65, null);

--3. update
update vwMen set age = 25 where name = '테스트';

--4. delete
delete from vwMen where name = '테스트';


-- 인라인 뷰, Inline View
create or replace view vwSeoul
as
select * from tblInsa where city = '서울';

select * from vwSeoul; --재사용 가능


--서브 쿼리 == 인라인 뷰
select * from (select * from tblInsa where city = '서울');  -- 1회성




-- 5. tblMen. tblWomen. 서로 짝이 있는 사람 중 남자와 여자의 정보를 모두 가져오시오.
--    [남자]        [남자키]   [남자몸무게]     [여자]    [여자키]   [여자몸무게]
--    홍길동         180       70            장도연     177        65
--    아무개         175       null          이세영     163        null--    ..

select 
    * 
from tblMen m
    inner join tblWomen w
        on m.couple = w.name;

-- 23. tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 가져오시오.
select 
    s.name,
    s.address,
    s.salary,
    p.project
from tblStaff s
    left outer join tblProject p
        on s.seq = p.staff_seq;

-- 24. tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름은?

select 
    m.name,
    v.name
from tblVideo v
    inner join tblRent r
        on v.seq = r.video
            inner join tblMember m
                on r. member = m.seq
                    where v.name = '뽀뽀할까요';

select * from tblVideo;
select * from tblRent;

-- 25. tblStaff, tblProejct. '노조협상'을 담당한 직원의 월급은 얼마인가?

--??
select 
    s.name,
    s.salary,
    p.project
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq
            where p.project = '노조협상';

select * from tblStaff;


-- 26. tblVideo, tblRent, tblMember. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름은?
select 
    m.name,
    v.name
from tblVideo v
    inner join tblRent r
        on v.seq = r.video
            inner join tblMember m
                on r. member = m.seq
                    where v.name = '털미네이터';


-- 27. tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 가져오시오.
select 
    s.name,
    s.salary,
    p.project
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq
            where s.address <> '서울시';

select * from tblStaff;

-- 28. tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량을 가져오시오.
--?X
select 
    * 
from tblCustomer;

select * from tblSales;

-- 29. tblVideo, tblRent, tblGenre. 모든 비디오 제목, 보유수량, 대여가격을 가져오시오.

select 
    v.name,
    v.qty,
    g.price    
from tblVideo v
    left outer join tblGenre g
         on v.genre = g.seq;        
         
select * from tblGenre;
select * from tblVideo;
select * from tblRent;

-- 30. tblVideo, tblRent, tblMember, tblGenre. 2007년 2월에 대여된 구매내역을 가져오시오. 회원명, 비디오명, 언제, 대여가격

select 
    m.name,
    v.name,
    r.rentdate,
    g.price
from tblVideo v
    inner join tblRent r
        on v.seq = r.video and to_char(rentdate, 'yyyy') = 2007 and to_char(rentdate, 'mm') = 2 
            inner join tblMember m
                on r. member = m.seq
                  inner join tblGenre g
                    on v.genre = g.seq;

         
select * from tblGenre;
select * from tblVideo;
select * from tblMember;
select * from tblRent;




-- 31. tblVideo, tblRent, tblMember. 현재 반납을 안한 회원명과 비디오명, 대여날짜를 가져오시오.
select 
    m.name,
    v.name,
    r.rentdate
from tblVideo v
    inner join tblRent r
        on v.seq = r.video
            inner join tblMember m
                on r. member = m.seq
                  where r.retdate is null;

