package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;


public class BSerializer_15 extends BSerializer {

	public final static BSerializer instance = new BSerializer_15();

	public BSerializer_15() {
		super(BRegistry.TYPEID_STREAM);
	}

	@Override
	public void write(final Object obj, final BOutput bout1, final long version) throws BException {
		final BOutputBin bout = ((BOutputBin)bout1);
		InputStream is = (InputStream)obj;
		BContentStream bstream = bout.createStreamRequest(is);
		
		bout.bbuf.putLong(bstream.getStreamId());
		
		if (bout1.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION) {
      bout.bbuf.putInt(bstream.getServerId());
      bout.bbuf.putLong(bstream.getMessageId());
      bout.bbuf.putLong(bstream.getContentLength());
      bout.bbuf.putString(bstream.getContentType());
      bout.bbuf.putBoolean(bstream.isAttachment());
      bout.bbuf.putString(bstream.getFileName());
		}
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		BInputBin bin = ((BInputBin)bin1);
		
		long streamId = bin.bbuf.getLong();
		int serverId = 0;
		long messageId = 0;
		long contentLength = 0;
		String contentType = BContentStream.DEFAULT_CONTENT_TYPE;
    boolean attachment = false;
		String fileName = "";
		
		if (bin1.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION) {
		  serverId = bin.bbuf.getInt();
		  messageId = bin.bbuf.getLong();
		  contentLength = bin.bbuf.getLong();
		  contentType = bin.bbuf.getString();
		  attachment = bin.bbuf.getBoolean();
		  fileName = bin.bbuf.getString();
    }
		else {
		  serverId = bin1.transport.getTargetId().serverId;
		  messageId =  bin1.header.messageId;
		}

		try {
			BContentStream strm = bin.transport.getWire().getStream(serverId, messageId, streamId);
			bin.onObjectCreated(strm);
			strm.setContentLength(contentLength);
			strm.setContentType(contentType);
      strm.setAttachment(attachment);
			strm.setFileName(fileName);
			return strm;
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, e.getMessage());
		}
	}

}
