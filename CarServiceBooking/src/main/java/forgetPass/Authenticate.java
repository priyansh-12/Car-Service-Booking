package forgetPass;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authenticate extends HttpServlet {
	
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Authenticate a = new Authenticate();
		Scanner sc = new Scanner(System.in) ;
	 String otp =  request.getParameter("otp");
	   
      SendOTP st = new SendOTP();
      String s1 = new String();
      s1 = st.getOtp();
      System.out.println("  The OTP u Entered "+ st.getOtp() );
     // int val = s1.compareTo(otp); 
      if(otp.equalsIgnoreCase(s1))
       {
    	   RequestDispatcher rd = request.getRequestDispatcher("ChangeDetails.html");
    	   rd.forward(request, response);
       }
       else
       {
    	   RequestDispatcher rr = request.getRequestDispatcher("ForgetPassword.html");
    	   rr.forward(request, response);
       }
	 
	 
	}

}
