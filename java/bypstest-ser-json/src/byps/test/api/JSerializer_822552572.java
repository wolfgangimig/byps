package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_1488550492
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
public class JSerializer_822552572 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_822552572();
	
	public JSerializer_822552572() {
		super(822552572);
	}
	
	public JSerializer_822552572(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1488550492 obj = (BResult_1488550492)obj1;		
		bout.writeObj("result",obj.result, false, byps.test.api.JSerializer_1488550492.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1488550492 obj = (BResult_1488550492)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1488550492()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.String,java.lang.Object>)bin.readObj("result", false, byps.test.api.JSerializer_1488550492.instance);
		
		return obj;
	}
	
}
