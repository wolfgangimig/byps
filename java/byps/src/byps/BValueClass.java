package byps;

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
	
  public Object getDBHelper() {
    return dbHelper;
  }

  public void setDBHelper(Object dbHelper) {
    this.dbHelper = dbHelper;
  }

  private static final long serialVersionUID = 22;

	
}
