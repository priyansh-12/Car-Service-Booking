package pojoClasses;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import net.bytebuddy.utility.nullability.NeverNull;
import pojoClasses.User;

@Entity
public class Credential {

	
	@Id 
	protected String password;

	@NeverNull
	protected String username;
	
	@OneToOne
	protected User u ;
	
	public Credential( String username ,String password) {
		super();
		this.password = password;
		this.username = username;
	}


	public Credential() {
		// TODO Auto-generated constructor stub
	}


	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
