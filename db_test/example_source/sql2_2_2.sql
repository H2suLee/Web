--Create a Table For Test
drop table emp2 purge;
create table emp2
as
select * from employees;
select table_name, constraint_name, constraint_type, status, search_condition
from user_constraints
where table_name = 'EMP2';
--Adding a Constraints
alter table emp2
add primary key(employee_id);
alter table emp2
add constraint emp2_email_uk unique (email);
select table_name, constraint_name, constraint_type, status,search_condition
from user_constraints
where table_name = 'EMP2';
--Disable a Constraints
alter table emp2
disable primary key;
update emp2
set employee_id = 102
where employee_id = 101;
commit;
alter table emp2
disable constraint emp2_email_uk;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--Enabling a Constraints
alter table emp2
enable constraint emp2_email_uk;
alter table emp2
enable primary key; 
SELECT *
FROM emp2;
SELECT employee_id, rowid
FROM emp2;
--rowid 값 복사 
UPDATE emp2
SET employee_id = 101
WHERE rowid='AAAE84AAEAAAAGrAAB';
--복사한 rowid 값 사용
SELECT *
FROM emp2;
COMMIT;
ALTER TABLE emp2
ENABLE primary key;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--Dropping a Constraints
alter table emp2 
drop primary key;
alter table emp2
drop constraint emp2_email_uk;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--Cascading Constraints
--Column Drop 시 추가 옵션
CREATE TABLE test1(
a NUMBER PRIMARY KEY,
b NUMBER,
c NUMBER,
d NUMBER,
CONSTRAINT test1_b_fk FOREIGN KEY (b) REFERENCES test1,
CONSTRAINT ck1 CHECK (a > 0 and c > 0),
CONSTRAINT ck2 CHECK (d > 0));
desc test1
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'TEST1';
alter table test1
drop column d;
DESC test1
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'TEST1';
alter table test1
drop column c;
alter table test1
drop column a;
alter table test1
drop column a cascade constraints;
desc test1
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'TEST1';
alter table test1 
drop column c;
desc test1
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'TEST1';
--Renaming Table Columns and Contraints
DESC emp2
alter table emp2
rename column employee_id to empid;
desc emp2
alter table emp2
add constraint emp2_pk primary key(employee_id);
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
alter table emp2
rename constraint emp2_pk to emp2_empid_pk;
select table_name, constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMP2';
--Clean Test
drop table emp2 purge;
drop table test1 purge;