package com.example.SpringSecurityJWT.Exception;

public class AccessRoleException extends Exception {

	/**
	 * 
	 */
	public String msg;
	
	
	public AccessRoleException(String msg) {
		this.msg = msg;
	}


	public AccessRoleException() {
		// TODO Auto-generated constructor stub
	}


	private static final long serialVersionUID = 1L;

}
