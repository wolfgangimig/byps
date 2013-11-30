package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;

import byps.BException;

public abstract class BInputBin extends BInput {

	public final BBufferBin bbuf;

	public BInputBin(BMessageHeader header, ByteBuffer buf, BTransport transport, BRegistry registry) {
		super(header, transport, registry);
		this.bbuf = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, buf);
	}

	public Object load() throws BException {
		if (header.messageId == 0) {
			header.read(bbuf.buf);
		}
		if (header.error != 0) {
			Throwable ex = (Throwable)readObj(false, null);
			if (ex instanceof BException) throw (BException)ex;
			throw new BException(header.error, ex.toString(), ex);
		}
		return readObj(false, null);
	}
	
	public abstract Object readObj(boolean isUnique, BSerializer ser) throws BException;

}
