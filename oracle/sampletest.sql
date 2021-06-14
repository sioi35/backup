--[관리자]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblManager (
     managerSeq number NOT NULL,        -- 관리자고유번호(PK)
     managerPW varchar2(15) NOT NULL    -- 관리자
 );

CREATE SEQUENCE managerSeq;

ALTER TABLE tblManager 
    ADD CONSTRAINT PK_TBLMANAGER PRIMARY KEY (managerSeq);

INSERT INTO tblManager (managerSeq, manager PW) values (managerSeq.nextVal, '1122334');
INSERT INTO tblManager (managerSeq, manager PW) values (managerSeq.nextVal, '2432511');
INSERT INTO tblManager (managerSeq, manager PW) values (managerSeq.nextVal, '1111111');
INSERT INTO tblManager (managerSeq, manager PW) values (managerSeq.nextVal, '2222222');
INSERT INTO tblManager (managerSeq, manager PW) values (managerSeq.nextVal, '3333333');

select * from tblManager;
    
--[교사]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblTeacher (
    teacherSeq number NOT NULL,             -- 교사고유번호(PK)
    name varchar2(15) NOT NULL,             -- 교사명
    ssn varchar2(15) NOT NULL,              -- 주민번호(뒷자리)
    phoneNumber varchar2(15) NOT NULL,      -- 전화번호
    condition varchar2(15) NOT NULL         -- 현직/대기여부
);

CREATE SEQUENCE teacherSeq;

ALTER TABLE tblTeacher
    ADD CONSTRAINT PK_TBLTEACHER PRIMARY KEY (teacherSeq);

ALTER TABLE tblTeacher 
    ADD CONSTRAINT CK_TBLTEACHER_SSN CHECK(length(ssn) = 7);

ALTER TABLE tblTeacher 
    ADD CONSTRAINT CK_TBLTEACHER_CONDITION CHECK(condition in ('현직', '대기'));

select * from tblTeacher;

-- 교사: 강의 인원(6명), 대기 인원(4명)
-- 교사명, 주민번호(뒷자리) - 7자리, 전화번호, 현직/대기여부
-- 1698912 1693889 1336896 1431653 1752757 1661624 1729593 1972958 1462878 1318642
/*
1. 채제원, 1698912, 010-5953-4044, 현직
2. 곽우신, 1693889, 010-6331-5858, 현직
3. 이응수, 1336896, 010-8284-5522, 대기
4. 이창익, 1431653, 010-8210-5218, 현직
5. 박세인, 1752757, 010-2114-1939, 현직
6. 이규미, 2661624, 010-5822-5652, 대기
7. 김호진, 1729593, 010-7991-3906, 대기
8. 김현룡, 1972958, 010-1053-4028, 현직
9. 김대기, 1462878, 010-7358-1664, 대기
10. 서영학, 1318642, 010-4465-5021, 현직
*/

INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '채제원', '1698912', '010-5953-4044', '현직');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '곽우신', '1693889', '010-6331-5858', '현직');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '이응수', '1336896', '010-8284-5522', '대기');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '이창익', '1431653', '010-8210-5218', '현직');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '박세인', '1752757', '010-2114-1939', '현직');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '이규미', '2661624', '010-5822-5652', '대기');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '김호진', '1729593', '010-7991-3906', '대기');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '김현룡', '1972958', '010-1053-4028', '현직');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '김대기', '1462878', '010-7358-1664', '대기');
INSERT INTO tblTeacher (teacherSeq, name, ssn, phoneNumber, condition) values (teacherSeq.nextVal, '서영학', '1318642', '010-4465-5021', '현직');

--[교육생]--------------------------------------------------------------------------------------------------------------
drop table tblStudent;
drop sequence studentSeq;

CREATE TABLE tblStudent (
    studentSeq number NOT NULL,        -- 교육생고유번호 (PK)
    name varchar2(20) NOT NULL,        -- 교육생 이름
    phoneNumber varchar2(15) NULL,     -- 전화번호
    ssn varchar2(15) NOT NULL,         -- 주민번호(뒷자리)
    enrollDate date NOT NULL,          -- 등록일
    birth varchar2(15) NOT NULL,       -- 생년월일
    condition varchar2(15) NOT NULL,   -- 중도탈락 여부
    dropDate date NULL                 -- 중도탈락날짜
);

CREATE SEQUENCE studentSeq;

ALTER TABLE tblStudent 
    ADD CONSTRAINT PK_TBLSTUDENT PRIMARY KEY (studentSeq);
    
ALTER TABLE tblStudent 
    ADD CONSTRAINT CK_TBLSTUDENT_SSN CHECK(length (ssn) = 7);

ALTER TABLE tblStudent 
    ADD CONSTRAINT CK_TBLSTUDENT_CONDITION CHECK(condition in('수료중', '중도탈락'));

select * from tblStudent;
       
        
--[전체과정]--------------------------------------------------------------------------------------------------------------

Drop table tblTotalCourse;
Drop SEQUENCE totalCourseSeq;

CREATE TABLE tblTotalCourse (
     totalCourseSeq number NOT NULL,     --전체과정 고유번호(PK)
     name varchar2(100) NOT NULL,        --과정명
     period number NOT NULL             --과정기간(5.5 0r 6 or 7)
);

CREATE SEQUENCE totalCourseSeq;

--PK_TBLTOTALCOURSE
ALTER TABLE tblTotalCourse 
    ADD CONSTRAINT PK_TBLTOTALCOURSE PRIMARY KEY (totalCourseSeq);

---CK_TBLTOTALCOURSE_PERIOD
ALTER TABLE tblTotalCourse 
ADD CONSTRAINT CK_TBLTOTALCOURSE_PERIOD CHECK(period in (5.5, 6, 7));

select * from tblTotalCourse;

--전체과정19개
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'오픈플랫폼(아두이노)을 활용한 융합개발자 양성과정(A)', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Java 기반 임베디드 플랫폼 연동 융합 개발자 양성 과정', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'자바 기반 AWS 클라우드 활용 Full-Stack 개발자 양성 과정', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'JAVA를 활용한 웹 콘텐츠 양성과정', 7);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'데이터 분석기법을 활용한 데이터융합 개발자 양성과정(B)', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'자바기반 Full-stack 웹 개발자 양성과정(C)', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'자바 기반 융합형 SW개발자 양성과정' , 6);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Java를 활용한 멀티 플랫폼 융합 SW개발자 양성과정(C)', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'JAVA기반의 스마트 웹 앱콘텐츠 양성과정', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Java와 JavaScript library을 활용한 반응형 웹 개발자 양성과정', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Python과 Java 응용SW실무개발자 양성과정', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'파이썬과 자바를 연계한 머신러닝 활용 개발자 양성과정', 6);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Framework 기반의 빅데이터 활용 응용프로그래머', 7);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Java And JavaScript library를 활용한 반응형 웹 개발자 양성', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Python And Java를 활용한 AI 텍스트마이닝 개발자', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'웹기반 빅데이터 분석 응용SW개발자 양성과정', 6);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Java를 활용한 웹 응용SW개발자 양성과정', 5.5);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'Java And Python 기반 응용SW개발자 양성과정', 6);
INSERT INTO tblTotalCourse(totalCourseSeq, name, period) VALUES (totalCourseSeq.nextval,'JAVA 기반의 스마트 웹 앱콘텐츠 양성과정', 7);

--[강의실]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblClassroom (
     classroomSeq number NOT NULL,      -- 강의실 고유번호(PK)
     name varchar2(15) NOT NULL,        -- 강의실 이름
     condition varchar2(15) NOT NULL,   -- 강의상태
     limitCount number NOT NULL         -- 수용인원
);

CREATE SEQUENCE classroomSeq;

ALTER TABLE tblClassroom 
    ADD CONSTRAINT PK_TBLCLASSROOM PRIMARY KEY (classroomSeq);
    
ALTER TABLE tblClassroom 
    ADD CONSTRAINT CK_TBLCLASSROOM_CONDITION CHECK(condition in ('강의중', '강의없음'));   

select * from tblClassroom;    

