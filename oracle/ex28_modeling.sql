--ex28_modeling.sql

/*

ANSI-SQL > Modeling > PL/SQL

데이터베이스 구축
- 프로젝트 진행 > 다량의 데이터 발생 > 저장하기 위한 조직화된 구조 필요 > 설계 > 구축
1. 데이터베이스 모델링
2. 데이터베이스 설계
3. 데이터베이스 구축

1. 데이터베이스 모델링
- 가장 초반에 하는 작업
- 가장 중요한 작업
- 설계도 작업(***)
- 요구 분석 > 정보(Raw) 수집 > 분석 > 저장 구조 > 도식화(설계화) > ERD(최종 산출물)
- 데이터베이스 모델링의 결과물 > ERD
- 아직 이 단계에서는 DBMS의 종류는 결정되지 않는다.
- 샘플: ERD

2. 데이터베이스 설계
- 1번의 결과물(ERD) -> 구체화하는 작업
- 실제 사용할 DBMS를 결정한다. -> 오라클
- 식별자 생성, 자료형 선택, 제약 사항 추가 등..
- 데이터베이스 설계의 산출물 > 스크립트(*sql) + DDL(create, alter, drop..)
- 샘플: DDL

3. 데이터베이스 구축
- 1,2번 결과 토대 > 실체화 > 물리적으로 만드는 작업
- SQL 사용

4. 데이터 추가
- 90%: 더미 데이터(유효한 데이터 + 유효하지 않은 데이터)
- 10%: 정확한 테스트용 데이터 > 업무 확인
- 1, 2, 3번 검증 동반 > 데이터 추가할 때 구조가 올바르지 않으면 문제 발생
- 샘플: 더미데이터

5. 업무 SQL 작성
- 요구 분석 > 업무 > 실제 SQL
- 산출물 > 스크립트(*.sql)
- 샘플: DML


데이터베이스 모델링 용어(개념)

1. ERD, Entity Relationship Diagram
- 엔티티간의 관계를 표현한 그림
- 데이터베이스 모델링 기법 중에 하나 > 대표적인 방법

2. Entity, 엔티티
- 다른 Entity와 분류(구분)될 수 있고, 다른 Entity에 대해서 정해진 관계를 맺을 수 있는 데이터 단위
- 객체(실체화 데이터의 집합 - 속성의 집합)
- 테이블(실체화된 데이터를 담는 역할 컨테이너) - 레코드(실체화된 데이터) - 속성(컬럼값, 필드, 셀)의 집합

ex) 회사 정보 관리 프로젝트
    a. 사원 정보 관리 기능
        - 정보: 나이, 사원명, 연락처, 주소, 사원번호 등..
        - 속성(나이, 사원명, 연락처, 주소, 사원번호) -> 사원(엔티티)
    b. 부서 정보 관리 기능
        - 정보: 부서명, 부서번호, 사무실번호, 내선번호 등..
        - 속성(부서명, 부서번호, 사무실번호, 내선번호) -> 부서(엔티티)

3. Entity Relationship, 엔티티 관계
- 엔티티간의 관계
- 사원 <-> 부서 
- 테이블과 테이블의 관계

4. Attribute, 속성
- 엔티티가 가지는 세부 정보
- 엔티티가 되기 위해 모인 하나, 하나의 정보
- 컬럼


5. Tuple, 튜플
- 엔티티에 정의된 규칙에 따라 실제 만들어진 데이터
- 레코드


-------------------------------------------------

ERD에서 Entity, Attribute, Relationship등을 표현하는 방법(그림 그리는 방법)

1.Entity
- 사각형으로 표시
- 이름을 작성(한글, 영어 대문자 권장)
- 엔티티명은 유일
- 단수로 표기

2.Attribute
- 엔티티 안에 표기(목록 형태)
- 표기법 자유 > 모두 소문자 표기
- 단수로 표기
- 추가로 표기사항(*** 속성에 대한 특징을 기술)
    a. NN, Not Null
        - 필수값
        - 해당 속성을 비워둘 수 없다.
    b. ND, Not Duplicate
        - 유일값(Unique)
        - 해당 속성은 중복될 수 없다.
    
    1. 중복되면 안되고, 생략되면 안된다.(NN,ND)
        - #*속성명
    2. 생략되면 안된다.(NN)
        - *속성명
    3. 중복되면 안된다.(ND)
        -#속성명
    4. 중복되도 되고, 생략되도 된다.
        - 속성명
        - o속성명, optional

3.Relationshiop
- 가장 중요한 작업
- 엔티티와 엔티티의 관계
- 관계의 패턴(종류)
    A 엔티티 : B 엔티티
    a. 1:1
        - 1개의 A는 1개의 B와 관계
    b. 1:0
        - 1개의 A는 0개의 B와 관계 > 무관계
    c. 1:N
        - 1개의 A는 1개 이상의 B와 관계
    d. 1:N
        - 1개의 A는 0개 이상의 B와 관계


키, Key
- 속성, 컬럼

1. 기본키, Primary Key
- 레코드를 다른 레코드와 구분하는 역할
- 식별자(***)
- NN + ND
- 테이블에는 반드시 기본키가 존재해야 한다.

2. 후보키, Candidate Key
- 레코드를 다른 레코드와 구분하는 역할
- 후보키들 중 대표로 선발된 키 > 기본키
ex) 회원 엔티티 > 회원번호(후보키->기본키), 아이디(후보키), 비밀번호, 주소..

3. 대체키, Alternate Key
- 후보키들 중 기본키를 제외한 나머지 키

4. 슈퍼키, Super Key
- 복합키, Composite Key
- 1개의 키만으로 식별자 역할이 불가능한 키들 > 2개 이상을 조합해 기본키 역할 부여

5. 외래키, Foreign Key
- 부모 테이블의 기본키를 참조하는 키
- 테이블간의 관계를 만드는 역할(***)

6. 일반키
- 1~5 중 아무것도 해당되지 않는 키


ERD 종류
1. 논리 다이어그램, Logical Diagram
    - 업무를 설명하기 위한 ERD > 데이터의 성격 + 관계
    - 모든 식별자 > 한글 정의
    - 설계 단계 + 업무를 정의하는 용도

2. 물리 다이어그램, Physical Diagram
    - 실제 데이터베이스를 적용하고 관리하기 위한 ERD
    - 모든 식별자 > 오라클에 적용할 실제 식별자 > 영어 정의
    - 자료형 명시, 제약사항 명시
    - 구현 단계
    

정규화, Normalization

- 모델링 작업 > ERD > 정규화 > 안정성 높고, 작업하기 편한 ERD
- ERD 수정하는 작업(공식)
- 자료의 손실이나, 불필요한 정보를 없애고, 데이터의 일관성을 유지하고, 데이터 종속을 최소화하기 위한 자료구조를(ERD)를 수정하는 작업
- 우리가 만든 테이블(ERD) = 비정형, 비정규형 상태 -> 정규화 -> 정규화된 구조
- 제 1 정규화, 제 2 정규화, 제 3정규화 등
- 1 ~ 3 정규화 + 역정규화

관계형 데이터베이스 시스템이 지향하는 데이터베이스 상태
1. 되도록 셀이 null 상태를 가지지 않는다. null 상태의 셀이 많으면 좋지 않다.
2. 중복값을 저장하지 않는다. > 동일한 성격의 데이터를 1개 이상의 테이블에 저장하지 않는다.
    > 같은 데이터를 여기저기 동시에 저장하지 않는다. > 공간 낭비, 관리 불편
3. 하나의 셀 > 반드시 원자값 저장(단일값, 분리될 수 없는 값(Scaler))

정규화 목적
1. null 제거
2. 중복값 제거
3. 자료 삽입, 갱신, 삭제에 따른 이상 현상 제거 > 데이터 무결성 보장

1. 삽입 이상(Insertion Anormaly)
    - 특정 테이블에 데이터를 삽입할 때 원하지 않는 데이터까지 같이 넣어야 하는 상황
2. 갱신 이상(Update Anormaly)
    - 동일한 데이터가 2개 이상의 테이블에 존재 > 그 중 1개는 수정했지만, 다른 1개를 수정 못했을 대
        > 두 데이터간의 이상 오류가 발생 > 2개 데이터 중 어떤 데이터가 올바른 데이터인지 구분 못하는 상황 발생
3. 삭제 이상(Deletion Anormaly)
    - 특정 테이블에서 데이터를 삭제할 때 원하지 않는 데이터까지 같이 지워야 하는 상황

함수 종속(Functional Dependency) -- 면접질문대비*
- 하나의 테이블내의 컬럼끼리의 관계 표현
- 정규화는 '부분 함수 종속'이나 '이행 함수 종속'을 모두 없애고, 모든 컬럼의 관계를
    '완전 함수 종속'으로 만드는 작업이다.

1. 완전 함수 종속, Full Functional Dependency
2. 부분 함수 종속, Partial Functional Dependency
3. 이행 함수 종속, Transitive Functional Dependency

정규화
- 1NF~ 3NF(Normal Form)
- 비정규형 -> (정규화) -> 정규형
- 1개 테이블 -> (정규화) -> 2개 이상의 테이블

제 1 정규화, 1NF
- 모든 컬럼(속성)은 원자값을 가진다.
- 여러개로 분리 가능한 값을 1개의 컬럼안에 넣지 말것

제 2 정규화, 2NF
- 기본 키가 아닌 모든 컬럼은 기본키에 완전 함수 종속이어야 한다.
- 부분 함수 종속 컬럼 발견!! > 부분 함수 종속 제거
- 일부 컬럼이 복합키 모두에게 종속이 아니라, 복합키 일부에만 종속되는 현상

제 3 정규화, 3NF
- 기본 키가 아닌 모든 컬럼은, 기본키가 아닌 다른 컬럼에 종속되면 안된다.
- 이행 함수 종속 컬럼 발견!! > 이행 함수 종속 제거

역정규화
- 정규화된 결과를 다시 원래대로 되돌리는 작업
- 2개 테이블 > 1개 테이블
- 수업 중 사용 금지

*/
