package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_16
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
public class JSerializer_534004415 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_534004415();
	
	public JSerializer_534004415() {
		super(534004415);
	}
	
	public JSerializer_534004415(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_16 obj = (BResult_16)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_16 obj = (BResult_16)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_16()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (BRemote)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
