package byps.test.api.comp;

/*
 * Serializer for byps.test.api.comp.BStub_IncompatibleChangeIF
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStub DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class BSerializer_88979576 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_88979576();
	
	public BSerializer_88979576() {
		super(88979576);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_IncompatibleChangeIF(transport);
	}
	
}
