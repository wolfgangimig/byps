package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=10

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class BSerializer_677876863 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_677876863();
	
	public BSerializer_677876863() {
		super(677876863);
	}
	
	public BSerializer_677876863(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putBoolean(obj.b);
		bbuf.putChar(obj.c);
		bbuf.putDouble(obj.d);
		bbuf.putFloat(obj.f);
		bbuf.putInt(obj.i);
		bbuf.putLong(obj.l);
		bbuf.putShort(obj.s);
		bbuf.putString(obj.str);
		bout.writeObj(obj.o, false, null);
		bout.writeObj(obj.pt, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_sendAllTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.b = bbuf.getBoolean();
		obj.c = bbuf.getChar();
		obj.d = bbuf.getDouble();
		obj.f = bbuf.getFloat();
		obj.i = bbuf.getInt();
		obj.l = bbuf.getLong();
		obj.s = bbuf.getShort();
		obj.str = bbuf.getString();
		obj.o = (java.lang.Object)bin.readObj(false, null);
		obj.pt = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
		
		return obj;
	}
	
}