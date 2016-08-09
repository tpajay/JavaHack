package com.tpajay.javahack.hackerrank;

public class HackerRankTestDivImp implements HackerRankTestDivInterface {

	@Override
	public int divisorSum(int n) {
		
		// TODO Auto-generated method stub
		//////create myCalculator class off interface that adds numbers divisible by a number
		//////eg. Divisors of 6 are 1,2,3 and 6. 1+2+3+6=12
		if(n==0) n = 6;
		int total = 0;
		// Loop from 1 to 'n'
		for(int i=1;i<=n;i++) {
			// If remainder is 0 when 'n' is divided by 'i', then add it
			if(n%i==0) {
				total = total+i;
				System.out.print("HackerRankTestDivImp:" + i +", ");
			}
		}
		System.out.println("are divisors of "+ n + " -- TOTAL: " + total);
		return total;
	}
	
	

}
