using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public abstract class BBuffer
    {
        public static BBuffer create(BBinaryModel bmodel, ByteBuffer buf)
        {
            if (bmodel == BBinaryModel.MEDIUM)
            {
                return new BBufferBin(bmodel, buf);
            }
            throw new InvalidOperationException();
        }

        public abstract ByteBuffer getBuffer();
        public abstract void clear();
    }
}
