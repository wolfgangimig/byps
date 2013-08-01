package com.wilutions.byps;


public class BBinaryModel {
	
	public final int pointerSize;
	public final int typeIdSize;
	public final int lengthSize;
	public final int packing;

	private BBinaryModel(int pointerSize, int typeIdSize, int lengthSize, int packing) {
		this.pointerSize = pointerSize;
		this.typeIdSize = typeIdSize;
		this.lengthSize = lengthSize;
		this.packing = packing; 
	}
	
	public final static BBinaryModel TINY = new BBinaryModel(1, 1, 1, 1); 
	public final static BBinaryModel SMALL = new BBinaryModel(2, 2, 2, 2); 
	public final static BBinaryModel MEDIUM = new BBinaryModel(4, 4, 4, 8);
	public final static BBinaryModel LARGE = new BBinaryModel(8, 8, 8, 8); // reserved
	public final static BBinaryModel JSON = new BBinaryModel(1, 1, 1, 1);
	
	public int computeArrayWireSize(int elmSize, int length) {
		int ret = length * elmSize;
		return ret;
	}

	public String toString() {
//		if (this == BBinaryModel.LARGE) return "L";
		if (this == BBinaryModel.MEDIUM) return "MEDIUM";
//		if (this == BBinaryModel.SMALL) return "A";
//		if (this == BBinaryModel.TINY) return "T";
		if (this == BBinaryModel.JSON) return "JSON"; 
		throw new IllegalStateException("Invalid binary model");
	}
	
	public String getProtocolId() {
		return (this == BBinaryModel.MEDIUM) ? "S" : "J";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lengthSize;
		result = prime * result + packing;
		result = prime * result + pointerSize;
		result = prime * result + typeIdSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BBinaryModel other = (BBinaryModel) obj;
		if (lengthSize != other.lengthSize)
			return false;
		if (packing != other.packing)
			return false;
		if (pointerSize != other.pointerSize)
			return false;
		if (typeIdSize != other.typeIdSize)
			return false;
		return true;
	}
	

}
