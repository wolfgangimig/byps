package com.wilutions.byps.test.servlet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteSetTypes;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MyRemoteSetTypes extends BSkeleton_RemoteSetTypes{

	private Set< Boolean> boolean1;
	private HashSet< Byte> byte1;
	private TreeSet< Character> char1;
	private Set< Short> short1;
	private Set< Integer> int1;
	private Set< Long> long1;
	private Set< Float> float1;
	private Set< Double> double1;
	private Set< String> string1;
	private Set< PrimitiveTypes> primitiveTypes1;
	private Set< byte[]> byte2;
	private Set< int[]> int2;
	private Set obj1;
	
	
	@Override public  Set<Boolean> getBoolean1() throws BException, InterruptedException  {
		return boolean1;
	}
	@Override public  void setBoolean1(Set<Boolean> boolean1) throws BException, InterruptedException  {
		this.boolean1 = boolean1;
	}
	@Override public  HashSet<Byte> getByte1() throws BException, InterruptedException  {
		return byte1;
	}
	@Override public  void setByte1(HashSet<Byte> byte1) throws BException, InterruptedException  {
		this.byte1 = byte1;
	}
	@Override public  TreeSet<Character> getChar1() throws BException, InterruptedException  {
		return char1;
	}
	@Override public  void setChar1(TreeSet<Character> char1) throws BException, InterruptedException  {
		this.char1 = char1;
	}
	@Override public  Set<Short> getShort1() throws BException, InterruptedException  {
		return short1;
	}
	@Override public  void setShort1(Set<Short> short1) throws BException, InterruptedException  {
		this.short1 = short1;
	}
	@Override public  Set<Integer> getInt1() throws BException, InterruptedException  {
		return int1;
	}
	@Override public  void setInt1(Set<Integer> int1) throws BException, InterruptedException  {
		this.int1 = int1;
	}
	@Override public  Set<Long> getLong1() throws BException, InterruptedException  {
		return long1;
	}
	@Override public  void setLong1(Set<Long> long1) throws BException, InterruptedException  {
		this.long1 = long1;
	}
	@Override public  Set<Float> getFloat1() throws BException, InterruptedException  {
		return float1;
	}
	@Override public  void setFloat1(Set<Float> float1) throws BException, InterruptedException  {
		this.float1 = float1;
	}
	@Override public  Set<Double> getDouble1() throws BException, InterruptedException  {
		return double1;
	}
	@Override public  void setDouble1(Set<Double> double1) throws BException, InterruptedException  {
		this.double1 = double1;
	}
	@Override public  Set<String> getString1() throws BException, InterruptedException  {
		return string1;
	}
	@Override public  void setString1(Set<String> string1) throws BException, InterruptedException  {
		this.string1 = string1;
	}
	@Override public  Set<PrimitiveTypes> getPrimitiveTypes1() throws BException, InterruptedException  {
		return primitiveTypes1;
	}
	@Override public  void setPrimitiveTypes1(Set<PrimitiveTypes> primitiveTypes1) throws BException, InterruptedException  {
		this.primitiveTypes1 = primitiveTypes1;
	}
	@Override public  Set<byte[]> getByte2() throws BException, InterruptedException  {
		return byte2;
	}
	@Override public  void setByte2(Set<byte[]> byte2) throws BException, InterruptedException  {
		this.byte2 = byte2;
	}
	@Override public  Set<int[]> getInt2() throws BException, InterruptedException  {
		return int2;
	}
	@Override public  void setInt2(Set<int[]> int2) throws BException, InterruptedException  {
		this.int2 = int2;
	}
	@Override public  Set getObj1() throws BException, InterruptedException  {
		return obj1;
	}
	@Override public  void setObj1(Set obj1) throws BException, InterruptedException  {
		this.obj1 = obj1;
	}

	
}