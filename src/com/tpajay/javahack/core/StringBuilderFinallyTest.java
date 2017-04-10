package com.tpajay.javahack.core;

public class StringBuilderFinallyTest {
	
	public static void main(String[] args){
		
		//Output = String1String2+1 because finally ALWAYS executes.
		//unless you use a System.exit(0);
		System.out.println(setOne().toString());
		
	}

	protected static StringBuilder setOne() {
		
	    StringBuilder builder=new StringBuilder();
	    
	    try{
	    	
	        builder.append("String1");
	        //System.exit(0);
	        return builder.append("String2"); //return here but still calls finally.
	        	        
	    }finally{
	    	
	        builder.append("+1");
	    }
	}

}
