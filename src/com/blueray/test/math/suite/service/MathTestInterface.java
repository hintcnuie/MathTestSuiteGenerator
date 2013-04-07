package com.blueray.test.math.suite.service;

import java.io.File;
import java.util.List;

import javax.swing.SwingWorker;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathTest;

public interface MathTestInterface {

	/**
	 * 产生一套数学题试卷，这套试卷中包含suiteNumber张试卷，每张试卷中数学题目数量为itemNumber,要求数学题中的数字范围为<start
	 * ,end>
	 * 
	 * @param suiteNumber
	 *            每套数学试卷包含多少张数学试卷
	 * @param itemNumber
	 *            每张数学试卷包含多少道题目
	 * @param mathItemStart
	 *            数学题中的开始数字
	 * @param mathItemEnd
	 *            数学题中的结束数字
	 * @param difChoice
	 *            难度级别，用于难度控制
	 * @param addSubChoice
	 *            是否产生加减运算题
	 * @param mulDivChoice
	 *            是否产生乘除运算题
	 * 
	 * @return
	 */
	public abstract List<MathTest> generateMathTest(int suiteNumber,
			int itemNumber, int start, int end, boolean addSubChoice,
			boolean mulDivChoice, DifficultyLevelEnum difChoice);

	/**
	 * 将试卷以txt格式输出到文件夹中
	 * 
	 * @param title
	 * @param mathTestList
	 * @param dist
	 */
	public abstract void writeTxtToDisk(String title,
			List<MathTest> mathTestList, File dist);

	public abstract void writeDocToDisk(String title,
			List<MathTest> mathTestList, File file);

	/**
	 * 产生试卷中的具体的试题
	 * 
	 * @param start
	 * @param end
	 * @param itemNumber
	 *            试题总量
	 * @return
	 */
	public List<MathItem> generateMathItems(int totalItemNum, int start,
			int end, boolean addSub, boolean multipleDivide,
			DifficultyLevelEnum difficultLevel);

	public abstract void writeDocToDisk(String title,
			List<MathTest> mathTestList, File file, SwingWorker task);
}