package byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerMapJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_132175071 extends JSerializer_13 {
	
	public final static BSerializer instance = new JSerializer_132175071();
	
	public JSerializer_132175071() {
		super(132175071);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BJsonObject js = bin.currentObject;
		final Set<String> keys = js.keys();
		final HashMap<java.lang.Integer,java.util.List<java.lang.String>> map = new HashMap<java.lang.Integer,java.util.List<java.lang.String>>(keys.size());
		bin.onObjectCreated(map);
		for (String keyName : keys) {
			java.lang.Integer key = keyName != null && keyName.length() != 0 ? Integer.parseInt(keyName) : 0;
			final java.util.List<java.lang.String> value = (java.util.List<java.lang.String>)bin.readObj(keyName, false, byps.test.api.JSerializer_2123584667.instance);
			map.put(key, value);
		}
		return map;
	}
	
	// checkpoint byps.gen.j.GenSerMapJson:80
	@Override
	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {
		final String keyName = key != null ? key.toString() : "";
		// checkpoint byps.gen.j.PrintContext:313
		bout.writeObj(keyName, value, false, byps.test.api.JSerializer_2123584667.instance);
	}
	
}
