package com.blueray.test.math.suite.service;

import java.util.Random;

import com.blueray.test.math.suite.entity.MathOperator;

public class RandomService {

	public RandomService() {
	}

	/**
	 * 产生一个totalItemNum以内的非负数
	 * 
	 * @param random
	 * @param totalItemNum
	 * @return
	 */
	public static int generateRandomNum(Random random, int totalItemNum) {
		int randomNum = Math.abs(random.nextInt()) % totalItemNum;
		return randomNum;
	}

	/**
	 * 需要根据addSub,multipleDivide的状态来生成操作数。<br>
	 * 如果addSubSub,multipeDivide其中有一个为真（true），则说明只产生加减运算或者乘除运算。<br>
	 * 如果addSub,multipleDivide都为真（true），则说明加减乘除运算符。
	 * 
	 * @param random
	 * @param addSub
	 *            Add or Substract operator(+ or -)
	 * @param multipleDivide
	 *            multiple or divide operator(* or /)
	 * @return
	 */
	public static MathOperator generateRandomOperator(Random random,
			boolean addSub, boolean multipleDivide) {

		MathOperator operator = null;
		int operandRandom = 0;
	
		/**
		 * if addSub==true and multipleDivide==false,select + or - operator
		 */
		
		if(addSub&&!multipleDivide){
			operandRandom = Math.abs(random.nextInt() % 2);
			if (operandRandom == 0) {
				operator = MathOperator.ADDITION;
			} else {
				operator = MathOperator.SUBSTRACT;
			}
			return operator;
		}
		/**
		 * if addSub==false and multipleDivide==true,select * or / operator
		 */
		if(multipleDivide&&!addSub){
			operandRandom = Math.abs(random.nextInt() % 2);
			if (operandRandom == 0) {
				operator = MathOperator.MULTIPLE;
			} else {
				operator = MathOperator.DIVIDE;
			}
			return operator;
		}
		/**
		 * if addSub==true and multipleDivide==true,select +,-,* or / operator
		 */
		if(addSub&&multipleDivide){
			operandRandom = Math.abs(random.nextInt() % 4);
			// 产生操作符
			if (operandRandom == 0) {
				operator = MathOperator.ADDITION;
			} else if (operandRandom == 1) {
				operator = MathOperator.SUBSTRACT;
			} else if (operandRandom == 2) {
				operator = MathOperator.MULTIPLE;
			} else {
				operator = MathOperator.DIVIDE;
			}
			return operator;
		}
		/**
		 * Invalid case:
		 * <ol>
		 *     <li>addSub==false and multipleDivide==false</li>
		 * </ol>    
		 * choose  +,-,* or / operator
		 */
		if(!addSub&&!multipleDivide){
			operandRandom = Math.abs(random.nextInt() % 4);
			// 产生操作符
			if (operandRandom == 0) {
				operator = MathOperator.ADDITION;
			} else if (operandRandom == 1) {
				operator = MathOperator.SUBSTRACT;
			} else if (operandRandom == 2) {
				operator = MathOperator.MULTIPLE;
			} else {
				operator = MathOperator.DIVIDE;
			}
			return operator;
		}
		
		return operator;
	}
}
