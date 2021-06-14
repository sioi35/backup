--ex26_account.sql

/*
계정
- DCL
- 계정 생성
- 리소스 접근 권한 제어

사용자 계정 생성하기
- 시스템 권한을 가지고 있는 계정만 할 수 있다.
    - 관리자만 가능(sys, system, 관리자 권한을 부여받은 계정 등)
    - 계정 생성 권한을 가지는 일반 계정

create user 계정명 identified by 암호;
alter user 계정명 identified by 암호;
alter user 계정명 account lock;
alter user 계정명 account unlock;
drop user 계정명; 

*/
show user;

-- ORA-01031: insufficient privileges
create user hong identified by java1234;  -- unlock


--계정 권한 조작
--1. grant 권한 to 계정
--2. revoke 권한 from 계정


-- 권한
--1. 권한
--2. 롤(Role) : 권한의 집합

--grant create session to hong; -- 단일 권한 부여

grant connect, resource to hong; -- 롤(수많은 권한 집합), 가장 흔한 롤 부여
grant create view to hong;

show user;

select * from tabs;
