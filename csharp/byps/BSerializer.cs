using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
{
    public abstract class BSerializer
    {
        public BSerializer(int typeId, bool inlineInstance)
        {
            this.typeId = typeId;
            this.inlineInstance = inlineInstance;
        }

        public BSerializer(int typeId)
        {
            this.typeId = typeId;
            this.inlineInstance = false;
        }

        public virtual int size(Object obj1, BBinaryModel bmodel)
        {
            return 0;
        }

        public virtual void write(Object obj1, BOutput bout1, int version)
        {
        }

        public abstract Object read(Object obj1, BInput bin1, int version);

        internal readonly int typeId;
        internal readonly bool inlineInstance;
    }
}
