--question.sql 

------------조인
-- 33. employees, departments. 사원들의 이름, 부서번호, 부서명을 가져오시오.
--O
select * from employees;
select * from departments;

select
    e.first_name || ' ' ||e.last_name as 이름,
    e.department_id as 부서번호, 
    d.department_name as 부서명
from employees e
    inner join departments d
        on e.department_id = d.department_id;


-- 34. employees, jobs. 사원들의 정보와 직위명을 가져오시오.
--O
select * from employees;
select * from jobs;

select 
    e.*,
    j.job_title
from employees e
    inner join jobs j
        on e.job_id =j.job_id;


-- 35. employees, jobs. 직무(job_id)별 최고급여(max_salary) 받는 사원 정보를 가져오시오.
--O??

select * from employees;
select * from jobs;

select job_id, count(*) from employees group by job_id;

select 
    e.*
from employees e
    inner join jobs j
        on e.salary = j.max_salary 
    where e.job_id = j.job_id;

-- 36. departments, locations. 모든 부서와 각 부서가 위치하고 있는 도시의 이름을 가져오시오.
--O
select * from departments;
select * from locations;

select
    d.department_name as 부서,
    l.street_address as 도시
from departments d
    left outer join locations l
    --inner join locations l
        on l.location_id = d.location_id;


-- 37. locations, countries. location_id 가 2900인 도시가 속한 국가 이름을 가져오시오.
--O
select * from locations;
select * from countries;

select 
    c.country_name
from locations l
    inner join countries 
        on l.country_id = c.country_id 
    where l.location_id = 2900;


-- 38. employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.
--O 조인X

select * from employees;

select job_id from employees where salary >=12000 group by job_id;
select first_name, department_id from employees where job_id in ('AC_MGR', 'AD_VP', 'FI_MGR', 'SA_MAN', 'MK_MAN', 'AD_PRES');

select
    e.first_name || ' ' ||e.last_name as 이름,
    e.department_id as 부서번호, 
    e.salary
from employees e 
    where department_id in (select department_id from employees where salary >= 12000 group by department_id);


-- 39. employees, departments. locations.  'Seattle'에서(LOC) 근무하는 사원의 이름, 직위, 부서번호, 부서이름을 가져오시오.
--O
select * from employees;
select * from departments;
select * from locations;

select 
    e.first_name || ' ' || e.last_name name,
    d.department_id,
    d.department_name
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id 
            where l.city = 'Seattle';

-- 40. employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.
--O
select * from employees;
select * from departments;

select 
    department_id
from employees where first_name = 'Jonathon';


select 
    *
from employees
    where department_id= (select department_id from employees where first_name = 'Jonathon'); 


-- 41. employees, departments. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 출력하는데 월급이 3000이상인 사원을 가져오시오.
--O
select * from employees;
select * from departments;

select 
    e.first_name || ' ' || e.last_name name,
    d.department_name, 
    e.salary
from employees e
    inner join departments d
        on e.department_id = d.department_id 
    where e.salary >= 3000;


-- 42. employees, departments. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름, 월급을 가져오시오.
--O
select * from employees;
select * from departments;

select 
    e.first_name || ' ' || e.last_name name,
    e.department_id,
    d.department_name, 
    e.salary
from employees e
    inner join departments d
        on e.department_id = d.department_id
    where d.department_id = 10;



-- 43. employees, departments. 모든 부서의 정보를 가져오되 부서장이 있는 부서는 부서장의 정보도 같이 가져오시오.
--O
select * from employees;
select * from departments;

select 
    *
from departments d left outer join employees e 
on e.employee_id = d.manager_id;


-- 44. departments, job_history. 퇴사한 사원의 입사일, 퇴사일, 근무했던 부서 이름을 가져오시오.
--O
select * from departments;
select * from job_history;

select 
    h.department_id,
    h.start_date,
    h.end_date,
    d.department_name
from departments d
     inner join job_history h
        on d.department_id = h.department_id;
    


-- 45. employees. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 
--     각각의 컬럼명을 '사원번호', '사원이름', '관리자번호', '관리자이름'으로 하여 가져오시오.
--O

select * from employees;

