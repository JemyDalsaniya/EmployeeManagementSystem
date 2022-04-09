<%@ page import="controller.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% String username = request.getParameter("name");
String useremail = request.getParameter("email");
String userpassword = request.getParameter("password");
String usercontact = request.getParameter("contact");

if(username !=  null){
	session.setAttribute("name" , username);
}
if(useremail !=  null){
	session.setAttribute("email" , useremail);
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" />
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<!-- <script type="text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
 -->
</head>

<body>
	<section class="loginsection">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<h2>Registration form</h2>
					<form action="Register" method="post">
						<div class="form-group">
							<label for="name">Name</label> <input type="text"
								class="form-control" id="name" placeholder="Enter your name:"
								name="name"> <span class="errorcolor">${messages.name}</span>
						</div>
						<div class="form-group">
							<label for="email">Email address</label> <input type="email"
								class="form-control" id="email" placeholder="Email" name="email">
							<span class="errorcolor">${messages.email}</span>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" placeholder="Password"
								name="password"> <span class="errorcolor">${messages.password}</span>
						</div>

						<div class="form-group">
							<label for="contact">Contact</label> <input type="text"
								class="form-control" id="contact" placeholder="Contact"
								name="contact"> <span class="errorcolor">${messages.contact}</span>
						</div>
						<input type="submit" class="btn btn-primary" value="Submit">
						<span class="errorcolor">${messages.success}</span> 
						<a href="login.jsp">Login</a>
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