--ex03_select.sql 

/*

select 문
- DML, DQL
- 데이터베이스로부터 원하는 데이터를 가져오는 명령어(읽기)

select 구문

[WITH <Sub Query>]
SELECT column_list
FROM table_name
[WHERE search_condition]
[GROUP BY group_by_expression]
[HAVING serach_condition]
[ORDER BY order_expression [ASC|DESC]];

**** select를 구성하는 모든 절들은 실행 순서가 있다. (불변) -> 무조건 암기(이해)
1. FROM절
2. SELECT절

SELECT 컬럼리스트     -- 2. 데이터를 가져올 컬럼을 지정한다.(지정된 컬럼만 가져온다.)
FROM 테이블명;        -- 1. 데이터를 가져올 테이블을 지정한다. (데이터 소스 지정)

*/

-- hr -> 샘플(테이블 + 데이터) 제공
-- 현재 계정이 소유하고 있는 테이블 목록 가져오기
select * from tabs;

-- select 문 작성 -> 실행 -> 서버 전달 -> 처리 -> 결과값 반환 -> 클라이언트 반환 -> 결과값 -> ResultSet

-- full select
select *    -- 2. 어떤 컬럼을 가져올거냐? -> * (wildcard) 모든 컬럼
from employees; --1.  employees 테이블로부터 데이터를 가져오겠다.

select  first_name
from employees;

select first_name, last_name, salary,  department_id, email
from employees;

-- ORA-00942: table or view does not exist -- 테이블이 존재하지 않음
select * 
from employee;

--ORA-00904: "FIRSTNAME": invalid identifier    -- 유효하지 않는 식별자
select firstname
from employees;

select * 
from tblCountry;

--우리는 tblCountry을 처음 봤음 -> tblCountry 구조?? -> 구조 확인 !!! -> 구조(컬럼 구성)
desc tblCountry; --표준 SQL(X), SQL(X), Sql * plus(전용 명령어), SQL Developer(Sqlplus 명령어 지원)

-- 동일한 컬럼을 여러번 반복해도 된다. 
select name, name, name, name, name
from tblCountry;

-- 동일한 컬럼을 가져오는 경우.. > 가공을 한다.
select name, '나라명: ' || name    -- || (문자열 더하기 연산자 -> concat 연산자)
from tblCountry;

select * 
from tblCountry;    -- A.

select name, capital, population, continent, area
from tblCountry;    -- B.

-- A와 B의 결과는 동일 > B 권장 > 가독성 차이

desc tblCountry;

-- 원본 테이블의 컬럼 순서와 select절의 컬럼 순서는 전혀 무관하다. -> 보통 지키는 경우가 많다. -> 가독성
select capital, population, continent, area, name
from tblCountry; 
