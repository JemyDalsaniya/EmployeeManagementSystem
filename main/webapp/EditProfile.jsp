<%@ page import="model.Employee"%>
<% Employee employee = (Employee) session.getAttribute("employee"); %>
<% String username = request.getParameter("empName");
String userpassword = request.getParameter("empPassword");
String usercontact = request.getParameter("empContact");

if(username !=  null){
	session.setAttribute("name" , username);
}
if(userpassword !=  null){
	session.setAttribute("password" , userpassword);
}
if(usercontact !=  null){
	session.setAttribute("contact" , usercontact);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
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
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="EditProfile.jsp">Edit Profile<span
							class="sr-only">(current)</span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Projects <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="GetEmployeeProjects?project_status=completed">Completed</a></li>
							<li><a href="GetEmployeeProjects?project_status=ongoing">Ongoing</a></li>
							<li><a href="GetEmployeeProjects?project_status=upcoming">Upcoming</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="loginsection">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<h2>Edit Details..</h2>
					<form action="UpdateProfile" method="post">
						<%-- <div class="form-group">
							<label for="id">Id</label> <input type="text"
								class="form-control" id="id" placeholder="Enter your id:"
								name="empId" value="${employee.empId}" readonly="readonly">
						</div>  --%>
						<div class="form-group">
							<label for="name">Name</label> <input type="text"
								class="form-control" id="name" placeholder="Enter your name:"
								name="empName" value="${employee.empName}"> <span
								class="errorcolor">${messages.name}</span>
						</div>
						<div class="form-group">
							<label for="email">Email address</label> <input type="email"
								class="form-control" id="email" placeholder="Email"
								name="empEmail" value="${employee.empEmail}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" placeholder="Password"
								name="empPassword" value="${employee.empPassword}">
								<span
								class="errorcolor">${messages.password}</span>
						</div>

						<div class="form-group">
							<label for="contact">Contact</label> <input type="text"
								class="form-control" id="contact" placeholder="Contact"
								name="empContact" value="${employee.empContact}"> <span
								class="errorcolor">${messages.contact}</span>

						</div>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
				</div>

			</div>
		</div>
	</section>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>