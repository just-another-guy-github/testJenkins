package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Employee;

public interface EmployeeService {

	public boolean addEmployee(Employee employee);

	public Employee findEmployeeById(int emp_id);

	public List<Employee> findEmployeeByName(String emp_name);

	public List<Employee> findEmployeeBySalary(double emp_salary);

	public List viewAllEmployee();

	public boolean deleteEmployee(int emp_id);

	public boolean updateEmployee(Employee updatedEmployee);
	
	public List<Employee> findEmployeeInSalaryRange(double min, double max);
}