INSERT INTO tblClassroom (CLASSROOMSEQ,NAME,CONDITION,LIMITCOUNT) VALUES(classroomSeq.nextval,'1강의실', '강의중' ,30);
INSERT INTO tblClassroom (CLASSROOMSEQ,NAME,CONDITION,LIMITCOUNT) VALUES(classroomSeq.nextval,'2강의실', '강의중' ,30);
INSERT INTO tblClassroom (CLASSROOMSEQ,NAME,CONDITION,LIMITCOUNT) VALUES(classroomSeq.nextval,'3강의실', '강의중' ,30);
INSERT INTO tblClassroom (CLASSROOMSEQ,NAME,CONDITION,LIMITCOUNT) VALUES(classroomSeq.nextval,'4강의실', '강의중' ,26);
INSERT INTO tblClassroom (CLASSROOMSEQ,NAME,CONDITION,LIMITCOUNT) VALUES(classroomSeq.nextval,'5강의실', '강의중' ,26);
INSERT INTO tblClassroom (CLASSROOMSEQ,NAME,CONDITION,LIMITCOUNT) VALUES(classroomSeq.nextval,'6강의실', '강의중' ,26);


--[전체과목]--------------------------------------------------------------------------------------------------------------


CREATE TABLE tblTotalSubject (
    totalSubjectSeq number NOT NULL,    -- 전체과목번호(PK)
    name varchar2(100) NOT NULL          -- 과목명
);

CREATE SEQUENCE totalSubjectSeq;

ALTER TABLE tblTotalSubject
    ADD CONSTRAINT PK_TBLTOTALSUBJECT PRIMARY KEY (totalSubjectSeq);   

select * from tblTotalSubject;        

-- 전체과목 (32개)
--insert into tblTotalSubject values (전체과목고유번호, 과목명);

insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'JAVA 객체 지향 프로그래밍');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '오라클을 사용한 RDBMS의 SQL과 PL/SQL');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Front-end 클라이언트 화면설계 및 구현');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Back-end를 활용한 웹서버 구현');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '아두이노를 활용한 임베디드 프로그래밍');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '멀티 플랫폼 기반 융합 실무 프로젝트');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '클라우드 개발을 위한 자바 기초 프로그래밍');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '클라우드 시스템 개요 및 AWS 서비스 요소');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'AWS 클라우드 등록 설정 및 구축');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Server Side 프로그래밍');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '지능형 웹을 위한 애플리케이션 구축');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '콘텐츠 추천 알고리즘 기법');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데이터 분석기법 및 활용');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '공공 데이터 분석기법을 활용한 데이터 융합 프로젝트');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '임베디드 애플리케이션 구현');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '반응형 웹 개발기법');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '애플리케이션 테스트 수행');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '애플리케이션 배포');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Java OpenJDK를 활용한 통합 프로젝트');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데이터베이스 구현');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데이터 저장을 위한 오라클 데이터베이스');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'NCS 소양교과');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '코틀린 프로그래밍');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '코틀린 안드로이드 프로그램 구현');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '코틀린 활용 안드로이드 모바일 프로젝트 제작');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'UML을 사용한 시스템 분석');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '형상관리');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '데스트 탑 UI/UX');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '웹킷 계열 브라우저 반응형 웹 UI/UX설계');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Web Publishing을 위한 Front-End 설계 및 구현');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, '인공지능');
insert into tblTotalSubject values (totalSubjectSeq.nextVal, 'Python');

    
--[전체교재]--------------------------------------------------------------------------------------------------------------
Drop table tblAllBook;
drop SEQUENCE allBookSeq;

CREATE TABLE tblAllBook (
     allBookSeq number NOT NULL,    -- 전체교제고유번호(PK)
     name varchar2(100) NOT NULL,    -- 교재명
     publisher varchar(50) NULL,    -- 출판사
     writer varchar(50) NULL,       -- 저자
     price number NOT NULL          -- 가격
);

CREATE SEQUENCE allBookSeq;

ALTER TABLE tblAllBook 
    ADD CONSTRAINT PK_TBLALLBOOK PRIMARY KEY (allBookSeq);

--전체 교재(32개)
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'Do it! 자바 프로그래밍 입문','이지스퍼블리싱','박은종', 25000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'Do it! 오라클로 배우는 데이터베이스 입문','이지스퍼블리싱','이지훈', 25000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'HTML5,CSS3,JavaScript,jQuery Mobile 중심의 Front-End 웹프로그래밍','마지원','김형수', 22000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'Do it! 웹 프로그래밍을 위한 자바스크립트 기본 편','이지스퍼블리싱','고경희', 18800);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, '한 권으로 끝내는 아두이노 입문 + 실전(종합편)','앤써북','서민우', 20000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, '2D/3D 멀티 플랫폼 게임을 위한 유니티','제이펍','박승제', 40000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, '클라우드 2nd Edition(그림으로 배우는)','영진닷컴','서재원', 16000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, '애플리케이션 프로그래밍 with 자바(아파치 카프카) ','비제이퍼블릭','최원영',32000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'AWS 클라우드 머신러닝','에이콘출판','박정현', 35000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'JSP 웹프로그래밍 가이드','마이트프레스','김재환', 23000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, '웹 크롤링 테크닉','제이펍','이동규', 30000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'Do it! 자료구조와 함께 배우는 알고리즘 입문','이지스퍼블리싱','강민', 22000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'ADsP 데이터 분석 준전문가','데이터에듀','윤종식', 28000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'R을 이용한 공공데이터 분석','한나래아카데미','오대영', 28000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, '임베디드 OS 개발 프로젝트','인사이트','이만우', 24000);
INSERT INTO tblAllBook VALUES(allBookSeq.nextval, 'Do it! 반응형 웹 페이지 만들기','이지스퍼블리싱','김운아', 20000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'데이터 중심 애플리케이션 설계','위키북스 ','마틴 클레프만', 32400);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'ClickOnce : 스마트클라이언트 애플리케이션 배포 솔루션','대림','황인균',18000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'OpenJDK Cookbook','Packt Publishing','Beckwith, Monica', 52030);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'멀티미디어 데이터베이스 구현 입문','생능출판사','이영재',13000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'예제로 배우는 오라클 데이터베이스 12c','가메출판사','인경열',20700);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'NCS : DB엔지니어링','휴먼컬처아리랑','한국산업인력공단',22000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'Do it! 코틀린 프로그래밍','이지스퍼블리싱','황영덕',27000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'빅 너드 랜치의 코틀린 프로그래밍','제이펍','조시 스킨, 데이비드 그린핼퍼', 27000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'만들면서 배우는 코틀린과 안드로이드 프로그래밍','위키북스','유병석',32400);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'객체 지향 설계와 분석을 위한 UML 기초와 응용','한빛아카데미','김귀정, 한수정', 24000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'시스템 개발 일반 지침서','대우통신','형상관리팀',10000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'사용자를 끌어들이는 UX/UI의 비밀','인사이트','제니퍼 타드웰, 박재현', 29700);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'UI/UX 디자인 이론과 실습 with Adobe XD','한빛아카데미','이영주',28000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'Do it! HTML+CSS+자바스크립트 웹 표준의 정석','이지스퍼블리싱','고경희',27000);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'혼자 공부하는 머신러닝+딥러닝','한빛미디어','박해선',23400);
INSERT INTO tblAllBook VALUES (allBookSeq.nextval,'이것이 취업을 위한 코딩 테스트다 with 파이썬','한빛미디어','나동빈',30600);

select * from tblAllBook;        
        

--[출결]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblAttendance (
     attendaceSeq number NOT NULL,      -- 출결고유번호(PK)
     AttendanceDate date NOT NULL,      -- 날짜
     inTime date NULL,                  -- 입실시간
     outTime date NULL,                 -- 퇴실시간
     condition varchar2(15) NOT NULL    -- 출결상태
);

CREATE SEQUENCE attendaceSeq;

ALTER TABLE tblAttendance 
    ADD CONSTRAINT PK_TBLATTENDANCE PRIMARY KEY (attendaceSeq);

ALTER TABLE tblAttendance
    ADD CONSTRAINT PK_TBLATTENDANCE_CONDITION CHECK(condition in('정상','조퇴','지각','결석','병가','기타', '외출'));

select * from tblAttendance;      

--[교사평가]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblTeacherSurvey (
     teacherSurveySeq number NOT NULL,  -- 교사평가고유번호(PK)
     studentComment varchar2(200) NULL     -- 느낀점
);

CREATE SEQUENCE teacherSurveySeq;

ALTER TABLE tblTeacherSurvey 
    ADD CONSTRAINT PK_TBLTEACHERSURVEY PRIMARY KEY (teacherSurveySeq);



select * from tblTeacherSurvey;      

