package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getShort
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class BSerializer_450820153 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_450820153();
	
	public BSerializer_450820153() {
		super(450820153);
	}
	
	public BSerializer_450820153(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_getShort obj = (BRequest_RemotePrimitiveTypes_getShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getShort()));
		
		return obj;
	}
	
}
