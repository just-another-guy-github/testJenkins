package com.capgemini.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capgemini.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getInt("Emp_Id"));
		emp.setEmployeeName(rs.getString("Emp_Name"));
		emp.setEmployeeSalary(rs.getDouble("Emp_Sal"));
		return emp;
	}

}
