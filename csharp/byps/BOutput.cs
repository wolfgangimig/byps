/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace byps
{
    public abstract class BOutput
    {
        public readonly BMessageHeader header;
        public readonly BTransport transport;
        public readonly BRegistry registry;

        public BOutput(BTransport transport, BRegistry registry, int streamHeaderMagic, int negotiatedBypsVersion, long negotiatedVersion, ByteOrder negotiatedByteOrder)
        {
            this.objMap = transport.getApiDesc().uniqueObjects ? null : new BObjMap();
            this.header = new BMessageHeader(streamHeaderMagic, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder, transport.getWire().makeMessageId());
            this.header.targetId = transport.getTargetId();
            this.header.sessionId = transport.getSessionId();
            this.transport = transport;
            this.registry = registry;
            this.streams = null;
        }

        public BOutput(BTransport transport, BRegistry registry, BMessageHeader requestHeader)
        {
            this.objMap = transport.getApiDesc().uniqueObjects ? null : new BObjMap();
            this.header = requestHeader;
            this.header.targetId = transport.getTargetId();
            this.header.sessionId = transport.getSessionId();
            this.transport = transport;
            this.registry = registry;
            this.streams = null;
        }


        public void store(Object bserializable)
        {
            internalStore(bserializable);
        }

        public void setException(Exception ex)
        {
            if (ex.GetType() == typeof(BException))
            {
                header.error = ((BException)ex).Code;
            }
            else
            {
                header.error = BExceptionC.REMOTE_ERROR;
                BSerializer ser = registry.getSerializer(ex, false);
                if (ser == null)
                {
                    ex = new BException(BExceptionC.REMOTE_ERROR, "", ex);
                }
            }
            store(ex);

            // Alle Streams schließen. Sie werden nicht gesendet.
            if (streams != null)
            {
                foreach (BContentStream bstream in streams)
                {
                    try
                    {
                        bstream.Close();
                    }
                    catch (Exception) { }
                }
                streams = null;
            }
        }

        public BMessage toMessage()
        {
            BMessage msg = new BMessage(header, toByteBuffer(), getStreamRequests());
            return msg;
        }


        public abstract ByteBuffer toByteBuffer();
        protected abstract void internalStore(Object bserializable);

        internal BContentStream createStreamRequest(Stream strm)
        {
            if (streams == null) streams = new List<BContentStream>();

            BContentStream bstrm = null;

            if (strm is BContentStream)
            {
                bstrm = (BContentStream)strm;
            }
            else
            {
                bstrm = new BContentStreamWrapper(strm);
            }

            // If the stream has already a streamId, it has been received
            // from the server. In this case, the application obviously
            // wants to forward the stream to another client. Thus 
            // we do not have to upload the stream.

            if (bstrm.TargetId.isZero())
            {
                BTargetId targetId = new BTargetId(
                    transport.getConnectedServerId(),
                    header.messageId,
                    transport.getWire().makeMessageId());
                bstrm.TargetId = targetId;
                streams.Add(bstrm);
            }

            return bstrm;
        }

        public List<BContentStream> getStreamRequests()
        {
            return streams;
        }

        protected BObjMap objMap;
        protected List<BContentStream> streams;

    }
}
