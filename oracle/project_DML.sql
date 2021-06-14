--DML

/*
[3번]
7. 출결 관리 및 출결 조회 - (관리자, 교사 별, 교육생)
8. 구인공고 관리(조회)
9. 자격증 일정 관리(조회)
*/



--관리자
--M_007. 출결 관리 및 출결 조회
/*
[메인] > [관리자] > [출결 관리 및 출결 조회]

1. [전체 개설 과정]
  - 개설된 모든 과정의 정보를 출력한다.
    - 개설 과정 고유 번호
    - 과정명을 출력한다.
    - 과정 시작 날짜
    - 과정 종료 날짜
    - 강의실
    - 교사
    - 교육생등록인원
    - 개설과목등록여부

*/

select
    oc.openCourseSeq as 개설과정고유번호,
    tc.name as 과정명,
    oc.begindate as 과정시작날짜,
    oc.enddate as 과정종료날짜,
    cr.name as 강의실명,
    t.name as 교사명,
    oc.registercount as 교육생등록인원,    
    oc.registrationstatus as 개설과목등록여부
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on oc.totalCourseSeq = tc.totalCourseSeq
            inner join tblClassroom cr
                on cr.classroomSeq = oc.classroomSeq
                    inner join tblTeacher t
                        on oc.teacherSeq = t.teacherSeq;

/*

[메인] > [관리자] > [출결 관리 및 출결 조회] > [전체 개설 과정]

1.1 [특정 개설 과정의 전체 교육생]
  - 전체 교육생의 정보를 출력한다.
    - 교육생 고유 번호
    - 교육생 이름
    - 교육생 주민번호 뒷자리
    - 교육생 전화번호
    - 교육생 등록일

*/
--전체개설과정을 듣는 전체교육생정보 조회
select
    tc.name as 개설과정명,
    s.studentseq as 교육생고유번호,
    s.name as 교육생이름,
    s.ssn as 주민번호뒷자리,
    s.phonenumber as 전화번호,
    s.enrolldate as 등록일
from tblEnrollment e
    inner join tblOpenCourse oc
        on oc.openCourseSeq = e.openCourseSeq
            inner join tblTotalCourse tc
                on tc.totalcourseseq = oc.totalcourseseq
                    inner join tblStudent s
                        on s.studentSeq = e.studentSeq;

--특정개설과정 > 전체교육생정보
--3번 개설과정을 듣는 전체 교육생 정보 조회
select
    tc.name as 개설과정명, 
    s.studentseq as 교육생고유번호,
    s.name as 교육생이름,
    s.ssn as 주민번호뒷자리,
    s.phonenumber as 전화번호,
    s.enrolldate as 등록일
from tblEnrollment e
    inner join tblOpenCourse oc
        on oc.openCourseSeq = e.openCourseSeq
            inner join tblTotalCourse tc
                on tc.totalcourseseq = oc.totalcourseseq
                    inner join tblStudent s
                        on s.studentSeq = e.studentSeq
                            where oc.openCourseSeq = 3; -- 3번 개설과정

/*
[메인] > [관리자] > [출결 관리 및 출결 조회] > [전체 개설 과정] > [특정 개설 과정의 전체 교육생]

1.1.1 [특정 개설 과정의 특정 교육생 조회]
    - 특정 교육생의 전체 기간의 정보를 출력한다. 
      - 날짜
      - 근태 상태
*/
-- 특정 개설과정(3과정)을 듣는 특정 교육생(61번) 출결 조회
select
    tc.name as 개설과정명,
    s.name as 교육생이름,
    a.attendancedate as 출석날짜,
    a.condition as 근태상태
from tblEnrollment e
    inner join tblOpenCourse oc
        on oc.openCourseSeq = e.openCourseSeq
            inner join tblTotalCourse tc
                on tc.totalcourseseq = oc.totalcourseseq
                    inner join tblStudent s
                        on s.studentSeq = e.studentSeq
                            inner join tblAttendance a
                                on a.studentseq = s.studentseq
                                    where oc.openCourseSeq = 3 and s.studentseq = 61; -- 3번 개설과정
