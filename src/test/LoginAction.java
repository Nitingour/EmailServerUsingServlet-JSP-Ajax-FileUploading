package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.doa.LoginDao;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
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
		
		
		String emailid=request.getParameter("email");
String password=request.getParameter("pwd");

  int x=new LoginDao().checkLogin(emailid, password);

 if(x!=0)
{
	 HttpSession session=request.getSession();
	 session.setAttribute("user",emailid);
	response.sendRedirect("home.jsp");
}
else 
{ RequestDispatcher rd=request.getRequestDispatcher("index.jsp");		 

	request.setAttribute("msg", "Login Fail");
	
  rd.forward(request,response);	
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
