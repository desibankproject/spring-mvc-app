<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <script type="text/javascript">
 	
    //creating blank object
    //Creating object using constructor function
	function Customer(name,email,education) {
 		this.name=name;
 		this.email=email;
 		this.education=education;
 		this.fun=function(){
 			console.log("_______________________");
 			console.log(this.name);
 			console.log(this.email);
 			console.log(this.education);
 			console.log("_______________________");
 		}
 	}
 	
 	var customer1 =new Customer("Nagendra","nagen@synergisticit.com","B.Tech");
 	var customer2 =new Customer("Purva","purva@synergisticit.com","BE");
 	var customer3 =new Customer("James","james@synergisticit.com","M.Tech");
 	customer1.fun();
 	customer2.fun();
 	customer3.fun();
 
 </script>
 
</head>
<body>
 	 <h1>${message}</h1>	
	<img src="${pageContext.request.contextPath}/img/createuser.png" style="height: 400px;"/>
</body>
</html>