--[개설과정]--------------------------------------------------------------------------------------------------------------
CREATE TABLE tblOpenCourse (
     openCourseSeq number NOT NULL,     -- 개설과정 고유번호(PK)
     beginDate date NOT NULL,           -- 과정시작기간
     endDate date NOT NULL,             -- 과정종료기간
     registerCount number NOT NULL,     -- 교육생 등록인원
     teacherSeq number NOT NULL,        -- 교사고유번호(FK)
     totalCourseSeq number NOT NULL,    -- 전체과정고유번호(FK)
     classroomSeq number NOT NULL       -- 강의실 고유번호(FK)
);

CREATE SEQUENCE openCourseSeq;

-- PK_TBLOPENCOURSE
ALTER TABLE tblOpenCourse 
    ADD CONSTRAINT PK_TBLOPENCOURSE PRIMARY KEY (openCourseSeq);

--FK_tblTeacher_TO_tblOpenCourse
ALTER TABLE tblOpenCourse 
    ADD CONSTRAINT FK_tblTeacher_TO_tblOpenCourse FOREIGN KEY (teacherSeq)
        REFERENCES tblTeacher (teacherSeq);

--FK_tblTotalCourse_TO_tblOpenCourse
ALTER TABLE tblOpenCourse 
    ADD CONSTRAINT FK_tblTotal_TO_tblOpen FOREIGN KEY (totalCourseSeq)
        REFERENCES tblTotalCourse (totalCourseSeq);

-- FK_tblClassroom_TO_tblOpenCourse
ALTER TABLE tblOpenCourse
    ADD CONSTRAINT FK_tblClassroom_TO_tblOpen FOREIGN KEY (classroomSeq)
        REFERENCES tblClassroom (classroomSeq);


INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2020-09-07', '2021-02-26', 30, 1, 11, 1);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2020-09-14', '2021-03-12', 30 , 2, 12, 2);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-03-02', '2022-08-13', 30, 1, 1, 1);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-03-15', '2022-08-27', 30, 2, 2, 2);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-04-05', '2021-09-24', 30, 4, 3, 3);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-02-01', '2021-09-03', 26, 5, 4, 4);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-04-19', '2021-10-08', 26, 8, 5, 5);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-05-03', '2021-10-15', 26, 10, 6, 6);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-08-16', '2022-02-16', 25, 1, 7, 1);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-08-30', '2022-02-11', 20, 2, 8, 2);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-09-27', '2022-03-11', 21, 4, 9, 3);
INSERT INTO tblOpenCourse VALUES(openCourseSeq.nextval, '2021-09-06', '2022-02-25', 26, 5, 10, 4);

select * from tblOpenCourse;  

--[강의가능과목]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblPossibleSubject (
    possibleSubjectSeq number NOT NULL,     -- 강의가능과목 고유번호(PK)
    totalSubjectSeq number NOT NULL,        -- 전체과목번호(FK)
    teacherSeq number NOT NULL              -- 교사고유번호(FK)
);

CREATE SEQUENCE possibleSubjectseq;

ALTER TABLE tblPossibleSubject
    ADD CONSTRAINT PK_TBLPOSSIBLESUBJECT PRIMARY KEY (possibleSubjectseq);

ALTER TABLE tblPossibleSubject
    ADD CONSTRAINT FK_tblTotalSub_tblPossible FOREIGN KEY (totalSubjectSeq)
        REFERENCES tblTotalSubject (totalSubjectSeq);
        
ALTER TABLE tblPossibleSubject
    ADD CONSTRAINT FK_tblTeacher_tblPossible FOREIGN KEY (teacherSeq)
        REFERENCES tblTeacher (teacherSeq);

--[강의가능과목]
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 2, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 30, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 5, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 15, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 16, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 17, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 18, 1);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 19, 1);


INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 2, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 30, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 5, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 6, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 10, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 22, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 23, 2);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 24, 2);


INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 7, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 20, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 30, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 3, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 8, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 9, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 28, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 29, 3);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 3);

INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 20, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 17, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 18, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 29, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 27, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 26, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 28, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 13, 4);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 14, 4);

INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 20, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 13, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 30, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 3, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 21, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 20, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 31, 5);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 32, 5);

INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 19, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 20, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 3, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 15, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 6, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 2, 6);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 21, 6);

INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 2, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 3, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 11, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 16, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 17, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 18, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 19, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 20, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 29, 7);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 30, 7);

INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 2, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 3, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 6, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 15, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 17, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 18, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 19, 8);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 32, 8);

INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 2, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 6, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 7, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 8, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 6, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 11, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 17, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 18, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 23, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 24, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 25, 9);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 27, 9);

INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 1, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 2, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 3, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 4, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 16, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 21, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 26, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 27, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 28, 10);
INSERT INTO tblPossibleSubject VALUES(possibleSubjectSeq.nextVal, 29, 10);

select * from tblPossibleSubject;


--[사용교재]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblUsedBook (
     usedBookSeq number NOT NULL,       -- 사용교재고유번호(PK)
     totalSubjectSeq number NOT NULL,   -- 전체과목번호(FK)
     allBookSeq number NOT NULL         -- 전체교재고유번호(FK)
);

CREATE SEQUENCE usedBookSeq;

ALTER TABLE tblUsedBook 
    ADD CONSTRAINT PK_TBLUSEDBOOK PRIMARY KEY (usedBookSeq);

ALTER TABLE tblUsedBook 
    ADD CONSTRAINT FK_tblTotalSub_tblUsedBook FOREIGN KEY (totalSubjectSeq)
        REFERENCES tblTotalSubject (totalSubjectSeq);

ALTER TABLE tblUsedBook 
    ADD CONSTRAINT FK_tblAllBook_tblUsedBook FOREIGN KEY (allBookSeq)
        REFERENCES tblAllBook (allBookSeq);

-- 사용교재
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 1, 1);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 2, 2);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 3, 3);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 4, 4);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 5, 5);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 6, 6);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 7, 7);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 8, 8);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 9, 9);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 10, 10);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 11, 11);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 12, 12);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 13, 13);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 14, 14);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 15, 15);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 16, 16);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 17, 17);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 18, 18);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 19, 19);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 20, 20);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 21, 21);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 22, 22);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 23, 23);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 24, 24);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 25, 25);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 26, 26);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 27, 27);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 28, 28);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 29, 29);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 30, 30);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 31, 31);
INSERT INTO tblUsedBook VALUES(usedBookSeq.nextval, 32, 32);

select * from tblUsedBook;

--[상담일지]--------------------------------------------------------------------------------------------------------------

Drop Table tblCounselingDiary;
Drop SEQUENCE counselingDiarySeq;

CREATE TABLE tblCounselingDiary (
     counselingDiarySeq number NOT NULL, -- 상담일지고유번호(PK)
     counselingDate date NULL,           -- 상담날짜
     content varchar2(1000) NULL,        -- 상담내용
     seq number NOT NULL                 -- 개설과정 고유번호(FK)
);

CREATE SEQUENCE counselingDiarySeq;

ALTER TABLE tblCounselingDiary 
    ADD CONSTRAINT PK_TBLCOUNSELINGDIARY PRIMARY KEY (counselingDiarySeq);

ALTER TABLE tblCounselingDiary 
    ADD CONSTRAINT FK_tblOpenC_tblCounselingDiary FOREIGN KEY (seq)
        REFERENCES tblOpenCourse (openCourseSeq);

INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 전공, 수업 이해도: 상 , 과제 난이도: 상, 희망 기업: 백엔드 쪽으로 희망 함 ,희망 연봉: 4000 희망 함, 추가사항: 조장으로 팀원을 이끌어가는 리더쉽이 보이나 완벽을 추구함', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 전공 , 수업 이해도: 중 , 과제 난이도: 하, 희망 기업: 아직 희망 취업 분야 없음, 희망 연봉: 3000만원 이상, 추가사항: 전문대 졸로 전공이긴 하나 이해도가 떨어짐', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공 , 수업 이해도: 상, 과제 난이도:상, 희망 기업: 아직 희망 취업 분야 없음, 희망 연봉:3000 만원 이상, 추가사항: 비전공이나 이해도가 높고 자기주도 학습이 잘 이루어짐', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도:중, 과제 난이도:중, 희망 기업: DB분야 ,희망 연봉: 2500만원, 추가사항: 수업을 잘 따라 옴', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 전공 , 수업 이해도: 중, 과제 난이도: 중, 희망 기업: 앱개발 분야 ,희망 연봉: 3000만원, 추가사항: 수업 참여도가 높고 질문에 대해 이해가 빠름', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도: 하, 과제 난이도: 하, 희망 기업: 아직 희망 기업 없음, 희망 연봉: 2000만원 이상, 추가사항: 수업 진도에 빠르다고 느끼며 과제 제출에 매번 늦음', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도: 중, 과제 난이도: 상, 희망 기업: 공기업, 희망 연봉: 4000만원, 추가사항: 수업 참여도는 적으나 프로젝트 결과물이 상당히 좋음, 팀워크가 좋음', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 전공, 수업 이해도: 상, 과제 난이도: 상, 희망 기업: 은행 ,희망 연봉: 3500만원이상, 추가사항: 프로젝트 설문조사때 기여도가 가장 큰 학생으로 리더쉽을 가짐', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 전공 , 수업 이해도: 중, 과제 난이도: 중, 희망 기업: 아직 희망 기업 없음, 희망 연봉: 희망 연봉 없음, 추가사항: 없음', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도: 하, 과제 난이도 :하, 희망 기업: 아직 희망 기업 없음 , 희망 연봉: 2000만원 중반, 추가사항: 수업에 어려움을 느낌, 성향과 안맞는다고 생각함', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도: 상, 과제 난이도: 중, 희망 기업: 소프트웨어 개발, 희망 연봉: 27000만원 이상, 추가사항: 수업참여도는 높으나 프로젝트때 비전공자의 한계를 느낌', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도: 중, 과제 난이도: 중, 희망 기업: 아직 희망기업 없음, 희망 연봉: 2000만원 초반, 추가사항: 없음 ', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도: 중, 과제 난이도: 상, 희망 기업: 아직 희망기업 없음, 희망 연봉: 3000만원 이상, 추가사항: 아르바이트로 인한 피로로 수업에 집중하기 어려운 환경이지만 질문과 상담으로 최선을 다 함', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 전공, 수업 이해도: 상, 과제 난이도: 중, 희망 기업: 금융업 희망, 희망 연봉: 4000만원, 추가사항: 개념에 대한 이해도가 높으며  탐워크가 좋음', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-07', '전공/비전공: 비전공, 수업 이해도: 중, 과제 난이도: 중, 희망 기업: 앱개발, 희망 연봉: 3000만원 이상, 추가사항: 프로젝트로 인한 팀원 갈등으로 단체활동에 어려움을 느낌', 1 );
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 아직까지 이해 잘됨, 과제 난이도: 보통, 희망 기업: 중소기업, 희망 연봉: 3000만원, 추가사항: 대면수업을 희망함', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 비전공자, 수업 이해도: 아직까지 무난, 과제 난이도: 무난, 희망 기업: 아직X, 희망 연봉: 2800이상, 추가사항: ', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 비전공자, 수업 이해도: 수업은 따라갈만함, 과제 난이도: 응용 어려워함, 희망 기업: 아직X , 희망 연봉:X, 추가사항: 아르바이트 병행하고있음.', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 무리없이 따라옴, 과제 난이도: 응용문제 해결ok, 희망 기업: 중견기업 , 희망 연봉: 3500이상, 추가사항: 응용문제 많이 풀기를 희망함', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 아직까지 이해 잘됨, 과제 난이도: 해결하는데 문제없음, 희망 기업: 은행관련기업, 희망 연봉: 3500만원, 추가사항: ', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 비전공자, 수업 이해도: 무리없이 따라옴, 과제 난이도: 응용문제는 좀 힘들어함, 희망 기업: 중소/중견기업 , 희망 연봉: 3000이상, 추가사항: 대면수업 늘리길 희망함', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 무난, 과제 난이도: 해결하는데 문제없음, 희망 기업: 아직X, 희망 연봉: X, 추가사항: 코딩에 재미를 붙였으나, 아직 정확한 진로를 못정함', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 비전공자, 수업 이해도: 무리없이 따라옴, 과제 난이도: 시간이 많이 걸리나 해결함, 희망 기업: 중소/중견기업 , 희망 연봉: 3000이상, 추가사항: 비전공자이지만 프로그래밍에 흥미를 가지고 배우러옴.', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 무리없음, 과제 난이도: 해결하는데 문제없음, 희망 기업: 쌍용, 희망 연봉: 3800이상, 추가사항: 전공이 적성에 맞아 체계적으로 더 배우고 싶어 지원', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 비전공자, 수업 이해도: 조금 힘들어함, 과제 난이도: 시간 투자에 비해 해결이 잘 안됨, 희망 기업: X , 희망 연봉: X, 추가사항: 문제풀이에 있어 많이 힘들어함. 응용 문제 풀이 설명 원함.', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 무리없음, 과제 난이도: 무난, 희망 기업: 네이버, 희망 연봉: 3800이상, 추가사항: 임베디드에 관심이 많음', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 무리없음, 과제 난이도: 무난, 희망 기업: 삼성, 희망 연봉: 3800이상, 추가사항: ', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 비전공자, 수업 이해도: 무리없음, 과제 난이도: 아직까지 무난, 희망 기업: 임베디드관련기업, 희망 연봉: 3000이상, 추가사항: 코드리뷰 시간 늘리길 원함.', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 비전공자, 수업 이해도: 무리없음, 과제 난이도: 응용문제(상)빼고는 괜찮음, 희망 기업: 웹페이지관리 , 희망 연봉: X, 추가사항: 문제풀이 많이 하길 원함.', 1);
INSERT INTO tblCounselingDiary VALUES(counselingDiarySeq.nextval, '2021-04-08', '전공/비전공: 전공자, 수업 이해도: 무리없음, 과제 난이도: 무난, 희망 기업: 전산직분야, 희망 연봉: 3500이상, 추가사항: ', 1);


select * from tblCounselingDiary;


--[개설과목]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblOpenSubject (
    openSubjectSeq number NOT NULL,         -- 개설과목 고유번호(PK)
    beginDate date NOT NULL,                -- 과목시작날짜
    endDate date NOT NULL,                  -- 과목종료날짜
    openCourseSeq number NOT NULL,          -- 개설과정 고유번호(FK)
    totalSubjectSeq number NOT NULL,        -- 전체과목번호(FK)
    period varchar2(20) NOT NULL            -- 과목기간
);  

CREATE SEQUENCE openSubjectSeq;

ALTER TABLE tblOpenSubject
    ADD CONSTRAINT PK_TBLOPENSUBJECT PRIMARY KEY (openSubjectSeq);

ALTER TABLE tblOpenSubject
    ADD CONSTRAINT FK_tblOpenC_tblOpenSub FOREIGN KEY (openCourseSeq)
        REFERENCES tblOpenCourse (openCourseSeq);

ALTER TABLE tblOpenSubject
    ADD CONSTRAINT FK_tblTotalSub_tblOpenSub FOREIGN KEY (totalSubjectSeq)
        REFERENCES tblTotalSubject (totalSubjectSeq);    

--개설과목
--INSERT INTO tblOpenSubject VALUES(개설과목 고유번호,과목시작날짜, 종료날짜, 개설과정고유번호, 전체과목번호, 과목기간);
--1강의실, 1번선생님 5.5개월  '2021-03-02', '2021-08-13'
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-03-02', '2021-04-02', 3, 1, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-04-05', '2021-05-03', 3, 2, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-05-04', '2021-06-04', 3, 4, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-06-07', '2021-07-07', 3, 5, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-08', '2021-07-30', 3, 30, '21일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-08-02', '2021-08-13', 3, 15, '10일');

--2강의실, 2번선생님 5.5개월  '2021-03-15', '2021-08-27'
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-03-15', '2021-04-09', 4, 1, '23일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-04-12', '2021-05-12', 4, 2, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-05-13', '2021-06-14', 4, 30, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-06-15', '2021-07-02', 4, 4, '17일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-05', '2021-07-30', 4, 5, '25일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-08-02', '2021-08-27', 4, 6, '25일');

--3강의실, 4번선생님 5.5개월  '2021-04-05', '2021-09-24'
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-04-05', '2021-04-30', 5, 1, '25일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-05-03', '2021-05-28', 5, 20, '25일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-05-31', '2021-06-29', 5, 17, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-06-30', '2021-07-23', 5, 18, '24일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-26', '2021-08-11', 5, 29, '16일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-08-12', '2021-09-02', 5, 27, '20일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-09-03', '2021-09-24', 5, 26, '21일');

