package com.wilutions.byps;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BProtocolS extends BProtocol {

	public BProtocolS(BApiDescriptor apiDesc, int negotiatedVersion, ByteOrder negotiatedByteOrder) {
		super(apiDesc, negotiatedVersion, negotiatedByteOrder);
	}

	public BProtocolS(BApiDescriptor apiDesc) {
		super(apiDesc);
	}

	public BOutput getOutput(BTransport transport, BMessageHeader responseHeader) throws BException {
		if (negotiatedByteOrder == null) throw new BException(BException.INTERNAL, "Protocol object can only be used for input.");
		if (responseHeader != null) {
			return new BOutputS(transport, responseHeader);
		}
		else {
			return new BOutputS(transport, negotiatedVersion, negotiatedByteOrder);
		}
	}
	
	public BInput getInput(BTransport transport, BMessageHeader header, ByteBuffer buf) throws BException {
		return new BInputS(header, buf, transport);
	}


}
