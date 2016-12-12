package com.tpajay.javahack.core;

//Just testing Multidimensional Arrays
public class MultiDimArray 
{
    public static void main( String[] args ) {
        
        String[] arrayTest = new String[] {"Bob","Kim","Johnny","Susie"};
        
        for(int i=0; i < arrayTest.length; i++) {
        	System.out.println("arrayTest: " + i + ":" + arrayTest[i]);
        }
        
        System.out.println("---------------------------------");
        		
        //multidimensional array
        String[][] arrayTest2 = new String[][] { {"Names","John",null}, { "Names2", "Bob","Kim","Johnny","Susie" } };
        
        //0,1: John
        //0,2: null
        //1,1: Bob
        //1,2: Kim
        //1,3: Johnny
        //1,4: Susie
        //System.out.println("arrayTest2: " + arrayTest2[1][4]);
        for(int i=0; i < arrayTest2.length; i++) {
        	for (int j=1; j < arrayTest2[i].length; j++) {
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
