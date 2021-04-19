package byps.http.rest;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BTargetId;
import byps.BTransport;
import byps.BWire;
import byps.rest.BStreamReference;

/**
 * Transform an object before it is serialized via Gson.
 * 
 * An InputStream object is replaced by a BStreamReference object to provide a download URL in the JSON data.
 * Furthermore the InputStream is added to the HActiveMessages.  
 *
 */
public class TransformObjectBeforeSerialization {
  
  /**
   * Executor with BYPS Session used to provide streams for download.  
   */
  private HRestExecutor executor;
  
  /**
   * Already visited objects.
   * Helps to avoid endless loop in recursion.
   */
  private Set<Key> visitedObjects = new HashSet<>();
  
  /**
   * Fields of this names do not required transformation.
   */
  private Set<String> skipFields = new HashSet<>();

  /**
   * Transform the given object before it is serialized with Gson.
   * 
   * This function replaces InputStream objects with BStreamReference objects.
   * 
   * @param object Object  
   */
  protected void transformObject(Object object) {
    transformFields(object);
  }

  /**
   * Constructor.
   * @param executor HRestExecutor
   * @param skipFields Fields of this names do not require trafo
   */
  public TransformObjectBeforeSerialization(HRestExecutor executor, Set<String> skipFields) {
    this.executor = executor;
    this.skipFields = skipFields;
  }

  /**
   * Transform fields of the given object.
   * @param object Object
   */
  protected void transformFields(Object object) {
    if (visit(object)) {
      Class<?> objectClass = object.getClass();
      
      if (objectClass.isArray()) {
        int length = Array.getLength(object);
        for (int i = 0; i < length; i++) {
          Object elm = Array.get(object, i);
          if (isTransformField(elm)) {
            transformFields(elm);
          }
        }
      }
      else {
        while (objectClass != Object.class) {
          Field[] fields = objectClass.getDeclaredFields();
          for (Field field : fields) {
            transformField(object, field);
          }
          objectClass = objectClass.getSuperclass();
        }
      }
    }
  }
  
  /**
   * Transform one field.
   * @param object
   * @param field
   */
  protected void transformField(Object object, Field field) {
    try {
      
      // final, static, transient fields are skipped.
      int modifiers = field.getModifiers();
      if ((modifiers & (Modifier.FINAL|Modifier.TRANSIENT|Modifier.STATIC)) != 0) return;
      
      // Field name to exclude?
      if (skipFields.contains(field.getName())) return;
        
      // Get field value.
      field.setAccessible(true);
      Object fieldObject = field.get(object);
      if (isTransformField(fieldObject)) {
        
        // transform InputStream or go to the field's fields
        Class<?> fieldClass = fieldObject.getClass();
        if (InputStream.class.isAssignableFrom(fieldClass)) {
          transformInputStream(object, (InputStream)fieldObject, field);
        }
        else {
          transformFields(fieldObject);
        }
      }
      
    }
    catch (IllegalArgumentException | IllegalAccessException e) {
      throw new IllegalStateException(e);
    }
  }
  
  /**
   * Transform an InputStream field.
   * @param object Object with InputStream field
   * @param istream Field value
   * @param field Field access 
   * @throws IllegalArgumentException
   * @throws IllegalAccessException
   */
  protected void transformInputStream(Object object, InputStream istream, Field field) throws IllegalArgumentException, IllegalAccessException {

    // Provide the stream as BContentStream
    BContentStream bstream = null;
    if (istream instanceof BContentStream) {
      bstream = (BContentStream)istream;
    }
    else {
      bstream = new BContentStreamWrapper(istream);
    }
    
    BTransport transport = executor.getSession().getServer().getTransport();
    BWire wire = transport.getWire();

    // Create a BTargetId to be able to manage the stream in HActiveMessages
    int serverId = transport.getConnectedServerId();
    long messageId = 0;
    long streamId = transport.getWire().makeMessageId();
    BTargetId targetId = new BTargetId(serverId, messageId, streamId);
    bstream.setTargetId(targetId);
    
    // Add the stream to the outgoing streams in HActiveMessages
    long trackingId = streamId;
    wire.putStreams(trackingId, Arrays.asList(bstream), null);
    
    // URL to download the content.
    String url = "getstream?serverid=" + serverId + "&messageid=" + messageId + "&streamid=" + streamId;
    BStreamReference bstreamRef = new BStreamReference();
    bstreamRef.setUrl(url);
    
    // Replace the field value by the reference.
    field.set(object, bstreamRef);
  }

  /**
   * Wraps an object to overload hashCode and equals.
   * 
   *
   */
  protected static class Key {
    private Object object;
    
    Key(Object object) {
      this.object = object;
    }
    
    @Override
    public int hashCode() {
      return System.identityHashCode(object);
    }
    
    @Override
    public boolean equals(Object rhs) {
      return this.object == ((Key)rhs).object;
    }
  }
  
  /**
   * Check whether object should be transformed.
   * @param object Object 
   * @return true, if object has not already been transformed.
   */
  protected boolean visit(Object object) {
    if (object == null) return false;
    if (!(object instanceof Serializable)) return false;
    Key key = new Key(object);
    boolean ret = visitedObjects.contains(key);
    if (!ret) {
      visitedObjects.add(key);
    }
    return !ret;
  }
  
  /**
   * Test whether the given field value might have to be transformed.
   * @param fieldObject value
   * @return true, if might have to be transformed
   */
  protected boolean isTransformField(Object fieldObject) {
    if (fieldObject == null) return false;
    Class<?> clazz = fieldObject.getClass();
    if (clazz.isPrimitive()) return false;
    if (Number.class.isAssignableFrom(clazz)) return false;
    if (Boolean.class == clazz || String.class == clazz || Date.class == clazz) return false;
    return true;
  }

}