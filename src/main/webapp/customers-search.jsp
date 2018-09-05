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
  					  content=content+'<tr>';
  					  content=content+'<td>&nbsp;'+temp.username+'</td>';
  					  content=content+'<td>&nbsp;'+temp.password+'</td>';
  					  content=content+'<td>&nbsp;'+temp.email+'</td>';
  					  content=content+'<td>&nbsp;'+temp.role+'</td>';
  					  content=content+'<td>&nbsp;'+temp.gender+'</td>';
  				     content=content+'<td>&nbsp;<img src="'+temp.photo+'" style="height:60px;"></td>';
  				   content=content+'<td>&nbsp;'+temp.doe+'</td>';
  				    content=content+'<td>&nbsp;</td>';
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
		 </p>       
		 <span id="emessage" style="color:red;font-size: 16px;"></span>   
		   
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

</body>
</html>