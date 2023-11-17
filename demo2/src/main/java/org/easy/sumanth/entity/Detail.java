package org.easy.sumanth.entity;

public class Detail {
	private int user_id;
	private String user_name;
	private String email_id;
	
	public Detail(int user_id, String user_name, String email_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email_id = email_id;
	}
	public Detail(String user_name, String email_id) {
		super();
		this.user_name = user_name;
		this.email_id = email_id;
	}
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
}
