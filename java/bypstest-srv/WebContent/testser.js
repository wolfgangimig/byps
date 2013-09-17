/**
 * ----------------------------------------------
 * Declare packages.
 * ----------------------------------------------
*/
var com = com || {};
com.wilutions = com.wilutions || {};
com.wilutions.byps = com.wilutions.byps || {};
com.wilutions.byps.test = com.wilutions.byps.test || {};
com.wilutions.byps.test.api = com.wilutions.byps.test.api || {};
com.wilutions.byps.test.api.arr = com.wilutions.byps.test.api.arr || {};
com.wilutions.byps.test.api.set = com.wilutions.byps.test.api.set || {};
com.wilutions.byps.test.api.enu = com.wilutions.byps.test.api.enu || {};
com.wilutions.byps.test.api.list = com.wilutions.byps.test.api.list || {};
com.wilutions.byps.test.api.ver = com.wilutions.byps.test.api.ver || {};
com.wilutions.byps.test.api.inherit = com.wilutions.byps.test.api.inherit || {};
com.wilutions.byps.test.api.remote = com.wilutions.byps.test.api.remote || {};
com.wilutions.byps.test.api.inl = com.wilutions.byps.test.api.inl || {};
com.wilutions.byps.test.api.prim = com.wilutions.byps.test.api.prim || {};
com.wilutions.byps.test.api.refs = com.wilutions.byps.test.api.refs || {};
com.wilutions.byps.test.api.map = com.wilutions.byps.test.api.map || {};
com.wilutions.byps.test.api.strm = com.wilutions.byps.test.api.strm || {};
com.wilutions.byps.test.api.priv = com.wilutions.byps.test.api.priv || {};
com.wilutions.byps.test.api.auth = com.wilutions.byps.test.api.auth || {};
com.wilutions.byps.test.api.srvr = com.wilutions.byps.test.api.srvr || {};
com.wilutions.byps.test.api.cons = com.wilutions.byps.test.api.cons || {};

/**
 * ----------------------------------------------
 * API Descriptor
 * ----------------------------------------------
*/
com.wilutions.byps.test.api.BApiDescriptor_Testser = {
	/**
	 * API serialisation version: 0.0.0.791
	 */
	VERSION : "0.0.0.791",
	
	/**
	 * Internal used API Desciptor.
	*/
	getInternalInstance : function() {
		return new com.wilutions.byps.BApiDescriptor(
			"Testser",
			"com.wilutions.byps.test.api",
			"0.0.0.791",
			false, // uniqueObjects
			new com.wilutions.byps.test.api.BRegistry_Testser()
		);
	}
};


/**
 * ----------------------------------------------
 * Client class
 * ----------------------------------------------
*/

com.wilutions.byps.test.api.createClient_Testser = function(url, startServerR, asyncResult) {
	var wire = new com.wilutions.byps.BWireClient(url);
	var transportFactory = new com.wilutions.byps.BTransportFactory(com.wilutions.byps.test.api.BApiDescriptor_Testser.getInternalInstance(), wire);
	var client = new com.wilutions.byps.test.api.BClient_Testser(transportFactory);
	client.start(startServerR, asyncResult);
	return client;
};

com.wilutions.byps.test.api.BClient_Testser = function(transportFactory) { 

	this.transport = transportFactory.createClientTransport();
	
	this._serverR = transportFactory.createServerR(
		new com.wilutions.byps.test.api.BServer_Testser(transportFactory.createServerTransport())
	);
	
	this.remoteArrayTypes1dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim(this.transport);
	this.remoteArrayTypes23 = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23(this.transport);
	this.remoteArrayTypes4dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim(this.transport);
	this.remoteConstants = new com.wilutions.byps.test.api.remote.BStub_RemoteConstants(this.transport);
	this.remoteEnums = new com.wilutions.byps.test.api.remote.BStub_RemoteEnums(this.transport);
	this.remoteInlineInstance = new com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance(this.transport);
	this.remoteListTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteListTypes(this.transport);
	this.remoteMapTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes(this.transport);
	this.remotePrimitiveTypes = new com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes(this.transport);
	this.remoteReferences = new com.wilutions.byps.test.api.remote.BStub_RemoteReferences(this.transport);
	this.remoteServerCtrl = new com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl(this.transport);
	this.remoteSetTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes(this.transport);
	this.remoteStreams = new com.wilutions.byps.test.api.remote.BStub_RemoteStreams(this.transport);
	this.remoteWithAuthentication = new com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication(this.transport);
	this.clientIF = new com.wilutions.byps.test.api.srvr.BStub_ClientIF(this.transport);
	this.serverIF = new com.wilutions.byps.test.api.srvr.BStub_ServerIF(this.transport);
	this.evolveIF = new com.wilutions.byps.test.api.ver.BStub_EvolveIF(this.transport);
};
com.wilutions.byps.test.api.BClient_Testser.prototype = new com.wilutions.byps.BClient();


/**
 * ----------------------------------------------
 * API value classes
 * ----------------------------------------------
*/

/**
*/
com.wilutions.byps.test.api.arr.ArrayTypes1dim = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, primitiveTypes1) {
	this._typeId = 2001;
	this.boolean1 = boolean1 || null;
	this.byte1 = byte1 || null;
	this.char1 = char1 || null;
	this.short1 = short1 || null;
	this.int1 = int1 || null;
	this.long1 = long1 || null;
	this.float1 = float1 || null;
	this.double1 = double1 || null;
	this.string1 = string1 || null;
	this.primitiveTypes1 = primitiveTypes1 || null;
};


/**
*/
com.wilutions.byps.test.api.arr.ArrayTypes4dim = function(boolean4, byte4, char4, short4, int4, long4, float4, double4, string4, primitiveTypes4) {
	this._typeId = 2004;
	this.boolean4 = boolean4 || null;
	this.byte4 = byte4 || null;
	this.char4 = char4 || null;
	this.short4 = short4 || null;
	this.int4 = int4 || null;
	this.long4 = long4 || null;
	this.float4 = float4 || null;
	this.double4 = double4 || null;
	this.string4 = string4 || null;
	this.primitiveTypes4 = primitiveTypes4 || null;
};


/**
 * Example for a session class.
 * @see com.wilutions.byps.test.api.remote.RemoteWithAuthentication
*/
com.wilutions.byps.test.api.auth.SessionInfo = function(sessionID) {
	this._typeId = 65775978;
	this.sessionID = sessionID || "";
};


/**
*/
com.wilutions.byps.test.api.cons.AllTypesZ = function(bool1, byte1, char1, short1, int1, long1, float1, double1, string1, hebrew1, byte2, int2, string2, hebrew2) {
	this._typeId = 142458;
	this.bool1 = bool1 || false;
	this.byte1 = byte1 || 0;
	this.char1 = char1 || '';
	this.short1 = short1 || 0;
	this.int1 = int1 || 0;
	this.long1 = long1 || '0.';
	this.float1 = float1 || 0;
	this.double1 = double1 || 0;
	this.string1 = string1 || "";
	this.hebrew1 = hebrew1 || null;
	this.byte2 = byte2 || null;
	this.int2 = int2 || null;
	this.string2 = string2 || null;
	this.hebrew2 = hebrew2 || null;
};


/**
*/
com.wilutions.byps.test.api.cons.HebrewZ = function(core) {
	this._typeId = 1518668429;
	this.core = core || "";
};


/**
*/
com.wilutions.byps.test.api.enu.UsePlanets = function(planet, planet2, arrayOfPlanets, listOfPlanets, mapOfPlanets) {
	this._typeId = 10000;
	this.planet = planet || null;
	this.planet2 = planet2 || null;
	this.arrayOfPlanets = arrayOfPlanets || null;
	this.listOfPlanets = listOfPlanets || null;
	this.mapOfPlanets = mapOfPlanets || null;
};


/**
 * Base class for ...
*/
com.wilutions.byps.test.api.inherit.Class1 = function(int1, nextClass1) {
	this._typeId = 6001;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
};


/**
*/
com.wilutions.byps.test.api.inherit.Class1Collections = function(list1, map1, set1) {
	this._typeId = 6004;
	this.list1 = list1 || null;
	this.map1 = map1 || null;
	this.set1 = set1 || null;
};


/**
*/
com.wilutions.byps.test.api.inherit.Class2 = function(int1, nextClass1, int2) {
	this._typeId = 6002;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
	this.int2 = int2 || 0;
};


/**
*/
com.wilutions.byps.test.api.inherit.Class3 = function(int1, nextClass1, int2, int3) {
	this._typeId = 6003;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
	this.int2 = int2 || 0;
	this.int3 = int3 || 0;
};


/**
*/
com.wilutions.byps.test.api.inl.Actor = function(shape, position) {
	this._typeId = 171948703;
	this.shape = shape || null;
	this.position = position || null;
};


/**
 * @inline 
*/
com.wilutions.byps.test.api.inl.Matrix2D = function(_11, _12, _13, _21, _22, _23, _31, _32, _33) {
	// this._typeId = 135329019;
	this._11 = _11 || 0;
	this._12 = _12 || 0;
	this._13 = _13 || 0;
	this._21 = _21 || 0;
	this._22 = _22 || 0;
	this._23 = _23 || 0;
	this._31 = _31 || 0;
	this._32 = _32 || 0;
	this._33 = _33 || 0;
};


/**
 * Example for an inline class.
 * Final classes cannot be evolved or derived.
 * Objects of final classes are serialized without
 * the overhead of type and reference information.
 * This optimization is especially useful in the case of
 * large arrays of small objects being serialized.
 * @inline 
*/
com.wilutions.byps.test.api.inl.Point2D = function(x, y) {
	// this._typeId = 1835035436;
	this.x = x || 0;
	this.y = y || 0;
};


/**
*/
com.wilutions.byps.test.api.list.ListListTypes = function(int2, int3, int24) {
	this._typeId = 3002;
	this.int2 = int2 || null;
	this.int3 = int3 || null;
	this.int24 = int24 || null;
};


/**
*/
com.wilutions.byps.test.api.list.ListTypes = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, primitiveTypes1, byte2, int2, int4, obj1) {
	this._typeId = 3001;
	this.boolean1 = boolean1 || null;
	this.byte1 = byte1 || null;
	this.char1 = char1 || null;
	this.short1 = short1 || null;
	this.int1 = int1 || null;
	this.long1 = long1 || null;
	this.float1 = float1 || null;
	this.double1 = double1 || null;
	this.string1 = string1 || null;
	this.primitiveTypes1 = primitiveTypes1 || null;
	this.byte2 = byte2 || null;
	this.int2 = int2 || null;
	this.int4 = int4 || null;
	this.obj1 = obj1 || null;
};


/**
*/
com.wilutions.byps.test.api.map.MapTypes = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, primitiveTypes1, byte2, int2, obj1) {
	this._typeId = 4001;
	this.boolean1 = boolean1 || null;
	this.byte1 = byte1 || null;
	this.char1 = char1 || null;
	this.short1 = short1 || null;
	this.int1 = int1 || null;
	this.long1 = long1 || null;
	this.float1 = float1 || null;
	this.double1 = double1 || null;
	this.string1 = string1 || null;
	this.primitiveTypes1 = primitiveTypes1 || null;
	this.byte2 = byte2 || null;
	this.int2 = int2 || null;
	this.obj1 = obj1 || null;
};


/**
 * Example class with primitive types like boolean, int, String.
*/
com.wilutions.byps.test.api.prim.PrimitiveTypes = function(boolVal, byteVal, charVal, shortVal, intVal, longVal, floatVal, doubleVal, stringVal, objVal, objVal2, value) {
	this._typeId = 1000;
	this.boolVal = boolVal || false;
	this.byteVal = byteVal || 0;
	this.charVal = charVal || '';
	this.shortVal = shortVal || 0;
	this.intVal = intVal || 0;
	this.longVal = longVal || '0.';
	this.floatVal = floatVal || 0;
	this.doubleVal = doubleVal || 0;
	this.stringVal = stringVal || "";
	this.objVal = objVal || null;
	this.objVal2 = objVal2 || null;
	this.value = value || false;
};


/**
 * Example class with private and protected members
*/
com.wilutions.byps.test.api.priv.PrivateMembers = function(boolVal, byteVal, charVal, shortVal, intVal, longVal, floatVal, doubleVal, stringVal, primitiveTypes, arrBool, arrInt, arrString, arrPrimitiveTypes, listBool, listInt, listString, listPrimitiveTypes, mapIntListString, protInt, pprotInt) {
	this._typeId = 8001;
	this.boolVal = boolVal || false;
	this.byteVal = byteVal || 0;
	this.charVal = charVal || '';
	this.shortVal = shortVal || 0;
	this.intVal = intVal || 0;
	this.longVal = longVal || '0.';
	this.floatVal = floatVal || 0;
	this.doubleVal = doubleVal || 0;
	this.stringVal = stringVal || "";
	this.primitiveTypes = primitiveTypes || null;
	this.arrBool = arrBool || null;
	this.arrInt = arrInt || null;
	this.arrString = arrString || null;
	this.arrPrimitiveTypes = arrPrimitiveTypes || null;
	this.listBool = listBool || null;
	this.listInt = listInt || null;
	this.listString = listString || null;
	this.listPrimitiveTypes = listPrimitiveTypes || null;
	this.mapIntListString = mapIntListString || null;
	this.protInt = protInt || 0;
	this.pprotInt = pprotInt || 0;
};


/**
*/
com.wilutions.byps.test.api.refs.Node = function(next, me, mapOfNodes, listOfNodes) {
	this._typeId = 9001;
	this.next = next || null;
	this.me = me || null;
	this.mapOfNodes = mapOfNodes || null;
	this.listOfNodes = listOfNodes || null;
};


/**
*/
com.wilutions.byps.test.api.set.SetTypes = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, primitiveTypes1, byte2, int2, obj1) {
	this._typeId = 5001;
	this.boolean1 = boolean1 || null;
	this.byte1 = byte1 || null;
	this.char1 = char1 || null;
	this.short1 = short1 || null;
	this.int1 = int1 || null;
	this.long1 = long1 || null;
	this.float1 = float1 || null;
	this.double1 = double1 || null;
	this.string1 = string1 || null;
	this.primitiveTypes1 = primitiveTypes1 || null;
	this.byte2 = byte2 || null;
	this.int2 = int2 || null;
	this.obj1 = obj1 || null;
};


/**
*/
com.wilutions.byps.test.api.srvr.ChatStructure = function(msg, sentAt, receivedAt) {
	this._typeId = 7007;
	this.msg = msg || "";
	this.sentAt = sentAt || 0;
	this.receivedAt = receivedAt || 0;
};


