package com.wilutions.byps;



public class BSerializer_20 extends BSerializer {

	public final static BSerializer instance = new BSerializer_20();

	public BSerializer_20() {
		super(BRegistry.TYPEID_EXCEPTION);
	}

	public BSerializer_20(int typeId) {
		super(typeId);
	}
	
	@Override
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0;
	}

	@Override
	public void write(final Object obj, final BOutput bout1, final long version) throws BException {
		final BOutputBin bout = ((BOutputBin)bout1);
		final BException e = (BException)obj;
		bout.bbuf.putInt(e.code);
		bout.bbuf.putString(e.msg);
		bout.bbuf.putString(e.details);
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = ((BInputBin)bin1);
		final int code = bin.bbuf.getInt();
		String msg = bin.bbuf.getString();
		String details = bin.bbuf.getString();
		BException e = new BException(code, msg, details);
		bin.onObjectCreated(e);
		return e;
	}

}
