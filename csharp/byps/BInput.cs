/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public abstract class BInput
    {
 	    public readonly BMessageHeader header;
	    public readonly BTransport transport;
	    public readonly BRegistry registry;

        public BInput(BTransport transport, BMessageHeader responseHeader, BRegistry registry)
        {
            this.header = responseHeader;
		    this.transport = transport;
		    this.registry = registry;
            this.idMap = transport.getApiDesc().uniqueObjects ? null : new Dictionary<int, Object>();
        }

        public Object onObjectCreated(Object obj)
        {
            if (currentId != 0)
            {
                idMap[currentId] = obj;
            }
            return obj;
        }

        protected Dictionary<int, Object> idMap;
        protected int currentId;

        public abstract Object load();
    }
}
