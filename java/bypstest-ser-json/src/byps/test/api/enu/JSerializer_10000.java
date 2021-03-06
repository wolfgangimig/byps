package byps.test.api.enu;

/*
 * Serializer for byps.test.api.enu.UsePlanets
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=6

// checkpoint byps.gen.j.GenSerStruct:304
@SuppressWarnings("all")
public class JSerializer_10000 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_10000();
	
	public JSerializer_10000() {
		super(10000);
	}
	
	public JSerializer_10000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final UsePlanets obj = (UsePlanets)obj1;		
		bbuf.putInt("planet", obj.planet!=null ? obj.planet.ordinal() : 0);
		bbuf.putInt("planet2", obj.getPlanet2()!=null ? obj.getPlanet2().ordinal() : 0);
		bbuf.putInt("encoding", obj.encoding!=null ? obj.encoding.ordinal() : 0);
		bout.writeObj("arrayOfPlanets",obj.arrayOfPlanets, false, byps.test.api.JSerializer_1441131650.instance);
		bout.writeObj("listOfPlanets",obj.listOfPlanets, false, byps.test.api.JSerializer_819140569.instance);
		bout.writeObj("mapOfPlanets",obj.mapOfPlanets, false, byps.test.api.JSerializer_493795497.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final UsePlanets obj = (UsePlanets)(obj1 != null ? obj1 : bin.onObjectCreated(new UsePlanets()));
		
		final BJsonObject js = bin.currentObject;
		obj.planet = BEnumHelper.fromOrdinal(byps.test.api.enu.EnumPlanets.values(), js.getInt("planet"));
		obj.setPlanet2(BEnumHelper.fromOrdinal(byps.test.api.enu.EnumPlanets.values(), js.getInt("planet2")));
		obj.encoding = BEnumHelper.fromOrdinal(byps.test.api.enu.MyEncoding.values(), js.getInt("encoding"));
		obj.arrayOfPlanets = (byps.test.api.enu.EnumPlanets[])bin.readObj("arrayOfPlanets", false, byps.test.api.JSerializer_1441131650.instance);
		obj.listOfPlanets = (java.util.ArrayList<byps.test.api.enu.EnumPlanets>)bin.readObj("listOfPlanets", false, byps.test.api.JSerializer_819140569.instance);
		obj.mapOfPlanets = (java.util.Map<java.lang.String,byps.test.api.enu.EnumPlanets>)bin.readObj("mapOfPlanets", false, byps.test.api.JSerializer_493795497.instance);
		
		return obj;
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		final UsePlanets obj = (UsePlanets)(obj1);		
		if (version >= 79400000000000000L) {
		}
		
	}
	
}