/**
*/
com.wilutions.byps.test.api.strm.Stream1 = function(is1, contentType, arrStream, listStream, mapStream) {
	this._typeId = 1541129345;
	this.is1 = is1 || null;
	this.contentType = contentType || "";
	this.arrStream = arrStream || null;
	this.listStream = listStream || null;
	this.mapStream = mapStream || null;
};


/**
 * Example class with elements that belong to different versions.
*/
com.wilutions.byps.test.api.ver.Evolve = function(bool1, byte1, char1, short1, int1, long1, float1, double1, bools1, bytes1, chars1, shorts1, ints1, longs1, floats1, doubles1, str1, obj1, evo1, list1, set1, map1, bool2, byte2, char2, short2, int2, long2, float2, double2, bools2, bytes2, chars2, shorts2, ints2, longs2, floats2, doubles2, str2, obj2, evo2, list2, set2, map2, bool3, byte3, char3, short3, int3, long3, float3, double3, bools3, bytes3, chars3, shorts3, ints3, longs3, floats3, doubles3, str3, obj3, evo3, list3, set3, map3) {
	this._typeId = 1391985860;
	this.bool1 = bool1 || false;
	this.byte1 = byte1 || 0;
	this.char1 = char1 || '';
	this.short1 = short1 || 0;
	this.int1 = int1 || 0;
	this.long1 = long1 || '0.';
	this.float1 = float1 || 0;
	this.double1 = double1 || 0;
	this.bools1 = bools1 || null;
	this.bytes1 = bytes1 || null;
	this.chars1 = chars1 || null;
	this.shorts1 = shorts1 || null;
	this.ints1 = ints1 || null;
	this.longs1 = longs1 || null;
	this.floats1 = floats1 || null;
	this.doubles1 = doubles1 || null;
	this.str1 = str1 || "";
	this.obj1 = obj1 || null;
	this.evo1 = evo1 || null;
	this.list1 = list1 || null;
	this.set1 = set1 || null;
	this.map1 = map1 || null;
	this.bool2 = bool2 || false;
	this.byte2 = byte2 || 0;
	this.char2 = char2 || '';
	this.short2 = short2 || 0;
	this.int2 = int2 || 0;
	this.long2 = long2 || '0.';
	this.float2 = float2 || 0;
	this.double2 = double2 || 0;
	this.bools2 = bools2 || null;
	this.bytes2 = bytes2 || null;
	this.chars2 = chars2 || null;
	this.shorts2 = shorts2 || null;
	this.ints2 = ints2 || null;
	this.longs2 = longs2 || null;
	this.floats2 = floats2 || null;
	this.doubles2 = doubles2 || null;
	this.str2 = str2 || "";
	this.obj2 = obj2 || null;
	this.evo2 = evo2 || null;
	this.list2 = list2 || null;
	this.set2 = set2 || null;
	this.map2 = map2 || null;
	this.bool3 = bool3 || false;
	this.byte3 = byte3 || 0;
	this.char3 = char3 || '';
	this.short3 = short3 || 0;
	this.int3 = int3 || 0;
	this.long3 = long3 || '0.';
	this.float3 = float3 || 0;
	this.double3 = double3 || 0;
	this.bools3 = bools3 || null;
	this.bytes3 = bytes3 || null;
	this.chars3 = chars3 || null;
	this.shorts3 = shorts3 || null;
	this.ints3 = ints3 || null;
	this.longs3 = longs3 || null;
	this.floats3 = floats3 || null;
	this.doubles3 = doubles3 || null;
	this.str3 = str3 || "";
	this.obj3 = obj3 || null;
	this.evo3 = evo3 || null;
	this.list3 = list3 || null;
	this.set3 = set3 || null;
	this.map3 = map3 || null;
};


/**
*/
com.wilutions.byps.test.api.ver.Evolve2 = function(n1) {
	this._typeId = 573592593;
	this.n1 = n1 || 0;
};



/**
 * ----------------------------------------------
 * API constant types
 * ----------------------------------------------
*/

com.wilutions.byps.test.api.cons.AllTypesC_Type = function() {
	this.bool1s = true;
	this.bool2s = false;
	this.byte1s = 1;
	this.char1s = '\u00bf';
	this.stringNull = "";
	/**
	 * This constant holds the currency symbol for Euro.
	 * It is defined "final static" and thus cannot be changed.
	*/
	this.char2s = '\u20ac';
	this.short1s = 3;
	this.int1s = 4;
	this.long1s = "6148914691236517205.";
	this.float1s = 6.8;
	this.double1s = 7.8;
	this.string1s = "Aa__\u00b6\u00b6__\u20ac\u20ac__\t\r\n\"\'";
	/**
	 * This defines a complex constant.
	 * It is an instance of the class AllTypesZ.
	 * The field value cannot be changed, but it's contents could.
	*/
	this.ALL = new com.wilutions.byps.test.api.cons.AllTypesZ(true, 1, 'A', 2, 3, "4.", 5.0, 6.0, "777", new com.wilutions.byps.test.api.cons.HebrewZ("\u05d0"), "AQID", [-4,-5], ["a","b"], [new com.wilutions.byps.test.api.cons.HebrewZ("\u05d0"),new com.wilutions.byps.test.api.cons.HebrewZ("\u05d1")]);
	this.arrInt = [1,2,3];
	this.arrInt4 = [[[[1,2],[4,5]],[[11,12],[14,15]]],[[[21,22],[24,25]],[[211,212],[214,215]]]];
	this.arrStrings = ["s1","s2"];
	this.arrStrings4 = [[[["s1","s2"]]]];
	this.arrALL = [[new com.wilutions.byps.test.api.cons.AllTypesZ(false, 0, '\u0000', 0, 0, "0.", 0.0, 0.0, "", null, null, null, null, null)],[new com.wilutions.byps.test.api.cons.AllTypesZ(true, 1, 'A', 2, 3, "4.", 5.0, 6.0, "777", new com.wilutions.byps.test.api.cons.HebrewZ("\u05d0"), "AQID", [-4,-5], ["a","b"], [new com.wilutions.byps.test.api.cons.HebrewZ("\u05d0"),new com.wilutions.byps.test.api.cons.HebrewZ("\u05d1")])]];
};

com.wilutions.byps.test.api.cons.HebrewC_Type = function() {
	this.aleph = "\u05d0";
	this.beth = "\u05d1";
	this.ALEPH = new com.wilutions.byps.test.api.cons.HebrewZ("\u05d0");
	this.BETH = new com.wilutions.byps.test.api.cons.HebrewZ("\u05d1");
};

com.wilutions.byps.test.api.enu.EnumPlanets = {
	/**
	 * ... is the closest planet to the Sun ...
	*/
	Mercury : 0,
	Venus : 1,
	Earth : 2
};


/**
 * ----------------------------------------------
 * API constants
 * ----------------------------------------------
*/

/**
*/
com.wilutions.byps.test.api.cons.AllTypesC = new com.wilutions.byps.test.api.cons.AllTypesC_Type();

/**
*/
com.wilutions.byps.test.api.cons.HebrewC = new com.wilutions.byps.test.api.cons.HebrewC_Type();


/**
 * ----------------------------------------------
 * Skeleton classes
 * ----------------------------------------------
*/

