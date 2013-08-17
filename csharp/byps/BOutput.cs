using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public abstract class BOutput
    {
  	    public readonly BMessageHeader header;
	    public readonly BTransport transport;
	    public readonly BRegistry registry;
	
	    public BOutput(BTransport transport, BRegistry registry, int streamHeaderMagic, int negotiatedVersion, ByteOrder negotiatedByteOrder) {
		    this.objMap = transport.apiDesc.uniqueObjects ? null : new BObjMap();
		    this.header = new BMessageHeader(streamHeaderMagic, negotiatedVersion, negotiatedByteOrder, transport.wire.makeMessageId());
		    this.header.targetId = transport.getTargetId();
		    this.transport = transport;
		    this.registry = registry;
		    this.streams = null;
	    }
	
	    public BOutput(BTransport transport, BRegistry registry, BMessageHeader requestHeader) {
		    this.objMap = transport.apiDesc.uniqueObjects ? null : new BObjMap();
		    this.header = requestHeader;
		    this.header.targetId = transport.getTargetId();
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
                header.error = BException.REMOTE_ERROR;
                BSerializer ser = registry.getSerializer(ex, false);
                if (ser == null)
                {
                    ex = new BException(BException.REMOTE_ERROR, "", ex);
                }
            }
            store(ex);

            // Alle Streams schließen. Sie werden nicht gesendet.
            if (streams != null)
            {
                foreach (BStreamRequest streamRequest in streams)
                {
                    try
                    {
                        streamRequest.strm.Close();
                    }
                    catch (Exception) { }
                }
                streams = null;
            }
        }

       	public BMessage toMessage() {
		    BMessage msg = new BMessage(header.messageId, toByteBuffer(), getStreamRequests());
		    return msg;
	    }
	

        public abstract ByteBuffer toByteBuffer();
        protected abstract void internalStore(Object bserializable);

  	    internal BStreamRequest createStreamRequest(Stream strm) {
		    if (streams == null) streams = new List<BStreamRequest>();
		    BStreamRequest streamRequest = new BStreamRequest();
		    streamRequest.messageId = header.messageId;
		    streamRequest.streamId = transport.wire.makeMessageId();
		    streamRequest.strm = strm;
            streams.Add(streamRequest);
		    return streamRequest;
	    }
	
	    public List<BStreamRequest> getStreamRequests() {
		    return streams;
	    }
		
	    protected BObjMap objMap;
	    protected List<BStreamRequest> streams;

    }
}
