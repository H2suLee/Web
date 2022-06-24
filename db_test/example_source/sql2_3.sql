--Dictionary View Prefix 구분해보기
--Run SQLCommandLine에서 다음을 실행
conn / as sysdba
select count(*) from user_tables;
select count(*) from all_tables;
select count(*) from dba_tables;
conn hr/hr
select count(*) from user_tables;
select count(*) from all_tables;
select count(*) from dba_tables;
SELECT comments FROM dictionary
WHERE table_name = 'USER_TABLES';
exit
--SQL Developer 실행 후 인사관리로 접속
--Creating Objects For Test
create table emp3
as
select * from employees;
create index emp3_empid_ix on emp3(employee_id);
create view emp3_list_vu
as
select employee_id, last_name, department_id
from employees
where department_id not in (10,90);
create synonym e3 for emp3_list_vu;
create sequence emp3_seq
increment by 1
start with 250
nocache
nocycle;
--Dictionary로 부터 사용자 소유 Object 관련 정보 탐색하기
select view_name, text from user_views
where view_name like 'EMP3%';
select synonym_name, table_owner, table_name
from user_synonyms
where synonym_name = 'E3';
select sequence_name, increment_by, max_value, cache_size
from user_sequences
where sequences_name like 'EMP3%';
select index_name, status from user_indexes
where index_name like 'EMP3%';
select object_name, object_type, status from user_objects
where object_name like 'EMP3%'
or object_name like 'E3%';
--Table 삭제 후 연관객체의 상태 알아보기
drop table emp3;
select index_name, status from user_indexes
where index_name like 'EMP3%';
select object_name, object_type, status from user_objects
where object_name like 'EMP3%'
or object_name like 'E3%';
--Clear Test
drop view emp_list_vu;
drop synonym e3;
drop sequence emp3_seq;

