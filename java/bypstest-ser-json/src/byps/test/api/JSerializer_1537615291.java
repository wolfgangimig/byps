package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_588723219
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class JSerializer_1537615291 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1537615291();
	
	public JSerializer_1537615291() {
		super(1537615291);
	}
	
	public JSerializer_1537615291(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_588723219 obj = (BResult_588723219)obj1;		
		bout.writeObj("result",obj.result, true, byps.test.api.JSerializer_588723219.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_588723219 obj = (BResult_588723219)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_588723219()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.String[][][][])bin.readObj("result", true, byps.test.api.JSerializer_588723219.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BResult_588723219 obj = (BResult_588723219)(obj1);		
		
	}
	
}
