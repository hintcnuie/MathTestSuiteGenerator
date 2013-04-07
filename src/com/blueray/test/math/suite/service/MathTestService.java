package com.blueray.test.math.suite.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SwingWorker;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathOperator;
import com.blueray.test.math.suite.entity.MathTest;

public  class MathTestService implements MathTestInterface {
	java.util.logging.Logger logger = java.util.logging.Logger
			.getLogger(MathTestService.class.getName());

	public MathTestService() {

	}

	/**
	 * 
	 * 
	 * @see com.blueray.test.math.suite.service.MathTestInterface#generateMathTest(int,
	 *      int, int, int)
	 */
	@Override
	public List<MathTest> generateMathTest(int suiteNumber, int itemNumber,
			int start, int end, boolean addSub, boolean multipleDivide,
			DifficultyLevelEnum difficultLevel) {
		logger.info("产生" + suiteNumber + "套试卷");
		List<MathTest> testList = new ArrayList<MathTest>();
		// 产生suiteNumber套试卷
		for (int i = 0; i < suiteNumber; i++) {
			MathTest test = new MathTest(itemNumber);
			// 产生试卷中的题目，数量为itemNumber
			logger.info("产生试卷中的题目，数量为:" + itemNumber);
			List<MathItem> items = generateMathItems(itemNumber, start, end,
					addSub, multipleDivide, difficultLevel);
			test.setItemsList(items);
			testList.add(test);
		}

		return testList;
	}

	/**
	 * 产生试卷中的具体的试题
	 * 
	 * @param start
	 * @param end
	 * @param difficultLevel
	 * @param multipleDivide
	 * @param addSub
	 * @param itemNumber
	 *            试题总量
	 * @return
	 */
	public List<MathItem> generateMathItems(int totalItemNum, int start,
			int end, boolean addSub, boolean multipleDivide,
			DifficultyLevelEnum difficultLevel) {
		List<MathItem> itemsList = new ArrayList<MathItem>();
		int operandScope = end;

		// 产生试题
		/**
		 * TODO产生算数时，要保证在整个totalItemNum中，各个算数有正态分布。<br/>
		 * 以totalItemNum为30为例，即产生30以内的算数题，则要保证试题的值在1~10,10~20,20~30之间分布。
		 */
		// itemsList = generateOperands(totalItemNum, end);
		int currentNum = 0;
		Random random = new Random();
		while (currentNum < totalItemNum) {
			MathItem item = new MathItem();

			// 获得totalItemNum以内的随机数
			int firstOperand = RandomService.generateRandomNum(random,
					operandScope);
			item.setFirstOperand(firstOperand);
			int secondOperand = RandomService.generateRandomNum(random,
					operandScope);
			item.setSecondOperand(secondOperand);

			// 获取运算符
			MathOperator operator = RandomService.generateRandomOperator(
					random, addSub, multipleDivide);

			// 设置运算符
			item.setOperator(operator);

			// 对算式进行检验
			boolean continueFlag = MathTestRule.checkMathRule( item,operandScope, difficultLevel);
			if (!continueFlag) {
				continue;
			}
			// SET MathItem
			logger.info(item.toString());
			// add to itemsList
			itemsList.add(item);
			currentNum++;
			logger.info(currentNum + "试题,total：" + totalItemNum);
		}
		return itemsList;
	}
	



	

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.blueray.test.math.suite.MathTestInterface#writeTxtToDisk(java.lang
	 * .String, java.util.List)
	 */
	@Override
	public void writeTxtToDisk(String title, List<MathTest> mathTestList,
			File dist) {

		File folder = dist;

		FileService.cleanFolder(folder);
		for (int i = 0; i < mathTestList.size(); i++) {

			File file = FileService.createNewFile(folder.getAbsoluteFile()
					+ File.separator + i + ".txt");

			MathTest test = mathTestList.get(i);
			List<MathItem> items = test.getItemsList();

			FileWriter writer = null;
			try {
				writer = new FileWriter(file);
				writer.write(title + "\r\n");
				for (MathItem item : items) {
					writer.write(item.toString() + "\r\n");
				}
				writer.flush();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != writer) {
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void writeDocToDisk(String title, List<MathTest> mathTestList,
			File dist) {
		File folder = dist;
		FileService.cleanFolder(folder);

		for (int i = 0; i < mathTestList.size(); i++) {
			StringBuffer buf = new StringBuffer();
			buf.append(title).append("\r\n");
			MathTest test = mathTestList.get(i);
			test.setTitle(title);
			List<MathItem> items = test.getItemsList();
			for (MathItem item : items) {
				buf.append(item.toString()).append("\r\n");
			}
			String content = buf.toString();
			logger.info(content);
			String filename = folder.getAbsoluteFile() + File.separator + i;
			WordService.writeDoc(filename, test);

		}

	}
	@Override
	public void writeDocToDisk(String title, List<MathTest> mathTestList,
			File dist, SwingWorker worker) {

		File folder = dist;
		FileService.cleanFolder(folder);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mathTestList.size(); i++) {

			MathTest test = mathTestList.get(i);
			test.setTitle(title);
			sb.append("writing ").append(title).append(" ").append(i)
					.append(" to disk\r\n");
			logger.info(sb.toString());
			
			String filename = folder.getAbsoluteFile() + File.separator + i;
			
			WordService.writeDoc(filename, test);

		}

	}
}
