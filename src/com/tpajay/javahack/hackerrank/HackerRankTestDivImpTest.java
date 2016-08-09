package com.tpajay.javahack.hackerrank;

public class HackerRankTestDivImpTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		HackerRankTestDivImp test = new HackerRankTestDivImp();
		int inputValue = 6;
		int value = test.divisorSum(inputValue);
		
		System.out.println("HackerRankTestDivImpTest - Input: " + inputValue);
		System.out.println("HackerRankTestDivImpTest - Total Sum of Divisors of Input: " + value);
		
		//get remainder, 0=no remainder
		//nt n=6;
		//System.out.println(n%2); //0
		//System.out.println(n%3); //0
		//System.out.println(n%4); //2
		//System.out.println(10%4); //2  10/4=2.5
		//System.out.println(10%2); //0  10/2=5 no remainder

	}

}
