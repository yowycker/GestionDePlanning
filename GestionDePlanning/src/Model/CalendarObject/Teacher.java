package Model.CalendarObject;

public class Teacher {
	private String email;
	private String phone;
	private String abbreviation;
	private String name;
	private String firstname;

	public Teacher(String email, String phone, String abbreviation, String name, String firstname){
		this.email = email;
		this.phone = phone;
		this.abbreviation = abbreviation;
		this.name = name;
		this.firstname = firstname;
	}
	
	public String getEmail(){
		return email;
	}
	public String getPhone(){
		return phone;
	}
	public String getAbbreviation(){
		return abbreviation;
	}
	public String getName(){
		return name;
	}
	public String getFirstname(){
		return firstname;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setAbbreviation(String abbreviation){
		this.abbreviation = abbreviation;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
}
