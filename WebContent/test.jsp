
<%@include file="base.jsp"%>

<style>
.container{
margin-top:120px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
             var data="id=All"; 
            //var sub= $("#subject").val();
             
        	$("#subject").keyup(function(){
        		var data = "id="+$("#subject").val();
        		$.ajax({
        			url:  'InboxAjaxAction',
        	               data:data,
        			type:'post',
        			success:function(response) {
        			    $("#result").html(response);
        	                    //$("#msg").html(response);
        				}
        			    }); //AJAX end
        			});  //change end
        			
	$.ajax({
		url:  'InboxAjaxAction',
               data:data,
		type:'post',
		success:function(response) {
		    $("#result").html(response);
                    //$("#msg").html(response);
			}
		    }); //AJAX end

             
             });
 </script>

    <div class="container">
  <h1>Inbox</h1>
  <hr/>
 Search <input type="text" id="subject">
 <div id="result"></div>
 
</div>
