<!DOCTYPE html>
<html lang="en">
<head>
 </head>
<body>
<%@include  file="base.jsp" %>



<script type="text/javascript">

   function validation()
   {
    var email=document.getElementById('email').value;
    var pwd=document.getElementById('pwd').value;
var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
     if(email.length ==0)
     {
document.getElementById('emailError').innerHTML="EmailID Required..."
        return false;
     }
if(!emailRegex.test(email))
{
  document.getElementById('emailError').innerHTML="EmailID is Invalid..."
          return false;

  }

   if(pwd.length ==0)
     {
       return false;
     }
   return true;
   }

</script>
<style >
  #emailError{
    color:red;
  }
  .container{
  margin-top:50px;
  }
  
</style>

<div class="container">

${msg}
  <h2>Login form</h2>
  <div class="row">
<div class="col-sm-4">
  <form action="LoginAction"  onsubmit="return validation();" method="post">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
      <span id="emailError"></span>
    </div>

    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>

    <button type="submit" class="btn btn-info">Login</button>
  </form>



  </div>
  </div>
</div>

</body>
</html>
