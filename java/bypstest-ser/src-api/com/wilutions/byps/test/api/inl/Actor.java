package com.wilutions.byps.test.api.inl;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public class Actor implements Serializable {

	public Point2D[] shape;
	public Matrix2D position;
	
	private final static long serialVersionUID = 171948703L;
	
	public Actor() {
	}	
	
	public Actor(Point2D[] shape, Matrix2D position) {
		this.shape = shape;
		this.position = position;
	}	
	
}
