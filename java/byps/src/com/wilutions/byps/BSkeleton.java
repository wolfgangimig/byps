package com.wilutions.byps;

public class BSkeleton implements BRemote {
  
  private BTargetId targetId;

	@Override
	public BTargetId BRemote_getTargetId() {
		return targetId;
	}

	void BSkeleton_setTargetId(BTargetId targetId) {
	  this.targetId = targetId;
	}
	
}
