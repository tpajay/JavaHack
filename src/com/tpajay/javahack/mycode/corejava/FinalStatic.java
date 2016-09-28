package com.tpajay.javahack.mycode.corejava;

public class FinalStatic {
	
    public final double radius;
    public final double xPos;
    public final double yPos;
    public final double zPos;
    
    //marked final so it can not be changed
    //marked static so it is part of the class, not instance, so
    //only one instance of a static field exists
    //ALSO, static methods are usually like math function as they always
    //have the same output for same input (static)
    public final static String CITY = "Tampa";
    
    FinalStatic(double x, double y, double z, double r) {
         radius = r;
         xPos = x;
         yPos = y;
         zPos = z;
    }
    
    public void display() {
    	System.out.println("Radius: " + radius);
    	System.out.println("xPos: " + xPos);
    	System.out.println("yPos: " + yPos);
    	System.out.println("zPos: " + zPos);
    	System.out.println("City: " + CITY);
    	System.out.println("-----------------------------");
    }
    

}
