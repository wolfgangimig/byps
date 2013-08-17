using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
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

        public virtual void send(BMessage msg, BAsyncResult<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult);
        }

        public virtual void sendR(BMessage msg, BAsyncResult<BMessage> asyncResult)
        {
            internalSend(msg, asyncResult);
        }

        private void internalSend(BMessage msg, BAsyncResult<BMessage> asyncResult)
        {
		    ByteBuffer obuf = ByteBuffer.allocate(msg.buf.remaining());
		    obuf.put(msg.buf);
		    obuf.flip();

            putStreams(msg.streams, asyncResult);

            BMessage omsg = new BMessage(msg.messageId, obuf, null);
            asyncResult.setAsyncResult(omsg, null);
        }

        public virtual long makeMessageId()
        {
            long mid = rand.nextLong();
            if (mid < 0) mid = -mid;
            return mid;
        }

        public virtual void putStreams(List<BStreamRequest> streamRequests, BAsyncResult<BMessage> asyncResult)
        {
        }

        public virtual Stream getStream(long messageId, long streamId)
        {
            return null;
        }

        public void bufferToStream(ByteBuffer buf, Stream os) 
        {
            if ((flags & BWireFlags.GZIP) != 0)
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
		    protected long messageId;
    	    protected long streamId;
    	
    	    public InputStreamWrapper(long messageId, long streamId) {
    		    this.messageId = messageId;
    		    this.streamId = streamId;
    	    }

        }

        public BWireFlags Flags
        {
            get { return flags; }
        }

        protected void internalInit(BWireFlags  flags)
        {
            rand = new BSecureRandom();
            this.flags = flags;
        }

        public virtual BTestAdapter getTestAdapter()
        {
            return null;
        }

        protected BSecureRandom rand;
        protected Object sess;
        protected BWireFlags flags;
    }
}