/*
[메인] > [관리자] > [출결 관리 및 출결 조회] > [전체 개설 과정] 
    > [특정 개설 과정의 전체 교육생] > [특정 개설 과정의 특정 교육생 조회]

1.1.1.1 [기간 검색]
      - 특정 교육생의 특정 기간의 출결 정보를 출력한다.
        - 날짜
        - 근태 상태
*/
-- 특정 개설과정(3과정)을 듣는 특정 교육생(61번)의 5월 달 출결 조회
select
    tc.name as 개설과정명,                
    s.name as 교육생이름,
    a.attendancedate as 출석날짜,
    a.condition as 근태상태
from tblEnrollment e
    inner join tblOpenCourse oc
        on oc.openCourseSeq = e.openCourseSeq
            inner join tblTotalCourse tc
                on tc.totalcourseseq = oc.totalcourseseq
                    inner join tblStudent s
                        on s.studentSeq = e.studentSeq
                            inner join tblAttendance a
                                on a.studentseq = s.studentseq
                                    where oc.openCourseSeq = 3 
                                        and s.studentseq = 61 
                                        and a.attendancedate between '21/05/01' and '21/05/31'; -- 3번 개설과정


/*
[메인] > [관리자] > [출결 관리 및 출결 조회] > [전체 개설 과정] 
    > [특정 개설 과정의 전체 교육생] > [특정 개설 과정의 특정 교육생 조회]
    
1.1.1.2 [날짜 검색]
      - 특정 교육생의 특정 날짜의 출결 정보를 출력한다.
        - 날짜
        - 입실시간
        - 퇴실시간
        - 근태 상태
*/
-- 특정 개설과정(3과정)을 듣는 특정 교육생(61번)의 특정날짜 출결 조회
select
    tc.name as 개설과정명,                
    s.name as 교육생이름,
    a.attendancedate as 출석날짜,
    a.intime as 입실시간,
    a.outtime as 퇴실시간,
    a.condition as 근태상태
from tblEnrollment e
    inner join tblOpenCourse oc
        on oc.openCourseSeq = e.openCourseSeq
            inner join tblTotalCourse tc
                on tc.totalcourseseq = oc.totalcourseseq
                    inner join tblStudent s
                        on s.studentSeq = e.studentSeq
                            inner join tblAttendance a
                                on a.studentseq = s.studentseq
                                    where oc.openCourseSeq = 3  -- 3번 개설과정
                                        and s.studentseq = 61   -- 교육생 고유번호 61번
                                        and a.attendancedate = '21-06-01'; -- 특정 날짜


/*
[메인] > [관리자] > [출결 관리 및 출결 조회] > [전체 개설 과정] 
    > [특정 개설 과정의 전체 교육생] > [특정 개설 과정의 특정 교육생 조회] > [날짜검색]
    
1.1.1.2.1 [출결 관리]
- 특정교육생의 특정날짜의 출결 정보를 수정, 추가, 삭제할 수 있다.
    - 출결 고유번호
    - 교육생 고유번호
    - 날짜
    - 입실/퇴실 시간
    - 근태상태

*/

select
    tc.name as 개설과정명,
    s.name as 교육생이름,
    a.attendancedate as 출석날짜,
    a.intime as 입실시간,
    a.outtime as 퇴실시간,
    a.condition as 근태상태
from tblEnrollment e
    inner join tblOpenCourse oc
        on oc.openCourseSeq = e.openCourseSeq
            inner join tblTotalCourse tc
                on tc.totalcourseseq = oc.totalcourseseq
                    inner join tblStudent s
                        on s.studentSeq = e.studentSeq
                            inner join tblAttendance a
                                on a.studentseq = s.studentseq
                                    where oc.openCourseSeq = 3 
                                        and s.studentseq = 61 
                                        and a.attendancedate = to_char(sysdate, 'yy-mm-dd'); -- 3번 개설과정


