using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
{
    public class BMessageHeader
    {
        public const int MAGIC_BINARY_STREAM = ((int)'B' << 24) | ((int)'Y' << 16) | ((int)'P' << 8) | ((int)'S');
	    private const int MAGIC_BINARY_STREAM_LE = ((int)'S' << 24) | ((int)'P' << 16) | ((int)'Y' << 8) | ((int)'B');
	
	    public const int MAGIC_JSON = ((int)'{' << 24) | ((int)'\"' << 16) | ((int)'h' << 8) | ((int)'e');
	    private const int MAGIC_JSON_SINGLE_QUOTE = ((int)'{' << 24) | ((int)'\'' << 16) | ((int)'h' << 8) | ((int)'e');
		
	    public const int FLAG_STREAM = 1;
	    public const int FLAG_RESPONSE = 2;

	    public int magic;
	    public int error;
	    public int flags;
	    public int version;
	    public BTargetId targetId;
	    public long messageId;
	    public long streamId; // if (flags & FLAG_STREAM)
	
	    public ByteOrder byteOrder;

	    public BMessageHeader(int magic, int version, ByteOrder byteOrder, long mid) {
		    this.magic = magic;
		    this.version = version;
		    this.byteOrder = byteOrder;
		    this.messageId = mid;
	    }
	
	    public BMessageHeader() {
	    }
	
	    public BMessageHeader(BMessageHeader rhs) {
		    this.magic = rhs.magic;
		    this.version = rhs.version;
		    this.byteOrder = rhs.byteOrder;
		    this.error = rhs.error;
		    this.flags = rhs.flags;
		    this.messageId = rhs.messageId;
		    this.streamId = rhs.streamId;
		    this.targetId = rhs.targetId;
	    }
	
	    public BMessageHeader createResponse() {
		    BMessageHeader hdr = new BMessageHeader(this);
		    hdr.flags |= FLAG_RESPONSE;
		    return hdr;
	    }
	
	    public static int detectProtocol(ByteBuffer buf) {
		    buf.mark();
		    int magic = readProtocol(buf);
		    if (magic == MAGIC_BINARY_STREAM_LE) magic = MAGIC_BINARY_STREAM;
		    buf.reset();
		    return magic;
	    }
	
	    private static int readProtocol(ByteBuffer buf) {
		    int magic = buf.getInt();
		
		    switch (magic) {
                    // Only Little Endian supported
		    case MAGIC_BINARY_STREAM: 
                break;
		    default: 
                magic = 0;
                break;
		    }
		
            return magic;
	    }
	
	    public void write(ByteBuffer buf) {
			buf.putInt(MAGIC_BINARY_STREAM);
			buf.putInt(error); 
			buf.putInt(flags); 
			buf.putInt(version);
			targetId.write(buf);
			buf.putLong(messageId);
			if ((flags & FLAG_STREAM) != 0) {
				buf.putLong(streamId);
		    }
	    }

	    private void readBinaryWithoutMagic(ByteBuffer buf) {
		    error = buf.getInt();
		    flags = buf.getInt();
		    version = buf.getInt();
		    targetId = BTargetId.read(buf);
		    messageId = buf.getLong();
		    if ((flags & FLAG_STREAM) != 0) {
			    streamId = buf.getLong();
		    }
	    }
	
	    public void read(ByteBuffer buf) {
		    int magic = readProtocol(buf);
		    switch (magic) {
		    case MAGIC_BINARY_STREAM: 
			    byteOrder = ByteOrder.LITTLE_ENDIAN;
			    readBinaryWithoutMagic(buf);
			    break;
		    default: 
			    throw new BException(BException.CORRUPT, "Invalid protocol.");
		    }
	    }
	
	    public bool isStreamRequest() {
		    return (flags & FLAG_STREAM) != 0;
	    }

    }
}
