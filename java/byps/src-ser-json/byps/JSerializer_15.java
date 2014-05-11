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
		bout.bbuf.putLong("streamId", bstream.getTargetId().getStreamId());
		bout.bbuf.putString("targetId", bstream.getTargetId().toString());
    bout.bbuf.putLong("contentLength", bstream.getContentLength());
    bout.bbuf.putString("contentType", bstream.getContentType());
    bout.bbuf.putBoolean("attachment", bstream.isAttachment());
    
    // Transfer a non-null fileName to be able to detect in internalRead()
    // whether the properties are valid.
    final String fileName = bstream.getFileName();
    bout.bbuf.putString("fileName", fileName != null ? fileName : "");
	}

	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
	  
	  BTargetId targetId = BTargetId.ZERO;
	  
	  final String targetIdStr = bin.currentObject.getString("targetId");
	  if (targetIdStr != null && targetIdStr.length() != 0) {
	    targetId = BTargetId.parseString(targetIdStr);
	  }
	  else {
	    final long streamId = bin.currentObject.getLong("streamId");
	    final int serverId = bin.transport.getTargetId().serverId;
	    final long messageId = bin.header.messageId;
	    targetId = new BTargetId(serverId, messageId, streamId);
	  }
    
		try {
			BContentStream strm = bin.transport.getWire().getStream(targetId);
			
			final boolean hasFileName = bin.currentObject.get("fileName") != null;
			if (hasFileName) {
	      final String contentType = bin.currentObject.getString("contentType");
        final long contentLength = bin.currentObject.getLong("contentLength");
        final boolean attachment = bin.currentObject.getBoolean("attachment");
        final String fileName = bin.currentObject.getString("fileName");
        strm.setContentType(contentType);
        strm.setContentLength(contentLength);
        strm.setAttachment(attachment);
        strm.setFileName(fileName);
        strm.setPropertiesValid(true);
			}
		    
			bin.onObjectCreated(strm);
			return strm;
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, e.getMessage());
		}
	}

}
