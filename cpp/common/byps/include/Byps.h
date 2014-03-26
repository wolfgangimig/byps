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
class BContentStreamFile;
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
typedef byps_ptr<BContentStreamFile> PContentStreamFile;

typedef vector<bool> BVectorBool;
typedef vector<wchar_t> BVectorChar;
typedef vector<int16_t> BVectorShort;
typedef vector<int32_t> BVectorInt;
typedef vector<int64_t> BVectorLong;
typedef vector<float> BVectorFloat;
typedef vector<double> BVectorDouble;
typedef vector<wstring> BVectorString;
typedef vector<BDateTime> BVectorDate;
typedef vector<PSerializable> BVectorObject;

typedef byps_ptr<BVectorBool> PVectorBool;
typedef byps_ptr<BVectorChar> PVectorChar;
typedef byps_ptr<BVectorShort> PVectorShort;
typedef byps_ptr<BVectorInt> PVectorInt;
typedef byps_ptr<BVectorLong> PVectorLong;
typedef byps_ptr<BVectorFloat> PVectorFloat;
typedef byps_ptr<BVectorDouble> PVectorDouble;
typedef byps_ptr<BVectorString> PVectorString;
typedef byps_ptr<BVectorDate> PVectorDate;
typedef byps_ptr<BVectorObject> PVectorObject;

typedef set<bool> BSetBool;
typedef set<wchar_t> BSetChar;
typedef set<int16_t> BSetShort;
typedef set<int32_t> BSetInt;
typedef set<int64_t> BSetLong;
typedef set<float> BSetFloat;
typedef set<double> BSetDouble;
typedef set<wstring> BSetString;
typedef set<BDateTime> BSetDate;

typedef byps_ptr<BSetBool> PSetBool;
typedef byps_ptr<BSetChar> PSetChar;
typedef byps_ptr<BSetShort> PSetShort;
typedef byps_ptr<BSetInt> PSetInt;
typedef byps_ptr<BSetLong> PSetLong;
typedef byps_ptr<BSetFloat> PSetFloat;
typedef byps_ptr<BSetDouble> PSetDouble;
typedef byps_ptr<BSetString> PSetString;
typedef byps_ptr<BSetDate> PSetDate;

typedef map<bool, PSerializable> BMapBoolObject;
typedef map<wchar_t, PSerializable> BMapCharObject;
typedef map<int16_t, PSerializable> BMapShortObject;
typedef map<int32_t, PSerializable> BMapIntObject;
typedef map<int64_t, PSerializable> BMapLongObject;
typedef map<float, PSerializable> BMapFloatObject;
typedef map<double, PSerializable> BMapDoubleObject;
typedef map<wstring, PSerializable> BMapStringObject;

typedef byps_ptr<BMapBoolObject> PMapBoolObject;
typedef byps_ptr<BMapCharObject> PMapCharObject;
typedef byps_ptr<BMapShortObject> PMapShortObject;
typedef byps_ptr<BMapIntObject> PMapIntObject;
typedef byps_ptr<BMapLongObject> PMapLongObject;
typedef byps_ptr<BMapFloatObject> PMapFloatObject;
typedef byps_ptr<BMapDoubleObject> PMapDoubleObject;
typedef byps_ptr<BMapStringObject> PMapStringObject;

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

#endif
