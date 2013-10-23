package byps.test.api.remote;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import byps.BRemote;
import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;

public interface RemoteMapTypes extends BRemote {

	public Map<String, Boolean> getBoolean1() throws RemoteException;
	public void setBoolean1(Map<String, Boolean> boolean1) throws RemoteException;
	public HashMap<Double, Byte> getByte1() throws RemoteException;
	public void setByte1(HashMap<Double, Byte> byte1) throws RemoteException;
	public TreeMap<Float, Character> getChar1() throws RemoteException;
	public void setChar1(TreeMap<Float, Character> char1) throws RemoteException;
	public Map<Long, Short> getShort1() throws RemoteException;
	public void setShort1(Map<Long, Short> short1) throws RemoteException;
	public Map<Integer, Integer> getInt1() throws RemoteException;
	public void setInt1(Map<Integer, Integer> int1) throws RemoteException;
	public Map<Short, Long> getLong1() throws RemoteException;
	public void setLong1(Map<Short, Long> long1) throws RemoteException;
	public Map<Character, Float> getFloat1() throws RemoteException;
	public void setFloat1(Map<Character, Float> float1) throws RemoteException;
	public Map<Byte, Double> getDouble1() throws RemoteException;
	public void setDouble1(Map<Byte, Double> double1) throws RemoteException;
	public Map<String, String> getString1() throws RemoteException;
	public void setString1(Map<String, String> string1) throws RemoteException;
	public Map<Integer, PrimitiveTypes> getPrimitiveTypes1() throws RemoteException;
	public void setPrimitiveTypes1(Map<Integer, PrimitiveTypes> primitiveTypes1) throws RemoteException;
	public Map<Integer, byte[]> getByte2() throws RemoteException;
	public void setByte2(Map<Integer, byte[]> byte2) throws RemoteException;
	public Map<Integer, int[]> getInt2() throws RemoteException;
	public void setInt2(Map<Integer, int[]> int2) throws RemoteException;
	public Map<String, Object> getObj1() throws RemoteException;
	public void setObj1(Map<String, Object> obj1) throws RemoteException;
	
	
}
