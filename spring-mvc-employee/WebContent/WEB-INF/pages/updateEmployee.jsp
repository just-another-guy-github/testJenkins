<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateEmployee.do" method="post">
		<label>Employee Id</label>
		<input type="text" name="employeeId"><br>
		<label>Employee Name</label>
		<input type="text" name="employeeName"><br>
		<label>Employee salary</label>
		<input type="text" name="employeeSalary"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>