package task.app.client;

import java.util.List;

import task.app.BApiDescriptor_Taskapp;
import task.app.BClient_Taskapp;
import task.app.TaskInfo;
import byps.BTransportFactory;
import byps.BWire;
import byps.RemoteException;
import byps.http.HTransportFactoryClient;
import byps.http.HWireClient;

public class TaskappMain {
	
	
	public final static void main(String[] args) {
	
		String url = "http://localhost:8080/taskapp-srv/taskapp";
		BClient_Taskapp bclient = null;
		
		try {
			bclient = connect(url);
			System.out.println("connected, targetId=" + bclient.getTransport().getTargetId());

			String command = args.length > 0 ? args[0] : "";
			if (command.equals("-add")) {
				addTask(bclient, args);
			}
			else if (command.equals("-remove")) {
				removeTask(bclient, args);
			}
			else if (command.equals("-list")) {
				listTasks(bclient);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (bclient != null) {
				bclient.done();
			}
		}
	}
	
	private static BClient_Taskapp connect(String url) throws RemoteException {
		BWire wire = new HWireClient(url, 0, 120, null);
		BTransportFactory tfact = new HTransportFactoryClient(BApiDescriptor_Taskapp.instance(), wire, 1);
		BClient_Taskapp bclient = BClient_Taskapp.createClient(tfact);
		bclient.start();
		return bclient;
	}
	
	private static void addTask(BClient_Taskapp bclient, String[] args) throws RemoteException {
		TaskInfo t = new TaskInfo();
		t.setId((int)(System.currentTimeMillis() % 1000));
		t.setUserName(args[1]);
		t.setTodo(args[2]);
		t.setDueDate(new java.util.Date(System.currentTimeMillis() + 24*60*60*1000));
		bclient.getTaskService().addTask(t);
	}
	
	private static void removeTask(BClient_Taskapp bclient, String[] args) throws RemoteException {
		int taskId = Integer.valueOf(args[1]);
		bclient.getTaskService().removeTask(taskId);
	}
	
	private static void listTasks(BClient_Taskapp bclient) throws RemoteException {
		List<TaskInfo> tasks = bclient.getTaskService().getTasks();
		System.out.println("id\tuser\ttodo");
		for (TaskInfo t : tasks) {
			System.out.println("id=" + t.getId() + 
					"\tuserName=" + t.getUserName() + 
					"\ttoDo=" + t.getTodo());
		}
	}
}
