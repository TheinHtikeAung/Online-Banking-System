package sg.com.issbank.dto;

import java.util.Date;

public class Customer {
	private String nric;
	private String name;
	private String address;
	private Date dateOfBirth;
	private String nationality;
	private String gender;
	private String userid;
	private String password;
	private Date dateOfJoining;
	
	public Customer(){
		
	}
	
	public Customer(String nric, String name, String address, Date dateOfBirth,
			String nationality, String gender, String userid, String password,
			Date dateOfJoining) {
		super();
		this.nric = nric;
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.gender = gender;
		this.userid = userid;
		this.password = password;
		this.dateOfJoining = dateOfJoining;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	@Override
	public String toString() {
		return "Customer [nric=" + nric + ", name=" + name + ", address="
				+ address + ", dateOfBirth=" + dateOfBirth + ", nationality="
				+ nationality + ", gender=" + gender + ", userid=" + userid
				+ ", password=" + password + ", dateOfJoining=" + dateOfJoining
				+ "]";
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}
	
}
