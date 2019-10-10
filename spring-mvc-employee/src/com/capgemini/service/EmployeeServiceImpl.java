package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.model.Employee;


@Service(value="service")
public class EmployeeServiceImpl implements EmployeeService {
	// EmployeeDao dao = new EmployeeDaoImpl();
	@Autowired
	private EmployeeDao dao = null;

	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	public boolean addEmployee(Employee employee) {
		int result = dao.createEmployee(employee);
		if (result != 0 )
			return true;
		return false;
	}

	public Employee findEmployeeById(int emp_id) {
		List<Employee> employee = dao.findEmployeeById(emp_id);
		return employee.get(0);
	}

	public List<Employee> findEmployeeByName(String emp_name) {
		List<Employee> employee = dao.findEmployeeByName(emp_name);
		return employee;
	}

	public List<Employee> findEmployeeBySalary(double emp_salary) {
		List<Employee> employee = dao.findEmployeeBySalary(emp_salary);
		return employee;
	}

	public List viewAllEmployee() {
		List<Employee> employee = dao.readAllEmployee();
		return employee;
	}
	
	public List<Employee> findEmployeeInSalaryRange(double min, double max) {
		List<Employee> employee = dao.findInSalaryRange(min, max);
		return employee;
	}

	public boolean deleteEmployee(int emp_id) {
		int result = dao.deleteEmployee(emp_id);
		if (result == 1)
			return true;
		return false;
	}

	public boolean updateEmployee(Employee updatedEmployee) {
		int result = dao.updateEmployee(updatedEmployee);
		if (result == 1)
			return true;
		return false;
	}

}
