package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import byps.BException;

public abstract class BProtocol {
	
	public final BApiDescriptor apiDesc;
	
	public final int negotiatedBypsVersion;
	
	public final long negotiatedVersion;
	
	public final ByteOrder negotiatedByteOrder;
	
	/**
	 * Client-site constructor.
	 * @param apiDesc
	 * @param negotiatedVersion
	 * @param negotiatedByteOrder
	 * @param protocolName
	 */
	public BProtocol(BApiDescriptor apiDesc, int negotiatedBypsVersion, long negotiatedVersion, ByteOrder negotiatedByteOrder) {
		this.apiDesc = apiDesc;
		this.negotiatedBypsVersion = negotiatedBypsVersion;
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
    this.negotiatedBypsVersion = 0;
		this.negotiatedVersion = 0;
		this.negotiatedByteOrder = null;
	}
	
	public abstract BOutput getOutput(BTransport transport, BMessageHeader responseHeader) throws BException;

	public abstract BInput getInput(BTransport transport, BMessageHeader header, ByteBuffer buf) throws BException;
	
	public abstract BRegistry getRegistry();

}
