package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_1596367810
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
public class JSerializer_1073221568 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1073221568();
	
	public JSerializer_1073221568() {
		super(1073221568);
	}
	
	public JSerializer_1073221568(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1596367810 obj = (BResult_1596367810)obj1;		
		bout.writeObj("result",obj.result, false, byps.test.api.JSerializer_1596367810.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1596367810 obj = (BResult_1596367810)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1596367810()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<byps.test.api.prim.PrimitiveTypes>)bin.readObj("result", false, byps.test.api.JSerializer_1596367810.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final BResult_1596367810 obj = (BResult_1596367810)(obj1);		
		bin.prepareForLazyLoading(obj.result, byps.test.api.BSerializer_1596367810.instance);
		
	}
	
}
