using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BStub_TaskService : BStub, TaskService, BSerializable {	
		
		public readonly static long serialVersionUID = 216769899L;
		
		public BStub_TaskService(BTransport transport)
			: base(transport) {}			
		
		public virtual Token Login(String name, String pwd) {
			BSyncResult<Token> asyncResult = new BSyncResult<Token>();			
			Login(name, pwd, BAsyncResultHelper.ToDelegate<Token>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void Login(String name, String pwd, BAsyncResult<Token> asyncResult) {
			BRequest_TaskService_login req = new BRequest_TaskService_login();			
			req.nameValue = name;
			req.pwdValue = pwd;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual void Logout(Token token) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			Logout(token, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void Logout(Token token, BAsyncResult<Object> asyncResult) {
			BRequest_TaskService_logout req = new BRequest_TaskService_logout();			
			req.tokenValue = token;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual void AddTask(Token token, TaskInfo task) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			AddTask(token, task, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void AddTask(Token token, TaskInfo task, BAsyncResult<Object> asyncResult) {
			BRequest_TaskService_addTask req = new BRequest_TaskService_addTask();			
			req.tokenValue = token;
			req.taskValue = task;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual void RemoveTask(Token token, long taskId) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			RemoveTask(token, taskId, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void RemoveTask(Token token, long taskId, BAsyncResult<Object> asyncResult) {
			BRequest_TaskService_removeTask req = new BRequest_TaskService_removeTask();			
			req.tokenValue = token;
			req.taskIdValue = taskId;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual IList<TaskInfo> GetTasks(Token token) {
			BSyncResult<IList<TaskInfo>> asyncResult = new BSyncResult<IList<TaskInfo>>();			
			GetTasks(token, BAsyncResultHelper.ToDelegate<IList<TaskInfo>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetTasks(Token token, BAsyncResult<IList<TaskInfo>> asyncResult) {
			BRequest_TaskService_getTasks req = new BRequest_TaskService_getTasks();			
			req.tokenValue = token;
			transport.sendMethod(req, asyncResult);
		}
		
		
	}
}
