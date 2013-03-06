package com.wilutions.byps.test.api.prim;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * Example class with primitive types like boolean, int, String.
*/
@SuppressWarnings("all")
public class PrimitiveTypes implements BSerializable {

	/**
	 * Boolean value.
	 * Serialized as one byte with value 1 for true and value 0 for false.
	*/
	public boolean boolVal;
	/**
	 * One byte.
	*/
	public byte byteVal;
	/**
	 * One wide (2 byte) character.
	 * Serialized as short integer in binary serialization and as string when serializing in JSON format.
	*/
	public char charVal;
	public short shortVal;
	public int intVal;
	public long longVal;
	public float floatVal;
	public double doubleVal;
	public java.lang.String stringVal;
	/**
	 * This element can refer a an arbitrary type that implements BSerializable.
	 * It cannot hold an array, List, ArrayList, etc.
	*/
	public java.lang.Object objVal;
	public java.lang.Object objVal2;
	/**
	 * In CSharp, value is a keyword in property setter functions.
	 * But it must not be a problem to name a member by value.
	*/
	public boolean value;
	public transient java.lang.Object temp;
	
	private final static long serialVersionUID = 1000L;
	
	public PrimitiveTypes() {
	}	
	
	public PrimitiveTypes(boolean boolVal, byte byteVal, char charVal, short shortVal, int intVal, long longVal, float floatVal, double doubleVal, java.lang.String stringVal, java.lang.Object objVal, java.lang.Object objVal2, boolean value, java.lang.Object temp) {
		this.boolVal = boolVal;
		this.byteVal = byteVal;
		this.charVal = charVal;
		this.shortVal = shortVal;
		this.intVal = intVal;
		this.longVal = longVal;
		this.floatVal = floatVal;
		this.doubleVal = doubleVal;
		this.stringVal = stringVal;
		this.objVal = objVal;
		this.objVal2 = objVal2;
		this.value = value;
		this.temp = temp;
	}	
	
}
