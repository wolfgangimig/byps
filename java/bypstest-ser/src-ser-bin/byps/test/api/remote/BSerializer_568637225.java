package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BStub_RemoteReferences
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStub DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_568637225 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_568637225();
	
	public BSerializer_568637225() {
		super(568637225);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteReferences(transport);
	}
	
}
