package com.bjit.training.employee.model;

public class ApiResponse {

	private String status;
	private Integer code;
	private Object result;
	private String message;
	private Object extra;

	public ApiResponse() {
		this(null);
	}

	public ApiResponse(Object result) {
		this.result = result;
		this.message = null;
	}

	public ApiResponse send(String status) {
		this.status = status;
		return this;
	}

	public ApiResponse send(String status, String message) {
		this.status = status;
		this.message = message;
		return this;
	}

	public ApiResponse send(String status, Integer code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
		return this;
	}
	
	public ApiResponse send(String status, Integer code, String message,Object extra) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.extra = extra;
		return this;
	}

	public Object getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return this.status;
	}

	public Integer getCode() {
		return code;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}

}
