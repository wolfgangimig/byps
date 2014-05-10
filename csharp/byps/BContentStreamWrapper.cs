/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace byps
{
    public class BContentStreamWrapper : BContentStream
    {

	    protected Stream innerStream;

        public BContentStreamWrapper()
            : this(null, DEFAULT_CONTENT_TYPE, -1L)
        {
        }

        public BContentStreamWrapper(Stream innerStream)
            : this(innerStream, DEFAULT_CONTENT_TYPE, -1L)
        {
        }

        public BContentStreamWrapper(Stream innerStream, String contentType, long contentLength)
            : base(contentType, contentLength)
        {
            this.innerStream = innerStream;
        }

        protected virtual Stream openStream()
        {
            throw new NotImplementedException();
        }

 	    protected Stream ensureStream() {
		    if (innerStream != null) return innerStream;
		
		    lock(this) 
            {
                if (innerStream == null)
                {
                    innerStream = openStream();
			    }
		    }

            return innerStream;
	    }

        public override int Read(byte[] buffer, int offset, int count)
        {
            return ensureStream().Read(buffer, offset, count);
        }

        public override void Close()
        {
            ensureStream().Close();
        }

        public override bool CanRead
        {
            get { return ensureStream().CanRead; }
        }

        public override bool CanSeek
        {
            get { return ensureStream().CanSeek; }
        }

        public override bool CanWrite
        {
            get { return ensureStream().CanWrite; }
        }

        public override void Flush()
        {
            ensureStream().Flush();
        }

        public override long Length
        {
            get { return ensureStream().Length; }
        }

        public override long Position
        {
            get
            {
                return ensureStream().Position;
            }
            set
            {
                ensureStream().Position = value;
            }
        }

        public override long Seek(long offset, SeekOrigin origin)
        {
            return ensureStream().Seek(offset, origin);
        }

        public override void SetLength(long value)
        {
            ensureStream().SetLength(value);
        }

        public override void Write(byte[] buffer, int offset, int count)
        {
            ensureStream().Write(buffer, offset, count);
        }

    }
}
