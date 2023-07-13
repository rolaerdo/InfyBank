package com.infy.userinterface;

import java.time.LocalDate;

import org.apache.commons.configuration2.builder.fluent.Configurations;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.infy.model.Employee;

import com.infy.validator.Validator;


public class Tester {
	
	public static final Log LOGGER = LogFactory.getLog(Tester.class);

	public static void main(String[] args) throws Exception {

        validateEmployee();

  }



  /*

  * This method is used to give input data and show corresponding output.

  */

  private static void validateEmployee() throws ConfigurationException {

        try {

             Employee employee = new Employee("Tom", 1001, "ECE", LocalDate.of(1001, 7, 7));

             String response = new Validator().validate(employee);
             
             LOGGER.info(new Configurations().properties("messages.properties").getProperty(response));
//             System.out.println(new Configurations().properties("messages.properties").getProperty(response));

        } catch (Exception exception) {

			/*
			 * System.out.println(
			 * 
			 * new Configurations().properties("messages.properties").getProperty(exception.
			 * getMessage()));
			 */
             
             LOGGER.info(new Configurations().properties("messages.properties").getProperty(exception.getMessage()));

        }



  }

}
