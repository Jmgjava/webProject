package org.java.dto;

import java.util.Date;

public class EmployeeDto {
	 
	 private int emp_id;
     private String emp_name;
     private String  emp_depart;
     private String emp_email ;       
     private Date date;
     // Dto만 있는
     private int count; 
      
     public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(int emp_id, String emp_name, String emp_depart, String emp_email, Date date) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_depart = emp_depart;
		this.emp_email = emp_email;
		this.date = date;
	}
    // Dto만 있는
	public void setCount(int count) {
		this.count = count;
	}
    // Dto만 있는
	public int getCount() {
		return count;
	}
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_depart() {
		return emp_depart;
	}

	public void setEmp_depart(String emp_depart) {
		this.emp_depart = emp_depart;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "EmployeeDto [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_depart=" + emp_depart
				+ ", emp_email=" + emp_email + ", date=" + date + "]";
	}
     
	
     
     
     
     
}
