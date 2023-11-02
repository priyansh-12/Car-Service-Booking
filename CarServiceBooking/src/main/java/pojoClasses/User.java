package pojoClasses;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import net.bytebuddy.utility.nullability.NeverNull;

@Entity
public class User {

	@Id
	protected String password;

	
	
     @Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int user_id;

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	protected String name;

	protected String car_number;
  
	protected int age;
	
	protected String email;

	//String phone;

	protected String gender;

	protected String state;

	protected String town;

	protected String office;

	@NeverNull
	protected String username;
	
	
	public int getUser_id() {
		return user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
		super();
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
*/
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public int getId()
	{
		return user_id;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

 
	public User(String password, String name, String car_number, int age, String email, String gender, String state,
			String town, String office, String username) {
		super();
		this.password = password;
		this.name = name;
		this.car_number = car_number;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.state = state;
		this.town = town;
		this.office = office;
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
