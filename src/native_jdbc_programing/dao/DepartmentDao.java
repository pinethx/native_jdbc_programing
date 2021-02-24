package native_jdbc_programing.dao;

import java.util.List;

import native_jdbc_programing.dto.Department;

/**
 * C(insert)
 * R(select, select where)
 * U(update)
 * D(delete)
 */

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department department);
	
	int insertDepartment(Department department);
	int updateDepartment(Department newdepartment);
	int deleteDepartment(int deptNo);
}
