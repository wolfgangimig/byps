package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_15
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
public class BSerializer_534004416 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_534004416();
	
	public BSerializer_534004416() {
		super(534004416);
	}
	
	public BSerializer_534004416(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_15 obj = (BResult_15)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_15 obj = (BResult_15)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_15()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.io.InputStream)bin.readObj(false, null);
		
		return obj;
	}
	
}
