package com.wilutions.byps;

public class BSkeleton implements BRemote {

	private BTransport transport;
	
	@Override
	public BTargetId BRemote_getTargetId() {
		return  transport.getTargetId();
	}

	void BSkeleton_setTransport(BTransport transport) {
		this.transport = transport;
	}
}
