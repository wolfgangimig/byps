/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Net;

namespace byps
{
    public abstract class BContentStream : Stream
    {
        public readonly static String DEFAULT_CONTENT_TYPE = "application/octet-stream";
        public readonly static int ATTACHMENT = 1;
        public readonly static int INLINE = 2;

        protected String contentTypeVal;
        protected long contentLengthVal;
        protected String fileNameVal;
        protected int attachmentCodeVal;
        protected BTargetId targetIdVal = BTargetId.ZERO;

        public BContentStream(String contentType, long contentLength)
        {
            this.contentTypeVal = contentType;
            this.contentLengthVal = contentLength;
        }

        public BContentStream()
        {
            this.contentTypeVal = DEFAULT_CONTENT_TYPE;
            this.contentLengthVal = -1L;
        }

        public BContentStream(BContentStream rhs, long lifetimeMillis)
        {
            copyProperties(rhs);
        }

        public virtual String ContentType
        {
            get
            {
                return contentTypeVal != null ? contentTypeVal : "";
            }
            set
            {
                contentTypeVal = value;
            }
        }

        public virtual long ContentLength
        {
            get
            {
                return contentLengthVal;
            }
            set
            {
                contentLengthVal = value;
            }
        }

        public virtual String FileName
        {
            get
            {
                return fileNameVal != null ? fileNameVal : "";
            }
            set
            {
                fileNameVal = value;
            }
        }

        public virtual int AttachmentCode
        {
            get
            {
                return attachmentCodeVal;
            }
            set
            {
                attachmentCodeVal = value;
            }
        }

        public virtual BTargetId TargetId
        {
            get
            {
                return targetIdVal;
            }
            set
            {
                targetIdVal = value;
            }
        }

        private String encodeUrl(String s, String charset)
        {
            String r = "";
            if (charset == "UTF-8")
            {
                r = WebUtility.UrlEncode(s);
            }
            else
            {
                byte[] buf = System.Text.Encoding.ASCII.GetBytes(s);
                byte[] bufE = WebUtility.UrlEncodeToBytes(buf, 0, buf.Length);
                r = System.Text.Encoding.ASCII.GetString(bufE, 0, bufE.Length);
            }
            r = r.Replace("+", "%20");
            return r;
        }

        private String decodeUrl(String s, String charset)
        {
            String r = "";
            if (charset == "UTF-8" || charset == "utf-8")
            {
                r = WebUtility.UrlDecode(s);
            }
            else
            {
                byte[] buf = System.Text.Encoding.ASCII.GetBytes(s);
                byte[] bufE = WebUtility.UrlDecodeToBytes(buf, 0, buf.Length);
                r = System.Text.Encoding.ASCII.GetString(bufE, 0, bufE.Length);
            }
            return r;
        }

        public virtual String ContentDisposition
        {
            get
            {
                StringBuilder sbuf = new StringBuilder();
                sbuf.Append( AttachmentCode == ATTACHMENT ? "attachment;" : "inline;" );
                String fileName = FileName;
                if (fileName != null && fileName.Length != 0) {
                    sbuf.Append(" filename=");
                    String fileNameA = encodeUrl(fileName, "ISO-8859-1");
                    sbuf.Append(fileNameA);

                    sbuf.Append("; filename*=UTF-8''");
                    String fileNameU = encodeUrl(fileName, "UTF-8");
                    sbuf.Append(fileNameU);
                }
                return sbuf.ToString();
            }

            set
            {
                String fileName = "";
                int attcode = 0;
                if (value != null && value.Length != 0)
                {
                    value = value.Trim();
                    attcode = value.IndexOf("attachment;") >= 0 ? ATTACHMENT : INLINE;

                    int p = value.IndexOf("filename*=");
                    if (p >= 0)
                    {
                        int b = p + 10;
                        int e = value.IndexOf('\'', b);
                        if (e != -1)
                        {
                            String charSet = value.Substring(b, e - b);
                            b = e;
                            e = value.IndexOf('\'', b + 1);
                            if (e != -1)
                            {
                                //String lang = value.substring(b, e); ignored
                                b = e + 1;
                                e = value.IndexOf(';', b);
                                if (e == -1) e = value.Length;
                                fileName = value.Substring(b, e - b);
                                fileName = fileName.Trim();
                                if (fileName.StartsWith("\"") && fileName.EndsWith("\"")) fileName = fileName.Substring(1, fileName.Length - 2);
                                fileName = decodeUrl(fileName, charSet);
                            }
                        }
                    }

                    if (fileName == "")
                    {
                        p = value.IndexOf("filename=");
                        if (p >= 0)
                        {
                            int b = p + 9;
                            int e = value.IndexOf(';', b);
                            if (e == -1) e = value.Length;
                            fileName = value.Substring(b, e - b);
                            fileName = fileName.Trim();
                            if (fileName.StartsWith("\"") && fileName.EndsWith("\"")) fileName = fileName.Substring(1, fileName.Length - 2);
                            fileName = decodeUrl(fileName, "ISO-8859-1");
                        }

                    }
                }
                attachmentCodeVal = attcode;
                fileNameVal = fileName;
            }
        }

        public virtual void copyProperties(BContentStream rhs)
        {
            contentTypeVal = rhs.ContentType;
            contentLengthVal = rhs.ContentLength;
            fileNameVal = rhs.FileName;
            attachmentCodeVal = rhs.AttachmentCode;
            targetIdVal = rhs.TargetId;
        }

        public virtual void ensureProperties()
        {
        }
     }

}
