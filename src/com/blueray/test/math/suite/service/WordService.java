package com.blueray.test.math.suite.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathTest;
import com.javadocx.CreateDocx;

public class WordService {
	public static final String subName = "姓名:____________\t";
	public static final String testDate = "日期：___________\t";
	public static final String testScore = "得分：______";
	public static final String testTime="开始时间：__________\t\t结束时间：__________";
	public static final String testFirstCol="一、数字计算";
	

	static Logger logger = Logger.getLogger(WordService.class.getName());

	public static void main(String[] args) {
		CreateDocx docx = new CreateDocx("docx");

		String text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit"
				+ " sed do eiusmod tempor incididunt ut labore et dolore magna "
				+ "aliqua. Ut enim ad minim veniam, quis nostrud exercitation "
				+ "ullamco laboris nisi ut aliquip ex ea commodo consequat. "
				+ "Duis aute irure dolor in reprehenderit in voluptate velit "
				+ "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint "
				+ "occaecat cupidatat non proident, sunt in culpa qui officia "
				+ "deserunt mollit anim id est laborum.";
		HashMap paramsText = new HashMap();
		paramsText.put("b", "single");
		paramsText.put("font", "Arial");

		docx.addText(text, paramsText);
		docx.createDocx("d:\\temp\\example_text");

	}

	public static void writeDoc(String filename, String content) {
		CreateDocx docx = new CreateDocx("docx");

		HashMap paramsText = new HashMap();
		paramsText.put("b", "single");
		paramsText.put("font", "Arial");

		docx.addText(content, paramsText);
		docx.createDocx(filename);

	}

	public static void writeDoc(String filename, MathTest test) {
		logger.info("Going to create word document " + filename);
		CreateDocx docx = new CreateDocx("docx");
		docx.setLanguage("UTF-8");

		HashMap paramsTitle = new HashMap();
		paramsTitle.put("val", "1");
		// paramsTitle.put("u", "single");
		paramsTitle.put("sz", "18");
		paramsTitle.put("font", "Blackadder ITC");
		docx.addTitle(test.getTitle(), paramsTitle);

		StringBuffer buf = new StringBuffer();
		buf.append(subName).append(testDate).append(testScore);
		String subTitle = buf.toString();
		HashMap paramsSubTitle = new HashMap();
		paramsSubTitle.put("b", "single");
		paramsSubTitle.put("font", "Arial");
		paramsSubTitle.put("sz", "15");
		docx.addText(subTitle, paramsSubTitle);
		docx.addText(testTime, paramsSubTitle);
		docx.addText("\r\n", paramsSubTitle);
		docx.addText(testFirstCol, paramsSubTitle);
		
		List<MathItem> itemList = test.getItemsList();
        
		for (int i = 0; i < itemList.size(); i++) {
			int row = i % 3;
			int column=i%4;
			MathItem item=itemList.get(i);
			String content="\t"+(i+1)+"、\t"+item.toString();
			
			logger.info(content);
			HashMap paramsItemText = new HashMap();
			paramsItemText.put("b", "single");
			paramsItemText.put("font", "Arial");
			paramsItemText.put("sz", "10");
			docx.addText(content, paramsItemText);
		}


		docx.createDocx(filename);

	}
}
