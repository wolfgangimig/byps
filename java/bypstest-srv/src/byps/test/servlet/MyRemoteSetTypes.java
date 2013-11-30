package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import byps.RemoteException;
import byps.test.api.prim.PrimitiveTypes;
import byps.test.api.remote.BSkeleton_RemoteSetTypes;

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
	private Set<Date> date1;
	
	
	@Override public  Set<Boolean> getBoolean1() throws RemoteException  {
		return boolean1;
	}
	@Override public  void setBoolean1(Set<Boolean> boolean1) throws RemoteException  {
		this.boolean1 = boolean1;
	}
	@Override public  HashSet<Byte> getByte1() throws RemoteException  {
		return byte1;
	}
	@Override public  void setByte1(HashSet<Byte> byte1) throws RemoteException  {
		this.byte1 = byte1;
	}
	@Override public  TreeSet<Character> getChar1() throws RemoteException  {
		return char1;
	}
	@Override public  void setChar1(TreeSet<Character> char1) throws RemoteException  {
		this.char1 = char1;
	}
	@Override public  Set<Short> getShort1() throws RemoteException  {
		return short1;
	}
	@Override public  void setShort1(Set<Short> short1) throws RemoteException  {
		this.short1 = short1;
	}
	@Override public  Set<Integer> getInt1() throws RemoteException  {
		return int1;
	}
	@Override public  void setInt1(Set<Integer> int1) throws RemoteException  {
		this.int1 = int1;
	}
	@Override public  Set<Long> getLong1() throws RemoteException  {
		return long1;
	}
	@Override public  void setLong1(Set<Long> long1) throws RemoteException  {
		this.long1 = long1;
	}
	@Override public  Set<Float> getFloat1() throws RemoteException  {
		return float1;
	}
	@Override public  void setFloat1(Set<Float> float1) throws RemoteException  {
		this.float1 = float1;
	}
	@Override public  Set<Double> getDouble1() throws RemoteException  {
		return double1;
	}
	@Override public  void setDouble1(Set<Double> double1) throws RemoteException  {
		this.double1 = double1;
	}
	@Override public  Set<String> getString1() throws RemoteException  {
		return string1;
	}
	@Override public  void setString1(Set<String> string1) throws RemoteException  {
		this.string1 = string1;
	}
	@Override public  Set<PrimitiveTypes> getPrimitiveTypes1() throws RemoteException  {
		return primitiveTypes1;
	}
	@Override public  void setPrimitiveTypes1(Set<PrimitiveTypes> primitiveTypes1) throws RemoteException  {
		this.primitiveTypes1 = primitiveTypes1;
	}
	@Override public  Set<byte[]> getByte2() throws RemoteException  {
		return byte2;
	}
	@Override public  void setByte2(Set<byte[]> byte2) throws RemoteException  {
		this.byte2 = byte2;
	}
	@Override public  Set<int[]> getInt2() throws RemoteException  {
		return int2;
	}
	@Override public  void setInt2(Set<int[]> int2) throws RemoteException  {
		this.int2 = int2;
	}
	@Override public  Set getObj1() throws RemoteException  {
		return obj1;
	}
	@Override public  void setObj1(Set obj1) throws RemoteException  {
		this.obj1 = obj1;
	}
  @Override
  public void setDate1(Set<Date> obj1) throws RemoteException {
    this.date1 = obj1;
  }
  @Override
  public Set<Date> getDate1() throws RemoteException {
    return date1;
  }

	
}
