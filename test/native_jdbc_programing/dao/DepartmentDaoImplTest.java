package native_jdbc_programing.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.impl.DepartmentDaoImpl;
import native_jdbc_programing.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoImplTest {
	private static DepartmentDao dao = DepartmentDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectDepartmentByAll");
		List<Department> departmentList = dao.selectDepartmentByAll();
		Assert.assertNotNull(departmentList);

//		titleList.stream().forEach(System.out::println);
		for (Department t : departmentList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectDepartmentByNo() {
		System.out.printf("%s()%n", "testSelectDepartmentByNo");
		Department department = new Department(3);
		Department searchDepartment = dao.selectDepartmentByNo(department);
		Assert.assertNotNull(searchDepartment);
		System.out.println(searchDepartment);
	}

	@Test
	public void test01InsertDepartment() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Department newDepartment = new Department(5, "인사", 6);
		int res = dao.insertDepartment(newDepartment);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(newDepartment));

		dao.selectDepartmentByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateDepartment() {
		System.out.printf("%s()%n", "testUpdateDepartment");
		Department newDepartment = new Department(5, "관리", 2);
		int res = dao.updateDepartment(newDepartment);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectDepartmentByNo(newDepartment));

		dao.selectDepartmentByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test03DeleteDepartment() {
		System.out.printf("%s()%n", "testDeleteDepartment");
		int res = dao.deleteDepartment(5);
		Assert.assertEquals(1, res);
		
		dao.selectDepartmentByAll().stream().forEach(System.out::println);
	}

}
