package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setChar
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
public class BSerializer_243974583 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_243974583();
	
	public BSerializer_243974583() {
		super(243974583);
	}
	
	public BSerializer_243974583(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemotePrimitiveTypes_setChar obj = (BRequest_RemotePrimitiveTypes_setChar)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putChar(obj.v);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_setChar obj = (BRequest_RemotePrimitiveTypes_setChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setChar()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.v = bbuf.getChar();
		
		return obj;
	}
	
}