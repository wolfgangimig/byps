package byps.test.api.remote;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import byps.BRemote;
import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;

public interface RemoteSetTypes extends BRemote {

	public Set<Boolean> getBoolean1() throws RemoteException;
	public void setBoolean1(Set<Boolean> boolean1) throws RemoteException;
	public HashSet<Byte> getByte1() throws RemoteException;
	public void setByte1(HashSet<Byte> byte1) throws RemoteException;
	public TreeSet<Character> getChar1() throws RemoteException;
	public void setChar1(TreeSet<Character> char1) throws RemoteException;
	public Set<Short> getShort1() throws RemoteException;
	public void setShort1(Set<Short> short1) throws RemoteException;
	public Set<Integer> getInt1() throws RemoteException;
	public void setInt1(Set<Integer> int1) throws RemoteException;
	public Set<Long> getLong1() throws RemoteException;
	public void setLong1(Set<Long> long1) throws RemoteException;
	public Set<Float> getFloat1() throws RemoteException;
	public void setFloat1(Set<Float> float1) throws RemoteException;
	public Set<Double> getDouble1() throws RemoteException;
	public void setDouble1(Set<Double> double1) throws RemoteException;
	public Set<String> getString1() throws RemoteException;
	public void setString1(Set<String> string1) throws RemoteException;
	public Set<PrimitiveTypes> getPrimitiveTypes1() throws RemoteException;
	public void setPrimitiveTypes1(Set<PrimitiveTypes> primitiveTypes1) throws RemoteException;
	public Set<byte[]> getByte2() throws RemoteException;
	public void setByte2(Set<byte[]> byte2) throws RemoteException;
	public Set<int[]> getInt2() throws RemoteException;
	public void setInt2(Set<int[]> int2) throws RemoteException;
	public Set<Object> getObj1() throws RemoteException;
	public void setObj1(Set<Object> obj1) throws RemoteException;
	
}
