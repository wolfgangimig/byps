using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class BTargetId
    {

	    public readonly long v1;
	    public readonly long v2;

        public BTargetId(long v1, long v2)
        {
            this.v1 = v1;
            this.v2 = v2;
        }
	
	    public BTargetId() {
		    v1 = v2 = 0;
	    }
	
	    public bool isZero() {
            return v1 == 0 && v2 == 0;
	    }
	
	    public void write(ByteBuffer buf) {
		    buf.putLong(v1);
		    buf.putLong(v2);
	    }
	
	    public static BTargetId read(ByteBuffer buf) {
		    long v1 = buf.getLong();
		    long v2 = buf.getLong();
		    return new BTargetId(v1,v2);
	    }


        private static void longToHex(StringBuilder builder, long v) {
            String h = Convert.ToString(v, 16);
		    String _0 = "0000000000000000";
		    builder.Append(_0.Substring(0, 16-h.Length)).Append(h);
	    }

        private static long hexToLong(String s, int offs)
        {
            long v = 0;
            for (int i = 0; i < 16; i += 2)
            {
                String d = s.Substring(offs + i, 2);
                int n = Convert.ToInt32(d, 16);
                v = (v << 8) + (n & 0xFF);
            }
            return v;
        }
	

	    public override String ToString() {
		    if (isZero()) return "";
		    StringBuilder builder = new StringBuilder();
            Convert.ToString(v1, 16);
            longToHex(builder, v1);
            longToHex(builder, v2);
            return builder.ToString();
	    }
	
	    public static BTargetId parseString(String s) {
            if (s.Length < 32) return new BTargetId();
            long v1 = hexToLong(s, 0);
            long v2 = hexToLong(s, 16);
            return new BTargetId(v1, v2);
	    }

	    public override int GetHashCode() {
		    int prime = 31;
		    int result = 1;
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
		    if (v1 != other.v1)
			    return false;
		    if (v2 != other.v2)
			    return false;
		    return true;
	    }


    }
}
