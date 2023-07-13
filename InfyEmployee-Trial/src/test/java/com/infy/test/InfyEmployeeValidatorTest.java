package com.infy.test;

 

import java.time.LocalDate;

 

import org.junit.Assert;

import org.junit.Rule;

import org.junit.Test;

import org.junit.rules.ExpectedException;

 

import com.infy.exception.InfyEmployeeException;

import com.infy.model.Employee;

import com.infy.validator.Validator;

 

public class InfyEmployeeValidatorTest {

     @Rule

     public ExpectedException ee = ExpectedException.none();

 

     Validator validator = new Validator();

 

     /*

     * This method test for invalid employee Id.EmployeeId should contain digits

     * only. It should have four digits only and it cannot start from zero.

     * EmployeeId cannot be null. valid inputs: 1001, 2004, 2307 invalid inputs:

     * 001, 03434, 34656

     */

     @Test

     public void validateEmployeeInvalidEmployeeId() throws Exception {

           Employee employee = new Employee("Tom", null, "IT", LocalDate.of(2020, 7, 7));

           ee.expectMessage("Validator.INVALID_EMPLOYEE_ID");

           validator.validate(employee);

          

     }

 

     /*

     * This method test for invalid employee name. Name can contain only alphabets

     * and no special character is allowed. Name cannot be null valid inputs: Tom,

     * jack, harry invalid inputs: tom9, tom&jack, tom smith

     */

     @Test

     public void validateEmployeeInvalidEmployeeName() throws Exception {

           Employee employee = new Employee("Tom9", 1001, "IT", LocalDate.of(2020, 7, 7));

           ee.expectMessage("Validator.INVALID_EMPLOYEE_NAME");

           validator.validate(employee);

     }

 

     /*

     * This method test for invalid employee department.Entered department is should

     * be one from ECE, CSE, IT or EEE. Department cannot be null. valid inputs:

     * ECE, CSE, IT, EEE invalid inputs: ece, Cse, It, eee

     */

     @Test

     public void validateEmployeeInvalidEmployeeDepartment() throws Exception {

           Employee employee = new Employee("Tom", 1001, "I", LocalDate.of(2020, 7, 7));

           ee.expectMessage("Validator.INVALID_DEPARTMENT");

           validator.validate(employee);

}

 

     /*

     * This method test for invalid employee date of joining. Entered date should be

     * before today and it should be after 1-JANUARY-2000. DateOfJoining cannot be

     * null. valid inputs: any date before today's date invalid inputs: any date

     * after today's date or before 1-1-2000

     */

     @Test

     public void validateEmployeeInvalidEmployeeDOJ()throws Exception {

           Employee employee = new Employee("Tom", 1001, "IT", LocalDate.of(1999, 7, 7));

           ee.expectMessage("Validator.INVALID_DOJ");

           validator.validate(employee);   

 

     }

 

     /* This test case contains all valid inputs */

     @Test

     public void validateEmployeeValidEmployee() throws InfyEmployeeException {

           Employee employee = new Employee("Tom", 1001, "IT", LocalDate.of(2020, 7, 7));

           String response = validator.validate(employee);

           Assert.assertEquals("Validator.SUCCESS", response);

     }

}