/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BSkeleton : BRemote
    {
	    private BTargetId targetId;
	
	    public BTargetId BRemote_getTargetId() {
            return targetId;
	    }

	    public void BSkeleton_setTargetId(BTargetId targetId) {
            this.targetId = targetId;
	    }


    }
}
