package task.app;

import java.util.List;

import byps.BRemote;
import byps.RemoteException;

public interface TaskService extends BRemote {

	Token login(String name, String pwd) throws RemoteException;
	
	void logout(Token token) throws RemoteException;
	
	void addTask(Token token, TaskInfo task) throws RemoteException;
	
	void removeTask(Token token, long taskId) throws RemoteException;
	
	List<TaskInfo> getTasks(Token token) throws RemoteException;
	
}
