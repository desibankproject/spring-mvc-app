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

	function editCustomer(username){
		//Open modal using jQuery 
		alert("Hello Opening the model for username "+username);
		$("#editCustomerModal").modal("show");
		
	}	

	function openCustomerModal(){
		//Open modal using jQuery 
		$("#addCustomerModal").modal("show");
		
	}	

	function deleteCustomer(username){
		
			var url="jdelete-customers?username="+username; 
			$.getJSON(url,function(data){ //data is coming from server in which format = JSON
				//data contains JavaScipt which is automatically convert from JSON into JavaScript
				if(data.status=="success"){
					$("#emessage").html(data.message);
					$("#"+username).hide();
				}
			});
	}
  	
  
  	//This is ready handler and it would be called when dom is ready in memory!
  	$(document).ready(function(){

  		$("#customers").click(function(){
			var url="customers-json"; 
  			$.getJSON(url,function(data){ //data is coming from server in which format = JSON
  				//data contains JavaScipt which is automatically convert from JSON into JavaScript
  				var content="";
  				for(var x=0;x<data.length;x++){
  					var temp=data[x];	
  					console.log(temp);
  					//Now parse this JavaScript object data and show on html page
  					  content=content+'<tr id="'+temp.username+'">';
  					  content=content+'<td>&nbsp;'+temp.username+'</td>';
  					  content=content+'<td>&nbsp;'+temp.password+'</td>';
  					  content=content+'<td>&nbsp;'+temp.email+'</td>';
  					  content=content+'<td>&nbsp;'+temp.role+'</td>';
  					  content=content+'<td>&nbsp;'+temp.gender+'</td>';
  				     content=content+'<td>&nbsp;<img src="'+temp.photo+'" style="height:60px;"></td>';
  				   content=content+'<td>&nbsp;'+temp.doe+'</td>';
  				 content=content+'<td>&nbsp;';
				    content=content+'<a href="javascript:deleteCustomer(\''+temp.username+'\');">';	
	  				  content=content+'<img src="${pageContext.request.contextPath}/img/delete-test-icon.png" style="height: 35px;"/></a>';
	  				 content=content+'<a href="javascript:editCustomer(\''+temp.username+'\');">';
	  				  content=content+'<img src="${pageContext.request.contextPath}/img/edit.png" style="height: 35px;"/></a>';
	  				 content=content+'</td>';
  				    content=content+'</tr>';
  				}
  				
  				$("#mtable").html(content);
  			});
  	  		
  		}); 
  	  	  	
  		$("#register").click(function(){
			var contextPath="${pageContext.request.contextPath}";
			 //$.getJSON
			 //$("#customerform").serialize() = this serializing form data to send by the AJAX
			 $.ajax({url:contextPath+"/ajax-add-csutomer", type: 'POST',data:$("#customerform").serialize(),success:function(data) {  //data= this.responseText
					if(data.status=="success"){
						$("#emessage").html(data.message);
						$("#addCustomerModal").modal("hide");
					}
  		  	   } //end of the callback function
  		  	});
		}); //end of registere event	  		
  		
  		$("#searchstring").keyup(function(){
  			$("#emessage").html("");
  		});
  		//Registering click event on button which id gogogo
  		$("#gogogo").click(function(){
  			var searchstring=$("#searchstring").val();
  			if(searchstring.length==0){
  				$("#emessage").html("Hey! this search string cannot blank!");
  				$("#searchstring").focus();
  				return;
  			}
  			//make AJAX call to bring JSON data from server
  			var url="jsearch-customers?searchstring="+searchstring;
  			$.getJSON(url,function(data){ //data is coming from server in which format = JSON
  				//data contains JavaScipt which is automatically convert from JSON into JavaScript
  				var content="";
  				for(var x=0;x<data.length;x++){
  					var temp=data[x];	
  					console.log(temp);
  					//Now parse this JavaScript object data and show on html page
  					  content=content+'<tr id="'+temp.username+'">';
  					  content=content+'<td>&nbsp;'+temp.username+'</td>';
  					  content=content+'<td>&nbsp;'+temp.password+'</td>';
  					  content=content+'<td>&nbsp;'+temp.email+'</td>';
  					  content=content+'<td>&nbsp;'+temp.role+'</td>';
  					  content=content+'<td>&nbsp;'+temp.gender+'</td>';
  				      content=content+'<td>&nbsp;<img src="'+temp.photo+'" style="height:60px;"></td>';
  				      content=content+'<td>&nbsp;'+temp.doe+'</td>';
  				      content=content+'<td>&nbsp;';
  				      content=content+'<a href="javascript:deleteCustomer(\''+temp.username+'\');">';	
	  				  content=content+'<img src="${pageContext.request.contextPath}/img/delete-test-icon.png" style="height: 35px;"/></a>';
	  				 content=content+'<a href="javascript:editCustomer(\''+temp.username+'\');">';
	  				  content=content+'<img src="${pageContext.request.contextPath}/img/edit.png" style="height: 35px;"/></a>';
	  				 content=content+'</td>';
  				      content=content+'</tr>';
  				}
  				
  				$("#mtable").html(content);
  			});
  		});
  		
  	});
  
  
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
		 Search  : <input type="text" style="display: inline;width: 30%" class="form-control" id="searchstring" name="searchstring" value="${param.searchstring}">
		 <button type="button" class="btn btn-danger" id="gogogo">Go</button>
		  <button type="button" class="btn btn-danger" id="customers">All Customer</button>
		  <button type="button" class="btn btn-primary" id="addCustomer" onclick="openCustomerModal();">Add Customer</button>
		 </p>       
		 <span id="emessage" style="color:red;font-size: 16px;"></span>   
		<hr/>
		<img src="${pageContext.request.contextPath}/img/filter.png" style="display: inline;"/>
		<select  id="roles" style="width: 300px;display: inline;" class="form-control">
					<option>Customer</option>
					<option>Employee</option>
					<option>Admin</option>
		</select>
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
    <tbody id="mtable">
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
           <td>&nbsp;</td>
            <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
                <td>&nbsp;</td>
      </tr>
    
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
       
      <!--
       Here we are not using action and method
       since we are not directly sending the form data to the server
       ...Here we have to send form data using AJAX
       --> 
      <form name="customerform" id="customerform">
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
          	<button  type="button" class="btn btn-danger" id="register">Register</button> &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.jsp">Login Page</a>
        </div>
        </form>
      </div>
    </div>
  </div>
	  <!-- The Modal end-->
	  
	  
	  	  <!-- The Modal start-->
  <div class="modal fade" id="editCustomerModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
       
      <!--
       Here we are not using action and method
       since we are not directly sending the form data to the server
       ...Here we have to send form data using AJAX
       --> 
      <form name="editcustomerform" id="editcustomerform">
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
    <input type="text" class="form-control" id="eusername" name="username">
  </div>
  
  	<div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" id="epassword" name="password">
  </div>
  
  <div class="form-group">
    <label for="email">email:</label>
    <input type="email" class="form-control" id="eemail" name="email">
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
    <input type="text" class="form-control" id="ephoto" name="photo">
  </div>
        
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          	<button  type="button" class="btn btn-danger" id="eregister">Register</button> &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.jsp">Login Page</a>
        </div>
        </form>
      </div>
    </div>
  </div>
	  <!-- The Modal end-->

</body>
</html>