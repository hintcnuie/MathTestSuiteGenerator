package com.blueray.test.math.suite.entity;

public enum DifficultyLevelEnum {
	EasyDifLevel("EASY"), MiddleDifLevel("MIDDLE"), AdvancedDifLevel("ADVANCE");
	
	private String level;

	private DifficultyLevelEnum(String difLevel) {
		this.setLevel(difLevel);
	}

	public String getLevel() {
		return level;
	}

	private void setLevel(String level) {
		this.level = level;
	}
}
