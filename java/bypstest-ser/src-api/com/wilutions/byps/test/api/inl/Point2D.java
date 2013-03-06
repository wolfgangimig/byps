package com.wilutions.byps.test.api.inl;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * Example for an inline class.
 * Final classes cannot be evolved or derived.
 * Objects of final classes are serialized without
 * the overhead of type and reference information.
 * This optimization is especially useful in the case of
 * large arrays of small objects being serialized.
 * @inline 
*/
@SuppressWarnings("all")
public class Point2D implements BSerializable {

	public short x;
	public short y;
	
	private final static long serialVersionUID = 1835035436L;
	
	public Point2D() {
	}	
	
	public Point2D(short x, short y) {
		this.x = x;
		this.y = y;
	}	
	
}
