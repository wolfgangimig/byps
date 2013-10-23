package byps.test.api.priv;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import byps.test.api.prim.PrimitiveTypes;

/**
 * Example class with private and protected members
 *
 */
public class PrivateMembers implements Serializable {
	
	private static final long serialVersionUID = 8001L;

	private boolean boolVal;
	private byte byteVal;
	private char charVal;
	private short shortVal;
	private int intVal;
	private long longVal;
	private float floatVal;
	private double doubleVal;
	private String stringVal;
	private PrimitiveTypes primitiveTypes;
	
	private boolean[] arrBool;
	private int[] arrInt;
	private String[] arrString;
	private PrimitiveTypes[] arrPrimitiveTypes;

	private List<Boolean> listBool;
	private List<Integer> listInt;
	private List<String> listString;
	private List<PrimitiveTypes> listPrimitiveTypes;
	
	private Map<Integer, List<String>> mapIntListString;

	protected int protInt;
	int pprotInt;
	
	public int getProtInt() {
		return protInt;
	}
	public void setProtInt(int protInt) {
		this.protInt = protInt;
	}
	public int getPprotInt() {
		return pprotInt;
	}
	public void setPprotInt(int pprotInt) {
		this.pprotInt = pprotInt;
	}
	public boolean isBoolVal() {
		return boolVal;
	}
	public void setBoolVal(boolean boolVal) {
		this.boolVal = boolVal;
	}
	public byte getByteVal() {
		return byteVal;
	}
	public void setByteVal(byte byteVal) {
		this.byteVal = byteVal;
	}
	public char getCharVal() {
		return charVal;
	}
	public void setCharVal(char charVal) {
		this.charVal = charVal;
	}
	public short getShortVal() {
		return shortVal;
	}
	public void setShortVal(short shortVal) {
		this.shortVal = shortVal;
	}
	public int getIntVal() {
		return intVal;
	}
	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}
	public long getLongVal() {
		return longVal;
	}
	public void setLongVal(long longVal) {
		this.longVal = longVal;
	}
	public float getFloatVal() {
		return floatVal;
	}
	public void setFloatVal(float floatVal) {
		this.floatVal = floatVal;
	}
	public double getDoubleVal() {
		return doubleVal;
	}
	public void setDoubleVal(double doubleVal) {
		this.doubleVal = doubleVal;
	}
	public String getStringVal() {
		return stringVal;
	}
	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}
	public PrimitiveTypes getPrimitiveTypes() {
		return primitiveTypes;
	}
	public void setPrimitiveTypes(PrimitiveTypes primitiveTypes) {
		this.primitiveTypes = primitiveTypes;
	}
	public boolean[] getArrBool() {
		return arrBool;
	}
	public void setArrBool(boolean[] arrBool) {
		this.arrBool = arrBool;
	}
	public int[] getArrInt() {
		return arrInt;
	}
	public void setArrInt(int[] arrInt) {
		this.arrInt = arrInt;
	}
	public String[] getArrString() {
		return arrString;
	}
	public void setArrString(String[] arrString) {
		this.arrString = arrString;
	}
	public PrimitiveTypes[] getArrPrimitiveTypes() {
		return arrPrimitiveTypes;
	}
	public void setArrPrimitiveTypes(PrimitiveTypes[] arrPrimitiveTypes) {
		this.arrPrimitiveTypes = arrPrimitiveTypes;
	}
	public List<Boolean> getListBool() {
		return listBool;
	}
	public void setListBool(List<Boolean> listBool) {
		this.listBool = listBool;
	}
	public List<Integer> getListInt() {
		return listInt;
	}
	public void setListInt(List<Integer> listInt) {
		this.listInt = listInt;
	}
	public List<String> getListString() {
		return listString;
	}
	public void setListString(List<String> listString) {
		this.listString = listString;
	}
	public List<PrimitiveTypes> getListPrimitiveTypes() {
		return listPrimitiveTypes;
	}
	public void setListPrimitiveTypes(List<PrimitiveTypes> listPrimitiveTypes) {
		this.listPrimitiveTypes = listPrimitiveTypes;
	}
	public Map<Integer, List<String>> getMapIntListString() {
		return mapIntListString;
	}
	public void setMapIntListString(Map<Integer, List<String>> mapIntListString) {
		this.mapIntListString = mapIntListString;
	}
	
	
}
