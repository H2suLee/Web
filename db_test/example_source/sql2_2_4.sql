--Creating a Temporary Table
create global temporary table emp_temp1
on commit delete rows
as
select employee_id, last_name,salary from employees;
create global temporary table emp_temp2
on commit preserve rows
as
select employee_id, last_name, salary from employees;
--SQL Developer 종료 후 재실행
--Using a Temporary Table
select * from emp_temp1;
select * from emp_temp2;
insert into emp_temp1
select employee_id, last_name, salary
from employees
where department_id = 50;
insert into emp_temp2
select employee_id, last_name, salary
from employees
where department_id in (80,90);
select * from emp_temp1;
select * from emp_temp2;
commit;
select * from emp_temp1;
select * from emp_temp2;
--SQL Developer 추가 실행 후 인사관리로 접속 
select * from emp_temp2;
insert into emp_temp2
select employee_id, last_name, salary
from employees
where department_id=60;
commit;
select * from emp_temp2;
--두 번째 SQL Developer 종료
--Clear Test
drop table emp_temp1;
drop table emp_temp2;

--External Table Test
--탐색기를 실행하고 c:\db_test\mydir1 폴더생성
--c:\db_test\sql_labs의 emp.dat 파일을 c:\db_test\mydir1 경로로 복사해두기
--Run SQL CommandLine을 실행한 후 관리자가 디렉토리 객체 생성 및 권한 부여
--Run SQL CommandLine 실행 내용
conn / as sysdba
CREATE DIRECTORY dir_1 AS 'c:\db_test\mydir1\';
GRANT read, write ON directory dir_1  TO hr;
exit;
--SQL Developer를 실행한 후 오라클 로더를 사용하는 외부테이블 생성 
CREATE TABLE empxt (empno       NUMBER(4),
                        ename       VARCHAR2(10),
                         job         VARCHAR2(9),
                         mgr         NUMBER(4),
                         hiredate    DATE,
                         sal         NUMBER(7,2),
                         comm        NUMBER(7,2),
                         deptno      NUMBER(2)
                        )
          ORGANIZATION EXTERNAL
           (
            TYPE ORACLE_LOADER
            DEFAULT DIRECTORY dir_1
            ACCESS PARAMETERS
            (
              records delimited by newline
              badfile dir_1:'empxt.bad'
              logfile dir_1:'empxt.log'
              fields terminated by ','
              missing field values are null
              ( empno, ename, job, mgr,
               hiredate char date_format date mask "dd-mon-yy",
                sal, comm, deptno
              )
            )
            LOCATION ('emp.dat')
          );

SELECT * FROM empxt; 

--오라클 데이터펌프를 사용하는 외부테이블 생성
create table empxt2
      Organization external
     (type oracle_datapump
      Default directory dir_1
      Location('emp2.dat'))
      As
      Select * from employees;

SELECT * FROM empxt2;

--Clear Test
drop table empxt;
drop table empxt2;
