package com.wilutions.byps;



public class JSerializer_20 extends JSerializer_Object {

	public final static BSerializer instance = new JSerializer_20();

	public JSerializer_20() {
		super(BRegistry.TYPEID_EXCEPTION);
	}

	public JSerializer_20(int typeId) {
		super(typeId);
	}

	@Override
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0;
	}

	@Override
	protected void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BException e = (BException)obj1;
		bbuf.putString("msg", e.getMessage());
	}

	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final String msg = bin.currentObject.getString("msg");
		final BException e = new BException(msg);
		bin.onObjectCreated(e);
		return e;
	}

}
