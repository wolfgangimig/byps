package byps.test.api.srvr;

/*
 * Serializer for byps.test.api.srvr.BRequest_ClientIF_sendChat
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class BSerializer_41050276 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_41050276();
	
	public BSerializer_41050276() {
		super(41050276);
	}
	
	public BSerializer_41050276(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.cs, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_sendChat()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.cs = (byps.test.api.srvr.ChatStructure)bin.readObj(false, null);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)(obj1);		
		bin.prepareForLazyLoading(obj.cs, null);
		
	}
	
}
