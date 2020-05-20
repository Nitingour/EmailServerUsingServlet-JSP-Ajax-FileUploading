
<%@include file="base.jsp"%>

<style>
.container{
margin-top:120px;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
       // alert("Welcome")  ;
       
       var mydata="id=All";
         $.ajax({
		url:  'InboxAction',
        data:mydata,
		type:'post',
		success:function(response) {
		     $("#result").html(response);
			}
		    }); //AJAX end 
    
         $("#subject").keyup(function(){
        		var mydata = "id="+$("#subject").val();
        		 $.ajax({
        				url:  'InboxAction',
        		        data:mydata,
        				type:'post',
        				success:function(response) {
        				     $("#result").html(response);
        					}
        				    }); //AJAX end 
        			});  //change end
	      
          });//ready closed
 </script>




    <div class="container">
  <h1>Inbox</h1>
  <hr/>
Search  <input type="text" id="subject" />
    <div id="result">
    
    </div>
 
</div>
