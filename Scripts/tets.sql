select user(), database ();

show tables;

desc title;
desc department;
desc employee;

select * from title;
select * from department;
select * from employee;

update title set tname='계약직' where tno = 6;
select tno, tname from title;
select tno, tname from title where tno=3;

delete from title where tno = 6;
insert into title values (6, '인턴');
delete from department where deptno = 5;


-- 부서 1인 사원 정보 출력
select empname
  from employee
 where dept = 1;

