
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
 <script type="text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script> 
 

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
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
					<li><a href="AddProject.jsp?">Add Project<span
							class="sr-only">(current)</span></a>
					<li><a href="displayProject?status=completed">Completed<span
							class="sr-only">(current)</span></a>
					<li><a href="displayProject?status=ongoing">Ongoing<span
							class="sr-only">(current)</span></a>
					<li><a href="displayProject?status=upcoming">Upcoming<span
							class="sr-only">(current)</span></a>
					<li><a href="displayAllProject">All Projects<span
							class="sr-only">(current)</span></a></li>


				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h2>Welcome Admin..</h2>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>