package com.wilutions.byps.test.api.prim;

import java.io.Serializable;

/**
 * Example class with primitive types like boolean, int, String.
 */
public class PrimitiveTypes implements Serializable {
	
	private static final long serialVersionUID = 1000L;
	
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
	public String stringVal;
	
	/**
	 * This element can refer a an arbitrary type that implements Serializable.
	 * It cannot hold an array, List, ArrayList, etc. 
	 */
	public Object objVal; 
	public Object objVal2;
	
	/**
	 * In CSharp, value is a keyword in property setter functions.
	 * But it must not be a problem to name a member by value.
	 */
	public boolean value;
	
	
	public transient Object temp;
}
