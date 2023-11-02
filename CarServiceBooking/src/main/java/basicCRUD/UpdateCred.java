package basicCRUD;

import java.io.IOException;
import java.util.List;

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
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import forgetPass.SendOTP;
import pojoClasses.Credential;
import pojoClasses.User;

/**
 * Servlet implementation class UpdateCred
 */
public class UpdateCred extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		SendOTP s = new SendOTP();
		String stt = s.getEmail();
		System.out.println("Email is " + stt);
		try {
			Configuration cfg = new Configuration();
			cfg.configure("Hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session ses = factory.openSession();
			Transaction t = ses.beginTransaction(); 
			
			SendOTP ot = new SendOTP();
			String aid = ot.getEmail();
			System.out.println("Email ID " + aid + "Running properly");
//from Answer as a where  a.answer =: x 

			
			Query q = ses.createQuery(" from  User as e where e.email =: aid  ");
			q.setParameter("aid", aid);
			System.out.println("Proper");
			User c = (User) q.uniqueResult();
			  			//System.out.println("the id is " + id);
          User u = new User();
			
			u.setName(c.getName());

			  u.setCar_number(c.getCar_number());

			  u.setAge(c.getAge());

			  u.setEmail(c.getEmail());

			//String phone = request.getParameter("number");

			  u.setGender(c.getGender());

		  u.setState(c.getState());

			  u.setTown(c.getTown());

			  u.setOffice(c.getOffice());

			  u.setPassword( request.getParameter("password"));
 
			  u.setUsername(request.getParameter("username"));
         
			  u.setUser_id(c.getId());

             ses.delete(c);
             ses.save(u);

              
			
             t.commit();
			ses.close();
			factory.close();

			RequestDispatcher rd = request.getRequestDispatcher("LoginPage.html");
			rd.forward(request, response);

		}

		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.html");
			rd.forward(request, response);
		}

	}

}