/*
[메인] > [관리자] > [출결 관리 및 출결 조회] > [전체 개설 과정] 
    > [특정 개설 과정의 전체 교육생] > [특정 개설 과정의 특정 교육생 조회] > [날짜검색] > [출결 관리]
-수정

update tblAttendance set
    AttendanceDate = 출결날짜, 
    inTime = 입실시간,
    outTime = 퇴실시간,
    condition = 근태상태
        where studentSeq = 학생고유번호;
*/
-- 특정교육생의 출결상태 수정 > 교육생의 입퇴실 시간을 확인하고 출결상태를 수정해준다.(당일)
select * from tblAttendance where AttendanceDate = to_char(sysdate, 'yy-mm-dd') and studentseq = 61 and condition = '기타';

update tblAttendance set
    condition = '정상'
        where AttendanceDate = to_char(sysdate, 'yy-mm-dd')
            and studentseq = 61
            and condition = '기타';

            
/*
[메인] > [관리자] > [출결 관리 및 출결 조회] > [전체 개설 과정] 
    > [특정 개설 과정의 전체 교육생] > [특정 개설 과정의 특정 교육생 조회] > [날짜검색] > [출결 관리]

-삭제

*/
--delete from tblAttendance where attendaceSeq = 출결고유번호;

delete from tblAttendance where studentSeq = 61 and atattendancedate = to_char(sysdate, 'yy-mm-dd');



--교사(교사번호1 채제원로 로그인했을때)
--T002. 출결 관리 및 출결 조회

/*
[메인] > [교사] > [출결 관리 및 출결 조회]

1 [담당 과정 조회]
  - 자신이 담당하고 있는 과정 조회
    - 담당 교사이름
    - 과정명
    - 과정 고유 번호
    - 과정 시작기간(년월일)
    - 과정 종료기간(년월일)
    - 강의실
    - 강의 진행 상태

*/

--1번선생님이 담당하고 있는 과정 조회
select 
    t.name as 교사명,
    t.teacherSeq as 교사고유번호,
    tc.name as 과정명,
    tc.totalcourseseq as 과정고유번호,
    oc.begindate as 과정시작날짜,
    oc.enddate as 과정종료날짜,
    cr.name as 강의실명,
    case
        when oc.enddate < to_char(sysdate, 'yy-mm-dd') then '강의종료'
        when oc.begindate > to_char(sysdate, 'yy-mm-dd') then '강의예정'
        else '강의중'
    end as 강의상태
from tblOpenCourse oc
    inner join tblTeacher t
        on oc.teacherSeq = t.teacherseq
            inner join tblTotalCourse tc
                on oc.totalCourseSeq = tc.totalCourseSeq
                    inner join tblClassroom cr
                        on oc.classroomSeq = cr.classroomSeq
                            where t.teacherseq = 1;



/*
[메인] > [교사] > [출결 관리 및 출결 조회] > [담당 과정 조회]

1.1 [출결 현황 조회]
  - 출결 현황을 확인할 기간을 입력한다.
    - 교육생 고유 번호
    - 교육생 이름
    - 교육생 번호
    - 교육생 출결 현황

*/

-- 자신이 담당하고 있는 특정 강의(1번과정)의 모든 교육생의 5월달 출결현황
select 
    t.name as 교사명,
    tc.name as 과정명,
    tc.totalcourseseq as 과정고유번호,
    s.name as 교육생이름,
    s.studentseq as 교육생고유번호,
    a.attendancedate as 날짜,
    a.condition as 출결상태
from tblOpenCourse oc
    inner join tblTeacher t
        on oc.teacherSeq = t.teacherseq
            inner join tblTotalCourse tc
                on oc.totalCourseSeq = tc.totalCourseSeq
                    inner join tblClassroom cr
                        on oc.classroomSeq = cr.classroomSeq
                            inner join tblEnrollment e
                                on e.openCourseSeq = oc.openCourseSeq
                                    inner join tblStudent s
                                        on s.studentSeq = e.studentSeq
                                            inner join tblAttendance a
                                                on a.studentSeq = s.studentSeq 
                                                    where t.teacherseq = 1  --1번 선생님
                                                        and tc.totalcourseseq = 1 -- 1번과정
                                                            and a.attendancedate between '21-05-01' and '21-05-31';

