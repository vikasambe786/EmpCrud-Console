package com.jdbc.model;

import java.io.Serializable;

public class Employee implements Serializable  {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String empName;
	private int empSalary;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String empName, int empSalary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
	
}
