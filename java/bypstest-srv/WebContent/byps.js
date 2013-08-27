var com = com || {};
com.wilutions = com.wilutions || {};
com.wilutions.byps = com.wilutions.byps || {};

// ------------------------------------------------------------------------------------------------

com.wilutions.byps.BBinaryModel = function(v) {
	this.MEDIUM = "MEDIUM";
	this.JSON = "JSON";
	
	this._value = v;
	
	this.equals = function(rhs) {
		return this._value == rhs._value;
	};
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BException = function(code, msg, details, cause) {
	this._typeId = 20;
	this.code = code;
	this.msg = msg;
	this.details = details;
	this.cause = cause;
};

com.wilutions.byps.BException.prototype.toString = function() {
	var s = "[BYPS:" + this.code + "]";
	if (this.msg) s += "[" + this.msg + "]";
	if (this.details) s += "[" + this.details + "]";
	return s;
};

com.wilutions.byps.throwExceptionFromStream = function(data) {
	var ex = data;
	if (data._typeId == 20) {
		ex = new com.wilutions.byps.BException(data.code, data.msg, data.details, data.cause);
	}
	throw ex;
};

com.wilutions.byps.throwBException = function(code, msg, details, cause) {
	throw new com.wilutions.byps.BException(code, msg, details, cause);
};

com.wilutions.byps.throwCORRUPT = function(msg, details) {
	throw new com.wilutions.byps.BException(com.wilutions.byps.BExceptionC.CORRUPT, msg, details);
};

com.wilutions.byps.throwIOERROR = function(msg, details) {
	throw new com.wilutions.byps.BException(com.wilutions.byps.BExceptionC.IOERROR, msg, details);
};

com.wilutions.byps.throwUNSUPPORTED = function(msg, details) { 
	throw new com.wilutions.byps.BException(com.wilutions.byps.BExceptionC.UNSUPPORTED_METHOD, msg, details);
};

com.wilutions.byps.throwINTERNAL = function(msg, details) { 
	throw new com.wilutions.byps.BException(com.wilutions.byps.BExceptionC.INTERNAL, msg, details);
};

com.wilutions.byps.BExceptionC = {
	INTERNAL : 3,
	CORRUPT : 8,
	IOERROR : 14,
	SERVICE_NOT_IMPLEMENTED : 11,
	UNSUPPORTED_METHOD : 17,
	REMOTE_ERROR : 10,
};

com.wilutions.byps.BContentStream = function(streamId) {
	this._typeId = 15;
	this.streamId = streamId;
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BSerializer = function(persistentNames, inlineNames, inlineInstance) {
	
	this.inlineInstance = inlineInstance;
	
	this.write = function(obj, bout) {
		for (var ename in obj) {
			if (ename == '_typeId' || ename == '*i' || !obj.hasOwnProperty(ename)) {
				continue;
			}

			if (inlineNames) {
				var typeId = inlineNames[ename];
				if (typeId) {
					var ser = bout.registry.getSerializer(typeId);
					bout.writeElement(obj, ename, ser);
					continue;
				}
			}
			
			if (!persistentNames || persistentNames[ename]) {
				bout.writeElement(obj, ename);
				continue;
			}

			bout.saveTransient(obj, ename);
		}
	};
	
	this.read = function(obj, bin) {
		
		for (var ename in obj) {

			if (ename == '_typeId' || ename == '*i' || !obj.hasOwnProperty(ename)) {
				continue;
			}

			if (inlineNames) {
				var typeId = inlineNames[ename];
				if (typeId) {
					var ser = bin.registry.getSerializer(typeId);
					bin.readElement(obj, ename, ser);
					continue;
				}
			}
			
			if (!persistentNames || persistentNames[ename]) {
				bin.readElement(obj, ename);
				continue;
			}
		}
		
		return obj;
	};
	
};

//------------------------------------------------------------------------------------------------
//Serializer for arrays

com.wilutions.byps.BSerializerArray = function(elementTypeId, nbOfDimensions) {

	var elementSerializer = undefined;

	var writeDim = function(obj, dim, bout, ser) {
		if (dim == 1) {
			for (var i = 0; i < obj.length; i++) {
				bout.writeElement(obj, i, ser);
			}
		}
		else {
			for (var i = 0; i < obj.length; i++) {
				writeDim(obj[i], dim-1, bout, ser);
			}
		}
	};
	
	var getElementSerializer = function(registry) {
		if (elementSerializer === undefined) {
			elementSerializer = registry.getSerializer(elementTypeId);
		}
		return elementSerializer;
	};
	
	this.write = function(obj, bout) {
		var ser = getElementSerializer(bout.registry);
		writeDim(obj, nbOfDimensions, bout, ser);
	};
	
	var readDim = function(obj, dim, bin, ser) {
		if (dim == 1) {
			for (var i = 0; i < obj.length; i++) {
				bin.readElement(obj, i, ser);
			}
		}
		else {
			for (var i = 0; i < obj.length; i++) {
				readDim(obj[i], dim-1, bin, ser);
			}
		}
	};
	
	this.read = function(obj, bin) {
		var ser = getElementSerializer(bin.registry);
		readDim(obj, nbOfDimensions, bin, ser);
		return obj;
	};
	
};

//------------------------------------------------------------------------------------------------
//Serializer for Map

com.wilutions.byps.BSerializerMap = function(valueTypeId) {

	var valueSerializer = undefined;

	var getValueSerializer = function(registry) {
		if (valueSerializer === undefined) {
			valueSerializer = registry.getSerializer(valueTypeId);
		}
		return valueSerializer;
	};
	
	this.write = function(obj, bout) {
		var ser = getValueSerializer(bout.registry);
		for (var ename in obj) {
			if (ename == '_typeId' || ename == '*i' || !obj.hasOwnProperty(ename)) {
				continue;
			}
			bout.writeElement(obj, ename, ser);
		}		
	};
	
	this.read = function(obj, bin) {
		var ser = getValueSerializer(bin.registry);
		for (var ename in obj) {
			if (ename == '_typeId' || ename == '*i' || !obj.hasOwnProperty(ename)) {
				continue;
			}
			bin.readElement(obj, ename, ser);
		}		
		return obj;
	};
	
};

//------------------------------------------------------------------------------------------------
//Serializer for streams

com.wilutions.byps.BSerializer_15 = function() {
	
	this.write = function(obj, bout) {
	};
	
	this.read = function(obj, bin) {
		obj.url = bin.transport.wire.rurl + "?messageid=" + bin.header.messageId + "&streamid=" + obj.streamId;
		return obj;
	};
	
};
com.wilutions.byps.BSerializer_15.prototype = new com.wilutions.byps.BSerializer();

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BSerializerRemote = function(clazz) {
	
	// When sending a remote, internal members are omitted.
	// The remote has a toJSON method that creates an 
	// object that merly contains the type ID and the target ID.

	this.write = function(obj, bout) {
	};
	
	this.read = function(obj, bin) {
		if (obj.constructor !== Object) return obj;
		var transport = new com.wilutions.byps.BTransport(bin.transport.apiDesc, bin.transport.wire, obj.targetId);
		obj = new clazz(transport);
		return obj;
	};
	
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BRegistry = function() {
	
	// sublcass has to implement:
	// this._serializerMap
	
	this.getSerializer = function(typeId) {
		
		var ser = null;
		if (typeId == 15) {
			ser = this._streamSerializer;
		}
		else if (typeId == 20) {
			ser = this._defaultSerializer;
		}
		else if (typeId >= 64) {
			ser = this._serializerMap[typeId];
		}
		
		ser = ser || this._defaultSerializer;
		return ser;
	};
	
	this._defaultSerializer = new com.wilutions.byps.BSerializer();
	this._streamSerializer = new com.wilutions.byps.BSerializer_15();
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BApiDescriptor = function(name, basePackage, version, uniqueObjects, registry) {
	this.name = name;
	this.basePackage = basePackage;
	this.version = version;
	this.uniqueObjects = uniqueObjects;
	this.protocols = "J";
	this.registry = registry;
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BNegotiate = function(apiDesc) {
	this.JSON = "J";
	
	this.protocols = this.JSON;
	this.version = apiDesc.version;
	this.targetId = "";
	
	this.isNegotiateMessage = function(buf) {
		return buf.indexOf("[\"N\"") == 0;
	};
	
	this.toArray = function() {
		return ["N","J",this.version,"_", this.targetId ];
	};
	
	this.fromArray = function(arr) {
    	if (!arr || arr.length < 5 || arr[0] != "N") throw new com.wilutions.byps.BException(com.wilutions.byps.BException_CORRUPT, "Invalid negotiate message.");
		this.targetId = arr[4];
	};
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BStreamRequest = function() {
	this.streamId = "";
	this.messageId = "";
	
	// JavaScript kennt keinen InputStream.
	// Man könnte hier mit HTML 5 Blobs arbeiten. Die sind aber noch sehr neu.
	// Statt des InputStream nehme ich für 
	// den Download eine URL,
	// den Upload die Stream-ID.
	// Die Download-URL wird beim Deserialisieren aus messageId und streamId gebildet.
	// Das Hochladen erfolgt über das HTML-file-Formular. Als Antwort wird eine vom Server 
	// gebildete streamId zurückgegeben. Diese Stream-ID nehme ich als "InputStream".
	
	this.downloadUrl = ""; 
	this.uploadResult = "";
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BMessage = function(jsonText, streams) {
	this.jsonText = jsonText; // Message object to be send: { header: [ ... message header ... ], objectTable: [ ] }
	this.streams = streams || []; // Array of BStreamRequest
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BMessageHeader = function(messageId_or_rhs) {
    
    this.error = 0;
    this.flags = 0;
    this.targetId = "";
    this.messageId = "";

    if (typeof messageId_or_rhs == 'string') {
    	this.messageId = messageId_or_rhs;
    } else {
	    this.error = messageId_or_rhs.error;
	    this.flags = messageId_or_rhs.flags;
	    this.messageId = messageId_or_rhs.messageId;
	    this.targetId = messageId_or_rhs.targetId;
    }
    
    this.createResponse = function(rhs) {
    	rhs = rhs || this;
    	var resp = rhs.clone();
    	return resp;
    };

 };
 
 com.wilutions.byps.BMessageHeaderC = {
		 FLAG_RESPONSE : 2
 };


//------------------------------------------------------------------------------------------------
// This is how an asyncResult function has to be defined.
com.wilutions.byps.BAsyncResult = function(result, exception) {
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BWireClient = function(rurl, flags, timeoutSeconds) {
	
	var me = this;
	this.rurl = rurl;
	this.flags = flags || 0;
	
	this.timeoutMillisClient = timeoutSeconds ? (timeoutSeconds * 1000) : (-1);
	
	this.openRequestsToCancel = {};
		
	// Send function.
	// The streams are already sent by a HTML file upload.
	this.send = function(requestMessage, asyncResult) {
		return this._internalSend(requestMessage, asyncResult, this.timeoutMillisClient);
	};
	
	this.sendR = function(requestMessage, asyncResult) {
		return this._internalSend(requestMessage, asyncResult, 60 * 60 * 1000);
	};

	this._internalSend = function(requestMessage, asyncResult, timeoutMillis) {
		var requestId = Math.random();
		var xhr = new XMLHttpRequest();
		
		this.openRequestsToCancel[requestId] = xhr;
		
		xhr.open('POST', me.rurl, !!asyncResult);
		
		if (timeoutMillis > 0) {
			xhr.timeout = timeoutMillis;
		}
		
		if (asyncResult) {
			xhr.onreadystatechange = function() {
				if (xhr.readyState != 4) return;
				
				delete me.openRequestsToCancel[requestId];
				
				if (xhr.status = 200) {
					var responseMessage = new com.wilutions.byps.BMessage();
					responseMessage.jsonText = xhr.responseText; // msg.jsonText = { header: [ ... message header ... ], objectTable: [ ] }
					asyncResult(responseMessage, null);
				} else {
					var ex = com.wilutions.byps.throwIOERROR("HTTP status " + this.status, xhr.responseText);
					asyncResult(null, ex);
				}; 
			};
		}
		
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(requestMessage.jsonText);
		
		var ret = new com.wilutions.byps.BMessage();
		
		if (!asyncResult) {
			
			delete me.openRequestsToCancel[requestId];
			
			if (xhr.status == 200) {
				ret.jsonText = xhr.responseText; // msg.jsonText = { header: [ ... message header ... ], objectTable: [ ] }
			} else {
				var ex = com.wilutions.byps.throwIOERROR("HTTP status " + xhr.status, xhr.responseText);
				throw ex;
			}
		}
		
		return ret;
	};
	
	this.makeMessageId = function() {
		var v1 =  Math.floor(Math.random() * Math.pow(10, 17));  
		return v1.toString();
	};
	
	this.cancelAllRequests = function() {
		for (requestId in this.openRequestsToCancel) {
			var xhr = this.openRequestsToCancel[requestId];
			xhr.abort();
		}
		this.openRequestsToCancel = {};
	};
	
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BTransport = function(apiDesc, wire, targetId) {
	
	var me = this;
	
	this.apiDesc = apiDesc;
	this.wire = wire;
	this.targetId = targetId || "";
	
	this.getOutput = function() {
		return new com.wilutions.byps.BInputOutput(this);
	};
	
	this.getResponse = function(requestHeader) {
		var responseHeader = new com.wilutions.byps.BMessageHeader(requestHeader);
		responseHeader.flags |= com.wilutions.byps.BMessageHeaderC.FLAG_RESPONSE;

		var bout = new com.wilutions.byps.BInputOutput(this, responseHeader);
		return bout;
	};
	
	this.getInput = function(jsonText) {
		return new com.wilutions.byps.BInputOutput(this, null, jsonText);
	};

	this.send = function(obj, asyncResult) {
		
		var transport = this;
		var bout = transport.getOutput();
		var requestMessage = bout.store(obj);
		
		var outerResult = null;
		if (asyncResult) {
			
			outerResult = function(responseMessage, exception) {
				try {
					if (exception) {
						asyncResult(null, exception);
					}
					else {
						var bin = transport.getInput(responseMessage.jsonText);
						var ret = bin.load();
						asyncResult(ret.result, null);
					}
				} catch (ex) {
					asyncResult(null, ex);
				};
			};
		}
		
		var responseMessage = wire.send(requestMessage, outerResult);
		
		var ret = {};
		
		if (!asyncResult) {
			var bin = transport.getInput(responseMessage.jsonText);
			ret = bin.load();
		}
		
		return ret;
	};
	
	this.recv = function(server, requestMessage, asyncResult) {
		var transport = this;
		var bin = this.getInput(requestMessage.jsonText);
		var methodObj = bin.load();
		
		var methodResult = function(obj, exception) {
			try {
				var bout = transport.getResponse(bin.header);
				if (exception) {
					bout.setException(exception);
				} else {
					bout.store(obj);
				};
				var rmsg = bout.toMessage();
				asyncResult(rmsg, null);
			}
			catch (ex) {
				asyncResult(null, ex);
			}
		};
		
		var clientTargetId = bin.header.targetId;
		server.recv(clientTargetId, methodObj, methodResult);
	};
	
	this.negotiateProtocolClient = function(asyncResult) { // BAsyncResult<Boolean>
		var nego = new com.wilutions.byps.BNegotiate(apiDesc);
		var jsonText = JSON.stringify(nego.toArray());
		
		var outerResult = null;
		if (asyncResult) {
			outerResult = function(responseMessage, exception) {
				try {
					if (exception) {
						asyncResult(false, exception);
					}
					else {
						var arr = JSON.parse(responseMessage.jsonText);
						nego.fromArray(arr);
						me.targetId = nego.targetId;
						asyncResult(true, null);
					}
				} catch (ex) {
					asyncResult(false, ex);
				};
			};
		};
		
		var requestMessage = new com.wilutions.byps.BMessage(jsonText);
		
		var responseMessage = wire.send(requestMessage, outerResult);
		if (!asyncResult) {
			var arr = JSON.parse(responseMessage.jsonText);
			nego.fromArray(arr);
			me.targetId = nego.targetId;
		}
		
		return true;
	};
	
	this.createServerR = function(server) {
		return new com.wilutions.byps.BServerR(this, server);
	};
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BInputOutput = function(transport, header, jsonText) {
	
	this.transport = transport;
	this.registry = transport.apiDesc.registry;
	this.header = header || new com.wilutions.byps.BMessageHeader(transport.wire.makeMessageId());
	this.header.targetId = transport.targetId;
	
	this.store = function(root) {
		this._root = root;
		return this.toMessage();
	};
	
	this.setException = function(ex) {
		this.header.error = ex.code || com.wilutions.byps.BExceptionC.REMOTE_ERROR;
		this.store(ex);
	};
	
	this.load = function() {
		var msg = JSON.parse(this._jsonText);
		this.header = msg.header;
		this._objectTable = msg.objectTable;
		this._internalLoad();
		this._root = this._objectTable[1];
		if (this.header.error) {
			com.wilutions.byps.throwExceptionFromStream(this._root);
		}
		return this._root;
	};
	
	this.toMessage = function() {
		
		// Replace object elements with references.
		this._internalStore();
		
		var msgObj = {};
		msgObj.header = this.header;
		msgObj.objectTable = this._objectTable;

		var jsonText = JSON.stringify(msgObj);
		var msg = new com.wilutions.byps.BMessage(jsonText, null);
		
		// BSerializer.write removes transient objects.
		// Restore them ...
		this._restoreTransients();
		
		// Replace references with objects.
		this._internalLoad();
		
		return msg;
	};
	
//	this._isArray = function(obj) {
//		var ret = false;
//		try {
//			ret = Array.isArray(obj); 
//		} catch (ignored) {
//			ret = Object.prototype.toString.call(obj) === '[object Array]';
//		}
//		return ret;
//	};
	
	this.writeElement = function(obj, ename, ser) {
		var elm = obj[ename];
		if (elm && typeof elm === 'object') {
			
			// Inline instance: write object instead of reference to object.
			if (ser && ser.inlineInstance) {
				ser.write(elm, this);
				return;
			}
			
			var id = elm["*i"];
			if (!id) {
				
				// Element was not jet serialized.
				
				// Assign an ID
				id = this._objectTable.length;
				elm["*i"] = id; 
				
				// Put element into the object table
				this._objectTable.push(elm);
				
				// Replace element with reference 
				obj[ename] = { "*i" : -id };
				
				// A serializer is passed, if a set or list class is to be serialized,
				// because the JSON representation of this classes is an array without type information.
				// For all other classes, the serializer is determined by the object's type ID. 
				if (!ser) {
					ser = this.registry.getSerializer(elm._typeId);
					if (!ser) com.wilutions.byps.throwCORRUPT("No serializer for typeId=" + elm._typeId);
				}
				
				var write = ser.write || this.registry._defaultSerializer.write;
				write(elm, this);
			}
			else if (id > 0) {
				// Element has already been serialized, 
				// replace element with reference to object table.
				obj[ename] = { "*i" : -id };
			}
			else { // id < 0
				// Element is already a reference.
			}
		};
	};
	
	this._internalStore = function() {
		this._objectTable.push(null);
		this.writeElement(this, "_root");
		this._removeIds();
	};
	
	this.readElement = function(obj, ename, ser) {
		var elm = obj[ename];
		if (elm && typeof elm === 'object') {

			// Inline instance: read object instead of reference to object.
			if (ser && ser.inlineInstance) {
				ser.read(elm, this);
				return;
			}
			
			// Ein Objekt-Element muss eine Referenz sein. 
			// Andernfalls würden wir einen Serialisierer das zweite mal durchlaufen.
			var id = elm["*i"];
			if (!id || id >= 0) {
				var msg = "Excpecting reference with \"*i\" < 0 but found " + id;
				com.wilutions.byps.throwCORRUPT(msg);
			}
			
			id = -id;
			
			// Objekt zum Element aus der objectTable holen
			elm = this._objectTable[id];
			
			// Wenn es noch keine ID hat, dann wurde es noch nicht deserialisiert.
			// (Objekt is null für ersten Longpoll.)
			if (elm && !elm["*i"]) {
				
				// Gib dem Objekt eine ID, damit ich weiß, dass ich es deserialisiert habe.
				elm["*i"] = id;
				
				if (!ser) {
					ser = this.registry.getSerializer(elm._typeId);
					if (!ser) com.wilutions.byps.throwCORRUPT("No serializer for typeId=" + elm._typeId);
				}
				
				var read = ser.read || this.registry._defaultSerializer.read;
				var nelm = read(elm, this);
				
				// Mglw wurde das Objekt in read ausgetauscht (Stub).
				if (elm !== nelm) {
					elm = nelm;
					elm["*i"] = id;
					this._objectTable[id] = elm;
				}
			}

			obj[ename] = elm;
		};
	};
	
	this._internalLoad = function() {
	    this["_root"] = { "*i" : -1 };
	    this.readElement(this, "_root");
		this._removeIds();
	};
	
	this._restoreTransients = function() {
		for (var i = 0; i < this._restoreInfos.length; i++) {
			var restoreInfo = this._restoreInfos[i];
			var obj = restoreInfo[0];
			var elm = restoreInfo[1];
			var ename = restoreInfo[2];
			obj[ename] = elm;
		}
	};
	
	this.saveTransient = function(obj, ename) {
		var elm = obj[ename];
		if (elm) {
			obj[ename] = undefined;
			this._restoreInfos.push([obj, elm, ename]);
		}
	};
	
	this._removeIds = function() {
		for (var i = 1; i < this._objectTable.length; i++) {
			var obj = this._objectTable[i];
			if (obj) { // obj is null for first longpoll.
				delete obj["*i"];
			}
		}
	};
	
	this._objectTable = [];
	this._streams = [];
	this._root = null;
	this._jsonText = jsonText || "";
	this._restoreInfos = [];
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BClient = function() {
	
	// Implemented by subclass:
	// this.transport;
	// this._serverR;
	
	this.start = function(startServerR, asyncResult) { // BAsyncResult<BClient>
		
		var me = this;
		
		var outerResult = null;
		if (asyncResult) {
			outerResult = function(ignored, exception) {
				try {
					if (!exception && startServerR && this._serverR) {
						serverR.start();
					}
					asyncResult(me, exception);
				} catch (ex) {
					asyncResult(null, ex);
				};
			};
		}
		
		this.transport.negotiateProtocolClient(outerResult);
		
		if (!asyncResult && startServerR && this._serverR) {
			this._serverR.start();
		}
	};
	
	this.stop = function() {
		this.transport.wire.cancelAllRequests();
	};
	
	this.addRemote = function(remoteImpl) {
		var remoteId = remoteImpl._typeId;
		if (!remoteId) {
			com.wilutions.byps.throwBException(com.wilutions.byps.BExceptionC.INTERNAL, "Missing interface type ID. The interface implementation must be inherited from a BSkeleton_ class."); 
		}
		this._serverR.server.addRemote(remoteId, remoteImpl);
	};
};

com.wilutions.byps.BClient_subclass = function(transport, serverR) {
	this.transport = transport;
	this._serverR = serverR;
};

com.wilutions.byps.BClient_subclass.prototype = new com.wilutions.byps.BClient();

// ------------------------------------------------------------------------------------------------

com.wilutions.byps.BTransportFactory = function(apiDesc, wire) {
	
	this._transport = new com.wilutions.byps.BTransport(apiDesc, wire, null);
	
	this.createClientTransport = function() {
		return this._transport;
	};
	this.createServerTransport = function() {
		return this._transport;
	};
	this.createClientR = function(client) {
		return null;
	};
	this.createServerR = function(server) {
		return new com.wilutions.byps.BServerR(this._transport, server);
	};
	
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BServer = function() {

	// Subclass must implement:
//	this.transport = transport;
//	this._remotes = {};
//  this._methodMap = {}; // request_typeId : [remote_typeId, result_typeId, methodFunction]
	
	this.addRemote = function(remoteId, remoteImpl) {
		this._remotes[remoteId] = remoteImpl;
		remoteImpl.transport = this.transport;
	};
		
	this.recv = function(clientTargetId, methodObj, methodResultObj) {
		
		try {
			var requestTypeId = methodObj._typeId;
			var methodItem = this._methodMap[requestTypeId];
			if (!methodItem) {
				com.wilutions.byps.throwUNSUPPORTED("Method not implemented: typeId=" + requestTypeId);
			}
				
			var remoteId = methodItem[0];
			var remote = this._remotes[remoteId];
			if (!remote) {
				com.wilutions.byps.throwBException(com.wilutions.byps.BExceptionC.SERVICE_NOT_IMPLEMENTED, 
						"Service not implemented: remoteId=" + remoteId);
			}
			
			var resultTypeId = methodItem[1];
			
			var methodFnct = methodItem[2];
			
			var methodResult = function(obj, exception) {
				if (exception) {
					methodResultObj(null, exception);
				}
				else {
					var resultObj = { _typeId : resultTypeId, result : obj };
					methodResultObj(resultObj, null);
				}
			};
			
			methodFnct(remote, methodObj, methodResult);
		}
		catch (ex) {
			methodResultObj(null, ex);
		}
		
	};
};

//------------------------------------------------------------------------------------------------

com.wilutions.byps.BServerR = function(transport, server) {
	
	var me = this;
	this.transport = transport;
	this.server = server;
	
	
	this.start = function() {
		var methodResult = this._makeInitMessage();
		this._run(methodResult);
	};
	
	this._run = function(methodResult) {
		
		var asyncResult = function(message, exception) {
			if (exception) {
				var bout = me.transport.getOutput();
				bout.header.flags = com.wilutions.byps.BMessageHeader.FLAG_RESPONSE;
				bout.setException(exception);
				message = bout.toMessage();
			}
			me._run(message);
		};
		
		var nextAsyncMethod = function(message, exception) {
			try {
				if (!exception && message.jsonText) {
					me.transport.recv(me.server, message, asyncResult);
				} else {
					window.setTimeout(function() {
							var methodResult = me._makeInitMessage();
							me._run(methodResult);
						}, 
						60 * 1000);
				}
			} catch (ex) {
				asyncResult(null, ex);
			};
		};
		
		transport.wire.sendR(methodResult, nextAsyncMethod);
	};
	
	this._makeInitMessage = function() {
		var outp = this.transport.getOutput();
		outp.header.flags |= com.wilutions.byps.BMessageHeaderC.FLAG_RESPONSE;
		outp.store(null); 
		return outp.toMessage();
	};
	
	
	this._isDone = false;
};

