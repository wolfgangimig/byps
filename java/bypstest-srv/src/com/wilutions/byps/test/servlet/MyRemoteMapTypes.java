package com.wilutions.byps.test.servlet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteMapTypes;

public class MyRemoteMapTypes extends BSkeleton_RemoteMapTypes {
	
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


	@Override
	public Map<String, Boolean> getBoolean1() throws BException,
			InterruptedException {
		return boolean1;
	}

	@Override
	public void setBoolean1(Map<String, Boolean> boolean1) throws BException,
			InterruptedException {
		this.boolean1 = boolean1;
	}

	@Override
	public HashMap<Double, Byte> getByte1() throws BException,
			InterruptedException {
		return byte1;
	}

	@Override
	public void setByte1(HashMap<Double, Byte> byte1) throws BException,
			InterruptedException {
		this.byte1 = byte1;
	}

	@Override
	public TreeMap<Float, Character> getChar1() throws BException,
			InterruptedException {
		return char1;
	}

	@Override
	public void setChar1(TreeMap<Float, Character> char1) throws BException,
			InterruptedException {
		this.char1 = char1;
	}

	@Override
	public Map<Long, Short> getShort1() throws BException, InterruptedException {
		return short1;
	}

	@Override
	public void setShort1(Map<Long, Short> short1) throws BException,
			InterruptedException {
		this.short1 = short1;
	}

	@Override
	public Map<Integer, Integer> getInt1() throws BException,
			InterruptedException {
		return int1;
	}

	@Override
	public void setInt1(Map<Integer, Integer> int1) throws BException,
			InterruptedException {
		this.int1 = int1;
	}

	@Override
	public Map<Short, Long> getLong1() throws BException, InterruptedException {
		return long1;
	}

	@Override
	public void setLong1(Map<Short, Long> long1) throws BException,
			InterruptedException {
		this.long1 = long1;
	}

	@Override
	public Map<Character, Float> getFloat1() throws BException,
			InterruptedException {
		return float1;
	}

	@Override
	public void setFloat1(Map<Character, Float> float1) throws BException,
			InterruptedException {
		this.float1 = float1;
	}

	@Override
	public Map<Byte, Double> getDouble1() throws BException,
			InterruptedException {
		return double1;
	}

	@Override
	public void setDouble1(Map<Byte, Double> double1) throws BException,
			InterruptedException {
		this.double1 =double1;
	}

	@Override
	public Map<String, String> getString1() throws BException,
			InterruptedException {
		return string1;
	}

	@Override
	public void setString1(Map<String, String> string1) throws BException,
			InterruptedException {
		this.string1 = string1;
	}

	@Override
	public Map<Integer, PrimitiveTypes> getPrimitiveTypes1() throws BException,
			InterruptedException {
		return primitiveTypes1;
	}

	@Override
	public void setPrimitiveTypes1(Map<Integer, PrimitiveTypes> primitiveTypes1)
			throws BException, InterruptedException {
		this.primitiveTypes1 = primitiveTypes1;
	}

	@Override
	public Map<Integer, byte[]> getByte2() throws BException,
			InterruptedException {
		return this.byte2;
	}

	@Override
	public void setByte2(Map<Integer, byte[]> byte2) throws BException,
			InterruptedException {
		this.byte2 = byte2;
	}

	@Override
	public Map<Integer, int[]> getInt2() throws BException,
			InterruptedException {
		return int2;
	}

	@Override
	public void setInt2(Map<Integer, int[]> int2) throws BException,
			InterruptedException {
		this.int2 = int2;
	}

	@Override
	public Map<String, Object> getObj1() throws BException,
			InterruptedException {
		return obj1;
	}

	@Override
	public void setObj1(Map<String, Object> obj1) throws BException,
			InterruptedException {
		this.obj1 = obj1;
	}

}
