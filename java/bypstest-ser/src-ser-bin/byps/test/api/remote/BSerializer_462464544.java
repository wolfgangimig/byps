package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_setObj1
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
public class BSerializer_462464544 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_462464544();
	
	public BSerializer_462464544() {
		super(462464544);
	}
	
	public BSerializer_462464544(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemoteSetTypes_setObj1 obj = (BRequest_RemoteSetTypes_setObj1)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.obj1, false, byps.BSerializer_14.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteSetTypes_setObj1 obj = (BRequest_RemoteSetTypes_setObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setObj1()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.obj1 = (java.util.Set<java.lang.Object>)bin.readObj(false, byps.BSerializer_14.instance);
		
		return obj;
	}
	
}
