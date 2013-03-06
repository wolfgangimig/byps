package com.wilutions.byps.gen.api;

import java.util.ArrayList;
import java.util.List;


public class MethodInfo extends ItemInfo {
	
	public final SerialInfo requestInfo;

	// memberInfo[0] ist return value
	// weitere memberInfo[.] sind Exceptions
	public final SerialInfo resultInfo;
	
	public final ArrayList<TypeInfo> exceptions;
	
	public RemoteInfo remoteInfo;
	
	public final static String METHOD_REQUEST_NAME_PREFIX  = "BRequest_";
	public final static String METHOD_RESULT_NAME_PREFIX  = "BResult_";
	
	public MethodInfo(String name, List<CommentInfo> comments, SerialInfo requestInfo, SerialInfo resultInfo, ArrayList<TypeInfo> exceptions) {
		super(name, comments);
		this.requestInfo = requestInfo;
		this.resultInfo = resultInfo;
		this.exceptions = exceptions != null ? exceptions : new ArrayList<TypeInfo>();
	}

	public String getQName() {
		return remoteInfo.qname + "." + name;
	}
}
