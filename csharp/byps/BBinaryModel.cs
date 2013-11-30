/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BBinaryModel
    {

        public override string ToString()
        {
            return "MEDIUM";
        }

        public String getProtocolId()
        {
            return "S";
        }

        public int computeArrayWireSize(int elmSize, int length)
        {
            int ret = length * elmSize;
            return ret;
        }

        protected BBinaryModel(int pointerSize, int typeIdSize, int lengthSize, int packing)
        {
            this.pointerSize = pointerSize;
            this.typeIdSize = typeIdSize;
            this.lengthSize = lengthSize;
            this.packing = packing;
        }


        public readonly int pointerSize;
        public readonly int typeIdSize;
        public readonly int lengthSize;
        public readonly int packing;
        public readonly static BBinaryModel MEDIUM = new BBinaryModel(4, 4, 4, 8);


    }
}
