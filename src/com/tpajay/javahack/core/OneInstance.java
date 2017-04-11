package com.tpajay.javahack.core;

public class OneInstance {
	
	//can only be retrieved by method, static part of Class
	private static OneInstance instance = null;
	
	//empty private contructor
	private OneInstance() {}
	
	public static OneInstance getInstance() {
		
		if (instance == null) {
			instance = new OneInstance();
		}
		
		return instance;
	}
	
	
}
