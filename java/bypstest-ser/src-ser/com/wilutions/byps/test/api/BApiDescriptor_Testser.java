package com.wilutions.byps.test.api;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BApiDescriptor_Testser { 

	public final static int VERSION = 791;
	public final static BBinaryModel BMODEL = BBinaryModel.MEDIUM;
	
	public final static BApiDescriptor instance = new BApiDescriptor(
		"Testser",
		"com.wilutions.byps.test.api",
		BMODEL,
		VERSION,
		false,
		BNegotiate.BINARY_STREAM,
		new BRegistry_Testser(BMODEL)
	);
	
	
}
