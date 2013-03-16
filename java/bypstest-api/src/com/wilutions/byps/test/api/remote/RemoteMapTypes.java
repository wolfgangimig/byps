package com.wilutions.byps.test.api.remote;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteMapTypes extends BRemote {

	public Map<String, Boolean> getBoolean1() throws BException, InterruptedException;
	public void setBoolean1(Map<String, Boolean> boolean1) throws BException, InterruptedException;
	public HashMap<Double, Byte> getByte1() throws BException, InterruptedException;
	public void setByte1(HashMap<Double, Byte> byte1) throws BException, InterruptedException;
	public TreeMap<Float, Character> getChar1() throws BException, InterruptedException;
	public void setChar1(TreeMap<Float, Character> char1) throws BException, InterruptedException;
	public Map<Long, Short> getShort1() throws BException, InterruptedException;
	public void setShort1(Map<Long, Short> short1) throws BException, InterruptedException;
	public Map<Integer, Integer> getInt1() throws BException, InterruptedException;
	public void setInt1(Map<Integer, Integer> int1) throws BException, InterruptedException;
	public Map<Short, Long> getLong1() throws BException, InterruptedException;
	public void setLong1(Map<Short, Long> long1) throws BException, InterruptedException;
	public Map<Character, Float> getFloat1() throws BException, InterruptedException;
	public void setFloat1(Map<Character, Float> float1) throws BException, InterruptedException;
	public Map<Byte, Double> getDouble1() throws BException, InterruptedException;
	public void setDouble1(Map<Byte, Double> double1) throws BException, InterruptedException;
	public Map<String, String> getString1() throws BException, InterruptedException;
	public void setString1(Map<String, String> string1) throws BException, InterruptedException;
	public Map<Integer, PrimitiveTypes> getPrimitiveTypes1() throws BException, InterruptedException;
	public void setPrimitiveTypes1(Map<Integer, PrimitiveTypes> primitiveTypes1) throws BException, InterruptedException;
	public Map<Integer, byte[]> getByte2() throws BException, InterruptedException;
	public void setByte2(Map<Integer, byte[]> byte2) throws BException, InterruptedException;
	public Map<Integer, int[]> getInt2() throws BException, InterruptedException;
	public void setInt2(Map<Integer, int[]> int2) throws BException, InterruptedException;
	public Map<String, Object> getObj1() throws BException, InterruptedException;
	public void setObj1(Map<String, Object> obj1) throws BException, InterruptedException;
	
	
}
