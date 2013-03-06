package com.wilutions.byps.test.api.map;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public class MapTypes implements Serializable {

	private static final long serialVersionUID = 4001L;
	
	public Map<String, Boolean> boolean1;
	public HashMap<Double, Byte> byte1;
	public TreeMap<Float, Character> char1;
	public Map<Long, Short> short1;
	public Map<Integer, Integer> int1;
	public Map<Short, Long> long1;
	public Map<Character, Float> float1;
	public Map<Byte, Double> double1;
	public Map<String, String> string1;
	public Map<Integer, PrimitiveTypes> primitiveTypes1;
	public Map<Integer, byte[]> byte2;
	public Map<Integer, int[]> int2;
	public Map<String, Object> obj1;
}
