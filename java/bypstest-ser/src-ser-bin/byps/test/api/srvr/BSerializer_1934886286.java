package byps.test.api.srvr;

/*
 * Serializer for byps.test.api.srvr.BRequest_ServerIF_putStreamsOnClient
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
public class BSerializer_1934886286 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1934886286();
	
	public BSerializer_1934886286() {
		super(1934886286);
	}
	
	public BSerializer_1934886286(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_ServerIF_putStreamsOnClient obj = (BRequest_ServerIF_putStreamsOnClient)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.streams, false, byps.test.api.BSerializer_1218831438.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_ServerIF_putStreamsOnClient obj = (BRequest_ServerIF_putStreamsOnClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_putStreamsOnClient()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.streams = (java.util.List<java.io.InputStream>)bin.readObj(false, byps.test.api.BSerializer_1218831438.instance);
		
		return obj;
	}
	
}
