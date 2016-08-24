package com.tpajay.javahack.mycode.hackerrank;

import java.util.Scanner;

//sum the total of int[] array number list
public class HackerRankTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1,2,3,4,5};
		int answer = sum(test);
		System.out.println("Sum of numbers: " + answer);		    
	}

    static int sum(int[] numbers) {
        
        //example input
        //int[1,2,3,4,5] = 15
        
        int result = 0;
        int value=0;
        
        for(int x=0; x < numbers.length; x++){
            value = numbers[x];
            result = result + value;
        }
                
        return result;

    }
    
}
