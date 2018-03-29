package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.BSkeleton_RemoteMapTypes;

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
	public Map<String, Date> date1;
	
	@Override
	public Map<String, Boolean> getBoolean1() throws RemoteException {
		return boolean1;
	}

	@Override
	public void setBoolean1(Map<String, Boolean> boolean1)
			throws RemoteException {
		this.boolean1 = boolean1;
	}

	@Override
	public HashMap<Double, Byte> getByte1() throws RemoteException {
		return byte1;
	}

	@Override
	public void setByte1(HashMap<Double, Byte> byte1) throws RemoteException {
		this.byte1 = byte1;
	}

	@Override
	public TreeMap<Float, Character> getChar1() throws RemoteException {
		return char1;
	}

	@Override
	public void setChar1(TreeMap<Float, Character> char1)
			throws RemoteException {
		this.char1 = char1;
	}

	@Override
	public Map<Long, Short> getShort1() throws RemoteException {
		return short1;
	}

	@Override
	public void setShort1(Map<Long, Short> short1) throws RemoteException {
		this.short1 = short1;
	}

	@Override
	public Map<Integer, Integer> getInt1() throws RemoteException {
		return int1;
	}

	@Override
	public void setInt1(Map<Integer, Integer> int1) throws RemoteException {
		this.int1 = int1;
	}

	@Override
	public Map<Short, Long> getLong1() throws RemoteException {
		return long1;
	}

	@Override
	public void setLong1(Map<Short, Long> long1) throws RemoteException {
		this.long1 = long1;
	}

	@Override
	public Map<Character, Float> getFloat1() throws RemoteException {
		return float1;
	}

	@Override
	public void setFloat1(Map<Character, Float> float1) throws RemoteException {
		this.float1 = float1;
	}

	@Override
	public Map<Byte, Double> getDouble1() throws RemoteException {
		return double1;
	}

	@Override
	public void setDouble1(Map<Byte, Double> double1) throws RemoteException {
		this.double1 = double1;
	}

	@Override
	public Map<String, String> getString1() throws RemoteException {
		return string1;
	}

	@Override
	public void setString1(Map<String, String> string1) throws RemoteException {
		this.string1 = string1;
	}

	@Override
	public Map<Integer, PrimitiveTypes> getPrimitiveTypes1()
			throws RemoteException {
		return primitiveTypes1;
	}

	@Override
	public void setPrimitiveTypes1(Map<Integer, PrimitiveTypes> primitiveTypes1)
			throws RemoteException {
		this.primitiveTypes1 = primitiveTypes1;
	}

	@Override
	public Map<Integer, byte[]> getByte2() throws RemoteException {
		return this.byte2;
	}

	@Override
	public void setByte2(Map<Integer, byte[]> byte2) throws RemoteException {
		this.byte2 = byte2;
	}

	@Override
	public Map<Integer, int[]> getInt2() throws RemoteException {
		return int2;
	}

	@Override
	public void setInt2(Map<Integer, int[]> int2) throws RemoteException {
		this.int2 = int2;
	}

	@Override
	public Map<String, Object> getObj1() throws RemoteException {
		return obj1;
	}

	@Override
	public void setObj1(Map<String, Object> obj1) throws RemoteException {
		this.obj1 = obj1;
	}

	@Override
	public void setDate1(Map<String, Date> obj1) throws RemoteException {
	  this.date1 = obj1;
	}
	
	@Override
	public Map<String, Date> getDate1() throws RemoteException {
	  return date1;
	}
}
