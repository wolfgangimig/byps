package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.util.List;

public class BMessage {
	final public ByteBuffer buf;
	final public List<BContentStream> streams;
	final public BMessageHeader header;
	
	public BMessage(final BMessageHeader header, final ByteBuffer buf, final List<BContentStream> streams) {
		this.buf = buf;
		this.streams = streams;
		this.header = header;
	}
	
	public boolean isEmpty() {
		return (buf == null || buf.remaining() == 0) && (header.messageObject == null);
	}
	
	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[").append(header);
		sbuf.append(",").append(buf).append(",").append(streams).append("]");
		return sbuf.toString();
	}
}
