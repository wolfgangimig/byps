package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BStub_RemoteArrayTypes23
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStub DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_964138163 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_964138163();
	
	public BSerializer_964138163() {
		super(964138163);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteArrayTypes23(transport);
	}
	
}