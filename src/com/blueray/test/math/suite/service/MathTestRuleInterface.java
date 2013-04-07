package com.blueray.test.math.suite.service;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;

public interface MathTestRuleInterface {
	boolean checkRule(MathItem item, int operandScope,
			DifficultyLevelEnum difficultLevel);
}
