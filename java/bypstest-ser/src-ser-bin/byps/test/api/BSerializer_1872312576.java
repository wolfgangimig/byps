package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_65775978
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
public class BSerializer_1872312576 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1872312576();
	
	public BSerializer_1872312576() {
		super(1872312576);
	}
	
	public BSerializer_1872312576(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BResult_65775978 obj = (BResult_65775978)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_65775978 obj = (BResult_65775978)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_65775978()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (byps.test.api.auth.SessionInfo)bin.readObj(false, null);
		
		return obj;
	}
	
}