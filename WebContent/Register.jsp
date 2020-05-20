<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
    String m=(String)request.getAttribute("msg");
  if(m!=null)
	  out.print(m);
%>
   ${msg}
   
<form action="SendMail" method="post">

Name <input type="text" name="name" />
EmailID <input type="email" name="email" />
<input type="submit" value="Register" />


</form>
</body>
</html>