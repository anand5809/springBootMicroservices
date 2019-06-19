<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
			<!-- 	<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
						<script src=" https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" type="text/javascript"></script>
		
		 -->
		
      
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Employee Data</h2>
		<form:form method="POST" action="addEmployee" modelAttribute="emp" >
	   		<table>
			    <tr>
			        <td><form:label path="empid">Employee ID:</form:label></td>
			        <td><form:input path="empid"  readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="empName">Employee Name:</form:label></td>
			        <td><form:input path="empName" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="empAge">Employee Age:</form:label></td>
			        <td><form:input path="empAge" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="salary">Employee Salary:</form:label></td>
			        <td><form:input path="salary" /></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="empaddress">Employee Address:</form:label></td>
                    <td><form:input path="empaddress" /></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
			 <h2 align="center"><a href="getAll">GET EMPLOYEE</a></h2>
		</form:form>
		
   <c:if test="${!empty employeeList}">
		<h2>List Employees</h2>
	<table align="left" border="1" id="table">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Employee Address</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${employeeList}" var="employee">
			<tr>
				<td id="emp">${employee.empid}</td>
				<td>${employee.empName}</td>
				<td>${employee.empAge}</td>
				<td>${employee.salary}</td>
				<td>${employee.empaddress}</td>
<%-- 				<td align="center"><a href="edit.html?id=${employee.empid}">Edit</a> | <a href="delete.html?id=${employee.empid}">Delete</a></td>
 --%>			
 <td align="center"><!-- <button onclick="EmpValidation()">Edit</button> | --> <a href="delete/${employee.empid}">Delete</a></td>
 </tr>
		</c:forEach>
	</table>
</c:if> 
<script type="text/javascript">
function EmpValidation(){
	var b=$('#emp').val();
	//var value = $("#emp").attr('value');
	alert(b);
}
</script>
<!-- <script type="text/javascript">

$(document).ready(function() {
    $('#table').DataTable();
} );

</script>
 -->
	</body>
</html>