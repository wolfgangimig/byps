/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BMessage
    {
        public readonly BMessageHeader header;
        public readonly ByteBuffer buf;
        public readonly List<BContentStream> streams;

        public BMessage(BMessageHeader header, ByteBuffer buf, List<BContentStream> streams)
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
