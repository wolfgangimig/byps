package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_1633750383
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
public class BSerializer_1293200061 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1293200061();
	
	public BSerializer_1293200061() {
		super(1293200061);
	}
	
	public BSerializer_1293200061(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_1633750383 obj = (BResult_1633750383)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, byps.test.api.BSerializer_1633750383.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_1633750383 obj = (BResult_1633750383)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1633750383()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.Map<java.lang.Integer,int[]>)bin.readObj(false, byps.test.api.BSerializer_1633750383.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BResult_1633750383 obj = (BResult_1633750383)(obj1);		
		
	}
	
}
