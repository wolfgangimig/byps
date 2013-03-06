package com.wilutions.byps.test.api.remote;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteMapTypes extends BRemote {

	public Map<String, Boolean> getBoolean1();
	public void setBoolean1(Map<String, Boolean> boolean1);
	public HashMap<Double, Byte> getByte1();
	public void setByte1(HashMap<Double, Byte> byte1);
	public TreeMap<Float, Character> getChar1();
	public void setChar1(TreeMap<Float, Character> char1);
	public Map<Long, Short> getShort1();
	public void setShort1(Map<Long, Short> short1);
	public Map<Integer, Integer> getInt1();
	public void setInt1(Map<Integer, Integer> int1);
	public Map<Short, Long> getLong1();
	public void setLong1(Map<Short, Long> long1);
	public Map<Character, Float> getFloat1();
	public void setFloat1(Map<Character, Float> float1);
	public Map<Byte, Double> getDouble1();
	public void setDouble1(Map<Byte, Double> double1);
	public Map<String, String> getString1();
	public void setString1(Map<String, String> string1);
	public Map<Integer, PrimitiveTypes> getPrimitiveTypes1();
	public void setPrimitiveTypes1(Map<Integer, PrimitiveTypes> primitiveTypes1);
	public Map<Integer, byte[]> getByte2();
	public void setByte2(Map<Integer, byte[]> byte2);
	public Map<Integer, int[]> getInt2();
	public void setInt2(Map<Integer, int[]> int2);
	public Map<String, Object> getObj1();
	public void setObj1(Map<String, Object> obj1);
	
	
}
