package com.calstate.models;

import java.util.Objects;

public class UserData {
	private String email;
	private String password;
	private String data;
	
	public UserData() {
		super();
	}
	
	public UserData(String email, String password, String data) {
		super();
		this.email = email;
		this.password = password;
		this.data = data;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, email, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserData)) {
			return false;
		}
		UserData other = (UserData) obj;
		return Objects.equals(data, other.data) && Objects.equals(email, other.email)
				&& Objects.equals(password, other.password);
	}
	@Override
	public String toString() {
		return "UserData [email=" + email + ", password=" + password + ", data=" + data + "]";
	}
	
	
}
