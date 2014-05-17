/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCONTENTSTREAM_H_
#define BCONTENTSTREAM_H_

#include "Byps.h"

namespace byps {

  using namespace ::std;

#define BYPS_DEFAULT_CONTENT_TYPE L"application/octet-stream"

  class BContentStream : public BSerializable {
  public:
  	const static int32_t ATTACHMENT = 1;
  	const static int32_t INLINE = 2;

    BContentStream();
    BContentStream(const wstring& contentType, int64_t contentLength);
    virtual ~BContentStream() {}

    virtual BTYPEID BSerializable_getTypeId() { return BTYPEID_STREAM; }

    virtual wstring getContentType() const ;
    virtual void setContentType(const wstring&);
    virtual int64_t getContentLength() const;
    virtual void setContentLength(int64_t);
    virtual wstring getFileName() const;
    virtual void setFileName(const wstring&);
    virtual int32_t getAttachmentCode() const;
    virtual void setAttachmentCode(int32_t b);
    virtual const BTargetId& getTargetId() const;
    virtual void setTargetId(const BTargetId& rhs);
    virtual void copyProperties(const PContentStream& rhs);
    virtual void setContentDisposition(const wstring& contentDisposition);
    virtual wstring getContentDisposition() const;

    virtual int32_t read(char* buf, int32_t offs, int32_t len) = 0;
    virtual PStream getStdStream() { return PStream(); };

  protected:
    wstring contentType;
    int64_t contentLength;
    wstring fileName;
    int32_t attachmentCode;
    BTargetId targetId;

  };


  class BContentStreamWrapper : public BContentStream {
  public:
    BContentStreamWrapper();
    BContentStreamWrapper(PStream stream, const wstring& contentType, int64_t contentLength);
    BContentStreamWrapper(PStream stream);
    BContentStreamWrapper(PContentStream innerStream, int64_t reserved);
    
    BContentStreamWrapper(const BFile& fname);
    BContentStreamWrapper(const BFile& fname, const wstring& contentType);

    virtual ~BContentStreamWrapper();

    virtual int32_t read(char* buf, int32_t offs, int32_t len);
    virtual PStream getStdStream();
    
  protected:
    virtual PContentStream openStream();
    virtual PContentStream ensureStream();

    void init(const BFile& file, const wstring& contentType);
    PStream stdStream;
    PContentStream innerStream;
    byps_mutex mutex;
  };

}

#endif
