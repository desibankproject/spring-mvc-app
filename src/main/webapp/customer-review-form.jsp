<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "sp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Review Form</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  
</head>
<body>
	<header style="background-color: pink; height: 30px;"> Welcome
		@ BizService </header>
	
	<div class="container">
	<img src="${pageContext.request.contextPath}/img/cust-registration.png" style="height: 100px;" />
	<h2>Welcome Customer Review Page!</h2>
	<hr />
	<section>
		<!--
		http://localhost:8080/spring-kb/ check
		 -->	
		<sp:form name="customerform"  commandName="customerVO">
		<h4>${message}</h4>
		<table>
		<tr>
			<tr>
				<td>Username :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<sp:input readonly="true"  type="text" path="username" style="width: 300px;display: inline;margin-right:20px;" class="form-control"  onkeypress="clearText();" onblur="checkName();"/>
					<!-- <button onclick="checkName();" type="button" class="btn btn-primary">Check</button> -->
					<span style="color:red;font-size: 16px;"  id="usernameError"></span>
				
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>Password :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<sp:input readonly="true" type="password" path="password" style="width: 300px;" class="form-control" onkeypress="clearText();"/>
					<span style="color:red;font-size: 16px;"  id="passwordError"></span>
				</td>
			</tr>	
			
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>Email :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<sp:input readonly="true" type="text" path="email" style="width: 500px;" class="form-control" onkeypress="clearText();"/>
					<span style="color:red;font-size: 16px;"  id="emailError"></span>
				</td>
			</tr>	
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Role :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<sp:select disabled="true"  path="role" style="width: 300px;" class="form-control">
					<sp:options items="${roles}"/>
				</sp:select>
				
					<span style="color:red;font-size: 16px;"  id="passwordError"></span>
				</td>
			</tr>	
			
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Gender :&nbsp;&nbsp;&nbsp;</td>
				<td align="left">
				<sp:radiobuttons path="gender" items="${genderList}" style="display: inline;margin-left: 20px;"/>
				</td>
			</tr>	
			
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>Photo :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<sp:input readonly="true" type="text" path="photo" style="width: 700px;" class="form-control"/>
					<span style="color:red;font-size: 16px;"  id="photoError"></span>
				</td>
			</tr>	
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
				<tr>
				<td>&nbsp;</td>
				<td><button onclick="validateCustomer();" type="button" class="btn btn-danger">Register</button> &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.jsp"><button type="button" class="btn btn-primary">Sign In</button></a></td>
				<td></td>
			</tr>
		</table>
		 <img src="${pageContext.request.contextPath}/img/404.jpg" id="userimage" style="height: 150px;"/> 
		</sp:form>
		<hr/>
		<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>

</body>
</html>