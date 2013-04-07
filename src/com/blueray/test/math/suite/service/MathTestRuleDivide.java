package com.blueray.test.math.suite.service;

import java.util.logging.Logger;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathOperator;

public class MathTestRuleDivide implements MathTestRuleInterface {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	String no_negative = "除法时，第一个数不应该小于第二个数";
	String no_one = "除法时，两个数不应该相等";
	String no_1 = "除法时，两个数不应该等于1";
	private String no_zero = "除法时，第二个数字不能为0";

	public MathTestRuleDivide() {
		logger.info("Going to MathTestRuleDivide");
	}

	@Override
	public boolean checkRule(MathItem item, int operandScope,
			DifficultyLevelEnum difficultLevel) {

		int firstOperator = item.getFirstOperand();
		int secondOperator = item.getSecondOperand();
		MathOperator operator = item.getOperator();
		String logPrefix = firstOperator + ":" + secondOperator;
		if (operator.equals(MathOperator.DIVIDE)) {

			if (firstOperator < secondOperator) {

				logger.info(logPrefix + no_negative);
				return false;
			}
			if (firstOperator == secondOperator) {

				logger.info(logPrefix + no_one);
				return false;
			}
			
			if (firstOperator == 1|| secondOperator==1) {

				logger.info(logPrefix + no_1);
				return false;
			}
			if (firstOperator == 0 || secondOperator == 0) {

				logger.info(logPrefix + no_zero);
				return false;
			}

			// 若firstOperator不能被整除，重新获取
			int result_yu = firstOperator % secondOperator;
			if(result_yu==0){
				return true;
			}else{
				return false;
			}

		}
		return true;
	}

}