/*
[메인] > [교사] > [출결 관리 및 출결 조회] > [담당 과정 조회] > [출결 현황 조회]

1.1.1. [특정 교육생 출결 현황 조회]
  - 확인할 교육생의 번호를 입력한다.
      - 교육생 번호
      - 교육생 이름
      - 교육생 전화번호
      - 교육생 출결 현황

*/


-- 자신이 담당하고 있는 특정 강의(1번과정)의 특정 교육생(61번)의 전체 출결현황 조회

select 
    t.name as 교사명,
    tc.name as 과정명,
    s.name as 교육생이름,
    s.studentseq as 교육생고유번호,
    s.phonenumber as 전화번호,
    a.attendancedate as 날짜,
    a.condition as 출결상태
from tblOpenCourse oc
    inner join tblTeacher t
        on oc.teacherSeq = t.teacherseq
            inner join tblTotalCourse tc
                on oc.totalCourseSeq = tc.totalCourseSeq
                    inner join tblClassroom cr
                        on oc.classroomSeq = cr.classroomSeq
                            inner join tblEnrollment e
                                on e.openCourseSeq = oc.openCourseSeq
                                    inner join tblStudent s
                                        on s.studentSeq = e.studentSeq
                                            inner join tblAttendance a
                                                on a.studentSeq = s.studentSeq 
                                                    where t.teacherseq = 1  --1번 선생님
                                                        and tc.totalcourseseq = 1 -- 1번과정
                                                            and s.studentseq = 61;


--교육생(61번 모세심 로그인)
--2. 출결 관리 및 출결 조회

/*

[메인] > [교육생] > [출결 관리 및 출결 조회] 

1. [수강 과정 조회] 
- 자신이 수강하고 있는 과정정보를 출력한다.
    - 교육생이름
    - 과정명
    - 과정시작날짜
    - 과정종료날짜
    - 교사명
    - 강의실명
*/

-- 61번 교육생이 수강하고 있는 과정정보 조회.
select
    s.name as 교육생이름,
    tc.name as 과정명,
    oc.begindate as 과정시작날짜,
    oc.enddate as 과정종료날짜,
    t.name as 교사명,
    cr.name as 강의실명
from tblEnrollment e
    inner join tblStudent s
        on s.studentseq = e.studentseq
            inner join tblOpenCourse oc
                on oc.openCourseSeq = e.openCourseSeq
                    inner join tblTotalCourse tc
                        on tc.totalcourseseq = oc.totalcourseseq
                            inner join tblTeacher t
                                on oc.teacherseq = t.teacherseq
                                    inner join tblClassroom cr
                                        on cr.classroomSeq = oc.classroomSeq
                                            where s.studentseq = 61;
           

/*

[메인] > [교육생] > [출결 관리 및 출결 조회] > [수강 과정 조회] 

 1.1 [출결 조회]
-자신이 현재 수강하고 있는 과정에 대한 자신의 출결현황 조회한다.
   - 과정번호 출력
   - 과정명 출력
   - 과정기간 출력
   - 출결날짜  
   - 출결 상황 출력

*/
--모세심교육생이 자신이 수강하고 있는 과정에 대한 자신의 출결상태 조회
select
    s.name as 교육생이름,
    a.attendancedate as 날짜,
    a.condition as 출결상태
from tblEnrollment e
    inner join tblStudent s
        on s.studentseq = e.studentseq
            inner join tblOpenCourse oc
                on oc.openCourseSeq = e.openCourseSeq
                    inner join tblTotalCourse tc
                        on tc.totalcourseseq = oc.totalcourseseq
                            inner join tblTeacher t
                                on oc.teacherseq = t.teacherseq
                                    inner join tblClassroom cr
                                        on cr.classroomSeq = oc.classroomSeq
                                            inner join tblAttendance a
                                                on a.studentseq = s.studentseq
                                                    where s.studentseq = 61;
