package com.tpajay.javahack.patterns.ChainOfResponsibility;

//Group of objects that can solve a problem, if the first can't it 
//passes it to the next in the chain.
public class AddNumbers implements ChainOfResponsibility {
	
	private ChainOfResponsibility nextChain;

	@Override
	public void setNextChain(ChainOfResponsibility m_nextChain) {
		this.nextChain = m_nextChain;
		
	}

	@Override
	public void calculate(Numbers request) {		
		if(request.getCalcType() == "add") {
			System.out.println(request.getNumber1() + request.getNumber2());
		} else {
			nextChain.calculate(request);
		}
	}

	public ChainOfResponsibility getNextChain() {
		return nextChain;
	}
	
	

}