select 
    e.employee_id as 사원번호,
    e.first_name || ' ' || e.last_name as 사원번호,
    e.manager_id as 관리자번호,
    em.first_name || ' ' || e.last_name as 관리자이름
from employees e
    inner join employees em
        on e.manager_id = em.employee_id
            order by e.employee_id ;


-- 46. employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오. 년도를 기준으로 오름차순 정렬.
--O
select * from employees;
select * from jobs;


            
select
    e.hire_date,avg(salary)
from hr.employees e 
    inner join hr.jobs j
        on e.job_id = j.job_id
    where j.job_title = 'Sales Manager'
        group by e.hire_date
            order by e.hire_date;



-- 47. employees, departments. locations. 
-- 각 도시(city)에 있는 모든 부서 사원들의 평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 사원수를 가져오시오. 
-- 단, 도시에 근 무하는 사원이 10명 이상인 곳은 제외하고 가져오시오.
--O
select * from employees;
select * from departments;
select * from locations;


select l.city, round(avg(e.salary),1), count(*) from hr.employees e inner join hr.departments d
on e.department_id =d.department_id
inner join hr.locations l
on d.location_id =l.location_id
group by l.city
having count(*) <10
order by round(avg(e.salary),1);




-- 48. employees, jobs, job_history. 
-- ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 가져오시오. 
--현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 말것
--O
select * from employees;
select * from jobs;
select * from job_history;

select
    e.first_name || ' ' || e.last_name,
    e.employee_id
from job_history h
    inner join employees e
        on h.employee_id = e.employee_id 
    where h.job_id = (select job_id from jobs where job_title = 'Public Accountant');


-- 49. employees, departments, locations. 커미션을 받는 모든 사람들의 first_name, last_name, 부서명, 지역 id, 도시명을 가져오시오.

select * from employees;
select * from departments;
select * from locations;

select 
    e.first_name || ' ' || e.last_name,
    d.department_name,
    d.location_id,
    l.city
from employees e
    left outer join departments d
        on e.department_id = d.department_id
            left outer join locations l
                on d.location_id = l.location_id
        where e.commission_pct > 0;



-- 50. employees. 자신의 매니저보다 먼저 고용된 사원들의 first_name, last_name, 고용일을 가져오시오.

select 
    e.first_name || ' ' || e.last_name as name,
    e.hire_date
from employees e
    inner join employees em
        on e.manager_id = em.employee_id
    where e.hire_date < em.hire_date
        order by e.employee_id;

-- 51. employees. 매니저로 근무하는 사원이 총 몇명인가?

select count(*)
from employees
where employee_id in (select distinct(manager_id) from HR.employees);


-- 52. employees. 자신의 매니저보다 연봉(salary)를 많이 받는 사원들의 성(last_name)과 연봉(salary)를 가져오시오.
--? 답이없음
select 
    e.first_name || ' ' || e.last_name as name,
    e.salary
from employees e
    inner join employees em
        on e.manager_id = em.employee_id
    where e.salary > em.salary;



-- 53. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.
select * from employees;


select count(*),
count(case 
    when substr(hire_date,1,2)=03 then 1
end) as "2003",
count(case 
    when substr(hire_date,1,2)=04 then 1
end) as "2004",
count(case 
    when substr(hire_date,1,2)=05 then 1
end) as "2005",
count(case 
    when substr(hire_date,1,2)=06 then 1
end) as "2006"
from HR.employees;

-- 54. employees, departments. 2007년에 입사(hire_date)한 사원들의 사번(employee_id), 이름(first_name), 성(last_name), 부서명(department_name)을 가져오시오.
-- 단, 부서에 배치되지 않은 사원은 'Not Assigned'로 가져오시오.
select * from employees;
select * from departments;

select 
    e.employee_id,
    e.first_name || ' ' || e.last_name as name,
    case
        when e.department_id is null then 'Not Assigned'
        when e.department_id is not null then d.department_name
    end as 부서명
from employees e
    left outer join departments d
        on e.department_id = d.department_id
    where to_char(e.hire_date, 'yy') = 07;


