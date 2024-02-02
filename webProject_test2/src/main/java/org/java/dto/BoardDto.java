package org.java.dto;

public class BoardDto {

	private int no;
	private String title;
	private String content;
	private String writer;
	private String nickName;

	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int no, String title, String content, String writer, String nickName) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.nickName = nickName;
	}

	public BoardDto(String title, String content, String writer, String nickName) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.nickName = nickName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", nickName="
				+ nickName + "]";
	}

}