/**
 * This class provides a skeleton implementation of the interface RemoteWithAuthentication.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication = function() {
	
	this._typeId = 1677934392;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1677934392, targetId : this.transport.targetId };
	};
	
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Set authentication flag in MySession.
 * @param useAuth
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.setUseAuthentication = function(useAuth) /* returns void , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Set authentication flag in MySession.
 * @param useAuth
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.async_setUseAuthentication = function(useAuth, __byps__asyncResult){
	try {
		this.setUseAuthentication(useAuth);
		__byps__asyncResult(null, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Login.
 * Only user "Fritz" is allowed to login.
 * @param sess Session information, always null in this scenario.
 * @param userName
 * @param userPwd
 * @return Session object
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.login = function(sess, userName, userPwd) /* returns com.wilutions.byps.test.api.auth.SessionInfo , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Login.
 * Only user "Fritz" is allowed to login.
 * @param sess Session information, always null in this scenario.
 * @param userName
 * @param userPwd
 * @return Session object
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.async_login = function(sess, userName, userPwd, __byps__asyncResult){
	try {
		var __byps__ret = this.login(sess, userName, userPwd);
		__byps__asyncResult(__byps__ret, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Do something.
 * @param sess Session information. Must not be null, if user was logged in.
 * @param value
 * @return value+1
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.doit = function(sess, value) /* returns int , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Do something.
 * @param sess Session information. Must not be null, if user was logged in.
 * @param value
 * @return value+1
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.async_doit = function(sess, value, __byps__asyncResult){
	try {
		var __byps__ret = this.doit(sess, value);
		__byps__asyncResult(__byps__ret, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Logout
 * @param sess
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.expire = function(sess) /* returns void , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Logout
 * @param sess
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.async_expire = function(sess, __byps__asyncResult){
	try {
		this.expire(sess);
		__byps__asyncResult(null, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Set the number of login calls nessesary to login the user.
 * This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
 * @param count
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.setReloginCount = function(count) /* returns void , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Set the number of login calls nessesary to login the user.
 * This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
 * @param count
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication.prototype.async_setReloginCount = function(count, __byps__asyncResult){
	try {
		this.setReloginCount(count);
		__byps__asyncResult(null, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

/**
 * This class provides a skeleton implementation of the interface ClientIF.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF = function() {
	
	this._typeId = 1784257353;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1784257353, targetId : this.transport.targetId };
	};
	
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.incrementInt = function(a) /* returns int , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_incrementInt = function(a, __byps__asyncResult){
	try {
		var __byps__ret = this.incrementInt(a);
		__byps__asyncResult(__byps__ret, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.getStreams = function(ctrl) /* returns java.util.List<java.io.InputStream> , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_getStreams = function(ctrl, __byps__asyncResult){
	try {
		var __byps__ret = this.getStreams(ctrl);
		__byps__asyncResult(__byps__ret, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.putStreams = function(strm, ctrl) /* returns void , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_putStreams = function(strm, ctrl, __byps__asyncResult){
	try {
		this.putStreams(strm, ctrl);
		__byps__asyncResult(null, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.sendChat = function(cs) /* returns com.wilutions.byps.test.api.srvr.ChatStructure , throws BException, InterruptedException*/  {
	com.wilutions.byps.throwUNSUPPORTED("");
};
// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_sendChat = function(cs, __byps__asyncResult){
	try {
		var __byps__ret = this.sendChat(cs);
		__byps__asyncResult(__byps__ret, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};


/**
 * ----------------------------------------------
 * Stub classes
 * ----------------------------------------------
*/

/**
 * Interface with functions using 1-dimensional arrays.
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim = function(transport) {
	
	this._typeId = 1557084481;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setBool = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 589253529, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setByte = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 589243771, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setChar = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 589230893, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setShort = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1071498593, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setInt = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1265927470, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setLong = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 588955655, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setFloat = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1083385729, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setDouble = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 720472590, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setString = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1154444878, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setPrimitiveTypes = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1765354225, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setObject = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1023062396, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getBool = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1645604187 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getByte = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1645613945 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getChar = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1645626823 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getShort = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 510386133 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getInt = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1609477282 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getLong = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1645902061 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getFloat = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 522273269 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getDouble = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 935089666 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getString = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1369061954 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getPrimitiveTypes = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 825201405 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getObject = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1237679472 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23 = function(transport) {
	
	this._typeId = 2081058997;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysInt = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1748523470, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysString = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 607451410, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysClass = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1004457221, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysObject = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 738833892, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysInline = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 899462794, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * Interface with functions using 4-dimensional arrays.
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim = function(transport) {
	
	this._typeId = 1557173854;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setBool = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 202005372, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setByte = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 201995614, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setChar = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 201982736, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setShort = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1951707614, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setInt = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1933153045, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setLong = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 201707498, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setFloat = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1963594750, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setDouble = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 796203285, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setString = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 362230997, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setPrimitiveTypes = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 710411500, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setObject = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 493613479, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getBool = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2032852344 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getByte = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2032862102 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getChar = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2032874980 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getShort = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1390595154 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getInt = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1589603233 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getLong = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2033150218 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getFloat = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1402482290 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getDouble = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 581586209 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getString = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 147613921 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getPrimitiveTypes = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1650564320 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getObject = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 278996403 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * Interface functions to verify constant definitions.
*/
com.wilutions.byps.test.api.remote.BStub_RemoteConstants = function(transport) {
	
	this._typeId = 431648293;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteConstants.prototype.compare_HebrewC = function(ALEPH, BETH, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1570751625, ALEPH : ALEPH, BETH : BETH };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteConstants.prototype.compare_AllTypesC = function(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 862752254, bool1s : bool1s, bool2s : bool2s, char1s : char1s, stringNull : stringNull, char2s : char2s, short1s : short1s, int1s : int1s, long1s : long1s, float1s : float1s, double1s : double1s, string1s : string1s, ALL : ALL, arrInt : arrInt, arrInt4 : arrInt4, arrStrings : arrStrings, arrStrings4 : arrStrings4, arrAll : arrAll };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteEnums = function(transport) {
	
	this._typeId = 359349400;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteEnums.prototype.getPlanet = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 627010462 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteEnums.prototype.setPlanet = function(planet, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 412393386, planet : planet };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance = function(transport) {
	
	this._typeId = 1206670536;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setActor = function(act, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 299289599, act : act };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getActor = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 261822861 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DArray1dim = function(pointArray, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 531757758, pointArray : pointArray };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DArray1dim = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1011970102 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DArray4dim = function(pointArray, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 531668385, pointArray : pointArray };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DArray4dim = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1012059475 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DList = function(pointList, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 224357548, pointList : pointList };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DList = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1996093752 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DListList = function(pointListList, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1097161578, pointListList : pointListList };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DListList = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 177127926 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DMap = function(pointMap, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 546951282, pointMap : pointMap };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DMap = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1321082494 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes = function(transport) {
	
	this._typeId = 380156079;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getBoolean1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1794077576 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setBoolean1 = function(boolean1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1882657404, boolean1 : boolean1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getByte1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1319541530 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setByte1 = function(byte1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 758429070, byte1 : byte1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getChar1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1319940748 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setChar1 = function(char1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 758828288, char1 : char1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getShort1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1573024156 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setShort1 = function(short1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1787641232, short1 : short1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 874047761 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt1 = function(int1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1360809955, int1 : int1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getLong1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1328473126 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setLong1 = function(long1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 767360666, long1 : long1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getFloat1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1941525372 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setFloat1 = function(float1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2138824848, float1 : float1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getDouble1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1741299407 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setDouble1 = function(double1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 195505829, double1 : double1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getString1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1173060367 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setString1 = function(string1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 763744869, string1 : string1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getPrimitiveTypes1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1940572240 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setPrimitiveTypes1 = function(primitiveTypes1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1434361404, primitiveTypes1 : primitiveTypes1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getByte2 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1319541531 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setByte2 = function(byte2, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 758429071, byte2 : byte2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt2 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 874047762 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt2 = function(int2, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1360809954, int2 : int2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getObj1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 874214665 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setObj1 = function(obj1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1360643051, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt3 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 874047763 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt3 = function(int3, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1360809953, int3 : int3 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt4 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 874047764 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt4 = function(int4, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1360809952, int4 : int4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes = function(transport) {
	
	this._typeId = 80483097;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getBoolean1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 461626272 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setBoolean1 = function(boolean1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 550206100, boolean1 : boolean1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getByte1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1348711374 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setByte1 = function(byte1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1909823834, byte1 : byte1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getChar1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1348312156 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setChar1 = function(char1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1909424616, char1 : char1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getShort1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1610481740 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setShort1 = function(short1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1395864664, short1 : short1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getInt1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1013140231 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setInt1 = function(int1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1046969349, int1 : int1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getLong1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1339779778 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setLong1 = function(long1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1900892238, long1 : long1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getFloat1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1241980524 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setFloat1 = function(float1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1027363448, float1 : float1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getDouble1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1836864439 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setDouble1 = function(double1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 99940797, double1 : double1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getString1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1268625399 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setString1 = function(string1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 668179837, string1 : string1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getPrimitiveTypes1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 77071512 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setPrimitiveTypes1 = function(primitiveTypes1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 842962140, primitiveTypes1 : primitiveTypes1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getByte2 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1348711373 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setByte2 = function(byte2, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1909823833, byte2 : byte2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getInt2 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1013140230 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setInt2 = function(int2, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1046969350, int2 : int2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.getObj1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1012973327 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes.prototype.setObj1 = function(obj1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1047136253, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes = function(transport) {
	
	this._typeId = 1341983932;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.voidFunctionVoid = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1856936054 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setBool = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 143860510, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setByte = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 143850752, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setChar = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 143837874, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setShort = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 149216892, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setInt = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 974465289, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setLong = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 143562636, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setFloat = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 161104028, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setDouble = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 753565751, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setString = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 319593463, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setPrimitiveTypes = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 941809610, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setObject = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 450975945, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getBool = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2090997206 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getByte = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2091006964 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getChar = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2091019842 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getShort = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 411895568 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getInt = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1318015101 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getLong = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2091295080 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getFloat = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 400008432 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getDouble = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 538948675 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getString = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 104976387 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getPrimitiveTypes = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1881962430 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getObject = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 236358869 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.sendAllTypes = function(b, c, s, i, l, f, d, str, pt, o, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1794219594, b : b, c : c, s : s, i : i, l : l, f : f, d : d, str : str, pt : pt, o : o };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.add = function(a, b, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1073583639, a : a, b : b };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteReferences = function(transport) {
	
	this._typeId = 2086824050;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteReferences.prototype.getNode = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 655936732 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteReferences.prototype.setNode = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1404172848, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl = function(transport) {
	
	this._typeId = 1124545992;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl.prototype.publishRemote = function(name, remote, fowardToOtherServers, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1776814809, name : name, remote : remote, fowardToOtherServers : fowardToOtherServers };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl.prototype.getPublishedRemote = function(name, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1216543212, name : name };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl.prototype.removePublishedRemote = function(name, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1302703010, name : name };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes = function(transport) {
	
	this._typeId = 1156008353;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getBoolean1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1690813926 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setBoolean1 = function(boolean1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1779393754, boolean1 : boolean1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getByte1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2125684552 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setByte1 = function(byte1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1608170284, byte1 : byte1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getChar1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2125285334 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setChar1 = function(char1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1608569502, char1 : char1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getShort1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1000850298 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setShort1 = function(short1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1215467374, short1 : short1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getInt1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 68372557 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setInt1 = function(int1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1991737023, int1 : int1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getLong1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2116752956 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setLong1 = function(long1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1617101880, long1 : long1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getFloat1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1369351514 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setFloat1 = function(float1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1583968590, float1 : float1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getDouble1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1183778993 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setDouble1 = function(double1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 753026243, double1 : double1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getString1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 615539953 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setString1 = function(string1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1321265283, string1 : string1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getPrimitiveTypes1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1802821742 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setPrimitiveTypes1 = function(primitiveTypes1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1572111902, primitiveTypes1 : primitiveTypes1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getByte2 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2125684551 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setByte2 = function(byte2, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1608170285, byte2 : byte2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getInt2 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 68372556 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setInt2 = function(int2, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1991737024, int2 : int2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.getObj1 = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 68205653 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes.prototype.setObj1 = function(obj1, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1991903927, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams = function(transport) {
	
	this._typeId = 2028487863;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams.prototype.getImage = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1902276204 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams.prototype.setImage = function(istrm, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1831578632, istrm : istrm };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams.prototype.getImages = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1158979935 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams.prototype.setImages = function(istrms, doNotReadStreamAtKey, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 944362859, istrms : istrms, doNotReadStreamAtKey : doNotReadStreamAtKey };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams.prototype.throwLastException = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2047657918 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams.prototype.getTextStream = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1083407988 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * This interface is an example for using the authentication mechanism.
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * @BClientRemote 
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * @BClientRemote 
*/
com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication = function(transport) {
	
	this._typeId = 1677934392;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Set authentication flag in MySession.
 * @param useAuth
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.setUseAuthentication = function(useAuth, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1785294043, useAuth : useAuth };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Login.
 * Only user "Fritz" is allowed to login.
 * @param sess Session information, always null in this scenario.
 * @param userName
 * @param userPwd
 * @return Session object
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.login = function(userName, userPwd, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 839695851, __byps__sess : 'sess', userName : userName, userPwd : userPwd };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Do something.
 * @param sess Session information. Must not be null, if user was logged in.
 * @param value
 * @return value+1
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.doit = function(value, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 388793292, __byps__sess : 'sess', value : value };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Logout
 * @param sess
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.expire = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 68943581, __byps__sess : 'sess' };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
 * Set the number of login calls nessesary to login the user.
 * This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
 * @param count
 * @throws RemoteException
*/
com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.setReloginCount = function(count, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 20608797, count : count };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * @BClientRemote 
 * @BClientRemote 
*/
com.wilutions.byps.test.api.srvr.BStub_ClientIF = function(transport) {
	
	this._typeId = 1784257353;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ClientIF.prototype.incrementInt = function(a, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1461829915, a : a };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ClientIF.prototype.getStreams = function(ctrl, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 865920738, ctrl : ctrl };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ClientIF.prototype.putStreams = function(strm, ctrl, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 242798857, strm : strm, ctrl : ctrl };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ClientIF.prototype.sendChat = function(cs, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1352392091, cs : cs };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF = function(transport) {
	
	this._typeId = 1313562065;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.callClientIncrementInt = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1252575894, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.setPartner = function(client, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1188403123, client : client };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.getPartner = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 748402113 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.getStreamsFromClient = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1415283169 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.putStreamsOnClient = function(streams, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1367013829, streams : streams };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.registerWithClientMap = function(id, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1921080901, id : id };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.getClient = function(id, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2107407220, id : id };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.getClientIds = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 2063368540 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF.prototype.callClientParallel = function(v, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1340180893, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
com.wilutions.byps.test.api.ver.BStub_EvolveIF = function(transport) {
	
	this._typeId = 2078696281;
	
	this.transport = transport;
	
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.ver.BStub_EvolveIF.prototype.setEvolve = function(obj, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 246658450, obj : obj };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.ver.BStub_EvolveIF.prototype.getEvolve = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 32041374 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.ver.BStub_EvolveIF.prototype.setClient = function(partner, __byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 313337668, partner : partner };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.ver.BStub_EvolveIF.prototype.getClient = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 98720592 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint com.wilutions.byps.gen.js.PrintContext:127
/**
*/
com.wilutions.byps.test.api.ver.BStub_EvolveIF.prototype.sendEvolveToClient = function(__byps__asyncResult) {
	// checkpoint com.wilutions.byps.gen.js.GenRemoteStub:39
	var req =  { _typeId : 1425170268 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};


/**
 * ----------------------------------------------
 * Server class
 * ----------------------------------------------
*/

com.wilutions.byps.test.api.BServer_Testser = function(transport) { 

	this.transport = transport;
	this._remotes = {};
	
	this._methodMap = {
		
		// Remote Interface RemoteArrayTypes1dim			
			// Method setBool
			589253529 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			589243771 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			589230893 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			1071498593 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			1265927470 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			588955655 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			1083385729 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			720472590 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			1154444878 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			1765354225 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			1023062396 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			1645604187 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				532799052, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			1645613945 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				578691531, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			1645626823 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				514676842, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			510386133 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1305849624, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1609477282 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				848023142, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			1645902061 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1862597051, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			522273269 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1517001317, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			935089666 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				493259283, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			1369061954 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				427000, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			825201405 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1937830923, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			1237679472 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				333265053, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
		
		
		// Remote Interface RemoteArrayTypes23			
			// Method sendArraysInt
			1748523470 : [ // _typeId of request class
				2081058997, // _typeId of remote interface
				848023142, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysInt(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysString
			607451410 : [ // _typeId of request class
				2081058997, // _typeId of remote interface
				427000, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysString(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysClass
			1004457221 : [ // _typeId of request class
				2081058997, // _typeId of remote interface
				1937830923, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysClass(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysObject
			738833892 : [ // _typeId of request class
				2081058997, // _typeId of remote interface
				333265053, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysObject(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysInline
			899462794 : [ // _typeId of request class
				2081058997, // _typeId of remote interface
				234867558, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysInline(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
		
		
		// Remote Interface RemoteArrayTypes4dim			
			// Method setBool
			202005372 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			201995614 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			201982736 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			1951707614 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			1933153045 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			201707498 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			1963594750 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			796203285 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			362230997 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			710411500 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			493613479 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			2032852344 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				2092891102, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			2032862102 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				541741223, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			2032874980 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				231816689, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			1390595154 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				101217472, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1589603233 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1682941350, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			2033150218 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				516356161, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			1402482290 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				188578332, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			581586209 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				580667480, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			147613921 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1886698628, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			1650564320 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				72308967, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			278996403 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				647080343, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
		
		
		// Remote Interface RemoteConstants			
			// Method compare_HebrewC
			1570751625 : [ // _typeId of request class
				431648293, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_compare_HebrewC(methodObj.ALEPH, methodObj.BETH, methodResult);
				}
			],
			
			// Method compare_AllTypesC
			862752254 : [ // _typeId of request class
				431648293, // _typeId of remote interface
				148544162, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_compare_AllTypesC(methodObj.bool1s, methodObj.bool2s, methodObj.char1s, methodObj.stringNull, methodObj.char2s, methodObj.short1s, methodObj.int1s, methodObj.long1s, methodObj.float1s, methodObj.double1s, methodObj.string1s, methodObj.ALL, methodObj.arrInt, methodObj.arrInt4, methodObj.arrStrings, methodObj.arrStrings4, methodObj.arrAll, methodResult);
				}
			],
		
		
		// Remote Interface RemoteEnums			
			// Method getPlanet
			627010462 : [ // _typeId of request class
				359349400, // _typeId of remote interface
				2038872493, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPlanet(methodResult);
				}
			],
			
			// Method setPlanet
			412393386 : [ // _typeId of request class
				359349400, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPlanet(methodObj.planet, methodResult);
				}
			],
		
		
		// Remote Interface RemoteInlineInstance			
			// Method setActor
			299289599 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActor(methodObj.act, methodResult);
				}
			],
			
			// Method getActor
			261822861 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1220439445, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActor(methodResult);
				}
			],
			
			// Method setPoint2DArray1dim
			531757758 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DArray1dim(methodObj.pointArray, methodResult);
				}
			],
			
			// Method getPoint2DArray1dim
			1011970102 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				234867558, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DArray1dim(methodResult);
				}
			],
			
			// Method setPoint2DArray4dim
			531668385 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DArray4dim(methodObj.pointArray, methodResult);
				}
			],
			
			// Method getPoint2DArray4dim
			1012059475 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1490187962, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DArray4dim(methodResult);
				}
			],
			
			// Method setPoint2DList
			224357548 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DList(methodObj.pointList, methodResult);
				}
			],
			
			// Method getPoint2DList
			1996093752 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1905478006, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DList(methodResult);
				}
			],
			
			// Method setPoint2DListList
			1097161578 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DListList(methodObj.pointListList, methodResult);
				}
			],
			
			// Method getPoint2DListList
			177127926 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				548882635, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DListList(methodResult);
				}
			],
			
			// Method setPoint2DMap
			546951282 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DMap(methodObj.pointMap, methodResult);
				}
			],
			
			// Method getPoint2DMap
			1321082494 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1651982651, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DMap(methodResult);
				}
			],
		
		
		// Remote Interface RemoteListTypes			
			// Method getBoolean1
			1794077576 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				732507399, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			1882657404 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			1319541530 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1532920911, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			758429070 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			1319940748 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1587436403, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			758828288 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			1573024156 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				980499904, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1787641232 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			874047761 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1414119390, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			1360809955 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			1328473126 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				2133842068, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			767360666 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			1941525372 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1862743418, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			2138824848 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1741299407 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1887708350, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			195505829 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			1173060367 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1978497049, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			763744869 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			1940572240 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				743592613, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			1434361404 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			1319541531 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				994835305, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			758429071 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			874047762 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				150989512, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			1360809954 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			874214665 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901676, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			1360643051 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
			
			// Method getInt3
			874047763 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1823196186, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt3(methodResult);
				}
			],
			
			// Method setInt3
			1360809953 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt3(methodObj.int3, methodResult);
				}
			],
			
			// Method getInt4
			874047764 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				831989576, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt4(methodResult);
				}
			],
			
			// Method setInt4
			1360809952 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt4(methodObj.int4, methodResult);
				}
			],
		
		
		// Remote Interface RemoteMapTypes			
			// Method getBoolean1
			461626272 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1602044401, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			550206100 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			1348711374 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				104960651, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			1909823834 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			1348312156 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1554344518, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			1909424616 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			1610481740 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1205316392, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1395864664 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			1013140231 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1350610934, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			1046969349 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			1339779778 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				839888536, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			1900892238 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			1241980524 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				127543251, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			1027363448 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1836864439 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				2081879792, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			99940797 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			1268625399 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				163470910, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			668179837 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			77071512 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1169980470, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			842962140 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			1348711373 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				179038766, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			1909823833 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			1013140230 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				770118380, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			1046969350 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			1012973327 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1240765869, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			1047136253 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
		
		
		// Remote Interface RemotePrimitiveTypes			
			// Method voidFunctionVoid
			1856936054 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_voidFunctionVoid(methodResult);
				}
			],
			
			// Method setBool
			143860510 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			143850752 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			143837874 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			149216892 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			974465289 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			143562636 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			161104028 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			753565751 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			319593463 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			941809610 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			450975945 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			2090997206 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544162, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			2091006964 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544161, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			2091019842 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544159, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			411895568 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544160, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1318015101 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544158, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			2091295080 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544157, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			400008432 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544156, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			538948675 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544155, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			104976387 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901678, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			1881962430 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1462767598, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			236358869 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901646, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
			
			// Method sendAllTypes
			1794219594 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendAllTypes(methodObj.b, methodObj.c, methodObj.s, methodObj.i, methodObj.l, methodObj.f, methodObj.d, methodObj.str, methodObj.pt, methodObj.o, methodResult);
				}
			],
			
			// Method add
			1073583639 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				148544158, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_add(methodObj.a, methodObj.b, methodResult);
				}
			],
		
		
		// Remote Interface RemoteReferences			
			// Method getNode
			655936732 : [ // _typeId of request class
				2086824050, // _typeId of remote interface
				1462529269, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getNode(methodResult);
				}
			],
			
			// Method setNode
			1404172848 : [ // _typeId of request class
				2086824050, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setNode(methodObj.v, methodResult);
				}
			],
		
		
		// Remote Interface RemoteServerCtrl			
			// Method publishRemote
			1776814809 : [ // _typeId of request class
				1124545992, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_publishRemote(methodObj.name, methodObj.remote, methodObj.fowardToOtherServers, methodResult);
				}
			],
			
			// Method getPublishedRemote
			1216543212 : [ // _typeId of request class
				1124545992, // _typeId of remote interface
				309901672, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPublishedRemote(methodObj.name, methodResult);
				}
			],
			
			// Method removePublishedRemote
			1302703010 : [ // _typeId of request class
				1124545992, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_removePublishedRemote(methodObj.name, methodResult);
				}
			],
		
		
		// Remote Interface RemoteSetTypes			
			// Method getBoolean1
			1690813926 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1253977781, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			1779393754 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			2125684552 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				307489197, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			1608170284 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			2125285334 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1317331941, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			1608569502 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			1000850298 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				398816652, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1215467374 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			68372557 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				276437907, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			1991737023 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			2116752956 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1119760023, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			1617101880 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			1369351514 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1716302523, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			1583968590 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1183778993 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				190591700, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			753026243 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			615539953 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				180574010, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			1321265283 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			1802821742 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				429041482, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			1572111902 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			2125684551 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				496389964, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			1608170285 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			68372556 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				104448059, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			1991737024 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			68205653 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901674, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			1991903927 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
		
		
		// Remote Interface RemoteStreams			
			// Method getImage
			1902276204 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				309901673, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getImage(methodResult);
				}
			],
			
			// Method setImage
			1831578632 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setImage(methodObj.istrm, methodResult);
				}
			],
			
			// Method getImages
			1158979935 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				93402296, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getImages(methodResult);
				}
			],
			
			// Method setImages
			944362859 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setImages(methodObj.istrms, methodObj.doNotReadStreamAtKey, methodResult);
				}
			],
			
			// Method throwLastException
			2047657918 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwLastException(methodResult);
				}
			],
			
			// Method getTextStream
			1083407988 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				309901673, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getTextStream(methodResult);
				}
			],
		
		
		// Remote Interface RemoteWithAuthentication			
			// Method setUseAuthentication
			1785294043 : [ // _typeId of request class
				1677934392, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setUseAuthentication(methodObj.useAuth, methodResult);
				}
			],
			
			// Method login
			839695851 : [ // _typeId of request class
				1677934392, // _typeId of remote interface
				56089321, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_login(methodObj.sess, methodObj.userName, methodObj.userPwd, methodResult);
				}
			],
			
			// Method doit
			388793292 : [ // _typeId of request class
				1677934392, // _typeId of remote interface
				148544158, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_doit(methodObj.sess, methodObj.value, methodResult);
				}
			],
			
			// Method expire
			68943581 : [ // _typeId of request class
				1677934392, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_expire(methodObj.sess, methodResult);
				}
			],
			
			// Method setReloginCount
			20608797 : [ // _typeId of request class
				1677934392, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setReloginCount(methodObj.count, methodResult);
				}
			],
		
		
		// Remote Interface ClientIF			
			// Method incrementInt
			1461829915 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				148544158, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_incrementInt(methodObj.a, methodResult);
				}
			],
			
			// Method getStreams
			865920738 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				1151524674, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getStreams(methodObj.ctrl, methodResult);
				}
			],
			
			// Method putStreams
			242798857 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_putStreams(methodObj.strm, methodObj.ctrl, methodResult);
				}
			],
			
			// Method sendChat
			1352392091 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				1462588845, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendChat(methodObj.cs, methodResult);
				}
			],
		
		
		// Remote Interface ServerIF			
			// Method callClientIncrementInt
			1252575894 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				148544158, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_callClientIncrementInt(methodObj.v, methodResult);
				}
			],
			
			// Method setPartner
			1188403123 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPartner(methodObj.client, methodResult);
				}
			],
			
			// Method getPartner
			748402113 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				1170836883, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPartner(methodResult);
				}
			],
			
			// Method getStreamsFromClient
			1415283169 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				1151524674, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getStreamsFromClient(methodResult);
				}
			],
			
			// Method putStreamsOnClient
			1367013829 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_putStreamsOnClient(methodObj.streams, methodResult);
				}
			],
			
			// Method registerWithClientMap
			1921080901 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_registerWithClientMap(methodObj.id, methodResult);
				}
			],
			
			// Method getClient
			2107407220 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				1170836883, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClient(methodObj.id, methodResult);
				}
			],
			
			// Method getClientIds
			2063368540 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				276437907, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClientIds(methodResult);
				}
			],
			
			// Method callClientParallel
			1340180893 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				148544158, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_callClientParallel(methodObj.v, methodResult);
				}
			],
		
		
		// Remote Interface EvolveIF			
			// Method setEvolve
			246658450 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setEvolve(methodObj.obj, methodResult);
				}
			],
			
			// Method getEvolve
			32041374 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				509380329, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getEvolve(methodResult);
				}
			],
			
			// Method setClient
			313337668 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setClient(methodObj.partner, methodResult);
				}
			],
			
			// Method getClient
			98720592 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				1911325389, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClient(methodResult);
				}
			],
			
			// Method sendEvolveToClient
			1425170268 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				309901669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendEvolveToClient(methodResult);
				}
			],
		
	};
};
com.wilutions.byps.test.api.BServer_Testser.prototype = new com.wilutions.byps.BServer();


