--ex16_update.sql

/*
update문
- DML(select, insert, update, delete)
- 원하는 행의 원하는 컬럼값을 수정하는 명령어
- update 테이블명 set 컬럼명 = 수정할값[, 컬럼명 = 수정할값] X N [where절]
- where절!!!!!!!!!!!!!!!(정확하게 쓸 것)
*/

--트랜잭션 처리
commit;
rollback;


select * from tblCountry;

-- 대한민국 -> 서울 => 세종시 이전
update tblCountry set 
    capital = '세종시'
        --where area = 10; 보장X
        where name = '대한민국'; --PK 컬럼을 조건으로 지정하면 유일한 행을 검색할 수 있다.(****)

--1년 후 > 인구 증가 > 10% 증가
update tblCountry set 
    population = population * 1.1;
    

-- 'AS'에 속한 나라만 인구수 증가
update tblCountry set 
    population = population * 1.1
        where continent = 'AS';
    
update tblCountry set
    capital = '제주시', 
    area = area + 10,
    population = population * 1.2
        where name = '대한민국';


-- 절대 하면 안되는 행동!!! -> PK는 절대로 수정하면 안된다 !!!!!
select * from tblInsa;

update tblInsa set
    num = 2000
        where num = 1001;
