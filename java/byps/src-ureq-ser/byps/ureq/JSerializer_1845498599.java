package byps.ureq;

/*
 * Serializer for byps.ureq.BResult_19
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
public class JSerializer_1845498599 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1845498599();
	
	public JSerializer_1845498599() {
		super(1845498599);
	}
	
	public JSerializer_1845498599(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_19 obj = (BResult_19)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_19()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
