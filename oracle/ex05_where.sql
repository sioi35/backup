-- ex05_where.sql

/*
select 문

[WITH <Sub Query>]
SELECT column_list
FROM table_name
[WHERE search_condition]
[GROUP BY group_by_expression]
[HAVING serach_condition]
[ORDER BY order_expression [ASC|DESC]];

SELECT 컬럼리스트
FROM 테이블명
WHERE 검색조건;

**** select를 구성하는 모든 절들은 실행 순서가 있다. (불변) -> 무조건 암기(이해)
1. FROM절
2. WHERE절
3. SELECT절

WHERE절
-가져올 레코드를 지정할 조건을 명시한다.
- 조건에 만족하는 행은 결과셋에 포함되고, 만족하지 못하는 행은 결과셋에 포함되지 않는다.
- 행단위로 걸러낸다.
- 주로 조건을 비교 연산자 or 논리 연산자를 사용해서 구성한다.


*/

-- 컬럼 선택 가능 + 레코드 선택 불가능 -> 항상 14개의 레코드 반환 
select *
from tblCountry
where capital = '서울' ;

select *
from tblCountry
where area > 20;

select * from tblInsa where city = '서울';    -- 20/60

select * from tblInsa where buseo = '영업부';  --16/60

select * from tblInsa where basicpay >= 2500000; --6/20

select name, buseo, jikwi, basicpay from tblInsa where basicpay >= 2500000; --원하는 행 + 열

select * from tblInsa
    where city = '서울';

select * from tblInsa
    where city <> '서울';
    
    
-- 논리 연산자
-- -and(&&), or(||), not(!) 
select * from tblInsa
    where city = '서울' and buseo = '영업부';

select * from tblInsa
    where city = '서울' or buseo = '영업부';

select * from tblInsa
    where city <> '서울' ;
    --where not (city = '서울'); -- 이런식 잘 사용 안함.

-- tblCoomedian
-- 몸무게가 60kg 이상이고, 키가 170cm 미만인 사람을 가져오시오.
select * from tblComedian where weight >=60 and height <170;

--tblInsa
-- 급여(basicpay)과 수당(sudang)을 모두 합한 금액이 200만원 이상인 직원을 가져오시오.
select * from tblInsa where (basicpay + sudang) > 2500000;

/*

between절
- where절에서 사용 > 조건으로 사용 
- 범위 조건으로 사용
- 컬럼명 between 최솟값 and  최댓값
- 연산자 사용보다 가독성 향상(성능 더 느림)
- 최소/최대값 -> 포함(inclusive)

*/
-- 몸무게 60kg ~ 70kg 사이에 있는 사람만
select last || first as name, weight from tblComedian;

select last || first as name, weight from tblComedian 
            where weight >= 60 and weight <=70;  -- 3명
            
select last || first as name, weight from tblComedian
            where weight between 64 and 66;  -- 3명

-- 비교 연산에 사용되는 자료형
-- 1. 숫자형(number)
desc tblInsa;

select name, sudang from tblInsa where sudang > 150000;
select name, sudang from tblInsa where sudang >= 150000 and sudang <= 160000;
select name, sudang from tblInsa where sudang between 150000 and 160000;

-- 2. 문자형
-- - 자바 : char(o), string(x)
-- -          c > 'a'     "홍길동" > "아무개"
select name from tblInsa where name > '박';
select first_name from employees where first_name > 'M';
select first_name from employees where first_name >= 'M' and first_name <= 'O'; 
select first_name from employees where first_name between 'M' and 'O'; 

-- 3. 날짜/시간형
-- - 자바 : Calendar > Calendar -> tick > tick
desc tblInsa;
select ibsadate from tblInsa where ibsadate > '2010-01-01';
select ibsadate from tblInsa where ibsadate <= '2010-01-01';
select ibsadate from tblInsa where ibsadate >= '2010-01-01' and ibsadate <= '2010-12-31';
select ibsadate from tblInsa where ibsadate between '2010-01-01' and '2010-12-31';


/*
 in
- where절에서 사용 -> 조건으로 사용
- 열거형 조건 -> 제시된 조건 중 하나라도 일치하면 만족
- 컬럼형 in (값, 값, 값, ... ) 

*/

--tblInsa. 홍보부 + 개발부 + 총무부
select * from tblInsa;
select * from tblInsa where buseo = '홍보부';
select * from tblInsa where buseo = '홍보부' or buseo = '개발부' or buseo = '총무부';  -- 27명
select * from tblInsa where buseo in ('홍보부', '개발부', '총무부');  -- 27명

-- tblInsa. (부장, 과장) + (서울, 인천) + 급여(250~260)
select * from tblInsa 
        where jikwi in ('부장', '과장') 
        and city in ('서울', '인천')
        and basicpay between 2500000 and 2600000;

/*
like
- where절에서 사용 -> 조건으로 사용
- 패턴 비교 (정규 표현식과 유사)
- 문자형을 대상으로 동작(숫자형, 날짜형은 적용 불가)
- 컬럼명 like '패턴 문자열'

패턴 문자열 구성 요소
1. _  : 임의의 문자 1개 -> " . "
2. % : 임의의 문자 N개(N: 0~무한대) -> " .* " , ". {0,}"


*/

select name from tblInsa;
select name from tblInsa where name like '홍__';  -- 홍00 
select name from tblInsa where name = '홍길동'; 
select name from tblInsa where name like '__신';  --00신
select name from tblInsa where name like '_길_';  --0길0
select name from tblInsa where name like '김___'; --김000
select name from tblInsa where name like '김_';   --김0 


select first_name from employees;
select first_name from employees where first_name like 'E____'; -- Ellen, Eleni 
select first_name from employees where first_name like 'E%'; -- E~
select first_name from employees where first_name like 'E%';
select first_name from employees where first_name like '%e';
select first_name from employees where first_name like '%e%'; -- 이름에 e가 들어간 사람
select first_name from employees where first_name like '%ea%'; -- 이름에 ea가 들어간 사람
select first_name from employees where first_name like '%e%a%'; -- Hermann

/*
RDBMS에서의 null
- 자바의  null 개념과 유사
- 컬럼값이 비어있는 상태(셀)
- null 상수
- 대다수의 언어는 null을 피연산자로 사용할 수 없다. 

null 조건
- where절 사용 -> 조건으로 사용
- 컬럼명 is null

*/

select * from tblCountry;

--인구수가 기재되지 않은 나라? 
select * from tblCountry where population = null;  -- X
select * from tblCountry where population is null;  -- O

-- 인구수가 기재된 나라?
select * from tblCountry where population <> null; -- X
select * from tblCountry where not population is null; -- O
select * from tblCountry where population is not null;  -- O --> 더 많이 사용

-- 할일
select * from tblTodo;

-- 아직 실행하지 못한 일은? 
select * from tblTodo where completedate is null;

-- 실행을 완료한 일은?
select * from tblTodo where completedate is not null;

-- 도서관 -> 도서 대여 테이블(대여 날짜, 반납 날짜)
-- 아직 반납이 안된 대여 기록?
select * from 도서대여 where 반납 날짜 is null; 

-- 반납이 완료된 대여 기록?
select * from 도서대여 where 반납 날짜 is not null; 

select * from tblMen where couple is null;
select * from tblMen where couple is not null;

select * from tblWomen where couple is null;
select * from tblWomen where couple is not null;
