<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Palindom</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#signin").click(function(){
			var contextPath="${pageContext.request.contextPath}";
			 //$("#customerform").serialize() = this serializing form data to send by the AJAX
			 $.ajax({url:contextPath+"/ajax-validate-user", type: 'POST',data:$("#loginform").serialize(),success:function(data) {  //data= this.responseText
					if(data.status=="success"){
						//redirect him to dashbaord!
						window.location.href="search-customer-home";
												
					}else{
						$("#emessage").html(data.message);
					}
 		  	   } //end of the callback function
 		  	});

		});
	});
</script>

</head>
<body>
	<header style="background-color: pink; height: 30px;"> Welcome
		@ BizService </header>

	<div class="container">
		<img src="${pageContext.request.contextPath}/img/users_delete.png"
			style="height: 100px;" />
		<hr />
		<span
							style="color: red; font-size: 16px;" id="emessage"></span>
		<section>
			<!--
		http://localhost:8080/spring-kb/ check
		 -->
			<form name="loginform" id="loginform">
				<table>
					<tr>
						<td>User Name :&nbsp;&nbsp;&nbsp;</td>
						<td><input type="text" name="username" style="width: 300px;"
							class="form-control" /> <span
							style="color: red; font-size: 16px;" id="usernameError"></span></td>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

					<tr>
						<td>Password :&nbsp;&nbsp;&nbsp;</td>
						<td><input type="password" name="password"
							style="width: 300px;" class="form-control" /> <span
							style="color: red; font-size: 16px;" id="passwordError"></span></td>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>
							<button type="button" id="signin" class="btn btn-danger">Sign
								In</button> &nbsp;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath}/register">
								<button type="button" class="btn btn-primary">Sign Up</button>
						</a>

						</td>
						<td></td>
					</tr>
				</table>
			</form>
			<hr />
			<span style="color: green; font-size: 18px;" id="pstatus">${appstatus}</span>
		</section>
	</div>

</body>
</html>