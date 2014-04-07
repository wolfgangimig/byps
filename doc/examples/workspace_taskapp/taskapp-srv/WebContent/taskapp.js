/**
 * ----------------------------------------------
 * Declare packages.
 * ----------------------------------------------
*/
var task = task || {};
task.app = task.app || {};

/**
 * ----------------------------------------------
 * API Descriptor
 * ----------------------------------------------
*/
task.app.BApiDescriptor_Taskapp = {
	/**
	 * API serialisation version: 1.0.0.0
	 */
	VERSION : "1.0.0.0",
	
	/**
	 * Internal used API Desciptor.
	*/
	instance : function() {
		return new byps.BApiDescriptor(
			"Taskapp",
			"task.app",
			"1.0.0.0",
			false, // uniqueObjects
			new task.app.BRegistry_Taskapp()
		);
	}
};


/**
 * ----------------------------------------------
 * Client class
 * ----------------------------------------------
*/

task.app.createClient_Taskapp = function(transportFactory) {
	return new task.app.BClient_Taskapp(transportFactory);
};

task.app.BClient_Taskapp = function(transportFactory) { 

	this.transport = transportFactory.createClientTransport();
	
	this._serverR = transportFactory.createServerR(
		new task.app.BServer_Taskapp(transportFactory.createServerTransport())
	);
	
	this.taskService = new task.app.BStub_TaskService(this.transport);
};
task.app.BClient_Taskapp.prototype = new byps.BClient();


/**
 * ----------------------------------------------
 * API value classes
 * ----------------------------------------------
*/

/**
*/
task.app.TaskInfo = function(id, userName, dueDate, todo) {
	this._typeId = 1660464439;
	this.id = id || 0;
	this.userName = userName || "";
	this.dueDate = dueDate || null;
	this.todo = todo || "";
};



/**
 * ----------------------------------------------
 * API constant types
 * ----------------------------------------------
*/


/**
 * ----------------------------------------------
 * API constants
 * ----------------------------------------------
*/


/**
 * ----------------------------------------------
 * Skeleton classes
 * ----------------------------------------------
*/


/**
 * ----------------------------------------------
 * Stub classes
 * ----------------------------------------------
*/

/**
*/
task.app.BStub_TaskService = function(transport) {
	
	this._typeId = 216769899;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
task.app.BStub_TaskService.prototype.addTask = function(task, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1498136965, task : task };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
task.app.BStub_TaskService.prototype.removeTask = function(taskId, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1265487020, taskId : taskId };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
task.app.BStub_TaskService.prototype.getTasks = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 280075325 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};


/**
 * ----------------------------------------------
 * Server class
 * ----------------------------------------------
*/

task.app.BServer_Taskapp = function(transport) { 

	this.transport = transport;
	this._remotes = {};
	
	this._methodMap = {
		
		// Remote Interface TaskService			
			// Method addTask
			1498136965 : [ // _typeId of request class
				216769899, // _typeId of remote interface
				1766349022, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_addTask(methodObj.task, methodResult);
				}
			],
			
			// Method removeTask
			1265487020 : [ // _typeId of request class
				216769899, // _typeId of remote interface
				1766349022, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_removeTask(methodObj.taskId, methodResult);
				}
			],
			
			// Method getTasks
			280075325 : [ // _typeId of request class
				216769899, // _typeId of remote interface
				2101800006, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getTasks(methodResult);
				}
			],
		
	};
};
task.app.BServer_Taskapp.prototype = new byps.BServer();


/**
 * ----------------------------------------------
 * Registry
 * ----------------------------------------------
*/

task.app.BRegistry_Taskapp = function() { 
	
	this._serializerMap = {
		
		// java.util.List<task.app.TaskInfo>
		1182472339 : new byps.BSerializerArray(
			1660464439, // Element type: task.app.TaskInfo
			1
		),
		
		// task.app.BRequest_TaskService_addTask
		1498136965 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"task":1660464439 // task.app.TaskInfo
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// task.app.BRequest_TaskService_getTasks
		280075325 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// task.app.BRequest_TaskService_removeTask
		1265487020 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"taskId":6 // long
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// task.app.BResult_1182472339
		2101800006 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1182472339 // java.util.List<task.app.TaskInfo>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1182472339 // java.util.List<task.app.TaskInfo>
			},
			// inlineInstance
			false
		),
		
		// task.app.BResult_19
		1766349022 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":19 // void
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// task.app.BStub_TaskService
		216769899 : new byps.BSerializerRemote(task.app.BStub_TaskService),
		
		// task.app.TaskInfo
		1660464439 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"id":5, // int
				// names of persistent elements
				"userName":10, // java.lang.String
				// names of persistent elements
				"dueDate":17, // java.util.Date
				// names of persistent elements
				"todo":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"dueDate":17, // java.util.Date
			},
			// inlineInstance
			false
		),
	};
};
task.app.BRegistry_Taskapp.prototype = new byps.BRegistry();
