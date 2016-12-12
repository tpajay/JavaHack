package com.tpajay.javahack.patterns.ChainOfResponsibility;

public class Numbers {
	
	private int number1;
	private int number2;
	private String calcType;
	
	public Numbers(int newNumber1, int newNumber2, String m_calcType){
		
		number1 = newNumber1;
		number2 = newNumber2;
		calcType = m_calcType;
	}	
	
	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public String getCalcType() {
		return calcType;
	}

	public void setCalcType(String calcType) {
		this.calcType = calcType;
	}

	

}
