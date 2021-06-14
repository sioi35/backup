-- ex07_order.sql

/*
[WITH <Sub Query>]
SELECT column_list  -- *
FROM table_name  -- *
[WHERE search_condition]  -- *
[GROUP BY group_by_expression]
[HAVING serach_condition]
[ORDER BY order_expression [ASC|DESC]];  -- *


정렬, sort
- order by절
- 레코드를 정렬
- 원본 테이블의 레코드 정렬(XXX) - 오라클 데이터베이스에 있는 테이블내의 레코드 순서는 우리가 손댈 수 없다.(절대)
- 원본 테이블 -> select -> 결과 테이블(결과셋)의 정렬(*****)
- 오름차순, 내림차순
- 특정 컬럼값을 기준으로 레코드를 정렬한다.(***)

SELECT 컬럼리스트
FROM 테이블명
WHERE 조건
ORDER BY 정렬기준;


정렬의 기준이 될 수 있는 자료형(컬럼의 자료형)
1. 숫자형
    - 10 -> 20 -> 30
    - 30 -> 20 -> 10
2. 문자형
    - '가' -> '나' -> '다'
    - '다' -> '나' -> '가'
3. 날짜시간형
    - '2019' -> '2020' -> '2021'
    - '2021' -> '2020' -> '2019'

**** select를 구성하는 모든 절들은 실행 순서가 있다. (불변) -> 무조건 암기(이해)
1. FROM절
2. WHERE절
3. SELECT절
4. ORDER BY절


*/

select
    last || first as name,
    weight
from tblComedian
order by weight desc; --acs(=ascending 오름차순 정렬), desc(=descending 내림차순)


-- order by 대상 컬럼이 결과셋에 포함되지 않아도 상관없다. -> 보편적으로는 포함시킨다.
select
    last || first as name
from tblComedian
order by weight desc;


select                      --3. 원하는 컬럼만 선별
    last || first as name,
    weight,
    gender
from tblComedian            --1. 테이블 지정(전체 데이터)
where gender = 'm'          --2. 원하는 레코드만 선별
order by weight desc;       --4. 결과셋의 정렬

-- 이름 오름차순 정렬
select 
    name, buseo, jikwi, city 
from tblInsa
    order by name asc;

-- 다중 정렬
select 
    name, buseo, jikwi, city 
from tblInsa
    --order by buseo asc; --1차 정렬(기준 1개)
    --order by buseo asc, jikwi asc; --2차 정렬(기준 2개)
    order by buseo asc, jikwi asc, city asc; -- 3차 정렬(기준 3개)
    --order by 2 asc, 3 asc, 4 asc;   -- 첨자로 컬럼을 지정 -> 사용금지 !!!

---------고정된 컬럼을 정렬 기준으로 사용


---------계산된 값을 정렬 기준으로 사용

select
    name, basicpay, sudang, basicpay + sudang 
from tblInsa
    order by basicpay + sudang desc;



select                          --3.
    name, sudang, jikwi,
    case
        when jikwi in ('부장', '과장') then sudang * 2
        when jikwi in ('사원', '대리') then sudang * 1.5
    end as sudang2 -- as 생략가능, 그래도 써주는게 좋음.
from tblInsa                    --1.
    --order by sudang2 desc;      --4.
    order by case
        when jikwi in ('부장', '과장') then sudang * 2
        when jikwi in ('사원', '대리') then sudang * 1.5
    end desc;
    
    
-- 팁(*****)
-- 직위 정렬(부장, 과장, 대리, 사원) -> 가나다(X)
select
    name, buseo, jikwi
from tblInsa
    order by jikwi desc;

    
select
    name, buseo, jikwi,
    case
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end as no
from tblInsa
    order by no asc;    
    
    
       
select
    name, buseo, jikwi
--    case
--        when jikwi = '부장' then 1
--        when jikwi = '과장' then 2
--       when jikwi = '대리' then 3
--        when jikwi = '사원' then 4
--    end as no
from tblInsa
    order by case
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end asc;   
