/**
 * ----------------------------------------------
 * Declare packages.
 * ----------------------------------------------
*/
var byps = byps || {};
byps.test = byps.test || {};
byps.test.api = byps.test.api || {};
byps.test.api.arr = byps.test.api.arr || {};
byps.test.api.set = byps.test.api.set || {};
byps.test.api.enu = byps.test.api.enu || {};
byps.test.api.list = byps.test.api.list || {};
byps.test.api.ver = byps.test.api.ver || {};
byps.test.api.inherit = byps.test.api.inherit || {};
byps.test.api.remote = byps.test.api.remote || {};
byps.test.api.inl = byps.test.api.inl || {};
byps.test.api.prim = byps.test.api.prim || {};
byps.test.api.refs = byps.test.api.refs || {};
byps.test.api.map = byps.test.api.map || {};
byps.test.api.strm = byps.test.api.strm || {};
byps.test.api.priv = byps.test.api.priv || {};
byps.test.api.auth = byps.test.api.auth || {};
byps.test.api.srvr = byps.test.api.srvr || {};
byps.test.api.cons = byps.test.api.cons || {};

/**
 * ----------------------------------------------
 * API Descriptor
 * ----------------------------------------------
*/
byps.test.api.BApiDescriptor_Testser = {
	/**
	 * API serialisation version: 0.0.0.792
	 */
	VERSION : "0.0.0.792",
	
	/**
	 * Internal used API Desciptor.
	*/
	instance : function() {
		return new byps.BApiDescriptor(
			"Testser",
			"byps.test.api",
			"0.0.0.792",
			false, // uniqueObjects
			new byps.test.api.BRegistry_Testser()
		);
	}
};


/**
 * ----------------------------------------------
 * Client class
 * ----------------------------------------------
*/

byps.test.api.createClient_Testser = function(transportFactory) {
	return new byps.test.api.BClient_Testser(transportFactory);
};

byps.test.api.BClient_Testser = function(transportFactory) { 

	this.transport = transportFactory.createClientTransport();
	
	this._serverR = transportFactory.createServerR(
		new byps.test.api.BServer_Testser(transportFactory.createServerTransport())
	);
	
	this.bioFruitService = new byps.test.api.inherit.BStub_BioFruitService(this.transport);
	this.bioLemonService = new byps.test.api.inherit.BStub_BioLemonService(this.transport);
	this.fruitService = new byps.test.api.inherit.BStub_FruitService(this.transport);
	this.lemonService = new byps.test.api.inherit.BStub_LemonService(this.transport);
	this.plantService = new byps.test.api.inherit.BStub_PlantService(this.transport);
	this.remoteArrayTypes1dim = new byps.test.api.remote.BStub_RemoteArrayTypes1dim(this.transport);
	this.remoteArrayTypes23 = new byps.test.api.remote.BStub_RemoteArrayTypes23(this.transport);
	this.remoteArrayTypes4dim = new byps.test.api.remote.BStub_RemoteArrayTypes4dim(this.transport);
	this.remoteConstants = new byps.test.api.remote.BStub_RemoteConstants(this.transport);
	this.remoteEnums = new byps.test.api.remote.BStub_RemoteEnums(this.transport);
	this.remoteInlineInstance = new byps.test.api.remote.BStub_RemoteInlineInstance(this.transport);
	this.remoteListTypes = new byps.test.api.remote.BStub_RemoteListTypes(this.transport);
	this.remoteMapTypes = new byps.test.api.remote.BStub_RemoteMapTypes(this.transport);
	this.remotePrimitiveTypes = new byps.test.api.remote.BStub_RemotePrimitiveTypes(this.transport);
	this.remoteReferences = new byps.test.api.remote.BStub_RemoteReferences(this.transport);
	this.remoteServerCtrl = new byps.test.api.remote.BStub_RemoteServerCtrl(this.transport);
	this.remoteSetTypes = new byps.test.api.remote.BStub_RemoteSetTypes(this.transport);
	this.remoteStreams = new byps.test.api.remote.BStub_RemoteStreams(this.transport);
	this.remoteWithAuthentication = new byps.test.api.remote.BStub_RemoteWithAuthentication(this.transport);
	this.clientIF = new byps.test.api.srvr.BStub_ClientIF(this.transport);
	this.serverIF = new byps.test.api.srvr.BStub_ServerIF(this.transport);
	this.evolveIF = new byps.test.api.ver.BStub_EvolveIF(this.transport);
};
byps.test.api.BClient_Testser.prototype = new byps.BClient();


/**
 * ----------------------------------------------
 * API value classes
 * ----------------------------------------------
*/

/**
*/
byps.test.api.arr.ArrayTypes1dim = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, date1, primitiveTypes1) {
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
	this.date1 = date1 || null;
	this.primitiveTypes1 = primitiveTypes1 || null;
};


