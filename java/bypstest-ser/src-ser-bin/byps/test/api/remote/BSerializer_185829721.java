package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setChar
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
public class BSerializer_185829721 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_185829721();
	
	public BSerializer_185829721() {
		super(185829721);
	}
	
	public BSerializer_185829721(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemoteArrayTypes4dim_setChar obj = (BRequest_RemoteArrayTypes4dim_setChar)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.v, false, byps.test.api.BSerializer_769021986.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteArrayTypes4dim_setChar obj = (BRequest_RemoteArrayTypes4dim_setChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setChar()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.v = (char[][][][])bin.readObj(false, byps.test.api.BSerializer_769021986.instance);
		
		return obj;
	}
	
}