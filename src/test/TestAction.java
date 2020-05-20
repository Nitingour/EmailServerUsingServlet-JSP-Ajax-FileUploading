package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.doa.InboxDao;
import com.test.utility.InboxBean;

/**
 * Servlet implementation class InboxAjaxAction
 */
@WebServlet("/InboxAjaxAction")
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	
	String id=request.getParameter("id");
		 ArrayList<InboxBean>list=new InboxDao().getInboxMail(id);
	out.println("<table class=table table-hover >"
			+" <tr>"
		    +" <th>SenderID</th>  <th>RecieverID</th>"
		      +" <th>Subject</th><th>Message</th>"
		        +"    <th>Date</th> <th></th>"
		    +"</tr>");
		  
		  for(InboxBean ib:list)
		  {
		    out.println("<tr>");
			out.println("<td>"+ib.getSenderid()+"</td><td>"+ib.getRecieverid()+"</td>");
			out.println("<td>"+ib.getSubject()+"</td><td>"+ib.getMessage()+"</td>");
			out.println("<td>"+ib.getDatetime()+"</td>");
		    out.println("</tr>");	      
		    	    }
		  out.println("</table>");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
