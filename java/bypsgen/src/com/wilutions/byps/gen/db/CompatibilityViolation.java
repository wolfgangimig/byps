package com.wilutions.byps.gen.db;

public class CompatibilityViolation {
	
	public final String msg;
	
	public CompatibilityViolation(String msg) {
		this.msg = msg;
	}
	
	public String toString()
	{
		return msg;
	}
}
