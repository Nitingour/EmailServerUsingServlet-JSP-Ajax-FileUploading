
<%@include file="base.jsp"%>

<style>
.container{
margin-top:120px;
}
</style>

    <div class="container">
  <h1>Inbox</h1>
  <hr/>
  <%@page import="java.util.ArrayList,com.test.utility.InboxBean" %>
 
 
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
  
  <table class="table table-hover">
    <tr>
      <th>SenderID</th>  <th>RecieverID</th>
        <th>Subject</th><th>Message</th>
          <th>Date</th> <th></th>
    </tr>
  <% 
  ArrayList<InboxBean>list=(ArrayList<InboxBean>)request.getAttribute("LIST");
  for(InboxBean ib:list)
  {
  %>
  
    <tr>
      <td><%=ib.getSenderid()%></td><td><%=ib.getRecieverid()%></td>
      <td><%=ib.getSubject()%></td><td><%=ib.getMessage()%></td>
      <td><%=ib.getDatetime()%></td>
      <td><a href="DeleteMailAction?id=<%=ib.getSubject()%>" class="glyphicon glyphicon-remove" onClick="return confirm('Are you sure?');"></a></td>
      
      
    </tr>
<%} %>

  </table>



</div>
