package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
  // public final static int TYPEID_WSTRING = 11; unused, Strings are always transported as UTF-8

  public final static int TYPEID_LIST = 12;
  public final static int TYPEID_MAP = 13;
  public final static int TYPEID_SET = 14;
  public final static int TYPEID_STREAM = 15;
  public final static int TYPEID_STUB = 16;
  public final static int TYPEID_DATE = 17;
  public final static int TYPEID_VOID = 19;
  public final static int TYPEID_EXCEPTION = 20;
  public final static int TYPEID_OBJECT = 21;
  public final static int TYPEID_VALUECLASS = 22;
  public final static int TYPEID_PUBLISH_CLIENT = 23;
  public final static int TYPEID_HTTP_REQUEST = 24; // Used by bypshttp-shmem
  public final static int TYPEID_HEADER = 30;

  public final static int TYPEID_STRING_UTF16 = TYPEID_STRING;

  public final static int TYPEID_MIN_USER = 64;

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
    throw new IllegalStateException();
  }

  protected Map<Integer, BRegisteredSerializer> serializerCacheUseGetSerializerCache;
  
  private Map<Integer, BRegisteredSerializer> getSerializerCache() {
    
    Map<Integer, BRegisteredSerializer> serializerCache = this.serializerCacheUseGetSerializerCache;
    if (serializerCache == null) {
      
      serializerCache = new HashMap<Integer, BRegisteredSerializer>();
      
      BSerializer[] builtInSerializers = bmodel == BBinaryModel.JSON ? builtInJsonSerializers : builtInBinarySerializers; 
      for (BSerializer ser : builtInSerializers) {
        serializerCache.put(ser.typeId, new BRegisteredSerializer(ser)); 
      }
      
      BRegisteredSerializer[] ssers = getSortedSerializers();
      for (BRegisteredSerializer sser : ssers) {
        serializerCache.put(sser.typeId, sser);
      }
      
      this.serializerCacheUseGetSerializerCache = serializerCache;
    }
    
    return serializerCache;
  }
  
  private static final BSerializer[] builtInJsonSerializers = new BSerializer[] {
    JSerializer_12.instance, JSerializer_13.instance, JSerializer_14.instance, JSerializer_15.instance, JSerializer_20.instance, JSerializer_22.instance
  };
    
  private static final BSerializer[] builtInBinarySerializers = new BSerializer[] {
    BSerializer_12.instance, BSerializer_13.instance, BSerializer_14.instance, BSerializer_15.instance, BSerializer_20.instance, BSerializer_22.instance
  };
    

  protected BSerializer internalGetSerializer(int typeId) throws BException {
    BSerializer ser = null;

    BRegisteredSerializer rser = getSerializerCache().get(typeId);
    if (rser != null) {
      ser = rser.instance;
      if (ser == null) {
        Class<?> c;
        try {
          c = Class.forName(rser.name);
          ser = rser.instance = (BSerializer) c.newInstance();
        } catch (Exception e) {
          throw new BException(BExceptionC.CORRUPT, "No serializer for typeId=" + typeId);
        }
      }
    }
    
    return ser;
  }
  
  public BSerializer getSerializer(int typeId) throws BException {
    BSerializer ser = internalGetSerializer(typeId);
    if (ser != null) return ser;
    throw new BException(BExceptionC.CORRUPT, "No serializer for typeId=" + typeId);
  }
  
  public BSerializer getSerializer(Object obj, boolean throwEx) throws BException {
    Class<?> clazz = obj.getClass();
    BSerializer ser = null;
    try {
      int typeId = 0;

      while (clazz != Object.class) {

        if (clazz == InputStream.class) {
          typeId = BRegistry.TYPEID_STREAM;
          break;
        }

        try {
          Field field = clazz.getDeclaredField("serialVersionUID");
          field.setAccessible(true);
          long longTypeId = field.getLong(obj);
          typeId = (int) (longTypeId & getMaxTypeId());
          break;
        } catch (NoSuchFieldException e) {
          clazz = clazz.getSuperclass();
        }
      }

      ser = getSerializer(typeId);
    } catch (Exception e) {
      if (throwEx) {
        throw new BException(BExceptionC.CORRUPT, "No serializer for className=" + clazz.getName() + ". " + "Only classes marked with BSerializable can be serialized as \"Object\" types. "
            + "This error occurs e. g. if a List<Object> contains String values. String is not a BSerializable.");
      }
    }

    return ser;
  }

  protected static class BRegisteredSerializer {
    public int typeId;
    public String name;
    public BSerializer instance;

    public BRegisteredSerializer(int typeId, String name) {
      this.typeId = typeId;
      this.name = name;
    }

    public BRegisteredSerializer(BSerializer instance) {
      this.typeId = instance.typeId;
      this.name = instance.getClass().getName();
      this.instance = instance;
    }
    
    public String toString() {
      return name;
    }
  }

  protected abstract BRegisteredSerializer[] getSortedSerializers();

  public boolean isPointerTypeId(long typeId) {
    if (typeId >= TYPEID_MIN_USER) return true;
    if (typeId == TYPEID_OBJECT) return true;
    if (typeId == TYPEID_HEADER) return true;
    if (typeId == TYPEID_EXCEPTION) return true;
    if (typeId == TYPEID_LIST) return true;
    if (typeId == TYPEID_MAP) return true;
    if (typeId == TYPEID_SET) return true;
    if (typeId == TYPEID_STREAM) return true;
    if (typeId == TYPEID_HTTP_REQUEST) return true;
    return false;
  }

  public void replaceSerializer(BSerializer bser) {
    getSerializerCache().put(bser.typeId, new BRegisteredSerializer(bser));
  }
  
}
