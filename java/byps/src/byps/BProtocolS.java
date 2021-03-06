package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import byps.BException;

public class BProtocolS extends BProtocol {
	
	public static final BBinaryModel BINARY_MODEL = BBinaryModel.MEDIUM;

	public BProtocolS(BApiDescriptor apiDesc, int negotiatedBypsVersion, long negotiatedVersion, ByteOrder negotiatedByteOrder) {
		super(apiDesc, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder);
	}

	public BProtocolS(BApiDescriptor apiDesc) {
		super(apiDesc);
	}

	public BOutput getOutput(BTransport transport, BMessageHeader responseHeader) throws BException {
		if (negotiatedByteOrder == null) throw new BException(BExceptionC.INTERNAL, "Protocol object can only be used for input.");
		if (responseHeader != null) {
			return new BOutputS(transport, responseHeader);
		}
		else {
			return new BOutputS(transport, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder);
		}
	}
	
	public BInput getInput(BTransport transport, BMessageHeader header, ByteBuffer buf) throws BException {
		return new BInputS(transport, header, buf);
	}

  public BRegistry getRegistry() {
    return apiDesc.getRegistry(BINARY_MODEL);
  }

}
