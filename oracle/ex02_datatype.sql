-- ex02_datatype.sql

/*

ANSI-SQL 자료형
- 오라클 자료형
- 데이터베이스 > 데이터 > 자료형

1. 숫자형
    -  정수 + 실수
    a. number
        - (유효자리)38자리 이하의 숫자를 표현하는 자료형
        - 5~22byte 
        - 1x10-130 ~ 9.99999x10 + 125
        - number(precision, scale)
            1. precision: 소수 이하를 포함한 전체 자릿수(1~38)
            2. scale : 소수 이하의 자릿수(0~127)
            ex) number -> 38자리까지 표현 가능한 모든 숫자(정수, 실수 포함)
            ex) number(3) -> 3자리까지 표현 가능한 숫자(정수) -> -999 ~ + 999
            ex) number(4,2) -> 4자리까지 표현 가능 숫자(실수) -> -99.99 ~ + 99.99
            ex) number(10,3) -> -9999999.999 ~ + 9999999.999
        - 숫자형 상수(리터럴)
            1. 정수: 123
            2. 실수: 3.14
            
        - byte, int, float -> 오라클? -> 사용 X

*/

-- 테이블 삭제하기
drop table tblType;

-- 테이블 생성하기
create table tblType(
    -- 컬럼 구성
    -- 컬럼명 자료형
    
    --num number
    --num number(3)
    num number(4,2)
);

-- 테이블의 모든 내용을 가져오시오.
select * from tblType;

--데이터 추가하기
insert into tblType (num) values (100);
insert into tblType (num) values (200);
insert into tblType (num) values (300);
insert into tblType (num) values (99.99);
insert into tblType (num) values (3.14);
insert into tblType (num) values (99.99999999999);
insert into tblType (num) values (9999);  -- ORA-01438: value larger than specified precision allowed for this column
insert into tblType (num) values (12345.6789);
insert into tblType (num) values (12345678901234567890123456789012345678); --38자리
insert into tblType (num) values (-12345678901234567890123456789012345678); 
insert into tblType (num) values (1234567890123456789012345678901234567890123456789);



/*

2. 문자형
    - 문자 + 문자열
    - 자바의 String과 유사
    - n(X) vs n(O)
    - var(X) vs var(O) -> 공간의 크기가 변한다.
    
    a. char(****)
        - 고정 자릿수 문자열  -> 공간보다 데이터가 짧아도 나머지 공간은 그대로 차지한다.(공백으로)
        - char(n) : n자리 문자열, n(바이트)
            -최소 크기: 1바이트
            - 최대 크기: 2000바이트
            ex) char -> X
            ex) char(3) -> 최대 3바이트까지 문자열을 저장 -> 인코딩? -> 영어(3글자), 한글(1글자)
            ex) char(10) -> 최대 10바이트까지 문자열을 저장 -> 영어(10글자), 한글(3글자)
            ex) char(200) -> 영어(2000글자), 한글(666글자)
    
    
    b. nchar
        - n : national > 유니코드 지원 > UTF-16 동작(모든 문자 -> 2바이트)
        - nchar(n) : n자리 문자열, n(문자 수)
            - 최소 크기: 1글자(2바이트)
            - 최대 크기 : 1000글자(2000바이트)
        - 영어가 아닌 문자를 저장할 때 용이
    
    c. varchar2(**********)
        - 가변 자릿수 문자열 -> 데이터 크기만큼 공간의 크기가 줄어든다. 
        - varchar2(n) : n자리 문자열, n(바이트)
            - 최소 크기 : 1바이트
            - 최대 크기 : 4000바이트
            
    d. nvarchar2

    lob(Large Object)
    
    e. clob, nclob
        - 대용량 텍스트 저장 자료형
        - 128TB
        - 잘 사용 안함. 참조형

3. 날짜/시간형
    - 자바 Calendar, Date
    a. date (****)
        -년월일시분초
        - 7byte
        - 기원전 4712년 1월 1일 ~ 9999년 12월 31일
    
    b. timestamp
        -년월일시분초 + 밀리초(나노초)
    
    c. interval
        - 틱값
        - 시간
        - number 대신
        
4. 이진 데이터 자료형
    - 비 텍스트 데이터 
    - 이미지, 영상, 음악 등..
    a. blob
        - 128TB
        
    게시판 -> 첨부 파일 -> 첨부 파일명(+경로) -> 문자열 -> varchar2

true, false -> X -> 제어문X

-- number + varchar2 + date 빈도 가장 높음

*/




drop table tblType;

create table tblType(
    --name char(3),
    --name char(10),
    --nick varchar2(10)
    
    name char(10),
    nick nchar(10)
);


select * from tblType;

insert into tblType (name) values ('abc');
insert into tblType (name) values ('abcd');  --value too large for column "HR"."TBLTYPE"."NAME" (actual: 4, maximum: 3)
insert into tblType (name) values ('김');
insert into tblType (name) values ('홍길동');  --(actual: 9, maximum: 3)
insert into tblType (name) values ('123');
insert into tblType (name) values ('&*(');  

insert into tblType (name, nick) values ('홍길동', '바보');
insert into tblType (name, nick) values ('가', '가');

--char -> 'abc       '
--varchar2 -> 'abc'
insert into tblType (name, nick) values ('abc', 'abc');

insert into tblType (name, nick) values ('홍길동', '홍길동');
insert into tblType (name, nick) values ('홍길동님', '홍길동님'); --value too large for column "HR"."TBLTYPE"."NAME" (actual: 12, maximum: 10)
insert into tblType (name, nick) values ('홍길동', '홍길동님');
insert into tblType (name, nick) values ('홍길동', '홍길동님안녕하세요.');
insert into tblType (name, nick) values ('홍길동', '홍길동님안녕하세요.!');

drop table tblType;

create table tblType(

    name varchar2(30),      -- 이름
    age number(3),             -- 나이
    birthday date                 -- 생일

);

insert into tblType(name, age, birthday) values ('홍길동', 20 , '1995-05-12');

select * from tblType;
