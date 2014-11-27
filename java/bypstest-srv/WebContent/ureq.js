/**
 * ----------------------------------------------
 * Declare packages.
 * ----------------------------------------------
*/
var byps = byps || {};
byps.ureq = byps.ureq || {};

/**
 * ----------------------------------------------
 * API Descriptor
 * ----------------------------------------------
*/
byps.ureq.BApiDescriptor_BUtilityRequests = {
	/**
	 * API serialisation version: 0.0.0.1
	 */
	VERSION : "0.0.0.1",
	
	/**
	 * Internal used API Desciptor.
	*/
	instance : function() {
		return new byps.BApiDescriptor(
			"BUtilityRequests",
			"byps.ureq",
			"0.0.0.1",
			false, // uniqueObjects
			new byps.ureq.BRegistry_BUtilityRequests()
		);
	}
};


/**
 * ----------------------------------------------
 * Client class
 * ----------------------------------------------
*/

byps.ureq.createClient_BUtilityRequests = function(transportFactory) {
	return new byps.ureq.BClient_BUtilityRequests(transportFactory);
};

byps.ureq.BClient_BUtilityRequests = function(transportFactory) { 

	this.transport = transportFactory.createClientTransport();
	
	this._serverR = transportFactory.createServerR(
		new byps.ureq.BServer_BUtilityRequests(transportFactory.createServerTransport())
	);
	
	this.bUtilityRequests = new byps.ureq.BStub_BUtilityRequests(this.transport);
};
byps.ureq.BClient_BUtilityRequests.prototype = new byps.BClient();


/**
 * ----------------------------------------------
 * API value classes
 * ----------------------------------------------
*/


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
 * Interface with internally used utility functions.
 * Hint: This API does not support versioning.
*/
byps.ureq.BStub_BUtilityRequests = function(transport) {
	
	this._typeId = 174367442;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.ureq.BStub_BUtilityRequests.prototype.cancelMessage = function(messageId, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1828952285, messageId : messageId };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.ureq.BStub_BUtilityRequests.prototype.testAdapter = function(functionName, params, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 421787891, functionName : functionName, params : params };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.ureq.BStub_BUtilityRequests.prototype.execute = function(functionName, params, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2048473051, functionName : functionName, params : params };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};


/**
 * ----------------------------------------------
 * Server class
 * ----------------------------------------------
*/

byps.ureq.BServer_BUtilityRequests = function(transport) { 

	this.transport = transport;
	this._remotes = {};
	
	this._methodMap = {
		
		// Remote Interface BUtilityRequests			
			// Method cancelMessage
			1828952285 : [ // _typeId of request class
				174367442, // _typeId of remote interface
				1845498599, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_cancelMessage(methodObj.messageId, methodResult);
				}
			],
			
			// Method testAdapter
			421787891 : [ // _typeId of request class
				174367442, // _typeId of remote interface
				60626368, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_testAdapter(methodObj.functionName, methodObj.params, methodResult);
				}
			],
			
			// Method execute
			2048473051 : [ // _typeId of request class
				174367442, // _typeId of remote interface
				60626368, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_execute(methodObj.functionName, methodObj.params, methodResult);
				}
			],
		
	};
};
byps.ureq.BServer_BUtilityRequests.prototype = new byps.BServer();


/**
 * ----------------------------------------------
 * Registry
 * ----------------------------------------------
*/

byps.ureq.BRegistry_BUtilityRequests = function() { 
	
	this._serializerMap = {
		
		// byps.ureq.BRequest_BUtilityRequests_cancelMessage
		1828952285 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"messageId":6 // long
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.ureq.BRequest_BUtilityRequests_execute
		2048473051 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"functionName":10, // java.lang.String
				// names of persistent elements
				"params":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"params":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.ureq.BRequest_BUtilityRequests_testAdapter
		421787891 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"functionName":10, // java.lang.String
				// names of persistent elements
				"params":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"params":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.ureq.BResult_1710660846
		60626368 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.ureq.BResult_19
		1845498599 : new byps.BSerializer(
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
		
		// byps.ureq.BStub_BUtilityRequests
		174367442 : new byps.BSerializer_16(byps.ureq.BStub_BUtilityRequests),
		
		// java.util.Map<String,String>
		1710660846 : new byps.BSerializerMap(
			10 // Element type: String
		),
	};
};
byps.ureq.BRegistry_BUtilityRequests.prototype = new byps.BRegistry();
