package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setString1
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
public class BSerializer_339567886 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_339567886();
	
	public BSerializer_339567886() {
		super(339567886);
	}
	
	public BSerializer_339567886(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemoteListTypes_setString1 obj = (BRequest_RemoteListTypes_setString1)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.string1, false, byps.test.api.BSerializer_2123584667.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteListTypes_setString1 obj = (BRequest_RemoteListTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setString1()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.string1 = (java.util.List<java.lang.String>)bin.readObj(false, byps.test.api.BSerializer_2123584667.instance);
		
		return obj;
	}
	
}
