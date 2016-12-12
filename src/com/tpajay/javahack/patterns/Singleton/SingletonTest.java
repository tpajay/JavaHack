package com.tpajay.javahack.patterns.Singleton;

public class SingletonTest {
	
	public static void main(String[] args){

		System.out.println("----------------[Singleton Class #1]--------------");		
		SingletonClass sc = SingletonClass.getInstance();
		sc.display();
		
		sc = SingletonClass.getInstance();
		sc.display();
		
		System.out.println("----------------[new SingletonClass #2]--------------");
		SingletonClass sc2 = SingletonClass.getInstance();
		sc2.display();
		
		System.out.println("----------------[new SingletonClass #3]--------------");
		SingletonClass sc3 = SingletonClass.getInstance();
		sc3.display();
		
		System.out.println("----------------[new SingletonClass #4]--------------");
		SingletonClass sc4 = SingletonClass.getInstance();
		sc4.display();
		
		System.out.println("----------------[new SingletonClass #5]--------------");
		SingletonClass sc5 = SingletonClass.getInstance();
		sc5.display();
		
		
		System.out.println("\n\n----------------[new NotSingleton Class #1]--------------");
		NotSingleton nsc1 = new NotSingleton("bob", "marley");
		nsc1.display();
		
		System.out.println("----------------[new NotSingleton Class #2]--------------");
		NotSingleton nsc2 = new NotSingleton("bob", "marley");
		nsc2.display();
		
		System.out.println("----------------[new NotSingleton Class #3]--------------");
		NotSingleton nsc3 = new NotSingleton("bob", "marley");
		nsc3.display();		
		
	}

}
