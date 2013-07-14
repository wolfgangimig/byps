package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteConstants_compare_AllTypesC implements BMethodRequest, Serializable {

	public boolean bool1s;
	public boolean bool2s;
	public char char1s;
	public java.lang.String stringNull;
	public char char2s;
	public short short1s;
	public int int1s;
	public long long1s;
	public float float1s;
	public double double1s;
	public java.lang.String string1s;
	public com.wilutions.byps.test.api.cons.AllTypesZ ALL;
	public int[] arrInt;
	public int[][][][] arrInt4;
	public java.lang.String[] arrStrings;
	public java.lang.String[][][][] arrStrings4;
	public com.wilutions.byps.test.api.cons.AllTypesZ[][] arrAll;
	
	private final static long serialVersionUID = 862752254L;
	
	@Override
	public int getRemoteId() { return 431648293; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteConstantsAsync __byps__remoteT = (RemoteConstantsAsync)__byps__remote;			
			BAsyncResultSendMethod<Boolean> __byps__outerResult = new BAsyncResultSendMethod<Boolean>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1());			
			__byps__remoteT.async_compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
