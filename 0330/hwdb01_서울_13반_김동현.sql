use harry;

-- 1. 직원의 id가 158인 레코드의 fname, lname, phone 검색
select fname, lname, phone
from emp
where empid=158;

-- 2. fname이 ‘D’로 시작하는 직원의 id와 이름,부서ID 검색
select empid id, fname 이름, deptid 부서ID 
from emp
where fname like 'D%';

-- 3. 부서번호가 30인 사원들의 사번과 fname, job_id, salary,deptid 출력
select empid 사번,fname, jobid job_id,salary,deptid
from emp
where deptid=30;

-- 4. comm이 0.2이상인 사원의 사번과 fname,comm 출력
select empid 사번,fname,comm
from emp
where comm>=0.2;

-- 5. 입사일이 1999년 12월31일 이후인 직원의 사원의 사번과 fname,입사일 출력(입사일로 오름차순 정렬)
select empid 사번, fname, hdate 입사일
from emp
-- where hdate between 1999-12-31 and 20200330
where hdate >=1999-12-31
order by 3;

-- 6. 부서번호가 20에서 50번 사이의 직원이름과 부서ID를 검색(부서id로 오름차순 정렬)
select fname 이름,deptid 부서ID
from emp
where deptid between 20 and 50
order by deptid asc;

-- 7. 부서번호가 없는 직원의 id와 email, 이름 검색
select empid id,email,fname 이름
from emp
where deptid is null;

-- 8. jobid가 'ST_CLERK' ,'SA_MAN','SA_REP'인 직원의 id와 이름, jobid
select empid id,fname 이름,jobid
from emp
where jobid in('ST_CLERK','SA_MAN');

-- 9. 전화번호가 011로 시작하는 직원의 id와 이름,부서ID, 전화번호 검색
select empid id, fname 이름 , deptid 부서ID, phone 전화번호
from emp
where phone like '011%';

-- 10. comm이 null이 아닌 직원 중 그 값이 0.3 이상인 레코드(comm으로 정렬)
select *
from emp
where comm is not null 
and comm>=0.3
order by comm;

-- 11. 테이블 안의 모든 레코드에 대해 아래와 같은 형식으로 출력 
-- 사번 설명
-- 101 Steven King IS A AD_PRES.
select empid 사번, concat(fname,' ',lname,' IS A ',jobid)설명
from emp;

-- 12. hdate가 ‘2003/12/15'에서 ‘2004/12/31' 사이의 레코드
select *
from emp
where hdate between '2003/12/15' and '2004/12/31';

-- 13. 입사일 순으로 사원 정보 정렬(오래된 순)
select *
from emp
order by hdate asc;

-- 14. 부서 ID가 40번이 아닌 부서에 속한 직원 들 중 SALARY가 20000 이상인 레코드
select *
from emp
where not deptid=40 and salary >=20000;

-- 15. empid, fname, salary, 15% 증가된 salary(새연봉) :새연봉이 높은 순으로 정렬
select empid, fname, salary, salary*0.15 '15%증가된 salary(새연봉)'
from emp
order by salary*0.15 desc;
