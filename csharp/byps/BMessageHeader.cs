/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BMessageHeader
    {
        public const int MAGIC_BINARY_STREAM = ((int)'B' << 24) | ((int)'Y' << 16) | ((int)'P' << 8) | ((int)'S');
        private const int MAGIC_BINARY_STREAM_LE = ((int)'S' << 24) | ((int)'P' << 16) | ((int)'Y' << 8) | ((int)'B');

        public const int MAGIC_JSON = ((int)'{' << 24) | ((int)'\"' << 16) | ((int)'h' << 8) | ((int)'e');
        private const int MAGIC_JSON_SINGLE_QUOTE = ((int)'{' << 24) | ((int)'\'' << 16) | ((int)'h' << 8) | ((int)'e');

        public const int BYPS_VERSION_EXTENDED_STREAM_INFORMATION = 1;
        public const int BYPS_VERSION_ENCRYPTED_TARGETID = 2;
        public const int BYPS_VERSION_WITH_SESSIONID = 3;
        public const int BYPS_VERSION_CURRENT = BYPS_VERSION_WITH_SESSIONID;

        public const int FLAG_BYPS_VERSION = 1;
        public const int FLAG_RESPONSE = 2;

        public int magic;
        public int error;
        public int flags;
        public int bversion;
        public long version;
        public BTargetId targetId;
        public long messageId;
        public String sessionId = BTargetId.SESSIONID_ZERO;

        public ByteOrder byteOrder;

        public BMessageHeader(int magic, int bversion, long version, ByteOrder byteOrder, long mid)
        {
            this.magic = magic;
            this.bversion = bversion;
            this.version = version;
            this.byteOrder = byteOrder;
            this.messageId = mid;
            if (bversion != 0)
            {
                this.flags = FLAG_BYPS_VERSION;
            }
        }

        public BMessageHeader()
        {
        }

        public BMessageHeader(BMessageHeader rhs)
        {
            this.magic = rhs.magic;
            this.bversion = rhs.bversion;
            this.version = rhs.version;
            this.byteOrder = rhs.byteOrder;
            this.error = rhs.error;
            this.flags = rhs.flags;
            this.messageId = rhs.messageId;
            this.targetId = rhs.targetId;
            this.sessionId = rhs.sessionId;
        }

        public BMessageHeader createResponse()
        {
            BMessageHeader hdr = new BMessageHeader(this);
            hdr.flags |= FLAG_RESPONSE;
            return hdr;
        }

        public static int detectProtocol(ByteBuffer buf)
        {
            buf.mark();
            int magic = readProtocol(buf);
            if (magic == MAGIC_BINARY_STREAM_LE) magic = MAGIC_BINARY_STREAM;
            buf.reset();
            return magic;
        }

        private static int readProtocol(ByteBuffer buf)
        {
            int magic = buf.getInt();

            switch (magic)
            {
                // Only Little Endian supported
                case MAGIC_BINARY_STREAM:
                    break;
                default:
                    magic = 0;
                    break;
            }

            return magic;
        }

        public void write(ByteBuffer buf)
        {
            buf.putInt(MAGIC_BINARY_STREAM);
            buf.putInt(error);
            buf.putInt(flags);

            if ((flags & FLAG_BYPS_VERSION) != 0)
            {
                buf.putInt(bversion);
            }

            buf.putLong(version);
            targetId.write(buf, bversion);
            buf.putLong(messageId);

            if (bversion >= BYPS_VERSION_WITH_SESSIONID)
            {
                BTargetId.writeSessionId(buf, sessionId);
            }
        }

        private void readBinaryWithoutMagic(ByteBuffer buf)
        {
            error = buf.getInt();
            flags = buf.getInt();

            if ((flags & FLAG_BYPS_VERSION) != 0)
            {
                bversion = buf.getInt();
            }

            version = buf.getLong();
            targetId = BTargetId.read(buf, bversion);
            messageId = buf.getLong();
        
            if (bversion >= BYPS_VERSION_WITH_SESSIONID)
            {
                sessionId = BTargetId.readSessionId(buf);
            }
        }

        public void read(ByteBuffer buf)
        {
            int magic = readProtocol(buf);
            switch (magic)
            {
                case MAGIC_BINARY_STREAM:
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                    readBinaryWithoutMagic(buf);
                    break;
                default:
                    throw new BException(BExceptionC.CORRUPT, "Invalid protocol.");
            }
        }

 
    }
}
