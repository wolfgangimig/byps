package com.wilutions.byps.http;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BServerR;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.BWire;

public class HTransportClient extends BTransport {

	public HTransportClient(BApiDescriptor apiDesc, BWire wire) {
		super(apiDesc, wire, null);
	}
	
	@Override
	public BServerR createServerR(BServer server) {
		return new HServerR(this, server);
	}

}
