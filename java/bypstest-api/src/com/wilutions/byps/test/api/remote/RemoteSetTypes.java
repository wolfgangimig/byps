package com.wilutions.byps.test.api.remote;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteSetTypes extends BRemote {

	public Set<Boolean> getBoolean1() throws BException, InterruptedException;
	public void setBoolean1(Set<Boolean> boolean1) throws BException, InterruptedException;
	public HashSet<Byte> getByte1() throws BException, InterruptedException;
	public void setByte1(HashSet<Byte> byte1) throws BException, InterruptedException;
	public TreeSet<Character> getChar1() throws BException, InterruptedException;
	public void setChar1(TreeSet<Character> char1) throws BException, InterruptedException;
	public Set<Short> getShort1() throws BException, InterruptedException;
	public void setShort1(Set<Short> short1) throws BException, InterruptedException;
	public Set<Integer> getInt1() throws BException, InterruptedException;
	public void setInt1(Set<Integer> int1) throws BException, InterruptedException;
	public Set<Long> getLong1() throws BException, InterruptedException;
	public void setLong1(Set<Long> long1) throws BException, InterruptedException;
	public Set<Float> getFloat1() throws BException, InterruptedException;
	public void setFloat1(Set<Float> float1) throws BException, InterruptedException;
	public Set<Double> getDouble1() throws BException, InterruptedException;
	public void setDouble1(Set<Double> double1) throws BException, InterruptedException;
	public Set<String> getString1() throws BException, InterruptedException;
	public void setString1(Set<String> string1) throws BException, InterruptedException;
	public Set<PrimitiveTypes> getPrimitiveTypes1() throws BException, InterruptedException;
	public void setPrimitiveTypes1(Set<PrimitiveTypes> primitiveTypes1) throws BException, InterruptedException;
	public Set<byte[]> getByte2() throws BException, InterruptedException;
	public void setByte2(Set<byte[]> byte2) throws BException, InterruptedException;
	public Set<int[]> getInt2() throws BException, InterruptedException;
	public void setInt2(Set<int[]> int2) throws BException, InterruptedException;
	public Set<Object> getObj1() throws BException, InterruptedException;
	public void setObj1(Set<Object> obj1) throws BException, InterruptedException;
	
}
