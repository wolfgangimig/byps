using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace com.wilutions.byps
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
            this.idMap = transport.apiDesc.uniqueObjects ? null : new Dictionary<int, Object>();
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
