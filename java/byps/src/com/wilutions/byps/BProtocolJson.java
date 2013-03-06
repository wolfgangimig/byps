package com.wilutions.byps;

import java.nio.ByteBuffer;

public class BProtocolJson extends BProtocol {

	public BProtocolJson(BApiDescriptor apiDesc) {
		super(apiDesc, apiDesc.version, null);
	}

	public BOutput getOutput(BTransport transport, BMessageHeader responseHeader) throws BException {
		if (responseHeader != null) {
			return new BOutputJson(transport, responseHeader);
		}
		else {
			return new BOutputJson(transport);
		}
	}

	public BInput getInput(BTransport transport, BMessageHeader header, ByteBuffer buf) throws BException {
		return new BInputJson(header, buf, transport);
	}

}
