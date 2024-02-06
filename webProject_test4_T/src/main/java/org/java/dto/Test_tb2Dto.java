package org.java.dto;

public class Test_tb2Dto {
	private int no;
	private String userId;
	private int userAge;
	private String userName;

	public Test_tb2Dto() {
		// TODO Auto-generated constructor stub
	}

	public Test_tb2Dto(int no, String userId, int userAge, String userName) {
		super();
		this.no = no;
		this.userId = userId;
		this.userAge = userAge;
		this.userName = userName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Test_tb2Dto [no=" + no + ", userId=" + userId + ", userAge=" + userAge + ", userName=" + userName + "]";
	}

	

}
