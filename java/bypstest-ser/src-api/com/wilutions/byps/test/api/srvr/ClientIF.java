package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface ClientIF extends BRemote {

	/**
	*/
	public int incrementInt(int a) throws BException, InterruptedException;
	
	/**
	*/
	public java.util.List<java.io.InputStream> getStreams(int ctrl) throws BException, InterruptedException;
	
	/**
	*/
	public void putStreams(java.util.List<java.io.InputStream> strm, int ctrl) throws BException, InterruptedException;
	
	/**
	*/
	public ChatStructure sendChat(ChatStructure cs) throws BException, InterruptedException;
	
	
}
