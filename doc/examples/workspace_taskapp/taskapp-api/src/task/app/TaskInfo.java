package task.app;

import java.io.Serializable;
import java.util.Date;

public class TaskInfo implements Serializable {

	private static final long serialVersionUID = 3264907623228026167L;

	protected int id;
	
	protected String userName;
	
	protected Date dueDate;

	protected String todo;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	
	
}
