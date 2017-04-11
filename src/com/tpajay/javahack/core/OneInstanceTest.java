package com.tpajay.javahack.core;

public class OneInstanceTest {
	
	public static void main(String args[]) {
		
		OneInstance instance1 = OneInstance.getInstance();
		System.out.println(instance1.hashCode());
		
		OneInstance instance2 = OneInstance.getInstance();
		System.out.println(instance2.hashCode());
		
		OneInstance instance3 = OneInstance.getInstance();
		System.out.println(instance3.hashCode());
		
		OneInstance instance4 = OneInstance.getInstance();
		System.out.println(instance4.hashCode());
		
		OneInstance instance5 = OneInstance.getInstance();
		System.out.println(instance5.hashCode());
		
	}
}
