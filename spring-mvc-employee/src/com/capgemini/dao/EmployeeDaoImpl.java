package com.capgemini.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Employee;


@Repository	("dao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate template;
	
	private static final String INSERT_EMPLOYEE = "Insert Into EMP(EMP_ID, EMP_NAME, EMP_SAL) Values(Emp_Seq.nextval, ?, ?)";
	private static final String DELETE_EMPLOYEE_BY_ID = "Delete From EMP Where Emp_Id = ?";
	private static final String SELECT_ALL_EMPLOYEES = "Select * from Emp";
	private static final String UPDATE_EMPLOYEE = "Update Emp Set Emp_Name = ? , Emp_Sal = ? where Emp_Id = ?";
	private static final String FIND_EMPLOYEE_BY_ID = "Select * From Emp Where Emp_Id = ?";
	private static final String FIND_EMPLOYEE_BY_NAME = "Select * From Emp Where Emp_Name = ?";
	private static final String FIND_EMPLOYEE_BY_SALARY = "Select * From Emp Where Emp_Sal = ?";
	private static final String FIND_EMPLOYEE_IN_SALARY_RANGE = "Select * From Emp Where Emp_Sal Between ? and ?";
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public EmployeeDaoImpl() {
	}

	public int createEmployee(Employee employee) {
		String query = "Select EMP_SEQ.NEXTVAL from Dual";
		int id = getTemplate().queryForObject(query, Integer.class);
		employee.setEmployeeId(id);
		int result = getTemplate().update(INSERT_EMPLOYEE, employee.getEmployeeName(), employee.getEmployeeSalary());
		return result;
	}

	public List readAllEmployee() {
		List<Employee> empList = getTemplate().query(SELECT_ALL_EMPLOYEES, new EmployeeRowMapper());
		return empList;
	}

	public List<Employee> findEmployeeById(int emp_id) {
		List<Employee> empList = getTemplate().query(FIND_EMPLOYEE_BY_ID, new Object[] {emp_id}, new EmployeeRowMapper());
		return empList;
	}

	public List<Employee> findEmployeeByName(String emp_name) {
		List<Employee> empList = getTemplate().query(FIND_EMPLOYEE_BY_NAME, new Object[] {emp_name}, new EmployeeRowMapper());
		return empList;
	}

	public List<Employee> findEmployeeBySalary(double emp_salary) {
		List<Employee> empList = getTemplate().query(FIND_EMPLOYEE_BY_SALARY, new Object[] {emp_salary}, new EmployeeRowMapper());
		return empList;
	}
	
	public List<Employee> findInSalaryRange(double min, double max) {
		return getTemplate().query(FIND_EMPLOYEE_IN_SALARY_RANGE, new Object[] {min, max}, new EmployeeRowMapper());
	}

	public int deleteEmployee(int emp_id) {
		return getTemplate().update(DELETE_EMPLOYEE_BY_ID, emp_id);
	}

	public int updateEmployee(Employee updatedEmployee) {
		int result = getTemplate().update(UPDATE_EMPLOYEE, updatedEmployee.getEmployeeName(), updatedEmployee.getEmployeeSalary(), updatedEmployee.getEmployeeId());
		return result;
	}

}
