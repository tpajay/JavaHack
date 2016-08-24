package com.tpajay.javahack.tutorialcode;

interface ExecutableInterface {
	int execute();
}
	
class Runner {
	public void run(ExecutableInterface e) {
		System.out.println("Executing code here...");
		int value = e.execute();
		System.out.println("value = " + value);
	}
}

public class LambdaExample01 {
	
	public static void main(String args[]) {
		Runner runner = new Runner();
		runner.run(new ExecutableInterface() {
			public int execute() {
				System.out.println("Here...");
				return 7;
			}
		});
		
		System.out.println("=====================================");
		
		runner.run(() -> {
			System.out.println("Code passed in LAMBDA expression");
			return 8;
		});
	}

}
