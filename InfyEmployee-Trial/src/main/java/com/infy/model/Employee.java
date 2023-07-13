package com.infy.model;


import java.time.LocalDate;

	 

	//This is model class of employee.

	public class Employee {
	
	     private String name;

	     private Integer empId;

	     private String department;

	     private LocalDate dateOfJoining;
	 

	     public String getName() {

	           return name;

	     }

	 

	     public void setName(String name) {

	           this.name = name;

	     }

	 

	     public Integer getEmpId() {

	           return empId;

	     }

	 

	     public void setEmpId(Integer empId) {

	           this.empId = empId;

	     }

	 

	     public String getDepartment() {

	           return department;

	     }

	 

	     public void setDepartment(String department) {

	           this.department = department;

	     }

	 

	     public LocalDate getDateOfJoining() {

	           return dateOfJoining;

	     }

	 

	     public void setDateOfJoining(LocalDate dateOfJoining) {

	           this.dateOfJoining = dateOfJoining;

	     }

	 

	     public Employee(String name, Integer empId, String department, LocalDate dateOfJoining) {

	           super();

	           this.name = name;

	           this.empId = empId;

	           this.department = department;

	           this.dateOfJoining = dateOfJoining;

	     }

	 

	}