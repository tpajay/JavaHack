package com.tpajay.javahack.mycode;

//Just quickly create Object to use in sample coding..
public class Employee {
	
	String fname;
	String lname;
	String address;
	String city;
	String state;
	String zipcode;
	String fullname;
	
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Employee(){
	}	
	
	public Employee(String f_fname, String f_lname, String f_address, String f_city, String f_state, String f_zipcode){
		this.fname = f_fname;
		this.lname = f_lname;
		this.address = f_address;
		this.city = f_city;
		this.state = f_state;
		this.zipcode = f_zipcode;
		this.fullname = f_fname + " " + f_lname;
	}
		
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
