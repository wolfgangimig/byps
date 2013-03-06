package com.wilutions.byps.test.api.remote;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.prim.PrimitiveTypes;

public interface RemoteListTypes extends BRemote {
	public List<Boolean> getBoolean1() ;
	public void setBoolean1(List<Boolean> boolean1) ;
	public List<Byte> getByte1() ;
	public void setByte1(List<Byte> byte1) ;
	public List<Character> getChar1() ;
	public void setChar1(List<Character> char1) ;
	public List<Short> getShort1() ;
	public void setShort1(List<Short> short1) ;
	public List<Integer> getInt1() ;
	public void setInt1(List<Integer> int1) ;
	public List<Long> getLong1() ;
	public void setLong1(List<Long> long1) ;
	public List<Float> getFloat1() ;
	public void setFloat1(List<Float> float1) ;
	public List<Double> getDouble1() ;
	public void setDouble1(List<Double> double1) ;
	public List<String> getString1() ;
	public void setString1(List<String> string1) ;
	public List<PrimitiveTypes> getPrimitiveTypes1() ;
	public void setPrimitiveTypes1(List<PrimitiveTypes> primitiveTypes1) ;
	public List<byte[]> getByte2() ;
	public void setByte2(List<byte[]> byte2) ;
	public List<int[]> getInt2() ;
	public void setInt2(List<int[]> int2) ;
	public List getObj1() ;
	public void setObj1(List obj1) ;

	public List<List<Integer>> getInt3() ;
	public void setInt3(List<List<Integer>> int3) ;
	public List<Map<Integer,List<TreeSet<Integer>>>> getInt4() ;
	public void setInt4(List<Map<Integer,List<TreeSet<Integer>>>> int4) ;

}
