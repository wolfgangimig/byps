package byps.test.api.prim;

/*
 * Serializer for byps.test.api.prim.PrimitiveTypes
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=13

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class BSerializer_1000 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1000();
	
	public BSerializer_1000() {
		super(1000);
	}
	
	public BSerializer_1000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final PrimitiveTypes obj = (PrimitiveTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putBoolean(obj.boolVal);
		bbuf.putByte(obj.byteVal);
		bbuf.putChar(obj.charVal);
		bbuf.putDouble(obj.doubleVal);
		bbuf.putFloat(obj.floatVal);
		bbuf.putInt(obj.intVal);
		bbuf.putLong(obj.longVal);
		bbuf.putShort(obj.shortVal);
		bbuf.putString(obj.stringVal);
		bbuf.putBoolean(obj.value);
		bout.writeObj(obj.objVal, false, null);
		bout.writeObj(obj.objVal2, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final PrimitiveTypes obj = (PrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new PrimitiveTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.boolVal = bbuf.getBoolean();
		obj.byteVal = bbuf.getByte();
		obj.charVal = bbuf.getChar();
		obj.doubleVal = bbuf.getDouble();
		obj.floatVal = bbuf.getFloat();
		obj.intVal = bbuf.getInt();
		obj.longVal = bbuf.getLong();
		obj.shortVal = bbuf.getShort();
		obj.stringVal = bbuf.getString();
		obj.value = bbuf.getBoolean();
		obj.objVal = (java.lang.Object)bin.readObj(false, null);
		obj.objVal2 = (java.lang.Object)bin.readObj(false, null);
		
		return obj;
	}
	
}