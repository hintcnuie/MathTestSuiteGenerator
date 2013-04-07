package com.blueray.test.math.suite.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 实体类，对应一套数学试卷。
 * <br/>
 * 数学试卷中包括：
 * <ol>
 * <li>标题</li>
 * <li>日期</li>
 * <li>做题时间</li>
 * <li>分数</li>
 * <li>具体题目,一套试卷可能有多个题目，是一个集合</li>
 * <li>题数</li>
 * <li>得分</li>
 * <li>做题人</li>
 * </ol>
 * @author chenzhengmin
 *
 */
public class MathTest {

	private String title;
	private Date mathDate;
	private Timestamp beginDate;
	private int itemNumbers;
	private List<MathItem> itemsList;
	public MathTest(int itemNumber) {
		this.itemNumbers=itemNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getMathDate() {
		return mathDate;
	}
	public void setMathDate(Date mathDate) {
		this.mathDate = mathDate;
	}
	public Timestamp getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}
	public int getItemNumbers() {
		return itemNumbers;
	}
	public void setItemNumbers(int itemNumbers) {
		this.itemNumbers = itemNumbers;
	}
	public List<MathItem> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<MathItem> itemsList) {
		this.itemsList = itemsList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beginDate == null) ? 0 : beginDate.hashCode());
		result = prime * result + itemNumbers;
		result = prime * result
				+ ((itemsList == null) ? 0 : itemsList.hashCode());
		result = prime * result
				+ ((mathDate == null) ? 0 : mathDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MathTest other = (MathTest) obj;
		if (beginDate == null) {
			if (other.beginDate != null)
				return false;
		} else if (!beginDate.equals(other.beginDate))
			return false;
		if (itemNumbers != other.itemNumbers)
			return false;
		if (mathDate == null) {
			if (other.mathDate != null)
				return false;
		} else if (!mathDate.equals(other.mathDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
