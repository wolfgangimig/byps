package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_12
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class BSerializer_534004419 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_534004419();
	
	public BSerializer_534004419() {
		super(534004419);
	}
	
	public BSerializer_534004419(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_12 obj = (BResult_12)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, byps.BSerializer_12.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_12 obj = (BResult_12)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_12()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.List<java.lang.Object>)bin.readObj(false, byps.BSerializer_12.instance);
		
		return obj;
	}
	
}
