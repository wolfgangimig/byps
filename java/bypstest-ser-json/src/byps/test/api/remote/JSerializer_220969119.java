package byps.test.api.remote;

/*
 * Serializer for byps.test.api.remote.BRequest_RemoteEnums_setPlanet
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
public class JSerializer_220969119 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_220969119();
	
	public JSerializer_220969119() {
		super(220969119);
	}
	
	public JSerializer_220969119(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteEnums_setPlanet obj = (BRequest_RemoteEnums_setPlanet)obj1;		
		bbuf.putInt("planet", obj.planet!=null ? obj.planet.ordinal() : 0);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteEnums_setPlanet obj = (BRequest_RemoteEnums_setPlanet)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteEnums_setPlanet()));
		
		final BJsonObject js = bin.currentObject;
		obj.planet = BEnumHelper.fromOrdinal(byps.test.api.enu.EnumPlanets.values(), js.getInt("planet"));
		
		return obj;
	}
	
}
