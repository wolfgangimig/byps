package com.wilutions.byps.test.api.remote;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteListTypes extends BRemote {
	public List<Boolean> getBoolean1() throws BException, InterruptedException;
	public void setBoolean1(List<Boolean> boolean1) throws BException, InterruptedException;
	public List<Byte> getByte1() throws BException, InterruptedException;
	public void setByte1(List<Byte> byte1) throws BException, InterruptedException;
	public List<Character> getChar1() throws BException, InterruptedException;
	public void setChar1(List<Character> char1) throws BException, InterruptedException;
	public List<Short> getShort1() throws BException, InterruptedException;
	public void setShort1(List<Short> short1) throws BException, InterruptedException;
	public List<Integer> getInt1() throws BException, InterruptedException;
	public void setInt1(List<Integer> int1) throws BException, InterruptedException;
	public List<Long> getLong1() throws BException, InterruptedException;
	public void setLong1(List<Long> long1) throws BException, InterruptedException;
	public List<Float> getFloat1() throws BException, InterruptedException;
	public void setFloat1(List<Float> float1) throws BException, InterruptedException;
	public List<Double> getDouble1() throws BException, InterruptedException;
	public void setDouble1(List<Double> double1) throws BException, InterruptedException;
	public List<String> getString1() throws BException, InterruptedException;
	public void setString1(List<String> string1) throws BException, InterruptedException;
	public List<PrimitiveTypes> getPrimitiveTypes1() throws BException, InterruptedException;
	public void setPrimitiveTypes1(List<PrimitiveTypes> primitiveTypes1) throws BException, InterruptedException;
	public List<byte[]> getByte2() throws BException, InterruptedException;
	public void setByte2(List<byte[]> byte2) throws BException, InterruptedException;
	public List<int[]> getInt2() throws BException, InterruptedException;
	public void setInt2(List<int[]> int2) throws BException, InterruptedException;
	public List<Object> getObj1() throws BException, InterruptedException;
	public void setObj1(List<Object> obj1) throws BException, InterruptedException;

	public List<List<Integer>> getInt3() throws BException, InterruptedException;
	public void setInt3(List<List<Integer>> int3) throws BException, InterruptedException;
	public List<Map<Integer,List<TreeSet<Integer>>>> getInt4() throws BException, InterruptedException;
	public void setInt4(List<Map<Integer,List<TreeSet<Integer>>>> int4) throws BException, InterruptedException;

}
