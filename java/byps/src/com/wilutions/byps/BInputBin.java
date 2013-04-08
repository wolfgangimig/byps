package com.wilutions.byps;

import java.nio.ByteBuffer;

public abstract class BInputBin extends BInput {

	public final BBufferBin bbuf;

	public BInputBin(BMessageHeader header, ByteBuffer buf, BTransport transport, BRegistry registry) {
		super(header, transport, registry);
		this.bbuf = (BBufferBin)BBuffer.create(transport.apiDesc.bmodel, buf);
	}

	public Object load() throws BException {
		if (header.messageId == 0) {
			header.read(bbuf.buf);
		}
		if (header.error != 0) {
			Throwable ex = (Throwable)readObj(false, null);
			if (ex instanceof BException) throw (BException)ex;
			throw new BException(header.error, ex.toString(), ex);
		}
		return readObj(false, null);
	}
	
	public abstract Object readObj(boolean isUnique, BSerializer ser) throws BException;

	@Override
	public boolean getBoolean(String name) {
		return bbuf.getBoolean();
	}

	@Override
	public short getShort(String name) {
		return bbuf.getShort();
	}

	@Override
	public int getInt(String name) {
		return bbuf.getInt();
	}

	@Override
	public long getLong(String name) {
		return bbuf.getLong();
	}

	@Override
	public float getFloat(String name) {
		return bbuf.getFloat();
	}

	@Override
	public double getDouble(String name) {
		return bbuf.getDouble();
	}

	@Override
	public String getString(String name) {
		return bbuf.getString();
	}
}
