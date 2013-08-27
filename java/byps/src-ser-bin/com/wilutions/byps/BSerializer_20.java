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
		bout.bbuf.putString(e.getMessage());
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = ((BInputBin)bin1);
		String msg = bin.bbuf.getString();
		BException e = new BException(msg);
		bin.onObjectCreated(e);
		return e;
	}

}
