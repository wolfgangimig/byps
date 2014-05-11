package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import byps.BException;

public abstract class BOutputBin extends BOutput {

	public final BBufferBin bbuf;

	public BOutputBin(BTransport transport, BMessageHeader requestHeader) {
		super(transport, transport.getApiDesc().getRegistry(BProtocolS.BINARY_MODEL), requestHeader);
		this.bbuf = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, null);
	}

	public BOutputBin(BTransport transport, int streamHeaderMagic, int negotiatedBypsVersion, long negotiatedVersion, ByteOrder negotiatedByteOrder) {
		super(transport, transport.getApiDesc().getRegistry(BProtocolS.BINARY_MODEL), streamHeaderMagic, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder);
		this.bbuf = (BBufferBin)BBuffer.create(BBinaryModel.MEDIUM, null);
	}
	
	@Override
	public ByteBuffer toByteBuffer() {
		if (bbuf.position() != 0) {
			bbuf.flip();
		}
		return bbuf.getBuffer();
	}

	@Override
	protected void internalStore(Object obj) throws BException {
		bbuf.clear();
		if (objMap != null) objMap.clear();
		header.writeBin(bbuf.getBuffer());
		storeObj(obj);
	}
	
	protected abstract void storeObj(Object obj) throws BException;
	
	public abstract void writeObj(Object obj, boolean isUnique, BSerializer ser) throws BException;	

	public void beginObject() {
	}
	public void endObject() {
	}
	public void putBoolean(String name, boolean value) {
		bbuf.putBoolean(value);
	}
	public void putShort(String name, short value) {
		bbuf.putShort(value);
	}
	public void putInt(String name, int value) {
		bbuf.putInt(value);
	}
	public void putLong(String name, long value){
		bbuf.putLong(value);
	}
	public void putFloat(String name, float value) {
		bbuf.putFloat(value);
	}
	public void putDouble(String name, double value) {
		bbuf.putDouble(value);
	}
	public void putString(String name, String value) {
		bbuf.putString(value);
	}
	

}
