package byps;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;


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
		bout.bbuf.putString("targetId", bstream.getTargetId().makeSerializeString(bout.header.bversion));
    bout.bbuf.putLong("contentLength", bstream.getContentLength());
    bout.bbuf.putString("contentType", bstream.getContentType());
    bout.bbuf.putInt("attachment", bstream.getAttachmentCode());
    bout.bbuf.putString("fileName", bstream.getFileName());
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
	    final int serverId = bin.transport.getTargetId().getServerId();
	    final long messageId = bin.header.messageId;
	    targetId = new BTargetId(serverId, messageId, streamId);
	  }
    
		try {
			BContentStream strm = bin.transport.getWire().getStream(targetId.getMessageId(), targetId);

			// BYPS-28: If stream is uploaded from browser, most likely its properties are not submitted
			// in JSON serialization. Instead, the stream properties are transferred as header values and thus
			// are already available in object strm.
			final Set<String> keys = bin.currentObject.keys();
			
			// Those Stream properties submitted as header values have precedence.
			// This is because HHttpPutStreamHelper sets Content-Type and Content-Length even for non-BContentStream objects.
			// BYPS-44
			
      if (keys.contains("contentLength") && strm.getContentLength() < 0) {
        final long contentLength = bin.currentObject.getLong("contentLength");
        strm.setContentLength(contentLength);
      }
      
      if (strm.getContentType().isEmpty()) {
  			if (keys.contains("contentType")) {
          final String contentType = bin.currentObject.getString("contentType");
          strm.setContentType(contentType);
  			}
  			
        if (keys.contains("attachment")) {
          final int attachmentCode = bin.currentObject.getInt("attachment");
          strm.setAttachmentCode(attachmentCode);
        }
        
        if (keys.contains("fileName")) {
          final String fileName = bin.currentObject.getString("fileName");
          strm.setFileName(fileName);
        }
      }
      
			bin.onObjectCreated(strm);
			return strm;
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, e.getMessage());
		}
	}

}
