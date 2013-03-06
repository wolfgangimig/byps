package com.wilutions.byps.gen.api;

import java.io.IOException;

@SuppressWarnings("serial")
public class GeneratorException extends IOException {
	
	public GeneratorException(String msg) {
		super(msg);
	}
	
	public GeneratorException(String msg, Exception e) {
		super(msg, e);
	}
	
}
