--ex06_column.sql

/*

distinct 
- 컬럼 리스트에 사용
- 중복값을 제거한다.
- distinct 컬럼명

*/

select * from tblCountry;

--tblCountry에는 어떤 대륙이 있나요?  -> 분류 질문
select continent from tblCountry;
select distinct continent from tblCountry;


select * from tblInsa;
--tblInsa. 어떤 부서가 있나요?
select buseo from tblInsa;
select distinct buseo from tblInsa;  -- 7부서

select name from tblInsa; --60명

-- 중복값이 단 1개도 없어도 동작된다. > 중복값이 없는 컬럼에 distinct를 적용하는 건 의미가 없다.
select distinct name from tblInsa; 
 
select buseo name from tblInsa;  --60명
select distinct buseo name from tblInsa; --6명 

select buseo, jikwi from tblInsa; --60명
select distinct buseo, jikwi from tblInsa; --23명


-- 표
-- 1. 데이터 저장하는 표 > 오라클
-- 2. 화면에 데이터를 출력하는 표 > 보여주기 위한 표 > 셀병합 지원



/*
1. 자료형
    -number, varchar2, char, date
    
2. select
    a. from절
    b. select 컬럼 리스트 -> 별칭(Alias), 연산자(산술), distinct
    c. where절 -> 연산자(산술, 비교, 논리), between, in, like, is null
    
case
- 모든 곳에서 사용이 가능
    - 컬럼 리스트에서 사용
    - 조건절에서 사용
    - 정렬에서 사용
- 자바의 if/switch과 비슷한 행동
- 문장 단위의 제어(X) -> 값을 제어(O)
- 조건을 만족하지 못하는 컬럼은 null을 반환(***)



*/

Select
    Last || First As Name,
    Gender
From Tblcomedian;


SELECT
    LAST || FIRST AS NAME,
    CASE
        WHEN GENDER = 'm' THEN '남자'
        WHEN GENDER = 'f' THEN '여자'
    END AS GENDER
FROM TBLCOMEDIAN;


SELECT 
    name,
    case
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        --when continent = 'AU' then '오세아니아'
        --when continent = 'SA' then '남아메리카'
        --when continent = 'AU' then continent  -- 조건의 반환값이 반드시 상수일 필요가 없다.
        --else '기타'
        --else continent
        --else capital --의미는 다른 항목들과 동일
        --else population --에러 -- 자료형이 다른 항목들과 동일해야함
        else '기타'
        
    end as continent
FROM tblcountry;


select 
    last || first as name,
    weight,
    case
        when weight > 100 then '과체중'
        when weight > 50 then '정상체중'
        when weight > 0 then '저체중'        
    end as state,
    case
        when weight between 50 and 100 then '정상체중'
        else '비정상체중'
    end as state2
from tblcomedian;

select
    title,
    case
        when completedate is null then '완료'
        when completedate is not null then '미완료'
    end as state
from tblTodo;


select
    name, 
    jikwi,
    case
        when jikwi in ('과장', '부장') then '세단'
        when jikwi in ('대리', '사원') then '경차'
    end as car
from tblInsa;


select 
    name,
    buseo,
    jikwi,
    -- 3년 미만: 주니어
    -- 3~7년 미만: 시니어
    -- 7년 이상: 익스퍼트
    case
        when ibsadate > '2018-05-14' then '주니어' 
        when ibsadate <= '2018-05-14' and ibsadate > '2014-05-14' then '시니어'
        when ibsadate <= '2014-05-14' then '익스퍼트'
    end as state
from tblInsa;


select
    name,
    case
        when couple is null then '없음'
        when couple is not null then '있음'
    end as state
from tblMen;


-- tblInsa. sudang
-- 결과셋 : name, buseo, jikwi, sudang, 추가수당(계산)
-- 정책1. : 직위별 수당 + a > 부장(x2), 과장(x1.7), 대리(x1.5), 사원(x1.3)
-- 정책2. : 직위별 수당 + a > 부장,과장(x2), 대리,사원(x1.5)

select 
    *
from tblInsa;

--정책1.
select 
    name,
    buseo,
    jikwi,
    sudang,
    case
        when jikwi = '부장' then sudang * 2
        when jikwi = '과장' then sudang * 1.7
        when jikwi = '대리' then sudang * 1.5
        when jikwi = '사원' then sudang * 1.3
    end as incentive
from tblInsa;

--정책2.
select 
    name,
    buseo,
    jikwi,
    sudang,
    case
        when jikwi in ('부장', '과장') then sudang * 2
        else sudang * 1.5
    end as incentive
from tblInsa;
