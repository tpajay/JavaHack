package com.tpajay.javahack.hackerrank;

//Code should output:
//     #
//    ##
//   ###
//  ####
// #####
//######
public class HackerRankTest1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createStairCase(6);
	}

	static void createStairCase(int n){
	
		if(n > 100) n=100; //never more than 100
		
		int stairs=0;
		int count=0;
		int spaces = n - 1; //no space on last line
		
		while(stairs < n){
			count = 0;
			createSpaces(spaces);
			do{
				System.out.print("#");
				count++;
			}while(count <= stairs);
			//System.out.println("stairs: " + stairs);
			System.out.println("");
		
			stairs++;
			spaces--;
		
		}
	}
	
	static void createSpaces(int x){
		int y = 0;
		while (y < x) {
			System.out.print(" ");
			y++;
		}
	}
	
}
