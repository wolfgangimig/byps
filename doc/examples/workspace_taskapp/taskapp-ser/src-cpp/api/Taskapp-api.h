#ifndef __Taskapp_api_H__
#define __Taskapp_api_H__

#include <Byps.h>

//-------------------------------------------------
// Forward Declaration of class BStub_TaskService

namespace task { namespace app { 

class BStub_TaskService; 
typedef byps_ptr< BStub_TaskService > PStub_TaskService; 

}}

//-------------------------------------------------
// Forward Declaration of class TaskInfo

namespace task { namespace app { 

class TaskInfo; 
typedef byps_ptr< TaskInfo > PTaskInfo; 

}}

//-------------------------------------------------
// Forward Declaration of class Token

namespace task { namespace app { 

class Token; 
typedef byps_ptr< Token > PToken; 

}}

//-------------------------------------------------
// TaskInfo
// typeId=1660464439

namespace task { namespace app { 

using namespace ::byps;

class TaskInfo : public BSerializable {
	protected: int32_t id;
	protected: ::std::wstring userName;
	protected: BDateTime dueDate;
	protected: ::std::wstring todo;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: TaskInfo();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: TaskInfo(int32_t id, const ::std::wstring& userName, const BDateTime& dueDate, const ::std::wstring& todo);	
	public: virtual BTYPEID BSerializable_getTypeId() { return 1660464439; }
	
	public: int32_t getId() { return id; }
	public: void setId(int32_t v);
	public: ::std::wstring getUserName() { return userName; }
	public: void setUserName(::std::wstring v);
	public: BDateTime getDueDate() { return dueDate; }
	public: void setDueDate(BDateTime v);
	public: ::std::wstring getTodo() { return todo; }
	public: void setTodo(::std::wstring v);
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
};

}}

//-------------------------------------------------
// Token
// typeId=323961470

namespace task { namespace app { 

using namespace ::byps;

class Token : public BSerializable {
	protected: ::std::wstring sessionId;
	
	// checkpoint byps.gen.cpp.GenApiClass:488
	public: Token();
	// checkpoint byps.gen.cpp.GenApiClass:535
	public: Token(const ::std::wstring& sessionId);	
	public: virtual BTYPEID BSerializable_getTypeId() { return 323961470; }
	
	public: ::std::wstring getSessionId() { return sessionId; }
	public: void setSessionId(::std::wstring v);
	// checkpoint byps.gen.cpp.GenApiClass:871
	public: void serialize(BIO& ar, const BVERSION version);
};

}}

//-------------------------------------------------
// Forward Declaration of class TaskService

namespace task { namespace app { 

class TaskService; 
typedef byps_ptr< TaskService > PTaskService; 

}}

//-------------------------------------------------
// TaskService

namespace task { namespace app { 

using namespace ::byps;

class TaskService : public virtual BRemote {
	
	public: virtual PToken login(const ::std::wstring& name, const ::std::wstring& pwd)  = 0;
	public: virtual void login(const ::std::wstring& name, const ::std::wstring& pwd, ::std::function< void (PToken, BException ex) > asyncResult)  = 0;
	
	public: virtual void logout(const PToken& token)  = 0;
	public: virtual void logout(const PToken& token, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void addTask(const PToken& token, const PTaskInfo& task)  = 0;
	public: virtual void addTask(const PToken& token, const PTaskInfo& task, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual void removeTask(const PToken& token, int64_t taskId)  = 0;
	public: virtual void removeTask(const PToken& token, int64_t taskId, ::std::function< void (bool, BException ex) > asyncResult)  = 0;
	
	public: virtual byps_ptr< ::std::vector< PTaskInfo > > getTasks(const PToken& token)  = 0;
	public: virtual void getTasks(const PToken& token, ::std::function< void (byps_ptr< ::std::vector< PTaskInfo > >, BException ex) > asyncResult)  = 0;
	
	
};

}}
//-------------------------------------------------
// Stub class BStub_TaskService

namespace task { namespace app { 

using namespace ::byps;

class BStub_TaskService;
typedef byps_ptr<BStub_TaskService> PStub_TaskService;

class BStub_TaskService : public BStub, public virtual TaskService {
	
	public: BStub_TaskService(PTransport transport);	
	
	public: virtual BTYPEID BSerializable_getTypeId() { return 216769899; }
	
	public: virtual PToken login(const ::std::wstring& name, const ::std::wstring& pwd) ;
	public: virtual void login(const ::std::wstring& name, const ::std::wstring& pwd, ::std::function< void (PToken, BException ex) > asyncResult) ;
	
	public: virtual void logout(const PToken& token) ;
	public: virtual void logout(const PToken& token, ::std::function< void (bool, BException ex) > asyncResult) ;
	
	public: virtual void addTask(const PToken& token, const PTaskInfo& task) ;
	public: virtual void addTask(const PToken& token, const PTaskInfo& task, ::std::function< void (bool, BException ex) > asyncResult) ;
	
	public: virtual void removeTask(const PToken& token, int64_t taskId) ;
	public: virtual void removeTask(const PToken& token, int64_t taskId, ::std::function< void (bool, BException ex) > asyncResult) ;
	
	public: virtual byps_ptr< ::std::vector< PTaskInfo > > getTasks(const PToken& token) ;
	public: virtual void getTasks(const PToken& token, ::std::function< void (byps_ptr< ::std::vector< PTaskInfo > >, BException ex) > asyncResult) ;
	
	
};
}}


//-------------------------------------------------
namespace task { namespace app { 

class BRegistry_Taskapp : public BRegistry { 
public:
	BRegistry_Taskapp();
	virtual ~BRegistry_Taskapp() {}
};

}}

namespace task { namespace app { 
using namespace ::byps;

class BApiDescriptor_Taskapp { 
	/**
	 * API serialisation version: 1.0.0.0
	 */
	public: const static int64_t VERSION = 100000000000000LL;
	public: static PApiDescriptor instance();
};

}}

namespace task { namespace app { 

using namespace ::byps;

class BClient_Taskapp;
typedef byps_ptr<BClient_Taskapp> PClient_Taskapp;

class BClient_Taskapp : public BClient { 

	public: static PClient_Taskapp createClient(PTransportFactory transportFactory);
	
	public: static PClient_Taskapp createClientR(PTransport transport);
	
	protected: BClient_Taskapp(PTransportFactory transportFactory); 
	
	protected: BClient_Taskapp(PTransport transport); 
	
	public: virtual ~BClient_Taskapp() {}
	
	virtual task::app::PTaskService getTaskService();	
	
	public: virtual PRemote getStub(int remoteId);
	
	protected: task::app::PTaskService taskService;
	
	private: void initStubs(PTransport transport);
	
};

}}

namespace task { namespace app { 

using namespace ::byps;

class BServer_Taskapp;
typedef byps_ptr<BServer_Taskapp> PServer_Taskapp;

class BServer_Taskapp : public BServer { 

	public: static PServer_Taskapp createServer(PTransportFactory transportFactory);
	
	public: static PServer_Taskapp createServerR(PTransport transport);
	
	protected: BServer_Taskapp(PTransportFactory transportFactory); 
	
	protected: BServer_Taskapp(PTransport transport); 
	
};

}}


#endif
