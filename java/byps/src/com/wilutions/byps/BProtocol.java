package com.wilutions.byps;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BProtocol {
	
	protected final BApiDescriptor apiDesc;
	
	protected final int negotiatedVersion;
	
	protected final ByteOrder negotiatedByteOrder;
	
	/**
	 * Client-site constructor.
	 * @param apiDesc
	 * @param negotiatedVersion
	 * @param negotiatedByteOrder
	 * @param protocolName
	 */
	public BProtocol(BApiDescriptor apiDesc, int negotiatedVersion, ByteOrder negotiatedByteOrder) {
		this.apiDesc = apiDesc;
		this.negotiatedVersion = negotiatedVersion;
		this.negotiatedByteOrder = negotiatedByteOrder;
	}
	
	/**
	 * Server-site constructor
	 * @param apiDesc
	 * @param remotes
	 * @param protocolName
	 */
	public BProtocol(BApiDescriptor apiDesc) {
		this.apiDesc = apiDesc;
		this.negotiatedVersion = 0;
		this.negotiatedByteOrder = null;
	}
	
	public abstract BOutput getOutput(BTransport transport, BMessageHeader responseHeader) throws BException;


	public abstract BInput getInput(BTransport transport, BMessageHeader header, ByteBuffer buf) throws BException;

}
