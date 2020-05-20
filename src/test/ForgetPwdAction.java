package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.doa.RegisterDao;
import com.test.utility.MailSend;

/**
 * Servlet implementation class ForgetPwdAction
 */
@WebServlet("/ForgetPwdAction")
public class ForgetPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPwdAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String email=request.getParameter("emailid");
	long l=System.currentTimeMillis();//938475843978356 time 1 jan1970 00:00AM -->till
	 String str=l+"";
	 String otp=str.substring(7);
	 int x= new RegisterDao().saveOTP(email, otp);
	 String msg="Your OTP for Password Recovery is "+otp;
	   if(x!=0)
		  new MailSend().sendMail(email,msg,"Password Recovery");
	 
	   RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	   request.setAttribute("omsg", "OTP is sent on your emailid plz confirm");
	   request.setAttribute("num", 1);
	   rd.forward(request,response);
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
