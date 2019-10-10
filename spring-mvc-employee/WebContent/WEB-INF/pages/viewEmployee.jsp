<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>View Employee</title>
</head>
<body>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Employee Id</th>
				<th scope="col">Employee Name</th>
				<th scope="col">Employee Salary</th>
			</tr>
		</thead>
		<c:forEach items="${ employeeList }" var="s" >
			<tbody >	
				<tr>
					<th scope="row">${ s.getEmployeeId() }</th>
					<td>${ s.getEmployeeName() }</td>
					<td>${ s.getEmployeeSalary() }</td>
					<!-- <td>@</td> -->
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>
<%-- 
<c:forEach items="${ employeeList }" var="s">
		${ s }<br>
	</c:forEach> --%>