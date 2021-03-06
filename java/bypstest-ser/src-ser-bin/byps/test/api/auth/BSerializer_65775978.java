package byps.test.api.auth;

/*
 * Serializer for byps.test.api.auth.SessionInfo
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class BSerializer_65775978 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_65775978();
	
	public BSerializer_65775978() {
		super(65775978);
	}
	
	public BSerializer_65775978(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final SessionInfo obj = (SessionInfo)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putString(obj.sessionID);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final SessionInfo obj = (SessionInfo)(obj1 != null ? obj1 : bin.onObjectCreated(new SessionInfo()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.sessionID = bbuf.getString();
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final SessionInfo obj = (SessionInfo)(obj1);		
		
	}
	
}
