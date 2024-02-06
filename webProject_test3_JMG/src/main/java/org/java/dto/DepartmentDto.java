package org.java.dto;

public class DepartmentDto {

	private int depart_id;
	private String depart_name;

	public DepartmentDto() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentDto(int depart_id, String depart_name) {
		super();
		this.depart_id = depart_id;
		this.depart_name = depart_name;
	}

	public int getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public String getDepart_name() {
		return depart_name;
	}

	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}

	@Override
	public String toString() {
		return "DepartmentDto [depart_id=" + depart_id + ", depart_name=" + depart_name + "]";
	}

}
