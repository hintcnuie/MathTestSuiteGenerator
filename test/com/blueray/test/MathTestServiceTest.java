package com.blueray.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.blueray.test.math.suite.entity.MathItem;
import com.blueray.test.math.suite.entity.MathOperator;
import com.blueray.test.math.suite.entity.MathTest;
import com.blueray.test.math.suite.service.MathTestInterface;
import com.blueray.test.math.suite.service.MathTestService;
import com.blueray.test.math.suite.service.RandomService;
import com.blueray.test.math.suite.service.WordService;

public class MathTestServiceTest {

	@Test
	public void testMathTestService() {
		fail("Not yet implemented");
	}

	@Test
	public void testMathRandomOperatorAddSub() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			// 获取运算符
			MathOperator operator = RandomService.generateRandomOperator(
					random, true, false);
			System.out.println("+ or -," + i + " times:" + operator.name());

		}

	}

	@Test
	public void testMathRandomOperatorMulDiv() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			// 获取运算符
			MathOperator operator = RandomService.generateRandomOperator(
					random, false, true);
			System.out.println("+ or -," + i + " times:" + operator.name());

		}

	}

	@Test
	public void testMathRandomOperatorAll() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			// 获取运算符
			MathOperator operator = RandomService.generateRandomOperator(
					random, true, true);
			System.out.println("+ or -," + i + " times:" + operator.name());
		}

	}

	@Test
	public void testMathRandomOperatorAll_invalid() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			// 获取运算符
			MathOperator operator = RandomService.generateRandomOperator(
					random, false, false);
			System.out.println("+ or -," + i + " times:" + operator.name());
		}

	}

	@Test
	public void testDivide() {
		int a=27%3;
		if(a==0){
			System.out.print("correct");
		}else{
			System.out.print("re-gen");
		}

	}

	@Test
	public void testGenerateMathTest() {
		MathTestInterface service = new MathTestService();
		List<MathTest> list = service.generateMathTest(20, 20, 1, 30, true,
				false, null);
		System.out.println(list.size());
	}

	@Test
	public void testGenerateRandomNum() {
		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			int number1 = RandomService.generateRandomNum(random, 30);
			int number2 = RandomService.generateRandomNum(random, 30);
			System.out.println(number1 + ":" + number2);
		}
	}

	@Test
	public void testGenerateMathItem() {
		MathTestInterface service = new MathTestService();
		MathTest test = new MathTest(20);
		test.setTitle("苏三四小学一年级   《数学》 寒假 作业");
		List<MathItem> list = service.generateMathItems(20, 1, 30, false,
				false, null);
		System.out.println(list.size());
		test.setItemsList(list);

		Date date = new Date();
		long file = date.getTime();
		String dist = "d:\\temp\\1\\" + file;

		WordService.writeDoc(dist, test);

	}

	@Test
	public void testWriteToDisc() {
		MathTestInterface service = new MathTestService();
		MathTest test = new MathTest(20);
		test.setTitle("苏三四小学一年级   《数学》 寒假 作业");
		List<MathItem> list = service.generateMathItems(20, 1, 30, false,
				false, null);
		System.out.println(list.size());
		test.setItemsList(list);

		Date date = new Date();
		long file = date.getTime();
		String dist = "d:\\temp\\1\\" + file;

		WordService.writeDoc(dist, test);
	}

}
