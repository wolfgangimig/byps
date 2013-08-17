using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public class BMessage
    {
        public readonly long messageId;
        public readonly ByteBuffer buf;
        public readonly List<BStreamRequest> streams;

        public BMessage(long messageId, ByteBuffer buf, List<BStreamRequest> streams) {
		    this.messageId = messageId;
		    this.buf = buf;
		    this.streams = streams;
	    }

        public bool isEmpty()
        {
            return buf == null || buf.remaining() == 0;
        }
    }
}
