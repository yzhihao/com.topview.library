package com.yezhihao.www.po;

public class UserPo {

	private String usre_name;
	private String password;
	private String type;
	private int id;
	private String user_amg;
	private String possword_request;
	private String possword_right;
	
	public UserPo() {
		super();
	}
	
	
	public String getPossword_request() {
		return possword_request;
	}


	public void setPossword_request(String possword_request) {
		this.possword_request = possword_request;
	}


	public String getPossword_right() {
		return possword_right;
	}


	public void setPossword_right(String possword_right) {
		this.possword_right = possword_right;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsre_name() {
		return usre_name;
	}
	public void setUsre_name(String usre_name) {
		this.usre_name = usre_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public UserPo(int id ,String usre_name, String password, String type) {
		super();
		this.id=id;
		this.usre_name = usre_name;
		this.password = password;
		this.type = type;
	}


	public UserPo(String usre_name, String password, String type) {
		super();
		this.usre_name = usre_name;
		this.password = password;
		this.type = type;
	}

	public String getUser_amg() {
		return user_amg;
	}


	public void setUser_amg(String user_amg) {
		this.user_amg = user_amg;
	}


	public UserPo(int id,String usre_name, String password, String type, String user_amg) {
		super();
		this.id=id;
		this.usre_name = usre_name;
		this.password = password;
		this.type = type;
		this.user_amg = user_amg;
	}
	public UserPo(String usre_name, String password, String type, String user_amg) {
		super();
		this.usre_name = usre_name;
		this.password = password;
		this.type = type;
		this.user_amg = user_amg;
	}
	
	
}