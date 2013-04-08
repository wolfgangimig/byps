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
com.wilutions.byps.test.api.list = com.wilutions.byps.test.api.list || {};
com.wilutions.byps.test.api.enu = com.wilutions.byps.test.api.enu || {};
com.wilutions.byps.test.api.remote = com.wilutions.byps.test.api.remote || {};
com.wilutions.byps.test.api.ver = com.wilutions.byps.test.api.ver || {};
com.wilutions.byps.test.api.inherit = com.wilutions.byps.test.api.inherit || {};
com.wilutions.byps.test.api.inl = com.wilutions.byps.test.api.inl || {};
com.wilutions.byps.test.api.prim = com.wilutions.byps.test.api.prim || {};
com.wilutions.byps.test.api.refs = com.wilutions.byps.test.api.refs || {};
com.wilutions.byps.test.api.map = com.wilutions.byps.test.api.map || {};
com.wilutions.byps.test.api.strm = com.wilutions.byps.test.api.strm || {};
com.wilutions.byps.test.api.priv = com.wilutions.byps.test.api.priv || {};
com.wilutions.byps.test.api.srvr = com.wilutions.byps.test.api.srvr || {};

/**
 * ----------------------------------------------
 * API Descriptor
 * ----------------------------------------------
*/
com.wilutions.byps.test.api.BApiDescriptor_Testser = {
	/**
	 * API Version
	*/
	VERSION : 791,
	
	/**
	 * Internal used API Desciptor.
	*/
	getInternalInstance : function() {
		return new com.wilutions.byps.BApiDescriptor(
			"Testser",
			"com.wilutions.byps.test.api",
			com.wilutions.byps.BBinaryModel.MEDIUM,
			791,
			false,
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
	this.remoteArrayTypes4dim = new com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim(this.transport);
	this.remoteEnums = new com.wilutions.byps.test.api.remote.BStub_RemoteEnums(this.transport);
	this.remoteException = new com.wilutions.byps.test.api.remote.BStub_RemoteException(this.transport);
	this.remoteInlineInstance = new com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance(this.transport);
	this.remoteListTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteListTypes(this.transport);
	this.remoteMapTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes(this.transport);
	this.remotePrimitiveTypes = new com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes(this.transport);
	this.remoteReferences = new com.wilutions.byps.test.api.remote.BStub_RemoteReferences(this.transport);
	this.remoteSetTypes = new com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes(this.transport);
	this.remoteStreams = new com.wilutions.byps.test.api.remote.BStub_RemoteStreams(this.transport);
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
com.wilutions.byps.test.api.remote.FirstException = function(listOfStrings, cause) {
	this._typeId = 11000;
	this.listOfStrings = listOfStrings || null;
	this.cause = cause || null;
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
com.wilutions.byps.test.api.remote.SecondException = function(msg) {
	this._typeId = 11001;
	this.msg = msg || "";
};


/**
*/
com.wilutions.byps.test.api.inl.Actor = function(shape, position) {
	this._typeId = 171948703;
	this.shape = shape || null;
	this.position = position || null;
};


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
 * Example class with elements that belong to different versions.
*/
com.wilutions.byps.test.api.ver.Evolve = function(bool1, byte1, char1, short1, int1, long1, float1, double1, bools1, bytes1, chars1, shorts1, ints1, longs1, floats1, doubles1, str1, obj1, evo1, list1, set1, map1, bool2, byte2, char2, short2, int2, long2, float2, double2, bools2, bytes2, chars2, shorts2, ints2, longs2, floats2, doubles2, str2, obj2, evo2, list2, set2, map2, bool3, byte3, char3, short3, int3, long3, float3, double3, bools3, bytes3, chars3, shorts3, ints3, longs3, floats3, doubles3, str3, obj3, evo3, list3, set3, map3) {
	this._typeId = 1391985860;
	this.bool1 = bool1 || false;
	this.byte1 = byte1 || 0;
	this.char1 = char1 || '';
	this.short1 = short1 || 0;
	this.int1 = int1 || 0;
	this.long1 = long1 || '0';
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
	this.long2 = long2 || '0';
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
	this.long3 = long3 || '0';
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
com.wilutions.byps.test.api.srvr.ChatStructure = function(msg, sentAt, receivedAt) {
	this._typeId = 7007;
	this.msg = msg || "";
	this.sentAt = sentAt || 0;
	this.receivedAt = receivedAt || 0;
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
com.wilutions.byps.test.api.inherit.Class2 = function(int1, nextClass1, int2) {
	this._typeId = 6002;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
	this.int2 = int2 || 0;
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
 * Base class for ...
*/
com.wilutions.byps.test.api.inherit.Class1 = function(int1, nextClass1) {
	this._typeId = 6001;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
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
 * Example class with private and protected members
*/
com.wilutions.byps.test.api.priv.PrivateMembers = function(boolVal, byteVal, charVal, shortVal, intVal, longVal, floatVal, doubleVal, stringVal, primitiveTypes, arrBool, arrInt, arrString, arrPrimitiveTypes, listBool, listInt, listString, listPrimitiveTypes, mapIntListString, protInt, pprotInt) {
	this._typeId = 8001;
	this.boolVal = boolVal || false;
	this.byteVal = byteVal || 0;
	this.charVal = charVal || '';
	this.shortVal = shortVal || 0;
	this.intVal = intVal || 0;
	this.longVal = longVal || '0';
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
com.wilutions.byps.test.api.strm.Stream1 = function(is1, contentType, arrStream, listStream, mapStream) {
	this._typeId = 1541129345;
	this.is1 = is1 || null;
	this.contentType = contentType || "";
	this.arrStream = arrStream || null;
	this.listStream = listStream || null;
	this.mapStream = mapStream || null;
};


/**
*/
com.wilutions.byps.test.api.ver.Evolve2 = function(n1) {
	this._typeId = 573592593;
	this.n1 = n1 || 0;
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
com.wilutions.byps.test.api.enu.UsePlanets = function(planet, planet2, arrayOfPlanets, listOfPlanets, mapOfPlanets) {
	this._typeId = 10000;
	this.planet = planet || null;
	this.planet2 = planet2 || null;
	this.arrayOfPlanets = arrayOfPlanets || null;
	this.listOfPlanets = listOfPlanets || null;
	this.mapOfPlanets = mapOfPlanets || null;
};


/**
 * Example class with primitive types like boolean, int, String.
*/
com.wilutions.byps.test.api.prim.PrimitiveTypes = function(boolVal, byteVal, charVal, shortVal, intVal, longVal, floatVal, doubleVal, stringVal, objVal, objVal2, value, temp) {
	this._typeId = 1000;
	this.boolVal = boolVal || false;
	this.byteVal = byteVal || 0;
	this.charVal = charVal || '';
	this.shortVal = shortVal || 0;
	this.intVal = intVal || 0;
	this.longVal = longVal || '0';
	this.floatVal = floatVal || 0;
	this.doubleVal = doubleVal || 0;
	this.stringVal = stringVal || "";
	this.objVal = objVal || null;
	this.objVal2 = objVal2 || null;
	this.value = value || false;
	this.temp = temp || null;
};



/**
 * ----------------------------------------------
 * API constant types
 * ----------------------------------------------
*/

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
 * ----------------------------------------------
 * Skeleton classes
 * ----------------------------------------------
*/

/**
 * This class provides a skeleton implementation of the interface RemoteArrayTypes1dim.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes1dim = function() {
	
	this._typeId = 1557084481;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1557084481, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.setBool = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setBool = function(v, asyncResult){
		try {
			this.setBool(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte = function(v, asyncResult){
		try {
			this.setByte(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setChar = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setChar = function(v, asyncResult){
		try {
			this.setChar(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setShort = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setShort = function(v, asyncResult){
		try {
			this.setShort(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt = function(v, asyncResult){
		try {
			this.setInt(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setLong = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setLong = function(v, asyncResult){
		try {
			this.setLong(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setFloat = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setFloat = function(v, asyncResult){
		try {
			this.setFloat(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setDouble = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setDouble = function(v, asyncResult){
		try {
			this.setDouble(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setString = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setString = function(v, asyncResult){
		try {
			this.setString(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPrimitiveTypes = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPrimitiveTypes = function(v, asyncResult){
		try {
			this.setPrimitiveTypes(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setObject = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setObject = function(v, asyncResult){
		try {
			this.setObject(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getBool = function() /* returns boolean[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getBool = function(asyncResult){
		try {
			var ret = this.getBool();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte = function() /* returns byte[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte = function(asyncResult){
		try {
			var ret = this.getByte();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getChar = function() /* returns char[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getChar = function(asyncResult){
		try {
			var ret = this.getChar();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getShort = function() /* returns short[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getShort = function(asyncResult){
		try {
			var ret = this.getShort();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt = function() /* returns int[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt = function(asyncResult){
		try {
			var ret = this.getInt();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getLong = function() /* returns long[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getLong = function(asyncResult){
		try {
			var ret = this.getLong();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getFloat = function() /* returns float[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getFloat = function(asyncResult){
		try {
			var ret = this.getFloat();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getDouble = function() /* returns double[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getDouble = function(asyncResult){
		try {
			var ret = this.getDouble();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getString = function() /* returns java.lang.String[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getString = function(asyncResult){
		try {
			var ret = this.getString();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getPrimitiveTypes = function() /* returns com.wilutions.byps.test.api.prim.PrimitiveTypes[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPrimitiveTypes = function(asyncResult){
		try {
			var ret = this.getPrimitiveTypes();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getObject = function() /* returns java.lang.Object[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getObject = function(asyncResult){
		try {
			var ret = this.getObject();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteArrayTypes4dim.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteArrayTypes4dim = function() {
	
	this._typeId = 1557173854;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1557173854, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.setBool = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setBool = function(v, asyncResult){
		try {
			this.setBool(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte = function(v, asyncResult){
		try {
			this.setByte(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setChar = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setChar = function(v, asyncResult){
		try {
			this.setChar(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setShort = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setShort = function(v, asyncResult){
		try {
			this.setShort(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt = function(v, asyncResult){
		try {
			this.setInt(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setLong = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setLong = function(v, asyncResult){
		try {
			this.setLong(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setFloat = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setFloat = function(v, asyncResult){
		try {
			this.setFloat(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setDouble = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setDouble = function(v, asyncResult){
		try {
			this.setDouble(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setString = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setString = function(v, asyncResult){
		try {
			this.setString(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPrimitiveTypes = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPrimitiveTypes = function(v, asyncResult){
		try {
			this.setPrimitiveTypes(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setObject = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setObject = function(v, asyncResult){
		try {
			this.setObject(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getBool = function() /* returns boolean[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getBool = function(asyncResult){
		try {
			var ret = this.getBool();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte = function() /* returns byte[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte = function(asyncResult){
		try {
			var ret = this.getByte();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getChar = function() /* returns char[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getChar = function(asyncResult){
		try {
			var ret = this.getChar();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getShort = function() /* returns short[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getShort = function(asyncResult){
		try {
			var ret = this.getShort();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt = function() /* returns int[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt = function(asyncResult){
		try {
			var ret = this.getInt();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getLong = function() /* returns long[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getLong = function(asyncResult){
		try {
			var ret = this.getLong();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getFloat = function() /* returns float[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getFloat = function(asyncResult){
		try {
			var ret = this.getFloat();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getDouble = function() /* returns double[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getDouble = function(asyncResult){
		try {
			var ret = this.getDouble();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getString = function() /* returns java.lang.String[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getString = function(asyncResult){
		try {
			var ret = this.getString();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getPrimitiveTypes = function() /* returns com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPrimitiveTypes = function(asyncResult){
		try {
			var ret = this.getPrimitiveTypes();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getObject = function() /* returns java.lang.Object[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getObject = function(asyncResult){
		try {
			var ret = this.getObject();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteEnums.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteEnums = function() {
	
	this._typeId = 359349400;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 359349400, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.getPlanet = function() /* returns com.wilutions.byps.test.api.enu.EnumPlanets , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPlanet = function(asyncResult){
		try {
			var ret = this.getPlanet();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPlanet = function(planet) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPlanet = function(planet, asyncResult){
		try {
			this.setPlanet(planet);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteException.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteException = function() {
	
	this._typeId = 1959416539;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1959416539, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.throwBException = function(code, msg) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_throwBException = function(code, msg, asyncResult){
		try {
			this.throwBException(code, msg);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.throwFirstException = function() /* returns void , throws BException, InterruptedException, FirstException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_throwFirstException = function(asyncResult){
		try {
			this.throwFirstException();
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.throwException = function(what) /* returns void , throws BException, InterruptedException, FirstException, SecondException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_throwException = function(what, asyncResult){
		try {
			this.throwException(what);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	 * Throw an exception that cannot be serialized.
	 * The exception message is wrapped into a BException.
	*/
	this.throwNullPointerException = function() /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	 * Throw an exception that cannot be serialized.
	 * The exception message is wrapped into a BException.
	*/
	this.async_throwNullPointerException = function(asyncResult){
		try {
			this.throwNullPointerException();
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteInlineInstance.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteInlineInstance = function() {
	
	this._typeId = 1206670536;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1206670536, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.setActor = function(act) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setActor = function(act, asyncResult){
		try {
			this.setActor(act);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getActor = function() /* returns com.wilutions.byps.test.api.inl.Actor , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getActor = function(asyncResult){
		try {
			var ret = this.getActor();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setActorArray1dim = function(actorArray) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setActorArray1dim = function(actorArray, asyncResult){
		try {
			this.setActorArray1dim(actorArray);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getActorArray1dim = function() /* returns com.wilutions.byps.test.api.inl.Actor[] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getActorArray1dim = function(asyncResult){
		try {
			var ret = this.getActorArray1dim();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setActorArray4dim = function(actorArray) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setActorArray4dim = function(actorArray, asyncResult){
		try {
			this.setActorArray4dim(actorArray);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getActorArray4dim = function() /* returns com.wilutions.byps.test.api.inl.Actor[][][][] , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getActorArray4dim = function(asyncResult){
		try {
			var ret = this.getActorArray4dim();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setActorList = function(actorList) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setActorList = function(actorList, asyncResult){
		try {
			this.setActorList(actorList);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getActorList = function() /* returns java.util.List<com.wilutions.byps.test.api.inl.Actor> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getActorList = function(asyncResult){
		try {
			var ret = this.getActorList();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setActorListList = function(actorListList) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setActorListList = function(actorListList, asyncResult){
		try {
			this.setActorListList(actorListList);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getActorListList = function() /* returns java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getActorListList = function(asyncResult){
		try {
			var ret = this.getActorListList();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setActorSet = function(actorSet) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setActorSet = function(actorSet, asyncResult){
		try {
			this.setActorSet(actorSet);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getActorSet = function() /* returns java.util.Set<com.wilutions.byps.test.api.inl.Actor> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getActorSet = function(asyncResult){
		try {
			var ret = this.getActorSet();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setActorMap = function(actorMap) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setActorMap = function(actorMap, asyncResult){
		try {
			this.setActorMap(actorMap);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getActorMap = function() /* returns java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getActorMap = function(asyncResult){
		try {
			var ret = this.getActorMap();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteListTypes.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteListTypes = function() {
	
	this._typeId = 380156079;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 380156079, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.getBoolean1 = function() /* returns java.util.List<java.lang.Boolean> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getBoolean1 = function(asyncResult){
		try {
			var ret = this.getBoolean1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setBoolean1 = function(boolean1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setBoolean1 = function(boolean1, asyncResult){
		try {
			this.setBoolean1(boolean1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte1 = function() /* returns java.util.List<java.lang.Byte> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte1 = function(asyncResult){
		try {
			var ret = this.getByte1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte1 = function(byte1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte1 = function(byte1, asyncResult){
		try {
			this.setByte1(byte1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getChar1 = function() /* returns java.util.List<java.lang.Character> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getChar1 = function(asyncResult){
		try {
			var ret = this.getChar1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setChar1 = function(char1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setChar1 = function(char1, asyncResult){
		try {
			this.setChar1(char1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getShort1 = function() /* returns java.util.List<java.lang.Short> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getShort1 = function(asyncResult){
		try {
			var ret = this.getShort1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setShort1 = function(short1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setShort1 = function(short1, asyncResult){
		try {
			this.setShort1(short1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt1 = function() /* returns java.util.List<java.lang.Integer> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt1 = function(asyncResult){
		try {
			var ret = this.getInt1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt1 = function(int1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt1 = function(int1, asyncResult){
		try {
			this.setInt1(int1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getLong1 = function() /* returns java.util.List<java.lang.Long> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getLong1 = function(asyncResult){
		try {
			var ret = this.getLong1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setLong1 = function(long1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setLong1 = function(long1, asyncResult){
		try {
			this.setLong1(long1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getFloat1 = function() /* returns java.util.List<java.lang.Float> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getFloat1 = function(asyncResult){
		try {
			var ret = this.getFloat1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setFloat1 = function(float1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setFloat1 = function(float1, asyncResult){
		try {
			this.setFloat1(float1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getDouble1 = function() /* returns java.util.List<java.lang.Double> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getDouble1 = function(asyncResult){
		try {
			var ret = this.getDouble1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setDouble1 = function(double1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setDouble1 = function(double1, asyncResult){
		try {
			this.setDouble1(double1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getString1 = function() /* returns java.util.List<java.lang.String> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getString1 = function(asyncResult){
		try {
			var ret = this.getString1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setString1 = function(string1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setString1 = function(string1, asyncResult){
		try {
			this.setString1(string1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getPrimitiveTypes1 = function() /* returns java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPrimitiveTypes1 = function(asyncResult){
		try {
			var ret = this.getPrimitiveTypes1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPrimitiveTypes1 = function(primitiveTypes1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPrimitiveTypes1 = function(primitiveTypes1, asyncResult){
		try {
			this.setPrimitiveTypes1(primitiveTypes1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte2 = function() /* returns java.util.List<byte[]> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte2 = function(asyncResult){
		try {
			var ret = this.getByte2();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte2 = function(byte2) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte2 = function(byte2, asyncResult){
		try {
			this.setByte2(byte2);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt2 = function() /* returns java.util.List<int[]> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt2 = function(asyncResult){
		try {
			var ret = this.getInt2();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt2 = function(int2) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt2 = function(int2, asyncResult){
		try {
			this.setInt2(int2);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getObj1 = function() /* returns java.util.List<java.lang.Object> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getObj1 = function(asyncResult){
		try {
			var ret = this.getObj1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setObj1 = function(obj1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setObj1 = function(obj1, asyncResult){
		try {
			this.setObj1(obj1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt3 = function() /* returns java.util.List<java.util.List<java.lang.Integer>> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt3 = function(asyncResult){
		try {
			var ret = this.getInt3();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt3 = function(int3) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt3 = function(int3, asyncResult){
		try {
			this.setInt3(int3);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt4 = function() /* returns java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt4 = function(asyncResult){
		try {
			var ret = this.getInt4();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt4 = function(int4) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt4 = function(int4, asyncResult){
		try {
			this.setInt4(int4);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteMapTypes.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteMapTypes = function() {
	
	this._typeId = 80483097;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 80483097, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.getBoolean1 = function() /* returns java.util.Map<java.lang.String,java.lang.Boolean> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getBoolean1 = function(asyncResult){
		try {
			var ret = this.getBoolean1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setBoolean1 = function(boolean1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setBoolean1 = function(boolean1, asyncResult){
		try {
			this.setBoolean1(boolean1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte1 = function() /* returns java.util.HashMap<java.lang.Double,java.lang.Byte> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte1 = function(asyncResult){
		try {
			var ret = this.getByte1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte1 = function(byte1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte1 = function(byte1, asyncResult){
		try {
			this.setByte1(byte1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getChar1 = function() /* returns java.util.TreeMap<java.lang.Float,java.lang.Character> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getChar1 = function(asyncResult){
		try {
			var ret = this.getChar1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setChar1 = function(char1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setChar1 = function(char1, asyncResult){
		try {
			this.setChar1(char1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getShort1 = function() /* returns java.util.Map<java.lang.Long,java.lang.Short> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getShort1 = function(asyncResult){
		try {
			var ret = this.getShort1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setShort1 = function(short1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setShort1 = function(short1, asyncResult){
		try {
			this.setShort1(short1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt1 = function() /* returns java.util.Map<java.lang.Integer,java.lang.Integer> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt1 = function(asyncResult){
		try {
			var ret = this.getInt1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt1 = function(int1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt1 = function(int1, asyncResult){
		try {
			this.setInt1(int1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getLong1 = function() /* returns java.util.Map<java.lang.Short,java.lang.Long> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getLong1 = function(asyncResult){
		try {
			var ret = this.getLong1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setLong1 = function(long1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setLong1 = function(long1, asyncResult){
		try {
			this.setLong1(long1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getFloat1 = function() /* returns java.util.Map<java.lang.Character,java.lang.Float> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getFloat1 = function(asyncResult){
		try {
			var ret = this.getFloat1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setFloat1 = function(float1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setFloat1 = function(float1, asyncResult){
		try {
			this.setFloat1(float1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getDouble1 = function() /* returns java.util.Map<java.lang.Byte,java.lang.Double> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getDouble1 = function(asyncResult){
		try {
			var ret = this.getDouble1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setDouble1 = function(double1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setDouble1 = function(double1, asyncResult){
		try {
			this.setDouble1(double1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getString1 = function() /* returns java.util.Map<java.lang.String,java.lang.String> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getString1 = function(asyncResult){
		try {
			var ret = this.getString1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setString1 = function(string1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setString1 = function(string1, asyncResult){
		try {
			this.setString1(string1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getPrimitiveTypes1 = function() /* returns java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPrimitiveTypes1 = function(asyncResult){
		try {
			var ret = this.getPrimitiveTypes1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPrimitiveTypes1 = function(primitiveTypes1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPrimitiveTypes1 = function(primitiveTypes1, asyncResult){
		try {
			this.setPrimitiveTypes1(primitiveTypes1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte2 = function() /* returns java.util.Map<java.lang.Integer,byte[]> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte2 = function(asyncResult){
		try {
			var ret = this.getByte2();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte2 = function(byte2) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte2 = function(byte2, asyncResult){
		try {
			this.setByte2(byte2);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt2 = function() /* returns java.util.Map<java.lang.Integer,int[]> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt2 = function(asyncResult){
		try {
			var ret = this.getInt2();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt2 = function(int2) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt2 = function(int2, asyncResult){
		try {
			this.setInt2(int2);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getObj1 = function() /* returns java.util.Map<java.lang.String,java.lang.Object> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getObj1 = function(asyncResult){
		try {
			var ret = this.getObj1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setObj1 = function(obj1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setObj1 = function(obj1, asyncResult){
		try {
			this.setObj1(obj1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemotePrimitiveTypes.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemotePrimitiveTypes = function() {
	
	this._typeId = 1341983932;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1341983932, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.voidFunctionVoid = function() /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_voidFunctionVoid = function(asyncResult){
		try {
			this.voidFunctionVoid();
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setBool = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setBool = function(v, asyncResult){
		try {
			this.setBool(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte = function(v, asyncResult){
		try {
			this.setByte(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setChar = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setChar = function(v, asyncResult){
		try {
			this.setChar(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setShort = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setShort = function(v, asyncResult){
		try {
			this.setShort(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt = function(v, asyncResult){
		try {
			this.setInt(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setLong = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setLong = function(v, asyncResult){
		try {
			this.setLong(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setFloat = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setFloat = function(v, asyncResult){
		try {
			this.setFloat(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setDouble = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setDouble = function(v, asyncResult){
		try {
			this.setDouble(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setString = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setString = function(v, asyncResult){
		try {
			this.setString(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPrimitiveTypes = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPrimitiveTypes = function(v, asyncResult){
		try {
			this.setPrimitiveTypes(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setObject = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setObject = function(v, asyncResult){
		try {
			this.setObject(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getBool = function() /* returns boolean , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getBool = function(asyncResult){
		try {
			var ret = this.getBool();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte = function() /* returns byte , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte = function(asyncResult){
		try {
			var ret = this.getByte();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getChar = function() /* returns char , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getChar = function(asyncResult){
		try {
			var ret = this.getChar();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getShort = function() /* returns short , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getShort = function(asyncResult){
		try {
			var ret = this.getShort();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt = function() /* returns int , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt = function(asyncResult){
		try {
			var ret = this.getInt();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getLong = function() /* returns long , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getLong = function(asyncResult){
		try {
			var ret = this.getLong();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getFloat = function() /* returns float , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getFloat = function(asyncResult){
		try {
			var ret = this.getFloat();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getDouble = function() /* returns double , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getDouble = function(asyncResult){
		try {
			var ret = this.getDouble();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getString = function() /* returns java.lang.String , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getString = function(asyncResult){
		try {
			var ret = this.getString();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getPrimitiveTypes = function() /* returns com.wilutions.byps.test.api.prim.PrimitiveTypes , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPrimitiveTypes = function(asyncResult){
		try {
			var ret = this.getPrimitiveTypes();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getObject = function() /* returns java.lang.Object , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getObject = function(asyncResult){
		try {
			var ret = this.getObject();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.sendAllTypes = function(b, c, s, i, l, f, d, str, pt, o) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_sendAllTypes = function(b, c, s, i, l, f, d, str, pt, o, asyncResult){
		try {
			this.sendAllTypes(b, c, s, i, l, f, d, str, pt, o);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.add = function(a, b) /* returns int , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_add = function(a, b, asyncResult){
		try {
			var ret = this.add(a, b);
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteReferences.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteReferences = function() {
	
	this._typeId = 2086824050;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 2086824050, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.getNode = function() /* returns com.wilutions.byps.test.api.refs.Node , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getNode = function(asyncResult){
		try {
			var ret = this.getNode();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setNode = function(v) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setNode = function(v, asyncResult){
		try {
			this.setNode(v);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteSetTypes.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteSetTypes = function() {
	
	this._typeId = 1156008353;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1156008353, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.getBoolean1 = function() /* returns java.util.Set<java.lang.Boolean> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getBoolean1 = function(asyncResult){
		try {
			var ret = this.getBoolean1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setBoolean1 = function(boolean1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setBoolean1 = function(boolean1, asyncResult){
		try {
			this.setBoolean1(boolean1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte1 = function() /* returns java.util.HashSet<java.lang.Byte> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte1 = function(asyncResult){
		try {
			var ret = this.getByte1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte1 = function(byte1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte1 = function(byte1, asyncResult){
		try {
			this.setByte1(byte1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getChar1 = function() /* returns java.util.TreeSet<java.lang.Character> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getChar1 = function(asyncResult){
		try {
			var ret = this.getChar1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setChar1 = function(char1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setChar1 = function(char1, asyncResult){
		try {
			this.setChar1(char1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getShort1 = function() /* returns java.util.Set<java.lang.Short> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getShort1 = function(asyncResult){
		try {
			var ret = this.getShort1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setShort1 = function(short1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setShort1 = function(short1, asyncResult){
		try {
			this.setShort1(short1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt1 = function() /* returns java.util.Set<java.lang.Integer> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt1 = function(asyncResult){
		try {
			var ret = this.getInt1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt1 = function(int1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt1 = function(int1, asyncResult){
		try {
			this.setInt1(int1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getLong1 = function() /* returns java.util.Set<java.lang.Long> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getLong1 = function(asyncResult){
		try {
			var ret = this.getLong1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setLong1 = function(long1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setLong1 = function(long1, asyncResult){
		try {
			this.setLong1(long1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getFloat1 = function() /* returns java.util.Set<java.lang.Float> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getFloat1 = function(asyncResult){
		try {
			var ret = this.getFloat1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setFloat1 = function(float1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setFloat1 = function(float1, asyncResult){
		try {
			this.setFloat1(float1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getDouble1 = function() /* returns java.util.Set<java.lang.Double> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getDouble1 = function(asyncResult){
		try {
			var ret = this.getDouble1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setDouble1 = function(double1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setDouble1 = function(double1, asyncResult){
		try {
			this.setDouble1(double1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getString1 = function() /* returns java.util.Set<java.lang.String> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getString1 = function(asyncResult){
		try {
			var ret = this.getString1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setString1 = function(string1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setString1 = function(string1, asyncResult){
		try {
			this.setString1(string1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getPrimitiveTypes1 = function() /* returns java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPrimitiveTypes1 = function(asyncResult){
		try {
			var ret = this.getPrimitiveTypes1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPrimitiveTypes1 = function(primitiveTypes1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPrimitiveTypes1 = function(primitiveTypes1, asyncResult){
		try {
			this.setPrimitiveTypes1(primitiveTypes1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getByte2 = function() /* returns java.util.Set<byte[]> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getByte2 = function(asyncResult){
		try {
			var ret = this.getByte2();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setByte2 = function(byte2) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setByte2 = function(byte2, asyncResult){
		try {
			this.setByte2(byte2);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getInt2 = function() /* returns java.util.Set<int[]> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getInt2 = function(asyncResult){
		try {
			var ret = this.getInt2();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setInt2 = function(int2) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setInt2 = function(int2, asyncResult){
		try {
			this.setInt2(int2);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getObj1 = function() /* returns java.util.Set<java.lang.Object> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getObj1 = function(asyncResult){
		try {
			var ret = this.getObj1();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setObj1 = function(obj1) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setObj1 = function(obj1, asyncResult){
		try {
			this.setObj1(obj1);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface RemoteStreams.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.remote.BSkeleton_RemoteStreams = function() {
	
	this._typeId = 2028487863;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 2028487863, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.getImage = function() /* returns java.io.InputStream , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getImage = function(asyncResult){
		try {
			var ret = this.getImage();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setImage = function(istrm) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setImage = function(istrm, asyncResult){
		try {
			this.setImage(istrm);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getImages = function() /* returns java.util.TreeMap<java.lang.Integer,java.io.InputStream> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getImages = function(asyncResult){
		try {
			var ret = this.getImages();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setImages = function(istrms, doNotReadStreamAtKey) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setImages = function(istrms, doNotReadStreamAtKey, asyncResult){
		try {
			this.setImages(istrms, doNotReadStreamAtKey);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.throwLastException = function() /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_throwLastException = function(asyncResult){
		try {
			this.throwLastException();
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getTextStream = function() /* returns java.io.InputStream , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getTextStream = function(asyncResult){
		try {
			var ret = this.getTextStream();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
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
	
	/**
	*/
	this.incrementInt = function(a) /* returns int , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_incrementInt = function(a, asyncResult){
		try {
			var ret = this.incrementInt(a);
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getStreams = function(ctrl) /* returns java.util.List<java.io.InputStream> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getStreams = function(ctrl, asyncResult){
		try {
			var ret = this.getStreams(ctrl);
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.putStreams = function(strm, ctrl) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_putStreams = function(strm, ctrl, asyncResult){
		try {
			this.putStreams(strm, ctrl);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.sendChat = function(cs) /* returns com.wilutions.byps.test.api.srvr.ChatStructure , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_sendChat = function(cs, asyncResult){
		try {
			var ret = this.sendChat(cs);
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface ServerIF.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.srvr.BSkeleton_ServerIF = function() {
	
	this._typeId = 1313562065;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 1313562065, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.callClientIncrementInt = function(v) /* returns int , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_callClientIncrementInt = function(v, asyncResult){
		try {
			var ret = this.callClientIncrementInt(v);
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setPartner = function(client) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setPartner = function(client, asyncResult){
		try {
			this.setPartner(client);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getPartner = function() /* returns com.wilutions.byps.test.api.srvr.ClientIF , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getPartner = function(asyncResult){
		try {
			var ret = this.getPartner();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getStreamsFromClient = function() /* returns java.util.List<java.io.InputStream> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getStreamsFromClient = function(asyncResult){
		try {
			var ret = this.getStreamsFromClient();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.putStreamsOnClient = function(streams) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_putStreamsOnClient = function(streams, asyncResult){
		try {
			this.putStreamsOnClient(streams);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.registerWithClientMap = function(id) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_registerWithClientMap = function(id, asyncResult){
		try {
			this.registerWithClientMap(id);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getClient = function(id) /* returns com.wilutions.byps.test.api.srvr.ClientIF , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getClient = function(id, asyncResult){
		try {
			var ret = this.getClient(id);
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getClientIds = function() /* returns java.util.Set<java.lang.Integer> , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getClientIds = function(asyncResult){
		try {
			var ret = this.getClientIds();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	
};

/**
 * This class provides a skeleton implementation of the interface EvolveIF.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
com.wilutions.byps.test.api.ver.BSkeleton_EvolveIF = function() {
	
	this._typeId = 2078696281;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 2078696281, targetId : this.transport.targetId };
	};
	
	/**
	*/
	this.setEvolve = function(obj) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setEvolve = function(obj, asyncResult){
		try {
			this.setEvolve(obj);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getEvolve = function() /* returns com.wilutions.byps.test.api.ver.Evolve , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getEvolve = function(asyncResult){
		try {
			var ret = this.getEvolve();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.setClient = function(partner) /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_setClient = function(partner, asyncResult){
		try {
			this.setClient(partner);
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.getClient = function() /* returns com.wilutions.byps.test.api.ver.EvolveIF , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_getClient = function(asyncResult){
		try {
			var ret = this.getClient();
			asyncResult(ret, null);
		} catch (e) {
			asyncResult(null, e);
		};
	};
	
	/**
	*/
	this.sendEvolveToClient = function() /* returns void , throws BException, InterruptedException*/  {
		com.wilutions.byps.throwUNSUPPORTED("");
	};
	/**
	*/
	this.async_sendEvolveToClient = function(asyncResult){
		try {
			this.sendEvolveToClient();
			asyncResult(null, null);
		} catch (e) {
			asyncResult(null, e);
		};
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
	
	/**
	*/
	this.setBool = function(v, asyncResult) {
		var req =  { _typeId : 589253529, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte = function(v, asyncResult) {
		var req =  { _typeId : 589243771, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setChar = function(v, asyncResult) {
		var req =  { _typeId : 589230893, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setShort = function(v, asyncResult) {
		var req =  { _typeId : 1071498593, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt = function(v, asyncResult) {
		var req =  { _typeId : 1265927470, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setLong = function(v, asyncResult) {
		var req =  { _typeId : 588955655, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setFloat = function(v, asyncResult) {
		var req =  { _typeId : 1083385729, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setDouble = function(v, asyncResult) {
		var req =  { _typeId : 720472590, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setString = function(v, asyncResult) {
		var req =  { _typeId : 1154444878, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPrimitiveTypes = function(v, asyncResult) {
		var req =  { _typeId : 1765354225, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setObject = function(v, asyncResult) {
		var req =  { _typeId : 1023062396, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getBool = function(asyncResult) {
		var req =  { _typeId : 1645604187 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte = function(asyncResult) {
		var req =  { _typeId : 1645613945 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getChar = function(asyncResult) {
		var req =  { _typeId : 1645626823 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getShort = function(asyncResult) {
		var req =  { _typeId : 510386133 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt = function(asyncResult) {
		var req =  { _typeId : 1609477282 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getLong = function(asyncResult) {
		var req =  { _typeId : 1645902061 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getFloat = function(asyncResult) {
		var req =  { _typeId : 522273269 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getDouble = function(asyncResult) {
		var req =  { _typeId : 935089666 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getString = function(asyncResult) {
		var req =  { _typeId : 1369061954 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getPrimitiveTypes = function(asyncResult) {
		var req =  { _typeId : 825201405 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getObject = function(asyncResult) {
		var req =  { _typeId : 1237679472 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
 * Interface with functions using 4-dimensional arrays.
*/
com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim = function(transport) {
	
	this._typeId = 1557173854;
	
	this.transport = transport;
	
	/**
	*/
	this.setBool = function(v, asyncResult) {
		var req =  { _typeId : 202005372, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte = function(v, asyncResult) {
		var req =  { _typeId : 201995614, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setChar = function(v, asyncResult) {
		var req =  { _typeId : 201982736, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setShort = function(v, asyncResult) {
		var req =  { _typeId : 1951707614, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt = function(v, asyncResult) {
		var req =  { _typeId : 1933153045, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setLong = function(v, asyncResult) {
		var req =  { _typeId : 201707498, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setFloat = function(v, asyncResult) {
		var req =  { _typeId : 1963594750, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setDouble = function(v, asyncResult) {
		var req =  { _typeId : 796203285, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setString = function(v, asyncResult) {
		var req =  { _typeId : 362230997, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPrimitiveTypes = function(v, asyncResult) {
		var req =  { _typeId : 710411500, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setObject = function(v, asyncResult) {
		var req =  { _typeId : 493613479, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getBool = function(asyncResult) {
		var req =  { _typeId : 2032852344 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte = function(asyncResult) {
		var req =  { _typeId : 2032862102 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getChar = function(asyncResult) {
		var req =  { _typeId : 2032874980 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getShort = function(asyncResult) {
		var req =  { _typeId : 1390595154 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt = function(asyncResult) {
		var req =  { _typeId : 1589603233 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getLong = function(asyncResult) {
		var req =  { _typeId : 2033150218 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getFloat = function(asyncResult) {
		var req =  { _typeId : 1402482290 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getDouble = function(asyncResult) {
		var req =  { _typeId : 581586209 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getString = function(asyncResult) {
		var req =  { _typeId : 147613921 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getPrimitiveTypes = function(asyncResult) {
		var req =  { _typeId : 1650564320 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getObject = function(asyncResult) {
		var req =  { _typeId : 278996403 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteEnums = function(transport) {
	
	this._typeId = 359349400;
	
	this.transport = transport;
	
	/**
	*/
	this.getPlanet = function(asyncResult) {
		var req =  { _typeId : 627010462 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPlanet = function(planet, asyncResult) {
		var req =  { _typeId : 412393386, planet : planet };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteException = function(transport) {
	
	this._typeId = 1959416539;
	
	this.transport = transport;
	
	/**
	*/
	this.throwBException = function(code, msg, asyncResult) {
		var req =  { _typeId : 641509600, code : code, msg : msg };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.throwFirstException = function(asyncResult) {
		var req =  { _typeId : 533533486 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.throwException = function(what, asyncResult) {
		var req =  { _typeId : 67092708, what : what };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	 * Throw an exception that cannot be serialized.
	 * The exception message is wrapped into a BException.
	*/
	this.throwNullPointerException = function(asyncResult) {
		var req =  { _typeId : 1888829108 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance = function(transport) {
	
	this._typeId = 1206670536;
	
	this.transport = transport;
	
	/**
	*/
	this.setActor = function(act, asyncResult) {
		var req =  { _typeId : 299289599, act : act };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getActor = function(asyncResult) {
		var req =  { _typeId : 261822861 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setActorArray1dim = function(actorArray, asyncResult) {
		var req =  { _typeId : 240237169, actorArray : actorArray };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getActorArray1dim = function(asyncResult) {
		var req =  { _typeId : 699915651 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setActorArray4dim = function(actorArray, asyncResult) {
		var req =  { _typeId : 240147796, actorArray : actorArray };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getActorArray4dim = function(asyncResult) {
		var req =  { _typeId : 700005024 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setActorList = function(actorList, asyncResult) {
		var req =  { _typeId : 1902022593, actorList : actorList };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getActorList = function(asyncResult) {
		var req =  { _typeId : 843952075 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setActorListList = function(actorListList, asyncResult) {
		var req =  { _typeId : 2080023171, actorListList : actorListList };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getActorListList = function(asyncResult) {
		var req =  { _typeId : 248580343 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setActorSet = function(actorSet, asyncResult) {
		var req =  { _typeId : 215745697, actorSet : actorSet };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getActorSet = function(asyncResult) {
		var req =  { _typeId : 304325525 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setActorMap = function(actorMap, asyncResult) {
		var req =  { _typeId : 215739803, actorMap : actorMap };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getActorMap = function(asyncResult) {
		var req =  { _typeId : 304319631 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteListTypes = function(transport) {
	
	this._typeId = 380156079;
	
	this.transport = transport;
	
	/**
	*/
	this.getBoolean1 = function(asyncResult) {
		var req =  { _typeId : 1794077576 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setBoolean1 = function(boolean1, asyncResult) {
		var req =  { _typeId : 1882657404, boolean1 : boolean1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte1 = function(asyncResult) {
		var req =  { _typeId : 1319541530 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte1 = function(byte1, asyncResult) {
		var req =  { _typeId : 758429070, byte1 : byte1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getChar1 = function(asyncResult) {
		var req =  { _typeId : 1319940748 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setChar1 = function(char1, asyncResult) {
		var req =  { _typeId : 758828288, char1 : char1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getShort1 = function(asyncResult) {
		var req =  { _typeId : 1573024156 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setShort1 = function(short1, asyncResult) {
		var req =  { _typeId : 1787641232, short1 : short1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt1 = function(asyncResult) {
		var req =  { _typeId : 874047761 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt1 = function(int1, asyncResult) {
		var req =  { _typeId : 1360809955, int1 : int1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getLong1 = function(asyncResult) {
		var req =  { _typeId : 1328473126 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setLong1 = function(long1, asyncResult) {
		var req =  { _typeId : 767360666, long1 : long1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getFloat1 = function(asyncResult) {
		var req =  { _typeId : 1941525372 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setFloat1 = function(float1, asyncResult) {
		var req =  { _typeId : 2138824848, float1 : float1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getDouble1 = function(asyncResult) {
		var req =  { _typeId : 1741299407 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setDouble1 = function(double1, asyncResult) {
		var req =  { _typeId : 195505829, double1 : double1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getString1 = function(asyncResult) {
		var req =  { _typeId : 1173060367 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setString1 = function(string1, asyncResult) {
		var req =  { _typeId : 763744869, string1 : string1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getPrimitiveTypes1 = function(asyncResult) {
		var req =  { _typeId : 1940572240 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPrimitiveTypes1 = function(primitiveTypes1, asyncResult) {
		var req =  { _typeId : 1434361404, primitiveTypes1 : primitiveTypes1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte2 = function(asyncResult) {
		var req =  { _typeId : 1319541531 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte2 = function(byte2, asyncResult) {
		var req =  { _typeId : 758429071, byte2 : byte2 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt2 = function(asyncResult) {
		var req =  { _typeId : 874047762 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt2 = function(int2, asyncResult) {
		var req =  { _typeId : 1360809954, int2 : int2 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getObj1 = function(asyncResult) {
		var req =  { _typeId : 874214665 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setObj1 = function(obj1, asyncResult) {
		var req =  { _typeId : 1360643051, obj1 : obj1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt3 = function(asyncResult) {
		var req =  { _typeId : 874047763 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt3 = function(int3, asyncResult) {
		var req =  { _typeId : 1360809953, int3 : int3 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt4 = function(asyncResult) {
		var req =  { _typeId : 874047764 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt4 = function(int4, asyncResult) {
		var req =  { _typeId : 1360809952, int4 : int4 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes = function(transport) {
	
	this._typeId = 80483097;
	
	this.transport = transport;
	
	/**
	*/
	this.getBoolean1 = function(asyncResult) {
		var req =  { _typeId : 461626272 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setBoolean1 = function(boolean1, asyncResult) {
		var req =  { _typeId : 550206100, boolean1 : boolean1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte1 = function(asyncResult) {
		var req =  { _typeId : 1348711374 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte1 = function(byte1, asyncResult) {
		var req =  { _typeId : 1909823834, byte1 : byte1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getChar1 = function(asyncResult) {
		var req =  { _typeId : 1348312156 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setChar1 = function(char1, asyncResult) {
		var req =  { _typeId : 1909424616, char1 : char1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getShort1 = function(asyncResult) {
		var req =  { _typeId : 1610481740 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setShort1 = function(short1, asyncResult) {
		var req =  { _typeId : 1395864664, short1 : short1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt1 = function(asyncResult) {
		var req =  { _typeId : 1013140231 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt1 = function(int1, asyncResult) {
		var req =  { _typeId : 1046969349, int1 : int1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getLong1 = function(asyncResult) {
		var req =  { _typeId : 1339779778 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setLong1 = function(long1, asyncResult) {
		var req =  { _typeId : 1900892238, long1 : long1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getFloat1 = function(asyncResult) {
		var req =  { _typeId : 1241980524 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setFloat1 = function(float1, asyncResult) {
		var req =  { _typeId : 1027363448, float1 : float1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getDouble1 = function(asyncResult) {
		var req =  { _typeId : 1836864439 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setDouble1 = function(double1, asyncResult) {
		var req =  { _typeId : 99940797, double1 : double1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getString1 = function(asyncResult) {
		var req =  { _typeId : 1268625399 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setString1 = function(string1, asyncResult) {
		var req =  { _typeId : 668179837, string1 : string1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getPrimitiveTypes1 = function(asyncResult) {
		var req =  { _typeId : 77071512 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPrimitiveTypes1 = function(primitiveTypes1, asyncResult) {
		var req =  { _typeId : 842962140, primitiveTypes1 : primitiveTypes1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte2 = function(asyncResult) {
		var req =  { _typeId : 1348711373 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte2 = function(byte2, asyncResult) {
		var req =  { _typeId : 1909823833, byte2 : byte2 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt2 = function(asyncResult) {
		var req =  { _typeId : 1013140230 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt2 = function(int2, asyncResult) {
		var req =  { _typeId : 1046969350, int2 : int2 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getObj1 = function(asyncResult) {
		var req =  { _typeId : 1012973327 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setObj1 = function(obj1, asyncResult) {
		var req =  { _typeId : 1047136253, obj1 : obj1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes = function(transport) {
	
	this._typeId = 1341983932;
	
	this.transport = transport;
	
	/**
	*/
	this.voidFunctionVoid = function(asyncResult) {
		var req =  { _typeId : 1856936054 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setBool = function(v, asyncResult) {
		var req =  { _typeId : 143860510, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte = function(v, asyncResult) {
		var req =  { _typeId : 143850752, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setChar = function(v, asyncResult) {
		var req =  { _typeId : 143837874, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setShort = function(v, asyncResult) {
		var req =  { _typeId : 149216892, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt = function(v, asyncResult) {
		var req =  { _typeId : 974465289, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setLong = function(v, asyncResult) {
		var req =  { _typeId : 143562636, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setFloat = function(v, asyncResult) {
		var req =  { _typeId : 161104028, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setDouble = function(v, asyncResult) {
		var req =  { _typeId : 753565751, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setString = function(v, asyncResult) {
		var req =  { _typeId : 319593463, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPrimitiveTypes = function(v, asyncResult) {
		var req =  { _typeId : 941809610, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setObject = function(v, asyncResult) {
		var req =  { _typeId : 450975945, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getBool = function(asyncResult) {
		var req =  { _typeId : 2090997206 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte = function(asyncResult) {
		var req =  { _typeId : 2091006964 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getChar = function(asyncResult) {
		var req =  { _typeId : 2091019842 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getShort = function(asyncResult) {
		var req =  { _typeId : 411895568 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt = function(asyncResult) {
		var req =  { _typeId : 1318015101 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getLong = function(asyncResult) {
		var req =  { _typeId : 2091295080 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getFloat = function(asyncResult) {
		var req =  { _typeId : 400008432 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getDouble = function(asyncResult) {
		var req =  { _typeId : 538948675 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getString = function(asyncResult) {
		var req =  { _typeId : 104976387 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getPrimitiveTypes = function(asyncResult) {
		var req =  { _typeId : 1881962430 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getObject = function(asyncResult) {
		var req =  { _typeId : 236358869 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.sendAllTypes = function(b, c, s, i, l, f, d, str, pt, o, asyncResult) {
		var req =  { _typeId : 1794219594, b : b, c : c, s : s, i : i, l : l, f : f, d : d, str : str, pt : pt, o : o };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.add = function(a, b, asyncResult) {
		var req =  { _typeId : 1073583639, a : a, b : b };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteReferences = function(transport) {
	
	this._typeId = 2086824050;
	
	this.transport = transport;
	
	/**
	*/
	this.getNode = function(asyncResult) {
		var req =  { _typeId : 655936732 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setNode = function(v, asyncResult) {
		var req =  { _typeId : 1404172848, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes = function(transport) {
	
	this._typeId = 1156008353;
	
	this.transport = transport;
	
	/**
	*/
	this.getBoolean1 = function(asyncResult) {
		var req =  { _typeId : 1690813926 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setBoolean1 = function(boolean1, asyncResult) {
		var req =  { _typeId : 1779393754, boolean1 : boolean1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte1 = function(asyncResult) {
		var req =  { _typeId : 2125684552 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte1 = function(byte1, asyncResult) {
		var req =  { _typeId : 1608170284, byte1 : byte1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getChar1 = function(asyncResult) {
		var req =  { _typeId : 2125285334 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setChar1 = function(char1, asyncResult) {
		var req =  { _typeId : 1608569502, char1 : char1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getShort1 = function(asyncResult) {
		var req =  { _typeId : 1000850298 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setShort1 = function(short1, asyncResult) {
		var req =  { _typeId : 1215467374, short1 : short1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt1 = function(asyncResult) {
		var req =  { _typeId : 68372557 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt1 = function(int1, asyncResult) {
		var req =  { _typeId : 1991737023, int1 : int1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getLong1 = function(asyncResult) {
		var req =  { _typeId : 2116752956 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setLong1 = function(long1, asyncResult) {
		var req =  { _typeId : 1617101880, long1 : long1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getFloat1 = function(asyncResult) {
		var req =  { _typeId : 1369351514 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setFloat1 = function(float1, asyncResult) {
		var req =  { _typeId : 1583968590, float1 : float1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getDouble1 = function(asyncResult) {
		var req =  { _typeId : 1183778993 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setDouble1 = function(double1, asyncResult) {
		var req =  { _typeId : 753026243, double1 : double1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getString1 = function(asyncResult) {
		var req =  { _typeId : 615539953 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setString1 = function(string1, asyncResult) {
		var req =  { _typeId : 1321265283, string1 : string1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getPrimitiveTypes1 = function(asyncResult) {
		var req =  { _typeId : 1802821742 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPrimitiveTypes1 = function(primitiveTypes1, asyncResult) {
		var req =  { _typeId : 1572111902, primitiveTypes1 : primitiveTypes1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getByte2 = function(asyncResult) {
		var req =  { _typeId : 2125684551 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setByte2 = function(byte2, asyncResult) {
		var req =  { _typeId : 1608170285, byte2 : byte2 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getInt2 = function(asyncResult) {
		var req =  { _typeId : 68372556 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setInt2 = function(int2, asyncResult) {
		var req =  { _typeId : 1991737024, int2 : int2 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getObj1 = function(asyncResult) {
		var req =  { _typeId : 68205653 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setObj1 = function(obj1, asyncResult) {
		var req =  { _typeId : 1991903927, obj1 : obj1 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.remote.BStub_RemoteStreams = function(transport) {
	
	this._typeId = 2028487863;
	
	this.transport = transport;
	
	/**
	*/
	this.getImage = function(asyncResult) {
		var req =  { _typeId : 1902276204 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setImage = function(istrm, asyncResult) {
		var req =  { _typeId : 1831578632, istrm : istrm };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getImages = function(asyncResult) {
		var req =  { _typeId : 1158979935 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setImages = function(istrms, doNotReadStreamAtKey, asyncResult) {
		var req =  { _typeId : 944362859, istrms : istrms, doNotReadStreamAtKey : doNotReadStreamAtKey };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.throwLastException = function(asyncResult) {
		var req =  { _typeId : 2047657918 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getTextStream = function(asyncResult) {
		var req =  { _typeId : 1083407988 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.srvr.BStub_ClientIF = function(transport) {
	
	this._typeId = 1784257353;
	
	this.transport = transport;
	
	/**
	*/
	this.incrementInt = function(a, asyncResult) {
		var req =  { _typeId : 1461829915, a : a };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getStreams = function(ctrl, asyncResult) {
		var req =  { _typeId : 865920738, ctrl : ctrl };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.putStreams = function(strm, ctrl, asyncResult) {
		var req =  { _typeId : 242798857, strm : strm, ctrl : ctrl };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.sendChat = function(cs, asyncResult) {
		var req =  { _typeId : 1352392091, cs : cs };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.srvr.BStub_ServerIF = function(transport) {
	
	this._typeId = 1313562065;
	
	this.transport = transport;
	
	/**
	*/
	this.callClientIncrementInt = function(v, asyncResult) {
		var req =  { _typeId : 1252575894, v : v };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setPartner = function(client, asyncResult) {
		var req =  { _typeId : 1188403123, client : client };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getPartner = function(asyncResult) {
		var req =  { _typeId : 748402113 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getStreamsFromClient = function(asyncResult) {
		var req =  { _typeId : 1415283169 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.putStreamsOnClient = function(streams, asyncResult) {
		var req =  { _typeId : 1367013829, streams : streams };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.registerWithClientMap = function(id, asyncResult) {
		var req =  { _typeId : 1921080901, id : id };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getClient = function(id, asyncResult) {
		var req =  { _typeId : 2107407220, id : id };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getClientIds = function(asyncResult) {
		var req =  { _typeId : 2063368540 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
};

/**
*/
com.wilutions.byps.test.api.ver.BStub_EvolveIF = function(transport) {
	
	this._typeId = 2078696281;
	
	this.transport = transport;
	
	/**
	*/
	this.setEvolve = function(obj, asyncResult) {
		var req =  { _typeId : 246658450, obj : obj };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getEvolve = function(asyncResult) {
		var req =  { _typeId : 32041374 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.setClient = function(partner, asyncResult) {
		var req =  { _typeId : 313337668, partner : partner };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.getClient = function(asyncResult) {
		var req =  { _typeId : 98720592 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
	/**
	*/
	this.sendEvolveToClient = function(asyncResult) {
		var req =  { _typeId : 1425170268 };
		var ret = transport.send(req, asyncResult);
		return ret.result;
	};
	
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
				343675807, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			589243771 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				343685565, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			589230893 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				343698443, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			1071498593 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				2079507047, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			1265927470 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				149640346, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			588955655 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				343973681, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			1083385729 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				2067619911, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			720472590 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				382600378, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			1154444878 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				51371910, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			1765354225 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1191276985, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			1023062396 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				80010572, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			1645604187 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1716433773, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			1645613945 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1716424015, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			1645626823 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1716411137, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			510386133 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1654347789, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1609477282 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				193909466, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			1645902061 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1716135899, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			522273269 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				1666234925, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			935089666 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				167983302, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			1369061954 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				265988986, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			825201405 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				251124165, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			1237679472 : [ // _typeId of request class
				1557084481, // _typeId of remote interface
				134606504, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
		
		
		// Remote Interface RemoteArrayTypes4dim			
			// Method setBool
			202005372 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				730923964, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			201995614 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				730933722, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			201982736 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				730946600, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			1951707614 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1199298026, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			1933153045 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				946246435, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			201707498 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				731221838, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			1963594750 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1187410890, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			796203285 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1899276253, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			362230997 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1465303965, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			710411500 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1284488740, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			493613479 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1596686447, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			2032852344 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1329185616, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			2032862102 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1329175858, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			2032874980 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1329162980, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			1390595154 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1760410486, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1589603233 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1289796247, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			2033150218 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1328887742, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			1402482290 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1748523350, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			581586209 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1684659177, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			147613921 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1250686889, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			1650564320 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				2070325736, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			278996403 : [ // _typeId of request class
				1557173854, // _typeId of remote interface
				1382069371, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
		
		
		// Remote Interface RemoteEnums			
			// Method getPlanet
			627010462 : [ // _typeId of request class
				359349400, // _typeId of remote interface
				839369882, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPlanet(methodResult);
				}
			],
			
			// Method setPlanet
			412393386 : [ // _typeId of request class
				359349400, // _typeId of remote interface
				1053986958, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPlanet(methodObj.planet, methodResult);
				}
			],
		
		
		// Remote Interface RemoteException			
			// Method throwBException
			641509600 : [ // _typeId of request class
				1959416539, // _typeId of remote interface
				805985960, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwBException(methodObj.code, methodObj.msg, methodResult);
				}
			],
			
			// Method throwFirstException
			533533486 : [ // _typeId of request class
				1959416539, // _typeId of remote interface
				1025539738, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwFirstException(methodResult);
				}
			],
			
			// Method throwException
			67092708 : [ // _typeId of request class
				1959416539, // _typeId of remote interface
				1170165676, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwException(methodObj.what, methodResult);
				}
			],
			
			// Method throwNullPointerException
			1888829108 : [ // _typeId of request class
				1959416539, // _typeId of remote interface
				2113544940, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwNullPointerException(methodResult);
				}
			],
		
		
		// Remote Interface RemoteInlineInstance			
			// Method setActor
			299289599 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1443251255, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActor(methodObj.act, methodResult);
				}
			],
			
			// Method getActor
			261822861 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				882138795, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActor(methodResult);
				}
			],
			
			// Method setActorArray1dim
			240237169 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				333840071, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActorArray1dim(methodObj.actorArray, methodResult);
				}
			],
			
			// Method getActorArray1dim
			699915651 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1273992891, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActorArray1dim(methodResult);
				}
			],
			
			// Method setActorArray4dim
			240147796 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				333929444, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActorArray4dim(methodObj.actorArray, methodResult);
				}
			],
			
			// Method getActorArray4dim
			700005024 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1274082264, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActorArray4dim(methodResult);
				}
			],
			
			// Method setActorList
			1902022593 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1540936711, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActorList(methodObj.actorList, methodResult);
				}
			],
			
			// Method getActorList
			843952075 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				8055917, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActorList(methodResult);
				}
			],
			
			// Method setActorListList
			2080023171 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1540726085, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActorListList(methodObj.actorListList, methodResult);
				}
			],
			
			// Method getActorListList
			248580343 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				922798383, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActorListList(methodResult);
				}
			],
			
			// Method setActorSet
			215745697 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1019545561, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActorSet(methodObj.actorSet, methodResult);
				}
			],
			
			// Method getActorSet
			304325525 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1108125389, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActorSet(methodResult);
				}
			],
			
			// Method setActorMap
			215739803 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1019539667, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActorMap(methodObj.actorMap, methodResult);
				}
			],
			
			// Method getActorMap
			304319631 : [ // _typeId of request class
				1206670536, // _typeId of remote interface
				1108119495, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActorMap(methodResult);
				}
			],
		
		
		// Remote Interface RemoteListTypes			
			// Method getBoolean1
			1794077576 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				378509760, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			1882657404 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				467089588, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			1319541530 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				495081042, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			758429070 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				66031418, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			1319940748 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				495480260, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			758828288 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				65632200, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			1573024156 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1361495508, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1787641232 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1576112584, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			874047761 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				431810265, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			1360809955 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1803047451, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			1328473126 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				504012638, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			767360666 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				57099822, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			1941525372 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1729996724, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			2138824848 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1944613800, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1741299407 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				521121385, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			195505829 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1837040675, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			1173060367 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1089360425, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			763744869 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1268801635, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			1940572240 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1298128264, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			1434361404 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				2076805380, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			1319541531 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				495081043, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			758429071 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				66031417, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			874047762 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				431810266, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			1360809954 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1803047450, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			874214665 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				431977169, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			1360643051 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1802880547, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
			
			// Method getInt3
			874047763 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				431810267, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt3(methodResult);
				}
			],
			
			// Method setInt3
			1360809953 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1803047449, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt3(methodObj.int3, methodResult);
				}
			],
			
			// Method getInt4
			874047764 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				431810268, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt4(methodResult);
				}
			],
			
			// Method setInt4
			1360809952 : [ // _typeId of request class
				380156079, // _typeId of remote interface
				1803047448, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt4(methodObj.int4, methodResult);
				}
			],
		
		
		// Remote Interface RemoteMapTypes			
			// Method getBoolean1
			461626272 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1800794520, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			550206100 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1712214692, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			1348711374 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1790948870, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			1909823834 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1942905966, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			1348312156 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1790549652, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			1909424616 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1943305184, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			1610481740 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				786021252, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1395864664 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				571404176, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			1013140231 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				773709361, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			1046969349 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1461148355, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			1339779778 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1782017274, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			1900892238 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1951837562, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			1241980524 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				417520036, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			1027363448 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				202902960, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1836864439 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1625335791, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			99940797 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				311469445, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			1268625399 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1057096751, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			668179837 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				879708485, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			77071512 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				929079504, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			842962140 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				9045852, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			1348711373 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1790948869, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			1909823833 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1942905967, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			1013140230 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				773709362, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			1046969350 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1461148354, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			1012973327 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				773876265, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			1047136253 : [ // _typeId of request class
				80483097, // _typeId of remote interface
				1460981451, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
		
		
		// Remote Interface RemotePrimitiveTypes			
			// Method voidFunctionVoid
			1856936054 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1763813202, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_voidFunctionVoid(methodResult);
				}
			],
			
			// Method setBool
			143860510 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				789068826, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			143850752 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				789078584, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			143837874 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				789091462, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			149216892 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1293178548, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			974465289 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				441102527, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			143562636 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				789366700, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			161104028 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1305065684, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			753565751 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1856638719, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			319593463 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1422666431, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			941809610 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1515886850, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			450975945 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1554048913, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			2090997206 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1271040754, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			2091006964 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1271030996, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			2091019842 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1271018118, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			411895568 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				732066088, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1318015101 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				97552715, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			2091295080 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1270742880, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			400008432 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				743953224, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			538948675 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1642021643, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			104976387 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1208049355, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			1881962430 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1838927626, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			236358869 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				1339431837, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
			
			// Method sendAllTypes
			1794219594 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				942211602, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendAllTypes(methodObj.b, methodObj.c, methodObj.s, methodObj.i, methodObj.l, methodObj.f, methodObj.d, methodObj.str, methodObj.pt, methodObj.o, methodResult);
				}
			],
			
			// Method add
			1073583639 : [ // _typeId of request class
				1341983932, // _typeId of remote interface
				249123151, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_add(methodObj.a, methodObj.b, methodResult);
				}
			],
		
		
		// Remote Interface RemoteReferences			
			// Method getNode
			655936732 : [ // _typeId of request class
				2086824050, // _typeId of remote interface
				1480397220, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getNode(methodResult);
				}
			],
			
			// Method setNode
			1404172848 : [ // _typeId of request class
				2086824050, // _typeId of remote interface
				579712360, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setNode(methodObj.v, methodResult);
				}
			],
		
		
		// Remote Interface RemoteSetTypes			
			// Method getBoolean1
			1690813926 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				571606866, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			1779393754 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				483027038, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			2125684552 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1727045248, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			1608170284 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1165932788, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			2125285334 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1727444466, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			1608569502 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1166332006, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			1000850298 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1825310786, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1215467374 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				2039927862, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			68372557 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1718477035, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			1991737023 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				516380681, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			2116752956 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1735976844, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			1617101880 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1174864384, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			1369351514 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				2101155294, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			1583968590 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1886538218, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1183778993 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				972250345, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			753026243 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				964554891, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			615539953 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				404011305, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			1321265283 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1532793931, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			1802821742 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				950813750, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			1572111902 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1870847402, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			2125684551 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1727045249, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			1608170285 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1165932789, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			68372556 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1718477036, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			1991737024 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				516380680, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			68205653 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				1718643939, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			1991903927 : [ // _typeId of request class
				1156008353, // _typeId of remote interface
				516213777, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
		
		
		// Remote Interface RemoteStreams			
			// Method getImage
			1902276204 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				115426612, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getImage(methodResult);
				}
			],
			
			// Method setImage
			1831578632 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				676539072, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setImage(methodObj.istrm, methodResult);
				}
			],
			
			// Method getImages
			1158979935 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				716742439, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getImages(methodResult);
				}
			],
			
			// Method setImages
			944362859 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				502125363, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setImages(methodObj.istrms, methodObj.doNotReadStreamAtKey, methodResult);
				}
			],
			
			// Method throwLastException
			2047657918 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				1243858054, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwLastException(methodResult);
				}
			],
			
			// Method getTextStream
			1083407988 : [ // _typeId of request class
				2028487863, // _typeId of remote interface
				1795991492, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getTextStream(methodResult);
				}
			],
		
		
		// Remote Interface ClientIF			
			// Method incrementInt
			1461829915 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				1720916535, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_incrementInt(methodObj.a, methodResult);
				}
			],
			
			// Method getStreams
			865920738 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				1897164468, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getStreams(methodObj.ctrl, methodResult);
				}
			],
			
			// Method putStreams
			242798857 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				1274042587, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_putStreams(methodObj.strm, methodObj.ctrl, methodResult);
				}
			],
			
			// Method sendChat
			1352392091 : [ // _typeId of request class
				1784257353, // _typeId of remote interface
				1101039945, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendChat(methodObj.cs, methodResult);
				}
			],
		
		
		// Remote Interface ServerIF			
			// Method callClientIncrementInt
			1252575894 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				846649496, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_callClientIncrementInt(methodObj.v, methodResult);
				}
			],
			
			// Method setPartner
			1188403123 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				2075320443, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPartner(methodObj.client, methodResult);
				}
			],
			
			// Method getPartner
			748402113 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				282841617, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPartner(methodResult);
				}
			],
			
			// Method getStreamsFromClient
			1415283169 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				2117724017, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getStreamsFromClient(methodResult);
				}
			],
			
			// Method putStreamsOnClient
			1367013829 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				1000905741, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_putStreamsOnClient(methodObj.streams, methodResult);
				}
			],
			
			// Method registerWithClientMap
			1921080901 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				227959465, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_registerWithClientMap(methodObj.id, methodResult);
				}
			],
			
			// Method getClient
			2107407220 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				1309389154, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClient(methodObj.id, methodResult);
				}
			],
			
			// Method getClientIds
			2063368540 : [ // _typeId of request class
				1313562065, // _typeId of remote interface
				1119377910, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClientIds(methodResult);
				}
			],
		
		
		// Remote Interface EvolveIF			
			// Method setEvolve
			246658450 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				959298536, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setEvolve(methodObj.obj, methodResult);
				}
			],
			
			// Method getEvolve
			32041374 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				744681460, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getEvolve(methodResult);
				}
			],
			
			// Method setClient
			313337668 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				1025977754, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setClient(methodObj.partner, methodResult);
				}
			],
			
			// Method getClient
			98720592 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				811360678, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClient(methodResult);
				}
			],
			
			// Method sendEvolveToClient
			1425170268 : [ // _typeId of request class
				2078696281, // _typeId of remote interface
				1931893518, // _typeId of result class
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
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setPrimitiveTypes1
		9045852 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setShort1
		571404176 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setShort
		1951707614 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1859644668 // short[][][][]
			},
			{// names of inline elements
				"v":1859644668 // short[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getInt1
		1013140231 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[]
		801243127 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			1
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getInt2
		1013140230 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_sendChat
		1101039945 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":7007 // com.wilutions.byps.test.api.srvr.ChatStructure
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getDouble
		581586209 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setString1
		879708485 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getString1
		615539953 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getObj1
		68205653 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setByte1
		1165932788 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getObject
		1237679472 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setByte2
		1165932789 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setLong1
		1900892238 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"long1":1973996106 // Map<Short,Long>
			},
			{// names of inline elements
				"long1":1973996106 // Map<Short,Long>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorList
		1540936711 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setBoolean1
		483027038 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getFloat
		1748523350 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1516687588 // float[][][][]
			},
			{// names of inline elements
				"result":1516687588 // float[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getPrimitiveTypes1
		1802821742 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_setPlanet
		412393386 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"planet":1042475995 // com.wilutions.byps.test.api.enu.EnumPlanets
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwException
		67092708 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"what":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorMap
		304319631 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setObject
		1023062396 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":183594037 // Object[]
			},
			{// names of inline elements
				"v":183594037 // Object[]
			},
			false // inlineInstance
		),
		
		// Object[]
		183594037 : new com.wilutions.byps.BSerializerArray(
			21, // Element type: Object
			1
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getString
		147613921 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setShort1
		1576112584 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteException_throwException
		1170165676 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setString1
		1532793931 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// float[]
		766441794 : new com.wilutions.byps.BSerializerArray(
			7, // Element type: float
			1
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorArray1dim
		333840071 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setPrimitiveTypes1
		842962140 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"primitiveTypes1":703065817 // Map<Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			{// names of inline elements
				"primitiveTypes1":703065817 // Map<Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getPrimitiveTypes
		251124165 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			{// names of inline elements
				"result":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getFloat1
		2101155294 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1898022288 // Set<Float>
			},
			{// names of inline elements
				"result":1898022288 // Set<Float>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_add
		1073583639 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"a":5, // int
				"b":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setBool
		143860510 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1 // boolean
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getByte1
		495081042 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1059148284 // List<Byte>
			},
			{// names of inline elements
				"result":1059148284 // List<Byte>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getByte2
		495081043 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1174971318 // List<byte[]>
			},
			{// names of inline elements
				"result":1174971318 // List<byte[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getObject
		236358869 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteEnums_setPlanet
		1053986958 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwBException
		641509600 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"code":5, // int
				"msg":10 // String
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getPrimitiveTypes
		1838927626 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1000 // com.wilutions.byps.test.api.prim.PrimitiveTypes
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteReferences
		2086824050 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteReferences),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setBoolean1
		1882657404 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean1":1617670280 // List<Boolean>
			},
			{// names of inline elements
				"boolean1":1617670280 // List<Boolean>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getPrimitiveTypes1
		929079504 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":703065817 // Map<Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			{// names of inline elements
				"result":703065817 // Map<Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setChar
		789091462 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.FirstException
		11000 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"listOfStrings":2123584667, // List<String>
				"cause":20 // Throwable
			},
			{// names of inline elements
				"listOfStrings":2123584667, // List<String>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setString1
		1321265283 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"string1":1888799711 // Set<String>
			},
			{// names of inline elements
				"string1":1888799711 // Set<String>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getShort
		510386133 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setByte
		789078584 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorArray1dim
		1273992891 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1784131613 // com.wilutions.byps.test.api.inl.Actor[]
			},
			{// names of inline elements
				"result":1784131613 // com.wilutions.byps.test.api.inl.Actor[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getPrimitiveTypes
		1650564320 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
		1765354225 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			{// names of inline elements
				"v":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getChar
		1645626823 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getString1
		1057096751 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1710660846 // Map<String,String>
			},
			{// names of inline elements
				"result":1710660846 // Map<String,String>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setByte
		730933722 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setChar1
		65632200 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClient
		2107407220 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"id":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getChar
		1329162980 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":769021986 // char[][][][]
			},
			{// names of inline elements
				"result":769021986 // char[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorArray4dim
		1274082264 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":193284349 // com.wilutions.byps.test.api.inl.Actor[][][][]
			},
			{// names of inline elements
				"result":193284349 // com.wilutions.byps.test.api.inl.Actor[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getChar1
		1727444466 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":936607009 // TreeSet<Character>
			},
			{// names of inline elements
				"result":936607009 // TreeSet<Character>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getLong
		1328887742 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":846419204 // long[][][][]
			},
			{// names of inline elements
				"result":846419204 // long[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getObj1
		1012973327 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setBool
		202005372 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":945713488 // boolean[][][][]
			},
			{// names of inline elements
				"v":945713488 // boolean[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getFloat
		743953224 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":7 // float
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_setPartner
		2075320443 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setInt
		1933153045 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":39910537 // int[][][][]
			},
			{// names of inline elements
				"v":39910537 // int[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_add
		249123151 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_putStreams
		1274042587 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getDouble1
		1836864439 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setPrimitiveTypes
		1191276985 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getPrimitiveTypes
		2070325736 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			{// names of inline elements
				"result":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setByte
		201995614 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1201775504 // byte[][][][]
			},
			{// names of inline elements
				"v":1201775504 // byte[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwNullPointerException
		1888829108 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getInt2
		68372556 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setObj1
		1360643051 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"obj1":12 // List<Object>
			},
			{// names of inline elements
				"obj1":12 // List<Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getInt2
		773709362 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1633750383 // Map<Integer,int[]>
			},
			{// names of inline elements
				"result":1633750383 // Map<Integer,int[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorSet
		215745697 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"actorSet":797794691 // Set<com.wilutions.byps.test.api.inl.Actor>
			},
			{// names of inline elements
				"actorSet":797794691 // Set<com.wilutions.byps.test.api.inl.Actor>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getInt1
		68372557 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getInt1
		773709361 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1347703734 // Map<Integer,Integer>
			},
			{// names of inline elements
				"result":1347703734 // Map<Integer,Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorMap
		215739803 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"actorMap":1930448581 // Map<Integer,com.wilutions.byps.test.api.inl.Actor>
			},
			{// names of inline elements
				"actorMap":1930448581 // Map<Integer,com.wilutions.byps.test.api.inl.Actor>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setPrimitiveTypes1
		1572111902 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"primitiveTypes1":1280571537 // Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			{// names of inline elements
				"primitiveTypes1":1280571537 // Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getInt
		1289796247 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":39910537 // int[][][][]
			},
			{// names of inline elements
				"result":39910537 // int[][][][]
			},
			false // inlineInstance
		),
		
		// boolean[][][][]
		945713488 : new com.wilutions.byps.BSerializerArray(
			1, // Element type: boolean
			4
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getChar
		1271018118 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":4 // char
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
		710411500 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			{// names of inline elements
				"v":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDouble
		538948675 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setInt2
		516380680 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getImage
		115426612 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":15 // java.io.InputStream
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getChar1
		495480260 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1661807911 // List<Character>
			},
			{// names of inline elements
				"result":1661807911 // List<Character>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setLong
		343973681 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getPartner
		748402113 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setInt1
		516380681 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setChar
		143837874 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":4 // char
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteReferences_getNode
		1480397220 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":9001 // com.wilutions.byps.test.api.refs.Node
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setInt
		149640346 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_getClient
		811360678 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2078696281 // com.wilutions.byps.test.api.ver.EvolveIF
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getDouble
		1642021643 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":8 // double
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setDouble
		1899276253 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setString
		1465303965 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_voidFunctionVoid
		1856936054 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setFloat
		2067619911 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getFloat
		400008432 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorMap
		1108119495 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1930448581 // Map<Integer,com.wilutions.byps.test.api.inl.Actor>
			},
			{// names of inline elements
				"result":1930448581 // Map<Integer,com.wilutions.byps.test.api.inl.Actor>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorList
		1902022593 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"actorList":494001343 // List<com.wilutions.byps.test.api.inl.Actor>
			},
			{// names of inline elements
				"actorList":494001343 // List<com.wilutions.byps.test.api.inl.Actor>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setPrimitiveTypes1
		1434361404 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"primitiveTypes1":1544333227 // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			{// names of inline elements
				"primitiveTypes1":1544333227 // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getBoolean1
		1800794520 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1279823631 // Map<String,Boolean>
			},
			{// names of inline elements
				"result":1279823631 // Map<String,Boolean>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_incrementInt
		1720916535 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inl.Actor[]
		1784131613 : new com.wilutions.byps.BSerializerArray(
			171948703, // Element type: com.wilutions.byps.test.api.inl.Actor
			1
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActor
		882138795 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":171948703 // com.wilutions.byps.test.api.inl.Actor
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setString
		1422666431 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getLong
		2091295080 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setDouble1
		1837040675 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setString
		319593463 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":10 // String
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setBool
		730923964 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_setImages
		502125363 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setPrimitiveTypes
		1515886850 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getInt
		1589603233 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getObj1
		874214665 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setByte1
		1942905966 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setByte2
		1942905967 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inl.Point2D[]
		2049740106 : new com.wilutions.byps.BSerializerArray(
			1835035436, // Element type: com.wilutions.byps.test.api.inl.Point2D
			1
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getShort1
		1825310786 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2028443792 // Set<Short>
			},
			{// names of inline elements
				"result":2028443792 // Set<Short>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getInt
		97552715 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_putStreamsOnClient
		1367013829 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"streams":1218831438 // List<java.io.InputStream>
			},
			{// names of inline elements
				"streams":1218831438 // List<java.io.InputStream>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActor
		261822861 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getImages
		716742439 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":476459792 // TreeMap<Integer,java.io.InputStream>
			},
			{// names of inline elements
				"result":476459792 // TreeMap<Integer,java.io.InputStream>
			},
			false // inlineInstance
		),
		
		// long[]
		1097129250 : new com.wilutions.byps.BSerializerArray(
			6, // Element type: long
			1
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setShort
		1293178548 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setPrimitiveTypes1
		1870847402 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getBool
		1645604187 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImage
		1831578632 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"istrm":15 // java.io.InputStream
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getShort
		1654347789 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2067161310 // short[]
			},
			{// names of inline elements
				"result":2067161310 // short[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_setClient
		1025977754 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inl.Matrix2D
		135329019 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"_11":7, // float
				"_12":7, // float
				"_13":7, // float
				"_21":7, // float
				"_22":7, // float
				"_23":7, // float
				"_31":7, // float
				"_32":7, // float
				"_33":7 // float
			},
			null,
			true // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setFloat1
		1583968590 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"float1":1898022288 // Set<Float>
			},
			{// names of inline elements
				"float1":1898022288 // Set<Float>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_putStreamsOnClient
		1000905741 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setObj1
		1460981451 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getLong1
		1782017274 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1973996106 // Map<Short,Long>
			},
			{// names of inline elements
				"result":1973996106 // Map<Short,Long>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte2
		1909823833 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"byte2":1799280818 // Map<Integer,byte[]>
			},
			{// names of inline elements
				"byte2":1799280818 // Map<Integer,byte[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setLong
		143562636 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":6 // long
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte1
		1909823834 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"byte1":1972793385 // HashMap<Double,Byte>
			},
			{// names of inline elements
				"byte1":1972793385 // HashMap<Double,Byte>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.refs.Node
		9001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"next":9001, // com.wilutions.byps.test.api.refs.Node
				"me":9001, // com.wilutions.byps.test.api.refs.Node
				"mapOfNodes":1768677016, // Map<String,com.wilutions.byps.test.api.refs.Node>
				"listOfNodes":202657921 // List<com.wilutions.byps.test.api.refs.Node>
			},
			{// names of inline elements
				"mapOfNodes":1768677016, // Map<String,com.wilutions.byps.test.api.refs.Node>
				"listOfNodes":202657921 // List<com.wilutions.byps.test.api.refs.Node>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getByte
		1329175858 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1201775504 // byte[][][][]
			},
			{// names of inline elements
				"result":1201775504 // byte[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setInt2
		1046969350 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int2":1633750383 // Map<Integer,int[]>
			},
			{// names of inline elements
				"int2":1633750383 // Map<Integer,int[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setInt1
		1046969349 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int1":1347703734 // Map<Integer,Integer>
			},
			{// names of inline elements
				"int1":1347703734 // Map<Integer,Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setPrimitiveTypes
		941809610 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1000 // com.wilutions.byps.test.api.prim.PrimitiveTypes
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
		825201405 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// char[]
		1361632968 : new com.wilutions.byps.BSerializerArray(
			4, // Element type: char
			1
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getObj1
		1718643939 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":14 // Set<Object>
			},
			{// names of inline elements
				"result":14 // Set<Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setObj1
		1802880547 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setFloat1
		1027363448 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"float1":94341197 // Map<Character,Float>
			},
			{// names of inline elements
				"float1":94341197 // Map<Character,Float>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setInt
		974465289 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImage
		1902276204 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.enu.EnumPlanets[]
		1092048313 : new com.wilutions.byps.BSerializerArray(
			1042475995, // Element type: com.wilutions.byps.test.api.enu.EnumPlanets
			1
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorSet
		1019545561 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorArray4dim
		240147796 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"actorArray":193284349 // com.wilutions.byps.test.api.inl.Actor[][][][]
			},
			{// names of inline elements
				"actorArray":193284349 // com.wilutions.byps.test.api.inl.Actor[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setFloat
		1083385729 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":766441794 // float[]
			},
			{// names of inline elements
				"v":766441794 // float[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteReferences_setNode
		579712360 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_putStreams
		242798857 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"strm":1218831438, // List<java.io.InputStream>
				"ctrl":5 // int
			},
			{// names of inline elements
				"strm":1218831438, // List<java.io.InputStream>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getPrimitiveTypes1
		1940572240 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getChar
		1716411137 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1361632968 // char[]
			},
			{// names of inline elements
				"result":1361632968 // char[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getByte2
		1727045249 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2052431866 // Set<byte[]>
			},
			{// names of inline elements
				"result":2052431866 // Set<byte[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getByte1
		1727045248 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":31512998 // HashSet<Byte>
			},
			{// names of inline elements
				"result":31512998 // HashSet<Byte>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_sendEvolveToClient
		1931893518 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.SecondException
		11001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"msg":10 // String
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setChar1
		758828288 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"char1":1661807911 // List<Character>
			},
			{// names of inline elements
				"char1":1661807911 // List<Character>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getByte2
		1348711373 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getByte1
		1348711374 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorSet
		304325525 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getDouble1
		1741299407 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_getPlanet
		627010462 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setChar1
		1909424616 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"char1":8789515 // TreeMap<Float,Character>
			},
			{// names of inline elements
				"char1":8789515 // TreeMap<Float,Character>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setDouble1
		99940797 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"double1":1487265161 // Map<Byte,Double>
			},
			{// names of inline elements
				"double1":1487265161 // Map<Byte,Double>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setLong
		731221838 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteException
		1959416539 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteException),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
		1503107601 : new com.wilutions.byps.BSerializerArray(
			1000, // Element type: com.wilutions.byps.test.api.prim.PrimitiveTypes
			4
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setString1
		1268801635 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_registerWithClientMap
		1921080901 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"id":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ClientIF_getStreams
		1897164468 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1218831438 // List<java.io.InputStream>
			},
			{// names of inline elements
				"result":1218831438 // List<java.io.InputStream>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorListList
		922798383 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1398598597 // List<List<com.wilutions.byps.test.api.inl.Actor>>
			},
			{// names of inline elements
				"result":1398598597 // List<List<com.wilutions.byps.test.api.inl.Actor>>
			},
			false // inlineInstance
		),
		
		// int[][][][]
		39910537 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: int
			4
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes
		1156008353 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getFloat1
		1729996724 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1628501332 // List<Float>
			},
			{// names of inline elements
				"result":1628501332 // List<Float>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorList
		843952075 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getLong
		1270742880 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":6 // long
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setFloat1
		202902960 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setChar1
		1608569502 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"char1":936607009 // TreeSet<Character>
			},
			{// names of inline elements
				"char1":936607009 // TreeSet<Character>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setChar1
		1166332006 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt4
		431810268 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1633500852 // List<Map<Integer,List<TreeSet<Integer>>>>
			},
			{// names of inline elements
				"result":1633500852 // List<Map<Integer,List<TreeSet<Integer>>>>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setLong1
		767360666 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"long1":1050216688 // List<Long>
			},
			{// names of inline elements
				"long1":1050216688 // List<Long>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setDouble1
		753026243 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"double1":1320560671 // Set<Double>
			},
			{// names of inline elements
				"double1":1320560671 // Set<Double>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inl.Actor
		171948703 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"shape":2049740106, // com.wilutions.byps.test.api.inl.Point2D[]
				"position":135329019 // com.wilutions.byps.test.api.inl.Matrix2D
			},
			{// names of inline elements
				"shape":2049740106, // com.wilutions.byps.test.api.inl.Point2D[]
				"position":135329019 // com.wilutions.byps.test.api.inl.Matrix2D
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt1
		431810265 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":181681714 // List<Integer>
			},
			{// names of inline elements
				"result":181681714 // List<Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt2
		431810266 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1752158699 // List<int[]>
			},
			{// names of inline elements
				"result":1752158699 // List<int[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt3
		431810267 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1746702954 // List<List<Integer>>
			},
			{// names of inline elements
				"result":1746702954 // List<List<Integer>>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setChar
		201982736 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":769021986 // char[][][][]
			},
			{// names of inline elements
				"v":769021986 // char[][][][]
			},
			false // inlineInstance
		),
		
		// int[]
		100361105 : new com.wilutions.byps.BSerializerArray(
			5, // Element type: int
			1
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte2
		1608170285 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"byte2":2052431866 // Set<byte[]>
			},
			{// names of inline elements
				"byte2":2052431866 // Set<byte[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte1
		1608170284 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"byte1":31512998 // HashSet<Byte>
			},
			{// names of inline elements
				"byte1":31512998 // HashSet<Byte>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.arr.ArrayTypes1dim
		2001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean1":2058423690, // boolean[]
				"byte1":1374008726, // byte[]
				"char1":1361632968, // char[]
				"short1":2067161310, // short[]
				"int1":100361105, // int[]
				"long1":1097129250, // long[]
				"float1":766441794, // float[]
				"double1":1359468275, // double[]
				"string1":1888107655, // String[]
				"primitiveTypes1":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			{// names of inline elements
				"boolean1":2058423690, // boolean[]
				"byte1":1374008726, // byte[]
				"char1":1361632968, // char[]
				"short1":2067161310, // short[]
				"int1":100361105, // int[]
				"long1":1097129250, // long[]
				"float1":766441794, // float[]
				"double1":1359468275, // double[]
				"string1":1888107655, // String[]
				"primitiveTypes1":801243127 // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getFloat1
		417520036 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":94341197 // Map<Character,Float>
			},
			{// names of inline elements
				"result":94341197 // Map<Character,Float>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes
		80483097 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes),
		
		// com.wilutions.byps.test.api.ver.Evolve
		1391985860 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"bool1":1, // boolean
				"byte1":2, // byte
				"char1":4, // char
				"short1":3, // short
				"int1":5, // int
				"long1":6, // long
				"float1":7, // float
				"double1":8, // double
				"bools1":2058423690, // boolean[]
				"bytes1":1374008726, // byte[]
				"chars1":1361632968, // char[]
				"shorts1":2067161310, // short[]
				"ints1":100361105, // int[]
				"longs1":1097129250, // long[]
				"floats1":766441794, // float[]
				"doubles1":1359468275, // double[]
				"str1":10, // String
				"obj1":21, // Object
				"evo1":573592593, // com.wilutions.byps.test.api.ver.Evolve2
				"list1":181681714, // List<Integer>
				"set1":1493282670, // Set<Integer>
				"map1":1347703734, // Map<Integer,Integer>
				"bool2":1, // boolean
				"byte2":2, // byte
				"char2":4, // char
				"short2":3, // short
				"int2":5, // int
				"long2":6, // long
				"float2":7, // float
				"double2":8, // double
				"bools2":2058423690, // boolean[]
				"bytes2":1374008726, // byte[]
				"chars2":1361632968, // char[]
				"shorts2":2067161310, // short[]
				"ints2":100361105, // int[]
				"longs2":1097129250, // long[]
				"floats2":766441794, // float[]
				"doubles2":1359468275, // double[]
				"str2":10, // String
				"obj2":21, // Object
				"evo2":573592593, // com.wilutions.byps.test.api.ver.Evolve2
				"list2":181681714, // List<Integer>
				"set2":1493282670, // Set<Integer>
				"map2":1347703734, // Map<Integer,Integer>
				"bool3":1, // boolean
				"byte3":2, // byte
				"char3":4, // char
				"short3":3, // short
				"int3":5, // int
				"long3":6, // long
				"float3":7, // float
				"double3":8, // double
				"bools3":2058423690, // boolean[]
				"bytes3":1374008726, // byte[]
				"chars3":1361632968, // char[]
				"shorts3":2067161310, // short[]
				"ints3":100361105, // int[]
				"longs3":1097129250, // long[]
				"floats3":766441794, // float[]
				"doubles3":1359468275, // double[]
				"str3":10, // String
				"obj3":21, // Object
				"evo3":573592593, // com.wilutions.byps.test.api.ver.Evolve2
				"list3":181681714, // List<Integer>
				"set3":1493282670, // Set<Integer>
				"map3":1347703734 // Map<Integer,Integer>
			},
			{// names of inline elements
				"bools1":2058423690, // boolean[]
				"bytes1":1374008726, // byte[]
				"chars1":1361632968, // char[]
				"shorts1":2067161310, // short[]
				"ints1":100361105, // int[]
				"longs1":1097129250, // long[]
				"floats1":766441794, // float[]
				"doubles1":1359468275, // double[]
				"list1":181681714, // List<Integer>
				"set1":1493282670, // Set<Integer>
				"map1":1347703734, // Map<Integer,Integer>
				"bools2":2058423690, // boolean[]
				"bytes2":1374008726, // byte[]
				"chars2":1361632968, // char[]
				"shorts2":2067161310, // short[]
				"ints2":100361105, // int[]
				"longs2":1097129250, // long[]
				"floats2":766441794, // float[]
				"doubles2":1359468275, // double[]
				"list2":181681714, // List<Integer>
				"set2":1493282670, // Set<Integer>
				"map2":1347703734, // Map<Integer,Integer>
				"bools3":2058423690, // boolean[]
				"bytes3":1374008726, // byte[]
				"chars3":1361632968, // char[]
				"shorts3":2067161310, // short[]
				"ints3":100361105, // int[]
				"longs3":1097129250, // long[]
				"floats3":766441794, // float[]
				"doubles3":1359468275, // double[]
				"list3":181681714, // List<Integer>
				"set3":1493282670, // Set<Integer>
				"map3":1347703734 // Map<Integer,Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim
		1557173854 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getClientIds
		1119377910 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1493282670 // Set<Integer>
			},
			{// names of inline elements
				"result":1493282670 // Set<Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_registerWithClientMap
		227959465 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getBoolean1
		378509760 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1617670280 // List<Boolean>
			},
			{// names of inline elements
				"result":1617670280 // List<Boolean>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteException_throwNullPointerException
		2113544940 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setFloat
		1963594750 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1516687588 // float[][][][]
			},
			{// names of inline elements
				"v":1516687588 // float[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_setNode
		1404172848 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":9001 // com.wilutions.byps.test.api.refs.Node
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getChar1
		1319940748 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_throwLastException
		1243858054 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteStreams
		2028487863 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteStreams),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getChar1
		1790549652 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":8789515 // TreeMap<Float,Character>
			},
			{// names of inline elements
				"result":8789515 // TreeMap<Float,Character>
			},
			false // inlineInstance
		),
		
		// char[][][][]
		769021986 : new com.wilutions.byps.BSerializerArray(
			4, // Element type: char
			4
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setFloat1
		2138824848 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"float1":1628501332 // List<Float>
			},
			{// names of inline elements
				"float1":1628501332 // List<Float>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getShort
		1390595154 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setString
		362230997 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":588723219 // String[][][][]
			},
			{// names of inline elements
				"v":588723219 // String[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setByte
		143850752 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":2 // byte
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getDouble
		167983302 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1359468275 // double[]
			},
			{// names of inline elements
				"result":1359468275 // double[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getString1
		1089360425 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2123584667 // List<String>
			},
			{// names of inline elements
				"result":2123584667 // List<String>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getShort1
		1610481740 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setDouble1
		195505829 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"double1":1555345627 // List<Double>
			},
			{// names of inline elements
				"double1":1555345627 // List<Double>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setEvolve
		246658450 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"obj":1391985860 // com.wilutions.byps.test.api.ver.Evolve
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getDouble
		935089666 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.arr.ArrayTypes4dim
		2004 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean4":945713488, // boolean[][][][]
				"byte4":1201775504, // byte[][][][]
				"char4":769021986, // char[][][][]
				"short4":1859644668, // short[][][][]
				"int4":39910537, // int[][][][]
				"long4":846419204, // long[][][][]
				"float4":1516687588, // float[][][][]
				"double4":2087445849, // double[][][][]
				"string4":588723219, // String[][][][]
				"primitiveTypes4":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			{// names of inline elements
				"boolean4":945713488, // boolean[][][][]
				"byte4":1201775504, // byte[][][][]
				"char4":769021986, // char[][][][]
				"short4":1859644668, // short[][][][]
				"int4":39910537, // int[][][][]
				"long4":846419204, // long[][][][]
				"float4":1516687588, // float[][][][]
				"double4":2087445849, // double[][][][]
				"string4":588723219, // String[][][][]
				"primitiveTypes4":1503107601 // com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteEnums
		359349400 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteEnums),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setShort
		149216892 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":3 // short
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getBool
		2090997206 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getPrimitiveTypes1
		77071512 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getChar1
		2125285334 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// short[][][][]
		1859644668 : new com.wilutions.byps.BSerializerArray(
			3, // Element type: short
			4
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getObject
		1382069371 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":124584219 // Object[][][][]
			},
			{// names of inline elements
				"result":124584219 // Object[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorListList
		2080023171 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"actorListList":1398598597 // List<List<com.wilutions.byps.test.api.inl.Actor>>
			},
			{// names of inline elements
				"actorListList":1398598597 // List<List<com.wilutions.byps.test.api.inl.Actor>>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getBool
		1329185616 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":945713488 // boolean[][][][]
			},
			{// names of inline elements
				"result":945713488 // boolean[][][][]
			},
			false // inlineInstance
		),
		
		// double[]
		1359468275 : new com.wilutions.byps.BSerializerArray(
			8, // Element type: double
			1
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getLong
		1645902061 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.list.ListTypes
		3001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean1":1617670280, // List<Boolean>
				"byte1":1059148284, // List<Byte>
				"char1":1661807911, // List<Character>
				"short1":1997002548, // List<Short>
				"int1":181681714, // List<Integer>
				"long1":1050216688, // List<Long>
				"float1":1628501332, // List<Float>
				"double1":1555345627, // List<Double>
				"string1":2123584667, // List<String>
				"primitiveTypes1":1544333227, // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"byte2":1174971318, // List<byte[]>
				"int2":1752158699, // List<int[]>
				"int4":1088217157, // List<int[][][][]>
				"obj1":12 // List<Object>
			},
			{// names of inline elements
				"boolean1":1617670280, // List<Boolean>
				"byte1":1059148284, // List<Byte>
				"char1":1661807911, // List<Character>
				"short1":1997002548, // List<Short>
				"int1":181681714, // List<Integer>
				"long1":1050216688, // List<Long>
				"float1":1628501332, // List<Float>
				"double1":1555345627, // List<Double>
				"string1":2123584667, // List<String>
				"primitiveTypes1":1544333227, // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"byte2":1174971318, // List<byte[]>
				"int2":1752158699, // List<int[]>
				"int4":1088217157, // List<int[][][][]>
				"obj1":12 // List<Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwFirstException
		533533486 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// Object[][][][]
		124584219 : new com.wilutions.byps.BSerializerArray(
			21, // Element type: Object
			4
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getByte2
		1319541531 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// double[][][][]
		2087445849 : new com.wilutions.byps.BSerializerArray(
			8, // Element type: double
			4
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getByte1
		1319541530 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getDouble1
		521121385 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1555345627 // List<Double>
			},
			{// names of inline elements
				"result":1555345627 // List<Double>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorArray4dim
		333929444 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setBoolean1
		467089588 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt4
		874047764 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientIncrementInt
		1252575894 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setChar
		730946600 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setByte
		343685565 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// String[][][][]
		588723219 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			4
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt1
		874047761 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getPrimitiveTypes1
		950813750 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1280571537 // Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			{// names of inline elements
				"result":1280571537 // Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_sendAllTypes
		942211602 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt3
		874047763 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setBool
		589253529 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":2058423690 // boolean[]
			},
			{// names of inline elements
				"v":2058423690 // boolean[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt2
		874047762 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getBool
		1271040754 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1 // boolean
			},
			null,
			false // inlineInstance
		),
		
		// java.io.InputStream[]
		1950626768 : new com.wilutions.byps.BSerializerArray(
			15, // Element type: java.io.InputStream
			1
		),
		
		// com.wilutions.byps.test.api.srvr.BStub_ServerIF
		1313562065 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.srvr.BStub_ServerIF),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setBoolean1
		1779393754 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean1":1365696060 // Set<Boolean>
			},
			{// names of inline elements
				"boolean1":1365696060 // Set<Boolean>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getLong1
		1735976844 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1457164460 // Set<Long>
			},
			{// names of inline elements
				"result":1457164460 // Set<Long>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getBool
		1716433773 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2058423690 // boolean[]
			},
			{// names of inline elements
				"result":2058423690 // boolean[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setDouble
		1856638719 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setDouble1
		964554891 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setLong1
		1617101880 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"long1":1457164460 // Set<Long>
			},
			{// names of inline elements
				"long1":1457164460 // Set<Long>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActor
		299289599 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"act":171948703 // com.wilutions.byps.test.api.inl.Actor
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setFloat
		1187410890 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getObject
		134606504 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":183594037 // Object[]
			},
			{// names of inline elements
				"result":183594037 // Object[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_sendEvolveToClient
		1425170268 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getLong
		2033150218 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getBool
		2032852344 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setLong
		588955655 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1097129250 // long[]
			},
			{// names of inline elements
				"v":1097129250 // long[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getFloat1
		1369351514 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getBoolean1
		571606866 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1365696060 // Set<Boolean>
			},
			{// names of inline elements
				"result":1365696060 // Set<Boolean>
			},
			false // inlineInstance
		),
		
		// boolean[]
		2058423690 : new com.wilutions.byps.BSerializerArray(
			1, // Element type: boolean
			1
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setString
		51371910 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setObject
		80010572 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setChar
		589230893 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1361632968 // char[]
			},
			{// names of inline elements
				"v":1361632968 // char[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getFloat1
		1241980524 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inl.Point2D
		1835035436 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"x":3, // short
				"y":3 // short
			},
			null,
			true // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setDouble1
		311469445 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteException_throwBException
		805985960 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setDouble
		382600378 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_getStreams
		865920738 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"ctrl":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getClient
		98720592 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getPrimitiveTypes1
		1298128264 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1544333227 // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			{// names of inline elements
				"result":1544333227 // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setChar
		343698443 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getShort
		1760410486 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1859644668 // short[][][][]
			},
			{// names of inline elements
				"result":1859644668 // short[][][][]
			},
			false // inlineInstance
		),
		
		// String[]
		1888107655 : new com.wilutions.byps.BSerializerArray(
			10, // Element type: String
			1
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setShort1
		1395864664 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"short1":601099730 // Map<Long,Short>
			},
			{// names of inline elements
				"short1":601099730 // Map<Long,Short>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.ChatStructure
		7007 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"msg":10, // String
				"sentAt":8, // double
				"receivedAt":8 // double
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActor
		1443251255 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setLong1
		1951837562 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setPrimitiveTypes1
		2076805380 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// byte[]
		1374008726 : new com.wilutions.byps.BSerializerArray(
			2, // Element type: byte
			1
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setString1
		763744869 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"string1":2123584667 // List<String>
			},
			{// names of inline elements
				"string1":2123584667 // List<String>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_voidFunctionVoid
		1763813202 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_sendChat
		1352392091 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"cs":7007 // com.wilutions.byps.test.api.srvr.ChatStructure
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setLong
		201707498 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":846419204 // long[][][][]
			},
			{// names of inline elements
				"v":846419204 // long[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getString1
		1268625399 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getLong1
		1339779778 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getEvolve
		32041374 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setFloat
		161104028 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":7 // float
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getByte
		2091006964 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_setPartner
		1188403123 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"client":1784257353 // com.wilutions.byps.test.api.srvr.ClientIF
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setInt
		946246435 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setLong1
		57099822 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getTextStream
		1083407988 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim
		1557084481 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim),
		
		// com.wilutions.byps.test.api.srvr.BStub_ClientIF
		1784257353 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.srvr.BStub_ClientIF),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setByte1
		66031418 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setBoolean1
		550206100 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean1":1279823631 // Map<String,Boolean>
			},
			{// names of inline elements
				"boolean1":1279823631 // Map<String,Boolean>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setByte2
		66031417 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setByte2
		758429071 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"byte2":1174971318 // List<byte[]>
			},
			{// names of inline elements
				"byte2":1174971318 // List<byte[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setByte1
		758429070 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"byte1":1059148284 // List<Byte>
			},
			{// names of inline elements
				"byte1":1059148284 // List<Byte>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setLong
		789366700 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getString1
		1173060367 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getLong1
		2116752956 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getDouble
		1684659177 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2087445849 // double[][][][]
			},
			{// names of inline elements
				"result":2087445849 // double[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getShort1
		1573024156 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorArray1dim
		699915651 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_getNode
		655936732 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setLong1
		1174864384 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setDouble
		796203285 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":2087445849 // double[][][][]
			},
			{// names of inline elements
				"v":2087445849 // double[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getClient
		1309389154 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1784257353 // com.wilutions.byps.test.api.srvr.ClientIF
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setInt
		441102527 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteListTypes
		380156079 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteListTypes),
		
		// com.wilutions.byps.test.api.inherit.Class3
		6003 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int3":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inherit.Class2
		6002 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int2":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getBoolean1
		1794077576 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setInt
		1265927470 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":100361105 // int[]
			},
			{// names of inline elements
				"v":100361105 // int[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inherit.Class1Collections
		6004 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"list1":317887457, // List<com.wilutions.byps.test.api.inherit.Class1>
				"map1":981592984, // Map<String,com.wilutions.byps.test.api.inherit.Class1>
				"set1":2114305573 // Set<com.wilutions.byps.test.api.inherit.Class1>
			},
			{// names of inline elements
				"list1":317887457, // List<com.wilutions.byps.test.api.inherit.Class1>
				"map1":981592984, // Map<String,com.wilutions.byps.test.api.inherit.Class1>
				"set1":2114305573 // Set<com.wilutions.byps.test.api.inherit.Class1>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getChar
		2091019842 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorArray4dim
		700005024 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setString
		1154444878 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1888107655 // String[]
			},
			{// names of inline elements
				"v":1888107655 // String[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setObj1
		1991903927 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"obj1":14 // Set<Object>
			},
			{// names of inline elements
				"obj1":14 // Set<Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getLong
		1716135899 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1097129250 // long[]
			},
			{// names of inline elements
				"result":1097129250 // long[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getByte1
		2125684552 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getByte2
		2125684551 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getDouble1
		972250345 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1320560671 // Set<Double>
			},
			{// names of inline elements
				"result":1320560671 // Set<Double>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getString
		1369061954 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorMap
		1019539667 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getFloat
		1402482290 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setByte
		589243771 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1374008726 // byte[]
			},
			{// names of inline elements
				"v":1374008726 // byte[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClientIds
		2063368540 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setBool
		343675807 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// short[]
		2067161310 : new com.wilutions.byps.BSerializerArray(
			3, // Element type: short
			1
		),
		
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_getEvolve
		744681460 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1391985860 // com.wilutions.byps.test.api.ver.Evolve
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteException_throwFirstException
		1025539738 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// long[][][][]
		846419204 : new com.wilutions.byps.BSerializerArray(
			6, // Element type: long
			4
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getFloat1
		1941525372 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImages
		1158979935 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
		1794219594 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"b":1, // boolean
				"c":4, // char
				"s":3, // short
				"i":5, // int
				"l":6, // long
				"f":7, // float
				"d":8, // double
				"str":10, // String
				"pt":1000, // com.wilutions.byps.test.api.prim.PrimitiveTypes
				"o":21 // Object
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getByte
		2032862102 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setShort1
		1787641232 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"short1":1997002548 // List<Short>
			},
			{// names of inline elements
				"short1":1997002548 // List<Short>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setObject
		450975945 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":21 // Object
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getPartner
		282841617 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1784257353 // com.wilutions.byps.test.api.srvr.ClientIF
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inherit.Class1
		6001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int1":5, // int
				"nextClass1":6001 // com.wilutions.byps.test.api.inherit.Class1
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setObj1
		516213777 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getObject
		1339431837 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":21 // Object
			},
			null,
			false // inlineInstance
		),
		
		// float[][][][]
		1516687588 : new com.wilutions.byps.BSerializerArray(
			7, // Element type: float
			4
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getShort1
		1000850298 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setChar1
		1943305184 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorSet
		1108125389 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":797794691 // Set<com.wilutions.byps.test.api.inl.Actor>
			},
			{// names of inline elements
				"result":797794691 // Set<com.wilutions.byps.test.api.inl.Actor>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_throwLastException
		2047657918 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getObject
		278996403 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes
		1341983932 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setShort1
		1215467374 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"short1":2028443792 // Set<Short>
			},
			{// names of inline elements
				"short1":2028443792 // Set<Short>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getLong1
		504012638 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1050216688 // List<Long>
			},
			{// names of inline elements
				"result":1050216688 // List<Long>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setBoolean1
		1712214692 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.list.ListListTypes
		3002 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int2":1746702954, // List<List<Integer>>
				"int3":1633500852, // List<Map<Integer,List<TreeSet<Integer>>>>
				"int24":1865834185 // List<List<int[][][][]>>
			},
			{// names of inline elements
				"int2":1746702954, // List<List<Integer>>
				"int3":1633500852, // List<Map<Integer,List<TreeSet<Integer>>>>
				"int24":1865834185 // List<List<int[][][][]>>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setShort
		1199298026 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getString1
		404011305 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1888799711 // Set<String>
			},
			{// names of inline elements
				"result":1888799711 // Set<String>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
		753565751 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":8 // double
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getByte
		1645613945 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt4
		1360809952 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int4":1633500852 // List<Map<Integer,List<TreeSet<Integer>>>>
			},
			{// names of inline elements
				"int4":1633500852 // List<Map<Integer,List<TreeSet<Integer>>>>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setBool
		789068826 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getShort1
		786021252 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":601099730 // Map<Long,Short>
			},
			{// names of inline elements
				"result":601099730 // Map<Long,Short>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getBoolean1
		1690813926 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getByte
		1271030996 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":2 // byte
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.priv.PrivateMembers
		8001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolVal":1, // boolean
				"byteVal":2, // byte
				"charVal":4, // char
				"shortVal":3, // short
				"intVal":5, // int
				"longVal":6, // long
				"floatVal":7, // float
				"doubleVal":8, // double
				"stringVal":10, // String
				"primitiveTypes":1000, // com.wilutions.byps.test.api.prim.PrimitiveTypes
				"arrBool":2058423690, // boolean[]
				"arrInt":100361105, // int[]
				"arrString":1888107655, // String[]
				"arrPrimitiveTypes":801243127, // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
				"listBool":1617670280, // List<Boolean>
				"listInt":181681714, // List<Integer>
				"listString":2123584667, // List<String>
				"listPrimitiveTypes":1544333227, // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"mapIntListString":132175071, // Map<Integer,List<String>>
				"protInt":5, // int
				"pprotInt":5 // int
			},
			{// names of inline elements
				"arrBool":2058423690, // boolean[]
				"arrInt":100361105, // int[]
				"arrString":1888107655, // String[]
				"arrPrimitiveTypes":801243127, // com.wilutions.byps.test.api.prim.PrimitiveTypes[]
				"listBool":1617670280, // List<Boolean>
				"listInt":181681714, // List<Integer>
				"listString":2123584667, // List<String>
				"listPrimitiveTypes":1544333227, // List<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"mapIntListString":132175071, // Map<Integer,List<String>>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt1
		1360809955 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int1":181681714 // List<Integer>
			},
			{// names of inline elements
				"int1":181681714 // List<Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt2
		1360809954 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int2":1752158699 // List<int[]>
			},
			{// names of inline elements
				"int2":1752158699 // List<int[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt3
		1360809953 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int3":1746702954 // List<List<Integer>>
			},
			{// names of inline elements
				"int3":1746702954 // List<List<Integer>>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setFloat1
		1944613800 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_getStreamsFromClient
		2117724017 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1218831438 // List<java.io.InputStream>
			},
			{// names of inline elements
				"result":1218831438 // List<java.io.InputStream>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getLong1
		1328473126 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getShort1
		1361495508 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1997002548 // List<Short>
			},
			{// names of inline elements
				"result":1997002548 // List<Short>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setFloat
		1305065684 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.strm.Stream1
		1541129345 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"is1":15, // java.io.InputStream
				"contentType":10, // String
				"arrStream":1950626768, // java.io.InputStream[]
				"listStream":1218831438, // List<java.io.InputStream>
				"mapStream":779528402 // Map<Integer,java.io.InputStream>
			},
			{// names of inline elements
				"arrStream":1950626768, // java.io.InputStream[]
				"listStream":1218831438, // List<java.io.InputStream>
				"mapStream":779528402 // Map<Integer,java.io.InputStream>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getFloat
		522273269 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getString
		104976387 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BResult_EvolveIF_setEvolve
		959298536 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getString
		1208049355 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":10 // String
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getInt2
		1718477036 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1406124761 // Set<int[]>
			},
			{// names of inline elements
				"result":1406124761 // Set<int[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getDouble1
		1625335791 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1487265161 // Map<Byte,Double>
			},
			{// names of inline elements
				"result":1487265161 // Map<Byte,Double>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setObj1
		1047136253 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"obj1":1488550492 // Map<String,Object>
			},
			{// names of inline elements
				"obj1":1488550492 // Map<String,Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getInt1
		1718477035 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1493282670 // Set<Integer>
			},
			{// names of inline elements
				"result":1493282670 // Set<Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ClientIF_incrementInt
		1461829915 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"a":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setInt1
		1461148355 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.Evolve2
		573592593 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"n1":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteEnums_getPlanet
		839369882 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1042475995 // com.wilutions.byps.test.api.enu.EnumPlanets
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getChar1
		1348312156 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setInt2
		1461148354 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getObj1
		773876265 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1488550492 // Map<String,Object>
			},
			{// names of inline elements
				"result":1488550492 // Map<String,Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setClient
		313337668 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"partner":2078696281 // com.wilutions.byps.test.api.ver.EvolveIF
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getInt
		1609477282 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.ver.BStub_EvolveIF
		2078696281 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.ver.BStub_EvolveIF),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getChar
		2032874980 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setDouble
		720472590 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":1359468275 // double[]
			},
			{// names of inline elements
				"v":1359468275 // double[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorListList
		248580343 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getFloat
		1666234925 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":766441794 // float[]
			},
			{// names of inline elements
				"result":766441794 // float[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getStreamsFromClient
		1415283169 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// byte[][][][]
		1201775504 : new com.wilutions.byps.BSerializerArray(
			2, // Element type: byte
			4
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setShort
		1071498593 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":2067161310 // short[]
			},
			{// names of inline elements
				"v":2067161310 // short[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_setImage
		676539072 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setObject
		1554048913 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getTextStream
		1795991492 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":15 // java.io.InputStream
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.map.MapTypes
		4001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean1":1279823631, // Map<String,Boolean>
				"byte1":1972793385, // HashMap<Double,Byte>
				"char1":8789515, // TreeMap<Float,Character>
				"short1":601099730, // Map<Long,Short>
				"int1":1347703734, // Map<Integer,Integer>
				"long1":1973996106, // Map<Short,Long>
				"float1":94341197, // Map<Character,Float>
				"double1":1487265161, // Map<Byte,Double>
				"string1":1710660846, // Map<String,String>
				"primitiveTypes1":703065817, // Map<Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"byte2":1799280818, // Map<Integer,byte[]>
				"int2":1633750383, // Map<Integer,int[]>
				"obj1":1488550492 // Map<String,Object>
			},
			{// names of inline elements
				"boolean1":1279823631, // Map<String,Boolean>
				"byte1":1972793385, // HashMap<Double,Byte>
				"char1":8789515, // TreeMap<Float,Character>
				"short1":601099730, // Map<Long,Short>
				"int1":1347703734, // Map<Integer,Integer>
				"long1":1973996106, // Map<Short,Long>
				"float1":94341197, // Map<Character,Float>
				"double1":1487265161, // Map<Byte,Double>
				"string1":1710660846, // Map<String,String>
				"primitiveTypes1":703065817, // Map<Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"byte2":1799280818, // Map<Integer,byte[]>
				"int2":1633750383, // Map<Integer,int[]>
				"obj1":1488550492 // Map<String,Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setObject
		1596686447 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setInt1
		1991737023 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int1":1493282670 // Set<Integer>
			},
			{// names of inline elements
				"int1":1493282670 // Set<Integer>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getString
		1250686889 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":588723219 // String[][][][]
			},
			{// names of inline elements
				"result":588723219 // String[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getShort
		732066088 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":3 // short
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setShort
		2079507047 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.set.SetTypes
		5001 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolean1":1365696060, // Set<Boolean>
				"byte1":31512998, // HashSet<Byte>
				"char1":936607009, // TreeSet<Character>
				"short1":2028443792, // Set<Short>
				"int1":1493282670, // Set<Integer>
				"long1":1457164460, // Set<Long>
				"float1":1898022288, // Set<Float>
				"double1":1320560671, // Set<Double>
				"string1":1888799711, // Set<String>
				"primitiveTypes1":1280571537, // Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"byte2":2052431866, // Set<byte[]>
				"int2":1406124761, // Set<int[]>
				"obj1":14 // Set<Object>
			},
			{// names of inline elements
				"boolean1":1365696060, // Set<Boolean>
				"byte1":31512998, // HashSet<Byte>
				"char1":936607009, // TreeSet<Character>
				"short1":2028443792, // Set<Short>
				"int1":1493282670, // Set<Integer>
				"long1":1457164460, // Set<Long>
				"float1":1898022288, // Set<Float>
				"double1":1320560671, // Set<Double>
				"string1":1888799711, // Set<String>
				"primitiveTypes1":1280571537, // Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>
				"byte2":2052431866, // Set<byte[]>
				"int2":1406124761, // Set<int[]>
				"obj1":14 // Set<Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorListList
		1540726085 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getShort
		411895568 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorList
		8055917 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":494001343 // List<com.wilutions.byps.test.api.inl.Actor>
			},
			{// names of inline elements
				"result":494001343 // List<com.wilutions.byps.test.api.inl.Actor>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.enu.UsePlanets
		10000 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"planet":1042475995, // com.wilutions.byps.test.api.enu.EnumPlanets
				"planet2":1042475995, // com.wilutions.byps.test.api.enu.EnumPlanets
				"arrayOfPlanets":1092048313, // com.wilutions.byps.test.api.enu.EnumPlanets[]
				"listOfPlanets":1590740862, // ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
				"mapOfPlanets":252873856 // Map<String,com.wilutions.byps.test.api.enu.EnumPlanets>
			},
			{// names of inline elements
				"arrayOfPlanets":1092048313, // com.wilutions.byps.test.api.enu.EnumPlanets[]
				"listOfPlanets":1590740862, // ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>
				"mapOfPlanets":252873856 // Map<String,com.wilutions.byps.test.api.enu.EnumPlanets>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getPrimitiveTypes
		1881962430 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.prim.PrimitiveTypes
		1000 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"boolVal":1, // boolean
				"byteVal":2, // byte
				"charVal":4, // char
				"shortVal":3, // short
				"intVal":5, // int
				"longVal":6, // long
				"floatVal":7, // float
				"doubleVal":8, // double
				"stringVal":10, // String
				"objVal":21, // Object
				"objVal2":21, // Object
				"value":1, // boolean
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getDouble1
		1183778993 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt2
		1803047450 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getInt
		1318015101 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt3
		1803047449 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt1
		1803047451 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setFloat1
		1886538218 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getByte2
		1790948869 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1799280818 // Map<Integer,byte[]>
			},
			{// names of inline elements
				"result":1799280818 // Map<Integer,byte[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getByte1
		1790948870 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1972793385 // HashMap<Double,Byte>
			},
			{// names of inline elements
				"result":1972793385 // HashMap<Double,Byte>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt4
		1803047448 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setPrimitiveTypes
		1284488740 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setInt2
		1991737024 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"int2":1406124761 // Set<int[]>
			},
			{// names of inline elements
				"int2":1406124761 // Set<int[]>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorArray1dim
		240237169 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"actorArray":1784131613 // com.wilutions.byps.test.api.inl.Actor[]
			},
			{// names of inline elements
				"actorArray":1784131613 // com.wilutions.byps.test.api.inl.Actor[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance
		1206670536 : new com.wilutions.byps.BSerializerRemote(com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setString1
		668179837 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"string1":1710660846 // Map<String,String>
			},
			{// names of inline elements
				"string1":1710660846 // Map<String,String>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getBoolean1
		461626272 : new com.wilutions.byps.BSerializer(
			null,
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getString
		265988986 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1888107655 // String[]
			},
			{// names of inline elements
				"result":1888107655 // String[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getObj1
		431977169 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":12 // List<Object>
			},
			{// names of inline elements
				"result":12 // List<Object>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setShort1
		2039927862 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":19 // void
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.inl.Actor[][][][]
		193284349 : new com.wilutions.byps.BSerializerArray(
			171948703, // Element type: com.wilutions.byps.test.api.inl.Actor
			4
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getInt
		193909466 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":100361105 // int[]
			},
			{// names of inline elements
				"result":100361105 // int[]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImages
		944362859 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"istrms":779528402, // Map<Integer,java.io.InputStream>
				"doNotReadStreamAtKey":5 // int
			},
			{// names of inline elements
				"istrms":779528402, // Map<Integer,java.io.InputStream>
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setObject
		493613479 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"v":124584219 // Object[][][][]
			},
			{// names of inline elements
				"v":124584219 // Object[][][][]
			},
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.srvr.BResult_ServerIF_callClientIncrementInt
		846649496 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":5 // int
			},
			null,
			false // inlineInstance
		),
		
		// com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getByte
		1716424015 : new com.wilutions.byps.BSerializer(
			{// names of persistent elements
				"result":1374008726 // byte[]
			},
			{// names of inline elements
				"result":1374008726 // byte[]
			},
			false // inlineInstance
		),
	};
};
com.wilutions.byps.test.api.BRegistry_Testser.prototype = new com.wilutions.byps.BRegistry();
