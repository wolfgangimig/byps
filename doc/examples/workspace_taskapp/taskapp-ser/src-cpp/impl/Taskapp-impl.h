#ifndef __Taskapp_impl_H__
#define __Taskapp_impl_H__

#include <Byps-impl.h>
#include <Taskapp-api.h>


//-------------------------------------------------
// Forward Declaration of class BRequest_TaskService_addTask

namespace task { namespace app { 

class BRequest_TaskService_addTask; 

}}

//-------------------------------------------------
// Forward Declaration of class BRequest_TaskService_getTasks

namespace task { namespace app { 

class BRequest_TaskService_getTasks; 

}}

//-------------------------------------------------
// Forward Declaration of class BRequest_TaskService_login

namespace task { namespace app { 

class BRequest_TaskService_login; 

}}

//-------------------------------------------------
// Forward Declaration of class BRequest_TaskService_logout

namespace task { namespace app { 

class BRequest_TaskService_logout; 

}}

//-------------------------------------------------
// Forward Declaration of class BRequest_TaskService_removeTask

namespace task { namespace app { 

class BRequest_TaskService_removeTask; 

}}

//-------------------------------------------------
// BRequest_TaskService_addTask
// typeId=1498136965

namespace task { namespace app { 

using namespace ::byps;

class BRequest_TaskService_addTask : public BMethodRequest {
	public: PToken token;
	public: PTaskInfo task;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: BRequest_TaskService_addTask();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: BRequest_TaskService_addTask(const PToken& token, const PTaskInfo& task);	
	public: virtual BTYPEID BSerializable_getTypeId() { return 1498136965; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
	public: virtual void execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult);
};

}}

//-------------------------------------------------
// BRequest_TaskService_getTasks
// typeId=280075325

namespace task { namespace app { 

using namespace ::byps;

class BRequest_TaskService_getTasks : public BMethodRequest {
	public: PToken token;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: BRequest_TaskService_getTasks();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: BRequest_TaskService_getTasks(const PToken& token);	
	public: virtual BTYPEID BSerializable_getTypeId() { return 280075325; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
	public: virtual void execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult);
};

}}

//-------------------------------------------------
// BRequest_TaskService_login
// typeId=366472542

namespace task { namespace app { 

using namespace ::byps;

class BRequest_TaskService_login : public BMethodRequest {
	public: ::std::wstring name;
	public: ::std::wstring pwd;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: BRequest_TaskService_login();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: BRequest_TaskService_login(const ::std::wstring& name, const ::std::wstring& pwd);	
	public: virtual BTYPEID BSerializable_getTypeId() { return 366472542; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
	public: virtual void execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult);
};

}}

//-------------------------------------------------
// BRequest_TaskService_logout
// typeId=1524246987

namespace task { namespace app { 

using namespace ::byps;

class BRequest_TaskService_logout : public BMethodRequest {
	public: PToken token;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: BRequest_TaskService_logout();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: BRequest_TaskService_logout(const PToken& token);	
	public: virtual BTYPEID BSerializable_getTypeId() { return 1524246987; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
	public: virtual void execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult);
};

}}

//-------------------------------------------------
// BRequest_TaskService_removeTask
// typeId=1265487020

namespace task { namespace app { 

using namespace ::byps;

class BRequest_TaskService_removeTask : public BMethodRequest {
	public: PToken token;
	public: int64_t taskId;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: BRequest_TaskService_removeTask();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: BRequest_TaskService_removeTask(const PToken& token, int64_t taskId);	
	public: virtual BTYPEID BSerializable_getTypeId() { return 1265487020; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
	public: virtual void execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult);
};

}}

//-------------------------------------------------
// BResult_1182472339
// typeId=2101800006

namespace task { namespace app { 

using namespace ::byps;

class BResult_1182472339 : public BSerializable {
	public: byps_ptr< ::std::vector< task::app::PTaskInfo > > result;
	// checkpoint byps.gen.cpp.GenApiClass:473
	public: BResult_1182472339(byps_ptr< ::std::vector< task::app::PTaskInfo > > result = byps_ptr< ::std::vector< task::app::PTaskInfo > >()) : result(result) {}	
	public: virtual BTYPEID BSerializable_getTypeId() { return 2101800006; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
};

}}

//-------------------------------------------------
// BResult_19
// typeId=1766349022

namespace task { namespace app { 

using namespace ::byps;

class BResult_19 : public BSerializable {
	public: bool result;
	// checkpoint byps.gen.cpp.GenApiClass:473
	public: BResult_19(bool result = bool()) : result(result) {}	
	public: virtual BTYPEID BSerializable_getTypeId() { return 1766349022; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
};

}}

//-------------------------------------------------
// BResult_323961470
// typeId=771996649

namespace task { namespace app { 

using namespace ::byps;

class BResult_323961470 : public BSerializable {
	public: task::app::PToken result;
	// checkpoint byps.gen.cpp.GenApiClass:473
	public: BResult_323961470(task::app::PToken result = task::app::PToken()) : result(result) {}	
	public: virtual BTYPEID BSerializable_getTypeId() { return 771996649; }
	
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
};

}}

namespace task { namespace app { 

// Serializer for java.util.List<task.app.TaskInfo>
void BSerializer_1182472339(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BRequest_TaskService_addTask
void BSerializer_1498136965(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BRequest_TaskService_getTasks
void BSerializer_280075325(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BRequest_TaskService_login
void BSerializer_366472542(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BRequest_TaskService_logout
void BSerializer_1524246987(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BRequest_TaskService_removeTask
void BSerializer_1265487020(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BResult_1182472339
void BSerializer_2101800006(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BResult_19
void BSerializer_1766349022(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BResult_323961470
void BSerializer_771996649(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.BStub_TaskService
void BSerializer_216769899(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.TaskInfo
void BSerializer_1660464439(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);
// Serializer for task.app.Token
void BSerializer_323961470(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase);

}}


#endif
