package byps.test.api;

/*
 * Serializer for byps.test.api.BResult_1888107655
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
public class JSerializer_2063745441 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2063745441();
	
	public JSerializer_2063745441() {
		super(2063745441);
	}
	
	public JSerializer_2063745441(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1888107655 obj = (BResult_1888107655)obj1;		
		bout.writeObj("result",obj.result, true, byps.test.api.JSerializer_1888107655.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1888107655 obj = (BResult_1888107655)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1888107655()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.String[])bin.readObj("result", true, byps.test.api.JSerializer_1888107655.instance);
		
		return obj;
	}
	
}
