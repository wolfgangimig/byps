package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;


public class JSerializer_15 extends JSerializer_Object {

	public final static BSerializer instance = new JSerializer_15();

	public JSerializer_15() {
		super(BRegistry.TYPEID_STREAM);
	}

	@Override
	public void internalWrite(final Object obj, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		InputStream is = (InputStream)obj;
		BContentStream bstream = bout.createStreamRequest(is);
		bout.bbuf.putLong("streamId", bstream.getStreamId());
		bout.bbuf.putInt("serverId", bstream.getServerId());
		bout.bbuf.putLong("messageId", bstream.getMessageId());
	}

	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		
	  final long streamId = bin.currentObject.getLong("streamId");
		int serverId = bin.currentObject.getInt("serverId");
    long messageId = bin.currentObject.getLong("messageId");
    
    if (serverId == 0) serverId = bin.transport.getTargetId().serverId;
    if (messageId == 0) messageId =  bin.header.messageId;
    
		try {
			InputStream strm = bin.transport.getWire().getStream(serverId, messageId, streamId);
			bin.onObjectCreated(strm);
			return strm;
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, e.getMessage());
		}
	}

}
