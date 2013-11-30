package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;

import byps.BBufferJson;
import byps.BException;
import byps.BExceptionC;
import byps.BInputJson;
import byps.BOutputJson;
import byps.BRegistry;
import byps.BSerializer;
import byps.BStreamRequest;


public class JSerializer_15 extends JSerializer_Object {

	public final static BSerializer instance = new JSerializer_15();

	public JSerializer_15() {
		super(BRegistry.TYPEID_STREAM);
	}

	@Override
	public void internalWrite(final Object obj, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		InputStream is = (InputStream)obj;
		BStreamRequest streamRequest = bout.createStreamRequest(is);
		bout.bbuf.putLong("streamId", streamRequest.streamId);
	}

	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		long streamId = bin.currentObject.getLong("streamId");
		try {
			InputStream strm = bin.transport.wire.getStream(bin.header.messageId, streamId);
			bin.onObjectCreated(strm);
			return strm;
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, e.getMessage());
		}
	}

}
