package authPACK;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pojoClasses.User;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	  String username = request.getParameter("username");
	  String password = request.getParameter("password");

		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session ses = factory.openSession();

	  try
	  {

			   User c = ses.get(User.class, password);
 			  if(c!=null)
			  {
					System.out.println(" Matched " + password + " - " + c.getPassword());			 
				 String password1= c.getPassword();
				  HttpSession session = request.getSession(true);
				  session.setAttribute("password", password);

				  

				  RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
				rd.forward(request, response);			 
			  	 
				
			  }

			else
			{
				System.out.println("Not found ");
			
				PrintWriter out=response.getWriter();  
		        
		        out.print("<h3> Please Enter Valid Credentials </h3>"); 		          
 				RequestDispatcher rd = request.getRequestDispatcher("LoginPage.html");
					rd.forward(request, response);			 


  

			
			}

	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  RequestDispatcher rd = request.getRequestDispatcher("LoginPage.html");
			rd.forward(request, response);
	  }
	  finally
	  {
		  ses.close();
			factory.close();
	  }
	
	}

}
