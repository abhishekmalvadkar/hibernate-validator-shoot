package com.shoot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
	
	@NotEmpty(message = "name should not be null or empty")
	private String name;
	
	@NotEmpty(message = "username should not be null or empty")
	private String username;
	
	@NotEmpty(message = "password should not be null or empty")
	@Size(min = 8 , message = "password should have at least 8 character" )
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
