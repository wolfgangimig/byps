package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_4
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
public class BSerializer_432867944 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_432867944();
	
	public BSerializer_432867944() {
		super(432867944);
	}
	
	public BSerializer_432867944(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_4 obj = (BResult_4)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putChar(obj.result);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_4 obj = (BResult_4)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_4()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = bbuf.getChar();
		
		return obj;
	}
	
}
