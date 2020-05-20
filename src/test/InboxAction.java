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
import javax.servlet.http.HttpSession;

import com.test.doa.InboxDao;
import com.test.utility.InboxBean;

/**
 * Servlet implementation class InboxAction
 */
@WebServlet("/InboxAction")
public class InboxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboxAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.addHeader("pragma","no-cache");
		response.addHeader("cache-control","no-store");
		response.addHeader("expire","0");
		
		
		
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("user");
		if(user==null)
			response.sendRedirect("index.jsp");
		else {
		//doa method calling return data
		//data send inbox.jsp
		String id=request.getParameter("id");	
		 ArrayList<InboxBean>list=new InboxDao().getInboxMail(id);
		 PrintWriter out=response.getWriter();
		out.println("<table class=table table-hover >");
		out.println(" <tr>");
				out.println("      <th>SenderID</th>  <th>RecieverID</th>");
						out.println("       <th>Subject</th><th>Message</th>");
								out.println("<th>Date</th> <th></th>");
										out.println("</tr>");
		
		  for(InboxBean ib:list)
		  {
			  out.println(" <tr>");
					  out.println(" <td>"+ib.getSenderid()+"</td><td>"+ib.getRecieverid()+"></td>");
							  out.println(" <td>"+ib.getSubject()+"</td><td>"+ib.getMessage()+"</td>");
									  out.println("<td>"+ib.getDatetime()+"</td>");
											  out.println(" </tr>");
		      }

		  out.println(" </table>");
 
		 
		 
		
		
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
