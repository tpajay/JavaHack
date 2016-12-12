package com.tpajay.javahack.core;

public class Remainder {
	
	public static void main(String args[]) {
		
		for ( int i=0; i<100000; i++ ) {
			//Divides left hand operand by right hand operand and returns remainder
			if( i % 50 == 0 ) {
				System.out.println("(i % 50 == 0) i=" + i);
		    }
		}
	}

}//end class