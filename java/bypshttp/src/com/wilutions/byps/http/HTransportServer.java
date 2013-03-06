package com.wilutions.byps.http;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BClient;
import com.wilutions.byps.BClientR;
import com.wilutions.byps.BRemoteRegistry;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.BWire;

public class HTransportServer extends BTransport {
	
	public final HWireClientR wireClientR;

	public HTransportServer(BApiDescriptor apiDesc, BWire wire,
			BRemoteRegistry remoteRegistry) {
		super(apiDesc, wire, remoteRegistry);
		wireClientR = new HWireClientR(wire);
	}

	@Override
	public BClientR createClientR(BClient client) {
		return new BClientR(
				new BTransport(this.apiDesc, wireClientR, this.remoteRegistry),
				client);
	}
}
