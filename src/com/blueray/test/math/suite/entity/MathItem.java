package com.blueray.test.math.suite.entity;

/**
 * 数学题，包含两个数字，一个操作符
 * 
 */
public class MathItem {
	/**
	 * 操作数1
	 */
	private int firstOperand;
	/**
	 * 操作数2
	 */
	private int secondOperand;
	/**
	 * 运算符
	 */
	private MathOperator operator;

	public MathItem() {

	}

	public int getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(int firstOperand) {
		this.firstOperand = firstOperand;
	}

	public int getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(int secondOperand) {
		this.secondOperand = secondOperand;
	}

	public MathOperator getOperator() {
		return operator;
	}

	public void setOperator(MathOperator operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.firstOperand).append("   ");
		buffer.append(this.operator.getContext()).append("   ");
		buffer.append(this.secondOperand).append("   ");
		buffer.append(" = _________");
		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstOperand;
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + secondOperand;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MathItem other = (MathItem) obj;
		if (firstOperand != other.firstOperand)
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (secondOperand != other.secondOperand)
			return false;
		return true;
	}

}
