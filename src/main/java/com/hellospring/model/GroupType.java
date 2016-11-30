package com.hellospring.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GroupType {
	Children(0),
	Youth(1),
	MiddleAge(2),
	OldAge(3);
	
	private int value;
	private GroupType(int val){
		this.value = val;
	}
	
	@JsonValue
	public int getValue() {
		return value;
	}
}
