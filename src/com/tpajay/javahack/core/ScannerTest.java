package com.tpajay.javahack.core;

import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Name: ");
		String name = sc.next();
				
		System.out.println("Enter your Age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter your Hourly Rate: ");
		double rate = sc.nextDouble();
		
		System.out.println(
				"Name: " + name +
				"\nAge: " + age + 
				"\nRate: " + rate + "/hr");
		sc.close();
		
	}
}
   