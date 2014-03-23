//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class TaskInfo : BSerializable
	{
	
		#region Constructors
		
		public TaskInfo() {
		}		
		
		public TaskInfo(int @id, String @userName, DateTime @dueDate, String @todo) {
			this.idValue = @id;
			this.userNameValue = @userName;
			this.dueDateValue = @dueDate;
			this.todoValue = @todo;
		}		
		
		public TaskInfo(TaskInfo rhs)
		{
			this.idValue = rhs.idValue;
			this.userNameValue = rhs.userNameValue;
			this.dueDateValue = rhs.dueDateValue;
			this.todoValue = rhs.todoValue;
		}		
		
		#endregion
		
		#region Properties
		
		public int Id
		{
			get
			{
				return idValue;
			}
			set
			{
				this.idValue = value;
			}
		}
		
		
		public String UserName
		{
			get
			{
				return userNameValue;
			}
			set
			{
				this.userNameValue = value;
			}
		}
		
		
		public DateTime DueDate
		{
			get
			{
				return dueDateValue;
			}
			set
			{
				this.dueDateValue = value;
			}
		}
		
		
		public String Todo
		{
			get
			{
				return todoValue;
			}
			set
			{
				this.todoValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int idValue;

		protected String userNameValue;

		protected DateTime dueDateValue;

		protected String todoValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1660464439L;		
	} // end class
}  // end namespace
