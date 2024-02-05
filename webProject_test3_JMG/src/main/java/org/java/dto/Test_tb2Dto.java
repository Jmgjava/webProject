package org.java.dto;

public class Test_tb2Dto {

	private int no;
	private String userId;
	private String userPw;
	private String email;

	public Test_tb2Dto() {
		// TODO Auto-generated constructor stub
	}

	public Test_tb2Dto(int no, String userId, String userPw, String email) {
		super();
		this.no = no;
		this.userId = userId;
		this.userPw = userPw;
		this.email = email;
	}

	public Test_tb2Dto(String userId, String userPw, String email) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.email = email;
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

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Test_tb2Dto [no=" + no + ", userId=" + userId + ", userPw=" + userPw + ", email=" + email + "]";
	}

}
