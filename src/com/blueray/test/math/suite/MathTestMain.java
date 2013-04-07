package com.blueray.test.math.suite;

import java.io.File;
import java.util.List;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathTest;
import com.blueray.test.math.suite.service.MathTestInterface;
import com.blueray.test.math.suite.service.MathTestService;

public class MathTestMain {
	// static Logger logger =
	// LogManager.getLogger(MathTestMain.class.getName());
	public MathTestMain() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MathTestInterface service = new MathTestService();
		String title = "苏三四小学一年级   《数学》 寒假 作业";
		// 20 套试卷
		int suiteNumber = 20;
		// 每套试卷20道题目
		int itemNumber = 20;
		/**
		 * 30以内加减法
		 */
		int mathItemStart = 1;
		int mathItemEnd = 30;
		boolean addSub = true;
		boolean multipleDiv = false;

		List<MathTest> mathTestList = service.generateMathTest(suiteNumber,
				itemNumber, mathItemStart, mathItemEnd, addSub, multipleDiv,
				DifficultyLevelEnum.AdvancedDifLevel);

		String dist = "d:\\temp\\mathTest";
		service.writeTxtToDisk(title, mathTestList, new File(dist));
		service.writeDocToDisk(title, mathTestList, new File(dist));
	}

}
