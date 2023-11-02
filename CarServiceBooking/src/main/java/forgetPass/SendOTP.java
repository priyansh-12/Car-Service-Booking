package forgetPass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.SendEmail;

/**
 * Servlet implementation class SendOTP
 */


public class SendOTP extends HttpServlet {

	   public static String getEmail() {
		return email;
	}



	public static void setEmail(String email) {
		SendOTP.email = email;
	}



	protected static String otp;
       protected static String email;
	   
	   
	public String getOtp() {
		return otp;
	}


 
	public void setOtp(String otp) {
		this.otp = otp;
	} 



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  email = request.getParameter("email");
		 GenerateOTP ot = new GenerateOTP();
		   otp =  ot.generateRandomOTP();
		 /* Email Code */
		 
 
		 SendEmail ss = new SendEmail();
		 ss.sendMail(otp, email);  
		   
		   System.out.print("The OTP is "+otp);
		 
       setOtp(otp);
       
 		 RequestDispatcher rd = request.getRequestDispatcher("GetOTP.html");
		 rd.include(request, response);
		 
 	}
 
}
