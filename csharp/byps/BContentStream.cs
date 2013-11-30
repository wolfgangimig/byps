/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace byps
{
    public abstract class BContentStream : Stream
    {
    	public readonly static String DEFAULT_CONTENT_TYPE = "application/octet-stream";

        protected String contentTypeVal;
        protected long contentLengthVal;

        public BContentStream(String contentType, long contentLength)
        {
            this.contentTypeVal = contentType;
            this.contentLengthVal = contentLength;
        }

        public BContentStream()
        {
            this.contentTypeVal = DEFAULT_CONTENT_TYPE;
            this.contentLengthVal = -1L;
        }

	    public virtual String ContentType
        {
            get
            {
                return contentTypeVal;
            }
	    }

        public virtual long ContentLength
        {
            get
            {
                return contentLengthVal;
            }
        }
	
	    public virtual BContentStream CloneInputStream() 
        {
		    throw new IOException("Stream cannot be cloned.");
	    }

    }
}
