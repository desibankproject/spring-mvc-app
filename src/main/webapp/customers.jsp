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
  <script type="text/javascript">
  
  	//This is ready handler and it would be called when dom is ready in memory!
  	$(document).ready(function(){
  		
  		$("#filterResult").change(function() {
			var selectedValue=$(this).val();
			//Make call with filter data
			window.location.href="${pageContext.request.contextPath}/customers?oowowow="+selectedValue;
  		});
  		//Registering click event on button which id gogogo
  		$("#gogogo").click(function(){
  			var searchstring=$("#searchstring").val();
  			window.location.href="${pageContext.request.contextPath}/search-customers?searchstring="+searchstring;
  		});
  		
  		
  		$("#clearSearch").click(function(){
  			window.location.href="${pageContext.request.contextPath}/customers";
  		});
  		
  		
  	});
  
  	function openCustomerPopup(){
  		//This will open a modal which id is 	addCustomerModal
  		$("#addCustomerModal").modal("show");
  	}
  
  </script>
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
		 <p>
		 Search  : <input type="text" class="form-control" id="searchstring" name="searchstring" value="${param.searchstring}">
		 <button type="button" class="btn btn-danger" id="gogogo">Go</button>
		  <button type="button" class="btn btn-danger" id="clearSearch">Clear Search</button>
	<%-- 	 <a href="${pageContext.request.contextPath}/register"><button type="button" class="btn btn-primary">Add Customer</button></a> --%>
		 <a href="javascript:openCustomerPopup();"><button type="button" class="btn btn-primary">Add Customer Popup</button></a>
		 &nbsp;&nbsp;&nbsp;&nbsp;
		<img src="${pageContext.request.contextPath}/img/filter.png"> 
		  <select  name="filterResult" id="filterResult" style="width: 300px;display: inline;margin-left: 20px;" class="form-control">
		  	<option ${param.oowowow=='All'?'selected':''}>All</option>
					<option ${param.oowowow=='Customer'?'selected':''}>Customer</option>
					<option ${param.oowowow=='Employee'?'selected':''}>Employee</option>
					<option ${param.oowowow=='Admin'?'selected':''}>Admin</option>
				</select>
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
	
	
  <!-- The Modal start-->
  <div class="modal fade" id="addCustomerModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        	<form name="customerform" action="${pageContext.request.contextPath}/register" method="post">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title"><img src="${pageContext.request.contextPath}/img/cust-registration.png" style="height: 40px;"> Add Customer</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
     
		<h4>${message}</h4>
		
		<div class="form-group">
    <label for="username">Username:</label>
    <input type="text" class="form-control" id="username" name="username">
  </div>
  
  	<div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  
  <div class="form-group">
    <label for="email">email:</label>
    <input type="email" class="form-control" id="email" name="email">
  </div>
  
    <div class="form-group">
    <label for="role">Role:</label>
   <select  name="role" style="width: 300px;" class="form-control">
   
					<option>Customer</option>
					<option>Employee</option>
					<option>Admin</option>
				</select>
  </div>
  
   <div class="form-group">
    <label for="gender">Gender</label>
    <br/>
   <input type="radio" name="gender" value="male"  style=""> Male
  				<input type="radio" name="gender" value="female" style="margin-left: 20px;"> Female
  </div>
		
		
		  <div class="form-group">
    <label for="Image">Image:</label>
    <input type="text" class="form-control" id="photo" name="photo">
  </div>
        
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          	<button  type="submit" class="btn btn-danger">Register</button> &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.jsp"><button type="button" class="btn btn-primary">Sign In</button></a>
        </div>
        </form>
      </div>
    </div>
  </div>
	  <!-- The Modal end-->

</body>
</html>