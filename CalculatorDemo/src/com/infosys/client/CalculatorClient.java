package com.infosys.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.infosys.service.Calculator;

public class CalculatorClient {
	private static final Logger logger = Logger.getLogger(CalculatorClient.class.getName());

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int sum = calculator.addition(10, 10);		
		logger.log(Level.INFO, "SUM : {0}" , sum);
	}

}
