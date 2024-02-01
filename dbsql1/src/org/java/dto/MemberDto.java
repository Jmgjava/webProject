package org.java.dto;

public class MemberDto {

	private int no;
	private String title;
	private String content;
	private String writer;
	private String nickname;

	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int no, String title, String content, String writer, String nickname) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.nickname = nickname;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", nickname=" + nickname + "]";
	}

}
