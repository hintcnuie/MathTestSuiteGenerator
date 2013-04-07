package com.blueray.test.math.suite.service;

import java.util.logging.Logger;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathOperator;

public class MathTestRuleMultiple implements MathTestRuleInterface{
	Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public boolean checkRule(MathItem item, int operandScope,
			DifficultyLevelEnum difficultLevel) {
		int firstOperator = item.getFirstOperand();
		int secondOperator = item.getSecondOperand();
		MathOperator operator = item.getOperator();

		String logPrefix = firstOperator + ":" + secondOperator;
		/**
		 * 对于加法，要求两个算数之和不可以超过totalItemNum，即totalItemNum以内的加减法.
		 */
		if (operator.equals(MathOperator.MULTIPLE)) {
			int result=firstOperator * secondOperator;
			if ( result> operandScope) {
				logger.info(logPrefix + "算数之和不能超过" + operandScope);
				return false;
			}
			if(firstOperator==1||secondOperator==1){
				logger.info(logPrefix + "两个数字不能同时为1");
				return false;
			}
			
		}
		return true;
	}

}
