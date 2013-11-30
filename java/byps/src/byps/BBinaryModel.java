package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

/**
 * This class defines protocol details.
 * 
 */
public class BBinaryModel {
	
	/**
	 * Size of pointers (object IDs) in bytes.
	 * The value is 4 in binary streams. 
	 * This member has no meaning in JSON streams.
	 */
	public final int pointerSize;
	/**
	 * Size of type IDs in bytes.
	 * The value is 4 in binary streams. 
	 * This member has no meaning in JSON streams.
	 */
	public final int typeIdSize;
	/**
	 * Size of array and string lengths in bytes.
	 * The value is 4 in binary streams. 
	 * This member has no meaning in JSON streams.
	 */
	public final int lengthSize;
	/**
	 * Reserved.
	 */
	public final int packing;

	private BBinaryModel(int pointerSize, int typeIdSize, int lengthSize, int packing) {
		this.pointerSize = pointerSize;
		this.typeIdSize = typeIdSize;
		this.lengthSize = lengthSize;
		this.packing = packing; 
	}
	
//	public final static BBinaryModel TINY = new BBinaryModel(1, 1, 1, 1); 
//	public final static BBinaryModel SMALL = new BBinaryModel(2, 2, 2, 2); 
	public final static BBinaryModel MEDIUM = new BBinaryModel(4, 4, 4, 8);
//	public final static BBinaryModel LARGE = new BBinaryModel(8, 8, 8, 8); // reserved
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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + lengthSize;
//		result = prime * result + packing;
//		result = prime * result + pointerSize;
//		result = prime * result + typeIdSize;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BBinaryModel other = (BBinaryModel) obj;
//		if (lengthSize != other.lengthSize)
//			return false;
//		if (packing != other.packing)
//			return false;
//		if (pointerSize != other.pointerSize)
//			return false;
//		if (typeIdSize != other.typeIdSize)
//			return false;
//		return true;
//	}
	

}
