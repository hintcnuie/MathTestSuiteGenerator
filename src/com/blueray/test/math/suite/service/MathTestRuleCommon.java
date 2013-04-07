package com.blueray.test.math.suite.service;

import java.util.logging.Logger;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathOperator;

public class MathTestRuleCommon implements MathTestRuleInterface {

	private static final String firstLessThan10 = ".若第一个数小于10， 1+x,2+x,3+x,4+x,5+x 都比较简单，剔除";
	private static final String secondLessThan10 = "若第二个数小于10， 1+x,2+x,3+x,4+x,5+x 都比较简单，剔除";

	private static final String bothLessthan2 = ".如果两个值都小于2，则重新取值";
	private static final String bothLessthan6 = ".如果两个值都小于6，则重新取值";
	private static final String bothLessthan10 = ".如果两个值都小于10，则重新取值";
	Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public boolean checkRule(MathItem item, int operandScope,
			DifficultyLevelEnum difficultLevel) {
		int firstOperator = item.getFirstOperand();
		int secondOperator = item.getSecondOperand();
		MathOperator operator = item.getOperator();

		String logPrefix = firstOperator + ":" + secondOperator;

		if (operator.equals(MathOperator.ADDITION)||operator.equals(MathOperator.SUBSTRACT)) {
			// 对于加减法，难度系数为EASY：如果两个值都小于2，则重新取值
			if (difficultLevel.equals(DifficultyLevelEnum.EasyDifLevel)) {
				if (firstOperator < 2 && secondOperator < 2) {
					logger.info(logPrefix + bothLessthan2);
					return false;
				}
			}
			// 对于加减法，难度系数为Middle：如果两个值都小于6，则重新取值
			if (difficultLevel.equals(DifficultyLevelEnum.MiddleDifLevel)) {
				// 对于加减法，难度系数为easy：若第一个数小于5， 1+x,2+x,3+x,4+x,5+x 都比较简单，剔除
				if (firstOperator < 6 && secondOperator < 6) {
					logger.info(logPrefix + bothLessthan6);
					return false;
				}
			}
			// 对于加减法，难度系数为Advance：如果两个值都小于10，则重新取值
			if (difficultLevel.equals(DifficultyLevelEnum.AdvancedDifLevel)) {
				if (firstOperator < 10 && secondOperator < 10) {
					logger.info(logPrefix + bothLessthan10);
					return false;
				}
				if (firstOperator < 10) {
					logger.info(logPrefix + firstLessThan10);
					return false;
				}
				if (secondOperator < 10) {
					logger.info(logPrefix + secondLessThan10);
					return false;
				}
			}
		}

		return true;
	}

}
