--ex08_aggregation_function.sql

/*

집계 함수, Aggregation Function
1. count()
2. sum()
3. avg()
4. max()
5. min()

1. count()
- 결과셋의 레코드 개수를 반환
- number count(컬럼명)
- null은 카운트에서 제외한다.(******)

*/

select name from tblCountry;
select count(name) from tblCountry; --14

select count(name)  --3. 33
from tblInsa    --1. 60
where city in ('서울', '경기'); --2. 33

select area from tblCountry;
select count(area) from tblCountry;

select population from tblCountry;          --14
select count(population) from tblCountry;   --13(null 제외)

-- ORA-00937: not a single-group group function
-- 컬럼 리스트에 집계 함수와 단일 컬럼을 동시에 사용할 수 없다.
select count(name), name from tblCountry; 

select count(name) from tblCountry;
select name from tblCountry;

select count(name), count(area) from tblCountry;

-- ORA-00909: invalid number of arguments
-- 매개변수에 컬럼은 하나밖에 못넣는다.
select count(name, area) from tblCountry;

-- 살짝 고민?
-- tblCountry의 나라 개수?
select * from tblCountry;
select count(name) from tblCountry;         --14
select count(capital) from tblCountry;      --14
select count(area) from tblCountry;         --14
select count(population) from tblCountry;   --13

select count(*) from tblCountry; --14 무조건 모든 레코드 갯수가 반환된다.
select * from tblCountry;


select * from tblTodo;

-- 아직 안한 일의 갯수?
select count(*) from tblTodo where completedate is null;

-- 한 일의 갯수?
select count(*) from tblTodo where completedate is not null;

-- 안한 일의 갯수, 한 일의 갯수 -> 하나의 결과셋으로
select
    count(*) as "전체 할 일 개수", 
    count(completedate) as "한 일의 개수",
    count(*) - count(completedate) as "아직 안한 일의 개수"
from tblTodo;


select 
    count(*) as "총직원수",  --60
    count(tel)as "연락처가 있는 직원수", --57
    count(*) - count(tel) as "연락처가 없는 직원수"  --3
from tblInsa;

--tblInsa -> buseo 컬럼 -> 어떤 부서들이 있나요?
select
    distinct buseo
from tblInsa;

--tblInsa -> buseo 컬럼 -> 부서가 몇개 있나요?
select
    count (distinct buseo)
from tblInsa;


-- tblComedian 남자 몇명? 여자 몇명?
select * from tblComedian;

select count(*) from tblComedian where gender = 'm';
select count(*) from tblComedian where gender = 'f';

-- 전체 인원수, 남자 인원 수, 여자 인원수 -> 결과 셋
-- count() + case end + null 존재

select 
    count(*) as "전체 인원수",
    count(case
        when gender = 'm' then 1
    end) as "남자",
    count(case
         when gender = 'f' then 1
    end) as "여자"
from tblComedian;


select avg(basicpay) from tblInsa; --1556526
select * from tblInsa where basicpay > 1556526; -- 27

-- 평균 급여보다 많이 받는 직원들 명단을 가져오시오.
--ORA-00934: group function is not allowed here ****
-- where절에는 집계 함수를 사용할 수 없다. > where절은 개인에 대한 조건절(집합 정보를 가져올 수 없다.)
select * from tblInsa where basicpay > avg(basicpay);


select * from tblCountry;

select count(*) from tblCountry where continent in('AS', 'EU');

select count(*) from tblCountry where population between 7000 and 20000;

select count(*) from employees where job_id = 'IT_PROG' and salary > 5000;

select * from tblInsa;

select 
    count(*)
from tblInsa 
    where not tel like '010%';
     
select count(*) from tblInsa where city not in('서울', '경기', '인천');

select count(*) from tblInsa where ssn like '8%-2%';

/*

2. sum()
- number sum(컬럼명)
- 해당 컬럼값들의 합을 구한다.
- 숫자형만 대상(문자형X, 날짜형X)


*/

select weight from tblComedian;
select sum(weight) from tblComedian;

select sum(first) from tblComedian; --ORA-01722: invalid number

select
    sum(basicpay), sum(sudang),
    sum(basicpay) + sum(sudang),
    sum(basicapy + sudang)
from tblInsa;

/*
3. avg()
- number avg(컬럼명)
- 해당 컬럼값들의 평균값을 반환한다.
- 숫자형만 가능하다.
- 해당 컬럼이 null을 가진 항목은 제외한다. 

*/

select
    sum(basicpay), count(*),
    sum(basicpay)/ count(*), --평균
    avg(basicpay)  --평균
from tblInsa;


--평균 인구수? --14475, 15588
select 
    sum(population) / count(*),
    sum(population) / count(population),
    avg(population),
    count(*),           --14
    count(population)   --13
from tblCountry;


-- 회사 성과급 지급
-- : 10명 팀원 -> 7명 참여 프로젝트 수익 발생, 3명 관련 없음
-- 1. 균등 지급 -> 수익 / 모든 팀원수 = sum() / count(*)
-- 2. 차등 지급 -> 수익 / 참여 팀원수 = sum() / count(참여팀원) = avg()


/*
4. max()
- object max(컬럼명) : 최대값 반환
- 숫자형, 문자형 , 날짜형

5. min()
- object min(컬럼명) : 최소값 반환
- 숫자형, 문자형 , 날짜형

*/
select max(basicpay), min(basicpay) from tblInsa;
select max(name), min(name) from tblInsa;
select max(ibsadate), min(ibsadate) from tblInsa;

--sum()
--Q001
select sum(population) from tblCountry where continent in ('EU', 'AF');

--Q002
select sum(salary) from employees where manager_id = 108;

--Q003
select * from employees;
select sum(salary) from hr.employees where job_id in('ST_CLERK', 'SH_CLERK');

--Q004
select * from tblInsa;

select sum(basicpay + sudang) from tblInsa where city = '서울';

--Q005
select sum(basicpay) from tblInsa where jikwi in ('부장', '과장');


--avg()

--Q001
select avg(population) from tblCountry where continent = 'AS';

--Q002
select avg(salary) from hr.employees
where first_name like '%AN%' or first_name like '%An%' or first_name like '%aN%' or first_name like '%an%';

--Q003
select * from tblInsa;

select avg(basicpay) from tblInsa where jikwi in ('부장', '과장');

--Q004
select avg(basicpay) from tblInsa where jikwi in ('대리', '사원');

--Q005 장급(부장,과장)의 평균 급여와 사원급(대리,사원)의 평균 급여의 차액?
select * from tblInsa;

select 
avg(case
    when jikwi in('부장', '과장') then basicpay
end) - 
avg(case
    when jikwi in('대리', '사원') then basicpay
end)
from tblInsa;


--max(), min()
--Q001
select max(area) from tblCountry;

--Q002
select min(basicpay + sudang) from tblInsa;

