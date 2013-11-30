using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class BBufferBin : BBuffer
    {
        public void putBoolean(bool v)
        {
            putByte((byte)(v ? 1 : 0));
        }

        public void putByte(byte v)
        {
            buf.wr.Write(v);
        }

        public void putChar(char c)
        {
            putShort((short)c);
        }

        public void putShort(short v)
        {
            buf.wr.Write(v);
        }

         public void putInt(int v)
        {
            if (compressInteger)
            {
                putLongCompressed(v);
            }
            else
            {
                buf.wr.Write(v);
            }
        }

        private void putLongCompressed(long v)
        {
            if (v == 0)
            {
                buf.wr.Write((byte)0);
            }
            else
            {
                bool neg = v < 0;
                if (neg) v = -(v + 1);
                v <<= 1;
                if (neg) v |= 1;

                int i = 0;
                for (; i < 10 && v != 0; i++)
                {
                    bool moreBytes = (v & ~0x7F) != 0;
                    int h = ((int)v) & 0x7F;
                    if (moreBytes) h |= 0x80;
                    helpBufferInt[i] = (byte)h;
                    v = (long)((ulong)v >> 7);
                }

                buf.wr.Write(helpBufferInt, 0, i);
            }

        }

        private long getLongCompressed()
        {
            long v = 0;

            int i = 0;
            int shift = 0;
            bool moreBytes = true;
            for (; i < 10 && moreBytes; i++)
            {
                int h = buf.rd.ReadByte();
                moreBytes = (h & 0x80) != 0;
                v |= ((long)(h & 0x7F)) << shift;
                shift += 7;
            }

            if (moreBytes)
            {
                throw new BException(BExceptionC.CORRUPT, "Read integer failed.");
            }

            bool neg = (v & 0x01) != 0;
            v = (long)((ulong)v >> 1);
      
            if (neg) v = -(v+1);
    
            return v;
        }

        public void putLong(long v)
        {
            if (compressInteger)
            {
                putLongCompressed(v);
            }
            else
            {
                buf.wr.Write(v);
            }
        }

        public void putFloat(float v)
        {
            buf.wr.Write(v);
        }

        public void putDouble(double v)
        {
            buf.wr.Write(v);
        }

        public void putString(string v)
        {
            if (v != null && v.Length != 0)
            {
                int max = Encoding.UTF8.GetMaxByteCount(v.Length);
                if (strhlp == null || strhlp.Length < max)
                {
                    strhlp = new byte[max];
                }

                int len = Encoding.UTF8.GetBytes(v, 0, v.Length, strhlp, 0);
                putInt(len);
                buf.wr.Write(strhlp, 0, len);
                putByte(0);
           }
            else
            {
                 putInt(0);
                 putByte(0);
            }
         }

        public void putArrayByte(byte[] arr)
        {
            buf.wr.Write(arr);
        }

        public bool getBoolean()
        {
            return buf.rd.ReadByte() != 0;
        }

        public byte getByte()
        {
            return buf.rd.ReadByte();
        }

        public char getChar()
        {
            return (char)getShort();
        }

        public short getShort()
        {
            return buf.rd.ReadInt16();
        }

        public int getInt()
        {
            if (compressInteger)
            {
                return (int)getLongCompressed();
            }
            else
            {
                return buf.rd.ReadInt32();
            }
        }

 
        public long getLong()
        {
            if (compressInteger)
            {
                return getLongCompressed();
            }
            else
            {
                return buf.rd.ReadInt64();
            }
        }

        public float getFloat()
        {
            return buf.rd.ReadSingle();
        }

        public double getDouble()
        {
            return buf.rd.ReadDouble();
        }

        public String getString()
        {
            String s = "";
            int len = getInt();
            if (len != 0)
            {
                if (strhlp == null || strhlp.Length < len)
                {
                    strhlp = new byte[len];
                }
                buf.rd.Read(strhlp, 0, len);
                s = Encoding.UTF8.GetString(strhlp, 0, len);
            }
            getByte();
            return s;
        }

        public DateTime getDate()
        {
            short _year = getShort();
            short _mmdd = getShort();
            short _hhmm = getShort();
            short _ssuu = getShort();

            int year = _year;
            int month = (_mmdd >> 8) & 0xFF;/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

            int day = _mmdd & 0xFF;
            int hour = (_hhmm >> 8) & 0xFF;
            int minute = _hhmm & 0xFF;
            int second = ((int)_ssuu >> 10) & 0x3F;
            int millis = _ssuu & 0x3FF;

            DateTime date = new DateTime(year, month, day, hour, minute, second, millis);
            return date;
        }

        public void putDate(DateTime v)
        {
            int year = v.Year;
            int month = v.Month;
            int day = v.Day;
            int hour = v.Hour;
            int minute = v.Minute;
            int second = v.Second;
            int millis = v.Millisecond;

            short _year = (short)year;
            short _mmdd = (short)((month << 8) | day);
            short _hhmm = (short)((hour << 8) | minute);
            short _ssuu = (short)((second << 10) | millis);

            putShort(_year);
            putShort(_mmdd);
            putShort(_hhmm);
            putShort(_ssuu);
        }

        public void getArrayByte(byte[] arr)
        {
            buf.rd.Read(arr, 0, arr.Length);
        }

        public override ByteBuffer getBuffer()
        {
            return buf;
        }

        public override void clear()
        {
            buf.clear();
        }

        public void putPointer(int v)
        {
            this.putInt(v);
        }

        public void putTypeId(int v)
        {
            this.putInt(v);
        }

        public void putLength(int v)
        {
            this.putInt(v);
        }

        public int getPointer()
        {
            return getInt();
        }

        public int getTypeId()
        {
            return getInt();
        }

        public int getLength()
        {
            return getInt();
        }

        public int position()
        {
            return buf.position();
        }

        internal BBufferBin(BBinaryModel bmodel, ByteBuffer buf)
        {
            this.bmodel = bmodel;
            this.buf = buf != null ? buf : ByteBuffer.allocate(10 * 1000);
        }

        public bool setCompressInteger(bool v)
        {
            bool ret = compressInteger;
            compressInteger = v;
            return ret;
        }

        public bool isCompressInteger()
        {
            return compressInteger;
        }

        protected readonly BBinaryModel bmodel;
        protected ByteBuffer buf;
        protected byte[] strhlp;
        protected byte[] helpBufferInt = new byte[10];
        protected bool compressInteger = true;







    }
}
