package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_846419204
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class BSerializer_167272824 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_167272824();
	
	public BSerializer_167272824() {
		super(167272824);
	}
	
	public BSerializer_167272824(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_846419204 obj = (BResult_846419204)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, byps.test.api.BSerializer_846419204.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_846419204 obj = (BResult_846419204)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_846419204()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (long[][][][])bin.readObj(false, byps.test.api.BSerializer_846419204.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BResult_846419204 obj = (BResult_846419204)(obj1);		
		
	}
	
}
