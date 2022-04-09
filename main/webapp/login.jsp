<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <c:if test="${sessionScope.email != null}">
    There is a user **attribute** in the session
</c:if> --%>
<%-- <c:if test = "${empty url}">  
     <c:redirect url="login.jsp"/>  
</c:if>  --%> 
<%-- <c:set var="urlvalue" value="${sessionScope.email}" scope="session"/>
 <c:choose>
	<c:when test="${empty urlvalue}">
		<c:redirect url="login.jsp" />
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose> --%>

<%
String email = request.getParameter("email");
String password = request.getParameter("password");
if (email != null) {
	session.setAttribute("email", email);
}
if (password != null) {
	session.setAttribute("password", password);
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" />
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!--  <script type = "text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>  -->

</head>
<body>
	<section class="loginsection">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<h2>User login form</h2>
					<form action="Userlogin" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label> <input
								type="email" class="form-control" id="exampleInputEmail1"
								placeholder="Email" name="email">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password" name="password" value="${error}">
							<span class="errorcolor">${messages.error}</span>
						</div>
						<input type="submit" class="btn btn-primary" value="submit"><br>
						<br> Not registered?<a href="register.jsp">&nbsp;Register</a>
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