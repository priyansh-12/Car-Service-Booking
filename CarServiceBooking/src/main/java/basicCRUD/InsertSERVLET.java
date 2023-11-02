package basicCRUD;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import email.RegisterEmail;
import pojoClasses.Credential;
import pojoClasses.User;

/**
 * Servlet implementation class InsertSERVLET
 */
public class InsertSERVLET extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Configuration cfg = new Configuration();
			cfg.configure("Hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session ses = factory.openSession();
			Transaction t = ses.beginTransaction();
			
			String username = request.getParameter("username");

			String password = request.getParameter("password");

			String name = request.getParameter("name");

			String car_number = request.getParameter("car_number");

			int age = Integer.parseInt(request.getParameter("age"));

			String email = request.getParameter("email");

			String phone = request.getParameter("number");

			String gender = request.getParameter("gender");

			String state = request.getParameter("state");

			String town = request.getParameter("town");

			String office = request.getParameter("office");

         User u = new User(password , name , car_number , age ,email , gender ,state , town , office , username);			
  
			ses.save(u);

			t.commit();  
			RegisterEmail r = new RegisterEmail();
			r.sendMail(email);  
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
