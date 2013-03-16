package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface RemoteStreams extends BRemote {

	/**
	*/
	public java.io.InputStream getImage() throws BException, InterruptedException;
	
	/**
	*/
	public void setImage(java.io.InputStream istrm) throws BException, InterruptedException;
	
	/**
	*/
	public java.util.TreeMap<java.lang.Integer,java.io.InputStream> getImages() throws BException, InterruptedException;
	
	/**
	*/
	public void setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey) throws BException, InterruptedException;
	
	/**
	*/
	public void throwLastException() throws BException, InterruptedException;
	
	/**
	*/
	public java.io.InputStream getTextStream() throws BException, InterruptedException;
	
	
}
