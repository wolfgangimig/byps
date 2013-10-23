package byps;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

import byps.BException;
import byps.BSerializer_12;
import byps.BSerializer_13;
import byps.BSerializer_14;
import byps.BSerializer_15;
import byps.BSerializer_20;
import byps.JSerializer_12;
import byps.JSerializer_13;
import byps.JSerializer_14;
import byps.JSerializer_15;
import byps.JSerializer_20;

public abstract class BRegistry {
	
	public final static int TYPEID_BOOL = 1;
	public final static int TYPEID_INT8 = 2;
	public final static int TYPEID_INT16 = 3;
	public final static int TYPEID_WCHAR = 4;
	public final static int TYPEID_INT32 = 5;
	public final static int TYPEID_INT64 = 6;
	public final static int TYPEID_FLOAT = 7;
	public final static int TYPEID_DOUBLE = 8;

	public final static int TYPEID_STRING = 10;
//	public final static int TYPEID_WSTRING = 11;// brauche ich wahrscheinlich nicht, weil das Übertragungsformat immer UTF-8 sein kann.

	public final static int TYPEID_LIST = 12;
	public final static int TYPEID_MAP = 13;
	public final static int TYPEID_SET = 14;
	public final static int TYPEID_STREAM = 15;
	public final static int TYPEID_STUB = 16;
	public final static int TYPEID_EXCEPTION = 20;
	public final static int TYPEID_OBJECT = 21;
	public final static int TYPEID_VALUECLASS = 22;
	public final static int TYPEID_PUBLISH_CLIENT = 23;
	public final static int TYPEID_HEADER = 30;
	
	public final static int TYPEID_VOID = 19;
	public final static int TYPEID_STRING_UTF16 = TYPEID_STRING;
	
	public final static int TYPEID_MIN_USER = 64;
	
	private ConcurrentHashMap<Class<?>, BSerializer> mapClassToSerializer = new ConcurrentHashMap<Class<?>, BSerializer>();
	private ConcurrentHashMap<Integer, BSerializer> mapTypeIdToSerializer = new ConcurrentHashMap<Integer, BSerializer>();
	public final BBinaryModel bmodel;
	
	public BRegistry(BBinaryModel bmodel) {
		this.bmodel = bmodel;
	}
	
	public int getMinTypeIdUser() {
		return TYPEID_MIN_USER;
	}
	
	public int getMaxTypeIdUser() {
		return getMaxTypeId();
	}
	
	public final int getMaxTypeId() {
		if (bmodel == BBinaryModel.JSON) return Integer.MAX_VALUE; 
		if (bmodel == BBinaryModel.MEDIUM) return Integer.MAX_VALUE;
//		if (bmodel == BBinaryModel.SMALL) return Short.MAX_VALUE;
//		if (bmodel == BBinaryModel.TINY) return Byte.MAX_VALUE; 
//		if (bmodel == BBinaryModel.LARGE) return Integer.MAX_VALUE;
		throw new IllegalStateException();
	}
	
	public BSerializer getSerializer(int typeId) throws BException {
		Integer typeId_o = typeId;
		BSerializer ser = mapTypeIdToSerializer.get(typeId_o);
		if (ser == null) {
			ser = getApiSerializer(typeId);
			if (ser == null) {
				ser = getBuiltInSerializer(typeId);
				if (ser == null) {
					throw new BException(BExceptionC.CORRUPT, "No serializer for typeId=" + typeId);
				}
			}
			mapTypeIdToSerializer.put(typeId_o, ser);
		}
		return ser;
	}

