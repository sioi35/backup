-- q029.sql

--Q001
SELECT * FROM tblcountry;

--Q002
Select Name, Capital  From Tblcountry;

--Q003
SELECT NAME AS "[국가명]", CAPITAL AS "[수도명]", POPULATION AS "[인구수]", CONTINENT "[면적]", AREA AS "[대륙]" FROM TBLCOUNTRY;

--Q004
SELECT '국가명: ' || NAME || ', 수도명: ' || capital || ', 인구수: ' || population "[국가정보]"   FROM tblcountry;
SELECT CONCAT('국가명: ', NAME) || CONCAT(', 수도명: ', capital) || CONCAT(', 인구수: ', population)  AS "[국가정보]" FROM tblcountry;

--Q005
Select First_Name || ' ' || Last_Name As "[이름]", Email || '@GMAIL.COM' As "[이메일]", Phone_Number As"[연락처]",  '$' || Salary As "[급여]" From Employees;

--Q006
Select Name, Area From Tblcountry Where Area <= 100;

--Q007
Select Name, Continent From Tblcountry Where Continent In ('AS','EU');
Select * From Tblcountry Where Continent In ('AS','EU');

--Q008
Select First_Name || ' ' || Last_Name  As Name , Phone_Number From Employees Where Job_Id = 'IT_PROG';

--Q009
Select First_Name || ' ' || Last_Name  As Name , Phone_Number, Hire_Date From Employees Where Last_Name = 'Grant';

--Q010
Select First_Name || ' ' || Last_Name  As Name , Salary, Phone_Number  From Employees Where Manager_Id = 120;

--Q011
Select First_Name || ' ' || Last_Name  As Name ,  Phone_Number, Email, Department_Id From Employees Where Department_Id In(60, 80, 100);

--Q012
Select * From Tblinsa Where Buseo = '기획부';

--Q013
Select Name, Jikwi, Tel From Tblinsa Where City = '서울' And Jikwi = '부장';

--Q014
Select * From Tblinsa Where City = '서울' And  Basicpay + Sudang >= 1500000;

--Q015
Select * From Tblinsa Where Jikwi In ( '사원', '대리' ) And Sudang <= 150000;

--Q016
Select * From Tblinsa Where Jikwi In ('과장', '부장') And City In '서울' And Basicpay >=2000000;

--Q017
Select * From Tblcountry Where Name Like '_국'; -- 국가명 2글자
Select * From Tblcountry Where Name Like '%국'; -- 국가명 상관 x

--Q018
Select * From Employees Where Phone_Number Like '515%';

--Q019
Select * From Employees Where Job_Id Like 'SA%';

--Q020
Select * From Employees Where First_Name Like '%de%' Or First_Name Like '%De%'; -- 대소문자 상관없이??

--Q021
Select * From Tblinsa Where Ssn Like '%-1%'; 

--Q022
Select * From Tblinsa Where Ssn Like '%-2%'; 

--Q023
Select * From Tblinsa Where Ssn Like '__07%' Or Ssn Like '__08%' Or Ssn Like '__09%' ; 

--Q024
Select * From Tblinsa Where City In ('서울', '인천') And Name Like '김%';

--Q025
Select * From Tblinsa Where Buseo In ('영업부', '총무부', '개발부') And Jikwi In ('사원', '대리') And Tel Like('010%');

--Q026
Select * From Tblinsa Where City In ('서울', '인천', '경기') And Ibsadate Between '2008-01-01' And '2010-12-31';

--Q027
Select * From Employees Where Department_Id Is Null;

--Q028
Select Distinct Job_Id From Employees;

--Q029
Select Distinct Department_Id From Employees Where Hire_Date Between '2002-01-01' And '2004-12-31';

--Q030
Select Distinct Manager_Id From Employees Where  Salary >=5000 And Manager_Id Is Not Null;

--Q031
Select Distinct Jikwi From Tblinsa Where Ssn Like '8%-1%';  

--Q032
Select Distinct City From Tblinsa Where Sudang >= 200000;  

--Q033
Select Buseo From Tblinsa Where Tel Is Null;
Select Buseo, Name From Tblinsa Where Tel Is Null;
