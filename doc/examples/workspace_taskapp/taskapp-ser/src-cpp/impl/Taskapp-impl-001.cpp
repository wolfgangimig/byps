#include "Taskapp-impl.h"
using namespace ::std;
using namespace ::byps;

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_1182472339(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< task::app::PTaskInfo >& r = * reinterpret_cast< ::std::vector< task::app::PTaskInfo >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< task::app::PTaskInfo >());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BRequest_TaskService_addTask
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_TaskService_addTask::BRequest_TaskService_addTask() : BMethodRequest(216769899) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
task::app::BRequest_TaskService_addTask::BRequest_TaskService_addTask(const PToken& token, const PTaskInfo& task)
	: BMethodRequest(216769899) 
	, token(token)
	, task(task)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BRequest_TaskService_addTask::serialize(BIO& ar, const BVERSION version) {
	ar & this->task;
	ar & this->token;
}
void task::app::BRequest_TaskService_addTask::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PTaskService __byps__remoteT = byps_ptr_cast<TaskService>(__byps__remote);
	__byps__remoteT->addTask(token, task, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_1498136965(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BRequest_TaskService_addTask& r = * dynamic_cast< task::app::BRequest_TaskService_addTask*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BRequest_TaskService_addTask());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BRequest_TaskService_getTasks
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_TaskService_getTasks::BRequest_TaskService_getTasks() : BMethodRequest(216769899) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
task::app::BRequest_TaskService_getTasks::BRequest_TaskService_getTasks(const PToken& token)
	: BMethodRequest(216769899) 
	, token(token)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BRequest_TaskService_getTasks::serialize(BIO& ar, const BVERSION version) {
	ar & this->token;
}
void task::app::BRequest_TaskService_getTasks::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PTaskService __byps__remoteT = byps_ptr_cast<TaskService>(__byps__remote);
	__byps__remoteT->getTasks(token, [__byps__asyncResult](byps_ptr< ::std::vector< PTaskInfo > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1182472339(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_280075325(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BRequest_TaskService_getTasks& r = * dynamic_cast< task::app::BRequest_TaskService_getTasks*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BRequest_TaskService_getTasks());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BRequest_TaskService_login
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_TaskService_login::BRequest_TaskService_login() : BMethodRequest(216769899) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
task::app::BRequest_TaskService_login::BRequest_TaskService_login(const ::std::wstring& name, const ::std::wstring& pwd)
	: BMethodRequest(216769899) 
	, name(name)
	, pwd(pwd)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BRequest_TaskService_login::serialize(BIO& ar, const BVERSION version) {
	ar & this->name;
	ar & this->pwd;
}
void task::app::BRequest_TaskService_login::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PTaskService __byps__remoteT = byps_ptr_cast<TaskService>(__byps__remote);
	__byps__remoteT->login(name, pwd, [__byps__asyncResult](PToken __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_323961470(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_366472542(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BRequest_TaskService_login& r = * dynamic_cast< task::app::BRequest_TaskService_login*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BRequest_TaskService_login());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BRequest_TaskService_logout
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_TaskService_logout::BRequest_TaskService_logout() : BMethodRequest(216769899) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
task::app::BRequest_TaskService_logout::BRequest_TaskService_logout(const PToken& token)
	: BMethodRequest(216769899) 
	, token(token)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BRequest_TaskService_logout::serialize(BIO& ar, const BVERSION version) {
	ar & this->token;
}
void task::app::BRequest_TaskService_logout::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PTaskService __byps__remoteT = byps_ptr_cast<TaskService>(__byps__remote);
	__byps__remoteT->logout(token, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_1524246987(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BRequest_TaskService_logout& r = * dynamic_cast< task::app::BRequest_TaskService_logout*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BRequest_TaskService_logout());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BRequest_TaskService_removeTask
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_TaskService_removeTask::BRequest_TaskService_removeTask() : BMethodRequest(216769899) {
	taskId = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
task::app::BRequest_TaskService_removeTask::BRequest_TaskService_removeTask(const PToken& token, int64_t taskId)
	: BMethodRequest(216769899) 
	, token(token)
	, taskId(taskId)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BRequest_TaskService_removeTask::serialize(BIO& ar, const BVERSION version) {
	ar & this->taskId;
	ar & this->token;
}
void task::app::BRequest_TaskService_removeTask::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PTaskService __byps__remoteT = byps_ptr_cast<TaskService>(__byps__remote);
	__byps__remoteT->removeTask(token, taskId, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_1265487020(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BRequest_TaskService_removeTask& r = * dynamic_cast< task::app::BRequest_TaskService_removeTask*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BRequest_TaskService_removeTask());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BResult_1182472339
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BResult_1182472339::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_2101800006(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BResult_1182472339& r = * dynamic_cast< task::app::BResult_1182472339*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BResult_1182472339());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BResult_19
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BResult_19::serialize(BIO& ar, const BVERSION version) {
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_1766349022(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BResult_19& r = * dynamic_cast< task::app::BResult_19*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BResult_19());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class BResult_323961470
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::BResult_323961470::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_771996649(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::BResult_323961470& r = * dynamic_cast< task::app::BResult_323961470*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::BResult_323961470());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class TaskInfo
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
TaskInfo::TaskInfo() {
	id = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
task::app::TaskInfo::TaskInfo(int32_t id, const ::std::wstring& userName, const BDateTime& dueDate, const ::std::wstring& todo)
	: id(id)
	, userName(userName)
	, dueDate(dueDate)
	, todo(todo)
	{}
void TaskInfo::setId(int32_t v) {
	id = v;
}
void TaskInfo::setUserName(::std::wstring v) {
	userName = v;
}
void TaskInfo::setDueDate(BDateTime v) {
	dueDate = v;
}
void TaskInfo::setTodo(::std::wstring v) {
	todo = v;
}
// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::TaskInfo::serialize(BIO& ar, const BVERSION version) {
	ar & this->dueDate;
	ar & this->id;
	ar & this->todo;
	ar & this->userName;
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_1660464439(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::TaskInfo& r = * dynamic_cast< task::app::TaskInfo*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::TaskInfo());
	}
}
}}
namespace task { namespace app { 

//-------------------------------------------------
// Implementation of class Token
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Token::Token() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
task::app::Token::Token(const ::std::wstring& sessionId)
	: sessionId(sessionId)
	{}
void Token::setSessionId(::std::wstring v) {
	sessionId = v;
}
// checkpoint byps.gen.cpp.GenApiClass:877
void task::app::Token::serialize(BIO& ar, const BVERSION version) {
	ar & this->sessionId;
}
}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace task { namespace app { 
void BSerializer_323961470(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		task::app::Token& r = * dynamic_cast< task::app::Token*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new task::app::Token());
	}
}
}}

namespace task { namespace app { 

BStub_TaskService::BStub_TaskService(PTransport transport) 
	: BStub(transport) {}

PToken BStub_TaskService::login(const ::std::wstring& name, const ::std::wstring& pwd)  {
	BSyncResultT< PToken > syncResult;	
	login(name, pwd, [&syncResult](PToken v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_TaskService::login(const ::std::wstring& name, const ::std::wstring& pwd, ::std::function< void (PToken, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_TaskService_login(name, pwd));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PToken, BResult_323961470 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_TaskService::logout(const PToken& token)  {
	BSyncResultT< bool > syncResult;	
	logout(token, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_TaskService::logout(const PToken& token, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_TaskService_logout(token));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_TaskService::addTask(const PToken& token, const PTaskInfo& task)  {
	BSyncResultT< bool > syncResult;	
	addTask(token, task, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_TaskService::addTask(const PToken& token, const PTaskInfo& task, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_TaskService_addTask(token, task));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_TaskService::removeTask(const PToken& token, int64_t taskId)  {
	BSyncResultT< bool > syncResult;	
	removeTask(token, taskId, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_TaskService::removeTask(const PToken& token, int64_t taskId, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_TaskService_removeTask(token, taskId));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< ::std::vector< PTaskInfo > > BStub_TaskService::getTasks(const PToken& token)  {
	BSyncResultT< byps_ptr< ::std::vector< PTaskInfo > > > syncResult;	
	getTasks(token, [&syncResult](byps_ptr< ::std::vector< PTaskInfo > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_TaskService::getTasks(const PToken& token, ::std::function< void (byps_ptr< ::std::vector< PTaskInfo > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_TaskService_getTasks(token));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PTaskInfo > >, BResult_1182472339 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace task { namespace app { 
void BSerializer_216769899(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new task::app::BStub_TaskService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}
//-------------------------------------------------
// Registry 

task::app::BRegistry_Taskapp::BRegistry_Taskapp()
{
	registerClass(typeid(::std::vector< task::app::PTaskInfo >), task::app::BSerializer_1182472339, 1182472339);
	registerClass(typeid(task::app::BRequest_TaskService_addTask), task::app::BSerializer_1498136965, 1498136965);
	registerClass(typeid(task::app::BRequest_TaskService_getTasks), task::app::BSerializer_280075325, 280075325);
	registerClass(typeid(task::app::BRequest_TaskService_login), task::app::BSerializer_366472542, 366472542);
	registerClass(typeid(task::app::BRequest_TaskService_logout), task::app::BSerializer_1524246987, 1524246987);
	registerClass(typeid(task::app::BRequest_TaskService_removeTask), task::app::BSerializer_1265487020, 1265487020);
	registerClass(typeid(task::app::BResult_1182472339), task::app::BSerializer_2101800006, 2101800006);
	registerClass(typeid(task::app::BResult_19), task::app::BSerializer_1766349022, 1766349022);
	registerClass(typeid(task::app::BResult_323961470), task::app::BSerializer_771996649, 771996649);
	registerClass(typeid(task::app::BStub_TaskService), task::app::BSerializer_216769899, 216769899);
	registerClass(typeid(task::app::TaskInfo), task::app::BSerializer_1660464439, 1660464439);
	registerClass(typeid(task::app::Token), task::app::BSerializer_323961470, 323961470);
}
namespace task { namespace app { 

PApiDescriptor BApiDescriptor_Taskapp::instance() {
	return PApiDescriptor((new BApiDescriptor(
	"Taskapp",
	"task.app",
	VERSION,
	false)) // uniqueObjects
	->addRegistry(PRegistry(new BRegistry_Taskapp()))
	);
};

}}

namespace task { namespace app { 

PClient_Taskapp BClient_Taskapp::createClient(PTransportFactory transportFactory) {
	return PClient_Taskapp(new BClient_Taskapp(transportFactory));
}
PClient_Taskapp BClient_Taskapp::createClientR(PTransport transport) {
	return PClient_Taskapp(new BClient_Taskapp(transport));
}
BClient_Taskapp::BClient_Taskapp(PTransportFactory transportFactory) 
	: BClient(
		transportFactory->createClientTransport(), 
		transportFactory->createServerR(
			BServer_Taskapp::createServerR(transportFactory->createServerTransport())
		)
	)
	{
	initStubs(transport);
}
BClient_Taskapp::BClient_Taskapp(PTransport transport) 
	: BClient(transport, NULL)
	{
	initStubs(transport);
}
BINLINE task::app::PTaskService BClient_Taskapp::getTaskService() {
	return taskService;
}
PRemote BClient_Taskapp::getStub(int remoteId) {
	if (remoteId == 216769899) return taskService;
	return PRemote();
}
BINLINE void BClient_Taskapp::initStubs(PTransport transport) {
	taskService = task::app::PTaskService(new BStub_TaskService(transport));
}
}}

namespace task { namespace app { 

PServer_Taskapp BServer_Taskapp::createServer(PTransportFactory transportFactory) {
	return PServer_Taskapp(new BServer_Taskapp(transportFactory));
}
PServer_Taskapp BServer_Taskapp::createServerR(PTransport transport) {
	return PServer_Taskapp(new BServer_Taskapp(transport));
}
BServer_Taskapp::BServer_Taskapp(PTransportFactory transportFactory) 
	: BServer(
		transportFactory->createServerTransport(), 
		transportFactory->createClientR(
			BClient_Taskapp::createClientR(transportFactory->createClientTransport())
		)
	)
	{
}
BServer_Taskapp::BServer_Taskapp(PTransport transport) 
	: BServer(transport, NULL)
	{
}
}}

