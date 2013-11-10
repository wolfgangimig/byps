package byps.test.servlet;

import java.util.Date;
import java.util.List;

import byps.RemoteException;
import byps.test.api.remote.BSkeleton_RemoteListTypes;

public class MyRemoteListTypes extends BSkeleton_RemoteListTypes {

	private java.util.List<java.lang.Boolean> boolean1;
	private java.util.List<java.lang.Byte> byte1;
	private java.util.List<byte[]> byte2;
	private java.util.List<java.lang.Character> char1;
	private java.util.List<java.lang.Double> double1;
	private java.util.List<java.lang.Float> float1;
	private java.util.List<java.lang.Integer> int1;
	private java.util.List<int[]> int2;
	private java.util.List<java.lang.Long> long1;
	private java.util.List<java.lang.Object> obj1;
	private java.util.List<byps.test.api.prim.PrimitiveTypes> primitiveTypes1;
	private java.util.List<java.lang.Short> short1;
	private java.util.List<java.lang.String> string1;
	private java.util.List<Date> date1;

	private java.util.List<java.util.List<java.lang.Integer>> int3;
	private java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>> int4;
	
    @Override public java.util.List<java.lang.Boolean> getBoolean1() {
		return boolean1;
	}
	@Override public void setBoolean1(java.util.List<java.lang.Boolean> boolean1) {
		this.boolean1 = boolean1;
	}
	@Override public java.util.List<java.lang.Byte> getByte1() {
		return byte1;
	}
	@Override public void setByte1(java.util.List<java.lang.Byte> byte1) {
		this.byte1 = byte1;
	}
	@Override public java.util.List<byte[]> getByte2() {
		return byte2;
	}
	@Override public void setByte2(java.util.List<byte[]> byte2) {
		this.byte2 = byte2;
	}
	@Override public java.util.List<java.lang.Character> getChar1() {
		return char1;
	}
	@Override public void setChar1(java.util.List<java.lang.Character> char1) {
		this.char1 = char1;
	}
	@Override public java.util.List<java.lang.Double> getDouble1() {
		return double1;
	}
	@Override public void setDouble1(java.util.List<java.lang.Double> double1) {
		this.double1 = double1;
	}
	@Override public java.util.List<java.lang.Float> getFloat1() {
		return float1;
	}
	@Override public void setFloat1(java.util.List<java.lang.Float> float1) {
		this.float1 = float1;
	}
	@Override public java.util.List<java.lang.Integer> getInt1() {
		return int1;
	}
	@Override public void setInt1(java.util.List<java.lang.Integer> int1) {
		this.int1 = int1;
	}
	@Override public java.util.List<int[]> getInt2() {
		return int2;
	}
	@Override public void setInt2(java.util.List<int[]> int2) {
		this.int2 = int2;
	}
	@Override public java.util.List<java.lang.Long> getLong1() {
		return long1;
	}
	@Override public void setLong1(java.util.List<java.lang.Long> long1) {
		this.long1 = long1;
	}
	@Override public java.util.List<java.lang.Object> getObj1() {
		return obj1;
	}
	@Override public void setObj1(java.util.List<java.lang.Object> obj1) {
		this.obj1 = obj1;
	}
	@Override public java.util.List<byps.test.api.prim.PrimitiveTypes> getPrimitiveTypes1() {
		return primitiveTypes1;
	}
	@Override public void setPrimitiveTypes1(
			java.util.List<byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
		this.primitiveTypes1 = primitiveTypes1;
	}
	@Override public java.util.List<java.lang.Short> getShort1() {
		return short1;
	}
	@Override public void setShort1(java.util.List<java.lang.Short> short1) {
		this.short1 = short1;
	}
	@Override public java.util.List<java.lang.String> getString1() {
		return string1;
	}
	@Override public void setString1(java.util.List<java.lang.String> string1) {
		this.string1 = string1;
	}
	@Override public java.util.List<java.util.List<java.lang.Integer>> getInt3() {
		return int3;
	}
	@Override public void setInt3(java.util.List<java.util.List<java.lang.Integer>> int3) {
		this.int3 = int3;
	}
	@Override public java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>> getInt4() {
		return int4;
	}
	@Override public void setInt4(java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>> int4) {
		this.int4 = int4;
	}
  @Override
  public void setDate1(List<Date> obj1) throws RemoteException {
    this.date1 = obj1;
  }
  @Override
  public List<Date> getDate1() throws RemoteException {
    return date1;
  }

}
