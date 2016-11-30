package com.hellospring.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hellospring.view.ResultView;

public class ResultEntity {	
	
	@JsonView(ResultView.ResultInfoView.class)
	private int errorCode;
	@JsonView(ResultView.ResultInfoView.class)
	private String message;
	@JsonView(ResultView.ResultInfoView.class)
	private Object data;
	
	public ResultEntity()
	{
		errorCode = 0;
		message = "";
		data = null;
	}	
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
