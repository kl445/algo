/*1. 자신의 jobid별 min/max 값 구하기
(fname, salary, minsalary ,maxsalary)*/
select e.fname, e.salary, b.minsalary, b.maxsalary 
from emp e , 
	(select jobid, min(salary)as minsalary, max(salary)as maxsalary 
	from emp group by jobid) b
where e.jobid=b.jobid;

/*2. 부서별 관리 직원의 이름
(deptid, deptname, fname )*/
select dept.deptid, deptname, fname
from dept  left outer join emp
on dept.mgrid=emp.empid; 


/*3. 아래와 같은 컬럼을 출력하되 연봉이 15000에서 20000사이의 레코드만 고르기
(empid, fname, salary, deptname, jobid, jobtitle)*/
select e.empid, e.fname, e.salary, d.deptname, e.jobid, j.jobtitle
from emp e join dept d using(deptid) join job j using(jobid) 
where e.salary between 15000 and 20000;

/*4. 아래와 같은 컬럼을 출력하되 ANSI 표준 방식으로 JOIN 문 작성하기
(empid, fname, deptname, jobid, jobtitle)*/
select e.empid, e.fname, d.deptname, j.jobid, j.jobtitle
from emp e join dept d using (deptid) join job j using(jobid);

/*5. 부서ID, 부서이름, 인원수(부서ID가 NULL인 레코드 제외, 부서ID로 정렬)*/
select d.deptid, d.deptname, t.dsum
from dept d 
	left outer join 
	(select deptid, count(*)as dsum from emp group by deptid) t
	using (deptid)
order by d.deptid;

/*6. 자신의 매니저 salary가 15000이상인 직원의 id, 이름, 매니저이름, 매니저
salary (결과 20 ROW)*/
select e.empid as id, e.fname as '이름', m.fname as '매니저이름', m.salary as '매니저 salary'
from  emp e inner join emp m on e.mgrid=m.empid
where m.salary >=15000;
