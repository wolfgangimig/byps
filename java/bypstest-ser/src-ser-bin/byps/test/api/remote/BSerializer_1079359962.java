package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getString
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
public class BSerializer_1079359962 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1079359962();
	
	public BSerializer_1079359962() {
		super(1079359962);
	}
	
	public BSerializer_1079359962(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_getString obj = (BRequest_RemotePrimitiveTypes_getString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getString()));
		
		return obj;
	}
	
}
