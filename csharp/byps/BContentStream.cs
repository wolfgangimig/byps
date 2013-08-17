using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public abstract class BContentStream : Stream
    {

	    public virtual String ContentType
        {
            get
            {
                return null;
            }
	    }

        public virtual long ContentLength
        {
            get
            {
                return -1L;
            }
        }
	
	    public virtual BContentStream CloneInputStream() 
        {
		    throw new IOException("Stream cannot be cloned.");
	    }

    }
}
