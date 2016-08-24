package com.tpajay.javahack.mycode.hackerrank;

//Output all divsors of a number then output the sum of all
//eg. Divisors of 6 are 1,2,3 and 6. 1+2+3+6=12
public class HackerRankTestDivisors {
	
	public static void main(String[] args) {
		
		int y = 20;
		System.out.println("value: " + y);
		int value = sumOfAll(y);
		
		/* 
		System.out.println("Get the remainder of " + y + ", 0=no remainder:");
		System.out.println("y%2 = " + y%2); //0
		System.out.println("y%3 = " + y%3); //0
		System.out.println("y%4 = " + y%4); //2
		System.out.println("10%4 = " + 10%4); //2  10/4=2.5
		System.out.println("10%2 = " + 10%2); //0  10/2=5 no remainder
		*/

	}	

	public static int sumOfAll(int x) {
		
		if(x==0) x = 6;
		int sum = 0;
		for(int i=1;i<=x;i++) {
			// If remainder is 0 when x is divided by i 
			// then it is a divisor of the number
			if(x%i==0) {
				sum = sum+i;
				System.out.print("Divisor found: " + i +"\n");
			}
		}
		System.out.println("Sum of all divisors = " + sum);
		return sum;
	}
	
	

}
