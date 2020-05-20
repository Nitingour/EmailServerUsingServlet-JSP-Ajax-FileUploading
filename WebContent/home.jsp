<!DOCTYPE html>
<%@include file="base.jsp"%>

<% 
response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");

String user1=(String)session.getAttribute("user");
if(user1==null)
	response.sendRedirect("index.jsp");

%>

<div class="container">
  <div class="jumbotron">
      <h3>Welcome  ${user} to Email Server</h3>
      <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing
      responsive, mobile-first projects on the web.</p>
    </div>

<img src="https://images.unsplash.com/photo-1453928582365-b6ad33cbcf64?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=752&q=80" alt="" />

</div>

</body>
</html>
