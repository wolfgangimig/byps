package com.wilutions.byps.test.api.strm;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Stream1 implements Serializable {

	public InputStream is1;
	
	private String contentType;

	private InputStream[] arrStream;
	
	private List<InputStream> listStream;
	
	public Map<Integer, InputStream> mapStream;
	
	private static final long serialVersionUID = 6436953915683226753L;

}
