package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setByte1
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
public class BSerializer_47373943 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_47373943();
	
	public BSerializer_47373943() {
		super(47373943);
	}
	
	public BSerializer_47373943(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemoteListTypes_setByte1 obj = (BRequest_RemoteListTypes_setByte1)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.byte1, false, byps.test.api.BSerializer_1059148284.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteListTypes_setByte1 obj = (BRequest_RemoteListTypes_setByte1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setByte1()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.byte1 = (java.util.List<java.lang.Byte>)bin.readObj(false, byps.test.api.BSerializer_1059148284.instance);
		
		return obj;
	}
	
}