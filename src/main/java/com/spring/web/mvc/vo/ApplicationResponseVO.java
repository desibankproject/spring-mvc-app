package com.spring.web.mvc.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApplicationResponseVO {
	private String status;
	private String message;
	private String uri;
	private String exception;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "ApplicationResponseVO [status=" + status + ", message=" + message + ", uri=" + uri + ", exception="
				+ exception + "]";
	}

}
