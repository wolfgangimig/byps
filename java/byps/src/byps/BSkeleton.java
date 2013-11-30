package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import byps.BRemote;
import byps.BTargetId;

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
