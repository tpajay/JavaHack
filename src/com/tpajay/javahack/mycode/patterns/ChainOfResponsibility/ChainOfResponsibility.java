package com.tpajay.javahack.mycode.patterns.ChainOfResponsibility;

// Group of objects that can solve a problem, if the first can't it 
//passes it to the next in the chain.
public interface ChainOfResponsibility {
	
	public void setNextChain(ChainOfResponsibility nextChain);
	public void calculate(Numbers request);

}
