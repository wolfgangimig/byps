using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace com.wilutions.byps
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
            buf.wr.Write(c);
        }

        public void putShort(short v)
        {
            buf.wr.Write(v);
        }

        public void putInt(int v)
        {
            buf.wr.Write(v);
        }

        public void putLong(long v)
        {
            buf.wr.Write(v);
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
            }
            else
            {
                putInt(0);
            }
            putByte(0);
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
            return buf.rd.ReadChar();
        }

        public short getShort()
        {
            return buf.rd.ReadInt16();
        }

        public int getInt()
        {
            return buf.rd.ReadInt32();
        }

        public long getLong()
        {
            return buf.rd.ReadInt64();
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
            int len = buf.rd.ReadInt32();
            if (len != 0)
            {
                if (strhlp == null || strhlp.Length < len)
                {
                    strhlp = new byte[len];
                }
                buf.rd.Read(strhlp, 0, len);
                s = Encoding.UTF8.GetString(strhlp, 0, len);
            }
            buf.rd.ReadByte();
            return s;
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

        protected readonly BBinaryModel bmodel;
        protected ByteBuffer buf;
        protected byte[] strhlp;



 
    }
}
