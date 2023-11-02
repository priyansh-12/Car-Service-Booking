package basicCRUD;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import email.RegisterEmail;
import pojoClasses.Credential;
import pojoClasses.User;

public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  HttpSession session = request.getSession(false);
		  
		try
		{ 
			Configuration cfg = new Configuration();
			cfg.configure("Hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session ses = factory.openSession();
			Transaction t = ses.beginTransaction();
			 String pass = (String)session.getAttribute("password");
	           User u = ses.get(User.class, pass);
	           //User u =  c.getU();
			
				u.setName(request.getParameter("name"));

				  u.setCar_number(request.getParameter("car_number"));

				  u.setAge(Integer.parseInt(request.getParameter("age")));

				  u.setEmail(request.getParameter("email"));

				//String phone = request.getParameter("number");

				  u.setGender(request.getParameter("gender"));

			  u.setState(request.getParameter("state"));;

				  u.setTown(request.getParameter("town"));

				  u.setOffice(request.getParameter("office"));

	 
	           
	           /*
 
		    ses.save(u);
		    
		    RegisterEmail r = new RegisterEmail();
		    r.sendMail(email);*/
	           ses.update(u);
	           t.commit();
	         ses.close();
		    factory.close();

			 RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
		    rd.forward(request, response);
		    
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			 RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.html");
			    rd.forward(request, response);
		}
		
	
	}

}