--4강의실, 5번선생님 7개월  '2021-02-01', '2021-09-03'
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-02-01', '2021-02-26', 6, 1, '25일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-03-02', '2021-03-31', 6, 20, '29일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-04-01', '2021-04-30', 6, 13, '29일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-05-02', '2021-05-31', 6, 30, '29일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-06-01', '2021-06-30', 6, 3, '29일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-01', '2021-07-16', 6, 4, '15일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-19', '2021-08-06', 6, 21, '17일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-08-09', '2021-08-20', 6, 20, '11일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-08-23', '2021-09-03', 6, 31, '11일');

--5강의실, 8번선생님 5.5개월  '2021-04-19', '2021-10-08'
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-04-19', '2021-05-06', 7, 2, '17일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-05-07', '2021-06-03', 7, 3, '30일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-06-04', '2021-06-30', 7, 4, '26일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-01', '2021-07-23', 7, 17, '22일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-26', '2021-08-31', 7, 18, '35일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-09-01', '2021-10-08', 7, 19, '37일');

--6강의실, 10번선생님 5.5개월  '2021-05-03', '2021-10-15'
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-05-03', '2021-05-31', 8, 1, '28일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-06-01', '2021-06-24', 8, 2, '23일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-06-25', '2021-07-16', 8, 3, '21일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-07-19', '2021-08-27', 8, 21, '38일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-08-30', '2021-09-24', 8, 27, '25일');
INSERT INTO tblOpenSubject VALUES(openSubjectSeq.nextval, '2021-09-27', '2021-10-15', 8, 29, '19일');

select * from tblOpenSubject;


--[강의스케줄]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblLectureSchedule (
     lectureScheduleSeq number NOT NULL,    -- 강의스케줄 고유번호(PK)
     condition varchar2(15) NOT NULL,       -- 강의진행상태 
     openSubjectSeq number NOT NULL         -- 개설과목고유번호(FK)
);

CREATE SEQUENCE lectureScheduleSeq;

ALTER TABLE tblLectureSchedule 
    ADD CONSTRAINT PK_TBLLECTURESCHEDULE PRIMARY KEY (lectureScheduleSeq);

ALTER TABLE tblLectureSchedule 
    ADD CONSTRAINT FK_tblOpenSub_tblSchedule FOREIGN KEY (openSubjectSeq)
        REFERENCES tblOpenSubject (openSubjectSeq);

ALTER TABLE tblLectureSchedule 
    ADD CONSTRAINT CK_tblSchedule_condition CHECK(condition in ('강의예정', '강의중', '강의종료'));


--강의 스케줄
--3번과정, 1번선생님
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 1);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 2);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 3);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의중', 4);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 5);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 6);

--4번과정, 2번선생님
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 7);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 8);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의중', 9);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 10);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 11);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 12);

--5번과정, 4번선생님
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 13);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 14);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의중', 15);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 16);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 17);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 18);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 19);

--6번과정, 5번선생님
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 20);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 21);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 22);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 23);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의중', 24);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 25);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 26);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 27);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 28);

--7번과정, 8번선생님
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 29);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 30);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의중', 31);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 32);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 33);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 34);

--8번과정, 10번선생님
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의종료', 35);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의중', 36);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 37);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 38);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 39);
INSERT INTO tblLectureSchedule VALUES(lectureScheduleSeq.nextval, '강의예정', 40);

select * from tblLectureSchedule;

--[강의평가]--------------------------------------------------------------------------------------------------------------

Drop Table tblCourseSurvey;
Drop SEQUENCE courseSurveySeq;

CREATE TABLE tblCourseSurvey (
     courseSurveySeq number NOT NULL,   -- 강의평가 고유번호(PK)
     surveyComment varchar2(1000) NULL,  -- 평가 내용
     score number NULL,                 -- 평가 점수
     openSubjectSeq number NOT NULL     -- 개설과목 고유번호(FK)
);

CREATE SEQUENCE courseSurveySeq;

--PK_TBLCORSESURVEY
ALTER TABLE tblCourseSurvey 
    ADD CONSTRAINT PK_TBLCORSESURVEY PRIMARY KEY (courseSurveySeq);

--CK_TBLCORSESURVEY_SCORE
ALTER TABLE tblCourseSurvey 
    ADD CONSTRAINT CK_TBLCOURSESURVEY_SCORE CHECK(score between 1 and 10);

-- FK_tblOpenSubject_TO_tblCorseSurvey    
ALTER TABLE tblCourseSurvey 
    ADD CONSTRAINT FK_tblOpenSub_tblCourseSurvey FOREIGN KEY (openSubjectSeq)
        REFERENCES tblOpenSubject (openSubjectSeq);

--1강의실, 1과목 (30명)
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '이해잘되게 세세하게 설명해주셔서 너무 좋았습니다.', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '비전공자가 따라가기에 진도가 조금 빨랐습니다ㅜㅜ', 9, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '질문할때마다 잘 답변해주셔서 수업 이해하기가 좋았습니다!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '코드리뷰시간은 아주 유용한거 같아요!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '단축키같은 좋은 정보를 다 알려주셔서 너무 좋았습니다ㅎㅎ', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '응용문제는 아직 해결하는데 어려움이 있지만 실력이 많이 좋아졌어요!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '매일 8시간씩 나가다보니까 복습없이는 따라가기 힘들거같아요', 9, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '선생님이 시키시는대로만 했는데 실력이 아주 좋아진거 같습니다!!ㅎ', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '자세히 알려주시는데도 따라가기가 벅찼습니다ㅜ', 9, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '첫 과목이 끝났는데 쌍용교육센터 오길 잘했단 생각이 듭니다!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '항상 친절히 설명해주셔서 너무 좋았습니다.', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도가 조금 빨랐습니다ㅜㅜ', 9, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '질문할때마다 잘 답변해주셔서 수업 이해하기가 좋았습니다!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '코드리뷰하면서 실력이 많이 좋아진거같아요!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '알고있으면 좋을만한 정보들을 많이 알려주셔서 너무 좋았습니다ㅎㅎ', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '응용문제는 아직 해결하는데 어려움이 있지만 실력이 많이 좋아졌어요!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '매일 진도를 많이 나가서 한번 놓치면 따라가기 힘든것 같아요', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '선생님이 시키시는대로만 했는데 실력이 아주 좋아진거 같습니다!!ㅎ', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '저는 따라가기가 벅찼습니다ㅜ', 8, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '쌍용교육센터 오길 잘했단 생각이 듭니다!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '설명을 잘해주셔서 따라가기에 어려움이 없었습니다', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '비전공자가 따라가기에 진도가 조금 빨랐습니다ㅜㅜ', 9, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '질문할때마다 잘 답변해주셔서 수업 이해하기가 좋았습니다!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '코드리뷰하면서 다양한 시각을 가지게 되는거 같아요!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '단축키같은 좋은 정보를 다 알려주셔서 너무 좋았습니다ㅎㅎ', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '적응 못할 때 좋은 얘기 많이 해주셔서 무사히 첫 과목 잘 마친거 같아요!', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '매일 8시간씩 나가다보니까 복습없이는 따라가기 힘들거같아요', 9, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '선생님이 시키시는대로만 했는데 실력이 아주 좋아진거 같습니다!!ㅎ', 10, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '자세히 알려주시는데도 따라가기가 벅찼습니다ㅜ', 8, 1);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '첫 과목이 끝났는데 쌍용교육센터 오길 잘했단 생각이 듭니다!', 10, 1);

