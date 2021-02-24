package native_jdbc_programing.dao;

import java.util.List;

import native_jdbc_programing.dto.Employee;

/**
 * C(insert)
 * R(select, select where)
 * U(update)
 * D(delete)
 */

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee employee);
	
	int insertEmployee(Employee employee);
	int updateEmployee(Employee newemployee);
	int deleteEmployee(int empNo);
}
