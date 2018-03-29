/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BYPS_API_H_
#define BYPS_API_H_

#define BOOST_SYSTEM_NO_DEPRECATED

#ifdef BYPS_HEADER_ONLY
#define BINLINE inline
#else
#define BINLINE
#endif

#include <stdint.h>
#include <ctime>
#include <string>
#include <sstream>
#include <vector>
#include <map>
#include <unordered_map>
#include <set>
#include <iostream>
#include <fstream>
#include <functional>

#include "platform/platform-api.h"

namespace byps {

using namespace ::std;

typedef int32_t BTYPEID;
typedef int32_t BPOINTER;
typedef int32_t BLENGTH;
typedef int64_t BVERSION;

//template<typename _resultType> class BAsyncResult;
class BAsyncResult;

template<typename _Type> class BArray1;
template<typename _Type> class BArray2;
template<typename _Type> class BArray3;
template<typename _Type> class BArray4;

class BClient;
class BRemote;
class BSerializable;
class BServerR;
class BTransport;
template<typename _Type> class BSyncResultT;

class BApiDescriptor;
class BAuthentication;
class BBinaryModel;
class BBuffer;
class BByteOrder;
class BBytes;
class BClient;
class BContentStream;
class BContentStreamWrapper;
class BFile;
class BException;
class BInput;
class BIO;
class BMessage;
class BMessageHeader;
class BMethodRequest;
template<typename _Type> class BMethodResult;
class BNegotiate;
class BOutput;
class BProtocol;
class BRegistry;
class BSerializer;
template<typename _T> class BSerializerT;
class BServer;
class BServerR;
class BLostConnectionHandler;
class BSkeleton;
class BStreamRequest;
class BStub;
class BTargetId;
class BTransportFactory;
class BTestAdapter;
class BVariant;
class BWire;
class BRunnable;
class BThreadPool;
class BDateTime;

typedef byps_ptr<BRunnable> PRunnable;
typedef byps_ptr<BThreadPool> PThreadPool;

typedef BAsyncResult* PAsyncResult;

typedef byps_ptr<BApiDescriptor> PApiDescriptor;
typedef byps_ptr<BAuthentication> PAuthentication;
typedef byps_ptr<BBuffer> PBuffer;
typedef byps_ptr<BBytes> PBytes;
typedef byps_ptr<BOutput> POutput;
typedef byps_ptr<BInput> PInput;
typedef byps_ptr<BMessage> PMessage;
typedef byps_ptr<BMethodRequest> PMethodRequest;
typedef byps_ptr<BProtocol> PProtocol;
typedef byps_ptr<BRegistry> PRegistry;
typedef byps_ptr<BRemote> PRemote;
typedef byps_ptr<BSerializable> PSerializable;
typedef byps_ptr<BSkeleton> PSkeleton;
typedef byps_ptr<istream> PStream;
typedef byps_ptr<BStreamRequest> PStreamRequest;
typedef byps_ptr<BVariant> PVariant;
typedef byps_ptr<BWire> PWire;
typedef byps_ptr<BTransportFactory> PTransportFactory;
typedef byps_ptr<BTestAdapter> PTestAdapter;

//typedef byps_ptr< BAsyncResult<PMessage> > PAsyncResult_PMessage;
//typedef byps_ptr< BAsyncResult<PBuffer> > PAsyncResult_PBuffer;
//typedef byps_ptr< BAsyncResult<PBytes> > PAsyncResult_PBytes;
//typedef byps_ptr< BAsyncResult<PSerializable> > PAsyncResult_PSerializable;
//typedef byps_ptr< BAsyncResult<BClient*> > PAsyncResult_BClient;

typedef byps_ptr<BSerializable> PSerializable;
typedef byps_ptr<BTransport> PTransport;
typedef byps_ptr<BRemote> PRemote;

typedef byps_ptr<BClient> PClient;
typedef byps_ptr<BServer> PServer;
typedef byps_ptr<BServerR> PServerR;
typedef byps_ptr<BLostConnectionHandler> PLostConnectionHandler;

typedef byps_ptr<void> POBJECT;
typedef void (*BSERIALIZER)(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);

typedef byps_ptr<BContentStream> PContentStream;
typedef byps_ptr<BContentStreamWrapper> PContentStreamWrapper;

}

#include "BException.h"
#include "BSerializable.h"
#include "BTargetId.h"
#include "BAsyncResult.h"
#include "BArray.h"
#include "BRemote.h"
#include "BSynchronized.h"
#include "BByteOrder.h"
#include "BBinaryModel.h"
#include "BBuffer.h"
#include "BVariant.h"
#include "BWire.h"
#include "BMessageHeader.h"
#include "BNegotiate.h"
#include "BIO.h"
#include "BOutput.h"
#include "BInput.h"
#include "BApiDescriptor.h"
#include "BSerializer.h"
#include "BRegistry.h"
#include "BUtils.h"
#include "BMethodResult.h"
#include "BMethodRequest.h"
#include "BProtocol.h"
#include "BRegistry.h"
#include "BBytes.h"
#include "BTransport.h"
#include "BStreamRequest.h"
#include "BMessage.h"
#include "BTransportFactory.h"
#include "BServer.h"
#include "BClient.h"
#include "BStub.h"
#include "BSkeleton.h"
#include "BContentStream.h"
#include "BTestAdapter.h"
#include "BThreadPool.h"
#include "BUtils.h"
#include "BVersioning.h"
#include "BAuthentication.h"
#include "BLostConnectionHandler.h"
#include "BDateTime.h"
#include "BValueClass.h"
#include "BFile.h"


////////////////////////////////////////////////////////////////////////
// Undefine constants defined by C headers

#undef min
#undef max


#endif
