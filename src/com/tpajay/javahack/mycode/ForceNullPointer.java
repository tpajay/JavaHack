package com.tpajay.javahack.mycode;

public class ForceNullPointer {
	
	public static void main(String[] args){
		
		//forces nullpointerexception, calls method on null instance.
		String name = null;
		System.out.println(name.length());
		
	}	

}
