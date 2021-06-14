--ex09_numeric_function.sql

/*

숫자 함수
- 자바 Math 클래스

round()
- 반올림 함수
- number round(컬럼명) : 정수 반환
- number round(컬럼명, 소수점자릿수) : 실수 반환
- 숫자형, 날짜형

*/

select height, weight, height / weight, round(height / weight)  from tblComedian;

select 10 / 3 from tblComedian;  -- 10
select 10 / 3 from tblInsa; -- 60


select 10 / 3 from tblInsa where name = '홍길동';

select * from dual; --시스템 테이블
select 10 / 3 from dual;

select round(987.654), round(987.654, 1), round(987.654, 2) from dual;

select round(avg(basicpay)) from tblInsa;

select round(name) from tblInsa; -- ORA-01722: invalid number
select round(ibsadate), ibsadate from tblInsa;

/*
floor(), trunc()
- 절삭 함수
- 무조건 내림 함수
- 자바의 정수 / 정수
- number floor(컬럼명)
- number trunc(컬럼명 [, 소슈이하자릿수])

*/

select 
    5.6789,
    round(5.6789),
    floor(5.6789),
    trunc(5.6789, 1)
from dual;


/*

ceil()
- 무조건 올림 함수
- number ceil(컬럼명)

*/
select
    3.1,
    round(3.1),
    ceil(3.1),
    ceil(3.00000000000000000000001),
    floor(3.9999999999999999999999)
from dual;


/*

mod()
- 나머지 함수
- number mod(피제수, 제수)


*/

select mod(10,3) from dual;

-- 100분 -> 1시간 40분
-- 100 / 60 -> 몫(시간)
-- 100 % 60 -> 나머지(분)

select
    floor(100 / 60) as 시,
    mod(100, 60) as 분
from dual;


select
    abs(-10), abs(10), 
    power(2, 8),
    sqrt(4)
from dual;
