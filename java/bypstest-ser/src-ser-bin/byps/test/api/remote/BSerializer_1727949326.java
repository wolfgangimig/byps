package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class BSerializer_1727949326 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1727949326();
	
	public BSerializer_1727949326() {
		super(1727949326);
	}
	
	public BSerializer_1727949326(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putDouble(obj.v);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setDouble()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.v = bbuf.getDouble();
		
		return obj;
	}
	
}
