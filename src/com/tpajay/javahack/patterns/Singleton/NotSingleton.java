package com.tpajay.javahack.patterns.Singleton;

public class NotSingleton {
	
	String fname, lname;
	
	public NotSingleton(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public void display() {
		System.out.println(">>>>>> in NotSingleton display(), hashCode: " + this.hashCode() + " << diff objects!");
	}

}
