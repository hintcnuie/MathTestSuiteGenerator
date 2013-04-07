package com.blueray.test.math.suite.service;

import java.util.logging.Logger;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathOperator;

public class MathTestRule {

	private static Logger logger = Logger.getLogger(MathTestRule.class
			.getName());

	public MathTestRule() {
	}

	public static boolean checkMathRule(MathItem item, int operandScope,
			DifficultyLevelEnum difficultLevel) {

		int firstOperator = item.getFirstOperand();
		int secondOperator = item.getSecondOperand();
		MathOperator operator = item.getOperator();

		// 两个运算数任意一个中包含0，则重新取值
		if (firstOperator == 0 || secondOperator == 0) {
			logger.info(firstOperator + ":" + secondOperator
					+ "两个运算数任意一个中包含0，则重新取值");
			return false;
		}
		// 两个运算数任意一个中包含1，则重新取值
		if (firstOperator == 1 || secondOperator == 1) {
			logger.info(firstOperator + ":" + secondOperator
					+ "两个运算数任意一个中包含1，则重新取值");
			return false;
		}
		boolean check = false;
		MathTestRuleInterface checker;
		// 加减法时通用的规则检验
		checker = new MathTestRuleCommon();
		check = checker.checkRule(item, operandScope, difficultLevel);
		if (!check) {
			return check;
		}
		// 加法规则检验
		checker = new MathTestRuleAdditity();
		check = checker.checkRule(item, operandScope, difficultLevel);
		if (!check) {
			return check;
		}
		// 减法规则检验
		checker = new MathTestRuleSubstract();
		check = checker.checkRule(item, operandScope, difficultLevel);
		if (!check) {
			return check;
		}
		// 乘法规则检验
		checker = new MathTestRuleMultiple();
		check = checker.checkRule(item, operandScope, difficultLevel);
		if (!check) {
			return check;
		}

		// 除法规则检验
		checker = new MathTestRuleDivide();
		check = checker.checkRule(item, operandScope, difficultLevel);
		if (!check) {
			return check;
		}

		return true;
	}

}
