package byps.ureq;

/*
 * Serializer for byps.ureq.BStub_BUtilityRequests
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStub DO NOT MODIFY.
 */

import byps.*;
@SuppressWarnings("all")
public class JSerializer_174367442 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_174367442();
	
	public JSerializer_174367442() {
		super(174367442);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_BUtilityRequests(transport);
	}
	
}