	public BSerializer getSerializer(Object obj, boolean throwEx) throws BException {
		Class<?> clazz = obj.getClass();
		BSerializer ser = mapClassToSerializer.get(clazz);
		if (ser != null) return ser;
		try {
			int typeId = 0;
		
			while (clazz != Object.class) {
				
				if (clazz == InputStream.class){
					typeId = BRegistry.TYPEID_STREAM;
					break;
				}
				
				try {
					Field field = clazz.getDeclaredField("serialVersionUID");
					field.setAccessible(true);
					long longTypeId = field.getLong(obj);
					typeId = (int)(longTypeId & getMaxTypeId());
					break;
				}
				catch (NoSuchFieldException e) {
					clazz = clazz.getSuperclass();
				}
			}
			
			ser = getSerializer(typeId);
			mapClassToSerializer.put(clazz, ser);
		} 
		catch (Exception e) {
			if (throwEx) {
				throw new BException(BExceptionC.CORRUPT, 
						"No serializer for className=" + clazz.getName() + ". " +
						"Only classes marked with BSerializable can be serialized as \"Object\" types. " + 
						"This error occurs e. g. if a List<Object> contains String values. String is not a BSerializable.");
			}
		}
		
		return ser;

		//		else if (obj instanceof BRemote) {
//			String stubName = makeStubName(clazz.getName());
//			try {
//				Class<?> stubClazz = Class.forName(stubName);
//				Field field = stubClazz.getDeclaredField("serialVersionUID");
//				field.setAccessible(true);
//				long longTypeId = field.getLong(null);
//				int typeId = (int)(longTypeId & maxTypeId);
//				ser = getSerializer(typeId);
//				mapClassToSerializer.put(clazz, ser);
//			} catch (Exception e) {
//				throw BException.createNoSerializer(clazz.getName(), e);
//			}
//		}

//		diese Funktion darf nur gerufen werden für objekte, die von BSerializable 
//		abgeleitet sind. Andere objekte dürfen nicht "annonym" exportiert werden.
//		für sie muss beim writeObject der BSerializer mit angegeben werden.
//		
//		Diese Einschränkung muss gmacht werden, weil aus der Klasseninfo von obj
//		keine Typ-Informationen zu den Generic-argumenten ermittelt werden können. Die
//		JavaVM gibt das nicht her. Beispielsweise kann man nicht herausfinden,
//		ob obj eine List<Integer> oder eine List<Long> ist.
//		
//		Die Funktion muss auch für Implementierungen von BRemote bzw. Subklassen von 
// 		BSkeleton funktionieren. Weil die BRemote nicht zugleich auch Serializable sind,
//		wird nur das Feld serialVersionUID gesucht und nciht etwa geprüft, ob das Objekt
//		die Schnittstelle Serializable implementiert - tut es ja nicht, wenn's ein BRemote ist.
		
		
	}
	
	protected abstract BSerializer getApiSerializer(int typeId) throws BException;

	private BSerializer getBuiltInSerializer(int typeId) throws BException {
		if (bmodel == BBinaryModel.JSON) {
			if (typeId == TYPEID_LIST) return JSerializer_12.instance;
			if (typeId == TYPEID_MAP) return new JSerializer_13();
			if (typeId == TYPEID_SET) return new JSerializer_14();
			if (typeId == TYPEID_EXCEPTION) return new JSerializer_20();
			if (typeId == TYPEID_STREAM) return new JSerializer_15();
		}
		else {
			if (typeId == TYPEID_LIST) return BSerializer_12.instance;
			if (typeId == TYPEID_MAP) return new BSerializer_13();
			if (typeId == TYPEID_SET) return new BSerializer_14();
			if (typeId == TYPEID_EXCEPTION) return new BSerializer_20();
			if (typeId == TYPEID_STREAM) return new BSerializer_15();
		}
		return null;
	}
		
	public boolean isStringTypeId(long typeId) {
		return typeId == TYPEID_STRING;
	}

	public boolean isPointerTypeId(long typeId) {
		if (typeId >= TYPEID_MIN_USER) return true;
	    if (typeId == TYPEID_OBJECT) return true;
	    if (typeId == TYPEID_HEADER) return true;
		if (typeId == TYPEID_EXCEPTION) return true;
		if (typeId == TYPEID_LIST) return true;
		if (typeId == TYPEID_MAP) return true;
		if (typeId == TYPEID_SET) return true;
		if (typeId == TYPEID_STREAM) return true;
		return false;
	}

	public void addSerializer(Class<?> clazz, BSerializer ser) throws BException {
		mapClassToSerializer.put(clazz, ser);
		mapTypeIdToSerializer.put(ser.typeId, ser);
	}
	
	public void addSerializer(BSerializer ser) throws BException {
		mapClassToSerializer.put(ser.read(null, null, 0).getClass(), ser);
		mapTypeIdToSerializer.put(ser.typeId, ser);
	}

}
