package com.tpajay.javahack.patterns.ChainOfResponsibility;

public class TestCalc {
	
	public static void main(String args[]){
		
		ChainOfResponsibility chain1 = new AddNumbers();
		ChainOfResponsibility chain2 = new SubtractNumbers();
		ChainOfResponsibility chain3 = new MultiplyNumbers();
		
		chain1.setNextChain(chain2);
		chain2.setNextChain(chain3);
		
		Numbers request;
		//request = new Numbers(4, 2, "add");
		//request = new Numbers(4, 2, "sub");
		request = new Numbers(4, 2, "mult");
		//request = new Numbers(4, 2, "pow");
		
		chain1.calculate(request);
		
	}

}
