package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_7007
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class JSerializer_2076960068 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2076960068();
	
	public JSerializer_2076960068() {
		super(2076960068);
	}
	
	public JSerializer_2076960068(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_7007 obj = (BResult_7007)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_7007 obj = (BResult_7007)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_7007()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (byps.test.api.srvr.ChatStructure)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
