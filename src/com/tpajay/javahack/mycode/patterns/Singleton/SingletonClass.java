package com.tpajay.javahack.mycode.patterns.Singleton;

/*
 * This pattern involves a single class which is responsible to create 
 * an object while making sure that only single object gets created.  
 * Control object creation, limiting the number of objects to one only. 
 * Since there is only one Singleton instance, any instance fields of 
 * a Singleton will occur only once per class, just like static fields. 
 * Singletons often control access to resources such as 
 * database connections or sockets.
 * 
 */
public class SingletonClass {
	
	//only one instance ever (static member)
	private static SingletonClass instance = null;
	
	private SingletonClass() {}
	
	public static SingletonClass getInstance(){
		if(instance == null) {
			System.out.println(">>>>>> instance is null");
			instance = new SingletonClass(); 
		}
		System.out.println(">>>>>> return instance, hashCode: " + instance.hashCode());
		return instance;
	}
	
	public void display(){
		System.out.println(">>>>>> in display(), hashCode: " + instance.hashCode() + " << same object!");
	}

}
