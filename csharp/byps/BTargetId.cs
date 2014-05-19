/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BTargetId
    {
        private readonly int serverId;
        private readonly int remoteId;
	    private readonly long v1;
	    private readonly long v2;
        private readonly long signature;

        public static readonly BTargetId ZERO = new BTargetId();

        public BTargetId(int serverId, long v1, long v2)
            : this(serverId, 0, v1, v2, 0)
        {
        }

        public BTargetId(int serverId, int remoteId, long v1, long v2, long signature)
        {
            this.serverId = serverId;
            this.remoteId = remoteId;
            this.v1 = v1;
            this.v2 = v2;
            this.signature = signature;
        }

        public BTargetId()
        {
	    }

	    public bool isZero() {
            return serverId == 0 && v1 == 0 && v2 == 0;
	    }

        public int getServerId()
        {
            return serverId;
        }
        public int getRemoteId()
        {
            return remoteId;
        }
        public long getSignature()
        {
            return signature;
        }
	
	    public void write(ByteBuffer buf, int bversion) {
            buf.putInt(serverId);
		    buf.putLong(v1);
		    buf.putLong(v2);
            if (bversion >= BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID)
            {
                buf.putInt(remoteId);
                buf.putLong(signature);
            }
	    }

        public static BTargetId read(ByteBuffer buf, int bversion)
        {
            int serverId = buf.getInt();
		    long v1 = buf.getLong();
		    long v2 = buf.getLong();
            int remoteId = 0;
            long signature = 0;
            if (bversion >= BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID)
            {
                remoteId = buf.getInt();
                signature = buf.getLong();
            }
		    return new BTargetId(serverId, remoteId, v1,v2, signature);
	    }

        public override String ToString()
        {
            StringBuilder builder = new StringBuilder();
            builder.Append('[');
            builder.Append(serverId).Append('.');
            builder.Append(v1).Append('.');
            builder.Append(v2);
            if (remoteId != 0)
            {
                builder.Append(remoteId).Append('.').Append(signature);
            }
            builder.Append(']');
            return builder.ToString();
        }

        //public String makeHeaderString()
        //{
        //    StringBuilder builder = new StringBuilder();
        //    builder.Append(serverId).Append('.');
        //    builder.Append(v1).Append('.');
        //    builder.Append(v2);
        //    if (remoteId != 0)
        //    {
        //        builder.Append(remoteId).Append('.').Append(signature);
        //    }
        //    return builder.ToString();
        //}

        public static BTargetId parseString(String s)
        {
            int serverId = 0, remoteId = 0;
            long v1 = 0, v2 = 0, v3 = 0;
            int p = 0;
            int e = s.IndexOf('.', p);
            if (e < 0) e = s.Length;
            serverId = Convert.ToInt32(s.Substring(p, e-p));

            p = e + 1;
            if (p < s.Length)
            {
                e = s.IndexOf('.', p);
                if (e < 0) e = s.Length;
                v1 = Convert.ToInt64(s.Substring(p, e - p));

                p = e + 1;
                if (p < s.Length)
                {
                    e = s.IndexOf('.', p);
                    if (e < 0) e = s.Length;
                    v2 = Convert.ToInt64(s.Substring(p, e - p));

                    p = e + 1;
                    if (p < s.Length)
                    {
                        e = s.IndexOf('.', p);
                        if (e < 0) e = s.Length;
                        remoteId = Convert.ToInt32(s.Substring(p, e - p));

                        p = e + 1;
                        if (p < s.Length)
                        {
                            e = s.IndexOf('.', p);
                            if (e < 0) e = s.Length;
                            v3 = Convert.ToInt64(s.Substring(p, e - p));
                        }
                    }
                }
            }

            return new BTargetId(serverId, remoteId, v1, v2, v3);
 	    }

	    public override int GetHashCode() {
		    int prime = 31;
		    int result = 1;
            result = prime * serverId;
		    result = prime * result + (int) (v1 ^ (v1 >> 32));
		    result = prime * result + (int) (v2 ^ (v2 >> 32));
		    return result;
	    }

	    public override bool Equals(Object obj) {
		    if (this == obj)
			    return true;
		    if (obj == null)
			    return false;
		    if (GetType() != obj.GetType())
			    return false;
		    BTargetId other = (BTargetId) obj;
            if (serverId != other.serverId)
                return false;
		    if (v1 != other.v1)
			    return false;
		    if (v2 != other.v2)
			    return false;
		    return true;
	    }


        public long getStreamId()
        {
            return v2;
        }

        public long getMessageId()
        {
            return v1;
        }

    }
}
