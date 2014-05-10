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
                bstream.TargetId.write(bout.bbuf.getBuffer());
                bout.bbuf.putLong(bstream.ContentLength);
                bout.bbuf.putString(bstream.ContentType);
                bout.bbuf.putBoolean(bstream.IsAttachment);
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
            long contentLength = 0;
            String contentType = BContentStream.DEFAULT_CONTENT_TYPE;
            bool attachment = false;
            String fileName = null;
            bool withProps = bin1.header.bversion >= BMessageHeader.BYPS_VERSION_EXTENDED_STREAM_INFORMATION;

            if (withProps)
            {
                targetId = BTargetId.read(bin.bbuf.getBuffer());
                contentLength = bin.bbuf.getLong();
                contentType = bin.bbuf.getString();
                attachment = bin.bbuf.getBoolean();
                fileName = bin.bbuf.getString();
            }
            else
            {
                long streamId = bin.bbuf.getLong();
                int serverId = bin1.transport.getTargetId().serverId;
                long messageId = bin1.header.messageId;
                targetId = new BTargetId(serverId, messageId, streamId);
            }

            try
            {
                BContentStream strm = bin.transport.getWire().getStream(targetId);
                bin.onObjectCreated(strm);
                strm.ContentLength = contentLength;
                strm.ContentType = contentType;
                strm.IsAttachment = attachment;
                strm.FileName = fileName;
                strm.setPropertiesValid(withProps);

                return strm;
            }
            catch (IOException e)
            {
                throw new BException(BExceptionC.IOERROR, e.Message);
            }

        }

    }
}
