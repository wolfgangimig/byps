package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteServerCtrl_getPublishedRemote
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
public class JSerializer_648762723 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_648762723();
	
	public JSerializer_648762723() {
		super(648762723);
	}
	
	public JSerializer_648762723(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteServerCtrl_getPublishedRemote obj = (BRequest_RemoteServerCtrl_getPublishedRemote)obj1;		
		bbuf.putString("name", obj.name);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteServerCtrl_getPublishedRemote obj = (BRequest_RemoteServerCtrl_getPublishedRemote)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteServerCtrl_getPublishedRemote()));
		
		final BJsonObject js = bin.currentObject;
		obj.name = js.getString("name");
		
		return obj;
	}
	
}