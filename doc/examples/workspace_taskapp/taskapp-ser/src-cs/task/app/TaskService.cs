using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface TaskService : BRemote {
	
		Token Login(String name, String pwd);
		void Login(String name, String pwd, BAsyncResult<Token> asyncResult) ;
		
		void Logout(Token token);
		void Logout(Token token, BAsyncResult<Object> asyncResult) ;
		
		void AddTask(Token token, TaskInfo task);
		void AddTask(Token token, TaskInfo task, BAsyncResult<Object> asyncResult) ;
		
		void RemoveTask(Token token, long taskId);
		void RemoveTask(Token token, long taskId, BAsyncResult<Object> asyncResult) ;
		
		IList<TaskInfo> GetTasks(Token token);
		void GetTasks(Token token, BAsyncResult<IList<TaskInfo>> asyncResult) ;
		
		
	}
}  // end namespace
