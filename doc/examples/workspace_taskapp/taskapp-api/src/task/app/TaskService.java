package task.app;

import java.util.List;

import byps.BRemote;
import byps.RemoteException;

public interface TaskService extends BRemote {

	void addTask(TaskInfo task) throws RemoteException;
	
	void removeTask(long taskId) throws RemoteException;
	
	List<TaskInfo> getTasks() throws RemoteException;
	
}
