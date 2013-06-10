package com.wilutions.byps;

import java.io.Serializable;

public class BValueClass implements Serializable {
	
	protected long changedMembers;
	
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
	
	private static final long serialVersionUID = 1L;
}
