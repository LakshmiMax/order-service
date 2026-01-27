package com.app.order.dto;

import java.time.LocalDateTime;

public class OrderServiceResponse<T> {
    private int statusCode;
    private String message;
    private T data;
    private LocalDateTime timestamp;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public OrderServiceResponse(int status, String message, T data) {
        this.statusCode = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now(); // 👈 object created here
    }

}
