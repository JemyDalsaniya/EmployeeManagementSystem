<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Project"%>
<%@ page import="model.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">

<!-- Data table cdn for css link -->
<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"> -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="style.css">
<!-- <script type = "text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script> -->

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Admin</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="AddProject.jsp">Add Project<span
							class="sr-only">(current)</span></a>
					<li><a href="displayProject?status=completed">Completed<span
							class="sr-only">(current)</span></a>
					<li><a href="displayProject?status=ongoing">Ongoing<span
							class="sr-only">(current)</span></a>
					<li><a href="displayProject?status=upcoming">Upcoming<span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Data table added  -->
	<div class=" container">
		<h3>Project Information</h3>
		<table id="example" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>Project Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projectDetails}">
					<tr>
						<td>${project.projectName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- <table>

			<c:forEach items="${projectDetails}" var="project">
				<tr>
					<th>Project Name</th>
					<td>${project.projectName}</td>
			</c:forEach>
		</table>
 --%>

		<h3>Select Employees:</h3>
		<% String id = request.getParameter("project_id"); %>
		<form action="AssignProject?id=<%= id %>" method="post">
			<select name="selectEmployee" multiple="multiple" size="10"
				id="selectmenu">
				<option value="select"></option>

				<c:forEach items="${employeeList}" var="emp">
					<option value="${emp.empId}">${emp.empName}</option>
				</c:forEach>
			</select><br><br> <input type="submit" value="Start" class="btn btn-primary">
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>

</body>
</html>