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
   <h1>Login Form</h1>
<form action="SendMail" method="post">

EmailID  <input type="text" name="name" />
Password <input type="email" name="email" />
          <input type="submit" value="Login" />
</form>


<br/><br/><br/><br/><br/><br/><br/>

  <form action="ForgetPwdAction" method="post">
         Enter EmailID<input type="email" name="emailid" />
         <input type="submit" value="Recover Password" />
  </form>


<br/><br/><br/><br/><br/><br/><br/>
  ${omsg}
<% 
    Integer num=(Integer)request.getAttribute("num");
if(num!=null)  
if(num==1)
  {
%>

 <form action="GetPwdAction" method="post">
         Enter OTP<input type="number" name="otp" />
         <input type="submit" value="Recover Password" />
  </form>

<%}%>






</body>
</html>