/**
*/
byps.test.api.arr.ArrayTypes4dim = function(boolean4, byte4, char4, short4, int4, long4, float4, double4, string4, primitiveTypes4) {
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
 * @see byps.test.api.remote.RemoteWithAuthentication
*/
byps.test.api.auth.SessionInfo = function(sessionID) {
	this._typeId = 65775978;
	this.sessionID = sessionID || "";
};


/**
*/
byps.test.api.cons.AllTypesZ = function(bool1, byte1, char1, short1, int1, long1, float1, double1, string1, hebrew1, byte2, int2, string2, hebrew2) {
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
byps.test.api.cons.HebrewZ = function(core) {
	this._typeId = 1518668429;
	this.core = core || "";
};


/**
*/
byps.test.api.enu.UsePlanets = function(planet, planet2, arrayOfPlanets, listOfPlanets, mapOfPlanets) {
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
byps.test.api.inherit.Class1 = function(int1, nextClass1) {
	this._typeId = 6001;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
};


/**
*/
byps.test.api.inherit.Class1Collections = function(list1, map1, set1) {
	this._typeId = 6004;
	this.list1 = list1 || null;
	this.map1 = map1 || null;
	this.set1 = set1 || null;
};


/**
*/
byps.test.api.inherit.Class2 = function(int1, nextClass1, int2) {
	this._typeId = 6002;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
	this.int2 = int2 || 0;
};


/**
*/
byps.test.api.inherit.Class3 = function(int1, nextClass1, int2, int3) {
	this._typeId = 6003;
	this.int1 = int1 || 0;
	this.nextClass1 = nextClass1 || null;
	this.int2 = int2 || 0;
	this.int3 = int3 || 0;
};


/**
*/
byps.test.api.inl.Actor = function(shape, position) {
	this._typeId = 171948703;
	this.shape = shape || null;
	this.position = position || null;
};


/**
 * @inline 
*/
byps.test.api.inl.Matrix2D = function(_11, _12, _13, _21, _22, _23, _31, _32, _33) {
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
byps.test.api.inl.Point2D = function(x, y) {
	// this._typeId = 1835035436;
	this.x = x || 0;
	this.y = y || 0;
};


/**
*/
byps.test.api.list.ListListTypes = function(int2, int3, int24) {
	this._typeId = 3002;
	this.int2 = int2 || null;
	this.int3 = int3 || null;
	this.int24 = int24 || null;
};


/**
*/
byps.test.api.list.ListTypes = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, date1, primitiveTypes1, byte2, int2, int4, obj1) {
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
	this.date1 = date1 || null;
	this.primitiveTypes1 = primitiveTypes1 || null;
	this.byte2 = byte2 || null;
	this.int2 = int2 || null;
	this.int4 = int4 || null;
	this.obj1 = obj1 || null;
};


/**
*/
byps.test.api.map.MapTypes = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, primitiveTypes1, byte2, int2, obj1, date1) {
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
	this.date1 = date1 || null;
};


/**
 * Example class with primitive types like boolean, int, String.
*/
byps.test.api.prim.PrimitiveTypes = function(boolVal, byteVal, charVal, shortVal, intVal, longVal, floatVal, doubleVal, stringVal, dateVal, objVal, objVal2, value) {
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
	this.dateVal = dateVal || null;
	this.objVal = objVal || null;
	this.objVal2 = objVal2 || null;
	this.value = value || false;
};


/**
 * Example class with private and protected members
*/
byps.test.api.priv.PrivateMembers = function(boolVal, byteVal, charVal, shortVal, intVal, longVal, floatVal, doubleVal, stringVal, primitiveTypes, arrBool, arrInt, arrString, arrPrimitiveTypes, listBool, listInt, listString, listPrimitiveTypes, mapIntListString, protInt, pprotInt) {
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
byps.test.api.refs.Node = function(next, me, mapOfNodes, listOfNodes) {
	this._typeId = 9001;
	this.next = next || null;
	this.me = me || null;
	this.mapOfNodes = mapOfNodes || null;
	this.listOfNodes = listOfNodes || null;
};


/**
*/
byps.test.api.set.SetTypes = function(boolean1, byte1, char1, short1, int1, long1, float1, double1, string1, primitiveTypes1, byte2, int2, obj1, date1) {
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
	this.date1 = date1 || null;
};


/**
*/
byps.test.api.srvr.ChatStructure = function(msg, sentAt, receivedAt) {
	this._typeId = 7007;
	this.msg = msg || "";
	this.sentAt = sentAt || 0;
	this.receivedAt = receivedAt || 0;
};


/**
*/
byps.test.api.strm.Stream1 = function(is1, contentType, arrStream, listStream, mapStream) {
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
byps.test.api.ver.Evolve = function(bool1, byte1, char1, short1, int1, long1, float1, double1, bools1, bytes1, chars1, shorts1, ints1, longs1, floats1, doubles1, str1, obj1, evo1, list1, set1, map1, bool2, byte2, char2, short2, int2, long2, float2, double2, bools2, bytes2, chars2, shorts2, ints2, longs2, floats2, doubles2, str2, obj2, evo2, list2, set2, map2, bool3, byte3, char3, short3, int3, long3, float3, double3, bools3, bytes3, chars3, shorts3, ints3, longs3, floats3, doubles3, str3, obj3, evo3, list3, set3, map3) {
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
byps.test.api.ver.Evolve2 = function(n1) {
	this._typeId = 573592593;
	this.n1 = n1 || 0;
};



/**
 * ----------------------------------------------
 * API constant types
 * ----------------------------------------------
*/

byps.test.api.cons.AllTypesC_Type = function() {
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
	this.ALL = new byps.test.api.cons.AllTypesZ(true, 1, 'A', 2, 3, "4.", 5.0, 6.0, "777", new byps.test.api.cons.HebrewZ("\u05d0"), "AQID", [-4,-5], ["a","b"], [new byps.test.api.cons.HebrewZ("\u05d0"),new byps.test.api.cons.HebrewZ("\u05d1")]);
	this.arrInt = [1,2,3];
	this.arrInt4 = [[[[1,2],[4,5]],[[11,12],[14,15]]],[[[21,22],[24,25]],[[211,212],[214,215]]]];
	this.arrStrings = ["s1","s2"];
	this.arrStrings4 = [[[["s1","s2"]]]];
	this.arrALL = [[new byps.test.api.cons.AllTypesZ(false, 0, '\u0000', 0, 0, "0.", 0.0, 0.0, "", null, null, null, null, null)],[new byps.test.api.cons.AllTypesZ(true, 1, 'A', 2, 3, "4.", 5.0, 6.0, "777", new byps.test.api.cons.HebrewZ("\u05d0"), "AQID", [-4,-5], ["a","b"], [new byps.test.api.cons.HebrewZ("\u05d0"),new byps.test.api.cons.HebrewZ("\u05d1")])]];
};

byps.test.api.cons.HebrewC_Type = function() {
	this.aleph = "\u05d0";
	this.beth = "\u05d1";
	this.ALEPH = new byps.test.api.cons.HebrewZ("\u05d0");
	this.BETH = new byps.test.api.cons.HebrewZ("\u05d1");
};

byps.test.api.enu.EnumPlanets = {
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
byps.test.api.cons.AllTypesC = new byps.test.api.cons.AllTypesC_Type();

/**
*/
byps.test.api.cons.HebrewC = new byps.test.api.cons.HebrewC_Type();


/**
 * ----------------------------------------------
 * Skeleton classes
 * ----------------------------------------------
*/

/**
 * This class provides a skeleton implementation of the interface ClientIF.
 * Use an object of this class as the prototype of your interface implementation.
 * Either provide an asynchronous or a synchronous function in your implementation.
 * The framework calls only the asynchronous function.
 */
byps.test.api.srvr.BSkeleton_ClientIF = function() {
	
	this._typeId = 955752991;
	
	this.transport = null; // is set in BServer.addRemote
	
	this.toJSON = function (key) {
		return { _typeId : 955752991, targetId : this.transport.targetId };
	};
	
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.incrementInt = function(a) /* returns int , throws BException, InterruptedException*/  {
	byps.throwUNSUPPORTED("");
};
// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_incrementInt = function(a, __byps__asyncResult){
	try {
		var __byps__ret = this.incrementInt(a);
		__byps__asyncResult(__byps__ret, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.getStreams = function(ctrl) /* returns java.util.List<java.io.InputStream> , throws BException, InterruptedException*/  {
	byps.throwUNSUPPORTED("");
};
// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_getStreams = function(ctrl, __byps__asyncResult){
	try {
		var __byps__ret = this.getStreams(ctrl);
		__byps__asyncResult(__byps__ret, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.putStreams = function(strm, ctrl) /* returns void , throws BException, InterruptedException*/  {
	byps.throwUNSUPPORTED("");
};
// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_putStreams = function(strm, ctrl, __byps__asyncResult){
	try {
		this.putStreams(strm, ctrl);
		__byps__asyncResult(null, null);
	} catch (e) {
		__byps__asyncResult(null, e);
	};
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.sendChat = function(cs) /* returns byps.test.api.srvr.ChatStructure , throws BException, InterruptedException*/  {
	byps.throwUNSUPPORTED("");
};
// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BSkeleton_ClientIF.prototype.async_sendChat = function(cs, __byps__asyncResult){
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
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
*/
byps.test.api.inherit.BStub_BioFruitService = function(transport) {
	
	this._typeId = 612235846;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioFruitService.prototype.certify = function(param, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1435417025, param : param };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioFruitService.prototype.grow = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 695716901 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioFruitService.prototype.squeeze = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1290167289 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
*/
byps.test.api.inherit.BStub_BioLemonService = function(transport) {
	
	this._typeId = 501819909;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioLemonService.prototype.certify = function(param, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1435417025, param : param };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioLemonService.prototype.grow = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 695716901 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioLemonService.prototype.squeeze = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1290167289 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioLemonService.prototype.pick = function(sess, fromTree, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1022088379, sess : sess, fromTree : fromTree };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_BioLemonService.prototype.useParing = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2108700976 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
*/
byps.test.api.inherit.BStub_FruitService = function(transport) {
	
	this._typeId = 937293552;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_FruitService.prototype.grow = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 695716901 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_FruitService.prototype.squeeze = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1290167289 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
*/
byps.test.api.inherit.BStub_LemonService = function(transport) {
	
	this._typeId = 826877615;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_LemonService.prototype.grow = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 695716901 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_LemonService.prototype.squeeze = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1290167289 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_LemonService.prototype.pick = function(sess, fromTree, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1022088379, sess : sess, fromTree : fromTree };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
*/
byps.test.api.inherit.BStub_PlantService = function(transport) {
	
	this._typeId = 1733272281;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.inherit.BStub_PlantService.prototype.grow = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 695716901 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * Interface with functions using 1-dimensional arrays.
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim = function(transport) {
	
	this._typeId = 1176140631;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setBool = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 201441072, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setByte = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 201431314, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setChar = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 201418436, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setShort = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1934214314, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setInt = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1530512055, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setLong = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 201143198, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setFloat = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1946101450, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setDouble = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 253910985, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setString = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 180061303, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setPrimitiveTypes = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1362276920, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setObject = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 48678821, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.setDate = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 201394796, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getBool = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2033416644 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getByte = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2033426402 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getChar = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2033439280 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getShort = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1373101854 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getInt = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1874061867 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getLong = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2033714518 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getFloat = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1384988990 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getDouble = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 39293909 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getString = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 394678379 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getPrimitiveTypes = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1992537556 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getObject = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 263295897 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes1dim.prototype.getDate = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2033462920 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes23 = function(transport) {
	
	this._typeId = 964138163;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysInt = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1828268517, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysString = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1175231899, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysClass = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 330036060, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysObject = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1306614381, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes23.prototype.sendArraysInline = function(arr2, arr3, arr4, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1467243283, arr2 : arr2, arr3 : arr3, arr4 : arr4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * Interface with functions using 4-dimensional arrays.
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim = function(transport) {
	
	this._typeId = 1176051258;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setBool = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 185807085, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setByte = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 185816843, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setChar = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 185829721, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setShort = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1480543961, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setInt = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1668568460, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setLong = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 186104959, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setFloat = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1468656825, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setDouble = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1770586860, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setString = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1336614572, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setPrimitiveTypes = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 456924651, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setObject = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1467997054, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.setDate = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 185853361, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getBool = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1874302495 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getByte = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1874292737 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getChar = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1874279859 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getShort = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2041656421 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getInt = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1325018648 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getLong = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1874004621 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getFloat = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2029769285 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getDouble = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1555969784 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getString = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1121997496 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getPrimitiveTypes = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 483228169 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getObject = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1253379978 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteArrayTypes4dim.prototype.getDate = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1874256219 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * Interface functions to verify constant definitions.
*/
byps.test.api.remote.BStub_RemoteConstants = function(transport) {
	
	this._typeId = 429088323;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteConstants.prototype.compare_HebrewC = function(ALEPH, BETH, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1711871378, ALEPH : ALEPH, BETH : BETH };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteConstants.prototype.compare_AllTypesC = function(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1609344203, bool1s : bool1s, bool2s : bool2s, char1s : char1s, stringNull : stringNull, char2s : char2s, short1s : short1s, int1s : int1s, long1s : long1s, float1s : float1s, double1s : double1s, string1s : string1s, ALL : ALL, arrInt : arrInt, arrInt4 : arrInt4, arrStrings : arrStrings, arrStrings4 : arrStrings4, arrAll : arrAll };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteEnums = function(transport) {
	
	this._typeId = 1222673152;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteEnums.prototype.getPlanet = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 6352043 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteEnums.prototype.setPlanet = function(planet, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 220969119, planet : planet };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance = function(transport) {
	
	this._typeId = 355071648;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setActor = function(act, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1162005320, act : act };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getActor = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 600892860 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DArray1dim = function(pointArray, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1355334613, pointArray : pointArray };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DArray1dim = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 188393247 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DArray4dim = function(pointArray, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1355245240, pointArray : pointArray };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DArray4dim = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 188482620 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DList = function(pointList, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 343422941, pointList : pointList };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DList = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1428313263 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DListList = function(pointListList, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 730520735, pointListList : pointListList };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DListList = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1650554387 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.setPoint2DMap = function(pointMap, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 127469879, pointMap : pointMap };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteInlineInstance.prototype.getPoint2DMap = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 646661333 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteListTypes = function(transport) {
	
	this._typeId = 1240892695;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getBoolean1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2058662161 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setBoolean1 = function(boolean1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2147241989, boolean1 : boolean1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getByte1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 608486403 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setByte1 = function(byte1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 47373943, byte1 : byte1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getChar1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 608885621 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setChar1 = function(char1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 47773161, char1 : char1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getShort1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2140896613 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setShort1 = function(short1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1939453607, short1 : short1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2098036488 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt1 = function(int1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 136821228, int1 : int1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getLong1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 617417999 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setLong1 = function(long1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 56305539, long1 : long1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getFloat1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1785569467 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setFloat1 = function(float1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1570952391, float1 : float1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getDouble1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2129490906 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setDouble1 = function(double1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 228671154, double1 : double1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getString1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1597237350 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setString1 = function(string1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 339567886, string1 : string1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getPrimitiveTypes1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1679973895 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setPrimitiveTypes1 = function(primitiveTypes1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 759940243, primitiveTypes1 : primitiveTypes1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getByte2 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 608486404 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setByte2 = function(byte2, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 47373944, byte2 : byte2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt2 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2098036489 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt2 = function(int2, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 136821227, int2 : int2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getObj1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2098203392 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setObj1 = function(obj1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 136654324, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setDate1 = function(obj1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 48506001, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getDate1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 609618461 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt3 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2098036490 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt3 = function(int3, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 136821226, int3 : int3 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.getInt4 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2098036491 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteListTypes.prototype.setInt4 = function(int4, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 136821225, int4 : int4 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteMapTypes = function(transport) {
	
	this._typeId = 1277224527;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getBoolean1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 885803255 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setBoolean1 = function(boolean1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 974383083, boolean1 : boolean1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getByte1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 124722647 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setByte1 = function(byte1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 685835107, byte1 : byte1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getChar1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 124323429 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setChar1 = function(char1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 685435889, char1 : char1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getShort1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 899426613 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setShort1 = function(short1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 684809537, short1 : short1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getInt1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 827458594 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setInt1 = function(int1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1407399122, int1 : int1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getLong1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 115791051 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setLong1 = function(long1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 676903511, long1 : long1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getFloat1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 530925397 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setFloat1 = function(float1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 316308321, float1 : float1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getDouble1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1890230400 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setDouble1 = function(double1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 467931660, double1 : double1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getString1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1836497856 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setString1 = function(string1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 100307380, string1 : string1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getPrimitiveTypes1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1745799327 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setPrimitiveTypes1 = function(primitiveTypes1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1629134317, primitiveTypes1 : primitiveTypes1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getByte2 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 124722646 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setByte2 = function(byte2, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 685835106, byte2 : byte2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getInt2 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 827458595 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setInt2 = function(int2, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1407399121, int2 : int2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getObj1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 827625498 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setObj1 = function(obj1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1407232218, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.getDate1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 123590589 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteMapTypes.prototype.setDate1 = function(obj1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 684703049, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes = function(transport) {
	
	this._typeId = 1391241180;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.voidFunctionVoid = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2033139391 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setBool = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 243951947, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setByte = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 243961705, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setChar = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 243974583, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setShort = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1011932613, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setInt = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1239049874, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setLong = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 244249821, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setFloat = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1023819749, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setDouble = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1727949326, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setString = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1293977038, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setPrimitiveTypes = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 225526541, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setObject = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1425359520, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.setDate = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 243998223, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getBool = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1816157633 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getByte = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1816147875 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getChar = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1816134997 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getShort = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 450820153 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getInt = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1582599686 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getLong = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1815859759 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getFloat = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 462707289 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getDouble = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1513332250 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getString = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1079359962 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getPrimitiveTypes = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 714626279 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getObject = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1210742444 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.getDate = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1816111357 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.sendAllTypes = function(b, c, s, i, l, f, d, str, pt, o, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 677876863, b : b, c : c, s : s, i : i, l : l, f : f, d : d, str : str, pt : pt, o : o };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.add = function(a, b, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 362528512, a : a, b : b };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.makeDate = function(year, month, day, hour, minute, second, millisecond, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1918934973, year : year, month : month, day : day, hour : hour, minute : minute, second : second, millisecond : millisecond };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.parseDate = function(date, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 578007072, date : date };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemotePrimitiveTypes.prototype.throwException = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1278149706 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteReferences = function(transport) {
	
	this._typeId = 1173792730;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteReferences.prototype.getNode = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1366991859 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteReferences.prototype.setNode = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 693117721, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteServerCtrl = function(transport) {
	
	this._typeId = 2037577312;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteServerCtrl.prototype.publishRemote = function(name, remote, fowardToOtherServers, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1543768912, name : name, remote : remote, fowardToOtherServers : fowardToOtherServers };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteServerCtrl.prototype.getPublishedRemote = function(name, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 648762723, name : name };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteServerCtrl.prototype.removePublishedRemote = function(name, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 135366859, name : name };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteSetTypes = function(transport) {
	
	this._typeId = 1781251319;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getBoolean1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2114990909 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setBoolean1 = function(boolean1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2091396559, boolean1 : boolean1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getByte1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 901695825 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setByte1 = function(byte1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1462808285, byte1 : byte1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getChar1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 901296607 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setChar1 = function(char1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1462409067, char1 : char1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getShort1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1711905425 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setShort1 = function(short1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1926522501, short1 : short1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getInt1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1772226268 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setInt1 = function(int1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 462631448, int1 : int1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getLong1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 892764229 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setLong1 = function(long1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1453876689, long1 : long1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getFloat1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2080406641 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setFloat1 = function(float1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1999943579, float1 : float1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getDouble1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1751651450 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setDouble1 = function(double1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 185153786, double1 : double1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getString1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1183412410 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setString1 = function(string1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 753392826, string1 : string1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getPrimitiveTypes1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 669274715 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setPrimitiveTypes1 = function(primitiveTypes1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 250758937, primitiveTypes1 : primitiveTypes1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getByte2 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 901695824 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setByte2 = function(byte2, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1462808284, byte2 : byte2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getInt2 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1772226269 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setInt2 = function(int2, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 462631447, int2 : int2 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getObj1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1772393172 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setObj1 = function(obj1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 462464544, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.setDate1 = function(obj1, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1461676227, obj1 : obj1 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteSetTypes.prototype.getDate1 = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 900563767 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.remote.BStub_RemoteStreams = function(transport) {
	
	this._typeId = 2123238175;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteStreams.prototype.getImage = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 61677379 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteStreams.prototype.setImage = function(istrm, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 622789839, istrm : istrm };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteStreams.prototype.getImages = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1911998634 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteStreams.prototype.setImages = function(istrms, doNotReadStreamAtKey, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2126615710, istrms : istrms, doNotReadStreamAtKey : doNotReadStreamAtKey };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteStreams.prototype.throwLastException = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2127402965 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.remote.BStub_RemoteStreams.prototype.getTextStream = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 818823403 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * This interface is an example for using the authentication mechanism.
 * @BSessionParamType byps.test.api.auth.SessionInfo
 * @BSessionParamType byps.test.api.auth.SessionInfo
*/
byps.test.api.remote.BStub_RemoteWithAuthentication = function(transport) {
	
	this._typeId = 1532028880;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
 * Set authentication flag in MySession.
 * @param useAuth
 * @throws RemoteException
*/
byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.setUseAuthentication = function(useAuth, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 946544530, useAuth : useAuth };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
 * Login.
 * Only user "Fritz" is allowed to login.
 * @param sess Session information, always null in this scenario.
 * @param userName
 * @param userPwd
 * @return Session object
 * @throws RemoteException
*/
byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.login = function(userName, userPwd, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 134687724, __byps__sess : 'sess', userName : userName, userPwd : userPwd };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
 * Do something.
 * @param sess Session information. Must not be null, if user was logged in.
 * @param value
 * @return value+1
 * @throws RemoteException
*/
byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.doit = function(value, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1251509013, __byps__sess : 'sess', value : value };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
 * Logout
 * @param sess
 * @throws RemoteException
*/
byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.expire = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 72176172, __byps__sess : 'sess' };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
 * Set the number of login calls nessesary to login the user.
 * This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
 * @param count
 * @throws RemoteException
*/
byps.test.api.remote.BStub_RemoteWithAuthentication.prototype.setReloginCount = function(count, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 802968058, count : count };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
 * @BClientRemote 
 * @BClientRemote 
*/
byps.test.api.srvr.BStub_ClientIF = function(transport) {
	
	this._typeId = 955752991;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ClientIF.prototype.incrementInt = function(a, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1685952420, a : a };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ClientIF.prototype.getStreams = function(ctrl, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1654980071, ctrl : ctrl };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ClientIF.prototype.putStreams = function(strm, ctrl, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2016865344, strm : strm, ctrl : ctrl };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ClientIF.prototype.sendChat = function(cs, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 41050276, cs : cs };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.srvr.BStub_ServerIF = function(transport) {
	
	this._typeId = 1426448279;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.callClientIncrementInt = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 389860173, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.setPartner = function(client, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1332497686, client : client };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.getPartner = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1025664374 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.getStreamsFromClient = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1679867754 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.putStreamsOnClient = function(streams, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1934886286, streams : streams };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.registerWithClientMap = function(id, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1533268444, id : id };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.getClient = function(id, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 190669475, id : id };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.getClientIds = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 2007476251 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.srvr.BStub_ServerIF.prototype.callClientParallel = function(v, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 772308436, v : v };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

/**
*/
byps.test.api.ver.BStub_EvolveIF = function(transport) {
	
	this._typeId = 564008001;
	
	this.transport = transport;
	
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.ver.BStub_EvolveIF.prototype.setEvolve = function(obj, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1064683365, obj : obj };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.ver.BStub_EvolveIF.prototype.getEvolve = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1279300441 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.ver.BStub_EvolveIF.prototype.setClient = function(partner, __byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 998004147, partner : partner };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.ver.BStub_EvolveIF.prototype.getClient = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 1212621223 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};

// checkpoint byps.gen.js.PrintContext:133
/**
*/
byps.test.api.ver.BStub_EvolveIF.prototype.sendEvolveToClient = function(__byps__asyncResult) {
	// checkpoint byps.gen.js.GenRemoteStub:40
	var req =  { _typeId : 714115141 };
	var ret = this.transport.sendMethod(req, __byps__asyncResult);
	return ret;
};


/**
 * ----------------------------------------------
 * Server class
 * ----------------------------------------------
*/

byps.test.api.BServer_Testser = function(transport) { 

	this.transport = transport;
	this._remotes = {};
	
	this._methodMap = {
		
		// Remote Interface BioFruitService			
			// Method certify
			1435417025 : [ // _typeId of request class
				612235846, // _typeId of remote interface
				432867947, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_certify(methodObj.param, methodResult);
				}
			],
		
		
		// Remote Interface BioLemonService			
			// Method useParing
			2108700976 : [ // _typeId of request class
				501819909, // _typeId of remote interface
				432867943, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_useParing(methodResult);
				}
			],
		
		
		// Remote Interface FruitService			
			// Method squeeze
			1290167289 : [ // _typeId of request class
				937293552, // _typeId of remote interface
				534004421, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_squeeze(methodResult);
				}
			],
		
		
		// Remote Interface LemonService			
			// Method pick
			1022088379 : [ // _typeId of request class
				826877615, // _typeId of remote interface
				534004421, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_pick(methodObj.sess, methodObj.fromTree, methodResult);
				}
			],
		
		
		// Remote Interface PlantService			
			// Method grow
			695716901 : [ // _typeId of request class
				1733272281, // _typeId of remote interface
				534004421, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_grow(methodResult);
				}
			],
		
		
		// Remote Interface RemoteArrayTypes1dim			
			// Method setBool
			201441072 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			201431314 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			201418436 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			1934214314 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			1530512055 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			201143198 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			1946101450 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			253910985 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			180061303 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			1362276920 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			48678821 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method setDate
			201394796 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDate(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			2033416644 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				1698849803, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			2033426402 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				1484626910, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			2033439280 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				1548641599, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			1373101854 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				925799231, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1874061867 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				498939805, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			2033714518 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				200721390, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			1384988990 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				1167917980, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			39293909 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				1738389572, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			394678379 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				2063745441, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			1992537556 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				1814499786, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			263295897 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				15818284, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
			
			// Method getDate
			2033462920 : [ // _typeId of request class
				1176140631, // _typeId of remote interface
				1980364794, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDate(methodResult);
				}
			],
		
		
		// Remote Interface RemoteArrayTypes23			
			// Method sendArraysInt
			1828268517 : [ // _typeId of request class
				964138163, // _typeId of remote interface
				498939805, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysInt(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysString
			1175231899 : [ // _typeId of request class
				964138163, // _typeId of remote interface
				2063745441, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysString(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysClass
			330036060 : [ // _typeId of request class
				964138163, // _typeId of remote interface
				1814499786, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysClass(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysObject
			1306614381 : [ // _typeId of request class
				964138163, // _typeId of remote interface
				15818284, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysObject(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
			
			// Method sendArraysInline
			1467243283 : [ // _typeId of request class
				964138163, // _typeId of remote interface
				748770738, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendArraysInline(methodObj.arr2, methodObj.arr3, methodObj.arr4, methodResult);
				}
			],
		
		
		// Remote Interface RemoteArrayTypes4dim			
			// Method setBool
			185807085 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			185816843 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			185829721 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			1480543961 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			1668568460 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			186104959 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			1468656825 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			1770586860 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			1336614572 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			456924651 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			1467997054 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method setDate
			185853361 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDate(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			1874302495 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				1852992857, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			1874292737 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				1521577218, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			1874279859 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				580900026, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			2041656421 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				2130431383, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1325018648 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				245460547, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			1874004621 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				167272824, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			2029769285 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				2043070523, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			1555969784 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				1650981375, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			1121997496 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				1537615291, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			483228169 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				1168951451, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			1253379978 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				996163680, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
			
			// Method getDate
			1874256219 : [ // _typeId of request class
				1176051258, // _typeId of remote interface
				905019472, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDate(methodResult);
				}
			],
		
		
		// Remote Interface RemoteConstants			
			// Method compare_HebrewC
			1711871378 : [ // _typeId of request class
				429088323, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_compare_HebrewC(methodObj.ALEPH, methodObj.BETH, methodResult);
				}
			],
			
			// Method compare_AllTypesC
			1609344203 : [ // _typeId of request class
				429088323, // _typeId of remote interface
				432867947, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_compare_AllTypesC(methodObj.bool1s, methodObj.bool2s, methodObj.char1s, methodObj.stringNull, methodObj.char2s, methodObj.short1s, methodObj.int1s, methodObj.long1s, methodObj.float1s, methodObj.double1s, methodObj.string1s, methodObj.ALL, methodObj.arrInt, methodObj.arrInt4, methodObj.arrStrings, methodObj.arrStrings4, methodObj.arrAll, methodResult);
				}
			],
		
		
		// Remote Interface RemoteEnums			
			// Method getPlanet
			6352043 : [ // _typeId of request class
				1222673152, // _typeId of remote interface
				1920161159, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPlanet(methodResult);
				}
			],
			
			// Method setPlanet
			220969119 : [ // _typeId of request class
				1222673152, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPlanet(methodObj.planet, methodResult);
				}
			],
		
		
		// Remote Interface RemoteInlineInstance			
			// Method setActor
			1162005320 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setActor(methodObj.act, methodResult);
				}
			],
			
			// Method getActor
			600892860 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				871356108, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getActor(methodResult);
				}
			],
			
			// Method setPoint2DArray1dim
			1355334613 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DArray1dim(methodObj.pointArray, methodResult);
				}
			],
			
			// Method getPoint2DArray1dim
			188393247 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				748770738, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DArray1dim(methodResult);
				}
			],
			
			// Method setPoint2DArray4dim
			1355245240 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DArray4dim(methodObj.pointArray, methodResult);
				}
			],
			
			// Method getPoint2DArray4dim
			188482620 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				996206823, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DArray4dim(methodResult);
				}
			],
			
			// Method setPoint2DList
			343422941 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DList(methodObj.pointList, methodResult);
				}
			],
			
			// Method getPoint2DList
			1428313263 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				937508540, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DList(methodResult);
				}
			],
			
			// Method setPoint2DListList
			730520735 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DListList(methodObj.pointListList, methodResult);
				}
			],
			
			// Method getPoint2DListList
			1650554387 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				114088296, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DListList(methodResult);
				}
			],
			
			// Method setPoint2DMap
			127469879 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPoint2DMap(methodObj.pointMap, methodResult);
				}
			],
			
			// Method getPoint2DMap
			646661333 : [ // _typeId of request class
				355071648, // _typeId of remote interface
				1693860029, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPoint2DMap(methodResult);
				}
			],
		
		
		// Remote Interface RemoteListTypes			
			// Method getBoolean1
			2058662161 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1330811042, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			2147241989 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			608486403 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				698727944, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			47373943 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			608885621 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				475882038, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			47773161 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			2140896613 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1082818537, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1939453607 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			2098036488 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1763202727, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			136821228 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			617417999 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				70523627, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			56305539 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			1785569467 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				368905437, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			1570952391 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			2129490906 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				343940505, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			228671154 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			1597237350 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				253151806, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			339567886 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			1679973895 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1073221568, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			759940243 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			608486404 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1068483136, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			47373944 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			2098036489 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1912328929, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			136821227 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			2098203392 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004419, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			136654324 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
			
			// Method setDate1
			48506001 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDate1(methodObj.obj1, methodResult);
				}
			],
			
			// Method getDate1
			609618461 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1210513700, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDate1(methodResult);
				}
			],
			
			// Method getInt3
			2098036490 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				408452669, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt3(methodResult);
				}
			],
			
			// Method setInt3
			136821226 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt3(methodObj.int3, methodResult);
				}
			],
			
			// Method getInt4
			2098036491 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				1231328865, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt4(methodResult);
				}
			],
			
			// Method setInt4
			136821225 : [ // _typeId of request class
				1240892695, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt4(methodObj.int4, methodResult);
				}
			],
		
		
		// Remote Interface RemoteMapTypes			
			// Method getBoolean1
			885803255 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				629604454, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			974383083 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			124722647 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				1958357790, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			685835107 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			124323429 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				323111619, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			685435889 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			899426613 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				856233055, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			684809537 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			827458594 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				881037921, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			1407399122 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			115791051 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				1391760319, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			676903511 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			530925397 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				1800858646, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			316308321 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1890230400 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				149769063, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			467931660 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			1836497856 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				1899847531, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			100307380 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			1745799327 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				50516327, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			1629134317 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			124722646 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				2052610089, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			685835106 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			827458595 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				1293200061, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			1407399121 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			827625498 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				822552572, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			1407232218 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
			
			// Method getDate1
			123590589 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				1725564610, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDate1(methodResult);
				}
			],
			
			// Method setDate1
			684703049 : [ // _typeId of request class
				1277224527, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDate1(methodObj.obj1, methodResult);
				}
			],
		
		
		// Remote Interface RemotePrimitiveTypes			
			// Method voidFunctionVoid
			2033139391 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_voidFunctionVoid(methodResult);
				}
			],
			
			// Method setBool
			243951947 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBool(methodObj.v, methodResult);
				}
			],
			
			// Method setByte
			243961705 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte(methodObj.v, methodResult);
				}
			],
			
			// Method setChar
			243974583 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar(methodObj.v, methodResult);
				}
			],
			
			// Method setShort
			1011932613 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort(methodObj.v, methodResult);
				}
			],
			
			// Method setInt
			1239049874 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt(methodObj.v, methodResult);
				}
			],
			
			// Method setLong
			244249821 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong(methodObj.v, methodResult);
				}
			],
			
			// Method setFloat
			1023819749 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat(methodObj.v, methodResult);
				}
			],
			
			// Method setDouble
			1727949326 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble(methodObj.v, methodResult);
				}
			],
			
			// Method setString
			1293977038 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString(methodObj.v, methodResult);
				}
			],
			
			// Method setPrimitiveTypes
			225526541 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes(methodObj.v, methodResult);
				}
			],
			
			// Method setObject
			1425359520 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObject(methodObj.v, methodResult);
				}
			],
			
			// Method setDate
			243998223 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDate(methodObj.v, methodResult);
				}
			],
			
			// Method getBool
			1816157633 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867947, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBool(methodResult);
				}
			],
			
			// Method getByte
			1816147875 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867946, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte(methodResult);
				}
			],
			
			// Method getChar
			1816134997 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867944, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar(methodResult);
				}
			],
			
			// Method getShort
			450820153 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867945, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort(methodResult);
				}
			],
			
			// Method getInt
			1582599686 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867943, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt(methodResult);
				}
			],
			
			// Method getLong
			1815859759 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867942, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong(methodResult);
				}
			],
			
			// Method getFloat
			462707289 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867941, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat(methodResult);
				}
			],
			
			// Method getDouble
			1513332250 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867940, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble(methodResult);
				}
			],
			
			// Method getString
			1079359962 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004421, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString(methodResult);
				}
			],
			
			// Method getPrimitiveTypes
			714626279 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				2077138821, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes(methodResult);
				}
			],
			
			// Method getObject
			1210742444 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004389, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObject(methodResult);
				}
			],
			
			// Method getDate
			1816111357 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004414, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDate(methodResult);
				}
			],
			
			// Method sendAllTypes
			677876863 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendAllTypes(methodObj.b, methodObj.c, methodObj.s, methodObj.i, methodObj.l, methodObj.f, methodObj.d, methodObj.str, methodObj.pt, methodObj.o, methodResult);
				}
			],
			
			// Method add
			362528512 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				432867943, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_add(methodObj.a, methodObj.b, methodResult);
				}
			],
			
			// Method makeDate
			1918934973 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004414, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_makeDate(methodObj.year, methodObj.month, methodObj.day, methodObj.hour, methodObj.minute, methodObj.second, methodObj.millisecond, methodResult);
				}
			],
			
			// Method parseDate
			578007072 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				498939805, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_parseDate(methodObj.date, methodResult);
				}
			],
			
			// Method throwException
			1278149706 : [ // _typeId of request class
				1391241180, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwException(methodResult);
				}
			],
		
		
		// Remote Interface RemoteReferences			
			// Method getNode
			1366991859 : [ // _typeId of request class
				1173792730, // _typeId of remote interface
				2076900492, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getNode(methodResult);
				}
			],
			
			// Method setNode
			693117721 : [ // _typeId of request class
				1173792730, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setNode(methodObj.v, methodResult);
				}
			],
		
		
		// Remote Interface RemoteServerCtrl			
			// Method publishRemote
			1543768912 : [ // _typeId of request class
				2037577312, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_publishRemote(methodObj.name, methodObj.remote, methodObj.fowardToOtherServers, methodResult);
				}
			],
			
			// Method getPublishedRemote
			648762723 : [ // _typeId of request class
				2037577312, // _typeId of remote interface
				534004415, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPublishedRemote(methodObj.name, methodResult);
				}
			],
			
			// Method removePublishedRemote
			135366859 : [ // _typeId of request class
				2037577312, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_removePublishedRemote(methodObj.name, methodResult);
				}
			],
		
		
		// Remote Interface RemoteSetTypes			
			// Method getBoolean1
			2114990909 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				809340660, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getBoolean1(methodResult);
				}
			],
			
			// Method setBoolean1
			2091396559 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setBoolean1(methodObj.boolean1, methodResult);
				}
			],
			
			// Method getByte1
			901695825 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				1620912700, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte1(methodResult);
				}
			],
			
			// Method setByte1
			1462808285 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte1(methodObj.byte1, methodResult);
				}
			],
			
			// Method getChar1
			901296607 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				968248604, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getChar1(methodResult);
				}
			],
			
			// Method setChar1
			1462409067 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setChar1(methodObj.char1, methodResult);
				}
			],
			
			// Method getShort1
			1711905425 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				1664501789, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getShort1(methodResult);
				}
			],
			
			// Method setShort1
			1926522501 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setShort1(methodObj.short1, methodResult);
				}
			],
			
			// Method getInt1
			1772226268 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				1955210948, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt1(methodResult);
				}
			],
			
			// Method setInt1
			462631448 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt1(methodObj.int1, methodResult);
				}
			],
			
			// Method getLong1
			892764229 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				1111888832, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getLong1(methodResult);
				}
			],
			
			// Method setLong1
			1453876689 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setLong1(methodObj.long1, methodResult);
				}
			],
			
			// Method getFloat1
			2080406641 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				515346332, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getFloat1(methodResult);
				}
			],
			
			// Method setFloat1
			1999943579 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setFloat1(methodObj.float1, methodResult);
				}
			],
			
			// Method getDouble1
			1751651450 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				2041057155, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDouble1(methodResult);
				}
			],
			
			// Method setDouble1
			185153786 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDouble1(methodObj.double1, methodResult);
				}
			],
			
			// Method getString1
			1183412410 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				2051074845, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getString1(methodResult);
				}
			],
			
			// Method setString1
			753392826 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setString1(methodObj.string1, methodResult);
				}
			],
			
			// Method getPrimitiveTypes1
			669274715 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				2098743607, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPrimitiveTypes1(methodResult);
				}
			],
			
			// Method setPrimitiveTypes1
			250758937 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPrimitiveTypes1(methodObj.primitiveTypes1, methodResult);
				}
			],
			
			// Method getByte2
			901695824 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				1566928477, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getByte2(methodResult);
				}
			],
			
			// Method setByte2
			1462808284 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setByte2(methodObj.byte2, methodResult);
				}
			],
			
			// Method getInt2
			1772226269 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				2127200796, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getInt2(methodResult);
				}
			],
			
			// Method setInt2
			462631447 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setInt2(methodObj.int2, methodResult);
				}
			],
			
			// Method getObj1
			1772393172 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004417, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getObj1(methodResult);
				}
			],
			
			// Method setObj1
			462464544 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setObj1(methodObj.obj1, methodResult);
				}
			],
			
			// Method setDate1
			1461676227 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setDate1(methodObj.obj1, methodResult);
				}
			],
			
			// Method getDate1
			900563767 : [ // _typeId of request class
				1781251319, // _typeId of remote interface
				428832038, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getDate1(methodResult);
				}
			],
		
		
		// Remote Interface RemoteStreams			
			// Method getImage
			61677379 : [ // _typeId of request class
				2123238175, // _typeId of remote interface
				534004416, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getImage(methodResult);
				}
			],
			
			// Method setImage
			622789839 : [ // _typeId of request class
				2123238175, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setImage(methodObj.istrm, methodResult);
				}
			],
			
			// Method getImages
			1911998634 : [ // _typeId of request class
				2123238175, // _typeId of remote interface
				255681041, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getImages(methodResult);
				}
			],
			
			// Method setImages
			2126615710 : [ // _typeId of request class
				2123238175, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setImages(methodObj.istrms, methodObj.doNotReadStreamAtKey, methodResult);
				}
			],
			
			// Method throwLastException
			2127402965 : [ // _typeId of request class
				2123238175, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_throwLastException(methodResult);
				}
			],
			
			// Method getTextStream
			818823403 : [ // _typeId of request class
				2123238175, // _typeId of remote interface
				534004416, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getTextStream(methodResult);
				}
			],
		
		
		// Remote Interface RemoteWithAuthentication			
			// Method setUseAuthentication
			946544530 : [ // _typeId of request class
				1532028880, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setUseAuthentication(methodObj.useAuth, methodResult);
				}
			],
			
			// Method login
			134687724 : [ // _typeId of request class
				1532028880, // _typeId of remote interface
				1872312576, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_login(methodObj.sess, methodObj.userName, methodObj.userPwd, methodResult);
				}
			],
			
			// Method doit
			1251509013 : [ // _typeId of request class
				1532028880, // _typeId of remote interface
				432867943, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_doit(methodObj.sess, methodObj.value, methodResult);
				}
			],
			
			// Method expire
			72176172 : [ // _typeId of request class
				1532028880, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_expire(methodObj.sess, methodResult);
				}
			],
			
			// Method setReloginCount
			802968058 : [ // _typeId of request class
				1532028880, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setReloginCount(methodObj.count, methodResult);
				}
			],
		
		
		// Remote Interface ClientIF			
			// Method incrementInt
			1685952420 : [ // _typeId of request class
				955752991, // _typeId of remote interface
				432867943, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_incrementInt(methodObj.a, methodResult);
				}
			],
			
			// Method getStreams
			1654980071 : [ // _typeId of request class
				955752991, // _typeId of remote interface
				911793767, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getStreams(methodObj.ctrl, methodResult);
				}
			],
			
			// Method putStreams
			2016865344 : [ // _typeId of request class
				955752991, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_putStreams(methodObj.strm, methodObj.ctrl, methodResult);
				}
			],
			
			// Method sendChat
			41050276 : [ // _typeId of request class
				955752991, // _typeId of remote interface
				2076960068, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendChat(methodObj.cs, methodResult);
				}
			],
		
		
		// Remote Interface ServerIF			
			// Method callClientIncrementInt
			389860173 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				432867943, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_callClientIncrementInt(methodObj.v, methodResult);
				}
			],
			
			// Method setPartner
			1332497686 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setPartner(methodObj.client, methodResult);
				}
			],
			
			// Method getPartner
			1025664374 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				695494982, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getPartner(methodResult);
				}
			],
			
			// Method getStreamsFromClient
			1679867754 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				911793767, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getStreamsFromClient(methodResult);
				}
			],
			
			// Method putStreamsOnClient
			1934886286 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_putStreamsOnClient(methodObj.streams, methodResult);
				}
			],
			
			// Method registerWithClientMap
			1533268444 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_registerWithClientMap(methodObj.id, methodResult);
				}
			],
			
			// Method getClient
			190669475 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				695494982, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClient(methodObj.id, methodResult);
				}
			],
			
			// Method getClientIds
			2007476251 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				1955210948, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClientIds(methodResult);
				}
			],
			
			// Method callClientParallel
			772308436 : [ // _typeId of request class
				1426448279, // _typeId of remote interface
				432867943, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_callClientParallel(methodObj.v, methodResult);
				}
			],
		
		
		// Remote Interface EvolveIF			
			// Method setEvolve
			1064683365 : [ // _typeId of request class
				564008001, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setEvolve(methodObj.obj, methodResult);
				}
			],
			
			// Method getEvolve
			1279300441 : [ // _typeId of request class
				564008001, // _typeId of remote interface
				1722268526, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getEvolve(methodResult);
				}
			],
			
			// Method setClient
			998004147 : [ // _typeId of request class
				564008001, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_setClient(methodObj.partner, methodResult);
				}
			],
			
			// Method getClient
			1212621223 : [ // _typeId of request class
				564008001, // _typeId of remote interface
				1405156912, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_getClient(methodResult);
				}
			],
			
			// Method sendEvolveToClient
			714115141 : [ // _typeId of request class
				564008001, // _typeId of remote interface
				534004412, // _typeId of result class
				function(remote, methodObj, methodResult) {
					remote.async_sendEvolveToClient(methodResult);
				}
			],
		
	};
};
byps.test.api.BServer_Testser.prototype = new byps.BServer();


