using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public class BNegotiate
    {
	    public const String BINARY_STREAM  = "S";
	
	    public const String PROTOCOLS = BINARY_STREAM;
	
	    private const int NEGOTIATE_MIN_SIZE = 13;  // ["N","J","1"]
	    public const int NEGOTIATE_MAX_SIZE = 1000;
	
	    private const int MAGIC_DOUBLE_QUOTES = ((int)'[' << 24) | ((int)'\"' << 16) | ((int)'N' << 8) | ((int)'\"');
	    private const int MAGIC_SINGLE_QUOTES = ((int)'[' << 24) | ((int)'\'' << 16) | ((int)'N' << 8) | ((int)'\'');
	
	    public String protocols = PROTOCOLS;
	    public int version;
	    public ByteOrder byteOrder; 
	    public BTargetId targetId;

        public BNegotiate()
        {
        }

        public BNegotiate(BApiDescriptor apiDesc)
        {
            this.protocols = PROTOCOLS;
            this.version = apiDesc.version;
        }

        public static bool isNegotiateMessage(ByteBuffer buf)
        {
            if (buf.remaining() >= BNegotiate.NEGOTIATE_MIN_SIZE)
            {
                buf.mark();

                ByteOrder bo = buf.order();
                if (bo != ByteOrder.BIG_ENDIAN) buf.order(ByteOrder.BIG_ENDIAN);

                try
                {
                    // Fast check for ["N" or ['N'
                    int magic = buf.getInt();
                    if (magic == MAGIC_DOUBLE_QUOTES || magic == MAGIC_SINGLE_QUOTES) return true;

                }
                catch (Exception)
                {
                }
                finally
                {
                    buf.reset();
                    if (bo != ByteOrder.BIG_ENDIAN) buf.order(bo);
                }
            }

            return false;
        }

        public void write(ByteBuffer buf) 
        {
            StringBuilder sbuf = new StringBuilder();
            sbuf.Append("[\"N\",")
                .Append("\"S\",") // Binary Stream
                .Append(version).Append(",")
                .Append("\"L\"").Append(",") // Little Endian
                .Append("\"").Append((targetId != null ? targetId : new BTargetId()).ToString()).Append("\"")
                .Append("]");
            buf.put(Encoding.UTF8.GetBytes(sbuf.ToString()));
	    }


        public void read(ByteBuffer buf)
        {
            String str = Encoding.UTF8.GetString(buf.array(), buf.position(), buf.remaining());
            str = str.Trim();
            if (str.IndexOf("[") == 0)
            {
                int endPos = str.IndexOf("]");
                if (endPos == str.Length - 1)
                {
                    str = str.Substring(1, str.Length - 2);
                    String[] items = str.Split(',');
                    int idx = 0;
                    if (items.Length >= 5)
                    {
                        if (items[idx++] == "\"N\"")
                        {
                            protocols = items[idx++];
                            if (protocols.Length >= 3)
                            {
                                protocols = protocols.Substring(1, protocols.Length - 2);

                                version = Convert.ToInt32(items[idx++]);

                                String byteOrderStr = items[idx++];
                                if (byteOrderStr.Equals("\"L\""))
                                {
                                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                                }
                                else if (byteOrderStr.Equals("\"B\""))
                                {
                                    byteOrder = ByteOrder.BIG_ENDIAN;
                                }
                                else
                                {
                                    byteOrder = ByteOrder.UNDEFINED;
                                }

                                String targetIdStr = items[idx++];
                                if (targetIdStr.Length > 2)
                                {
                                    targetIdStr = targetIdStr.Substring(1, targetIdStr.Length - 2);
                                    targetId = BTargetId.parseString(targetIdStr);

                                    return; // OK
                                }
                            }
                        }
                    }
                }
            }

            throw new BException(BException.CORRUPT, "Invalid negotiate message.");
        }
    }
}
