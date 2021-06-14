--ex14_sequence.sql


/*
시퀀스, Sequence
- 데이터베이스 객체 중 하나
- 식별자를 만드는데 주로 사용 > PK 컬럼에서 잘 사용
- 일련번호를 만들어서 제공하는 객체(중복되지 않은 번호)
- 오라클 전용

시퀀스 객체 만들기
- create sequence 시퀀스명;

시퀀스 객체 삭제하기
- drop sequence 시퀀스명;

시퀀스 객체 사용하기
- 시퀀스명.nextVal 함수 (***)
- 시퀀스명.currVal 함수

*/

create sequence seqNum;

select seqNum.nextVal from dual; --계수기

select 'A' || seqNum.nextVal from dual; --상품번호, 주문번호
select 'A' || trim(to_char(seqNum.nextVal, '000')) from dual;  -- A001, A002, A003..

-- 
select seqNum.currVal from dual; -- 13(자바 Queue.peek())


drop sequence seqNum;

/*
시퀀스 상세 설정

- create sequence 시퀀스명;

- create sequence 시퀀스명
    increment by n  -- 증감치(양수, 음수)
    start with n    -- 시작값(seed)
    maxvalue n      -- 최대값(넘어가면 에러)
    minvalue n      -- 최소값(넘어가면 에러)
    cycle           --순환구조(PK로 써먹기 곤란함;)
    cache n;        

*/

drop sequence seqTest;

create sequence seqTest 
        increment by 1
        start with 1
        maxvalue 10
        cycle
        cache 5;

select seqTest.nextVal from dual;

create sequence seqA
    maxvalue 10
    cycle
    cache 5;
    
create sequence seqB
    maxvalue 5
    cycle
    cache 3;


select 'ABC' || trim(to_char(seqA.nextVal, '00')) || trim(to_char(seqB.nextVal, '00')) from dual;
--ABC0101
--ABC0202
--..
--ABC0505
--ABC0601
--ABC0702
--..
--ABC1005
--ABC0101


drop sequence seqNum;

create sequence seqNum;

select seqNum.nextVal from dual; -- 5 -> ?? -> 21

-- ORA-08002: sequence SEQNUM.CURRVAL is not yet defined in this session 
-- currVal 함수는 반드시 1번 이상의 nextVal가 호출해야만 동작이 된다.
select seqNum.currVal from dual;

select * from tblInsa;

/*

오라클 서버를 중지하는 방법
1. Win + R > services.msc > OracleServiceXE 중지
2. 메뉴 > Stop Database
3. cmd > net stop OracleServiceXE

오라클 서버를 시작하는 방법
1. Win + R > services.msc > OracleServiceXE 시작
2. 메뉴 > Start Database
3. cmd > net start OracleServiceXE

*/


-- 메모 번호: seqMemo.nextVal
-- 중복이 되면 안되는 번호(******)
-- 1, 2, 3, 4, 5... 21, 22, 23, 24...
-- 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23...

drop sequence seqNum;

create sequence seqNum start with 125;

select seqNum.nextVal from dual;
