<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <script type="text/javascript">
 	//anonymous function
 	//function definition can be stored in a variable
 	var temp=function(num1,num2) {
 				return 100+num1+num2;		
 	};
 	console.log(temp);
 	var paa=temp(100,200);
 	console.log(paa);
 
 </script>
 
</head>
<body>
 	 <h1>${message}</h1>	
	<img src="${pageContext.request.contextPath}/img/createuser.png" style="height: 400px;"/>
</body>
</html>