package com.infy.validator;

import java.time.LocalDate;

import org.apache.commons.logging.LogFactory;

import com.infy.exception.InfyEmployeeException;

import com.infy.model.Employee;

public class Validator {

	/*

     * This method takes an employee object as arguments and validates all

     * attributes of it. If any attribute validation fails then

     * InfyEmployeeException is thrown with corresponding message.

     */

     public String validate(Employee employee) throws InfyEmployeeException {

           String responseStatus = null;

           if (!isValidName(employee.getName()))

                responseStatus = "Validator.INVALID_EMPLOYEE_NAME";

 

           else if (!isValidEmployeeId(employee.getEmpId()))

                responseStatus = "Validator.INVALID_EMPLOYEE_ID";

 

           else if (!isValidDepartment(employee.getDepartment()))

                responseStatus = "Validator.INVALID_DEPARTMENT";

 

           else if (!isValidDateOfJoining(employee.getDateOfJoining()))

                responseStatus = "Validator.INVALID_DOJ";

 

           if (responseStatus != null) {

                InfyEmployeeException exception = new InfyEmployeeException(responseStatus);

                LogFactory.getLog(this.getClass()).error(exception.getMessage(), exception);

                throw exception;

           } else {

                responseStatus = "Validator.SUCCESS";

                return responseStatus;

           }

     }

 

     /*

     * This method takes LocalDate object as argument. It validates the

     * dateOfJoining attribute of employee. Entered date should be before today and

     * it should be after 1-JANUARY-2000. DateOfJoining cannot be null .If any of

     * the given condition fails then it return false else it will return true.

     */

     private boolean isValidDateOfJoining(LocalDate dateOfJoining) {

           if (dateOfJoining != null && dateOfJoining.isBefore(LocalDate.now())

                     && dateOfJoining.isAfter(LocalDate.of(2000, 1, 1)))

                return true;

           return false;

     }

 

     /*

     * This method takes String object as argument. It validates the department

     * attribute of employee. Entered department is should be one from ECE, CSE, IT

     * or EEE. Department cannot be null. If any of the given condition fails then

     * it return false else it will return true.

     */

     private boolean isValidDepartment(String department) {

           if (department != null && department.matches("(ECE|CSE|IT|EEE)"))

                return true;

           return false;

     }

 

     /*

     * This method takes Integer object as argument. It validates the employeeId

     * attribute of employee. EmployeeId should contain digits only. It should have

     * four digits only and it cannot start from zero. EmployeeId cannot be null. If

     * any of the given condition fails then it return false else it will return

     * true.

     */

     private boolean isValidEmployeeId(Integer employeeId) {

           if (employeeId != null && employeeId.toString().matches("[1-9]{1}[0-9]{3}"))

                return true;

           return false;

     }

 

     /*

     * This method takes String object as argument. It validates the name attribute

     * of employee. Name can contain only alphabets and no special character is

     * allowed. Name cannot be null. If any given condition fails then it will

     * return false else it will return true.

     */

     private boolean isValidName(String name) {

           if (name != null && name.matches("[a-zA-Z]+"))

                return true;

           return false;

     }
}