/**
 * ----------------------------------------------
 * Registry
 * ----------------------------------------------
*/

com.wilutions.byps.test.api.BRegistry_Testser = function() { 
	
	this._serializerMap = {
		
		// boolean[]
		2058423690 : new com.wilutions.byps.BSerializerArray(
			1, // Element type: boolean
			1
		),
		
		// boolean[][][][]
		945713488 : new com.wilutions.byps.BSerializerArray(
			1, // Element type: boolean
			4
		),
		
		// byte[]
		1374008726 : new com.wilutions.byps.BSerializerArray(
			2, // Element type: byte
			1
		),
		
		// byte[][][][]
		1201775504 : new com.wilutions.byps.BSerializerArray(
			2, // Element type: byte
			4
		),
		
		// char[]
		1361632968 : new com.wilutions.byps.BSerializerArray(
			4, // Element type: char
			1
		),
		
		// char[][][][]
		769021986 : new com.wilutions.byps.BSerializerArray(
			4, // Element type: char
			4
		),
		
		// com.wilutions.byps.test.api.BResult_1
		148544162 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1 // boolean
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_10
		309901678 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":10 // java.lang.String
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1000
		1462767598 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1000 // com.wilutions.byps.test.api.prim.PrimitiveTypes
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_100361105
		848023142 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":100361105 // int[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":100361105 // int[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1042475995
		2038872493 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1042475995 // com.wilutions.byps.test.api.enu.EnumPlanets
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1050216688
		2133842068 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1050216688 // java.util.List<java.lang.Long>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1050216688 // java.util.List<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1059148284
		1532920911 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1059148284 // java.util.List<java.lang.Byte>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1059148284 // java.util.List<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1097129250
		1862597051 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1097129250 // long[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1097129250 // long[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1174971318
		994835305 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1174971318 // java.util.List<byte[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1174971318 // java.util.List<byte[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1178379224
		1911325389 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2078696281 // com.wilutions.byps.test.api.ver.EvolveIF
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_12
		309901676 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":12 // java.util.List<java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":12 // java.util.List<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1201775504
		541741223 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1201775504 // byte[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1201775504 // byte[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1218831438
		1151524674 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1218831438 // java.util.List<java.io.InputStream>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1218831438 // java.util.List<java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_124584219
		647080343 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":124584219 // java.lang.Object[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":124584219 // java.lang.Object[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1279823631
		1602044401 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1280571537
		429041482 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1280571537 // java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1280571537 // java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1320560671
		190591700 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1320560671 // java.util.Set<java.lang.Double>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1320560671 // java.util.Set<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1347703734
		1350610934 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1359468275
		493259283 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1359468275 // double[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1359468275 // double[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1361632968
		514676842 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1361632968 // char[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1361632968 // char[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1365696060
		1253977781 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1374008726
		578691531 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1374008726 // byte[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1374008726 // byte[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1391985860
		509380329 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1391985860 // com.wilutions.byps.test.api.ver.Evolve
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_14
		309901674 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":14 // java.util.Set<java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":14 // java.util.Set<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1406124761
		104448059 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1406124761 // java.util.Set<int[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1406124761 // java.util.Set<int[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1457164460
		1119760023 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1457164460 // java.util.Set<java.lang.Long>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1457164460 // java.util.Set<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1463615848
		548882635 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1463615848 // java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1463615848 // java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1473575576
		1170836883 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1784257353 // com.wilutions.byps.test.api.srvr.ClientIF
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1487265161
		2081879792 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1488550492
		1240765869 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1493282670
		276437907 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1493282670 // java.util.Set<java.lang.Integer>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1493282670 // java.util.Set<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_15
		309901673 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":15 // java.io.InputStream
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1503107601
		72308967 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1516687588
		188578332 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1516687588 // float[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1516687588 // float[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1544333227
		743592613 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1544333227 // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1544333227 // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1555345627
		1887708350 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1555345627 // java.util.List<java.lang.Double>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1555345627 // java.util.List<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_16
		309901672 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":16 // com.wilutions.byps.BRemote
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1617670280
		732507399 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1617670280 // java.util.List<java.lang.Boolean>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1617670280 // java.util.List<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1628501332
		1862743418 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1628501332 // java.util.List<java.lang.Float>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1628501332 // java.util.List<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1633500852
		831989576 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1633750383
		770118380 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1661807911
		1587436403 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1661807911 // java.util.List<java.lang.Character>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1661807911 // java.util.List<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1710660846
		163470910 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_171948703
		1220439445 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":171948703 // com.wilutions.byps.test.api.inl.Actor
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_172221196
		1905478006 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":172221196 // java.util.List<com.wilutions.byps.test.api.inl.Point2D>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":172221196 // java.util.List<com.wilutions.byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1746702954
		1823196186 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1752158699
		150989512 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1752158699 // java.util.List<int[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1752158699 // java.util.List<int[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1799280818
		179038766 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_181681714
		1414119390 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":181681714 // java.util.List<java.lang.Integer>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":181681714 // java.util.List<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_183594037
		333265053 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":183594037 // java.lang.Object[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":183594037 // java.lang.Object[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1851881336
		1651982651 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1851881336 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1851881336 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1859644668
		101217472 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1859644668 // short[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1859644668 // short[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1888107655
		427000 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1888107655 // java.lang.String[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1888107655 // java.lang.String[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1888799711
		180574010 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1888799711 // java.util.Set<java.lang.String>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1888799711 // java.util.Set<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1898022288
		1716302523 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1898022288 // java.util.Set<java.lang.Float>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1898022288 // java.util.Set<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_19
		309901669 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":19 // void
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1972793385
		104960651 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1973996106
		839888536 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_1997002548
		980499904 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1997002548 // java.util.List<java.lang.Short>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1997002548 // java.util.List<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2
		148544161 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2 // byte
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2028443792
		398816652 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2028443792 // java.util.Set<java.lang.Short>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2028443792 // java.util.Set<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2049740106
		234867558 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2049740106 // com.wilutions.byps.test.api.inl.Point2D[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2049740106 // com.wilutions.byps.test.api.inl.Point2D[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2052431866
		496389964 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2052431866 // java.util.Set<byte[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2052431866 // java.util.Set<byte[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2058423690
		532799052 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2058423690 // boolean[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2058423690 // boolean[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2067161310
		1305849624 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2067161310 // short[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2067161310 // short[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2087445849
		580667480 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2087445849 // double[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2087445849 // double[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_21
		309901646 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":21 // java.lang.Object
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_2123584667
		1978497049 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2123584667 // java.util.List<java.lang.String>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2123584667 // java.util.List<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_3
		148544160 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":3 // short
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_31512998
		307489197 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_39910537
		1682941350 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":39910537 // int[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":39910537 // int[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_4
		148544159 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":4 // char
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_476459792
		93402296 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":476459792 // java.util.TreeMap<java.lang.Integer,java.io.InputStream>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":476459792 // java.util.TreeMap<java.lang.Integer,java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_487702928
		1490187962 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":487702928 // com.wilutions.byps.test.api.inl.Point2D[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":487702928 // com.wilutions.byps.test.api.inl.Point2D[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_5
		148544158 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_588723219
		1886698628 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":588723219 // java.lang.String[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":588723219 // java.lang.String[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_6
		148544157 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":6 // long
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_601099730
		1205316392 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_65775978
		56089321 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":65775978 // com.wilutions.byps.test.api.auth.SessionInfo
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_7
		148544156 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":7 // float
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_7007
		1462588845 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":7007 // com.wilutions.byps.test.api.srvr.ChatStructure
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_703065817
		1169980470 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":703065817 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":703065817 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_766441794
		1517001317 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":766441794 // float[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":766441794 // float[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_769021986
		231816689 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":769021986 // char[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":769021986 // char[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_8
		148544155 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":8 // double
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_801243127
		1937830923 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_846419204
		516356161 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":846419204 // long[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":846419204 // long[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_8789515
		1554344518 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_9001
		1462529269 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":9001 // com.wilutions.byps.test.api.refs.Node
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_936607009
		1317331941 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_94341197
		127543251 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.BResult_945713488
		2092891102 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":945713488 // boolean[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":945713488 // boolean[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.arr.ArrayTypes1dim
		2001 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":2058423690, // boolean[]
				// names of persistent elements
				"byte1":1374008726, // byte[]
				// names of persistent elements
				"char1":1361632968, // char[]
				// names of persistent elements
				"short1":2067161310, // short[]
				// names of persistent elements
				"int1":100361105, // int[]
				// names of persistent elements
				"long1":1097129250, // long[]
				// names of persistent elements
				"float1":766441794, // float[]
				// names of persistent elements
				"double1":1359468275, // double[]
				// names of persistent elements
				"string1":1888107655, // java.lang.String[]
				// names of persistent elements
				"primitiveTypes1":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":2058423690, // boolean[]
				// names of inline elements
				"byte1":1374008726, // byte[]
				// names of inline elements
				"char1":1361632968, // char[]
				// names of inline elements
				"short1":2067161310, // short[]
				// names of inline elements
				"int1":100361105, // int[]
				// names of inline elements
				"long1":1097129250, // long[]
				// names of inline elements
				"float1":766441794, // float[]
				// names of inline elements
				"double1":1359468275, // double[]
				// names of inline elements
				"string1":1888107655, // java.lang.String[]
				// names of inline elements
				"primitiveTypes1":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.arr.ArrayTypes4dim
		2004 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean4":945713488, // boolean[][][][]
				// names of persistent elements
				"byte4":1201775504, // byte[][][][]
				// names of persistent elements
				"char4":769021986, // char[][][][]
				// names of persistent elements
				"short4":1859644668, // short[][][][]
				// names of persistent elements
				"int4":39910537, // int[][][][]
				// names of persistent elements
				"long4":846419204, // long[][][][]
				// names of persistent elements
				"float4":1516687588, // float[][][][]
				// names of persistent elements
				"double4":2087445849, // double[][][][]
				// names of persistent elements
				"string4":588723219, // java.lang.String[][][][]
				// names of persistent elements
				"primitiveTypes4":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean4":945713488, // boolean[][][][]
				// names of inline elements
				"byte4":1201775504, // byte[][][][]
				// names of inline elements
				"char4":769021986, // char[][][][]
				// names of inline elements
				"short4":1859644668, // short[][][][]
				// names of inline elements
				"int4":39910537, // int[][][][]
				// names of inline elements
				"long4":846419204, // long[][][][]
				// names of inline elements
				"float4":1516687588, // float[][][][]
				// names of inline elements
				"double4":2087445849, // double[][][][]
				// names of inline elements
				"string4":588723219, // java.lang.String[][][][]
				// names of inline elements
				"primitiveTypes4":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.auth.SessionInfo
		65775978 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sessionID":10 // java.lang.String
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.cons.AllTypesC
		930294276 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"bool1s":1, // boolean
				// names of persistent elements
				"bool2s":1, // boolean
				// names of persistent elements
				"byte1s":2, // byte
				// names of persistent elements
				"char1s":4, // char
				// names of persistent elements
				"stringNull":10, // java.lang.String
				// names of persistent elements
				"char2s":4, // char
				// names of persistent elements
				"short1s":3, // short
				// names of persistent elements
				"int1s":5, // int
				// names of persistent elements
				"long1s":6, // long
				// names of persistent elements
				"float1s":7, // float
				// names of persistent elements
				"double1s":8, // double
				// names of persistent elements
				"string1s":10, // java.lang.String
				// names of persistent elements
				"ALL":142458, // com.wilutions.byps.test.api.cons.AllTypesZ
				// names of persistent elements
				"arrInt":100361105, // int[]
				// names of persistent elements
				"arrInt4":39910537, // int[][][][]
				// names of persistent elements
				"arrStrings":1888107655, // java.lang.String[]
				// names of persistent elements
				"arrStrings4":588723219, // java.lang.String[][][][]
				// names of persistent elements
				"arrALL":1981543076 // com.wilutions.byps.test.api.cons.AllTypesZ[][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arrInt":100361105, // int[]
				// names of inline elements
				"arrInt4":39910537, // int[][][][]
				// names of inline elements
				"arrStrings":1888107655, // java.lang.String[]
				// names of inline elements
				"arrStrings4":588723219, // java.lang.String[][][][]
				// names of inline elements
				"arrALL":1981543076 // com.wilutions.byps.test.api.cons.AllTypesZ[][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.cons.AllTypesZ
		142458 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"bool1":1, // boolean
				// names of persistent elements
				"byte1":2, // byte
				// names of persistent elements
				"char1":4, // char
				// names of persistent elements
				"short1":3, // short
				// names of persistent elements
				"int1":5, // int
				// names of persistent elements
				"long1":6, // long
				// names of persistent elements
				"float1":7, // float
				// names of persistent elements
				"double1":8, // double
				// names of persistent elements
				"string1":10, // java.lang.String
				// names of persistent elements
				"hebrew1":1518668429, // com.wilutions.byps.test.api.cons.HebrewZ
				// names of persistent elements
				"byte2":1374008726, // byte[]
				// names of persistent elements
				"int2":100361105, // int[]
				// names of persistent elements
				"string2":1888107655, // java.lang.String[]
				// names of persistent elements
				"hebrew2":2092671091 // com.wilutions.byps.test.api.cons.HebrewZ[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":1374008726, // byte[]
				// names of inline elements
				"int2":100361105, // int[]
				// names of inline elements
				"string2":1888107655, // java.lang.String[]
				// names of inline elements
				"hebrew2":2092671091 // com.wilutions.byps.test.api.cons.HebrewZ[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.cons.AllTypesZ[][]
		1981543076 : new com.wilutions.byps.BSerializerArray(
			142458, // Element type: com.wilutions.byps.test.api.cons.AllTypesZ
			2
		),
		
		// com.wilutions.byps.test.api.cons.HebrewC
		691741677 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"aleph":10, // java.lang.String
				// names of persistent elements
				"beth":10, // java.lang.String
				// names of persistent elements
				"ALEPH":1518668429, // com.wilutions.byps.test.api.cons.HebrewZ
				// names of persistent elements
				"BETH":1518668429 // com.wilutions.byps.test.api.cons.HebrewZ
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.cons.HebrewZ
		1518668429 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"core":10 // java.lang.String
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.cons.HebrewZ[]
		2092671091 : new com.wilutions.byps.BSerializerArray(
			1518668429, // Element type: com.wilutions.byps.test.api.cons.HebrewZ
			1
		),
		
		// com.wilutions.byps.test.api.enu.EnumPlanets[]
		1092048313 : new com.wilutions.byps.BSerializerArray(
			1042475995, // Element type: com.wilutions.byps.test.api.enu.EnumPlanets
			1
		),
		
		// com.wilutions.byps.test.api.enu.UsePlanets
		10000 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"planet":1042475995, // com.wilutions.byps.test.api.enu.EnumPlanets
				// names of persistent elements
				"planet2":1042475995, // com.wilutions.byps.test.api.enu.EnumPlanets
				// names of persistent elements
				"arrayOfPlanets":1092048313, // com.wilutions.byps.test.api.enu.EnumPlanets[]
				// names of persistent elements
				"listOfPlanets":1590740862, // java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
				// names of persistent elements
				"mapOfPlanets":252873856 // java.util.Map<java.lang.String,com.wilutions.byps.test.api.enu.EnumPlanets>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arrayOfPlanets":1092048313, // com.wilutions.byps.test.api.enu.EnumPlanets[]
				// names of inline elements
				"listOfPlanets":1590740862, // java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
				// names of inline elements
				"mapOfPlanets":252873856 // java.util.Map<java.lang.String,com.wilutions.byps.test.api.enu.EnumPlanets>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.inherit.Class1
		6001 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":5, // int
				// names of persistent elements
				"nextClass1":6001 // com.wilutions.byps.test.api.inherit.Class1
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.inherit.Class1Collections
		6004 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"list1":317887457, // java.util.List<com.wilutions.byps.test.api.inherit.Class1>
				// names of persistent elements
				"map1":981592984, // java.util.Map<java.lang.String,com.wilutions.byps.test.api.inherit.Class1>
				// names of persistent elements
				"set1":2114305573 // java.util.Set<com.wilutions.byps.test.api.inherit.Class1>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"list1":317887457, // java.util.List<com.wilutions.byps.test.api.inherit.Class1>
				// names of inline elements
				"map1":981592984, // java.util.Map<java.lang.String,com.wilutions.byps.test.api.inherit.Class1>
				// names of inline elements
				"set1":2114305573 // java.util.Set<com.wilutions.byps.test.api.inherit.Class1>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.inherit.Class2
		6002 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.inherit.Class3
		6003 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int3":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.inl.Actor
		171948703 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"shape":2049740106, // com.wilutions.byps.test.api.inl.Point2D[]
				// names of persistent elements
				"position":135329019 // com.wilutions.byps.test.api.inl.Matrix2D
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"shape":2049740106, // com.wilutions.byps.test.api.inl.Point2D[]
				// names of inline elements
				"position":135329019 // com.wilutions.byps.test.api.inl.Matrix2D
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.inl.Matrix2D
		135329019 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"_11":7, // float
				// names of persistent elements
				"_12":7, // float
				// names of persistent elements
				"_13":7, // float
				// names of persistent elements
				"_21":7, // float
				// names of persistent elements
				"_22":7, // float
				// names of persistent elements
				"_23":7, // float
				// names of persistent elements
				"_31":7, // float
				// names of persistent elements
				"_32":7, // float
				// names of persistent elements
				"_33":7 // float
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			true
		),
		
		// com.wilutions.byps.test.api.inl.Point2D
		1835035436 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"x":3, // short
				// names of persistent elements
				"y":3 // short
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			true
		),
		
		// com.wilutions.byps.test.api.inl.Point2D[]
		2049740106 : new com.wilutions.byps.BSerializerArray(
			1835035436, // Element type: com.wilutions.byps.test.api.inl.Point2D
			1
		),
		
		// com.wilutions.byps.test.api.inl.Point2D[][]
		1589744084 : new com.wilutions.byps.BSerializerArray(
			1835035436, // Element type: com.wilutions.byps.test.api.inl.Point2D
			2
		),
		
		// com.wilutions.byps.test.api.inl.Point2D[][][]
		1264295566 : new com.wilutions.byps.BSerializerArray(
			1835035436, // Element type: com.wilutions.byps.test.api.inl.Point2D
			3
		),
		
		// com.wilutions.byps.test.api.inl.Point2D[][][][]
		487702928 : new com.wilutions.byps.BSerializerArray(
			1835035436, // Element type: com.wilutions.byps.test.api.inl.Point2D
			4
		),
		
		// com.wilutions.byps.test.api.list.ListListTypes
		3002 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1746702954, // java.util.List<java.util.List<java.lang.Integer>>
				// names of persistent elements
				"int3":1633500852, // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
				// names of persistent elements
				"int24":1865834185 // java.util.List<java.util.List<int[][][][]>>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int2":1746702954, // java.util.List<java.util.List<java.lang.Integer>>
				// names of inline elements
				"int3":1633500852, // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
				// names of inline elements
				"int24":1865834185 // java.util.List<java.util.List<int[][][][]>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.list.ListTypes
		3001 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1617670280, // java.util.List<java.lang.Boolean>
				// names of persistent elements
				"byte1":1059148284, // java.util.List<java.lang.Byte>
				// names of persistent elements
				"char1":1661807911, // java.util.List<java.lang.Character>
				// names of persistent elements
				"short1":1997002548, // java.util.List<java.lang.Short>
				// names of persistent elements
				"int1":181681714, // java.util.List<java.lang.Integer>
				// names of persistent elements
				"long1":1050216688, // java.util.List<java.lang.Long>
				// names of persistent elements
				"float1":1628501332, // java.util.List<java.lang.Float>
				// names of persistent elements
				"double1":1555345627, // java.util.List<java.lang.Double>
				// names of persistent elements
				"string1":2123584667, // java.util.List<java.lang.String>
				// names of persistent elements
				"primitiveTypes1":1544333227, // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"byte2":1174971318, // java.util.List<byte[]>
				// names of persistent elements
				"int2":1752158699, // java.util.List<int[]>
				// names of persistent elements
				"int4":1088217157, // java.util.List<int[][][][]>
				// names of persistent elements
				"obj1":12 // java.util.List<java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1617670280, // java.util.List<java.lang.Boolean>
				// names of inline elements
				"byte1":1059148284, // java.util.List<java.lang.Byte>
				// names of inline elements
				"char1":1661807911, // java.util.List<java.lang.Character>
				// names of inline elements
				"short1":1997002548, // java.util.List<java.lang.Short>
				// names of inline elements
				"int1":181681714, // java.util.List<java.lang.Integer>
				// names of inline elements
				"long1":1050216688, // java.util.List<java.lang.Long>
				// names of inline elements
				"float1":1628501332, // java.util.List<java.lang.Float>
				// names of inline elements
				"double1":1555345627, // java.util.List<java.lang.Double>
				// names of inline elements
				"string1":2123584667, // java.util.List<java.lang.String>
				// names of inline elements
				"primitiveTypes1":1544333227, // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of inline elements
				"byte2":1174971318, // java.util.List<byte[]>
				// names of inline elements
				"int2":1752158699, // java.util.List<int[]>
				// names of inline elements
				"int4":1088217157, // java.util.List<int[][][][]>
				// names of inline elements
				"obj1":12 // java.util.List<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.map.MapTypes
		4001 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1279823631, // java.util.Map<java.lang.String,java.lang.Boolean>
				// names of persistent elements
				"byte1":1972793385, // java.util.HashMap<java.lang.Double,java.lang.Byte>
				// names of persistent elements
				"char1":8789515, // java.util.TreeMap<java.lang.Float,java.lang.Character>
				// names of persistent elements
				"short1":601099730, // java.util.Map<java.lang.Long,java.lang.Short>
				// names of persistent elements
				"int1":1347703734, // java.util.Map<java.lang.Integer,java.lang.Integer>
				// names of persistent elements
				"long1":1973996106, // java.util.Map<java.lang.Short,java.lang.Long>
				// names of persistent elements
				"float1":94341197, // java.util.Map<java.lang.Character,java.lang.Float>
				// names of persistent elements
				"double1":1487265161, // java.util.Map<java.lang.Byte,java.lang.Double>
				// names of persistent elements
				"string1":1710660846, // java.util.Map<java.lang.String,java.lang.String>
				// names of persistent elements
				"primitiveTypes1":703065817, // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"byte2":1799280818, // java.util.Map<java.lang.Integer,byte[]>
				// names of persistent elements
				"int2":1633750383, // java.util.Map<java.lang.Integer,int[]>
				// names of persistent elements
				"obj1":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1279823631, // java.util.Map<java.lang.String,java.lang.Boolean>
				// names of inline elements
				"byte1":1972793385, // java.util.HashMap<java.lang.Double,java.lang.Byte>
				// names of inline elements
				"char1":8789515, // java.util.TreeMap<java.lang.Float,java.lang.Character>
				// names of inline elements
				"short1":601099730, // java.util.Map<java.lang.Long,java.lang.Short>
				// names of inline elements
				"int1":1347703734, // java.util.Map<java.lang.Integer,java.lang.Integer>
				// names of inline elements
				"long1":1973996106, // java.util.Map<java.lang.Short,java.lang.Long>
				// names of inline elements
				"float1":94341197, // java.util.Map<java.lang.Character,java.lang.Float>
				// names of inline elements
				"double1":1487265161, // java.util.Map<java.lang.Byte,java.lang.Double>
				// names of inline elements
				"string1":1710660846, // java.util.Map<java.lang.String,java.lang.String>
				// names of inline elements
				"primitiveTypes1":703065817, // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of inline elements
				"byte2":1799280818, // java.util.Map<java.lang.Integer,byte[]>
				// names of inline elements
				"int2":1633750383, // java.util.Map<java.lang.Integer,int[]>
				// names of inline elements
				"obj1":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes
		1000 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolVal":1, // boolean
				// names of persistent elements
				"byteVal":2, // byte
				// names of persistent elements
				"charVal":4, // char
				// names of persistent elements
				"shortVal":3, // short
				// names of persistent elements
				"intVal":5, // int
				// names of persistent elements
				"longVal":6, // long
				// names of persistent elements
				"floatVal":7, // float
				// names of persistent elements
				"doubleVal":8, // double
				// names of persistent elements
				"stringVal":10, // java.lang.String
				// names of persistent elements
				"objVal":21, // java.lang.Object
				// names of persistent elements
				"objVal2":21, // java.lang.Object
				// names of persistent elements
				"value":1, // boolean
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[]
		801243127 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			1
		),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[][]
		1195496149 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			2
		),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[][][]
		2115528243 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			3
		),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
		1503107601 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			4
		),
		
		// com.wilutions.byps.test.api.priv.PrivateMembers
		8001 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolVal":1, // boolean
				// names of persistent elements
				"byteVal":2, // byte
				// names of persistent elements
				"charVal":4, // char
				// names of persistent elements
				"shortVal":3, // short
				// names of persistent elements
				"intVal":5, // int
				// names of persistent elements
				"longVal":6, // long
				// names of persistent elements
				"floatVal":7, // float
				// names of persistent elements
				"doubleVal":8, // double
				// names of persistent elements
				"stringVal":10, // java.lang.String
				// names of persistent elements
				"primitiveTypes":1000, // com.wilutions.byps.test.api.prim.PrimitiveTypes
				// names of persistent elements
				"arrBool":2058423690, // boolean[]
				// names of persistent elements
				"arrInt":100361105, // int[]
				// names of persistent elements
				"arrString":1888107655, // java.lang.String[]
				// names of persistent elements
				"arrPrimitiveTypes":801243127, // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
				// names of persistent elements
				"listBool":1617670280, // java.util.List<java.lang.Boolean>
				// names of persistent elements
				"listInt":181681714, // java.util.List<java.lang.Integer>
				// names of persistent elements
				"listString":2123584667, // java.util.List<java.lang.String>
				// names of persistent elements
				"listPrimitiveTypes":1544333227, // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"mapIntListString":132175071, // java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
				// names of persistent elements
				"protInt":5, // int
				// names of persistent elements
				"pprotInt":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arrBool":2058423690, // boolean[]
				// names of inline elements
				"arrInt":100361105, // int[]
				// names of inline elements
				"arrString":1888107655, // java.lang.String[]
				// names of inline elements
				"arrPrimitiveTypes":801243127, // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
				// names of inline elements
				"listBool":1617670280, // java.util.List<java.lang.Boolean>
				// names of inline elements
				"listInt":181681714, // java.util.List<java.lang.Integer>
				// names of inline elements
				"listString":2123584667, // java.util.List<java.lang.String>
				// names of inline elements
				"listPrimitiveTypes":1544333227, // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of inline elements
				"mapIntListString":132175071, // java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.refs.Node
		9001 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"next":9001, // com.wilutions.byps.test.api.refs.Node
				// names of persistent elements
				"me":9001, // com.wilutions.byps.test.api.refs.Node
				// names of persistent elements
				"mapOfNodes":1768677016, // java.util.Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>
				// names of persistent elements
				"listOfNodes":202657921 // java.util.List<com.wilutions.byps.test.api.refs.Node>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"mapOfNodes":1768677016, // java.util.Map<java.lang.String,com.wilutions.byps.test.api.refs.Node>
				// names of inline elements
				"listOfNodes":202657921 // java.util.List<com.wilutions.byps.test.api.refs.Node>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getBool
		1645604187 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getByte
		1645613945 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getChar
		1645626823 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getDouble
		935089666 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getFloat
		522273269 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getInt
		1609477282 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getLong
		1645902061 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getObject
		1237679472 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
		825201405 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getShort
		510386133 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getString
		1369061954 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setBool
		589253529 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2058423690 // boolean[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":2058423690 // boolean[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setByte
		589243771 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1374008726 // byte[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1374008726 // byte[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setChar
		589230893 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1361632968 // char[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1361632968 // char[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setDouble
		720472590 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1359468275 // double[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1359468275 // double[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setFloat
		1083385729 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":766441794 // float[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":766441794 // float[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setInt
		1265927470 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":100361105 // int[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":100361105 // int[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setLong
		588955655 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1097129250 // long[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1097129250 // long[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setObject
		1023062396 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":183594037 // java.lang.Object[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":183594037 // java.lang.Object[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
		1765354225 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setShort
		1071498593 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2067161310 // short[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":2067161310 // short[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setString
		1154444878 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1888107655 // java.lang.String[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1888107655 // java.lang.String[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysClass
		1004457221 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":1195496149, // com.wilutions.byps.test.api.prim.PrimitiveTypes[][]
				// names of persistent elements
				"arr3":2115528243, // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][]
				// names of persistent elements
				"arr4":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arr2":1195496149, // com.wilutions.byps.test.api.prim.PrimitiveTypes[][]
				// names of inline elements
				"arr3":2115528243, // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][]
				// names of inline elements
				"arr4":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInline
		899462794 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":1589744084, // com.wilutions.byps.test.api.inl.Point2D[][]
				// names of persistent elements
				"arr3":1264295566, // com.wilutions.byps.test.api.inl.Point2D[][][]
				// names of persistent elements
				"arr4":487702928 // com.wilutions.byps.test.api.inl.Point2D[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arr2":1589744084, // com.wilutions.byps.test.api.inl.Point2D[][]
				// names of inline elements
				"arr3":1264295566, // com.wilutions.byps.test.api.inl.Point2D[][][]
				// names of inline elements
				"arr4":487702928 // com.wilutions.byps.test.api.inl.Point2D[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInt
		1748523470 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":1957744307, // int[][]
				// names of persistent elements
				"arr3":196606293, // int[][][]
				// names of persistent elements
				"arr4":39910537 // int[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arr2":1957744307, // int[][]
				// names of inline elements
				"arr3":196606293, // int[][][]
				// names of inline elements
				"arr4":39910537 // int[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysObject
		738833892 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":340213335, // java.lang.Object[][]
				// names of persistent elements
				"arr3":527503353, // java.lang.Object[][][]
				// names of persistent elements
				"arr4":124584219 // java.lang.Object[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arr2":340213335, // java.lang.Object[][]
				// names of inline elements
				"arr3":527503353, // java.lang.Object[][][]
				// names of inline elements
				"arr4":124584219 // java.lang.Object[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysString
		607451410 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":1995260457, // java.lang.String[][]
				// names of persistent elements
				"arr3":1889888075, // java.lang.String[][][]
				// names of persistent elements
				"arr4":588723219 // java.lang.String[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arr2":1995260457, // java.lang.String[][]
				// names of inline elements
				"arr3":1889888075, // java.lang.String[][][]
				// names of inline elements
				"arr4":588723219 // java.lang.String[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getBool
		2032852344 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getByte
		2032862102 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getChar
		2032874980 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getDouble
		581586209 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getFloat
		1402482290 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getInt
		1589603233 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getLong
		2033150218 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getObject
		278996403 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getPrimitiveTypes
		1650564320 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getShort
		1390595154 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getString
		147613921 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setBool
		202005372 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":945713488 // boolean[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":945713488 // boolean[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setByte
		201995614 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1201775504 // byte[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1201775504 // byte[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setChar
		201982736 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":769021986 // char[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":769021986 // char[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setDouble
		796203285 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2087445849 // double[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":2087445849 // double[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setFloat
		1963594750 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1516687588 // float[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1516687588 // float[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setInt
		1933153045 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":39910537 // int[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":39910537 // int[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setLong
		201707498 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":846419204 // long[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":846419204 // long[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setObject
		493613479 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":124584219 // java.lang.Object[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":124584219 // java.lang.Object[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
		710411500 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setShort
		1951707614 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1859644668 // short[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1859644668 // short[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setString
		362230997 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":588723219 // java.lang.String[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":588723219 // java.lang.String[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteConstants_compare_AllTypesC
		862752254 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"bool1s":1, // boolean
				// names of persistent elements
				"bool2s":1, // boolean
				// names of persistent elements
				"char1s":4, // char
				// names of persistent elements
				"stringNull":10, // java.lang.String
				// names of persistent elements
				"char2s":4, // char
				// names of persistent elements
				"short1s":3, // short
				// names of persistent elements
				"int1s":5, // int
				// names of persistent elements
				"long1s":6, // long
				// names of persistent elements
				"float1s":7, // float
				// names of persistent elements
				"double1s":8, // double
				// names of persistent elements
				"string1s":10, // java.lang.String
				// names of persistent elements
				"ALL":142458, // com.wilutions.byps.test.api.cons.AllTypesZ
				// names of persistent elements
				"arrInt":100361105, // int[]
				// names of persistent elements
				"arrInt4":39910537, // int[][][][]
				// names of persistent elements
				"arrStrings":1888107655, // java.lang.String[]
				// names of persistent elements
				"arrStrings4":588723219, // java.lang.String[][][][]
				// names of persistent elements
				"arrAll":1981543076 // com.wilutions.byps.test.api.cons.AllTypesZ[][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arrInt":100361105, // int[]
				// names of inline elements
				"arrInt4":39910537, // int[][][][]
				// names of inline elements
				"arrStrings":1888107655, // java.lang.String[]
				// names of inline elements
				"arrStrings4":588723219, // java.lang.String[][][][]
				// names of inline elements
				"arrAll":1981543076 // com.wilutions.byps.test.api.cons.AllTypesZ[][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteConstants_compare_HebrewC
		1570751625 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"ALEPH":1518668429, // com.wilutions.byps.test.api.cons.HebrewZ
				// names of persistent elements
				"BETH":1518668429 // com.wilutions.byps.test.api.cons.HebrewZ
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_getPlanet
		627010462 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_setPlanet
		412393386 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"planet":1042475995 // com.wilutions.byps.test.api.enu.EnumPlanets
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActor
		261822861 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray1dim
		1011970102 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray4dim
		1012059475 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DList
		1996093752 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DListList
		177127926 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DMap
		1321082494 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActor
		299289599 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"act":171948703 // com.wilutions.byps.test.api.inl.Actor
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray1dim
		531757758 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointArray":2049740106 // com.wilutions.byps.test.api.inl.Point2D[]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointArray":2049740106 // com.wilutions.byps.test.api.inl.Point2D[]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray4dim
		531668385 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointArray":487702928 // com.wilutions.byps.test.api.inl.Point2D[][][][]
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointArray":487702928 // com.wilutions.byps.test.api.inl.Point2D[][][][]
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DList
		224357548 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointList":172221196 // java.util.List<com.wilutions.byps.test.api.inl.Point2D>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointList":172221196 // java.util.List<com.wilutions.byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DListList
		1097161578 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointListList":1463615848 // java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointListList":1463615848 // java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DMap
		546951282 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointMap":1851881336 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointMap":1851881336 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getBoolean1
		1794077576 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getByte1
		1319541530 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getByte2
		1319541531 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getChar1
		1319940748 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getDouble1
		1741299407 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getFloat1
		1941525372 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt1
		874047761 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt2
		874047762 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt3
		874047763 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt4
		874047764 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getLong1
		1328473126 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getObj1
		874214665 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getPrimitiveTypes1
		1940572240 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getShort1
		1573024156 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getString1
		1173060367 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setBoolean1
		1882657404 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1617670280 // java.util.List<java.lang.Boolean>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1617670280 // java.util.List<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setByte1
		758429070 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte1":1059148284 // java.util.List<java.lang.Byte>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte1":1059148284 // java.util.List<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setByte2
		758429071 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte2":1174971318 // java.util.List<byte[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":1174971318 // java.util.List<byte[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setChar1
		758828288 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"char1":1661807911 // java.util.List<java.lang.Character>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"char1":1661807911 // java.util.List<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setDouble1
		195505829 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"double1":1555345627 // java.util.List<java.lang.Double>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"double1":1555345627 // java.util.List<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setFloat1
		2138824848 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"float1":1628501332 // java.util.List<java.lang.Float>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"float1":1628501332 // java.util.List<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt1
		1360809955 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":181681714 // java.util.List<java.lang.Integer>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int1":181681714 // java.util.List<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt2
		1360809954 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1752158699 // java.util.List<int[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int2":1752158699 // java.util.List<int[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt3
		1360809953 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int3":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int3":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt4
		1360809952 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int4":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int4":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setLong1
		767360666 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"long1":1050216688 // java.util.List<java.lang.Long>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"long1":1050216688 // java.util.List<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setObj1
		1360643051 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":12 // java.util.List<java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":12 // java.util.List<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setPrimitiveTypes1
		1434361404 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"primitiveTypes1":1544333227 // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"primitiveTypes1":1544333227 // java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setShort1
		1787641232 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"short1":1997002548 // java.util.List<java.lang.Short>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"short1":1997002548 // java.util.List<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setString1
		763744869 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"string1":2123584667 // java.util.List<java.lang.String>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"string1":2123584667 // java.util.List<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getBoolean1
		461626272 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getByte1
		1348711374 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getByte2
		1348711373 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getChar1
		1348312156 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getDouble1
		1836864439 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getFloat1
		1241980524 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getInt1
		1013140231 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getInt2
		1013140230 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getLong1
		1339779778 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getObj1
		1012973327 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getPrimitiveTypes1
		77071512 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getShort1
		1610481740 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getString1
		1268625399 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setBoolean1
		550206100 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte1
		1909823834 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte1":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte1":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte2
		1909823833 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte2":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setChar1
		1909424616 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"char1":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"char1":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setDouble1
		99940797 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"double1":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"double1":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setFloat1
		1027363448 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"float1":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"float1":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setInt1
		1046969349 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int1":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setInt2
		1046969350 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int2":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setLong1
		1900892238 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"long1":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"long1":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setObj1
		1047136253 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setPrimitiveTypes1
		842962140 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"primitiveTypes1":703065817 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"primitiveTypes1":703065817 // java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setShort1
		1395864664 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"short1":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"short1":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setString1
		668179837 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"string1":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"string1":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_add
		1073583639 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"a":5, // int
				// names of persistent elements
				"b":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getBool
		2090997206 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getByte
		2091006964 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getChar
		2091019842 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDouble
		538948675 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getFloat
		400008432 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getInt
		1318015101 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getLong
		2091295080 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getObject
		236358869 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getPrimitiveTypes
		1881962430 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getShort
		411895568 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getString
		104976387 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
		1794219594 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"b":1, // boolean
				// names of persistent elements
				"c":4, // char
				// names of persistent elements
				"s":3, // short
				// names of persistent elements
				"i":5, // int
				// names of persistent elements
				"l":6, // long
				// names of persistent elements
				"f":7, // float
				// names of persistent elements
				"d":8, // double
				// names of persistent elements
				"str":10, // java.lang.String
				// names of persistent elements
				"pt":1000, // com.wilutions.byps.test.api.prim.PrimitiveTypes
				// names of persistent elements
				"o":21 // java.lang.Object
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setBool
		143860510 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1 // boolean
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setByte
		143850752 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2 // byte
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setChar
		143837874 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":4 // char
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
		753565751 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":8 // double
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setFloat
		161104028 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":7 // float
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setInt
		974465289 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setLong
		143562636 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":6 // long
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setObject
		450975945 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":21 // java.lang.Object
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setPrimitiveTypes
		941809610 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1000 // com.wilutions.byps.test.api.prim.PrimitiveTypes
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setShort
		149216892 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":3 // short
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setString
		319593463 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":10 // java.lang.String
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_voidFunctionVoid
		1856936054 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_getNode
		655936732 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_setNode
		1404172848 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":9001 // com.wilutions.byps.test.api.refs.Node
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteServerCtrl_getPublishedRemote
		1216543212 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"name":10 // java.lang.String
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteServerCtrl_publishRemote
		1776814809 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"name":10, // java.lang.String
				// names of persistent elements
				"remote":16, // com.wilutions.byps.BRemote
				// names of persistent elements
				"fowardToOtherServers":1 // boolean
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteServerCtrl_removePublishedRemote
		1302703010 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"name":10 // java.lang.String
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getBoolean1
		1690813926 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getByte1
		2125684552 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getByte2
		2125684551 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getChar1
		2125285334 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getDouble1
		1183778993 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getFloat1
		1369351514 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getInt1
		68372557 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getInt2
		68372556 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getLong1
		2116752956 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getObj1
		68205653 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getPrimitiveTypes1
		1802821742 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getShort1
		1000850298 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getString1
		615539953 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setBoolean1
		1779393754 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte1
		1608170284 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte1":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte1":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte2
		1608170285 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte2":2052431866 // java.util.Set<byte[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":2052431866 // java.util.Set<byte[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setChar1
		1608569502 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"char1":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"char1":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setDouble1
		753026243 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"double1":1320560671 // java.util.Set<java.lang.Double>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"double1":1320560671 // java.util.Set<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setFloat1
		1583968590 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"float1":1898022288 // java.util.Set<java.lang.Float>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"float1":1898022288 // java.util.Set<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setInt1
		1991737023 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":1493282670 // java.util.Set<java.lang.Integer>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int1":1493282670 // java.util.Set<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setInt2
		1991737024 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1406124761 // java.util.Set<int[]>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int2":1406124761 // java.util.Set<int[]>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setLong1
		1617101880 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"long1":1457164460 // java.util.Set<java.lang.Long>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"long1":1457164460 // java.util.Set<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setObj1
		1991903927 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":14 // java.util.Set<java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":14 // java.util.Set<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setPrimitiveTypes1
		1572111902 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"primitiveTypes1":1280571537 // java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"primitiveTypes1":1280571537 // java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setShort1
		1215467374 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"short1":2028443792 // java.util.Set<java.lang.Short>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"short1":2028443792 // java.util.Set<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setString1
		1321265283 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"string1":1888799711 // java.util.Set<java.lang.String>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"string1":1888799711 // java.util.Set<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImage
		1902276204 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImages
		1158979935 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getTextStream
		1083407988 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImage
		1831578632 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"istrm":15 // java.io.InputStream
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImages
		944362859 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"istrms":779528402, // java.util.Map<java.lang.Integer,java.io.InputStream>
				// names of persistent elements
				"doNotReadStreamAtKey":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"istrms":779528402, // java.util.Map<java.lang.Integer,java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_throwLastException
		2047657918 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_doit
		388793292 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sess":65775978, // com.wilutions.byps.test.api.auth.SessionInfo
				// names of persistent elements
				"value":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_expire
		68943581 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sess":65775978 // com.wilutions.byps.test.api.auth.SessionInfo
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_login
		839695851 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sess":65775978, // com.wilutions.byps.test.api.auth.SessionInfo
				// names of persistent elements
				"userName":10, // java.lang.String
				// names of persistent elements
				"userPwd":10 // java.lang.String
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_setReloginCount
		20608797 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"count":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteWithAuthentication_setUseAuthentication
		1785294043 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"useAuth":1 // boolean
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim
		1557084481 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23
		2081058997 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim
		1557173854 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteConstants
		431648293 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteConstants),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteEnums
		359349400 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteEnums),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance
		1206670536 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteListTypes
		380156079 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteListTypes),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes
		80483097 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes),
		
		// com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes
		1341983932 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteReferences
		2086824050 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteReferences),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl
		1124545992 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes
		1156008353 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteStreams
		2028487863 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteStreams),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication
		1677934392 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication),
		
		// com.wilutions.byps.test.api.set.SetTypes
		5001 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1365696060, // java.util.Set<java.lang.Boolean>
				// names of persistent elements
				"byte1":31512998, // java.util.HashSet<java.lang.Byte>
				// names of persistent elements
				"char1":936607009, // java.util.TreeSet<java.lang.Character>
				// names of persistent elements
				"short1":2028443792, // java.util.Set<java.lang.Short>
				// names of persistent elements
				"int1":1493282670, // java.util.Set<java.lang.Integer>
				// names of persistent elements
				"long1":1457164460, // java.util.Set<java.lang.Long>
				// names of persistent elements
				"float1":1898022288, // java.util.Set<java.lang.Float>
				// names of persistent elements
				"double1":1320560671, // java.util.Set<java.lang.Double>
				// names of persistent elements
				"string1":1888799711, // java.util.Set<java.lang.String>
				// names of persistent elements
				"primitiveTypes1":1280571537, // java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"byte2":2052431866, // java.util.Set<byte[]>
				// names of persistent elements
				"int2":1406124761, // java.util.Set<int[]>
				// names of persistent elements
				"obj1":14 // java.util.Set<java.lang.Object>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1365696060, // java.util.Set<java.lang.Boolean>
				// names of inline elements
				"byte1":31512998, // java.util.HashSet<java.lang.Byte>
				// names of inline elements
				"char1":936607009, // java.util.TreeSet<java.lang.Character>
				// names of inline elements
				"short1":2028443792, // java.util.Set<java.lang.Short>
				// names of inline elements
				"int1":1493282670, // java.util.Set<java.lang.Integer>
				// names of inline elements
				"long1":1457164460, // java.util.Set<java.lang.Long>
				// names of inline elements
				"float1":1898022288, // java.util.Set<java.lang.Float>
				// names of inline elements
				"double1":1320560671, // java.util.Set<java.lang.Double>
				// names of inline elements
				"string1":1888799711, // java.util.Set<java.lang.String>
				// names of inline elements
				"primitiveTypes1":1280571537, // java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				// names of inline elements
				"byte2":2052431866, // java.util.Set<byte[]>
				// names of inline elements
				"int2":1406124761, // java.util.Set<int[]>
				// names of inline elements
				"obj1":14 // java.util.Set<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_getStreams
		865920738 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"ctrl":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_incrementInt
		1461829915 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"a":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_putStreams
		242798857 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"strm":1218831438, // java.util.List<java.io.InputStream>
				// names of persistent elements
				"ctrl":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"strm":1218831438, // java.util.List<java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_sendChat
		1352392091 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"cs":7007 // com.wilutions.byps.test.api.srvr.ChatStructure
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientIncrementInt
		1252575894 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientParallel
		1340180893 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClient
		2107407220 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"id":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClientIds
		2063368540 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getPartner
		748402113 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getStreamsFromClient
		1415283169 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_putStreamsOnClient
		1367013829 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"streams":1218831438 // java.util.List<java.io.InputStream>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"streams":1218831438 // java.util.List<java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_registerWithClientMap
		1921080901 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"id":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_setPartner
		1188403123 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"client":1784257353 // com.wilutions.byps.test.api.srvr.ClientIF
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.srvr.BStub_ClientIF
		1784257353 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.srvr.BStub_ClientIF),
		
		// com.wilutions.byps.test.api.srvr.BStub_ServerIF
		1313562065 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.srvr.BStub_ServerIF),
		
		// com.wilutions.byps.test.api.srvr.ChatStructure
		7007 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"msg":10, // java.lang.String
				// names of persistent elements
				"sentAt":8, // double
				// names of persistent elements
				"receivedAt":8 // double
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.strm.Stream1
		1541129345 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"is1":15, // java.io.InputStream
				// names of persistent elements
				"contentType":10, // java.lang.String
				// names of persistent elements
				"arrStream":1950626768, // java.io.InputStream[]
				// names of persistent elements
				"listStream":1218831438, // java.util.List<java.io.InputStream>
				// names of persistent elements
				"mapStream":779528402 // java.util.Map<java.lang.Integer,java.io.InputStream>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arrStream":1950626768, // java.io.InputStream[]
				// names of inline elements
				"listStream":1218831438, // java.util.List<java.io.InputStream>
				// names of inline elements
				"mapStream":779528402 // java.util.Map<java.lang.Integer,java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getClient
		98720592 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getEvolve
		32041374 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_sendEvolveToClient
		1425170268 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setClient
		313337668 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"partner":2078696281 // com.wilutions.byps.test.api.ver.EvolveIF
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setEvolve
		246658450 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj":1391985860 // com.wilutions.byps.test.api.ver.Evolve
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.ver.BStub_EvolveIF
		2078696281 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.ver.BStub_EvolveIF),
		
		// com.wilutions.byps.test.api.ver.Evolve
		1391985860 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"bool1":1, // boolean
				// names of persistent elements
				"byte1":2, // byte
				// names of persistent elements
				"char1":4, // char
				// names of persistent elements
				"short1":3, // short
				// names of persistent elements
				"int1":5, // int
				// names of persistent elements
				"long1":6, // long
				// names of persistent elements
				"float1":7, // float
				// names of persistent elements
				"double1":8, // double
				// names of persistent elements
				"bools1":2058423690, // boolean[]
				// names of persistent elements
				"bytes1":1374008726, // byte[]
				// names of persistent elements
				"chars1":1361632968, // char[]
				// names of persistent elements
				"shorts1":2067161310, // short[]
				// names of persistent elements
				"ints1":100361105, // int[]
				// names of persistent elements
				"longs1":1097129250, // long[]
				// names of persistent elements
				"floats1":766441794, // float[]
				// names of persistent elements
				"doubles1":1359468275, // double[]
				// names of persistent elements
				"str1":10, // java.lang.String
				// names of persistent elements
				"obj1":21, // java.lang.Object
				// names of persistent elements
				"evo1":573592593, // com.wilutions.byps.test.api.ver.Evolve2
				// names of persistent elements
				"list1":181681714, // java.util.List<java.lang.Integer>
				// names of persistent elements
				"set1":1493282670, // java.util.Set<java.lang.Integer>
				// names of persistent elements
				"map1":1347703734, // java.util.Map<java.lang.Integer,java.lang.Integer>
				// names of persistent elements
				"bool2":1, // boolean
				// names of persistent elements
				"byte2":2, // byte
				// names of persistent elements
				"char2":4, // char
				// names of persistent elements
				"short2":3, // short
				// names of persistent elements
				"int2":5, // int
				// names of persistent elements
				"long2":6, // long
				// names of persistent elements
				"float2":7, // float
				// names of persistent elements
				"double2":8, // double
				// names of persistent elements
				"bools2":2058423690, // boolean[]
				// names of persistent elements
				"bytes2":1374008726, // byte[]
				// names of persistent elements
				"chars2":1361632968, // char[]
				// names of persistent elements
				"shorts2":2067161310, // short[]
				// names of persistent elements
				"ints2":100361105, // int[]
				// names of persistent elements
				"longs2":1097129250, // long[]
				// names of persistent elements
				"floats2":766441794, // float[]
				// names of persistent elements
				"doubles2":1359468275, // double[]
				// names of persistent elements
				"str2":10, // java.lang.String
				// names of persistent elements
				"obj2":21, // java.lang.Object
				// names of persistent elements
				"evo2":573592593, // com.wilutions.byps.test.api.ver.Evolve2
				// names of persistent elements
				"list2":181681714, // java.util.List<java.lang.Integer>
				// names of persistent elements
				"set2":1493282670, // java.util.Set<java.lang.Integer>
				// names of persistent elements
				"map2":1347703734, // java.util.Map<java.lang.Integer,java.lang.Integer>
				// names of persistent elements
				"bool3":1, // boolean
				// names of persistent elements
				"byte3":2, // byte
				// names of persistent elements
				"char3":4, // char
				// names of persistent elements
				"short3":3, // short
				// names of persistent elements
				"int3":5, // int
				// names of persistent elements
				"long3":6, // long
				// names of persistent elements
				"float3":7, // float
				// names of persistent elements
				"double3":8, // double
				// names of persistent elements
				"bools3":2058423690, // boolean[]
				// names of persistent elements
				"bytes3":1374008726, // byte[]
				// names of persistent elements
				"chars3":1361632968, // char[]
				// names of persistent elements
				"shorts3":2067161310, // short[]
				// names of persistent elements
				"ints3":100361105, // int[]
				// names of persistent elements
				"longs3":1097129250, // long[]
				// names of persistent elements
				"floats3":766441794, // float[]
				// names of persistent elements
				"doubles3":1359468275, // double[]
				// names of persistent elements
				"str3":10, // java.lang.String
				// names of persistent elements
				"obj3":21, // java.lang.Object
				// names of persistent elements
				"evo3":573592593, // com.wilutions.byps.test.api.ver.Evolve2
				// names of persistent elements
				"list3":181681714, // java.util.List<java.lang.Integer>
				// names of persistent elements
				"set3":1493282670, // java.util.Set<java.lang.Integer>
				// names of persistent elements
				"map3":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"bools1":2058423690, // boolean[]
				// names of inline elements
				"bytes1":1374008726, // byte[]
				// names of inline elements
				"chars1":1361632968, // char[]
				// names of inline elements
				"shorts1":2067161310, // short[]
				// names of inline elements
				"ints1":100361105, // int[]
				// names of inline elements
				"longs1":1097129250, // long[]
				// names of inline elements
				"floats1":766441794, // float[]
				// names of inline elements
				"doubles1":1359468275, // double[]
				// names of inline elements
				"list1":181681714, // java.util.List<java.lang.Integer>
				// names of inline elements
				"set1":1493282670, // java.util.Set<java.lang.Integer>
				// names of inline elements
				"map1":1347703734, // java.util.Map<java.lang.Integer,java.lang.Integer>
				// names of inline elements
				"bools2":2058423690, // boolean[]
				// names of inline elements
				"bytes2":1374008726, // byte[]
				// names of inline elements
				"chars2":1361632968, // char[]
				// names of inline elements
				"shorts2":2067161310, // short[]
				// names of inline elements
				"ints2":100361105, // int[]
				// names of inline elements
				"longs2":1097129250, // long[]
				// names of inline elements
				"floats2":766441794, // float[]
				// names of inline elements
				"doubles2":1359468275, // double[]
				// names of inline elements
				"list2":181681714, // java.util.List<java.lang.Integer>
				// names of inline elements
				"set2":1493282670, // java.util.Set<java.lang.Integer>
				// names of inline elements
				"map2":1347703734, // java.util.Map<java.lang.Integer,java.lang.Integer>
				// names of inline elements
				"bools3":2058423690, // boolean[]
				// names of inline elements
				"bytes3":1374008726, // byte[]
				// names of inline elements
				"chars3":1361632968, // char[]
				// names of inline elements
				"shorts3":2067161310, // short[]
				// names of inline elements
				"ints3":100361105, // int[]
				// names of inline elements
				"longs3":1097129250, // long[]
				// names of inline elements
				"floats3":766441794, // float[]
				// names of inline elements
				"doubles3":1359468275, // double[]
				// names of inline elements
				"list3":181681714, // java.util.List<java.lang.Integer>
				// names of inline elements
				"set3":1493282670, // java.util.Set<java.lang.Integer>
				// names of inline elements
				"map3":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// com.wilutions.byps.test.api.ver.Evolve2
		573592593 : new com.wilutions.byps.BSerializer(
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"n1":5 // int
			},
			// checkpoint com.wilutions.byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// double[]
		1359468275 : new com.wilutions.byps.BSerializerArray(
			8, // Element type: double
			1
		),
		
		// double[][][][]
		2087445849 : new com.wilutions.byps.BSerializerArray(
			8, // Element type: double
			4
		),
		
		// float[]
		766441794 : new com.wilutions.byps.BSerializerArray(
			7, // Element type: float
			1
		),
		
		// float[][][][]
		1516687588 : new com.wilutions.byps.BSerializerArray(
			7, // Element type: float
			4
		),
		
		// int[]
		100361105 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: int
			1
		),
		
		// int[][]
		1957744307 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: int
			2
		),
		
		// int[][][]
		196606293 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: int
			3
		),
		
		// int[][][][]
		39910537 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: int
			4
		),
		
		// java.io.InputStream[]
		1950626768 : new com.wilutions.byps.BSerializerArray(
			15, // Element type: java.io.InputStream
			1
		),
		
		// Object[]
		183594037 : new com.wilutions.byps.BSerializerArray(
			21, // Element type: Object
			1
		),
		
		// Object[][]
		340213335 : new com.wilutions.byps.BSerializerArray(
			21, // Element type: Object
			2
		),
		
		// Object[][][]
		527503353 : new com.wilutions.byps.BSerializerArray(
			21, // Element type: Object
			3
		),
		
		// Object[][][][]
		124584219 : new com.wilutions.byps.BSerializerArray(
			21, // Element type: Object
			4
		),
		
		// String[]
		1888107655 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			1
		),
		
		// String[][]
		1995260457 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			2
		),
		
		// String[][][]
		1889888075 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			3
		),
		
		// String[][][][]
		588723219 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			4
		),
		
		// java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
		1590740862 : new com.wilutions.byps.BSerializerArray(
			1042475995, // Element type: com.wilutions.byps.test.api.enu.EnumPlanets
			1
		),
		
		// java.util.HashMap<Double,Byte>
		1972793385 : new com.wilutions.byps.BSerializerMap(
			2 // Element type: Byte
		),
		
		// java.util.HashSet<Byte>
		31512998 : new com.wilutions.byps.BSerializerArray(
			2, // Element type: Byte
			1
		),
		
		// java.util.List<byte[]>
		1174971318 : new com.wilutions.byps.BSerializerArray(
			1374008726, // Element type: byte[]
			1
		),
		
		// java.util.List<com.wilutions.byps.test.api.inherit.Class1>
		317887457 : new com.wilutions.byps.BSerializerArray(
			6001, // Element type: com.wilutions.byps.test.api.inherit.Class1
			1
		),
		
		// java.util.List<com.wilutions.byps.test.api.inl.Point2D>
		172221196 : new com.wilutions.byps.BSerializerArray(
			1835035436, // Element type: com.wilutions.byps.test.api.inl.Point2D
			1
		),
		
		// java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
		1544333227 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			1
		),
		
		// java.util.List<com.wilutions.byps.test.api.refs.Node>
		202657921 : new com.wilutions.byps.BSerializerArray(
			9001, // Element type: com.wilutions.byps.test.api.refs.Node
			1
		),
		
		// java.util.List<int[]>
		1752158699 : new com.wilutions.byps.BSerializerArray(
			100361105, // Element type: int[]
			1
		),
		
		// java.util.List<int[][][][]>
		1088217157 : new com.wilutions.byps.BSerializerArray(
			39910537, // Element type: int[][][][]
			1
		),
		
		// java.util.List<java.io.InputStream>
		1218831438 : new com.wilutions.byps.BSerializerArray(
			15, // Element type: java.io.InputStream
			1
		),
		
		// java.util.List<Boolean>
		1617670280 : new com.wilutions.byps.BSerializerArray(
			1, // Element type: Boolean
			1
		),
		
		// java.util.List<Byte>
		1059148284 : new com.wilutions.byps.BSerializerArray(
			2, // Element type: Byte
			1
		),
		
		// java.util.List<Character>
		1661807911 : new com.wilutions.byps.BSerializerArray(
			4, // Element type: Character
			1
		),
		
		// java.util.List<Double>
		1555345627 : new com.wilutions.byps.BSerializerArray(
			8, // Element type: Double
			1
		),
		
		// java.util.List<Float>
		1628501332 : new com.wilutions.byps.BSerializerArray(
			7, // Element type: Float
			1
		),
		
		// java.util.List<Integer>
		181681714 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: Integer
			1
		),
		
		// java.util.List<Long>
		1050216688 : new com.wilutions.byps.BSerializerArray(
			6, // Element type: Long
			1
		),
		
		// java.util.List<Short>
		1997002548 : new com.wilutions.byps.BSerializerArray(
			3, // Element type: Short
			1
		),
		
		// java.util.List<String>
		2123584667 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			1
		),
		
		// java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>>
		1463615848 : new com.wilutions.byps.BSerializerArray(
			172221196, // Element type: java.util.List<com.wilutions.byps.test.api.inl.Point2D>
			1
		),
		
		// java.util.List<java.util.List<int[][][][]>>
		1865834185 : new com.wilutions.byps.BSerializerArray(
			1088217157, // Element type: java.util.List<int[][][][]>
			1
		),
		
		// java.util.List<java.util.List<Integer>>
		1746702954 : new com.wilutions.byps.BSerializerArray(
			181681714, // Element type: java.util.List<Integer>
			1
		),
		
		// java.util.List<java.util.Map<Integer,java.util.List<java.util.TreeSet<Integer>>>>
		1633500852 : new com.wilutions.byps.BSerializerArray(
			49984088, // Element type: java.util.Map<Integer,java.util.List<java.util.TreeSet<Integer>>>
			1
		),
		
		// java.util.List<java.util.TreeSet<Integer>>
		724129228 : new com.wilutions.byps.BSerializerArray(
			855786668, // Element type: java.util.TreeSet<Integer>
			1
		),
		
		// java.util.Map<Byte,Double>
		1487265161 : new com.wilutions.byps.BSerializerMap(
			8 // Element type: Double
		),
		
		// java.util.Map<Character,Float>
		94341197 : new com.wilutions.byps.BSerializerMap(
			7 // Element type: Float
		),
		
		// java.util.Map<Integer,byte[]>
		1799280818 : new com.wilutions.byps.BSerializerMap(
			1374008726 // Element type: byte[]
		),
		
		// java.util.Map<Integer,com.wilutions.byps.test.api.inl.Point2D>
		1851881336 : new com.wilutions.byps.BSerializerMap(
			1835035436 // Element type: com.wilutions.byps.test.api.inl.Point2D
		),
		
		// java.util.Map<Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
		703065817 : new com.wilutions.byps.BSerializerMap(
			1000 // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
		),
		
		// java.util.Map<Integer,int[]>
		1633750383 : new com.wilutions.byps.BSerializerMap(
			100361105 // Element type: int[]
		),
		
		// java.util.Map<Integer,java.io.InputStream>
		779528402 : new com.wilutions.byps.BSerializerMap(
			15 // Element type: java.io.InputStream
		),
		
		// java.util.Map<Integer,Integer>
		1347703734 : new com.wilutions.byps.BSerializerMap(
			5 // Element type: Integer
		),
		
		// java.util.Map<Integer,java.util.List<String>>
		132175071 : new com.wilutions.byps.BSerializerMap(
			2123584667 // Element type: java.util.List<String>
		),
		
		// java.util.Map<Integer,java.util.List<java.util.TreeSet<Integer>>>
		49984088 : new com.wilutions.byps.BSerializerMap(
			724129228 // Element type: java.util.List<java.util.TreeSet<Integer>>
		),
		
		// java.util.Map<Long,Short>
		601099730 : new com.wilutions.byps.BSerializerMap(
			3 // Element type: Short
		),
		
		// java.util.Map<Short,Long>
		1973996106 : new com.wilutions.byps.BSerializerMap(
			6 // Element type: Long
		),
		
		// java.util.Map<String,com.wilutions.byps.test.api.enu.EnumPlanets>
		252873856 : new com.wilutions.byps.BSerializerMap(
			1042475995 // Element type: com.wilutions.byps.test.api.enu.EnumPlanets
		),
		
		// java.util.Map<String,com.wilutions.byps.test.api.inherit.Class1>
		981592984 : new com.wilutions.byps.BSerializerMap(
			6001 // Element type: com.wilutions.byps.test.api.inherit.Class1
		),
		
		// java.util.Map<String,com.wilutions.byps.test.api.refs.Node>
		1768677016 : new com.wilutions.byps.BSerializerMap(
			9001 // Element type: com.wilutions.byps.test.api.refs.Node
		),
		
		// java.util.Map<String,Boolean>
		1279823631 : new com.wilutions.byps.BSerializerMap(
			1 // Element type: Boolean
		),
		
		// java.util.Map<String,Object>
		1488550492 : new com.wilutions.byps.BSerializerMap(
			21 // Element type: Object
		),
		
		// java.util.Map<String,String>
		1710660846 : new com.wilutions.byps.BSerializerMap(
			10 // Element type: String
		),
		
		// java.util.Set<byte[]>
		2052431866 : new com.wilutions.byps.BSerializerArray(
			1374008726, // Element type: byte[]
			1
		),
		
		// java.util.Set<com.wilutions.byps.test.api.inherit.Class1>
		2114305573 : new com.wilutions.byps.BSerializerArray(
			6001, // Element type: com.wilutions.byps.test.api.inherit.Class1
			1
		),
		
		// java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
		1280571537 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			1
		),
		
		// java.util.Set<int[]>
		1406124761 : new com.wilutions.byps.BSerializerArray(
			100361105, // Element type: int[]
			1
		),
		
		// java.util.Set<Boolean>
		1365696060 : new com.wilutions.byps.BSerializerArray(
			1, // Element type: Boolean
			1
		),
		
		// java.util.Set<Double>
		1320560671 : new com.wilutions.byps.BSerializerArray(
			8, // Element type: Double
			1
		),
		
		// java.util.Set<Float>
		1898022288 : new com.wilutions.byps.BSerializerArray(
			7, // Element type: Float
			1
		),
		
		// java.util.Set<Integer>
		1493282670 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: Integer
			1
		),
		
		// java.util.Set<Long>
		1457164460 : new com.wilutions.byps.BSerializerArray(
			6, // Element type: Long
			1
		),
		
		// java.util.Set<Short>
		2028443792 : new com.wilutions.byps.BSerializerArray(
			3, // Element type: Short
			1
		),
		
		// java.util.Set<String>
		1888799711 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			1
		),
		
		// java.util.TreeMap<Float,Character>
		8789515 : new com.wilutions.byps.BSerializerMap(
			4 // Element type: Character
		),
		
		// java.util.TreeMap<Integer,java.io.InputStream>
		476459792 : new com.wilutions.byps.BSerializerMap(
			15 // Element type: java.io.InputStream
		),
		
		// java.util.TreeSet<Character>
		936607009 : new com.wilutions.byps.BSerializerArray(
			4, // Element type: Character
			1
		),
		
		// java.util.TreeSet<Integer>
		855786668 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: Integer
			1
		),
		
		// long[]
		1097129250 : new com.wilutions.byps.BSerializerArray(
			6, // Element type: long
			1
		),
		
		// long[][][][]
		846419204 : new com.wilutions.byps.BSerializerArray(
			6, // Element type: long
			4
		),
		
		// short[]
		2067161310 : new com.wilutions.byps.BSerializerArray(
			3, // Element type: short
			1
		),
		
		// short[][][][]
		1859644668 : new com.wilutions.byps.BSerializerArray(
			3, // Element type: short
			4
		),
	};
};
com.wilutions.byps.test.api.BRegistry_Testser.prototype = new com.wilutions.byps.BRegistry();