/**
 * ----------------------------------------------
 * Registry
 * ----------------------------------------------
*/

byps.test.api.BRegistry_Testser = function() { 
	
	this._serializerMap = {
		
		// boolean[]
		2058423690 : new byps.BSerializerArray(
			1, // Element type: boolean
			1
		),
		
		// boolean[][][][]
		945713488 : new byps.BSerializerArray(
			1, // Element type: boolean
			4
		),
		
		// byps.test.api.BResult_1
		432867947 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1 // boolean
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_10
		534004421 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1000
		2077138821 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1000 // byps.test.api.prim.PrimitiveTypes
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_100361105
		498939805 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":100361105 // int[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":100361105 // int[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1050216688
		70523627 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1050216688 // java.util.List<java.lang.Long>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1050216688 // java.util.List<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1059148284
		698727944 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1059148284 // java.util.List<java.lang.Byte>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1059148284 // java.util.List<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1097129250
		200721390 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1097129250 // long[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1097129250 // long[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1097919350
		428832038 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1097919350 // java.util.Set<java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1097919350 // java.util.Set<java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1174971318
		1068483136 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1174971318 // java.util.List<byte[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1174971318 // java.util.List<byte[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_12
		534004419 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":12 // java.util.List<java.lang.Object>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":12 // java.util.List<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1201775504
		1521577218 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1201775504 // byte[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1201775504 // byte[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1218831438
		911793767 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1218831438 // java.util.List<java.io.InputStream>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1218831438 // java.util.List<java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_124584219
		996163680 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":124584219 // java.lang.Object[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":124584219 // java.lang.Object[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1279823631
		629604454 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1320560671
		2041057155 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1320560671 // java.util.Set<java.lang.Double>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1320560671 // java.util.Set<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1347703734
		881037921 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1358523233
		1693860029 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1358523233 // java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1358523233 // java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1359468275
		1738389572 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1359468275 // double[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1359468275 // double[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1361632968
		1548641599 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1361632968 // char[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1361632968 // char[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1365696060
		809340660 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1366799209
		1725564610 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1366799209 // java.util.Map<java.lang.String,java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1366799209 // java.util.Map<java.lang.String,java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1374008726
		1484626910 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1374008726 // byte[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1374008726 // byte[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1375035164
		1920161159 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1375035164 // byps.test.api.enu.EnumPlanets
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1391985860
		1722268526 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1391985860 // byps.test.api.ver.Evolve
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_14
		534004417 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":14 // java.util.Set<java.lang.Object>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":14 // java.util.Set<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1406124761
		2127200796 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1406124761 // java.util.Set<int[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1406124761 // java.util.Set<int[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1406664368
		1980364794 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1406664368 // java.util.Date[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1406664368 // java.util.Date[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1457164460
		1111888832 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1457164460 // java.util.Set<java.lang.Long>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1457164460 // java.util.Set<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1487265161
		149769063 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1488550492
		822552572 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1493282670
		1955210948 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1493282670 // java.util.Set<java.lang.Integer>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1493282670 // java.util.Set<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_15
		534004416 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":15 // java.io.InputStream
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1504867122
		1210513700 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1504867122 // java.util.List<java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1504867122 // java.util.List<java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1516687588
		2043070523 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1516687588 // float[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1516687588 // float[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1555345627
		343940505 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1555345627 // java.util.List<java.lang.Double>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1555345627 // java.util.List<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1596367810
		1073221568 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1596367810 // java.util.List<byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1596367810 // java.util.List<byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_16
		534004415 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":16 // byps.BRemote
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1617670280
		1330811042 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1617670280 // java.util.List<java.lang.Boolean>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1617670280 // java.util.List<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1628501332
		368905437 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1628501332 // java.util.List<java.lang.Float>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1628501332 // java.util.List<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1633500852
		1231328865 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1633750383
		1293200061 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1661807911
		475882038 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1661807911 // java.util.List<java.lang.Character>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1661807911 // java.util.List<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_17
		534004414 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":17 // java.util.Date
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":17 // java.util.Date
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1710660846
		1899847531 : new byps.BSerializer(
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
		
		// byps.test.api.BResult_171948703
		871356108 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":171948703 // byps.test.api.inl.Actor
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1746702954
		408452669 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1752158699
		1912328929 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1752158699 // java.util.List<int[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1752158699 // java.util.List<int[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1799280818
		2052610089 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_181681714
		1763202727 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":181681714 // java.util.List<java.lang.Integer>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":181681714 // java.util.List<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1823330785
		114088296 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1823330785 // java.util.List<java.util.List<byps.test.api.inl.Point2D>>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1823330785 // java.util.List<java.util.List<byps.test.api.inl.Point2D>>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1831201218
		50516327 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1831201218 // java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1831201218 // java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_183594037
		15818284 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":183594037 // java.lang.Object[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":183594037 // java.lang.Object[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_184101377
		748770738 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":184101377 // byps.test.api.inl.Point2D[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":184101377 // byps.test.api.inl.Point2D[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1859644668
		2130431383 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1859644668 // short[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1859644668 // short[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1888107655
		2063745441 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1888107655 // java.lang.String[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1888107655 // java.lang.String[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1888799711
		2051074845 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1888799711 // java.util.Set<java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1888799711 // java.util.Set<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1898022288
		515346332 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1898022288 // java.util.Set<java.lang.Float>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1898022288 // java.util.Set<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_19
		534004412 : new byps.BSerializer(
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
		
		// byps.test.api.BResult_1972793385
		1958357790 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1973996106
		1391760319 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_1997002548
		1082818537 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":1997002548 // java.util.List<java.lang.Short>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":1997002548 // java.util.List<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2
		432867946 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2 // byte
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2028443792
		1664501789 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2028443792 // java.util.Set<java.lang.Short>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2028443792 // java.util.Set<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2052431866
		1566928477 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2052431866 // java.util.Set<byte[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2052431866 // java.util.Set<byte[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2053507648
		1814499786 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2053507648 // byps.test.api.prim.PrimitiveTypes[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2053507648 // byps.test.api.prim.PrimitiveTypes[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2058423690
		1698849803 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2058423690 // boolean[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2058423690 // boolean[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2064980445
		937508540 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2064980445 // java.util.List<byps.test.api.inl.Point2D>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2064980445 // java.util.List<byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2067161310
		925799231 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2067161310 // short[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2067161310 // short[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2087445849
		1650981375 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2087445849 // double[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2087445849 // double[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_21
		534004389 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":21 // java.lang.Object
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_2123584667
		253151806 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":2123584667 // java.util.List<java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":2123584667 // java.util.List<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_3
		432867945 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":3 // short
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_31512998
		1620912700 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_39910537
		245460547 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":39910537 // int[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":39910537 // int[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_4
		432867944 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":4 // char
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_476459792
		255681041 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":476459792 // java.util.TreeMap<java.lang.Integer,java.io.InputStream>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":476459792 // java.util.TreeMap<java.lang.Integer,java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_5
		432867943 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_51898890
		905019472 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":51898890 // java.util.Date[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":51898890 // java.util.Date[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_564008001
		1405156912 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":564008001 // byps.test.api.ver.EvolveIF
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_588723219
		1537615291 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":588723219 // java.lang.String[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":588723219 // java.lang.String[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_6
		432867942 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":6 // long
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_601099730
		856233055 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_65775978
		1872312576 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":65775978 // byps.test.api.auth.SessionInfo
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_673917574
		2098743607 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":673917574 // java.util.Set<byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":673917574 // java.util.Set<byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_7
		432867941 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":7 // float
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_7007
		2076960068 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":7007 // byps.test.api.srvr.ChatStructure
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_758319514
		1168951451 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_766441794
		1167917980 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":766441794 // float[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":766441794 // float[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_769021986
		580900026 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":769021986 // char[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":769021986 // char[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_8
		432867940 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":8 // double
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_846419204
		167272824 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":846419204 // long[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":846419204 // long[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_8789515
		323111619 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_9001
		2076900492 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":9001 // byps.test.api.refs.Node
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_936607009
		968248604 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_94341197
		1800858646 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_945713488
		1852992857 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":945713488 // boolean[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":945713488 // boolean[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_949340697
		996206823 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":949340697 // byps.test.api.inl.Point2D[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"result":949340697 // byps.test.api.inl.Point2D[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.BResult_955752991
		695494982 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"result":955752991 // byps.test.api.srvr.ClientIF
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.arr.ArrayTypes1dim
		2001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"date1":1406664368, // java.util.Date[]
				// names of persistent elements
				"primitiveTypes1":2053507648 // byps.test.api.prim.PrimitiveTypes[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
				"date1":1406664368, // java.util.Date[]
				// names of inline elements
				"primitiveTypes1":2053507648 // byps.test.api.prim.PrimitiveTypes[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.arr.ArrayTypes4dim
		2004 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"primitiveTypes4":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
				"primitiveTypes4":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.auth.SessionInfo
		65775978 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sessionID":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.cons.AllTypesC
		930294276 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"ALL":142458, // byps.test.api.cons.AllTypesZ
				// names of persistent elements
				"arrInt":100361105, // int[]
				// names of persistent elements
				"arrInt4":39910537, // int[][][][]
				// names of persistent elements
				"arrStrings":1888107655, // java.lang.String[]
				// names of persistent elements
				"arrStrings4":588723219, // java.lang.String[][][][]
				// names of persistent elements
				"arrALL":81775365 // byps.test.api.cons.AllTypesZ[][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
				"arrALL":81775365 // byps.test.api.cons.AllTypesZ[][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.cons.AllTypesZ
		142458 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"hebrew1":1518668429, // byps.test.api.cons.HebrewZ
				// names of persistent elements
				"byte2":1374008726, // byte[]
				// names of persistent elements
				"int2":100361105, // int[]
				// names of persistent elements
				"string2":1888107655, // java.lang.String[]
				// names of persistent elements
				"hebrew2":92445340 // byps.test.api.cons.HebrewZ[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":1374008726, // byte[]
				// names of inline elements
				"int2":100361105, // int[]
				// names of inline elements
				"string2":1888107655, // java.lang.String[]
				// names of inline elements
				"hebrew2":92445340 // byps.test.api.cons.HebrewZ[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.cons.AllTypesZ[][]
		81775365 : new byps.BSerializerArray(
			142458, // Element type: byps.test.api.cons.AllTypesZ
			2
		),
		
		// byps.test.api.cons.HebrewC
		691741677 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"aleph":10, // java.lang.String
				// names of persistent elements
				"beth":10, // java.lang.String
				// names of persistent elements
				"ALEPH":1518668429, // byps.test.api.cons.HebrewZ
				// names of persistent elements
				"BETH":1518668429 // byps.test.api.cons.HebrewZ
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.cons.HebrewZ
		1518668429 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"core":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.cons.HebrewZ[]
		92445340 : new byps.BSerializerArray(
			1518668429, // Element type: byps.test.api.cons.HebrewZ
			1
		),
		
		// byps.test.api.enu.EnumPlanets[]
		1441131650 : new byps.BSerializerArray(
			1375035164, // Element type: byps.test.api.enu.EnumPlanets
			1
		),
		
		// byps.test.api.enu.UsePlanets
		10000 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"planet":1375035164, // byps.test.api.enu.EnumPlanets
				// names of persistent elements
				"planet2":1375035164, // byps.test.api.enu.EnumPlanets
				// names of persistent elements
				"arrayOfPlanets":1441131650, // byps.test.api.enu.EnumPlanets[]
				// names of persistent elements
				"listOfPlanets":819140569, // java.util.ArrayList<byps.test.api.enu.EnumPlanets>
				// names of persistent elements
				"mapOfPlanets":493795497 // java.util.Map<java.lang.String,byps.test.api.enu.EnumPlanets>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arrayOfPlanets":1441131650, // byps.test.api.enu.EnumPlanets[]
				// names of inline elements
				"listOfPlanets":819140569, // java.util.ArrayList<byps.test.api.enu.EnumPlanets>
				// names of inline elements
				"mapOfPlanets":493795497 // java.util.Map<java.lang.String,byps.test.api.enu.EnumPlanets>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.BRequest_BioFruitService_certify
		1435417025 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"param":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.BRequest_BioLemonService_useParing
		2108700976 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.BRequest_FruitService_squeeze
		1290167289 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.BRequest_LemonService_pick
		1022088379 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sess":65775978, // byps.test.api.auth.SessionInfo
				// names of persistent elements
				"fromTree":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.BRequest_PlantService_grow
		695716901 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.BStub_BioFruitService
		612235846 : new byps.BSerializerRemote(byps.test.api.inherit.BStub_BioFruitService),
		
		// byps.test.api.inherit.BStub_BioLemonService
		501819909 : new byps.BSerializerRemote(byps.test.api.inherit.BStub_BioLemonService),
		
		// byps.test.api.inherit.BStub_FruitService
		937293552 : new byps.BSerializerRemote(byps.test.api.inherit.BStub_FruitService),
		
		// byps.test.api.inherit.BStub_LemonService
		826877615 : new byps.BSerializerRemote(byps.test.api.inherit.BStub_LemonService),
		
		// byps.test.api.inherit.BStub_PlantService
		1733272281 : new byps.BSerializerRemote(byps.test.api.inherit.BStub_PlantService),
		
		// byps.test.api.inherit.Class1
		6001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":5, // int
				// names of persistent elements
				"nextClass1":6001 // byps.test.api.inherit.Class1
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.Class1Collections
		6004 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"list1":510524840, // java.util.List<byps.test.api.inherit.Class1>
				// names of persistent elements
				"map1":2058676657, // java.util.Map<java.lang.String,byps.test.api.inherit.Class1>
				// names of persistent elements
				"set1":484881308 // java.util.Set<byps.test.api.inherit.Class1>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"list1":510524840, // java.util.List<byps.test.api.inherit.Class1>
				// names of inline elements
				"map1":2058676657, // java.util.Map<java.lang.String,byps.test.api.inherit.Class1>
				// names of inline elements
				"set1":484881308 // java.util.Set<byps.test.api.inherit.Class1>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.Class2
		6002 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inherit.Class3
		6003 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int3":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.inl.Actor
		171948703 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"shape":184101377, // byps.test.api.inl.Point2D[]
				// names of persistent elements
				"position":135329019 // byps.test.api.inl.Matrix2D
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"shape":184101377, // byps.test.api.inl.Point2D[]
				// names of inline elements
				"position":135329019 // byps.test.api.inl.Matrix2D
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.inl.Matrix2D
		135329019 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			true
		),
		
		// byps.test.api.inl.Point2D
		1835035436 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"x":3, // short
				// names of persistent elements
				"y":3 // short
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			true
		),
		
		// byps.test.api.inl.Point2D[]
		184101377 : new byps.BSerializerArray(
			1835035436, // Element type: byps.test.api.inl.Point2D
			1
		),
		
		// byps.test.api.inl.Point2D[][]
		827767075 : new byps.BSerializerArray(
			1835035436, // Element type: byps.test.api.inl.Point2D
			2
		),
		
		// byps.test.api.inl.Point2D[][][]
		915212229 : new byps.BSerializerArray(
			1835035436, // Element type: byps.test.api.inl.Point2D
			3
		),
		
		// byps.test.api.inl.Point2D[][][][]
		949340697 : new byps.BSerializerArray(
			1835035436, // Element type: byps.test.api.inl.Point2D
			4
		),
		
		// byps.test.api.list.ListListTypes
		3002 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1746702954, // java.util.List<java.util.List<java.lang.Integer>>
				// names of persistent elements
				"int3":1633500852, // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
				// names of persistent elements
				"int24":1865834185 // java.util.List<java.util.List<int[][][][]>>
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
		
		// byps.test.api.list.ListTypes
		3001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"date1":1504867122, // java.util.List<java.util.Date>
				// names of persistent elements
				"primitiveTypes1":1596367810, // java.util.List<byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"byte2":1174971318, // java.util.List<byte[]>
				// names of persistent elements
				"int2":1752158699, // java.util.List<int[]>
				// names of persistent elements
				"int4":1088217157, // java.util.List<int[][][][]>
				// names of persistent elements
				"obj1":12 // java.util.List<java.lang.Object>
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
				"date1":1504867122, // java.util.List<java.util.Date>
				// names of inline elements
				"primitiveTypes1":1596367810, // java.util.List<byps.test.api.prim.PrimitiveTypes>
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
		
		// byps.test.api.map.MapTypes
		4001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"primitiveTypes1":1831201218, // java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"byte2":1799280818, // java.util.Map<java.lang.Integer,byte[]>
				// names of persistent elements
				"int2":1633750383, // java.util.Map<java.lang.Integer,int[]>
				// names of persistent elements
				"obj1":1488550492, // java.util.Map<java.lang.String,java.lang.Object>
				// names of persistent elements
				"date1":1366799209 // java.util.Map<java.lang.String,java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
				"primitiveTypes1":1831201218, // java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
				// names of inline elements
				"byte2":1799280818, // java.util.Map<java.lang.Integer,byte[]>
				// names of inline elements
				"int2":1633750383, // java.util.Map<java.lang.Integer,int[]>
				// names of inline elements
				"obj1":1488550492, // java.util.Map<java.lang.String,java.lang.Object>
				// names of inline elements
				"date1":1366799209 // java.util.Map<java.lang.String,java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.prim.PrimitiveTypes
		1000 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"dateVal":17, // java.util.Date
				// names of persistent elements
				"objVal":21, // java.lang.Object
				// names of persistent elements
				"objVal2":21, // java.lang.Object
				// names of persistent elements
				"value":1, // boolean
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"dateVal":17, // java.util.Date
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.prim.PrimitiveTypes[]
		2053507648 : new byps.BSerializerArray(
			1000, // Element type: byps.test.api.prim.PrimitiveTypes
			1
		),
		
		// byps.test.api.prim.PrimitiveTypes[][]
		2030857950 : new byps.BSerializerArray(
			1000, // Element type: byps.test.api.prim.PrimitiveTypes
			2
		),
		
		// byps.test.api.prim.PrimitiveTypes[][][]
		1739334652 : new byps.BSerializerArray(
			1000, // Element type: byps.test.api.prim.PrimitiveTypes
			3
		),
		
		// byps.test.api.prim.PrimitiveTypes[][][][]
		758319514 : new byps.BSerializerArray(
			1000, // Element type: byps.test.api.prim.PrimitiveTypes
			4
		),
		
		// byps.test.api.priv.PrivateMembers
		8001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"primitiveTypes":1000, // byps.test.api.prim.PrimitiveTypes
				// names of persistent elements
				"arrBool":2058423690, // boolean[]
				// names of persistent elements
				"arrInt":100361105, // int[]
				// names of persistent elements
				"arrString":1888107655, // java.lang.String[]
				// names of persistent elements
				"arrPrimitiveTypes":2053507648, // byps.test.api.prim.PrimitiveTypes[]
				// names of persistent elements
				"listBool":1617670280, // java.util.List<java.lang.Boolean>
				// names of persistent elements
				"listInt":181681714, // java.util.List<java.lang.Integer>
				// names of persistent elements
				"listString":2123584667, // java.util.List<java.lang.String>
				// names of persistent elements
				"listPrimitiveTypes":1596367810, // java.util.List<byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"mapIntListString":132175071, // java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
				// names of persistent elements
				"protInt":5, // int
				// names of persistent elements
				"pprotInt":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arrBool":2058423690, // boolean[]
				// names of inline elements
				"arrInt":100361105, // int[]
				// names of inline elements
				"arrString":1888107655, // java.lang.String[]
				// names of inline elements
				"arrPrimitiveTypes":2053507648, // byps.test.api.prim.PrimitiveTypes[]
				// names of inline elements
				"listBool":1617670280, // java.util.List<java.lang.Boolean>
				// names of inline elements
				"listInt":181681714, // java.util.List<java.lang.Integer>
				// names of inline elements
				"listString":2123584667, // java.util.List<java.lang.String>
				// names of inline elements
				"listPrimitiveTypes":1596367810, // java.util.List<byps.test.api.prim.PrimitiveTypes>
				// names of inline elements
				"mapIntListString":132175071, // java.util.Map<java.lang.Integer,java.util.List<java.lang.String>>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.refs.Node
		9001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"next":9001, // byps.test.api.refs.Node
				// names of persistent elements
				"me":9001, // byps.test.api.refs.Node
				// names of persistent elements
				"mapOfNodes":2011881553, // java.util.Map<java.lang.String,byps.test.api.refs.Node>
				// names of persistent elements
				"listOfNodes":1442786648 // java.util.List<byps.test.api.refs.Node>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"mapOfNodes":2011881553, // java.util.Map<java.lang.String,byps.test.api.refs.Node>
				// names of inline elements
				"listOfNodes":1442786648 // java.util.List<byps.test.api.refs.Node>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getBool
		2033416644 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getByte
		2033426402 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getChar
		2033439280 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getDate
		2033462920 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getDouble
		39293909 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getFloat
		1384988990 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getInt
		1874061867 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getLong
		2033714518 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getObject
		263295897 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
		1992537556 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getShort
		1373101854 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getString
		394678379 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setBool
		201441072 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2058423690 // boolean[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":2058423690 // boolean[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setByte
		201431314 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1374008726 // byte[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1374008726 // byte[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setChar
		201418436 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1361632968 // char[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1361632968 // char[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setDate
		201394796 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1406664368 // java.util.Date[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1406664368 // java.util.Date[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setDouble
		253910985 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1359468275 // double[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1359468275 // double[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setFloat
		1946101450 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":766441794 // float[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":766441794 // float[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setInt
		1530512055 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":100361105 // int[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":100361105 // int[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setLong
		201143198 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1097129250 // long[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1097129250 // long[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setObject
		48678821 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":183594037 // java.lang.Object[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":183594037 // java.lang.Object[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
		1362276920 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2053507648 // byps.test.api.prim.PrimitiveTypes[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":2053507648 // byps.test.api.prim.PrimitiveTypes[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setShort
		1934214314 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2067161310 // short[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":2067161310 // short[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setString
		180061303 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1888107655 // java.lang.String[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1888107655 // java.lang.String[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysClass
		330036060 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":2030857950, // byps.test.api.prim.PrimitiveTypes[][]
				// names of persistent elements
				"arr3":1739334652, // byps.test.api.prim.PrimitiveTypes[][][]
				// names of persistent elements
				"arr4":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arr2":2030857950, // byps.test.api.prim.PrimitiveTypes[][]
				// names of inline elements
				"arr3":1739334652, // byps.test.api.prim.PrimitiveTypes[][][]
				// names of inline elements
				"arr4":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInline
		1467243283 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":827767075, // byps.test.api.inl.Point2D[][]
				// names of persistent elements
				"arr3":915212229, // byps.test.api.inl.Point2D[][][]
				// names of persistent elements
				"arr4":949340697 // byps.test.api.inl.Point2D[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"arr2":827767075, // byps.test.api.inl.Point2D[][]
				// names of inline elements
				"arr3":915212229, // byps.test.api.inl.Point2D[][][]
				// names of inline elements
				"arr4":949340697 // byps.test.api.inl.Point2D[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysInt
		1828268517 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":1957744307, // int[][]
				// names of persistent elements
				"arr3":196606293, // int[][][]
				// names of persistent elements
				"arr4":39910537 // int[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysObject
		1306614381 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":340213335, // java.lang.Object[][]
				// names of persistent elements
				"arr3":527503353, // java.lang.Object[][][]
				// names of persistent elements
				"arr4":124584219 // java.lang.Object[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes23_sendArraysString
		1175231899 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"arr2":1995260457, // java.lang.String[][]
				// names of persistent elements
				"arr3":1889888075, // java.lang.String[][][]
				// names of persistent elements
				"arr4":588723219 // java.lang.String[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getBool
		1874302495 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getByte
		1874292737 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getChar
		1874279859 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getDate
		1874256219 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getDouble
		1555969784 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getFloat
		2029769285 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getInt
		1325018648 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getLong
		1874004621 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getObject
		1253379978 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getPrimitiveTypes
		483228169 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getShort
		2041656421 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getString
		1121997496 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setBool
		185807085 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":945713488 // boolean[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":945713488 // boolean[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setByte
		185816843 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1201775504 // byte[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1201775504 // byte[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setChar
		185829721 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":769021986 // char[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":769021986 // char[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setDate
		185853361 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":51898890 // java.util.Date[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":51898890 // java.util.Date[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setDouble
		1770586860 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2087445849 // double[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":2087445849 // double[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setFloat
		1468656825 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1516687588 // float[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1516687588 // float[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setInt
		1668568460 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":39910537 // int[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":39910537 // int[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setLong
		186104959 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":846419204 // long[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":846419204 // long[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setObject
		1467997054 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":124584219 // java.lang.Object[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":124584219 // java.lang.Object[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
		456924651 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":758319514 // byps.test.api.prim.PrimitiveTypes[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setShort
		1480543961 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1859644668 // short[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":1859644668 // short[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setString
		1336614572 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":588723219 // java.lang.String[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":588723219 // java.lang.String[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteConstants_compare_AllTypesC
		1609344203 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"ALL":142458, // byps.test.api.cons.AllTypesZ
				// names of persistent elements
				"arrInt":100361105, // int[]
				// names of persistent elements
				"arrInt4":39910537, // int[][][][]
				// names of persistent elements
				"arrStrings":1888107655, // java.lang.String[]
				// names of persistent elements
				"arrStrings4":588723219, // java.lang.String[][][][]
				// names of persistent elements
				"arrAll":81775365 // byps.test.api.cons.AllTypesZ[][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
				"arrAll":81775365 // byps.test.api.cons.AllTypesZ[][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteConstants_compare_HebrewC
		1711871378 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"ALEPH":1518668429, // byps.test.api.cons.HebrewZ
				// names of persistent elements
				"BETH":1518668429 // byps.test.api.cons.HebrewZ
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteEnums_getPlanet
		6352043 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteEnums_setPlanet
		220969119 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"planet":1375035164 // byps.test.api.enu.EnumPlanets
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_getActor
		600892860 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray1dim
		188393247 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray4dim
		188482620 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DList
		1428313263 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DListList
		1650554387 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DMap
		646661333 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_setActor
		1162005320 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"act":171948703 // byps.test.api.inl.Actor
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray1dim
		1355334613 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointArray":184101377 // byps.test.api.inl.Point2D[]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointArray":184101377 // byps.test.api.inl.Point2D[]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DArray4dim
		1355245240 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointArray":949340697 // byps.test.api.inl.Point2D[][][][]
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointArray":949340697 // byps.test.api.inl.Point2D[][][][]
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DList
		343422941 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointList":2064980445 // java.util.List<byps.test.api.inl.Point2D>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointList":2064980445 // java.util.List<byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DListList
		730520735 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointListList":1823330785 // java.util.List<java.util.List<byps.test.api.inl.Point2D>>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointListList":1823330785 // java.util.List<java.util.List<byps.test.api.inl.Point2D>>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteInlineInstance_setPoint2DMap
		127469879 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"pointMap":1358523233 // java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"pointMap":1358523233 // java.util.Map<java.lang.Integer,byps.test.api.inl.Point2D>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getBoolean1
		2058662161 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getByte1
		608486403 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getByte2
		608486404 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getChar1
		608885621 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getDate1
		609618461 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getDouble1
		2129490906 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getFloat1
		1785569467 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getInt1
		2098036488 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getInt2
		2098036489 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getInt3
		2098036490 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getInt4
		2098036491 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getLong1
		617417999 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getObj1
		2098203392 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getPrimitiveTypes1
		1679973895 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getShort1
		2140896613 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_getString1
		1597237350 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setBoolean1
		2147241989 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1617670280 // java.util.List<java.lang.Boolean>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1617670280 // java.util.List<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setByte1
		47373943 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte1":1059148284 // java.util.List<java.lang.Byte>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte1":1059148284 // java.util.List<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setByte2
		47373944 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte2":1174971318 // java.util.List<byte[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":1174971318 // java.util.List<byte[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setChar1
		47773161 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"char1":1661807911 // java.util.List<java.lang.Character>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"char1":1661807911 // java.util.List<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setDate1
		48506001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":1504867122 // java.util.List<java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":1504867122 // java.util.List<java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setDouble1
		228671154 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"double1":1555345627 // java.util.List<java.lang.Double>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"double1":1555345627 // java.util.List<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setFloat1
		1570952391 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"float1":1628501332 // java.util.List<java.lang.Float>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"float1":1628501332 // java.util.List<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setInt1
		136821228 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":181681714 // java.util.List<java.lang.Integer>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int1":181681714 // java.util.List<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setInt2
		136821227 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1752158699 // java.util.List<int[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int2":1752158699 // java.util.List<int[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setInt3
		136821226 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int3":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int3":1746702954 // java.util.List<java.util.List<java.lang.Integer>>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setInt4
		136821225 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int4":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int4":1633500852 // java.util.List<java.util.Map<java.lang.Integer,java.util.List<java.util.TreeSet<java.lang.Integer>>>>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setLong1
		56305539 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"long1":1050216688 // java.util.List<java.lang.Long>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"long1":1050216688 // java.util.List<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setObj1
		136654324 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":12 // java.util.List<java.lang.Object>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":12 // java.util.List<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setPrimitiveTypes1
		759940243 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"primitiveTypes1":1596367810 // java.util.List<byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"primitiveTypes1":1596367810 // java.util.List<byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setShort1
		1939453607 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"short1":1997002548 // java.util.List<java.lang.Short>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"short1":1997002548 // java.util.List<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteListTypes_setString1
		339567886 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"string1":2123584667 // java.util.List<java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"string1":2123584667 // java.util.List<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getBoolean1
		885803255 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getByte1
		124722647 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getByte2
		124722646 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getChar1
		124323429 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getDate1
		123590589 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getDouble1
		1890230400 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getFloat1
		530925397 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getInt1
		827458594 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getInt2
		827458595 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getLong1
		115791051 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getObj1
		827625498 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getPrimitiveTypes1
		1745799327 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getShort1
		899426613 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_getString1
		1836497856 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setBoolean1
		974383083 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1279823631 // java.util.Map<java.lang.String,java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setByte1
		685835107 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte1":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte1":1972793385 // java.util.HashMap<java.lang.Double,java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setByte2
		685835106 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte2":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":1799280818 // java.util.Map<java.lang.Integer,byte[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setChar1
		685435889 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"char1":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"char1":8789515 // java.util.TreeMap<java.lang.Float,java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setDate1
		684703049 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":1366799209 // java.util.Map<java.lang.String,java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":1366799209 // java.util.Map<java.lang.String,java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setDouble1
		467931660 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"double1":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"double1":1487265161 // java.util.Map<java.lang.Byte,java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setFloat1
		316308321 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"float1":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"float1":94341197 // java.util.Map<java.lang.Character,java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setInt1
		1407399122 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int1":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setInt2
		1407399121 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int2":1633750383 // java.util.Map<java.lang.Integer,int[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setLong1
		676903511 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"long1":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"long1":1973996106 // java.util.Map<java.lang.Short,java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setObj1
		1407232218 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":1488550492 // java.util.Map<java.lang.String,java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setPrimitiveTypes1
		1629134317 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"primitiveTypes1":1831201218 // java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"primitiveTypes1":1831201218 // java.util.Map<java.lang.Integer,byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setShort1
		684809537 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"short1":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"short1":601099730 // java.util.Map<java.lang.Long,java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteMapTypes_setString1
		100307380 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"string1":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"string1":1710660846 // java.util.Map<java.lang.String,java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_add
		362528512 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"a":5, // int
				// names of persistent elements
				"b":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getBool
		1816157633 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getByte
		1816147875 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getChar
		1816134997 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDate
		1816111357 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDouble
		1513332250 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getFloat
		462707289 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getInt
		1582599686 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getLong
		1815859759 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getObject
		1210742444 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getPrimitiveTypes
		714626279 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getShort
		450820153 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_getString
		1079359962 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_makeDate
		1918934973 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"year":5, // int
				// names of persistent elements
				"month":5, // int
				// names of persistent elements
				"day":5, // int
				// names of persistent elements
				"hour":5, // int
				// names of persistent elements
				"minute":5, // int
				// names of persistent elements
				"second":5, // int
				// names of persistent elements
				"millisecond":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_parseDate
		578007072 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"date":17 // java.util.Date
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"date":17 // java.util.Date
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
		677876863 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"pt":1000, // byps.test.api.prim.PrimitiveTypes
				// names of persistent elements
				"o":21 // java.lang.Object
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setBool
		243951947 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1 // boolean
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setByte
		243961705 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":2 // byte
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setChar
		243974583 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":4 // char
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDate
		243998223 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":17 // java.util.Date
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"v":17 // java.util.Date
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
		1727949326 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":8 // double
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setFloat
		1023819749 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":7 // float
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setInt
		1239049874 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setLong
		244249821 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":6 // long
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setObject
		1425359520 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":21 // java.lang.Object
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setPrimitiveTypes
		225526541 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":1000 // byps.test.api.prim.PrimitiveTypes
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setShort
		1011932613 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":3 // short
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_setString
		1293977038 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_throwException
		1278149706 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemotePrimitiveTypes_voidFunctionVoid
		2033139391 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteReferences_getNode
		1366991859 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteReferences_setNode
		693117721 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":9001 // byps.test.api.refs.Node
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteServerCtrl_getPublishedRemote
		648762723 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"name":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteServerCtrl_publishRemote
		1543768912 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"name":10, // java.lang.String
				// names of persistent elements
				"remote":16, // byps.BRemote
				// names of persistent elements
				"fowardToOtherServers":1 // boolean
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteServerCtrl_removePublishedRemote
		135366859 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"name":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getBoolean1
		2114990909 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getByte1
		901695825 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getByte2
		901695824 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getChar1
		901296607 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getDate1
		900563767 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getDouble1
		1751651450 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getFloat1
		2080406641 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getInt1
		1772226268 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getInt2
		1772226269 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getLong1
		892764229 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getObj1
		1772393172 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getPrimitiveTypes1
		669274715 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getShort1
		1711905425 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_getString1
		1183412410 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setBoolean1
		2091396559 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"boolean1":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"boolean1":1365696060 // java.util.Set<java.lang.Boolean>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setByte1
		1462808285 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte1":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte1":31512998 // java.util.HashSet<java.lang.Byte>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setByte2
		1462808284 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"byte2":2052431866 // java.util.Set<byte[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"byte2":2052431866 // java.util.Set<byte[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setChar1
		1462409067 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"char1":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"char1":936607009 // java.util.TreeSet<java.lang.Character>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setDate1
		1461676227 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":1097919350 // java.util.Set<java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":1097919350 // java.util.Set<java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setDouble1
		185153786 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"double1":1320560671 // java.util.Set<java.lang.Double>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"double1":1320560671 // java.util.Set<java.lang.Double>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setFloat1
		1999943579 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"float1":1898022288 // java.util.Set<java.lang.Float>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"float1":1898022288 // java.util.Set<java.lang.Float>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setInt1
		462631448 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int1":1493282670 // java.util.Set<java.lang.Integer>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int1":1493282670 // java.util.Set<java.lang.Integer>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setInt2
		462631447 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"int2":1406124761 // java.util.Set<int[]>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"int2":1406124761 // java.util.Set<int[]>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setLong1
		1453876689 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"long1":1457164460 // java.util.Set<java.lang.Long>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"long1":1457164460 // java.util.Set<java.lang.Long>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setObj1
		462464544 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj1":14 // java.util.Set<java.lang.Object>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"obj1":14 // java.util.Set<java.lang.Object>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setPrimitiveTypes1
		250758937 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"primitiveTypes1":673917574 // java.util.Set<byps.test.api.prim.PrimitiveTypes>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"primitiveTypes1":673917574 // java.util.Set<byps.test.api.prim.PrimitiveTypes>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setShort1
		1926522501 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"short1":2028443792 // java.util.Set<java.lang.Short>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"short1":2028443792 // java.util.Set<java.lang.Short>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteSetTypes_setString1
		753392826 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"string1":1888799711 // java.util.Set<java.lang.String>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"string1":1888799711 // java.util.Set<java.lang.String>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteStreams_getImage
		61677379 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteStreams_getImages
		1911998634 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteStreams_getTextStream
		818823403 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteStreams_setImage
		622789839 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"istrm":15 // java.io.InputStream
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteStreams_setImages
		2126615710 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"istrms":779528402, // java.util.Map<java.lang.Integer,java.io.InputStream>
				// names of persistent elements
				"doNotReadStreamAtKey":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"istrms":779528402, // java.util.Map<java.lang.Integer,java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteStreams_throwLastException
		2127402965 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteWithAuthentication_doit
		1251509013 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sess":65775978, // byps.test.api.auth.SessionInfo
				// names of persistent elements
				"value":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteWithAuthentication_expire
		72176172 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sess":65775978 // byps.test.api.auth.SessionInfo
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteWithAuthentication_login
		134687724 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"sess":65775978, // byps.test.api.auth.SessionInfo
				// names of persistent elements
				"userName":10, // java.lang.String
				// names of persistent elements
				"userPwd":10 // java.lang.String
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteWithAuthentication_setReloginCount
		802968058 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"count":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BRequest_RemoteWithAuthentication_setUseAuthentication
		946544530 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"useAuth":1 // boolean
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.remote.BStub_RemoteArrayTypes1dim
		1176140631 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteArrayTypes1dim),
		
		// byps.test.api.remote.BStub_RemoteArrayTypes23
		964138163 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteArrayTypes23),
		
		// byps.test.api.remote.BStub_RemoteArrayTypes4dim
		1176051258 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteArrayTypes4dim),
		
		// byps.test.api.remote.BStub_RemoteConstants
		429088323 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteConstants),
		
		// byps.test.api.remote.BStub_RemoteEnums
		1222673152 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteEnums),
		
		// byps.test.api.remote.BStub_RemoteInlineInstance
		355071648 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteInlineInstance),
		
		// byps.test.api.remote.BStub_RemoteListTypes
		1240892695 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteListTypes),
		
		// byps.test.api.remote.BStub_RemoteMapTypes
		1277224527 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteMapTypes),
		
		// byps.test.api.remote.BStub_RemotePrimitiveTypes
		1391241180 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemotePrimitiveTypes),
		
		// byps.test.api.remote.BStub_RemoteReferences
		1173792730 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteReferences),
		
		// byps.test.api.remote.BStub_RemoteServerCtrl
		2037577312 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteServerCtrl),
		
		// byps.test.api.remote.BStub_RemoteSetTypes
		1781251319 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteSetTypes),
		
		// byps.test.api.remote.BStub_RemoteStreams
		2123238175 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteStreams),
		
		// byps.test.api.remote.BStub_RemoteWithAuthentication
		1532028880 : new byps.BSerializerRemote(byps.test.api.remote.BStub_RemoteWithAuthentication),
		
		// byps.test.api.set.SetTypes
		5001 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"primitiveTypes1":673917574, // java.util.Set<byps.test.api.prim.PrimitiveTypes>
				// names of persistent elements
				"byte2":2052431866, // java.util.Set<byte[]>
				// names of persistent elements
				"int2":1406124761, // java.util.Set<int[]>
				// names of persistent elements
				"obj1":14, // java.util.Set<java.lang.Object>
				// names of persistent elements
				"date1":1097919350 // java.util.Set<java.util.Date>
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
				"primitiveTypes1":673917574, // java.util.Set<byps.test.api.prim.PrimitiveTypes>
				// names of inline elements
				"byte2":2052431866, // java.util.Set<byte[]>
				// names of inline elements
				"int2":1406124761, // java.util.Set<int[]>
				// names of inline elements
				"obj1":14, // java.util.Set<java.lang.Object>
				// names of inline elements
				"date1":1097919350 // java.util.Set<java.util.Date>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ClientIF_getStreams
		1654980071 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"ctrl":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ClientIF_incrementInt
		1685952420 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"a":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ClientIF_putStreams
		2016865344 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"strm":1218831438, // java.util.List<java.io.InputStream>
				// names of persistent elements
				"ctrl":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"strm":1218831438, // java.util.List<java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ClientIF_sendChat
		41050276 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"cs":7007 // byps.test.api.srvr.ChatStructure
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_callClientIncrementInt
		389860173 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_callClientParallel
		772308436 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"v":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_getClient
		190669475 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"id":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_getClientIds
		2007476251 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_getPartner
		1025664374 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_getStreamsFromClient
		1679867754 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_putStreamsOnClient
		1934886286 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"streams":1218831438 // java.util.List<java.io.InputStream>
			},
			// checkpoint byps.gen.js.GenRegistry:138
			// names of inline elements
			{
				"streams":1218831438 // java.util.List<java.io.InputStream>
			},
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_registerWithClientMap
		1533268444 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"id":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BRequest_ServerIF_setPartner
		1332497686 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"client":955752991 // byps.test.api.srvr.ClientIF
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.srvr.BStub_ClientIF
		955752991 : new byps.BSerializerRemote(byps.test.api.srvr.BStub_ClientIF),
		
		// byps.test.api.srvr.BStub_ServerIF
		1426448279 : new byps.BSerializerRemote(byps.test.api.srvr.BStub_ServerIF),
		
		// byps.test.api.srvr.ChatStructure
		7007 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"msg":10, // java.lang.String
				// names of persistent elements
				"sentAt":8, // double
				// names of persistent elements
				"receivedAt":8 // double
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.strm.Stream1
		1541129345 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
			// checkpoint byps.gen.js.GenRegistry:138
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
		
		// byps.test.api.ver.BRequest_EvolveIF_getClient
		1212621223 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.ver.BRequest_EvolveIF_getEvolve
		1279300441 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.ver.BRequest_EvolveIF_sendEvolveToClient
		714115141 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.ver.BRequest_EvolveIF_setClient
		998004147 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"partner":564008001 // byps.test.api.ver.EvolveIF
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.ver.BRequest_EvolveIF_setEvolve
		1064683365 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"obj":1391985860 // byps.test.api.ver.Evolve
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byps.test.api.ver.BStub_EvolveIF
		564008001 : new byps.BSerializerRemote(byps.test.api.ver.BStub_EvolveIF),
		
		// byps.test.api.ver.Evolve
		1391985860 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
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
				"evo1":573592593, // byps.test.api.ver.Evolve2
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
				"evo2":573592593, // byps.test.api.ver.Evolve2
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
				"evo3":573592593, // byps.test.api.ver.Evolve2
				// names of persistent elements
				"list3":181681714, // java.util.List<java.lang.Integer>
				// names of persistent elements
				"set3":1493282670, // java.util.Set<java.lang.Integer>
				// names of persistent elements
				"map3":1347703734 // java.util.Map<java.lang.Integer,java.lang.Integer>
			},
			// checkpoint byps.gen.js.GenRegistry:138
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
		
		// byps.test.api.ver.Evolve2
		573592593 : new byps.BSerializer(
			// checkpoint byps.gen.js.GenRegistry:138
			// names of persistent elements
			{
				"n1":5 // int
			},
			// checkpoint byps.gen.js.GenRegistry:138
			null,
			// inlineInstance
			false
		),
		
		// byte[]
		1374008726 : new byps.BSerializerArray(
			2, // Element type: byte
			1
		),
		
		// byte[][][][]
		1201775504 : new byps.BSerializerArray(
			2, // Element type: byte
			4
		),
		
		// char[]
		1361632968 : new byps.BSerializerArray(
			4, // Element type: char
			1
		),
		
		// char[][][][]
		769021986 : new byps.BSerializerArray(
			4, // Element type: char
			4
		),
		
		// double[]
		1359468275 : new byps.BSerializerArray(
			8, // Element type: double
			1
		),
		
		// double[][][][]
		2087445849 : new byps.BSerializerArray(
			8, // Element type: double
			4
		),
		
		// float[]
		766441794 : new byps.BSerializerArray(
			7, // Element type: float
			1
		),
		
		// float[][][][]
		1516687588 : new byps.BSerializerArray(
			7, // Element type: float
			4
		),
		
		// int[]
		100361105 : new byps.BSerializerArray(
			5, // Element type: int
			1
		),
		
		// int[][]
		1957744307 : new byps.BSerializerArray(
			5, // Element type: int
			2
		),
		
		// int[][][]
		196606293 : new byps.BSerializerArray(
			5, // Element type: int
			3
		),
		
		// int[][][][]
		39910537 : new byps.BSerializerArray(
			5, // Element type: int
			4
		),
		
		// java.io.InputStream[]
		1950626768 : new byps.BSerializerArray(
			15, // Element type: java.io.InputStream
			1
		),
		
		// Object[]
		183594037 : new byps.BSerializerArray(
			21, // Element type: Object
			1
		),
		
		// Object[][]
		340213335 : new byps.BSerializerArray(
			21, // Element type: Object
			2
		),
		
		// Object[][][]
		527503353 : new byps.BSerializerArray(
			21, // Element type: Object
			3
		),
		
		// Object[][][][]
		124584219 : new byps.BSerializerArray(
			21, // Element type: Object
			4
		),
		
		// String[]
		1888107655 : new byps.BSerializerArray(
			10, // Element type: String
			1
		),
		
		// String[][]
		1995260457 : new byps.BSerializerArray(
			10, // Element type: String
			2
		),
		
		// String[][][]
		1889888075 : new byps.BSerializerArray(
			10, // Element type: String
			3
		),
		
		// String[][][][]
		588723219 : new byps.BSerializerArray(
			10, // Element type: String
			4
		),
		
		// java.util.ArrayList<byps.test.api.enu.EnumPlanets>
		819140569 : new byps.BSerializerArray(
			1375035164, // Element type: byps.test.api.enu.EnumPlanets
			1
		),
		
		// java.util.Date[]
		1406664368 : new byps.BSerializerArray(
			17, // Element type: java.util.Date
			1
		),
		
		// java.util.Date[][][][]
		51898890 : new byps.BSerializerArray(
			17, // Element type: java.util.Date
			4
		),
		
		// java.util.HashMap<Double,Byte>
		1972793385 : new byps.BSerializerMap(
			2 // Element type: Byte
		),
		
		// java.util.HashSet<Byte>
		31512998 : new byps.BSerializerArray(
			2, // Element type: Byte
			1
		),
		
		// java.util.List<byps.test.api.inherit.Class1>
		510524840 : new byps.BSerializerArray(
			6001, // Element type: byps.test.api.inherit.Class1
			1
		),
		
		// java.util.List<byps.test.api.inl.Point2D>
		2064980445 : new byps.BSerializerArray(
			1835035436, // Element type: byps.test.api.inl.Point2D
			1
		),
		
		// java.util.List<byps.test.api.prim.PrimitiveTypes>
		1596367810 : new byps.BSerializerArray(
			1000, // Element type: byps.test.api.prim.PrimitiveTypes
			1
		),
		
		// java.util.List<byps.test.api.refs.Node>
		1442786648 : new byps.BSerializerArray(
			9001, // Element type: byps.test.api.refs.Node
			1
		),
		
		// java.util.List<byte[]>
		1174971318 : new byps.BSerializerArray(
			1374008726, // Element type: byte[]
			1
		),
		
		// java.util.List<int[]>
		1752158699 : new byps.BSerializerArray(
			100361105, // Element type: int[]
			1
		),
		
		// java.util.List<int[][][][]>
		1088217157 : new byps.BSerializerArray(
			39910537, // Element type: int[][][][]
			1
		),
		
		// java.util.List<java.io.InputStream>
		1218831438 : new byps.BSerializerArray(
			15, // Element type: java.io.InputStream
			1
		),
		
		// java.util.List<Boolean>
		1617670280 : new byps.BSerializerArray(
			1, // Element type: Boolean
			1
		),
		
		// java.util.List<Byte>
		1059148284 : new byps.BSerializerArray(
			2, // Element type: Byte
			1
		),
		
		// java.util.List<Character>
		1661807911 : new byps.BSerializerArray(
			4, // Element type: Character
			1
		),
		
		// java.util.List<Double>
		1555345627 : new byps.BSerializerArray(
			8, // Element type: Double
			1
		),
		
		// java.util.List<Float>
		1628501332 : new byps.BSerializerArray(
			7, // Element type: Float
			1
		),
		
		// java.util.List<Integer>
		181681714 : new byps.BSerializerArray(
			5, // Element type: Integer
			1
		),
		
		// java.util.List<Long>
		1050216688 : new byps.BSerializerArray(
			6, // Element type: Long
			1
		),
		
		// java.util.List<Short>
		1997002548 : new byps.BSerializerArray(
			3, // Element type: Short
			1
		),
		
		// java.util.List<String>
		2123584667 : new byps.BSerializerArray(
			10, // Element type: String
			1
		),
		
		// java.util.List<java.util.Date>
		1504867122 : new byps.BSerializerArray(
			17, // Element type: java.util.Date
			1
		),
		
		// java.util.List<java.util.List<byps.test.api.inl.Point2D>>
		1823330785 : new byps.BSerializerArray(
			2064980445, // Element type: java.util.List<byps.test.api.inl.Point2D>
			1
		),
		
		// java.util.List<java.util.List<int[][][][]>>
		1865834185 : new byps.BSerializerArray(
			1088217157, // Element type: java.util.List<int[][][][]>
			1
		),
		
		// java.util.List<java.util.List<Integer>>
		1746702954 : new byps.BSerializerArray(
			181681714, // Element type: java.util.List<Integer>
			1
		),
		
		// java.util.List<java.util.Map<Integer,java.util.List<java.util.TreeSet<Integer>>>>
		1633500852 : new byps.BSerializerArray(
			49984088, // Element type: java.util.Map<Integer,java.util.List<java.util.TreeSet<Integer>>>
			1
		),
		
		// java.util.List<java.util.TreeSet<Integer>>
		724129228 : new byps.BSerializerArray(
			855786668, // Element type: java.util.TreeSet<Integer>
			1
		),
		
		// java.util.Map<Byte,Double>
		1487265161 : new byps.BSerializerMap(
			8 // Element type: Double
		),
		
		// java.util.Map<Character,Float>
		94341197 : new byps.BSerializerMap(
			7 // Element type: Float
		),
		
		// java.util.Map<Integer,byps.test.api.inl.Point2D>
		1358523233 : new byps.BSerializerMap(
			1835035436 // Element type: byps.test.api.inl.Point2D
		),
		
		// java.util.Map<Integer,byps.test.api.prim.PrimitiveTypes>
		1831201218 : new byps.BSerializerMap(
			1000 // Element type: byps.test.api.prim.PrimitiveTypes
		),
		
		// java.util.Map<Integer,byte[]>
		1799280818 : new byps.BSerializerMap(
			1374008726 // Element type: byte[]
		),
		
		// java.util.Map<Integer,int[]>
		1633750383 : new byps.BSerializerMap(
			100361105 // Element type: int[]
		),
		
		// java.util.Map<Integer,java.io.InputStream>
		779528402 : new byps.BSerializerMap(
			15 // Element type: java.io.InputStream
		),
		
		// java.util.Map<Integer,Integer>
		1347703734 : new byps.BSerializerMap(
			5 // Element type: Integer
		),
		
		// java.util.Map<Integer,java.util.List<String>>
		132175071 : new byps.BSerializerMap(
			2123584667 // Element type: java.util.List<String>
		),
		
		// java.util.Map<Integer,java.util.List<java.util.TreeSet<Integer>>>
		49984088 : new byps.BSerializerMap(
			724129228 // Element type: java.util.List<java.util.TreeSet<Integer>>
		),
		
		// java.util.Map<Long,Short>
		601099730 : new byps.BSerializerMap(
			3 // Element type: Short
		),
		
		// java.util.Map<Short,Long>
		1973996106 : new byps.BSerializerMap(
			6 // Element type: Long
		),
		
		// java.util.Map<String,byps.test.api.enu.EnumPlanets>
		493795497 : new byps.BSerializerMap(
			1375035164 // Element type: byps.test.api.enu.EnumPlanets
		),
		
		// java.util.Map<String,byps.test.api.inherit.Class1>
		2058676657 : new byps.BSerializerMap(
			6001 // Element type: byps.test.api.inherit.Class1
		),
		
		// java.util.Map<String,byps.test.api.refs.Node>
		2011881553 : new byps.BSerializerMap(
			9001 // Element type: byps.test.api.refs.Node
		),
		
		// java.util.Map<String,Boolean>
		1279823631 : new byps.BSerializerMap(
			1 // Element type: Boolean
		),
		
		// java.util.Map<String,Object>
		1488550492 : new byps.BSerializerMap(
			21 // Element type: Object
		),
		
		// java.util.Map<String,String>
		1710660846 : new byps.BSerializerMap(
			10 // Element type: String
		),
		
		// java.util.Map<String,java.util.Date>
		1366799209 : new byps.BSerializerMap(
			17 // Element type: java.util.Date
		),
		
		// java.util.Set<byps.test.api.inherit.Class1>
		484881308 : new byps.BSerializerArray(
			6001, // Element type: byps.test.api.inherit.Class1
			1
		),
		
		// java.util.Set<byps.test.api.prim.PrimitiveTypes>
		673917574 : new byps.BSerializerArray(
			1000, // Element type: byps.test.api.prim.PrimitiveTypes
			1
		),
		
		// java.util.Set<byte[]>
		2052431866 : new byps.BSerializerArray(
			1374008726, // Element type: byte[]
			1
		),
		
		// java.util.Set<int[]>
		1406124761 : new byps.BSerializerArray(
			100361105, // Element type: int[]
			1
		),
		
		// java.util.Set<Boolean>
		1365696060 : new byps.BSerializerArray(
			1, // Element type: Boolean
			1
		),
		
		// java.util.Set<Double>
		1320560671 : new byps.BSerializerArray(
			8, // Element type: Double
			1
		),
		
		// java.util.Set<Float>
		1898022288 : new byps.BSerializerArray(
			7, // Element type: Float
			1
		),
		
		// java.util.Set<Integer>
		1493282670 : new byps.BSerializerArray(
			5, // Element type: Integer
			1
		),
		
		// java.util.Set<Long>
		1457164460 : new byps.BSerializerArray(
			6, // Element type: Long
			1
		),
		
		// java.util.Set<Short>
		2028443792 : new byps.BSerializerArray(
			3, // Element type: Short
			1
		),
		
		// java.util.Set<String>
		1888799711 : new byps.BSerializerArray(
			10, // Element type: String
			1
		),
		
		// java.util.Set<java.util.Date>
		1097919350 : new byps.BSerializerArray(
			17, // Element type: java.util.Date
			1
		),
		
		// java.util.TreeMap<Float,Character>
		8789515 : new byps.BSerializerMap(
			4 // Element type: Character
		),
		
		// java.util.TreeMap<Integer,java.io.InputStream>
		476459792 : new byps.BSerializerMap(
			15 // Element type: java.io.InputStream
		),
		
		// java.util.TreeSet<Character>
		936607009 : new byps.BSerializerArray(
			4, // Element type: Character
			1
		),
		
		// java.util.TreeSet<Integer>
		855786668 : new byps.BSerializerArray(
			5, // Element type: Integer
			1
		),
		
		// long[]
		1097129250 : new byps.BSerializerArray(
			6, // Element type: long
			1
		),
		
		// long[][][][]
		846419204 : new byps.BSerializerArray(
			6, // Element type: long
			4
		),
		
		// short[]
		2067161310 : new byps.BSerializerArray(
			3, // Element type: short
			1
		),
		
		// short[][][][]
		1859644668 : new byps.BSerializerArray(
			3, // Element type: short
			4
		),
	};
};
byps.test.api.BRegistry_Testser.prototype = new byps.BRegistry();
