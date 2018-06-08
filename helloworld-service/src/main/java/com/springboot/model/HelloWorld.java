package com.springboot.model;

public class HelloWorld {
	public long id;
	public String message;
	
	
	
	public HelloWorld(long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}