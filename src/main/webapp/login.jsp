<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Palindom</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<header style="background-color: pink; height: 30px;"> Welcome
		@ BizService </header>
	
	<div class="container">
	<img src="${pageContext.request.contextPath}/img/users_delete.png" style="height: 100px;" />
	<hr />
	<section>
		<!--
		http://localhost:8080/spring-kb/ check
		 -->	
		<form name="mathform" action="${pageContext.request.contextPath}/auth" method="post">
		<table>
			<tr>
				<td>User Name :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="text" name="username" style="width: 300px;" class="form-control"/>
					<span style="color:red;font-size: 16px;"  id="usernameError"></span>
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>Password :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="password" name="password" style="width: 300px;" class="form-control"/>
					<span style="color:red;font-size: 16px;"  id="passwordError"></span>
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
				<tr>
				<td>&nbsp;</td>
				<td>
				<button type="submit" class="btn btn-danger">Check User</button> &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/register"><button type="button" class="btn btn-primary">Sign Up</button></a>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/customers"><button type="button" class="btn btn-warning">Show Customers</button></a>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/customers-search.jsp"><button type="button" class="btn btn-warning">Customer Search</button></a>
				
				</td>
				<td></td>
			</tr>
		</table>
		</form>
		<hr/>
		<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>

</body>
</html>