/*
[메인] > [교육생] > [출결 관리 및 출결 조회] > [수강 과정 조회] > [출결 조회]

1.1.1  [월별 확인]
    - 자신의 월별 출결상태를 확인할 수 있다.
    - 확인할 기간 선택
        - 과정번호 출력 
        - 과정명 출력 
        - 출결일 출력 
        - 근태 상황 출력
*/
--모세심교육생이 자신이 수강하고 있는 과정에 대한 자신의 월별 출결상태 조회
select
    s.name as 교육생이름,
    a.attendancedate as 날짜,
    a.condition as 출결상태
from tblEnrollment e
    inner join tblStudent s
        on s.studentseq = e.studentseq
            inner join tblOpenCourse oc
                on oc.openCourseSeq = e.openCourseSeq
                    inner join tblTotalCourse tc
                        on tc.totalcourseseq = oc.totalcourseseq
                            inner join tblTeacher t
                                on oc.teacherseq = t.teacherseq
                                    inner join tblClassroom cr
                                        on cr.classroomSeq = oc.classroomSeq
                                            inner join tblAttendance a
                                                on a.studentseq = s.studentseq
                                                    where s.studentseq = 61 and a.attendancedate between '21-05-01' and '21-05-31';
   

/*
1.1.2. [날짜별 확인]
  - 자신의 특정 날짜의 출결상태를 확인할 수 있다..
  - 조회할 시작기간 입력(년/월/일)
  - 과정번호 출력 
  - 과정명 출력 
  - 출결일 출력 
  - 근태 상황 출력

*/
--모세심교육생이 자신이 수강하고 있는 과정에 대한 자신의 특정날짜에(2021-05-06) 대한 출결상태 조회
select
    s.name as 교육생이름,
    a.attendancedate as 날짜,
    a.condition as 출결상태
from tblEnrollment e
    inner join tblStudent s
        on s.studentseq = e.studentseq
            inner join tblOpenCourse oc
                on oc.openCourseSeq = e.openCourseSeq
                    inner join tblTotalCourse tc
                        on tc.totalcourseseq = oc.totalcourseseq
                            inner join tblTeacher t
                                on oc.teacherseq = t.teacherseq
                                    inner join tblClassroom cr
                                        on cr.classroomSeq = oc.classroomSeq
                                            inner join tblAttendance a
                                                on a.studentseq = s.studentseq
                                                    where s.studentseq = 61
                                                        and a.attendancedate = '21-05-06';




/*

[메인] > [교육생] > [출결 관리 및 출결 조회] > [수강 과정 조회] 

1.2[출결 체크(입력)]
 - 당일 출퇴근 시간을 입력한다.  
*/

-- 입실체크(당일)-- 퇴실시간은 null, 출결상태는 기타 
INSERT INTO tblAttendance (attendanceSeq, AttendanceDate, inTime, outTime, condition, studentSeq) values (attendanceSeq.nextVal, to_char(sysdate,'yy-mm-dd'), to_char(sysdate, 'hh24:mi'), null, '기타', 61);
delete from tblAttendance where attendanceseq = 2072; 

--퇴실체크(당일)
update tblAttendance set
    outTime =  to_char(sysdate, 'hh24:mi')
        where AttendanceDate = to_char(sysdate, 'yy-mm-dd')
            and studentseq = 61
            and condition = '기타';

select * from tblAttendance where AttendanceDate = to_char(sysdate, 'yy-mm-dd') and studentSeq =  61;


--관리자
--M_008. 구인공고 관리(조회)

/*
[메인] > [관리자] > [구인공고 관리] 

1. [전체 구인공고 조회]
- 구인공고 목록 출력한다.
    - 공고번호
    - 회사명
    - 채용분야
    - 채용 시작 날짜
    - 채용 종료 날짜

*/

-- 전체 구인공고목록 조회
select 
    jobpostseq as 공고번호,
    companyname as 회사명,
    recruitfield as 채용분야,
    recruitbegin as 채용시작날짜,
    recruitend as 채용종료날짜
