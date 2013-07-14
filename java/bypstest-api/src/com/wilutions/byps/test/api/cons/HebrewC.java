package com.wilutions.byps.test.api.cons;

import java.io.Serializable;

public class HebrewC implements Serializable {

	private static final long serialVersionUID = -197616602852940819L;
	
	private final static String aleph = "\u05D0";
	private final static String beth = "\u05D1";
	
	public final static HebrewZ ALEPH = new HebrewZ(aleph);
	public final static HebrewZ BETH = new HebrewZ(beth);
	
}
