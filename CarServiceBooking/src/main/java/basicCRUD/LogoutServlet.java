package basicCRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 
		
		PrintWriter out=response.getWriter();  
        
          
        HttpSession session=request.getSession();  
        session.removeAttribute("password");
        session.invalidate();  
        
        request.getRequestDispatcher("LoginPage.html").include(request, response);  
        out.print("You are successfully logged out!");            
          
        out.close();  
	}

}
