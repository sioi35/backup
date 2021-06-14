--ex24_hierarchical.sql

/*
Hierarchical Query, 계층형 쿼리
- 오라클 전용
- 레코드간의 관계가 서로 상하 수직 구조인 경우 적당한 구조의 결과셋을 만들어 주는 역할
- 한 테이블에 부모, 자식 레코드가 동시에 있는 경우 > 자기 참조 테이블
- 조직도, 답변형 게시판, BOM 

컴퓨터
    - 본체
        - 메인보드
        - 그래픽카드
        - 랜카드
        - CPU
        - 메모리
    - 모니터
        - 보호필름
    - 프린터
        - 잉크카트리지
        - A4용지

*/

create table tblComputer(
    seq number primary key,                             --식별자
    name varchar2(50) not null,                         --요소명
    qty number not null,                                --수량
    pseq number null references tblComputer(seq)        --부모부품(FK)
);

insert into tblComputer values(1, '컴퓨터', 1, null);  --루트(root)

insert into tblComputer values(2, '본체', 1, 1);
insert into tblComputer values(3, '모니터', 1, 1);
insert into tblComputer values(4, '프린터', 1, 1);

insert into tblComputer values(5, '메인보드', 1, 2);
insert into tblComputer values(6, '그래픽보드', 1, 2);
insert into tblComputer values(7, '랜카드', 1, 2);
insert into tblComputer values(8, 'CPU', 1, 2);
insert into tblComputer values(9, '메모리', 2, 2);

insert into tblComputer values(10, '보호필름', 1, 3);

insert into tblComputer values(11, '잉크카트리지', 1, 4);
insert into tblComputer values(12, 'A4용지', 100, 4);

select * from tblComputer;

-- 셀프조인 : 부품 + 부모부품
select 
    c1.name as 부품,
    c2.name as 부모부품
from tblComputer c1
    left outer join tblComputer c2
        on c1.pseq = c2.seq;

-- 계층형 쿼리
-- start with절 + connect by절
-- 계층형 쿼리에서만 사용 가능한 의사 컬럼을 제공
-- prior: 의사컬럼. 부모 레코드
-- level: 의사컬럼. N세대

select
    lpad(' ', (level - 1) * 5) || name,
    prior name,
    level
from tblComputer
    --start with seq = 1
    --start with seq = (select seq from tblComputer where name = '컴퓨터')
    start with pseq is null
        connect by prior seq = pseq;

select * from tblSelf;

select
    lpad(' ', (level - 1) * 2) || name as 직원,
    --prior name as 상사명,
    department
from tblSelf
    start with super is null
        connect by prior seq = super;


-- prior: 부모 레코드
-- connect_by_root: 최상위 레코드

select
    lpad(' ', (level - 1) * 5) || name,
    prior name,
    level,
    connect_by_root name as 루트부품명,
    connect_by_isleaf as 리프노드,
    sys_connect_by_path(name, '->')
from tblComputer
    start with pseq is null
        connect by prior seq = pseq
            --order by name asc;
            order siblings by name asc;  -- 형제끼리만 정렬
