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
        public readonly int serverId;
	    public readonly long v1;
	    public readonly long v2;

        public static readonly BTargetId ZERO = new BTargetId();

        public BTargetId(int serverId, long v1, long v2)
        {
            this.serverId = serverId;
            this.v1 = v1;
            this.v2 = v2;
        }
	
	    public BTargetId() {
            serverId = 0;
		    v1 = v2 = 0;
	    }
	
	    public bool isZero() {
            return serverId == 0 && v1 == 0 && v2 == 0;
	    }
	
	    public void write(ByteBuffer buf) {
            buf.putInt(serverId);
		    buf.putLong(v1);
		    buf.putLong(v2);
	    }
	
	    public static BTargetId read(ByteBuffer buf) {
            int serverId = buf.getInt();
		    long v1 = buf.getLong();
		    long v2 = buf.getLong();
		    return new BTargetId(serverId, v1,v2);
	    }

	    public override String ToString() {
		    if (isZero()) return "";
		    StringBuilder builder = new StringBuilder();
            builder.Append(serverId).Append('.');
            builder.Append(v1).Append('.');
            builder.Append(v2);
            return builder.ToString();
	    }
	
	    public static BTargetId parseString(String s) {
            int serverId = 0;
            long v1 = 0, v2 = 0;
            int p = s.IndexOf('.');
            if (p >= 0)
            {
                serverId = Convert.ToInt32(s.Substring(0, p));
                p++;
                int e = s.IndexOf('.', p);
                if (e >= 0)
                {
                    v1 = Convert.ToInt64(s.Substring(p, e - p));
                    e++;
                    v2 = Convert.ToInt64(s.Substring(e));
                }
            }
            return new BTargetId(serverId, v1, v2);
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