-- 55. employees. 직업이 'AD_PRESS' 인 사람은 A 등급을, 'ST_MAN' 인 사람은 B 등급을, 'IT_PROG' 인 사람은 C 등급을, 'SA_REP' 인 사람은 D 등급을, 'ST_CLERK' 인 사람은 E 등급을 기타는 0 을 부여하여 가져오시오.

select employee_id,
case
    when job_id = 'AD_PRESS' then 'A'
    when job_id = 'ST_MAN' then 'B'
    when job_id = 'IT_PROG' then 'C'
    when job_id = 'SA_REP' then 'D'
    when job_id = 'ST_CLERK' then 'E'
    else '0'
end as "RANK"
from HR.employees
order by employee_id;


-- 56. employees, jobs. 업무명(job_title)이 ‘Sales Representative’인 사원 중에서
-- 연봉(salary)이 9,000이상, 10,000 이하인 사원들의 이름(first_name), 성(last_name)과 연봉(salary)를 가져오시오.

select * from employees;
select * from jobs;

select 
    e.first_name,
    e.last_name,
    e.salary
from employees e
    inner join jobs j
        on e.job_id = j.job_id
        where j.job_title = 'Sales Representative' and e.salary between 9000 and 10000;


-- 57. employees, departments. 부서별로 가장 적은 급여를 받고 있는 사원의 이름, 부서이름, 급여를 가져오시오. 
-- 이름은 last_name만 가져오고, 부서이름으로 오름차순 정렬하고, 부서가 같은 경우 이름을 기준 으로 오름차순 정렬하여 가져오시오. 
--O

select 
    e.last_name, d.department_name, e.salary
from employees e 
    inner join departments d 
        on e.department_id = d.department_id
        where (e.department_id, e.salary) in (select department_id, min(salary) from employees group by department_id) order by d.department_name, e.last_name;;


select e.last_name, d.department_name, e.salary
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
where (e.department_id, e.salary) in (select e.department_id,min(e.salary) from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
group by e.department_id)
order by d.department_name, e.last_name;




-- 58. employees, departments, locations. 사원의 부서가 속한 도시(city)가 ‘Seattle’인 사원의 이름, 해당 사원의 매니저 이름, 사원 의 부서이름을 가져오시오. 
-- 이때 사원의 매니저가 없을 경우 ‘없음’이라고 가져오시오. 이름은 last_name만 가져오고, 사원의 이름을 오름차순으로 정렬하시오.
--XX??
select 
    e.first_name || ' ' || e.last_name name,
    d.department_name
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id
            where l.city = 'Seattle';
            
            
            
select * from employees;
select * from departments;
select * from locations;


select e.last_name,
case
    when e2.last_name is null then '없음'
    else e2.last_name
end,
(select department_name from hr.departments where department_id= e.department_id)
from hr.employees e left outer join hr.employees e2
on e.manager_id = e2.employee_id
where e.department_id in (select department_id from hr.departments
where location_id =(select location_id from hr.locations where city = 'Seattle'))
order by e.last_name;







-- 59. employees, jobs. 각 업무(job) 별로 연봉(salary)의 총합을 구하고자 한다. 
-- 연봉 총합이 가장 높은 업무부터 업무명(job_title)과 연봉 총합을 가져오시오. 단 연봉총합이 30,000보다 큰 업무만 가져오시오.
--XX
select
    e.job_id as a,
    sum(salary) as b
from employees e
    inner join jobs j
        on e.job_id = j.job_id
        group by e.job_id
            having sum(salary) > 30000
        order by sum(salary) desc;
    
select j2.job_title, t.sum
from (select e.job_id as job, sum(e.salary) as sum 
    from hr.employees e left outer join hr.jobs j
        on e.job_id =j.job_id
            group by e.job_id
                having sum(e.salary) > 30000) t 
                    left outer join hr.jobs j2
                        on t.job= j2.job_id
                            order by t.sum desc;




-- 60. employees, departments, locations, jobs. 
--각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 업무명(job_title), 부서 명(department_name)을 가져오시오.
--단 도시명(city)이 ‘Seattle’인 지역(location)의 부서 (department)에 근무하는 사원을 사원번호 오름차순으로 가져오시오.

select * from employees;
select * from departments;
select * from jobs;
select * from locations;


