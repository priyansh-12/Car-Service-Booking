package basicCRUD;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	String doing = request.getParameter("doing");
	
	if(doing.equalsIgnoreCase("aboutme"))
	{
		  RequestDispatcher rd = request.getRequestDispatcher("UserPage.jsp");	
		   rd.forward(request, response);
	}
	else if(doing.equalsIgnoreCase("book"))
	{
	    RequestDispatcher rd = request.getRequestDispatcher("ServicePage.html");	
	    rd.forward(request, response);
	}
/*	switch(doing)
	{
	case "aboutme":
	 {
	  
		// response.sendRedirect("UserPage.jsp");
	   break;
	 }
	 
	case "book":
	 {
	    RequestDispatcher rd = request.getRequestDispatcher("ServicePage.html");	
	    rd.forward(request, response);
		 // response.sendRedirect("ServicePage.html");
	    break;
	 }
	}
	*/
	}

}
