package com.capgemini.dao;

import java.util.List;

import com.capgemini.model.Employee;

public interface EmployeeDao {

	public int createEmployee(Employee employee);

	public List readAllEmployee();

	public List<Employee> findEmployeeById(int emp_id);

	public List<Employee> findEmployeeByName(String emp_name);

	public List<Employee> findEmployeeBySalary(double emp_salary);

	public int deleteEmployee(int emp_id);

	public int updateEmployee(Employee updatedEmployee);
	
	public List<Employee> findInSalaryRange(double min, double max);

}
