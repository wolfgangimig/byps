/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace byps
{
    public class BOutputS : BOutputBin
    {
 
        public BOutputS(BTransport transport, int negotiatedBypsVersion, long negotiatedVersion, ByteOrder negotiatedByteOrder)
            : base(transport, BMessageHeader.MAGIC_BINARY_STREAM, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder)
        {
        }

        public BOutputS(BTransport transport, BMessageHeader requestHeader)
            : base(transport, requestHeader)
        {
        }

        protected override void storeObj(object obj)
        {
            writeObj(obj, false, null);
        }

        public override void writeObj(object obj, bool isUnique, BSerializer ser)
        {
            if (ser != null && ser.inlineInstance)
            {

                // Inline objects must not be null
                if (obj == null)
                {
                    obj = ser.read(null, null, 0);
                }

                ser.write(obj, this, header.version);
                return;
            }

            if (obj != null)
            {

                BObjMap objMap = isUnique ? null : this.objMap;

                int id_o = objMap != null ? objMap.get(obj) : 0;
                if (id_o != 0)
                {
                    bbuf.putPointer(-id_o);
                }
                else
                {
                    id_o = ++nextObjId;

                    bbuf.putPointer(nextObjId);

                    if (objMap != null) objMap.put(obj, id_o);

                    if (ser == null)
                    {
                        ser = registry.getSerializer(obj, true);
                    }

                    bbuf.putTypeId(ser.typeId);

                    ser.write(obj, this, header.version);
                }
            }
            else
            {
                // NULL-Referenz
                bbuf.putPointer(0);
            }
        }

        private int nextObjId;
    }
}
