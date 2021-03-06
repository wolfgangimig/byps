package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class BJsonObject {
	
	final HashMap<String,Object> map;
	final ArrayList<Object> arr;

	public BJsonObject(HashMap<String,Object> map) {
		this.map = map;
		this.arr = null;
	}
	
	public BJsonObject(ArrayList<Object> arr) {
		this.arr = arr;
		this.map = null;
	}
	
	public BJsonObject() {
		map = null;
		arr = null;
	}
	
	public int size() {
		return arr != null ? arr.size() : 0;
	}
	
	public Set<String> keys() {
		return map.keySet();
	}
	
	public final Object get(String name) {
		return map != null ? map.get(name) : null;
	}
	
	public final Object get(int i) {
		return arr != null ? arr.get(i) : null;
	}
	
	private final boolean parseBoolean(Object v) {
	  if (v == null) return false;
		try {
			return (Boolean)v;
		}
		catch (Throwable ignored) {
		}
    try {
      return Boolean.parseBoolean((String)v);
    }
    catch (Throwable ignored) {
    }
    return false;
	}
	
	public final boolean getBoolean(String name) {
		return parseBoolean(get(name));
	}
	
	public final boolean getBoolean(int i) {
		return parseBoolean(get(i));
	}
	
	private final byte parseByte(Object v) {
	  if (v == null) return 0;
		try {
			return ((Double)v).byteValue();
		}
		catch (Throwable ignored) {
		}
		try {
		  return Byte.valueOf((String)v);
		}
		catch (Throwable ignored) {
		}
		return 0;
	}
	
	public final byte getByte(String name) {
		return parseByte(get(name));
	}
	
	public final byte getByte(int i) {
		return parseByte(get(i));
	}
	
	private final char parseChar(Object v) {
		String s = (String)v;
		return s != null && s.length() != 0 ? s.charAt(0) : 0;
	}
	
	public final char getChar(String name) {
		return parseChar(get(name));
	}
	
	public final char getChar(int i) {
		return parseChar(get(i));
	}

	private final short parseShort(Object v) {
    if (v == null) return 0;
    try {
      return ((Double)v).shortValue();
    }
    catch (Throwable ignored) {
    }
    try {
      return Short.valueOf((String)v);
    }
    catch (Throwable ignored) {
    }
    return 0;
	}
	
	public final short getShort(String name) {
		return parseShort(get(name));
	}
	
	public final short getShort(int i) {
		return parseShort(get(i));
	}

	private final int parseInt(Object v) {
    if (v == null) return 0;
    try {
      return ((Double)v).intValue();
    }
    catch (Throwable ignored) {
    }
    try {
      return Integer.valueOf((String)v);
    }
    catch (Throwable ignored) {
    }
    return 0;
	}
	
	public final int getInt(String name) {
		return parseInt(get(name));
	}
	
	public final int getInt(int i) {
		return parseInt(get(i));
	}
	
	private final long parseLong(Object v) {
    if (v == null) return 0;
    try {
      return BBufferJson.parseLong((String)v);
    }
    catch (Throwable ignored) {
    }
    try {
      return ((Double)v).longValue();
    }
    catch (Throwable ignored) {
    }
    return 0;
	}
	
	public final long getLong(String name) {
		return parseLong(get(name));
	}
	
	public final long getLong(int i) {
		return parseLong(get(i));
	}

	private final float parseFloat(Object v) {
		try {
			return v != null ? ((Double)v).floatValue() : 0;
		}
		catch (ClassCastException ignored) {
			return Float.valueOf((String)v);
		}
	}
	
	public final float getFloat(String name) {
		return parseFloat(get(name));
	}
	
	public final float getFloat(int i) {
		return parseFloat(get(i));
	}

	private final double parseDouble(Object v) {
		try {
			return v != null ? ((Double)v).doubleValue() : 0;
		}
		catch (ClassCastException ignored) {
			return Double.valueOf((String)v);
		}
	}
	
	public final double getDouble(String name) {
		return parseDouble(get(name));
	}
	
	public final double getDouble(int i) {
		return parseDouble(get(i));
	}

	public final String getString(String name) {
		Object v = get(name);
		return makeStringValue(v);
	}
	
	public final String getString(int i) {
	  Object v = get(i);
	  return makeStringValue(v);
	}
	
	private final String makeStringValue(Object v) {
    if (v == null) return "";
    if (v instanceof String) return (String)v;
    if (v instanceof Double) {
      Double d = (Double)v;
      if (Math.floor(d) == d) {
        v = d.longValue();
      }
    }
    return v.toString();
	}
	
	public final Date getDate(String name) {
	  return BBufferJson.toDate(get(name));
	}
	
	public final Date getDate(int i) {
	  return BBufferJson.toDate(get(i));
	}
	
	private final byte[] parseArrayByte(Object s) {
		if (s == null) return null;
		//return DatatypeConverter.parseBase64Binary((String)s);
		String str = (String)s;
		int cap = str.length() * 3 + 2;
		ByteBuffer buf = ByteBuffer.allocate(cap);
		BBufferJson bbuf = new BBufferJson(buf);
		bbuf.putString(str);
		bbuf.flip();
		return bbuf.getArrayByte();
	}
	
	public final byte[] getArrayByte(int i) {
		return parseArrayByte(get(i));
	}
	
	public final byte[] getArrayByte(String name) {
		return parseArrayByte(get(name));
	}
	
	public final BJsonObject getJsonObject(int i) {
		return (BJsonObject)get(i);
	}
	
	public final BJsonObject getJsonObject(String name) {
		return (BJsonObject)get(name);
	}
	
	public static BJsonObject fromString(String s) throws BException {
		BBufferJson bbuf;
		try {
			bbuf = new BBufferJson(ByteBuffer.wrap(s.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			throw new BException(BExceptionC.INTERNAL, "", e);
		}
		BJsonObject obj = (BJsonObject)bbuf.parseJsonValue();
		return obj;
	}
}
