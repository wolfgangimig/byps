/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Text;

namespace byps
{
    public class BApiDescriptor
    {
	    public readonly String name;
	    public readonly String basePackage;
	    public readonly long version;
	    public readonly bool uniqueObjects;

        protected Dictionary<BBinaryModel, BRegistry> registries = new Dictionary<BBinaryModel,BRegistry>();
	
	    public BApiDescriptor( 
			    String name, String apiPack,
                long version,
			    bool uniqueObjects
			    ) {
		    this.name = name;
		    this.basePackage = apiPack;
		    this.version = version;
		    this.uniqueObjects = uniqueObjects;
	    }

        public BApiDescriptor addRegistry(BRegistry registry)
        {
            registries[registry.bmodel] = registry;
            return this;
        }

        public BRegistry getRegistry(BBinaryModel bmodel)
        {
            BRegistry ret = null;
            if (!registries.TryGetValue(bmodel, out ret))
            {
                throw new InvalidOperationException("No registry for protocol=" + bmodel);
            }
            return ret;
        }

        public String getProtocolIds()
        {
            StringBuilder sbuf = new StringBuilder();
            foreach (BBinaryModel p in registries.Keys)
            {
                sbuf.Append(p.ToString());
            }
            return sbuf.ToString();
        }
	
	    public override string ToString() {
		    StringBuilder sbuf = new StringBuilder();
		    sbuf.Append("[name=").Append(name).Append(",package=").Append(basePackage);
            sbuf.Append(",version=").Append(version);
		    sbuf.Append(",uniqueObjects=").Append(uniqueObjects);
		    sbuf.Append("]");
		    return sbuf.ToString();
	    }

    }
}
