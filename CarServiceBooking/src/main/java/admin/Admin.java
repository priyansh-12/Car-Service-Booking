package admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		 String userId = request.getParameter("adminID");
	     String passkey = request.getParameter("adminPASS");
	     String ID = new String("priyansh");
	     String Password = new String("maltare");
	     if(userId.equals(ID) && passkey.equals(Password))
	     {
	    	 System.out.println("Success ");
	    	 RequestDispatcher rd = request.getRequestDispatcher("Registration.html");
	    	 rd.forward(request, response);
	     }
	     else
	     {
	    	 RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.html");
	    	 rd.forward(request, response);
	     }
	
	}

}
