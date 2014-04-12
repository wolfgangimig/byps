package task.app.srv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import task.app.BSkeleton_TaskService;
import task.app.TaskInfo;
import byps.RemoteException;

public class TaskServiceImpl extends BSkeleton_TaskService {
	
	private String userName;
	private static HashMap<String, ArrayList<TaskInfo>> tasksOfAllUsers = new HashMap<String, ArrayList<TaskInfo>>();
	
	public TaskServiceImpl(String userName) {
		this.userName = "Fritz"; //userName;
	}

	@Override
	public void addTask(TaskInfo task) throws RemoteException {
		synchronized(tasksOfAllUsers) {
			ArrayList<TaskInfo> tasksOfUser = tasksOfAllUsers.get(task.getUserName());
			if (tasksOfUser == null) {
				tasksOfAllUsers.put(task.getUserName(), tasksOfUser = new ArrayList<TaskInfo>()); 
			}
			tasksOfUser.add(task);
		}
	}

	@Override
	public void removeTask(long taskId) throws RemoteException {
		synchronized(tasksOfAllUsers) {
			ArrayList<TaskInfo> tasksOfUser = tasksOfAllUsers.get(this.userName);
			if (tasksOfUser != null) {
				for (int i = 0; i < tasksOfUser.size(); i++) {
					if (tasksOfUser.get(i).getId() == taskId) {
						tasksOfUser.remove(i);
						break;
					}
				}
			}
		}
	}

	@Override
	public List<TaskInfo> getTasks() throws RemoteException {
		synchronized(tasksOfAllUsers) {
			ArrayList<TaskInfo> tasksOfUser = tasksOfAllUsers.get(userName);
			if (tasksOfUser == null) {
				tasksOfAllUsers.put(this.userName, tasksOfUser = new ArrayList<TaskInfo>()); 
			}
			return tasksOfUser;
		}
	}

}
