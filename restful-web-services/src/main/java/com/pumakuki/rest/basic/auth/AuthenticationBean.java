package com.pumakuki.rest.basic.auth;

public class AuthenticationBean {

	private String message;

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthenticationBean(String msg) {
		
		this.message = msg;
	}
	

}
