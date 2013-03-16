package com.wilutions.byps.test.api.strm;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public class Stream1 implements Serializable {

	public java.io.InputStream is1;
	private java.lang.String contentType;
	private java.io.InputStream[] arrStream;
	private java.util.List<java.io.InputStream> listStream;
	public java.util.Map<java.lang.Integer,java.io.InputStream> mapStream;
	
	private final static long serialVersionUID = 1541129345L;
	
	public Stream1() {
	}	
	
	public Stream1(java.io.InputStream is1, java.lang.String contentType, java.io.InputStream[] arrStream, java.util.List<java.io.InputStream> listStream, java.util.Map<java.lang.Integer,java.io.InputStream> mapStream) {
		this.is1 = is1;
		this.contentType = contentType;
		this.arrStream = arrStream;
		this.listStream = listStream;
		this.mapStream = mapStream;
	}	
	
	public java.lang.String getContentType(){
		if (contentType == null) contentType = "";
		return contentType;
	}
	
	public void setContentType(java.lang.String v) {
		contentType = v;
	}
	
	
	public java.io.InputStream[] getArrStream(){
		return arrStream;
	}
	
	public void setArrStream(java.io.InputStream[] v) {
		arrStream = v;
	}
	
	
	public java.util.List<java.io.InputStream> getListStream(){
		return listStream;
	}
	
	public void setListStream(java.util.List<java.io.InputStream> v) {
		listStream = v;
	}
	
	
}
