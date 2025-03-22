package entity;

import java.util.Objects;

public class User {

	private String username;
	private String password;
	private String contactNumber;
	private String role;
	private Double accountBalance;
	
	public User(String username, String password, String contactNumber, String role, Double accountBalance) {
		this.username = username;
		this.password = password;
		this.contactNumber = contactNumber;
		this.role = role;
		this.accountBalance = accountBalance;
		
	}
	
	public String getUsername() {
		return username;	
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return username;	
	}
	
	public void setPassword(String password) {
		this.password = password;

	}
	
	public String getContactNumber() {
		return contactNumber;	
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;	
	}
	
	public void setRole(String role) {
		this.role = role;

	}	
	
	public double getAccountBalance() {
		return accountBalance;	
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;

	}	
	
	
	@Override 
	public String toString() {
		return "User{" + 
				"Username='" + username + '\'' +
				", password='" + password + '\'' +
				", contactNumber='" + contactNumber + '\'' +
				", role ='" + role + '\'' +
				", accountBalance='" + accountBalance + '\'' +
				'}';
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
}
