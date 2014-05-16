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
    final BOutputBin bout = ((BOutputBin) bout1);
    final InputStream is = (InputStream) obj;
    final BContentStream bstream = bout.createStreamRequest(is);
    final BTargetId targetId = bstream.getTargetId();
    final boolean withProps = bout.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION;

    if (withProps) {
      bstream.getTargetId().write(bout.bbuf.getBuffer(), bout.header.bversion);
      bout.bbuf.putLong(bstream.getContentLength());
      bout.bbuf.putString(bstream.getContentType());
      bout.bbuf.putInt(bstream.getAttachmentCode());
      bout.bbuf.putString(bstream.getFileName());
    } else {
      bout.bbuf.putLong(targetId.getStreamId());
    }
  }

  @Override
  public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
    BInputBin bin = ((BInputBin) bin1);
    BTargetId targetId = null;
    long contentLength = -1;
    String contentType = BContentStream.DEFAULT_CONTENT_TYPE;
    int attachmentCode = 0;
    String fileName = null;
    final boolean withProps = bin1.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION;

    if (withProps) {
      targetId = BTargetId.read(bin.bbuf.getBuffer(), bin1.header.bversion);
      contentLength = bin.bbuf.getLong();
      contentType = bin.bbuf.getString();
      attachmentCode = bin.bbuf.getInt();
      fileName = bin.bbuf.getString();
    } else {
      final long streamId = bin.bbuf.getLong();
      final int serverId = bin1.transport.getTargetId().getServerId();
      final long messageId = bin1.header.messageId;
      targetId = new BTargetId(serverId, messageId, streamId);
    }

    try {
      BContentStream strm = bin.transport.getWire().getStream(targetId);
      bin.onObjectCreated(strm);
      strm.setContentLength(contentLength);
      strm.setContentType(contentType);
      strm.setAttachmentCode(attachmentCode);
      strm.setFileName(fileName);
      
      return strm;
    } catch (IOException e) {
      throw new BException(BExceptionC.IOERROR, e.getMessage());
    }
  }

}
