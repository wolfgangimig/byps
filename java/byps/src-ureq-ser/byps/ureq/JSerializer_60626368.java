package byps.ureq;

/*
 * Serializer for byps.ureq.BResult_1710660846
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
public class JSerializer_60626368 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_60626368();
	
	public JSerializer_60626368() {
		super(60626368);
	}
	
	public JSerializer_60626368(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1710660846 obj = (BResult_1710660846)obj1;		
		bout.writeObj("result",obj.result, false, byps.ureq.JSerializer_1710660846.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1710660846 obj = (BResult_1710660846)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1710660846()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.String,java.lang.String>)bin.readObj("result", false, byps.ureq.JSerializer_1710660846.instance);
		
		return obj;
	}
	
}