--1강의실, 2과목 (30명)
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '오라클은 자바보다 더 어렵네요 ㅜㅜ', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '두번째 과목은 더 빨리 지나가버린 거 같아요', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도가 빨라서 조금 힘들었습니다', 9, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '데이터베이스도 자세히 알려주셔서 많이 배운거 같습니다!', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '항상 좋은 얘기 해주셔서 힘 얻으며 수업 잘 받고있습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '내용은 이해하기 어려웠지만 진도 속도도 좋았고 질문하면 친절하게 알려주셔서 좋았습니다!. ', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '개념부분보다 실습하는 부분에 초점을 맞춰서 실무에 적용할 때 유용할것 같습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '프로젝트 기간이 짧아서 힘들었습니다', 7, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습문제를 질문하면 답을 바로주기보다 방향을 알려주셔서 혼자공부하기 좋았습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '조별로 프로젝트를 하는것 보다 개인으로 진행하고싶습니다. 강의는 좋았습니다.', 9, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '오라클은 자바보다 더 어렵네요 ㅜㅜ', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '두번째 과목은 더 빨리 지나가버린 거 같아요', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도가 빨라서 조금 힘들었습니다', 9, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '데이터베이스도 자세히 알려주셔서 많이 배운거 같습니다!', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '항상 좋은 얘기 해주셔서 힘 얻으며 수업 잘 받고있습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '내용은 이해하기 어려웠지만 진도 속도도 좋았고 질문하면 친절하게 알려주셔서 좋았습니다!. ', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '개념부분보다 실습하는 부분에 초점을 맞춰서 실무에 적용할 때 유용할것 같습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '프로젝트 기간이 짧아서 힘들었습니다', 7, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습문제를 질문하면 답을 바로주기보다 방향을 알려주셔서 혼자공부하기 좋았습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '조별로 프로젝트를 하는것 보다 개인으로 진행하고싶습니다. 강의는 좋았습니다.', 9, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '오라클은 자바보다 더 어렵네요 ㅜㅜ', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '두번째 과목은 더 빨리 지나가버린 거 같아요', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도가 빨라서 조금 힘들었습니다', 9, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '데이터베이스도 자세히 알려주셔서 많이 배운거 같습니다!', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '항상 좋은 얘기 해주셔서 힘 얻으며 수업 잘 받고있습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '내용은 이해하기 어려웠지만 진도 속도도 좋았고 질문하면 친절하게 알려주셔서 좋았습니다!. ', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '개념부분보다 실습하는 부분에 초점을 맞춰서 실무에 적용할 때 유용할것 같습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '프로젝트 기간이 짧아서 힘들었습니다', 7, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습문제를 질문하면 답을 바로주기보다 방향을 알려주셔서 혼자공부하기 좋았습니다.', 10, 2);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '조별로 프로젝트를 하는것 보다 개인으로 진행하고싶습니다. 강의는 좋았습니다.', 9, 2);


--1강의실, 3과목 (30명)
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도가 빨라서 따라가기 어려지만 구현하는 실습때는 충분한 시간을 주셔서 좋았습니다.', 9, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습하는 컴퓨터가 렉이 많이 걸려서 진도 따라가기 어려웠습니다.', 7, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '내용이 너무어려워서 배우는 기간이 너무 짧은것 같습니다.', 8, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '저는 포기해야할까요..  실습이 부족한건지 프로젝트 준비가 매우 벅찼습니다.', 7, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '짧은 시간인대도 불구하고 선생님 강의실력이 좋아서 좋은 결과물을 낼 수 있었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습보다 개념부분 설명이 더 길었으면 좋겠습니다.', 9, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도 속도도 좋았고, 설명도 좋아서 공부하기 편했습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습할때 모바일 강의도 포함돼서 혼자 공부하기 좋았습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '개념이해도 완벽하게 되었고 기사시험공부할 때 도움이 많이 되었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습하기 재밌었고 선생님께서 일일히 봐주셔서 도움이 많이 되었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도가 빨라서 따라가기 어려지만 구현하는 실습때는 충분한 시간을 주셔서 좋았습니다.', 9, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습하는 컴퓨터가 렉이 많이 걸려서 진도 따라가기 어려웠습니다.', 7, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '내용이 너무어려워서 배우는 기간이 너무 짧은것 같습니다.', 8, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '저는 포기해야할까요..  실습이 부족한건지 프로젝트 준비가 매우 벅찼습니다.', 7, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '짧은 시간인대도 불구하고 선생님 강의실력이 좋아서 좋은 결과물을 낼 수 있었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습보다 개념부분 설명이 더 길었으면 좋겠습니다.', 9, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도 속도도 좋았고, 설명도 좋아서 공부하기 편했습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습할때 모바일 강의도 포함돼서 혼자 공부하기 좋았습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '개념이해도 완벽하게 되었고 기사시험공부할 때 도움이 많이 되었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습하기 재밌었고 선생님께서 일일히 봐주셔서 도움이 많이 되었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도가 빨라서 따라가기 어려지만 구현하는 실습때는 충분한 시간을 주셔서 좋았습니다.', 9, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습하는 컴퓨터가 렉이 많이 걸려서 진도 따라가기 어려웠습니다.', 7, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '내용이 너무어려워서 배우는 기간이 너무 짧은것 같습니다.', 8, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '저는 포기해야할까요..  실습이 부족한건지 프로젝트 준비가 매우 벅찼습니다.', 7, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '짧은 시간인대도 불구하고 선생님 강의실력이 좋아서 좋은 결과물을 낼 수 있었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습보다 개념부분 설명이 더 길었으면 좋겠습니다.', 9, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '진도 속도도 좋았고, 설명도 좋아서 공부하기 편했습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습할때 모바일 강의도 포함돼서 혼자 공부하기 좋았습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '개념이해도 완벽하게 되었고 기사시험공부할 때 도움이 많이 되었습니다.', 10, 3);
INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '실습하기 재밌었고 선생님께서 일일히 봐주셔서 도움이 많이 되었습니다.', 10, 3);

select * from tblCourseSurvey;




--[시험지등록여부]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblRegistrationStatus (
    registrationStatusSeq number NOT NULL,      -- 시험지등록번호(PK)
    registrationDate date NULL,                 -- 시험지등록날짜
    condition varchar2(15) NOT NULL,            -- 시험지등록여부
    openSubjectSeq number NOT NULL              -- 개설과목 고유번호(FK)
);

CREATE SEQUENCE registrationStatusSeq;   

ALTER TABLE tblRegistrationStatus
    ADD CONSTRAINT PK_TBLREGISTSTATUS PRIMARY KEY (registrationStatusSeq);

ALTER TABLE tblRegistrationStatus 
    ADD CONSTRAINT CK_TBLREGISTATUS_CONDITION CHECK(condition in ('등록','미등록'));   

ALTER TABLE tblRegistrationStatus
    ADD CONSTRAINT FK_tblOpenSub_tblRegiStatus FOREIGN KEY (openSubjectSeq)
        REFERENCES tblOpenSubject (openSubjectSeq);

--시험지등록여부
--INSERT INTO tblRegistrationStatus VALUES(시험지등록번호, 시험지등록날짜, 시험지등록여부, 개설과목고유번호);
--1강의실
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-03-02' , '등록', 1);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-04-05' , '등록', 2);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-05-04' , '등록', 3);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, '2021-06-07', '등록', 4);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null , '미등록', 5);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null , '미등록', 6);

--2강의실
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-03-15' , '등록', 7);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-04-12' , '등록', 8);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-05-13' , '등록', 9);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 10);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 11);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 12);

--3강의실
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-04-05' , '등록', 13);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-05-03' , '등록', 14);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-05-31' , '등록', 15);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 16);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 17);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 18);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 19);

--4강의실
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-02-01' , '등록', 20);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-03-02' , '등록', 21);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-04-01' , '등록', 22);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-05-02' , '등록', 23);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-06-01' , '등록', 24);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,null, '미등록', 25);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,null, '미등록', 26);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,null, '미등록', 27);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,null, '미등록', 28);

--5강의실
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-04-19' , '등록', 29);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-05-07' , '등록', 30);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-06-04' , '등록', 31);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null , '미등록', 32);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null , '미등록', 33);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null , '미등록', 34);

--6강의실
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-05-03' , '등록', 35);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval,'2021-06-01' , '등록', 36);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 37);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 38);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 39);
INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '미등록', 20);


select * from tblRegistrationStatus;


--[시험]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblTest (                             
     testSeq number NOT NULL,               -- 시험고유번호(PK)
     testDate date NULL,                    -- 시험 날짜
     handwritingDistribution number NULL,   -- 필기 배점
     practiceDistribution number NULL,      -- 실기 배점
     attendanceDistribution number NULL,    -- 출석배점
     openSubjectSeq number NOT NULL,        -- 개설과목 고유번호(FK)
     registrationStatusSeq number NOT NULL  -- 시험지 등록 번호(FK)
);

CREATE SEQUENCE testSeq;

--PK_TBLTEST
ALTER TABLE tblTest 
    ADD CONSTRAINT PK_TBLTEST PRIMARY KEY (testSeq);

--FK_tblOpenSubject_TO_tblTest
ALTER TABLE tblTest 
    ADD CONSTRAINT FK_tblOpenSub_tblTest FOREIGN KEY (openSubjectSeq)
        REFERENCES tblOpenSubject (openSubjectSeq);

--FK_tblRegistrationStatus_TO_tblTest
ALTER TABLE tblTest 
    ADD CONSTRAINT FK_tblRegiStatus_tblTest FOREIGN KEY (registrationStatusSeq)
        REFERENCES tblRegistrationStatus (registrationStatusSeq);

