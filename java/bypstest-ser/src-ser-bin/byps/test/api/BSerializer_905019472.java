package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_51898890
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
public class BSerializer_905019472 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_905019472();
	
	public BSerializer_905019472() {
		super(905019472);
	}
	
	public BSerializer_905019472(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_51898890 obj = (BResult_51898890)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, byps.test.api.BSerializer_51898890.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_51898890 obj = (BResult_51898890)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_51898890()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.Date[][][][])bin.readObj(false, byps.test.api.BSerializer_51898890.instance);
		
		return obj;
	}
	
}
