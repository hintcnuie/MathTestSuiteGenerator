package com.blueray.test.math.suite.entity;

public enum MathOperator {
	ADDITION(" + "),SUBSTRACT(" - "),MULTIPLE(" × "),DIVIDE(" ÷ ");
	private String context;
	private MathOperator(String context){
		this.context=context;
	}
	public String getContext(){
		return this.context;
	}
}