select
    e.employee_id,
    e.first_name,
    j.job_title,
    d.department_name
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join jobs j
                on j.job_id = e.job_id
                    inner join locations l
                        on d.location_id = l.location_id
                    where l.city = 'Seattle'
                        order by e.employee_id;
                

-- 61. employees. 2001~20003년사이에 입사한 사원의 이름(first_name), 입사일(hire_date), 관리자사번 (employee_id), 관리자 이름(fist_name)을 가져오시오.
-- 단, 관리자가 없는 사원정보도 결과에 포함시켜 가져오시오.

select 
    e.first_name,
    e.hire_date,
    em.employee_id,
    em.first_name
from employees e
    left outer join employees em
        on e.manager_id = em.employee_id
        where to_char(e.hire_date, 'yyyy') between 2001 and 2003;



-- 62. employees, departments. ‘Sales’ 부서에 속한 사원의 이름(first_name), 급여(salary), 부서이름(department_name)을 가져오시오. 
-- 단, 급여는 100번 부서의 평균보다 적게 받는 사원 정보만 가져오시오.
--O
select
    e.first_name,
    e.salary,
    d.department_id
from employees e
    inner join departments d
       on e.department_id = d.department_id
       where d.department_name = 'Sales'
       and e.salary < (select avg(salary) from employees where department_id = 100);

-- 63. employees. last_name 에 'u' 가 포함되는 사원들과 동일 부서에 근무하는 사원들의 사번 및 last_name을 가져오시오.
--O
select 
    employee_id,
    last_name
from employees 
    where department_id 
        in (select distinct(department_id) 
            from employees where instr(last_name,'u') > 0) ;       


-- 64. employees, departments. 부서별 사원들의 최대, 최소, 평균급여를 조회하되, 
-- 평균급여가 ‘IT’ 부서의 평균급여보다 많고, ‘Sales’ 부서의 평균보다 적은 부서 정보만 가져오시오. 
--O
select 
     e.department_id,
     max(e.salary),
     min(e.salary),
     round(avg(e.salary),1)
from employees e
     left outer join departments d
        on e.department_id = d.department_id
            group by e.department_id
                having avg(e.salary) > (select avg(e.salary) from employees e inner join departments d on e.department_id = d.department_id where d.department_name = 'IT')
                and avg(e.salary) < (select avg(e.salary) from employees e inner join departments d on e.department_id = d.department_id where d.department_name = 'Sales'); 


-- 65. employees, departments. 각 부서별로 사원이 한명만 있는 부서만 가져오시오.
--단, 사원이 없는 부서에 대해서는 ‘신생부서’라는 문자열을 가져오고,  결과는 부서명이 내림차순으로 정렬되게 하시오.
--O ? 
select 
    case
        when count(e.employee_id) = 1 then d.department_name
        when count(e.employee_id) = 0 then d.department_name || ' 신생부서'
    end,
    count(e.employee_id)
from employees e
    right outer join departments d 
        on e.department_id = d.department_id
             group by d.department_name
                having count(e.employee_id) <= 1
                    order by d.department_name desc; 

-- 66. employees, departments. 부서별 입사월별 사원수를 가져오시오. 단, 사원수가 5명 이상인 부서만 가져오고,  결과는 부서이름 순으로 하시오.
--O
select 
    d.department_name,
    to_char(e.hire_date, 'MM'),
    count(e.employee_id)
from employees e
    inner join departments d
        on e.department_id = d.department_id
            group by d.department_name, to_char(e.hire_date, 'MM')
                having count(e.employee_id) >=5
            order by d.department_name;

-- 67. employees, departments, locations, countries. 국가(country_name) 별 도시(city)별 사원수를 가져오시오.
-- 부서정보가 없는 사원은 국가명과 도시명 대신에 ‘부서없음’을 넣어서 가져오시오.

select * from employees;
select * from departments;
select * from locations;
select * from countries;



-- 68. employees, departments. 각 부서별 최대 급여자의 아이디(employee_id), 이름(first_name), 급여(salary)를 가져오시오.

-- 69. employees. 커미션(commission_pct)별 사원수를 가져오시오. 커미션은 0.2, 0.25는 모두 0.2로, 0.3, 0.35는 0.3 형태로 바꾸시오. 단, 커미션 정보가 없는 사원들도 있는 데 커미션이 없는 사원 그룹은 ‘커미션 없음’으로 바꿔 가져오시오.


