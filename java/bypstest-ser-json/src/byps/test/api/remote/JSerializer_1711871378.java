package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteConstants_compare_HebrewC
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=2

// checkpoint byps.gen.j.GenSerStruct:274
@SuppressWarnings("all")
public class JSerializer_1711871378 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1711871378();
	
	public JSerializer_1711871378() {
		super(1711871378);
	}
	
	public JSerializer_1711871378(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteConstants_compare_HebrewC obj = (BRequest_RemoteConstants_compare_HebrewC)obj1;		
		bout.writeObj("ALEPH",obj.ALEPH, false, null);
		bout.writeObj("BETH",obj.BETH, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteConstants_compare_HebrewC obj = (BRequest_RemoteConstants_compare_HebrewC)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteConstants_compare_HebrewC()));
		
		final BJsonObject js = bin.currentObject;
		obj.ALEPH = (byps.test.api.cons.HebrewZ)bin.readObj("ALEPH", false, null);
		obj.BETH = (byps.test.api.cons.HebrewZ)bin.readObj("BETH", false, null);
		
		return obj;
	}
	
}
