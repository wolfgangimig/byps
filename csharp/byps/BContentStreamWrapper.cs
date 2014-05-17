/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace byps
{
    public class BContentStreamWrapper : BContentStream
    {
        private Stream innerStream;

        public BContentStreamWrapper()
            : this(null, "", -1L)
        {
        }

        public BContentStreamWrapper(Stream innerStream)
            : this(innerStream, "", -1, 0)
        {
        }

        public BContentStreamWrapper(Stream innerStream, String contentType, long contentLength)
            : this(innerStream, contentType, contentLength, 0)
        {
        }

        public BContentStreamWrapper(Stream innerStream, String contentType, long contentLength, long reserved)
            : base(contentType, contentLength)
        {
            this.innerStream = innerStream;
        }

        public BContentStreamWrapper(BContentStream innerStream, long reserved)
            : base(innerStream, 0)
        {
            this.innerStream = innerStream;
        }

        public BContentStreamWrapper(FileInfo file)
            : this(file.OpenRead(), getContentTypeFromRegistry(file), file.Length)
        {
            this.fileNameVal = file.Name;
        }

        public BContentStreamWrapper(MemoryStream innerStream, String contentType)
            : this(innerStream, contentType, innerStream.Length, 0)
        {
        }

        private static String getContentTypeFromRegistry(FileInfo file)
        {
            String mime = DEFAULT_CONTENT_TYPE;
            Microsoft.Win32.RegistryKey regKey = null;

            try
            {
                String ext = file.Extension;
                if (!(string.IsNullOrEmpty(ext) || string.IsNullOrWhiteSpace(ext)))
                {
                    regKey = Microsoft.Win32.Registry.ClassesRoot.OpenSubKey(ext);
                    if (regKey != null)
                    {
                        object val = regKey.GetValue("Content Type");
                        if (val != null)
                        {
                            string strval = val.ToString();
                            if (!(string.IsNullOrEmpty(strval) || string.IsNullOrWhiteSpace(strval)))
                            {
                                mime = strval;
                            }
                        }
                    }
                }

            }
            catch (Exception)
            {
            }
            finally
            {
                if (regKey != null)
                {
                    regKey.Close();
                }
            }
            return mime;
        }

        protected virtual Stream openStream()
        {
            throw new NotImplementedException();
        }

        protected Stream ensureStream()
        {
            if (innerStream != null) return innerStream;

            lock (this)
            {
                if (innerStream == null)
                {
                    innerStream = openStream();
                    if (innerStream is BContentStream)
                    {
                        BContentStream bstrm = (BContentStream)innerStream;
                        this.copyProperties(bstrm);
                    }
                }
            }

            return innerStream;
        }

        public override void ensureProperties()
        {
            ensureStream();
        }


        public override int Read(byte[] buffer, int offset, int count)
        {
            return ensureStream().Read(buffer, offset, count);
        }

        public override void Close()
        {
            ensureStream().Close();
        }

        public override bool CanRead
        {
            get { return ensureStream().CanRead; }
        }

        public override bool CanSeek
        {
            get { return ensureStream().CanSeek; }
        }

        public override bool CanWrite
        {
            get { return ensureStream().CanWrite; }
        }

        public override void Flush()
        {
            ensureStream().Flush();
        }

        public override long Length
        {
            get { return ensureStream().Length; }
        }

        public override long Position
        {
            get
            {
                return ensureStream().Position;
            }
            set
            {
                ensureStream().Position = value;
            }
        }

        public override long Seek(long offset, SeekOrigin origin)
        {
            return ensureStream().Seek(offset, origin);
        }

        public override void SetLength(long value)
        {
            ensureStream().SetLength(value);
        }

        public override void Write(byte[] buffer, int offset, int count)
        {
            ensureStream().Write(buffer, offset, count);
        }

    }
}