from tblJobPost;


/*
[메인] > [관리자] > [구인공고 관리] > [전체 구인공고 조회]

1.1. [특정 구인공고 조회]
      - 특정 구인공고 정보 출력한다.
        - 회사명
        - 채용분야
        - 경력
        - 학력
        - 연봉
        - 근무지역
        - 근무일시
        - 전형절차 수
*/
--특정 구인공고(1번)에 대한 상세정보 출력한다
select 
    companyname as 회사명,
    recruitfield as 채용분야,
    career as 경력,
    educationlevel as 학력,
    annualincom as 연봉,
    workarea as 근무지역,
    worktime as 근무일시,
    selectioncount as 전형수
from tblJobPost 
    where jobpostseq = 1;

/*
[메인] > [관리자] > [구인공고 관리] > [전체 구인공고 조회] > [특정 구인공고 조회]

  1.2 [특정 구인공고 수정]
      - 특정 구인 공고 정보 수정한다.
        - 회사명
        - 채용분야
        - 채용 시작 날짜
        - 채용 종료 날짜
        - 경력
        - 학력
        - 연봉
        - 근무지역

*/
--특정 구인공고(1번)에 대한 상세정보 수정한다
/*
update tblJobPost set
    companyName = '회사명',
    recruitField = '분야',
    recruitBegin = '채용시작날짜',
    recruitEnd = '채용 종료날짜',
    career = '경력',
    educationLevel = '학력',
    annualIncom = 연봉,
    workArea = '근무지'
    where j.jobpostseq = 1;
*/
update tblJobPost set
    companyName = '로지올'
   where jobpostseq = 1;
 
/*
[메인] > [관리자] > [구인공고 관리] > [전체 구인공고 조회] > [특정 구인공고 조회]

1.3 [특정 구인공고 삭제]
      - 특정 구인 공고 정보 삭제한다.
- 해당 구인공고 정보는 테이블에서 제거된다.

*/
delete from tblJobPost where jobpostseq = 17;

   
 /*
[메인] > [관리자] > [구인공고 관리]
 
 2 [구인공고 추가]
    - 구인공고 정보 입력한다.
- 공고번호
        - 회사명
        - 채용분야
        - 채용 시작 날짜
        - 채용 종료 날짜
        - 경력
        - 학력
        - 연봉
        - 근무지역
        - 근무일시
        - 전형절차 수

 */
--구인공고 추가
-- 구인공고고유번호, 분야, 회사명, 채용시작날짜, 채용종료날짜, 경력, 학력, 연봉, 근무지역, 근무일시, 전형수
INSERT INTO tblJobPost (jobPostSeq, recruitField, companyName, recruitBegin, recruitEnd, career, educationLevel, annualIncom, workArea, workTime, selectionCount) values (jobPostSeq.nextVal, 'IT', '쌍용', '2021/06/03', '2021/06/30', '신입', '대졸/전문대졸', '면접시 협의', '서울', '판교', '3');

--교육생
--S_003 구인공고 조회

/*
[메인] > [교육생] > [구인공고 조회] 

1. [전체 구인공고 조회]
- 구인공고 목록 출력한다.
    - 공고번호
    - 회사명
    - 채용분야
    - 채용 시작 날짜
    - 채용 종료 날짜
*/
-- 전체 구인공고목록 조회
select 
    jobpostseq as 공고번호,
    companyname as 회사명,
    recruitfield as 채용분야,
    recruitbegin as 채용시작날짜,
    recruitend as 채용종료날짜
from tblJobPost;
/*
[메인] > [교육생] > [구인공고 조회] > [전체 구인공고 조회]

1.1. [특정 구인공고 조회]
  - 특정 구인공고 정보 출력한다.
    - 회사명
    - 채용분야
    - 경력
    - 학력
    - 연봉
    - 근무지역
    - 근무일시
    - 전형절차 수
*/
select 
    companyname as 회사명,
    recruitfield as 채용분야,
    career as 경력,
    educationlevel as 학력,
    annualincom as 연봉,
    workarea as 근무지역,
    worktime as 근무일시,
    selectioncount as 전형수
