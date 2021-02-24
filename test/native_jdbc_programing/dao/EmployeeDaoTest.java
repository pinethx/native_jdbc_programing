package native_jdbc_programing.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.impl.EmployeeDaoImpl;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Employee;
import native_jdbc_programing.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll");
		List<Employee> employeeList = dao.selectEmployeeByAll();
		Assert.assertNotNull(employeeList);

//		titleList.stream().forEach(System.out::println);
		for (Employee t : employeeList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee employee = new Employee(2106);
		Employee searchEmployee = dao.selectEmployeeByNo(employee);
		Assert.assertNotNull(searchEmployee);
		System.out.println(searchEmployee);
	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee newEmployee = new Employee(1007, "서현진", new Title(5), new Employee(4377), 1500000, new Department(3));
		int res = dao.insertEmployee(newEmployee);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEmployee));

		dao.selectEmployeeByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee");
		Employee newEmployee = new Employee(1007, "서현진", new Title(4), new Employee(4377), 2000000, new Department(4));
		int res = dao.updateEmployee(newEmployee);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEmployee));

		dao.selectEmployeeByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test03DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployee");
		int res = dao.deleteEmployee(1007
				
				);
		Assert.assertEquals(1, res);
		
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
	}

}
