<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
	<img src="${pageContext.request.contextPath}/img/cust-registration.png" style="height: 100px;" />
	<hr />
	<section>
		<!--
		http://localhost:8080/spring-kb/ check
		 -->	
		 <p>All the customers details coming from the database:
		 <a href="${pageContext.request.contextPath}/register"><button type="button" class="btn btn-primary">Add Customer</button></a>
		 </p>          
		   
	<h4>${message}</h4>	   
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
         <th>Role</th>
         <th>Gender</th>
         <th>Photo</th>
         <th>Doe</th>
          <th>Action</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${customerList}" var="item">
      <tr>
        <td>${item.username}</td>
        <td>${item.password}</td>
        <td>${item.email}</td>
           <td>${item.role}</td>
            <td>${item.gender}</td>
        <td><img src="${item.photo}" style="height: 60px;"/></td>
        <td>${item.doe}</td>
        <td>
        <a href="${pageContext.request.contextPath}/deleteCustomer?pusername=${item.username}">	
        <img src="${pageContext.request.contextPath}/img/delete-test-icon.png" style="height: 35px;"/>
        </a>
        </td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
		<hr/>
		<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>

</body>
</html>