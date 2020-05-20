
<%@include file="base.jsp"%>

<style>
.container{
margin-top:120px;
}
</style>

<div class="container">

<%
String m=(String)request.getAttribute("msg");
if(m!=null)
{
%>
  <div class="alert alert-success alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <strong><%=m%></strong>
</div>
<%
} 
%>
  <pre>
  <form action="ComposeAction" method="post" enctype="multipart/form-data">
  To        <input type="email" name="to"  class="form-control" required/>
  Subject    <input type="text" name="subject" class="form-control" required/>
  Message    <textarea name="msg" rows="5" cols="50" class="form-control"></textarea>
 Attachment: <input type="file" name="file" value="" class="form-control">
             <input type="submit" value="Send" class="btn btn-success" />
           </div>
  </form>
</pre>
</div>
</body>
</html>
