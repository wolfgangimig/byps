package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BContentStreamWrapper;

public class HOutgoingStream extends BContentStreamWrapper {
	private static Log log = LogFactory.getLog(HOutgoingStream.class);
	public final long streamId;
	
	private AtomicBoolean closed = new AtomicBoolean();

	HOutgoingStream(InputStream innerStream, long streamId, long lifetimeMillis)  {
		super(innerStream, null, -1L, lifetimeMillis);
		this.streamId = streamId;
	}
	
	public InputStream ensureStream() throws IOException {
		if (closed.get()) {
			if (log.isDebugEnabled()) log.debug("Outgoing stream already closed, streamId=" + streamId);
			throw new IOException("Stream is closed");
		}
		if (innerStream instanceof BContentStreamWrapper) {
		  ((BContentStreamWrapper)innerStream).ensureStream();
		}
		return innerStream;
	}

}
