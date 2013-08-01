package com.wilutions.byps.test.api.remote;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteListTypes extends BRemote {
	public List<Boolean> getBoolean1() throws RemoteException;
	public void setBoolean1(List<Boolean> boolean1) throws RemoteException;
	public List<Byte> getByte1() throws RemoteException;
	public void setByte1(List<Byte> byte1) throws RemoteException;
	public List<Character> getChar1() throws RemoteException;
	public void setChar1(List<Character> char1) throws RemoteException;
	public List<Short> getShort1() throws RemoteException;
	public void setShort1(List<Short> short1) throws RemoteException;
	public List<Integer> getInt1() throws RemoteException;
	public void setInt1(List<Integer> int1) throws RemoteException;
	public List<Long> getLong1() throws RemoteException;
	public void setLong1(List<Long> long1) throws RemoteException;
	public List<Float> getFloat1() throws RemoteException;
	public void setFloat1(List<Float> float1) throws RemoteException;
	public List<Double> getDouble1() throws RemoteException;
	public void setDouble1(List<Double> double1) throws RemoteException;
	public List<String> getString1() throws RemoteException;
	public void setString1(List<String> string1) throws RemoteException;
	public List<PrimitiveTypes> getPrimitiveTypes1() throws RemoteException;
	public void setPrimitiveTypes1(List<PrimitiveTypes> primitiveTypes1) throws RemoteException;
	public List<byte[]> getByte2() throws RemoteException;
	public void setByte2(List<byte[]> byte2) throws RemoteException;
	public List<int[]> getInt2() throws RemoteException;
	public void setInt2(List<int[]> int2) throws RemoteException;
	public List<Object> getObj1() throws RemoteException;
	public void setObj1(List<Object> obj1) throws RemoteException;

	public List<List<Integer>> getInt3() throws RemoteException;
	public void setInt3(List<List<Integer>> int3) throws RemoteException;
	public List<Map<Integer,List<TreeSet<Integer>>>> getInt4() throws RemoteException;
	public void setInt4(List<Map<Integer,List<TreeSet<Integer>>>> int4) throws RemoteException;

}