--CK_TBLTEST_ATTENDANCEDISTRIBUTION
ALTER TABLE tblTest 
    ADD CONSTRAINT CK_TBLTEST_ATTENDANCEDIS CHECK (attendanceDistribution >= 20);
    
--CK_TBLTEST_DISTRIBUTION
ALTER TABLE tblTest 
    ADD CONSTRAINT CK_TBLTEST_DISTRIBUTION CHECK (attendanceDistribution + practiceDistribution + handwritingDistribution = 100);

--시험
--INSERT INTO tblTest VALUES(testSeq.nextval, 시험날짜, 필기배점, 실기, 출석, 개설과목고유번호, 시험지등록번호);
--1강의실
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-04-02', 30, 40, 30, 1, 1);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-05-03', 30, 40, 30, 2, 2);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-06-04', 30, 40, 30, 3, 3);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-07-07', 30, 40, 30, 4, 4);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 5, 5);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 6, 6);

--2강의실
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-04-09', 35, 45, 20, 7, 7);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-05-12', 35, 45, 20, 8, 8);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-06-14', 35, 45, 20, 9, 9);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 10, 10);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 11, 11);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 12, 12);

--3강의실
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-04-30', 40, 40, 20, 13, 13);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-05-28', 40, 40, 20, 14, 14);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-06-29', 40, 40, 20, 15, 15);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 16, 16);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 17, 17);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 18, 18);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 19, 19);

--4강의실
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-02-26', 40, 40, 20, 20, 20);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-03-31', 40, 40, 20, 21, 21);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-04-30', 40, 40, 20, 22, 22);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-05-31', 40, 40, 20, 23, 23);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-06-30', 40, 40, 20, 24, 24);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 25, 25);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 26, 26);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 27, 27);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 28, 28);

--5강의실
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-05-06', 35, 45, 20, 29, 29);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-06-03', 35, 45, 20, 30, 30);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-06-30', 35, 45, 20, 31, 31);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 32, 32);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 33, 33);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 34, 34);

--6강의실
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-05-31', 30, 40, 30, 35, 35);
INSERT INTO tblTest VALUES(testSeq.nextval, '2021-06-24', 30, 40, 30, 36, 36);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 37, 37);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 38, 38);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 39, 39);
INSERT INTO tblTest VALUES(testSeq.nextval, null, null, null, null, 40, 40);


select * from tblTest;

--[성적]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblScore (
     scoreSeq number NOT NULL,      -- 성적고유번호(PK)
     hasdwritingScore number NULL,  -- 필기점수
     practiceScore number NULL,     -- 실기점수
     attendanceScore number NULL,   -- 출결점수
     testSeq number NOT NULL        -- 시험고유번호(FK)
);

CREATE SEQUENCE scoreSeq;

ALTER TABLE tblScore 
    ADD CONSTRAINT PK_TBLSCORE PRIMARY KEY (scoreSeq);

ALTER TABLE tblScore 
    ADD CONSTRAINT FK_tblTest_TO_tblScore FOREIGN KEY (testSeq)
        REFERENCES tblTest (testSeq);

--성적
--INSERT INTO tblScore VALUES(scoreSeq.nextval, 필기, 실기, 출석, 시험고유번호);
--1강의실(30)명 
--1과목
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 28, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 35, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 40, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 32, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 1);

INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 30, 32, 28, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 35, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 40, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 26, 36, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 1);

INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 39, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 33, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 28, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 30, 40, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 30, 1);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 31, 30, 1);

--2과목

INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 28, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 35, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 40, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 26, 36, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 35, 30, 2);

INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 40, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 32, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 30, 32, 28, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 39, 30, 2);

INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 33, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 28, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 30, 40, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 30, 2);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 30, 2);

--3과목

INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 28, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 21, 35, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 19, 38, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 40, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 21, 38, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 32, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 25, 35, 30, 3);

INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 30, 32, 28, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 35, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 40, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 26, 36, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 24, 32, 30, 3);

INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 29, 38, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 21, 39, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 22, 33, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 28, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 30, 40, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 33, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 32, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 30, 3);
INSERT INTO tblScore VALUES(scoreSeq.nextval, 27, 34, 30, 3);

select * from tblScore;

--[시험문제]--------------------------------------------------------------------------------------------------------------

Drop table tblTestQuestion;
Drop SEQUENCE testQuestionSeq;

CREATE TABLE tblTestQuestion (
     testQuestionSeq number NOT NULL,           -- 시험문제 고유번호(PK)
     testQusetion varchar2(1000) NULL,          -- 시험문제
     answer varchar2(1000) NULL,                -- 답
     registrationStatusSeq number NOT NULL      -- 시험지등록번호(FK)
);

CREATE SEQUENCE testQuestionSeq;
    
ALTER TABLE tblTestQuestion
    ADD CONSTRAINT PK_TBLTESTQUESTION PRIMARY KEY (testQuestionSeq);


ALTER TABLE tblTestQuestion
    ADD CONSTRAINT FK_tblRegiStatus_tblQuestion FOREIGN KEY (registrationStatusSeq)
        REFERENCES tblRegistrationStatus (registrationStatusSeq);    

--시험문제
--INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 시험문제, 답, 시험지등록번호);

--1강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 1);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 2);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 123이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 2);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 2);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 2);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 3);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 3);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 3);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 3);

-- 아두이노를 활용한 임베디드 프로그래밍
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. ALU의 Full Name은 무엇인가?', 'Arthmetic Lojic Unit', 4);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. SoC(System On chip)에 대해 설명하시오', '하나의 집적회로에 집적된 컴퓨터나 전자 시스템 부품들을 가르킨다.', 4);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 임베디드란 무엇인가?', '임베디드란 PC이외의 장비에 사용되는 칩을 말한다.', 4);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 임베디드 시스템에는 어떤 프로세서 코어가 장착될수 있는지 설명하시오', '마이크로컨트롤러, DSP', 4);

--2강의실
--java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. 명시적인 형변환은 항상 안전하다.', 'X', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. 대입 연산자는 우선 순위가 가장 낮다.', 'O', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. float는 실수형이고, 4byte의 크기를 가진다.', 'X', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. int는 실수형이고, 8byte의 크기를 가진다.', 'O', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. long을 float로 형변환할 때 암시적인 형변환이 일어난다.', 'O', 7);

--오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 8);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 123이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 8);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 8);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 8);

--프론트엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. CSS 전처리(CSS preprocessors)설명과 장단점?','[장점]재사용성: 공통 요소를 변수 또는 함수, 믹스인으로 만들어 재사용할 수 있다.[단점] 전처리기를 위한 도구(컴파일러) 필요', 9);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. CSS Selector가 어떠한 원리로 동작하는지 설명', '브라우저는 선택자를 오른쪽 키 선택자부터 왼쪽으로 일치시킨다. 선택자에 따라 DOM의 요소를 필터링하고 부모요소를 검사해 일치하는지 본다.', 9);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. UI와 UX의 차이점을 설명해보세요.', 'UI: 사용자가 제품/서비스와 상호작용할 수 있도록 만들어진 매개체. UX:사용자가 만족할 수 있도록 사용자 중심적으로 설계된 디자인', 9);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. XSS(Cross-site scripting)를 설명해보세요.', '특정 javascript 구문을 client side에서 hacker가 원하는 시점에 실행시키는 공격이다.', 9);



--3강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 13);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 14);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 123이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 14);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 14);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 14);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 15);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 15);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 15);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 15);



--4강의실
--java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. 명시적인 형변환은 항상 안전하다.', 'X', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. 대입 연산자는 우선 순위가 가장 낮다.', 'O', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. float는 실수형이고, 4byte의 크기를 가진다.', 'X', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. int는 실수형이고, 8byte의 크기를 가진다.', 'O', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. long을 float로 형변환할 때 암시적인 형변환이 일어난다.', 'O', 20);

--오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 21);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 123이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 21);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 21);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 21);

--프론트엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. CSS 전처리(CSS preprocessors)설명과 장단점?','[장점]재사용성: 공통 요소를 변수 또는 함수, 믹스인으로 만들어 재사용할 수 있다.[단점] 전처리기를 위한 도구(컴파일러) 필요', 22);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. CSS Selector가 어떠한 원리로 동작하는지 설명', '브라우저는 선택자를 오른쪽 키 선택자부터 왼쪽으로 일치시킨다. 선택자에 따라 DOM의 요소를 필터링하고 부모요소를 검사해 일치하는지 본다.', 22);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. UI와 UX의 차이점을 설명해보세요.', 'UI: 사용자가 제품/서비스와 상호작용할 수 있도록 만들어진 매개체. UX:사용자가 만족할 수 있도록 사용자 중심적으로 설계된 디자인', 22);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. XSS(Cross-site scripting)를 설명해보세요.', '특정 javascript 구문을 client side에서 hacker가 원하는 시점에 실행시키는 공격이다.', 22);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 23);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 23);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 23);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 23);

