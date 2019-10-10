<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Page</title>
</head>
<body>
	<form action="addEmployee.do" method="post">
		<label>Employee Name</label>
		<input type="text" name="employeeName"><br>
		<label>Employee salary</label>
		<input type="text" name="employeeSalary"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>