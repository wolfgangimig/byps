package com.wilutions.byps;

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
