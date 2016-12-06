package com.tpajay.javahack.mycode;

public class StringBuilderFinallyTest {
	
	public static void main(String[] args){
		
		//Output = String1String2+1 because finally ALWAYS executes.
		//unless you use a System.exit(0);
		System.out.println(setOne().toString());
		
		//forces nullpointerexception, calls method on null instance.
		String name = null;
		System.out.println(name.length());
		
	}

	protected static StringBuilder setOne() {
		
	    StringBuilder builder=new StringBuilder();
	    
	    try{
	    	
	        builder.append("String1");
	        return builder.append("String2");
	        
	    }finally{
	    	
	        builder.append("+1");
	    }
	}

}
