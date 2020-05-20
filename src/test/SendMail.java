package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.doa.RegisterDao;
import com.test.utility.MailSend;



@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String name=request.getParameter("name");
		  String emailid=request.getParameter("email");
		  
		 long l=System.currentTimeMillis();//938475843978356 time 1 jan1970 00:00AM -->till
		 String str=l+"";
		 String pwd=str.substring(7);
		 String msg="Hello "+name+ ",Your Password is: "+pwd;
		 System.out.println(msg);
		
RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");		 
		 
		    int x=new RegisterDao().register(name, emailid, pwd); 
		  if(x==1)
		  {
		   new MailSend().sendMail(emailid,msg,"Password of EmailServerApp");
		  request.setAttribute("msg", "Registration Successfull, Your password is sent on your Emailid");
		  }else 
			  request.setAttribute("msg", "Registration Failed");
          rd.forward(request,response);			  
	}


}
