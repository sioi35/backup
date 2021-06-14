--ex27_transaction.sql

/*

트랜잭션, Transaction
- 트랜잭션 개념
- 오라클에서 트랜잭션을 처리(조작)하는 방법
- 오라클에서 발생하는 1개 이상의 명령들을 하나의논리 집합으로 묶어 놓은 단위 > (실행된) 명령어들의 집합 > 통제 (제어)
- 트랜잭션에 포함되는 명령어 > insert, update, delete > 테이블 조작(변경)

트랜잭션 명령어
- DCL(TCL)
- 하나의 트랜잭션으로 묶여있는 DML들을 감시하다가, 일부 DML에서 문제가 발생하면 이전에 성공한 모든 DML을 어떻게 처리
1. commit
2. rollback
3. savepoint

새로운 트랜잭션이 시작하는 경우
1. 클라이언트가 접속한 직 후
2. commit 실행 직 후 
3. rollback 실행 직 후

현재 트랜잭션이 종료되는 경우
1. commit 실행 직 후
2. rollback 실행 직 후
3. 클라이언트가 접속을 종료하는 경우
4. DDL을 실행하는 경우(create, alter, drop) -> 자동으로 commit 호출이 된다. Auto Commit.
    - 구조를 바꾸는 작업이라 데이터를 완전 처리하는 작업을 내장

*/
drop table tblTrans;

create table tblTrans
as
select name, city, buseo, jikwi from tblInsa where buseo = '개발부';


-- 클라이언트 접속함(hr)
select * from tblTrans;

delete from tblTrans where name = '김신애';

select * from tblTrans;

rollback;

select * from tblTrans;

delete from tblTrans where name = '임수봉';

update tblTrans set city = '서울' where name = '이순애';

insert into tblTrans values ('하하하', '서울', '개발부', '사원');

select * from tblTrans;

rollback;

select * from tblTrans;

delete from tblTrans where name = '임수봉';

select * from tblTrans;

commit;

-- 오라클 재시작
--1. 실행 > services.msc
--2. 메뉴 > Start DB
--3. cmd > net start 서비스명, net start OracleServiceXE


-- 둘 다 한번 실행하면 취소 불가능
rollback; -- 현재 트랜잭션의 모든 작업을 없었던 일로..
commit; -- 현재 트랜잭션의 모든 작업을 실제 데이터베이스(오라클)에 적용해라..

delete from tblTrans;

select * from tblTrans;

-- 트랜잭션 선택
--1. 사용
--2. 미사용

select * from tblTrans;

delete from tbltrans;

select * from tblTrans;

rollback;


--commit 발생
create or replace view vwCountry
as 
select * from tblCountry;


--commit, rollback 어떻게 제어?
--1. 주기
-- -어느 정도 자주 호출해야 하는가?
-- - 논리적 작업 단위(스스로 선택)


--savepoint
commit;
rollback;

select * from tblTrans;

delete from tblTrans where name = '김신애';

select * from tblTrans;

savepoint a;

delete from tblTrans where name = '황진이';

select * from tblTrans;

savepoint b;

delete from tblTrans where name = '홍길남';


--현재
rollback;
rollback to b;
rollback to a;
commit;

select * from tblTrans;










