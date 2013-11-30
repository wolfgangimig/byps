package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import byps.BRemote;
import byps.BTargetId;

public class BStub implements BRemote {

	public final BTransport transport;
	
	public BStub(BTransport transport) {
		this.transport = transport;
	}
	
	@Override
	public BTargetId BRemote_getTargetId() {
		return transport.getTargetId();
	}

}
