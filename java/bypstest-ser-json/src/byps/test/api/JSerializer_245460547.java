package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_39910537
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
public class JSerializer_245460547 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_245460547();
	
	public JSerializer_245460547() {
		super(245460547);
	}
	
	public JSerializer_245460547(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_39910537 obj = (BResult_39910537)obj1;		
		bout.writeObj("result",obj.result, false, byps.test.api.JSerializer_39910537.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_39910537 obj = (BResult_39910537)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_39910537()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (int[][][][])bin.readObj("result", false, byps.test.api.JSerializer_39910537.instance);
		
		return obj;
	}
	
}
