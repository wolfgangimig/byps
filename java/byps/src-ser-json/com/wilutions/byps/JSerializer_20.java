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
	protected void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BException e = (BException)obj1;
		bbuf.putInt("code", e.code);
		bbuf.putString("msg", e.msg);
		bbuf.putString("details", e.details);
	}

	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final int code = bin.currentObject.getInt("code");
		final String msg = bin.currentObject.getString("msg");
		final String details = bin.currentObject.getString("details");
		final BException e = new BException(code, msg, details);
		bin.onObjectCreated(e);
		return e;
	}

}
