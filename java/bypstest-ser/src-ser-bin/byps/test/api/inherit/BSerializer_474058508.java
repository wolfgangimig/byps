package byps.test.api.inherit;

/*
 * Serializer for byps.test.api.inherit.BStub_BioLemonService
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStub DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_474058508 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_474058508();
	
	public BSerializer_474058508() {
		super(474058508);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_BioLemonService(transport);
	}
	
}
