--ex01.sql

--단일 라인 주석

/*
    다중라인 주석
    ..
*/

/*
오라클, Oracle
- 회사명, 제품명
- 데이터베이스(Database) -> 데이터베이스 관리 시스템(Database Management System, DBMS) -> 관계형 데이터베이스 관리 시스템(Relational DBMS, RDBMS)
- 프로젝트하실 때 DBMS 뭐 쓰셨나요? -> Oracle 11g 사용
- DB 클라이언트는 ? -> SQL Developer 사용

다운로드
1. OracleXE112_Win64.zip
    - 데이터베이스 프로그램(DBMS)

 2. sqldeveloper-20.4.1.407.0006-x64.zip
    - 데이터베이스 클라이언트 프로그램  

데이터, Data
- 가공된 정보

데이터베이스, Database
- 데이터의 집합
- 데이터의 집합을 지원하는 프로그램

데이터베이스 관리 시스템, Database Management System
- 데이터베이스 + 추가 작업 -> 통합 시스템
- 오라클(Oracle)

관리 시스템의 필요성 -> 아래의 기능들을 지원

1. 데이터 무결성
    - 데이터에 오류가 있으면 안된다.
    - 제약 조건(Constraint)를 사용한다.
    
2. 데이터 독립성
    - 데이터베이스에 변화가 발생하더라도 관계된 응용 프로그램들은 영향을 받지 않는다.

3. 보안
    - 데이터베이스내의 데이터를 함부로 접근 방지
    - 소유주나 접근 권한이 있는 사용자만 접근 가능.. 통제가능

4. 데이터 중복 최소화
    - 동일한 데이터가 여러곳에 여러번 저장되는 것을 방지한다.

5. 데이터 안정성
    - 데이터 백업/복원 기능들 제공한다.


DBMS 종류
1. 계층형 DBMS
2. 망형 DBMS
3. 관계형 DBMS > 현재 > 데이터를 표형태로 저장/관리 
4. 객체지향형 DBMS
5. 객체관계형 DBMS


관계형 데이터베이스 관리 시스템 -> 제품 종류

1. Oracle
    - Oracle
    - 기업용
    
2. MS-SQL
    - Microsoft
    - 기업용
    
3.  MySQL
    - Oracle
    - 개인용 + 기업용
    
4. MariaDB
    - MySQL 기반
    - 무료
    - 개인용 + 기업용

5. PostgreSQL
    - 포스트그레스큐엘
    - 무료
    - 개인용 + 기업용

6. DB2
    - IBM
    - 메인프레임

7. Access
    - MS
    - 개인용 + 소규모
    
8. 티베로
    - 티맥스(TMax)
    
9. SQLite
    - 경량
    - 모바일 등..
    
Oracle(데이터베이스)
-> UI 가 없는 프로그램 -> 서비스


데이터베이스 클라이언트 프로그램
-> UI가 없는 오라클에 접속을 해서 -> 조작을 도와주는 툴

1. SQL Developer
    - 무료
    - Oracle

2. Toad
    - 유료
    - 점유율 최상
    
3.  SQLGate

4. DataGrip(JetBrain)
    - 30일 평가판
    - 대학교 이메일(무료)

5. Eclipse

6. SQL*Plus
    - 오라클을 설치하면 자동으로 같이 설치되는 클라이언트 툴
    - CLI(Command Line Interface)


오라클 버전
- Oracle 11g Express Edition

- Oracle 1.0 ~ 21c

오라클 에디션
- Express Edition
    - 무료. 상용 가능(개발용). 기능제한
    - 11g XE, 18c XE
- Enterprise Edition
    - 상용


오라클 설치
-> 오라클이 잘 동작하고 있는지???
-> 시작 or 종료??

1. cmd > services.msc

2. OralceXXX
    - OracleServiceXE(실행 중)
        - 데이터베이스 프로그램
    - OracleXETNSListener(실행 중)
        - 오라클과 클라이언트 프로그램을 연결시켜 주는 프로그램
        
 
 열려 있는 파일(현재 파일)
 -> 스크립트 파일(*.sql), 워크 시트 파일(*.sql)
 -> 오라클(데이터베이스서버)와 대화를 하기위한 작업 파일(자바 -> (소스파일(*.java))
-> 문장 단위 실행 

 스크립트 실행 방법
 1. 실행할 명령어(문장)을 선택한다.(블럭잡기)
    - 마우스
    - Shift + 방향키(Home, End)
2. 실행
    - Ctrl + Enter
    
계정
1. sys, system
    - 관리자 계정

2. 일반 사용자 계정
    - 권한이 일부 제한되어 있는 계정
    - 생성(나중에)
    - 학습용 계정 제공 > scott, hr(사용금지 -> 해제)


show user;

select * from tabs;


  
*/

