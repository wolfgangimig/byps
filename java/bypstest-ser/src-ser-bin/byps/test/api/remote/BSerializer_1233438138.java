package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BStub_RemoteListTypes
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStub DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_1233438138 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_1233438138();
	
	public BSerializer_1233438138() {
		super(1233438138);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteListTypes(transport);
	}
	
}
