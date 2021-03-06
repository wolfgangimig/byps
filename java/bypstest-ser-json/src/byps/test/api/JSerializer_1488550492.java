package byps.test.api;

/*
 * Serializer for java.util.Map<java.lang.String,java.lang.Object>
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenSerMapJson DO NOT MODIFY.
 */

import byps.*;
import java.util.*;

@SuppressWarnings("all")
public class JSerializer_1488550492 extends JSerializer_13 {
	
	public final static BSerializer instance = new JSerializer_1488550492();
	
	public JSerializer_1488550492() {
		super(1488550492);	}
	
	
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputJson bin = (BInputJson)bin1;
		final BJsonObject js = bin.currentObject;
		final Set<String> keys = js.keys();
		final HashMap<java.lang.String,java.lang.Object> map = new HashMap<java.lang.String,java.lang.Object>(keys.size());
		bin.onObjectCreated(map);
		for (String keyName : keys) {
			java.lang.String key = keyName;
			final java.lang.Object value = (java.lang.Object)bin.readObj(keyName, false, null);
			map.put(key, value);
		}
		return map;
	}
	
	// checkpoint byps.gen.j.GenSerMapJson:80
	@Override
	protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {
		final String keyName = key != null ? (String)key : "";
		// checkpoint byps.gen.j.PrintContext:340
		bout.writeObj(keyName, value, false, null);
	}
	
	@Override
	public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {
		Map<java.lang.String,java.lang.Object> map = (Map<java.lang.String,java.lang.Object>)obj1;
		for (Map.Entry<java.lang.String,java.lang.Object> obj : map.entrySet()) {
			bin.prepareForLazyLoading(obj.getValue(), null);
		}
	}
	
}
