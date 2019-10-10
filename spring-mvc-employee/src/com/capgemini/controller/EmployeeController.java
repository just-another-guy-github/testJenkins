package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.model.Employee;
import com.capgemini.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}

	@RequestMapping(path = "addEmployeePage", method = RequestMethod.GET)
	public String addEmployeePage() {
		return "addEmployee";
	}

	@RequestMapping(path = "addEmployee.do", method = RequestMethod.POST)
	public String processAddEmployee(@RequestParam("employeeName") String name,
			@RequestParam("employeeSalary") double salary) {
		Employee employee = new Employee();
		employee.setEmployeeName(name);
		employee.setEmployeeSalary(salary);
		boolean result = employeeService.addEmployee(employee);
		if (result)
			return "redirect:viewEmployees.do";
		else
			return "error";
	}

	@RequestMapping(path = "viewEmployeePage", method = RequestMethod.GET)
	public String viewEmployeePage(Model model) {
		List<Employee> list = employeeService.viewAllEmployee();
		model.addAttribute("employeeList", list);
		return "viewEmployee";
	}

	@RequestMapping(path = "viewEmployees.do", method = RequestMethod.GET)
	public String viewAllEmployee(Model model) {
		List<Employee> list = employeeService.viewAllEmployee();
		model.addAttribute("employeeList", list);
		return "viewEmployee";
	}
	
	@RequestMapping(path="updateEmployeePage", method = RequestMethod.GET)
	public String updateEmployee() {
		return "updateEmployee";
	}
	
	@RequestMapping(path="updateEmployee.do")
	public String processUpdateEmployee(@RequestParam("employeeId") int id, 
			@RequestParam("employeeName") String name, @RequestParam("employeeSalary") double salary) {
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		employee.setEmployeeSalary(salary);
		boolean result = employeeService.updateEmployee(employee);
		if(result)
			return "redirect:viewEmployees.do";
		else
			return "error";
	}

	@RequestMapping(path = "deleteEmployeePage", method = RequestMethod.GET)
	public String deleteEmployee() {
		return "deleteEmployee";
	}

	@RequestMapping(path = "deleteEmployee.do", method = RequestMethod.POST)
	public String deleteAllEmployee(@RequestParam("employeeId") int id) {
		boolean result = employeeService.deleteEmployee(id);
		if (result)
			return "redirect:viewEmployees.do";
		else
			return "error";
	}
	
}