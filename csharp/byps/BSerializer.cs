/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
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

        public virtual void write(Object obj1, BOutput bout1, long version)
        {
        }

        public abstract Object read(Object obj1, BInput bin1, long version);

        public readonly int typeId;
        public readonly bool inlineInstance;
    }
}
