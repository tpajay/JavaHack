package com.tpajay.javahack.mycode.patterns.ChainOfResponsibility;

public class SubtractNumbers implements ChainOfResponsibility {

	private ChainOfResponsibility nextChain;
	
	@Override
	public void setNextChain(ChainOfResponsibility m_nextChain) {
		this.nextChain = m_nextChain;
		
	}

	@Override
	public void calculate(Numbers request) {
		if(request.getCalcType() == "sub") {
			System.out.println(request.getNumber1() - request.getNumber2());
		} else {
			nextChain.calculate(request);
		}
		
	}

	public ChainOfResponsibility getNextChain() {
		return nextChain;
	}
	
	

}
