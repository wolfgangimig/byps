package com.wilutions.byps;



public class BSerializer_22 extends BSerializer {

	public final static BSerializer instance = new BSerializer_22();

	public BSerializer_22() {
		super(BRegistry.TYPEID_VALUECLASS);
	}

	public BSerializer_22(int typeId) {
		super(typeId);
	}
	
	@Override
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0;
	}

	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BOutputBin bout = ((BOutputBin)bout1);
		final BValueClass obj = (BValueClass)obj1;
		bout.bbuf.putLong(obj.changedMembers);
	}

	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = ((BInputBin)bin1);
		final long v = bin.bbuf.getLong();
		BValueClass obj = (BValueClass)obj1;
		if (obj == null) {
			obj = new BValueClass();
			bin.onObjectCreated(obj);
		}
		obj.setChangedMember(v);
		return obj;
	}

}