--계정이 잠겨있다. -> 활성화
-- alter user 계정명 account unlock;
alter user hr account unlock; --User HR이(가) 변경되었습니다.

-- 비밀번호 변경
alter user hr identified by java1234;--User HR이(가) 변경되었습니다.

alter user hr account unlock identified by java1234;

--system vs hr -> ?154 vs 7
select * from tabs;

show user;

-- 데이터베이스 서버 설치(오라클 서버) -> 데이터베이스 클라이언트 툴(SQL Developer) -> hr 계정 활성화 -> DB 서버 접속

/*
DB 관련 직무

1. DBA 
    - 데이터베이스 관리자

2. DB 프로그래머
    - DB 작업 전문

3. 응용 프로그래머
    - DB 작업 일부 



localhost.hr
- 테이블
- 뷰
- 인덱스
- 패키지
- 프로시저
...

localhost.hr (human resources, hr)
- 테이블
    - countries
    - department
    - employees
    -...



관계형 데이터베이스
- 데이터를 표형태로 저장/관리한다.
- 데이터끼리의 관계를 관리한다.
- 표(테이블)의 집합

테이블
- 열(컬럼)의 집합 > 테이블의 구조 > 스키마(Scheme)

열, Column
- 컬럼, 필드(Field), 속성(Attribute), 특성(Property)
- 세부 정보


행, Row
- 행, 로우, 레코드(Record), 튜플(Tuple)
- 테이블에 실체화된 데이터 1건
- Object(객체)


클라이언트  <-> 오라클
- SQL 

SQL, Structured Query Language
- 구조화된 질의 언어
- 사용자(클라이언트 툴)가 관계형 데이터베이스와 대화할 때 사용하는 언어
- 자바에 비해 자연어에 가깝다.

1. DBMS 제작사와 독립적이다.
- SQL은 모든 DBMS에 공통이다.

2. 표준 SQL, (ANSI-SQL)
- 모든 DBMS는 표준 SQL를 지원하도록 설계되어 있다.
- SQL-86... SQL-92... SQL-2011

3. 대화식 언어다.
- 질문 > 답변 > 질문 > 답변 > ...


SQL(오라클 기준)
1. ANSI SQL
    - 표준 SQL

2. PL/SQL
    - 자체 SQL
    - 오라클에서만 동작되는 명령어


ANSI SQL 종류
- 명령어들을 성격에 따라 분류

1. DDL
    - Data Definition Language
    - 데이터 정의어
    - 구조를 만드는 언어
    - 테이블, 뷰, 사용자, 인덱스 등의 객체(DB Object)를 생성, 수정, 삭제하는 명령어
    a. create : 생성
    b. drop : 삭제
    c. alter : 수정
    - 데이터베이스 관리자
    - 데이터베이스 담당자
    - 프로그래머(일부)

2. DML
    - Data Manipulation Language
    - 데이터 조작어
    - 데이터베이스의 데이터를 추가, 수정, 삭제, 조회하는 명령어
    a. select: 읽기(****************)
    b. insert: 추가
    c. update: 수정
    d. delete: 삭제
    - 데이터베이스 관리자
    - 데이터베이스 담당자
    - 프로그래머(*******)

3. DCL
    - Data Control Language
    - 데이터 제어어
    - 계정, 보안, 트랜잭션 등을 제어
    a. commit
    b. rollback
    c. grant
    d. revoke
    - 데이터베이스 관리자
    - 데이터베이스 담당자
    - 프로그래머(일부)    

4. DQL
    - Data Query Language
    - 데이터 질의어
    - DML 중에 select만을 이렇게 따로 칭한다.

5. TCL
    - Transaction Control Language
    - DCL중에 commit, rollback만을 이렇게 따로 칭한다.
    

오라클 기본 인코딩
- ~ 8i : EUC-KR
- 9i ~ : UTF-8

*/

--현재 계정(HR)이 소유하고 있는 테이블 목록 보여주세요.

--SQL은 키워드의 대소문자를 구분하지 않는다.
select * from tabs; --수업

SELECT * FROM tabs; -- 더 많이 사용

-- Alt + 홑따옴표
SELECT * FROM tabs;

-- Ctrl + Space
SELECT
    *
FROM tabs;

