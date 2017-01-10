package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.Serializable;

public class BValueClass implements Serializable {
  
  protected long changedMembers;
  
  protected transient int flags; 
  
  protected final static int FLAG_SEALED = 1;
	
	protected transient Object dbHelper;
	
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
	
  public Object getDbHelper() {
    return dbHelper;
  }

  public void setDbHelper(Object dbHelper) {
    this.dbHelper = dbHelper;
  }

  private static final long serialVersionUID = 22;

	
}
