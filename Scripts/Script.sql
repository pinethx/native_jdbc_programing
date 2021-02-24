select user(), database ();

select deptno, deptname, floor
  from department;
  
select e.empno, e.empname,
       t.tno as title_no, t.tname as title_name,
       m.manager as manager_no, m.empname as manager_name,
       e.salary,
       d.deptno, d.deptname, d.floor 
  from employee e join title t on e.title = t.tno
       left join employee m on e.manager = m.empno 
       join department d on e.dept = d.deptno ;
       
select empno, empname, title_no, title_name, manager_no, manager_name, salary, deptno
  from vw_full_employee;
  
select empno, empname, title as title_no, manager as manager_no, salary, dept as deptNo
  from employee;
  

insert into employee values (1004, '천사', 5, 4377, 2000000, 1);
update employee 
   set dept = 3
 where empno = 1004;
delete
  from employee 
 where empno = 1004;