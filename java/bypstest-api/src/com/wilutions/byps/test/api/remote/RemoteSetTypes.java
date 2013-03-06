package com.wilutions.byps.test.api.remote;

import java.rmi.Remote;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteSetTypes extends Remote {

	public Set<Boolean> getBoolean1();
	public void setBoolean1(Set<Boolean> boolean1);
	public HashSet<Byte> getByte1();
	public void setByte1(HashSet<Byte> byte1);
	public TreeSet<Character> getChar1();
	public void setChar1(TreeSet<Character> char1);
	public Set<Short> getShort1();
	public void setShort1(Set<Short> short1);
	public Set<Integer> getInt1();
	public void setInt1(Set<Integer> int1);
	public Set<Long> getLong1();
	public void setLong1(Set<Long> long1);
	public Set<Float> getFloat1();
	public void setFloat1(Set<Float> float1);
	public Set<Double> getDouble1();
	public void setDouble1(Set<Double> double1);
	public Set<String> getString1();
	public void setString1(Set<String> string1);
	public Set<PrimitiveTypes> getPrimitiveTypes1();
	public void setPrimitiveTypes1(Set<PrimitiveTypes> primitiveTypes1);
	public Set<byte[]> getByte2();
	public void setByte2(Set<byte[]> byte2);
	public Set<int[]> getInt2();
	public void setInt2(Set<int[]> int2);
	public Set getObj1();
	public void setObj1(Set obj1);
	
}
