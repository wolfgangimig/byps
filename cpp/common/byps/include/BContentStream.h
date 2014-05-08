/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCONTENTSTREAM_H_
#define BCONTENTSTREAM_H_

#include "Byps.h"

namespace byps {

  using namespace ::std;

#define BYPS_DEFAULT_CONTENT_TYPE L"application/octet-stream"

  class BContentStream : public BSerializable {
  public:
    virtual ~BContentStream() {}

    virtual BTYPEID BSerializable_getTypeId() { return BTYPEID_STREAM; }

    virtual int32_t read(char* buf, int32_t offs, int32_t len) = 0;

    virtual const wstring& getContentType() const = 0;
    virtual void setContentType(const wstring&) = 0;
    virtual int64_t getContentLength() const = 0;
    virtual void setContentLength(int64_t) = 0;
    virtual const wstring& getFileName() const = 0;
    virtual void setFileName(const wstring&) = 0;
    virtual bool isAttachment() const = 0;
    virtual void setAttachment(bool b) = 0;
    virtual const BTargetId& getTargetId() const = 0;
    virtual void setTargetId(const BTargetId& rhs) = 0;
    virtual void copyProperties(const PContentStream& rhs) = 0;

    static void serialize(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
  };

  class BContentStreamImpl : public BContentStream {
  public:
    BContentStreamImpl(const wstring& contentType, int64_t contentLength, PStream stream);
    BContentStreamImpl(PStream stream);
    virtual ~BContentStreamImpl() {}

    virtual const wstring& getContentType() const ;
    virtual void setContentType(const wstring&);
    virtual int64_t getContentLength() const;
    virtual void setContentLength(int64_t);
    virtual const wstring& getFileName() const;
    virtual void setFileName(const wstring&);
    virtual bool isAttachment() const;
    virtual void setAttachment(bool b);
    virtual const BTargetId& getTargetId() const;
    virtual void setTargetId(const BTargetId& rhs);
    virtual void copyProperties(const PContentStream& rhs);

    virtual int32_t read(char* buf, int32_t offs, int32_t len);

  protected:
    BContentStreamImpl();
    wstring contentType;
    int64_t contentLength;
    PStream stream;
    wstring fileName;
    bool attachment;
    BTargetId targetId;
  };


  class BContentStreamFile : public BContentStreamImpl {
  public:
#ifdef BFSTREAM_WCHAR
    BContentStreamFile(const wstring& fname);
    BContentStreamFile(const wstring& fname, const wstring& contentType, int64_t contentLength);
#endif
    BContentStreamFile(const string& fname);
    BContentStreamFile(const string& fname, const string& contentType, int64_t contentLength);
    virtual ~BContentStreamFile();
  private:
    void init(ifstream* fstrm);
  };

}

#endif
