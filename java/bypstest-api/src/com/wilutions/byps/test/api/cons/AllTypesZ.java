package com.wilutions.byps.test.api.cons;

/**
 * 
 * @BSerializable
 *
 */
public class AllTypesZ {

	private boolean bool1;
	private byte byte1;
	private char char1;
	private short short1;
	private int int1;
	private long long1;
	private float float1;
	private double double1;
	private String string1;
	private HebrewZ hebrew1; 
	private byte[] byte2;
	private int[] int2;
	private String[] string2;
	private HebrewZ[] hebrew2;
	
	public AllTypesZ() {
		
	}
	
	public AllTypesZ(boolean bool1, byte byte1, char char1, short short1,
			int int1, long long1, float float1, double double1, String string1,
			HebrewZ hebrew1, byte[] byte2, int[] int2, String[] string2,
			HebrewZ[] hebrew2) {
		super();
		this.bool1 = bool1;
		this.byte1 = byte1;
		this.char1 = char1;
		this.short1 = short1;
		this.int1 = int1;
		this.long1 = long1;
		this.float1 = float1;
		this.double1 = double1;
		this.string1 = string1;
		this.hebrew1 = hebrew1;
		this.byte2 = byte2;
		this.int2 = int2;
		this.string2 = string2;
		this.hebrew2 = hebrew2;
	}

	public boolean isBool1() {
		return bool1;
	}

	public void setBool1(boolean bool1) {
		this.bool1 = bool1;
	}

	public byte getByte1() {
		return byte1;
	}

	public void setByte1(byte byte1) {
		this.byte1 = byte1;
	}

	public char getChar1() {
		return char1;
	}

	public void setChar1(char char1) {
		this.char1 = char1;
	}

	public short getShort1() {
		return short1;
	}

	public void setShort1(short short1) {
		this.short1 = short1;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public long getLong1() {
		return long1;
	}

	public void setLong1(long long1) {
		this.long1 = long1;
	}

	public float getFloat1() {
		return float1;
	}

	public void setFloat1(float float1) {
		this.float1 = float1;
	}

	public double getDouble1() {
		return double1;
	}

	public void setDouble1(double double1) {
		this.double1 = double1;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public HebrewZ getHebrew1() {
		return hebrew1;
	}

	public void setHebrew1(HebrewZ hebrew1) {
		this.hebrew1 = hebrew1;
	}

	public byte[] getByte2() {
		return byte2;
	}

	public void setByte2(byte[] byte2) {
		this.byte2 = byte2;
	}

	public int[] getInt2() {
		return int2;
	}

	public void setInt2(int[] int2) {
		this.int2 = int2;
	}

	public String[] getString2() {
		return string2;
	}

	public void setString2(String[] string2) {
		this.string2 = string2;
	}

	public HebrewZ[] getHebrew2() {
		return hebrew2;
	}

	public void setHebrew2(HebrewZ[] hebrew2) {
		this.hebrew2 = hebrew2;
	}
	
	
}
