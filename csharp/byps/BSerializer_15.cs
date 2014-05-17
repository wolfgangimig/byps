/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSerializer_15 : BSerializer
    {

        public readonly static BSerializer instance = new BSerializer_15();

        public BSerializer_15()
            : base(BRegistry.TYPEID_STREAM)
        {
        }

        public override void write(Object obj, BOutput bout1, long version)
        {
            BOutputBin bout = ((BOutputBin)bout1);
            Stream strm = (Stream)obj;
            BContentStream bstream = bout.createStreamRequest(strm);
            BTargetId targetId = bstream.TargetId;
            bool withProps = bout1.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION;

            if (withProps)
            {
                bstream.TargetId.write(bout.bbuf.getBuffer(), bout1.header.bversion);
                bout.bbuf.putLong(bstream.ContentLength);
                bout.bbuf.putString(bstream.ContentType);
                bout.bbuf.putInt(bstream.AttachmentCode);
                bout.bbuf.putString(bstream.FileName);
            }
            else
            {
                bout.bbuf.putLong(targetId.getStreamId());
            }
        }

        public override Object read(Object obj, BInput bin1, long version)
        {
            BInputBin bin = ((BInputBin)bin1);
            BTargetId targetId = null;
            long contentLength = -1;
            String contentType = BContentStream.DEFAULT_CONTENT_TYPE;
            int attachmentCode = 0;
            String fileName = "";
            bool withProps = bin1.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION;

            if (withProps)
            {
                targetId = BTargetId.read(bin.bbuf.getBuffer(), bin1.header.bversion);
                contentLength = bin.bbuf.getLong();
                contentType = bin.bbuf.getString();
                attachmentCode = bin.bbuf.getInt();
                fileName = bin.bbuf.getString();
            }
            else
            {
                long streamId = bin.bbuf.getLong();
                int serverId = bin1.transport.getTargetId().getServerId();
                long messageId = bin1.header.messageId;
                targetId = new BTargetId(serverId, messageId, streamId);
            }

            try
            {
                BContentStream strm = bin.transport.getWire().getStream(targetId);
                bin.onObjectCreated(strm);
                strm.ContentLength = contentLength;
                strm.ContentType = contentType;
                strm.AttachmentCode = attachmentCode;
                strm.FileName = fileName;
                return strm;
            }
            catch (IOException e)
            {
                throw new BException(BExceptionC.IOERROR, e.Message);
            }

        }

    }
}
