package com.tpajay.javahack.core;

//Just testing Multidimensional Arrays
public class MultiDimArray 
{
    public static void main( String[] args ) {
        
        String[] arrayTest = new String[] {"Bob","Kim","Johnny","Susie"};
        
        for(int i=0; i < arrayTest.length; i++) {
        	System.out.println("arrayTest: " + i + ":" + arrayTest[i]);
        }
        
        /*
	    	arrayTest: 0:Bob
	    	arrayTest: 1:Kim
	    	arrayTest: 2:Johnny
	    	arrayTest: 3:Susie
         */
        
        System.out.println("---------------------------------");
        		
        //multidimensional array
        String[][] arrayTest2 = new String[][] { {"Travis","John",null}, { "Mike", "Bob","Kim","Johnny","Susie" } };
        
        /*
	    	arrayTest2, value at [0][0] is: Travis
	    	arrayTest2, value at [0][1] is: John
	    	arrayTest2, value at [0][2] is: null
	    	arrayTest2, value at [1][0] is: Mike
	    	arrayTest2, value at [1][1] is: Bob
	    	arrayTest2, value at [1][2] is: Kim
	    	arrayTest2, value at [1][3] is: Johnny
	    	arrayTest2, value at [1][4] is: Susie
         */
        
        //System.out.println("arrayTest2: " + arrayTest2[1][4]);
        for(int i=0; i < arrayTest2.length; i++) {
        	for (int j=0; j < arrayTest2[i].length; j++) {
        		System.out.println("arrayTest2, value at [" + i + "][" + j + "] is: " + arrayTest2[i][j]);
        	}
        }

        System.out.println("---------------------------------");
   
        String multiStrArr[][] = new String[][]{
        	{"A", "B"},
        	null,
        	{"Jan", "Feb", "Mar"},
        	};
        
    }
}
