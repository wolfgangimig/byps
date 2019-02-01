package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.Serializable;
import java.lang.ref.WeakReference;

public class BValueClass implements Serializable {
  
  protected long changedMembers;
  
  protected transient int flags; 
  
  protected final static int FLAG_SEALED = 1;
	
  /**
   * This reference can be used for arbitrary purposes. 
   */
	protected transient Object dbHelper;
	
	/**
	 * Deserialisation on the client-side stores the BClient object in this member.
	 * This reference can be used for deferred loading of elements.
	 * It is defined as a weak reference, because we do not want to cause this
	 * relation to keep a BClient object in memory. If a BClient is not reachable
	 * by a strong reference anymore, it is most unlikely that any lazy loaded 
	 * element is of further interest. However, as long as there is somewhere in the program
	 * a strong reference to the BClient, the weak reference is not released.
	 */
	protected transient WeakReference<BClient> bypsClient;
	
	public long getChangedMembers() {
		return changedMembers;
	}
	
	public void setChangedMembers(long v) {
	  if (isSealed()) {
	    throw new IllegalStateException("Sealed object cannot be modified.");
	  }
		changedMembers = v;
	}
	
	public boolean isChangedMember(long v) {
		return (changedMembers & v) != 0;
	}
	
	public void setChangedMember(long v) {
    if (isSealed()) {
      throw new IllegalStateException("Sealed object cannot be modified.");
    }
		changedMembers |= v;
	}
	
	/**
	 * Check whether this object is invariant.
	 * @return
	 */
	public boolean isSealed() {
	  return (flags & FLAG_SEALED) != 0;
	}
	
	/**
	 * Set object as invariant.
	 * Subsequent calls of {@link #setChangedMember(long)} or {@link #setChangedMembers(long)} will
	 * throw an IllegalStateException.
	 * @param obj Object 
	 */
	public static <T extends BValueClass> T seal(T obj) {
	  obj.flags |= FLAG_SEALED; 
	  return obj;
	}
	
	/**
	 * Set all objects in the given array as invariant.
	 * @param arr Array
	 */
  public static <T extends BValueClass> T[] seal(T[] arr) {
    for (T obj : arr) BValueClass.seal(obj);
    return arr;
  }

	
  public Object getDbHelper() {
    return dbHelper;
  }

  public void setDbHelper(Object dbHelper) {
    this.dbHelper = dbHelper;
  }
  
  public WeakReference<BClient> getBypsClient() {
    return bypsClient;
  }

  public void setBypsClient(WeakReference<BClient> bypsClient) {
    this.bypsClient = bypsClient;
  }
  
  private static final long serialVersionUID = 22;

}
