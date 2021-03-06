package byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Integer,int[]>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerMapJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1633750383 extends JSerializer_13 {
	
	public final static BSerializer instance = new JSerializer_1633750383();
	
	public JSerializer_1633750383() {
		super(1633750383);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BJsonObject js = bin.currentObject;
		final Set<String> keys = js.keys();
		final HashMap<java.lang.Integer,int[]> map = new HashMap<java.lang.Integer,int[]>(keys.size());
		bin.onObjectCreated(map);
		for (String keyName : keys) {
			java.lang.Integer key = keyName != null && keyName.length() != 0 ? Integer.parseInt(keyName) : 0;
			final int[] value = (int[])bin.readObj(keyName, false, byps.test.api.JSerializer_100361105.instance);
			map.put(key, value);
		}
		return map;
	}
	
	// checkpoint byps.gen.j.GenSerMapJson:80
	@Override
	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {
		final String keyName = key != null ? key.toString() : "";
		// checkpoint byps.gen.j.PrintContext:340
		bout.writeObj(keyName, value, false, byps.test.api.JSerializer_100361105.instance);
	}
	
}