------------로우넘

--1. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
--O
select * from tblInsa;

select 
    name, buseo, jikwi, salary, rownum 
from (select name, buseo, jikwi, basicpay + sudang as salary 
    from tblInsa 
        where substr(ssn, 8, 1) = 1
            order by salary desc);


--2. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
--O
select 
    name, buseo, jikwi, salary, rownum 
from (select name, buseo, jikwi, basicpay + sudang as salary
    from tblInsa
        where substr(ssn, 8,1)=2 order by salary asc);

--3. tblInsa. 여자 인원수가 가장 많은 부서 및 인원수 가져오시오.
--O
select buseo, count(*) as cnt from tblInsa where substr(ssn,8,1) = 2 group by buseo order by count(*) desc;

select buseo, cnt, rownum 
from (select buseo, count(*) as cnt 
      from tblInsa 
        where substr(ssn,8,1) = 2
            group by buseo
                order by count(*) desc) 
where rownum = 1;


--4. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)
--O
select 
    city, cnt, rownum 
from (select city, count(*) as cnt
    from tblInsa 
        group by city 
            order by count(*) desc);
 
select city, count(*) as cnt
    from tblInsa 
        group by city 
            order by count(*) desc; 

--5. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수 출력.
--O
select
    buseo, cnt 
from(select buseo, count(*) as cnt 
    from tblInsa 
        group by buseo
            order by count(*) desc)
where rownum = 1;

--6. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select 
    name, buseo, jikwi, salary, rnum 
from (select name, buseo, jikwi, salary, rownum as rnum 
    from (select name, buseo, jikwi, basicpay + sudang as salary
        from tblInsa 
            where substr(ssn, 8, 1) = 1 
            order by salary desc))
    where rnum between 3 and 5;



--7. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.
--O
select * from (select * from tblInsa order by ibsadate) where rownum <=5;

--8. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.
--O
select * from (select item, price * qty as price from tblhousekeeping order by price desc) where rownum<=3;


--9. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.
--O?

select * from tblInsa;

select buseo from tblInsa group by buseo order by round(avg(basicpay)) desc;

select buseo, round(avg(basicpay)) from tblInsa group by buseo order by round(avg(basicpay)) desc ;
select buseo from (select buseo, basicpay, rownum rnum from (select buseo, round(avg(basicpay)) as basicpay from tblInsa group by buseo order by basicpay desc)) where rnum = 2;

select 
    * 
from tblInsa 
    where buseo = (select buseo from 
                    (select buseo, basicpay, rownum rnum
                     from (select buseo, round(avg(basicpay)) as basicpay
                            from tblInsa group by buseo order by basicpay desc)) 
                  where rnum = 2);



--10. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.
--O
select * from (select * from tbltodo order by adddate) where rownum <=5;

--32. tblInsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마?
-- O
select 
    salary
from (select salary, rownum as rnum 
    from (select basicpay + sudang as salary
        from tblInsa 
            where substr(ssn, 8, 1) = 1 order by salary desc)) where rnum = 3;

--답
select 
sum(case
    when rNum =3 then basicpay+sudang
end)-
sum(case
    when rNum =9 then basicpay+sudang
end) as "차액"
from (select e.*, rowNum as rNum
from (select * from tblinsa order by basicpay+sudang desc) e);





--70. employees, departments. 
--커미션(commission_pct)을 가장 많이 받은 상위 4명의 부서명(department_name), 사원명 (first_name), 급여(salary), 커미션(commission_pct) 정보를 가져오시오.
--결과는 커미션 을 많이 받는 순서로 가져오되 동일한 커미션에 대해서는 급여가 높은 사원을 먼저 정렬하시오.

select * from employees where commission_pct >0 order by commission_pct desc;

select * from (select * from employees where commission_pct >0 order by commission_pct desc) where rownum <=4;

select * from departments;

--답
select *
from (select d.department_name, e.first_name, e.salary, e.commission_pct
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
where commission_pct is not null 
order by commission_pct desc, salary)
where rownum <5;




