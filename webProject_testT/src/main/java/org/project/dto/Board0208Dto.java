package org.project.dto;

public class Board0208Dto {

	private int no;
	private String title;
	private String content;
	private String userId;

	public Board0208Dto() {
		// TODO Auto-generated constructor stub
	}

	public Board0208Dto(int no, String title, String content, String userId) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Board0208Dto [no=" + no + ", title=" + title + ", content=" + content + ", userId=" + userId + "]";
	}

}
