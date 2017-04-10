package com.tpajay.javahack.core;

public class FinalStaticTest {
	
	public static void main(String[] args) {
		
		FinalStatic fs = new FinalStatic(100,4,5,6);
		fs.display();
		
		//fs.CITY = "Dallas";
		//fs.display();
		
		//fs.city = "Atlanta";
		//fs.display();
		
		System.out.println(fs.getCity());

	}

}
