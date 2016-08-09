package com.tpajay.javahack.hackerrank;

import java.util.Scanner;

//simple Scanner stdin testing
public class HackerRankTest3 {

	public static void main(String[] args) {

		System.out.println("Enter your username: ");
		System.out.println("Enter your age: ");
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		int myInt = scanner.nextInt();
		scanner.close();

		System.out.println("myString is: " + myString);
		System.out.println("myInt is: " + myInt);
    
	}
    
}
