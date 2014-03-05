package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.Serializable;

public class BValueClass implements Serializable {
	
  protected long changedMembers;
	
	protected transient Object dbHelper;
	
	public long getChangedMembers() {
		return changedMembers;
	}
	
	public void setChangedMembers(long v) {
		changedMembers = v;
	}
	
	public boolean isChangedMember(long v) {
		return (changedMembers & v) != 0;
	}
	
	public void setChangedMember(long v) {
		changedMembers |= v;
	}
	
  public Object getDbHelper() {
    return dbHelper;
  }

  public void setDbHelper(Object dbHelper) {
    this.dbHelper = dbHelper;
  }

  private static final long serialVersionUID = 22;

	
}
