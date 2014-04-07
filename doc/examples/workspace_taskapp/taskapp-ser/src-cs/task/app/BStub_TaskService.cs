using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class BStub_TaskService : BStub, TaskService, BSerializable {	
		
		public readonly static long serialVersionUID = 216769899L;
		
		public BStub_TaskService(BTransport transport)
			: base(transport) {}			
		
		public virtual void AddTask(TaskInfo task) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			AddTask(task, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void AddTask(TaskInfo task, BAsyncResult<Object> asyncResult) {
			BRequest_TaskService_addTask req = new BRequest_TaskService_addTask();			
			req.taskValue = task;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual void RemoveTask(long taskId) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			RemoveTask(taskId, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void RemoveTask(long taskId, BAsyncResult<Object> asyncResult) {
			BRequest_TaskService_removeTask req = new BRequest_TaskService_removeTask();			
			req.taskIdValue = taskId;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual IList<TaskInfo> GetTasks() {
			BSyncResult<IList<TaskInfo>> asyncResult = new BSyncResult<IList<TaskInfo>>();			
			GetTasks(BAsyncResultHelper.ToDelegate<IList<TaskInfo>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetTasks(BAsyncResult<IList<TaskInfo>> asyncResult) {
			BRequest_TaskService_getTasks req = new BRequest_TaskService_getTasks();			
			transport.sendMethod(req, asyncResult);
		}
		
		
	}
}
