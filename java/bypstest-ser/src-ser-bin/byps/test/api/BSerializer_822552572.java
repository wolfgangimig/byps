package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_1488550492
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
public class BSerializer_822552572 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_822552572();
	
	public BSerializer_822552572() {
		super(822552572);
	}
	
	public BSerializer_822552572(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_1488550492 obj = (BResult_1488550492)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, byps.test.api.BSerializer_1488550492.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_1488550492 obj = (BResult_1488550492)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1488550492()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.Map<java.lang.String,java.lang.Object>)bin.readObj(false, byps.test.api.BSerializer_1488550492.instance);
		
		return obj;
	}
	
}
