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
  		var context="${pageContext.request.contextPath}";
  		
  		function checkName(){
	  			//var pusername=document.customerform.username.value;
					var pusername=$("#username").val();  			
					if(pusername.length==0){
						//document.getElementById("usernameError") = reference of span object
						//innerHTML is one the attribute of span object
						//document.getElementById("usernameError").innerHTML="Username cannot be empty!!!!!!!!!!";
						$("#usernameError").html("Username cannot be empty!!!!!!!!!!");
						return;
					}
					//let's make AJAX call 
					//Ajax means communicating with server for data exchage without refreshing whole page
					//with AJAX always use @ResponseBody annotation with controller code
				 	$.ajax({url: context+"/checkUsername?purva="+pusername, success: function(result){
				 		console.log(result);
				 		if(result=="yes"){
				 			$("#usernameError").html("hey this username "+pusername+" already exist");
				 		}
    				}});
  			
  		}
  		
  		function  updateImage(gender){
  			imageObj=document.getElementById("userimage");
  			if(gender=='Male'){
  				imageObj.src=context+"/img/male.jpg";
  			}else{
  				imageObj.src=context+"/img/female.jpg";
  			}
  		}
  
  		function clearText(){
  			document.getElementById("usernameError").innerHTML="";
  			document.getElementById("passwordError").innerHTML="";
  			document.getElementById("emailError").innerHTML="";
  		}
  		function validateCustomer(){
  				//this will give me the reference of input object which name is username
  				//value is one of the attribute of input object
  				var pusername=window.document.customerform.username.value;
  				if(pusername.length==0){
  					//document.getElementById("usernameError") = reference of span object
  					//innerHTML is one the attribute of span object
  					document.getElementById("usernameError").innerHTML="Username cannot be empty!!!!!!!!!!";
  					return;
  				}
  				
  				var password=window.document.customerform.password.value;
  				if(password.length==0){
  					//document.getElementById("usernameError") = reference of span object
  					//innerHTML is one the attribute of span object
  					document.getElementById("passwordError").innerHTML="Password cannot be empty!!!!!!!!!!";
  					return;
  				}
  				
  				var email=window.document.customerform.email.value;
  				if(email.length==0){
  					//document.getElementById("usernameError") = reference of span object
  					//innerHTML is one the attribute of span object
  					document.getElementById("emailError").innerHTML="Email cannot be empty!!!!!!!!!!";
  					return;
  				}
  				//Write JavaScript code to submit the form
  				document.customerform.submit();
  			
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
		<form name="customerform" action="${pageContext.request.contextPath}/register" method="post">
		<h4>${message}</h4>
		<table>
		<tr>
			<tr>
				<td>Username :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="text" name="username" id="username" style="width: 300px;display: inline;margin-right:20px;" class="form-control"  onkeypress="clearText();" onblur="checkName();"/>
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
				<input type="password" name="password" style="width: 300px;" class="form-control" onkeypress="clearText();"/>
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
				<input type="text" name="email" style="width: 500px;" class="form-control" onkeypress="clearText();"/>
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
				<select  name="role" style="width: 300px;" class="form-control">
					<option>Customer</option>
					<option>Employee</option>
				</select>
				
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
				<input type="radio" name="gender" value="male"  style="display: inline;" onclick="updateImage('Male');"> Male
  				<input type="radio" name="gender" value="female" style="display: inline;margin-left: 20px;" onclick="updateImage('Female');"> Female
				</td>
			</tr>	
			
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>Photo :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="text" name="photo" style="width: 700px;" class="form-control"/>
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
		</form>
		<hr/>
		<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>

</body>
</html>