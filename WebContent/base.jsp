<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%

String user=(String)session.getAttribute("user");
%>

<nav class="navbar navbar-inverse navbar-fixed-top">

  <div class="container-fluid">
    <div class="navbar-header">

      <a class="navbar-brand" href="#">Email Server</a>
    </div>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="nav navbar-nav">
      <% if(user!=null){ %>
      <li class="active"><a href="#">Home</a></li>
      <li><a href="InboxAction">Inbox</a></li>
      <li><a href="compose.jsp">Compose</a></li>
      <li><a href="sentmail.html">Sent Item</a></li>
      <li><a href="changepwd.html">Change Password</a></li>
      <%}%>
    </ul>
    <ul class="nav navbar-nav navbar-right">
       <% if(user!=null){ %>
      <li><a href="LogoutAction"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
       <%}else {%>
     <li><a href="Register.jsp"><span class="glyphicon glyphicon-signup"></span> Register</a></li>
      <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     <%}%>
    </ul>
  </div>
  </div>
</nav>
