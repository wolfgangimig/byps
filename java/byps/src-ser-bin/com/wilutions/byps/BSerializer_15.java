package com.wilutions.byps;

import java.io.IOException;
import java.io.InputStream;


public class BSerializer_15 extends BSerializer {

	public final static BSerializer instance = new BSerializer_15();

	public BSerializer_15() {
		super(BRegistry.TYPEID_STREAM);
	}

	@Override
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 8;
	}

	@Override
	public void write(final Object obj, final BOutput bout1, final int version) throws BException {
		final BOutputBin bout = ((BOutputBin)bout1);
		InputStream is = (InputStream)obj;
		BStreamRequest streamRequest = bout.createStreamRequest(is);
		bout.bbuf.putLong(streamRequest.streamId);
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		BInputBin bin = ((BInputBin)bin1);
		long streamId = bin.bbuf.getLong();
		try {
			InputStream strm = bin.transport.wire.getStream(bin.header.messageId, streamId);
			bin.onObjectCreated(strm);
			return strm;
		} catch (IOException e) {
			throw new BException(BException.IOERROR, e.getMessage());
		}
	}

}
