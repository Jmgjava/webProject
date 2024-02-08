package org.project.dto;

public class Member0208Dto {

	private int no;
	private String userId;
	private String userPw;
	private String name;

	public Member0208Dto() {
		// TODO Auto-generated constructor stub
	}

	public Member0208Dto(int no, String userId, String userPw, String name) {
		super();
		this.no = no;
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member0208Dto [no=" + no + ", userId=" + userId + ", userPw=" + userPw + ", name=" + name + "]";
	}

}
