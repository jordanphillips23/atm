package atm;

public class User {
	
	
	private String name;
	private String address;
	private String ssn;
	private String phone;
	
	
	public User(String name, String address, String ssn, String phone) {

		this.name = name;
		this.address = address;
		this.ssn = ssn;
		this.phone= phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getSSN() {
		return ssn;
	}
	
	public String getPhone() {
		return phone;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