from tblJobPost
    where jobpostseq = 1;



--관리자
--M00_9. 자격증 일정관리

/*
[메인] > [관리자] > [자격증 일정 관리]

1. [전체 자격증 목록 조회]
- 전체 자격증 목록을 출력한다.
    - 자격증 고유번호
    - 자격증 명
    - 자격 종류
    - 시행기관
*/

select * from tblLicense;

--전체 자격증 목록 출력한다.
select 
    licenseSeq as 자격증고유번호,
    name as 자격증명,
    licenseType as 자격종류,
    testAgency as 시행기관    
from tblLicense;


/*
[메인] > [관리자] > [자격증 일정 관리] > [전체 자격증 목록 조회]

1.1 [특정 자격증 정보]
    - 특정 자격증 정보를 출력한다.
        - 자격증 고유번호
        - 자격명
        - 시행기관
        - 회차
        - 접수비
        - 필기시험 원서접수 시작날짜
        - 필기시험 원서접수 종료날짜
        - 필기시험 날짜
        - 필기시험 합격자발표 날짜
        - 응시자격 서류제출 시작날짜
        - 응시자격 서류제출 종료날짜
        - 실기시험 원서접수 시작날짜
        - 실기시험 원서접수 종료날짜
        - 실기시험 날짜
        - 합격자발표 날짜

*/
--특정자격증(1번)에 대한 상세 정보 출력
select 
    licenseSeq as 자격증고유번호,
    name as 자격증명,
    licenseType as 자격종류,
    testAgency as 시행기관,
    round as 회차,
    receptionfee as 접수비,
    writtenregisterbegin as 필기접수시작일,
    writtenregisterend as 필기접수종료일,
    writtentestdate as 필기시험날짜,
    writtenresultdate as 필기합격자발표일,
    practicalRegisterBegin as 실기접수시작일,
    practicalRegisterEnd as 실기원서종료일,
    practicalTestDate as 실기시험날짜,
    practicalResultDate as 실기합격자발표일
from tblLicense
    where licenseSeq = 1;

/*
[메인] > [관리자] > [자격증 일정 관리] > [전체 자격증 목록 조회] > [특정 자격증 정보]

 1.1.1. [자격증 정보 수정]
  - 특정 자격증을 선택한다.
  - 변경할 내용 입력
- 자격명
   - 시행기관
   - 회차
   - 접수비
   - 필기시험 원서접수 시작날짜
   - 필기시험 원서접수 종료날짜
   - 필기시험 날짜
   - 필기시험 합격자발표 날짜
   - 응시자격 서류제출 시작날짜
   - 응시자격 서류제출 종료날짜
   - 실기시험 원서접수 시작날짜
   - 실기시험 원서접수 종료날짜
   - 실기시험 날짜
   - 합격자발표 날짜

update tblLicense set
    name = '자격증명',
    licenseType = '자격종류',
    --..
    where j.jobpostseq = 1;
*/

    
update tblLicense set
    name = '정보관리기술사',
    licenseType = '국가기술자격'
    --..
    where licenseSeq = 1;


/*
[메인] > [관리자] > [자격증 일정 관리]

2. [자격증 목록 추가]
    - 자격증 고유번호
    - 자격명
    - 시행기관
    - 회차
    - 접수비
    - 필기시험 원서접수 시작날짜
    - 필기시험 원서접수 종료날짜
    - 필기시험 날짜
    - 필기시험 합격자발표 날짜
    - 응시자격 서류제출 시작날짜
    - 응시자격 서류제출 종료날짜
    - 실기시험 원서접수 시작날짜
    - 실기시험 원서접수 종료날짜
    - 실기시험 날짜
    - 합격자발표 날짜

*/
-- 자격증 추가
INSERT INTO tblLicense (licenseSeq, name, licenseType, testAgency, round, receptionFee, writtenRegisterBegin, writtenRegisterEnd, writtenTestDate, writtenResultDate, practicalRegisterBegin, practicalRegisterEnd, practicalTestDate, practicalResultDate) values (licenseSeq.nextVal, '정보관리기술사', '국가기술자격', '한국산업인력공단', '125회', '67800', '2021/07/06', '2021/07/09', '2021/07/31', '2021/09/10', '2021/09/13', '2021/09/16', '2021/10/16 ~ 2021/10/26', '2021/11/12');


