package com.wilutions.byps.test.api.remote;

import java.util.List;


public class FirstException extends Throwable {

	private static final long serialVersionUID = 11000L;

	// kann msg und cause nicht serialisieren.
	// Sie sind in Throwable final und können nicht über internalRead eingelesen werden.
//	public FirstException(String msg, Throwable cause) {
//		super(msg, cause);
//	}
	
	public List<String> listOfStrings;
	
	// Muss BSerializable implementieren (generiert) oder BException sein
	private Throwable cause;
	
}
