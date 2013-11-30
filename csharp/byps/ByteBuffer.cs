/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace byps
{
    public class ByteBuffer
    {

        public static ByteBuffer wrap(byte[] bytes, int pos, int len)
        {
            return new ByteBuffer(bytes, pos, len);
        }

        public static ByteBuffer allocate(int cap)
        {
            return new ByteBuffer(cap);
        }

        public byte[] array()
        {
            return getMemoryStream().GetBuffer();
        }

        public int position()
        {
            return (int)getMemoryStream().Position;
        }

        public int remaining()
        {
            return (int)getMemoryStream().Length;
        }

        public void put(ByteBuffer buf)
        {
            wr.Write(buf.array(), buf.position(), buf.remaining());
        }

        public void put(byte[] buf)
        {
            wr.Write(buf, 0, buf.Length);
        }

        public void putLong(long v)
        {
            if (_order == ByteOrder.BIG_ENDIAN) v = swap(v);
            wr.Write(v);
        }

        public long getLong()
        {
            long v = rd.ReadInt64();
            if (_order == ByteOrder.BIG_ENDIAN) v = swap(v);
            return v;
        }

        private long swap(long v)
        {
            UInt64 v1 = (UInt64)v;
            UInt64 ret = (v1 & 0x00000000000000FFUL) << 56 | (v1 & 0x000000000000FF00UL) << 40 |
                   (v1 & 0x0000000000FF0000UL) << 24 | (v1 & 0x00000000FF000000UL) << 8 |
                   (v1 & 0x000000FF00000000UL) >> 8 | (v1 & 0x0000FF0000000000UL) >> 24 |
                   (v1 & 0x00FF000000000000UL) >> 40 | (v1 & 0xFF00000000000000UL) >> 56;
            return (long)ret;
        }

        public void putInt(int v)
        {
            if (_order == ByteOrder.BIG_ENDIAN) v = swap(v);
            wr.Write(v);
        }

        public int getInt()
        {
            int v = rd.ReadInt32();
            if (_order == ByteOrder.BIG_ENDIAN) v = swap(v);
            return v;
        }

        private int swap(int v)
        {
            UInt32 v1 = (UInt32)v;
            UInt32 ret = (v1 & 0x000000FF) << 24 | (v1 & 0x0000FF00) << 8 |
                    (v1 & 0x00FF0000) >> 8 | (v1 & 0xFF000000) >> 24;
            return (int)ret;
        }

        public void mark()
        {
            markPosition = getMemoryStream().Position;
        }

        public void reset()
        {
            getMemoryStream().Position = markPosition;
        }

        private MemoryStream getMemoryStream()
        {
            if (wr != null) return ((MemoryStream)wr.BaseStream);
            if (rd != null) return ((MemoryStream)rd.BaseStream);
            throw new InvalidOperationException("Either BinaryWriter or BinaryReader must be valid");
        }

        public void flip()
        {
            if (wr != null)
            {
                MemoryStream strm = (MemoryStream)wr.BaseStream;
                rd = new BinaryReader(strm);
            }

            MemoryStream rstrm = (MemoryStream)rd.BaseStream;
            long pos = rstrm.Position;
            rstrm.Position = 0;
            rstrm.SetLength(pos);
        }

        public ByteOrder order()
        {
            return _order;
        }

        public void order(ByteOrder byteOrder)
        {
            this._order = byteOrder;
        }

        private ByteBuffer(byte[] bytes, int pos, int len)
        {
            MemoryStream mstrm = new MemoryStream(bytes, pos, len, false, true);
            rd = new BinaryReader(mstrm, Encoding.Unicode);
        }

        private ByteBuffer(int cap)
        {
            MemoryStream mstrm = new MemoryStream(cap);
            wr = new BinaryWriter(mstrm, Encoding.Unicode);
        }

        internal void clear()
        {
            wr = new BinaryWriter(new MemoryStream(), Encoding.Unicode);
        }

        private ByteOrder _order = BitConverter.IsLittleEndian ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
        internal BinaryWriter wr;
        internal BinaryReader rd;
        private long markPosition = -1;


     }
}
