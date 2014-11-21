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
byps.ureq.BApiDescriptor_UtilityRequests = {
	/**
	 * API serialisation version: 0.0.0.1
	 */
	VERSION : "0.0.0.1",
	
	/**
	 * Internal used API Desciptor.
	*/
	instance : function() {
		return new byps.BApiDescriptor(
			"UtilityRequests",
			"byps.ureq",
			"0.0.0.1",
			false, // uniqueObjects
			new byps.ureq.BRegistry_UtilityRequests()
		);
	}
};


/**
 * ----------------------------------------------
 * Client class
 * ----------------------------------------------
*/

byps.ureq.createClient_UtilityRequests = function(transportFactory) {
	return new byps.ureq.BClient_UtilityRequests(transportFactory);
};

byps.ureq.BClient_UtilityRequests = function(transportFactory) { 

	this.transport = transportFactory.createClientTransport();
	
	this._serverR = transportFactory.createServerR(
		new byps.ureq.BServer_UtilityRequests(transportFactory.createServerTransport())
	);
	
	this.utilityRequests = new byps.ureq.BStub_UtilityRequests(this.transport);
};
byps.ureq.BClient_UtilityRequests.prototype = new byps.BClient();


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
*/
byps.ureq.BStub_UtilityRequests = function(transport) {
	
	this._typeId = 363558736;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.ureq.BStub_UtilityRequests.prototype.cancelMessage = function(messageId, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 648161469, messageId : messageId };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};


/**
 * ----------------------------------------------
 * Server class
 * ----------------------------------------------
*/

byps.ureq.BServer_UtilityRequests = function(transport) { 

	this.transport = transport;
	this._remotes = {};
	
	this._methodMap = {
		
		// Remote Interface UtilityRequests			
			// Method cancelMessage
			648161469 : [ // _typeId of request class
				363558736, // _typeId of remote interface
				1845498599, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_cancelMessage(methodObj.messageId, methodResult);
				}
			],
		
	};
};
byps.ureq.BServer_UtilityRequests.prototype = new byps.BServer();


/**
 * ----------------------------------------------
 * Registry
 * ----------------------------------------------
*/

byps.ureq.BRegistry_UtilityRequests = function() { 
	
	this._serializerMap = {
		
		// byps.ureq.BRequest_UtilityRequests_cancelMessage
		648161469 : new byps.BSerializer(
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
		
		// byps.ureq.BStub_UtilityRequests
		363558736 : new byps.BSerializer_16(byps.ureq.BStub_UtilityRequests),
	};
};
byps.ureq.BRegistry_UtilityRequests.prototype = new byps.BRegistry();
