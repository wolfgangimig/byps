/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    [Flags]
    public enum BWireFlags
    {
        DEFAULT,
        GZIP
    }

    public class BWire
    {
        public BWire(BWireFlags flags)
        {
            internalInit(flags);
        }

        public virtual void done()
        {
        }

        public virtual void send(BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult);
        }

        public virtual void sendR(BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult);
        }

        private void internalSend(BMessage msg, BAsyncResultIF<BMessage> asyncResult)
        {
		    ByteBuffer obuf = ByteBuffer.allocate(msg.buf.remaining());
		    obuf.put(msg.buf);
		    obuf.flip();

            putStreams(msg.streams, asyncResult);

            BMessageHeader header = new BMessageHeader();
            header.read(obuf);
            BMessage omsg = new BMessage(header, obuf, null);
            asyncResult.setAsyncResult(omsg, null);
        }

        public virtual long makeMessageId()
        {
            long mid = rand.nextLong();
            if (mid < 0) mid = -mid;
            return mid;
        }

        public virtual void putStreams(List<BContentStream> streamRequests, BAsyncResultIF<BMessage> asyncResult)
        {
        }

        public virtual BContentStream getStream(BTargetId targetId)
        {
            return null;
        }

        public void bufferToStream(ByteBuffer buf, Stream os) 
        {
            if ((flagsVal & BWireFlags.GZIP) != 0)
            {
                os = new GZipStream(os, CompressionMode.Compress);
            }
            os.Write(buf.array(), buf.position(), buf.remaining());
            os.Close();
        }
    
	    public static ByteBuffer bufferFromStream(Stream js, bool gzip) {
            byte[] bytes = new byte[10*1000];
            if (gzip)
            {
                js = new GZipStream(js, CompressionMode.Decompress);
            }

            int pos = 0, len = 0;
            while ((len = js.Read(bytes, pos, bytes.Length-pos)) > 0)
            {
                pos += len;
                if (pos == bytes.Length)
                {
                    byte[] nbytes = new byte[bytes.Length << 1];
                    Array.Copy(bytes, nbytes, bytes.Length);
                    bytes = nbytes;
                }
            }
            ByteBuffer ibuf = ByteBuffer.wrap(bytes, 0, pos);
            js.Close();
            return ibuf;
	    }

        public virtual void cancelAllRequests() {
	    }

        public virtual Object getSessionContext()
        {
            return sess;
        }

        public virtual void setSessionContext(Object sess)
        {
            this.sess = sess;
        }

        public class InputStreamWrapper : BContentStreamWrapper
        {
            public InputStreamWrapper(BTargetId targetId)
            {
                this.TargetId = targetId;
    	    }

        }

        public BWireFlags Flags
        {
            get { return flagsVal; }
        }

        protected void internalInit(BWireFlags  flags)
        {
            rand = new BSecureRandom();
            this.flagsVal = flags;
        }

        public virtual BTestAdapter getTestAdapter()
        {
            return null;
        }

        protected BSecureRandom rand;
        protected Object sess;
        protected BWireFlags flagsVal;
    }
}
