package com.TC25.bean;

public class Msg {
	private int id;
	private String toUser;
	private String fromUser;
	private String title;
	private String content;
	public Msg(String toUser, String fromUser, String title, String content) {
		super();
		this.toUser = toUser;
		this.fromUser = fromUser;
		this.title = title;
		this.content = content;
	}
	public Msg() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
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
	@Override
	public String toString() {
		return "Msg [id=" + id + ", toUser=" + toUser + ", fromUser=" + fromUser + ", title=" + title + ", content="
				+ content + "]";
	}
	
	
	
}
