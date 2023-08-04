package com.infosys.test;

import java.util.logging.Logger;

import com.infosys.service.Calculator;

class CalculatorTest {
	private static final Logger logger = Logger.getLogger(CalculatorTest.class.getName());

	private Calculator calculator = new Calculator();

	void additionTest() {
		int actualSum = calculator.addition(1, 1);
		int expectedSum = 2;
		if (expectedSum == actualSum) {
			logger.info("additionTest has passed.");
		} else {
			logger.info("additionTest has failed.");
		}
	}

	public static void main(String[] args) {
		CalculatorTest calculatorTest = new CalculatorTest();
		calculatorTest.additionTest();
	}

}