-- 아두이노를 활용한 임베디드 프로그래밍
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. ALU의 Full Name은 무엇인가?', 'Arthmetic Lojic Unit', 24);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. SoC(System On chip)에 대해 설명하시오', '하나의 집적회로에 집적된 컴퓨터나 전자 시스템 부품들을 가르킨다.', 24);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 임베디드란 무엇인가?', '임베디드란 PC이외의 장비에 사용되는 칩을 말한다.', 24);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 임베디드 시스템에는 어떤 프로세서 코어가 장착될수 있는지 설명하시오', '마이크로컨트롤러, DSP', 24);


--5강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 29);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 30);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 123이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 30);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 30);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 30);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 31);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 31);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 31);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 31);


--6강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 35);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 36);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 123이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 36);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 36);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 36);

select * from tblTestQuestion;


--[수강신청]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblEnrollment (
     enrollmentSeq number NOT NULL,         -- 수강신청고유번호(PK)
     attendaceSeq number NOT NULL,          -- 출결고유번호(FK)
     counselingDiarySeq number NOT NULL,    -- 상담일지고유번호(FK)
     teacherSurveySeq number NOT NULL,      -- 교사평가고유번호(FK)
     scoreSeq number NOT NULL,              -- 성적고유번호(FK)
     courseSurveySeq number NOT NULL,       -- 강의평가고유번호(FK)
     openCourseSeq number NOT NULL,         -- 개설과정고유번호(FK)
     studentSeq number NOT NULL             -- 교육생고유번호(FK)
);

CREATE SEQUENCE enrollmentSeq;

ALTER TABLE tblEnrollment 
    ADD CONSTRAINT PK_TBLENROLLMENT PRIMARY KEY (enrollmentSeq);
  
ALTER TABLE tblEnrollment 
    ADD CONSTRAINT FK_tblAttendance_tblEnrollment FOREIGN KEY (attendaceSeq)
        REFERENCES tblAttendance (attendaceSeq);   
           
ALTER TABLE tblEnrollment 
    ADD CONSTRAINT FK_tblDiary_tblEnrollment FOREIGN KEY (counselingDiarySeq)
        REFERENCES tblCounselingDiary (counselingDiarySeq);

ALTER TABLE tblEnrollment 
    ADD CONSTRAINT FK_tblTSurvey_tblEnrollment FOREIGN KEY (teacherSurveySeq)
        REFERENCES tblTeacherSurvey (teacherSurveySeq);

ALTER TABLE tblEnrollment 
    ADD CONSTRAINT FK_tblScore_tblEnrollment FOREIGN KEY (scoreSeq)
        REFERENCES tblScore (scoreSeq);

ALTER TABLE tblEnrollment 
    ADD CONSTRAINT FK_tblCSurvey_tblEnrollment FOREIGN KEY (courseSurveySeq)
        REFERENCES tblCourseSurvey (courseSurveySeq);

ALTER TABLE tblEnrollment 
    ADD CONSTRAINT FK_tblOpenCourse_tblEnrollment FOREIGN KEY (openCourseSeq)
        REFERENCES tblOpenCourse (openCourseSeq);

ALTER TABLE tblEnrollment 
    ADD CONSTRAINT FK_tblStudent_TO_tblEnrollment FOREIGN KEY (studentSeq)
        REFERENCES tblStudent (studentSeq);

select * from tblEnrollment;

--[교육종료교육생]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblCompleteStudent (
     completeStudentSeq number NOT NULL,    -- 교육종료교육생고유번호(PK)
     name varchar2(15) NOT NULL,            -- 교육생이름
     completeDate date NOT NULL,            -- 수료날짜(중도탈락날짜)
     condition varchar2(15) NOT NULL,       -- 수료/중도탈락
     birthDate date NOT NULL,               -- 생년월일
     phoneNumber varchar2(15) NULL,         -- 전화번호
     enrollmentSeq number NOT NULL          -- 수강신청고유번호(FK)
);

CREATE SEQUENCE completeStudentSeq;

ALTER TABLE tblCompleteStudent 
    ADD CONSTRAINT PK_TBLCOMPLETESTUDENT PRIMARY KEY (completeStudentSeq);

ALTER TABLE tblCompleteStudent 
    ADD CONSTRAINT CK_TBLCOMPLETES_CONDITION CHECK(condition in ('중도탈락', '수료완료'));


select * from tblCompleteStudent;

--[취업현황]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblEmployment (
     employmentSeq number NOT NULL,         -- 취업현황고유번호(PK)
     companyName varchar2(20) NULL,         -- 회사명
     annualIncome number NULL,              -- 연봉
     area varchar2(50) NULL,                -- 근무지
     completeStudentSeq number NOT NULL     -- 교육종료교육생고유번호(FK)
);

CREATE SEQUENCE employmentSeq;

ALTER TABLE tblEmployment 
    ADD CONSTRAINT PK_TBLEMPLOYMENT PRIMARY KEY (employmentSeq);

ALTER TABLE tblEmployment 
    ADD CONSTRAINT FK_tblCompleteS_tblEmployment FOREIGN KEY (completeStudentSeq)
        REFERENCES tblCompleteStudent (completeStudentSeq);

select * from tblEmployment;

--[구인공고]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblJobPost (
     jobPostSeq number NOT NULL,            -- 구인공고 고유번호(PK)
     recruitField varchar2(20) NOT NULL,    -- 채용분야
     companyName varchar2(20) NOT NULL,     -- 회사명
     recruitBegin date NOT NULL,            -- 채용시작날짜
     recruitEnd date NOT NULL,              -- 채용종료날짜
     career varchar2(20) NOT NULL,          -- 경력
     educationLevel varchar2(20) NOT NULL,  -- 학력
     annualIncom number NOT NULL,           -- 연봉
     workArea varchar2(20) NOT NULL,        -- 근무지역
     workTime varchar2(20) NOT NULL,        -- 근무시간
     selectionCount number NOT NULL         -- 전형수
);

CREATE SEQUENCE jobPostSeq;

ALTER TABLE tblJobPost 
    ADD CONSTRAINT PK_TBLJOBPOST PRIMARY KEY (jobPostSeq);

ALTER TABLE tblJobPost
    ADD CONSTRAINT CK_TBLJOBPOST_EDUCATIONLEVEL CHECK(educationLevel in('고졸', '대졸', '전문대졸'));

select * from tblJobPost;

--[자격증]--------------------------------------------------------------------------------------------------------------

CREATE TABLE tblLicense (
     licenseSeq number NOT NULL,            -- 자격증고유번호(PK)
     name varchar2(15) NOT NULL,            -- 자격명
     licenseType varchar2(30) NOT NULL,     -- 자격증 종류
     testAgency varchar2(20) NOT NULL,      -- 시험기관
     round varchar2(15) NOT NULL,           -- 회차
     receptionFee number NOT NULL,          -- 접수비
     writtenRegisterBegin date NOT NULL,    -- 필기시험 원서접수 시작날짜
     writtenRegisterEnd date NOT NULL,      -- 필기시험 원서접수 종료날짜
     writtenTestDate date NOT NULL,         -- 필기시험 날짜
     writtenResultDate date NOT NULL,       -- 필기시험 합격자 발표 시작날짜
     submissionBegin date NOT NULL,         -- 응시자격 서류제출 시작날짜
     submissionEnd date NOT NULL,           -- 응시자격 서류제출 종료날짜
     practicalRegisterBegin date NOT NULL,  -- 실기시험 원서접수 시작날짜
     practicalRegisterEnd date NOT NULL,    -- 실기시험 원서접수 종료날짜
     practicalTestDate date NOT NULL,       -- 실기시험 날짜
     practicalResultDate date NOT NULL      -- 실기시험 합격자발표 날짜
);

CREATE SEQUENCE licenseSeq;

ALTER TABLE tblLicense
    ADD CONSTRAINT PK_TBLLICENSE PRIMARY KEY (licenseSeq);

ALTER TABLE tblLicense 
    ADD CONSTRAINT CK_TBLLICENSE_LICENSETYPE CHECK(licenseType in('국가기술자격', '국가전문자격','민간자격'));
    
select * from tblLicense;

