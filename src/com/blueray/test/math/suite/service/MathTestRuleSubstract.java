package com.blueray.test.math.suite.service;

import java.util.logging.Logger;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathOperator;

public class MathTestRuleSubstract implements MathTestRuleInterface{

	private static final String no_zero = ".算数之差不能为0，否则重新取值";
	private static final String no_negative = ".算数之差不能为负，否则重新取值";
	private static final String secondLessThan5 = ".减法中，第二个数小于5而第一个数小于11，则重新取值，因为x-1，x-2，x-3，x-4，x-5,(x<11),这类题型适用于Middle 模式时，剔除";
	private static final String secondLessThan5_Advance = ".减法中，第二个数小于5，则重新取值，因为x-1，x-2，x-3，x-4，x-5,(x<11),这类题型适用于Advance模式时，剔除，";
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public MathTestRuleSubstract() {
		logger.info("Going to MathTestRuleSubstract");
	}

	@Override
	public boolean checkRule(MathItem item, int operandScope,
			DifficultyLevelEnum difficultLevel) {

		int firstOperator = item.getFirstOperand();
		int secondOperator = item.getSecondOperand();
		MathOperator operator = item.getOperator();
		String logPrefix = firstOperator + ":" + secondOperator;
		/**
		 * 对于减法，要求算数之差不能为负数，否则调整两个算数的位置 对于减法，如果两个值都小于10，则重新取值
		 */
		if (operator.equals(MathOperator.SUBSTRACT)) {

			if (firstOperator < secondOperator) {
				logger.info(logPrefix + no_negative);
				return false;
			}
			if (firstOperator == secondOperator) {
				logger.info(logPrefix + no_zero);
				return false;
			}

			// 减法中，如果两数之差小于5，x-y=1,x-y=2,x-y=3,x-y=4，这类题型比较简单，剔除
			int result = firstOperator - secondOperator;
			if (difficultLevel.compareTo(DifficultyLevelEnum.MiddleDifLevel) == 0) {
				if (result < 5 & firstOperator < 11) {
					logger.info(logPrefix + secondLessThan5);
					return false;
				}
			}
			if (difficultLevel.compareTo(DifficultyLevelEnum.AdvancedDifLevel) == 0) {
				if (result < 5) {
					logger.info(logPrefix + secondLessThan5_Advance);
					return false;
				}
			}

		}
		return true;
	}


}
