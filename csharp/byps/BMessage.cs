using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public class BMessage
    {
        public readonly BMessageHeader header;
        public readonly ByteBuffer buf;
        public readonly List<BStreamRequest> streams;

        public BMessage(BMessageHeader header, ByteBuffer buf, List<BStreamRequest> streams)
        {
            this.header = header;
		    this.buf = buf;
		    this.streams = streams;
	    }

        public bool isEmpty()
        {
            return buf == null || buf.remaining() == 0;
        }
    }
}
