package native_jdbc_programing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import native_jdbc_programing.dao.EmployeeDao;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Employee;
import native_jdbc_programing.dto.Title;
import native_jdbc_programing.util.JdbcUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private static EmployeeDaoImpl instance = new EmployeeDaoImpl();

	public static EmployeeDaoImpl getInstance() {
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}

	private EmployeeDaoImpl() {
	}

	@Override
	public List<Employee> selectEmployeeByAll() {
		String sql = "select empNo, empName, title, manager, salary, dept from employee";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				} while (rs.next());
				System.out.println(list.size());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("empno");
		String empName = rs.getString("empname");
		Title title = new Title (rs.getInt("title"));
		Employee manager = new Employee(rs.getInt("manager"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("dept"));
		return new Employee(empNo, empName, title, manager, salary, dept);
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select empNo, empName, title, manager, salary, dept from employee where empNo=?";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, employee.getEmpNo());
//			System.out.println(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "insert into employee values (?, ?, ?, ?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, employee.getEmpNo());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setInt(3, employee.getTitle().gettNo());
			pstmt.setInt(4, employee.getManager().getEmpNo());
			pstmt.setInt(5, employee.getSalary());
			pstmt.setInt(6, employee.getDept().getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee newemployee) {
		String sql = "update employee set empName=? , title=?, manager=?, salary=?, dept=? where empno = ?;";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, newemployee.getEmpName());
			pstmt.setInt(2, newemployee.getTitle().gettNo());
			pstmt.setInt(3, newemployee.getManager().getEmpNo());
			pstmt.setInt(4, newemployee.getSalary());
			pstmt.setInt(5, newemployee.getDept().getDeptNo());
			pstmt.setInt(6, newemployee.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int empNo) {
		String sql = "delete from employee where empno = ?";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, empNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