/*
[메인] > [관리자] > [자격증 일정 관리] > [전체 자격증 목록 조회] > [특정 자격증 정보]

3. [자격증 정보 삭제]
- 선택한 자격증의 데이터를 모든 테이블에서 삭제한다.

*/
-- 특정 자격증 정보 삭제
delete from tblLicense where licenseSeq = 1;


--교육생
--S_004. 자격증 일정 조회

/*
[메인] > [교육생] > [자격증 일정 조회]

1. [전체 자격증 목록 조회]
- 전체 자격증 목록을 출력한다.
    - 자격증 고유번호
    - 자격증 명
    - 자격 종류
    - 시행기관
*/

select * from tblLicense;

--전체 자격증 목록 출력한다.
select 
    licenseSeq as 자격증고유번호,
    name as 자격증명,
    licenseType as 자격종류,
    testAgency as 시행기관    
from tblLicense;


/*
[메인] > [교육생] > [자격증 일정 조회] > [전체 자격증 목록 조회]

1.1 [특정 자격증 정보]
    - 특정 자격증 정보를 출력한다.
        - 자격증 고유번호
        - 자격명
        - 시행기관
        - 회차
        - 접수비
        - 필기시험 원서접수 시작날짜
        - 필기시험 원서접수 종료날짜
        - 필기시험 날짜
        - 필기시험 합격자발표 날짜
        - 응시자격 서류제출 시작날짜
        - 응시자격 서류제출 종료날짜
        - 실기시험 원서접수 시작날짜
        - 실기시험 원서접수 종료날짜
        - 실기시험 날짜
        - 합격자발표 날짜

*/
--특정자격증(1번)에 대한 상세 정보 출력
select 
    licenseSeq as 자격증고유번호,
    name as 자격증명,
    licenseType as 자격종류,
    testAgency as 시행기관,
    round as 회차,
    receptionfee as 접수비,
    writtenregisterbegin as 필기접수시작일,
    writtenregisterend as 필기접수종료일,
    writtentestdate as 필기시험날짜,
    writtenresultdate as 필기합격자발표일,
    practicalRegisterBegin as 실기접수시작일,
    practicalRegisterEnd as 실기원서종료일,
    practicalTestDate as 실기시험날짜,
    practicalResultDate as 실기합격자발표일
from tblLicense
    where licenseSeq = 1;

commit;


select
    tc.totalcourseseq as 과정고유번호, 
    tc.name as 과정명,
    oc.endDate as 종료날짜
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on tc.totalCourseSeq = oc.totalCourseSeq
    where oc.endDate < to_char(sysdate, 'yy-mm-dd');



select 
    e.enrollmentseq as 수강신청번호,
    oc.begindate as 과정시작기간,
    oc.endDate as 과정종료기간,
    s.name as 교육생이름,
    s.condition as 중도탈락여부,
    s.dropdate as 중도탈락날짜
from tblEnrollment e
    inner join tblStudent s
        on e.studentseq = s.studentseq
            inner join tblEnrollment e
                on s.studentseq = e.studentseq
                    inner join tblOpenCourse oc
                        on oc.opencourseseq = e.opencourseseq
                            where oc.endDate = '21-08-13';

select 
    e.enrollmentseq,
    oc.begindate,
    oc.endDate,
    s.name,
    s.condition,
    s.dropdate
from tblEnrollment e
    inner join tblStudent s
        on e.studentseq = s.studentseq
            inner join tblEnrollment e
                on s.studentseq = e.studentseq
                    inner join tblOpenCourse oc
                        on oc.opencourseseq = e.opencourseseq
                            where oc.endDate = '21-08-13';
        



