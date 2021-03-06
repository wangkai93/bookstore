package cn.edu.zzia.bookstore.domain;
// Generated 2017-3-10 14:17:41 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * User generated by hbm2java
 */
@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	private String id;
	private String username;
	private String password;
	private String cellphone;
	private String address;
	private String email;
	private Date birthday;
	private String nickname;
	private Boolean type = false;
	private Integer state = 1;

	public User() {
	}

	public User(String id, String username, String cellphone, String address, String email) {
		this.id = id;
		this.username = username;
		this.cellphone = cellphone;
		this.address = address;
		this.email = email;
	}

	public User(String id, String username, String password, String cellphone, String address, String email,
			Date birthday, String nickname) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.cellphone = cellphone;
		this.address = address;
		this.email = email;
		this.birthday = birthday;
		this.nickname = nickname;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
