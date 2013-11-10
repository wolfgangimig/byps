describe("Tests for sending and receiving array types.", function() {
   
	beforeEach(function() {
	});

	it("testRemoteArrayTypes1dim", function() {
		log.info("testRemoteArrayTypes1dim(");

		var remote = client.remoteArrayTypes1dim;

		var boolean1 = [true, false, true];
		var byte1 = Base64.encode("abc");
		var char1 = ['a', 'b', 'c' ];
		var short1 = [ 55,66,77];
		var int1 = [12,34,56];
		var long1 = ['999.','88.','7.'];
		var float1 = [1.2, 2.2, 3.2];
		var double1 = [1e1, 1e2, 1e3];
		var string1 = ["ττττ"];
		var primitiveTypes1 = [ TestUtils.createObjectPrimitiveTypes() ];
		var object1 = [ new byps.test.api.arr.ArrayTypes1dim() ];
		var date1 = [new Date(), null, new Date("2011-12-13 14:15:16.789")];

		remote.setBool(boolean1);
		TestUtils.assertEquals(log, "bool", boolean1, remote.getBool());
		remote.setByte(byte1);
		TestUtils.assertEquals(log, "byte", byte1, remote.getByte());
		remote.setChar(char1);
		TestUtils.assertEquals(log, "char", char1, remote.getChar());
		remote.setShort(short1);
		TestUtils.assertEquals(log, "short", short1, remote.getShort());
		remote.setInt(int1);
		TestUtils.assertEquals(log,  "int", int1, remote.getInt());
		remote.setLong(long1);
		TestUtils.assertEquals(log, "long", long1, remote.getLong());
		remote.setFloat(float1);
		TestUtils.assertEquals(log,  "float", float1, remote.getFloat());
		remote.setDouble(double1);
		TestUtils.assertEquals(log,  "double", double1, remote.getDouble());
		remote.setString(string1);
		TestUtils.assertEquals(log,  "String", string1, remote.getString());
		remote.setDate(date1);
		TestUtils.assertEquals(log, "date", date1, remote.getDate());
		
		remote.setObject(object1);
		TestUtils.assertEquals(log,  "Object", object1, remote.getObject());
		
		remote.setPrimitiveTypes(primitiveTypes1);
		TestUtils.assertEquals(log,  "PrimitiveTypes", primitiveTypes1, remote.getPrimitiveTypes());
		
		log.info(")testRemoteArrayTypes1dim");
	});

	it("testRemoteArrayTypes4dim", function() {
		log.info("testRemoteArrayTypes4dim(");

		var remote = client.remoteArrayTypes4dim;

		var obj = new byps.test.api.arr.ArrayTypes4dim();
		obj.boolean4 = [[[[true]]]];
		obj.byte4 = [[[[1,2],[3,4]]]];
		obj.char4 = [[[['u'],['l'],['l'],['a']]]];
		obj.double4 = [[[[1],[2]]]];
		obj.float4 = [[[[3],[4]]]];
		obj.int4 = [[[[5],[6]]]];
		obj.long4 = [[[['7.'],['8.']]]];
		obj.primitiveTypes4 = [[[[ TestUtils.createObjectPrimitiveTypes() ]]]];
		obj.short4 = [[[[4,2,3,4,5,6,7]]]];
		obj.string4 = [[[["a", "b", "c"]]]];
		var object4 = [ [ [ [ new byps.test.api.arr.ArrayTypes4dim() ] ] ] ];
		var date4 = [[[[null, new Date(), null]]]];

		remote.setBool(obj.boolean4);
		TestUtils.assertEquals(log, "bool", obj.boolean4, remote.getBool());
		remote.setByte(obj.byte4);
		TestUtils.assertEquals(log, "byte", obj.byte4, remote.getByte());
		remote.setChar(obj.char4);
		TestUtils.assertEquals(log, "char", obj.char4, remote.getChar());
		remote.setShort(obj.short4);
		TestUtils.assertEquals(log, "short", obj.short4, remote.getShort());
		remote.setInt(obj.int4);
		TestUtils.assertEquals(log,  "int", obj.int4, remote.getInt());
		remote.setLong(obj.long4);
		TestUtils.assertEquals(log, "long", obj.long4, remote.getLong());
		remote.setFloat(obj.float4);
		TestUtils.assertEquals(log,  "float", obj.float4, remote.getFloat());
		remote.setDouble(obj.double4);
		TestUtils.assertEquals(log,  "double", obj.double4, remote.getDouble());
		remote.setString(obj.string4);
		TestUtils.assertEquals(log,  "String", obj.string4, remote.getString());
		remote.setDate(date4);
		TestUtils.assertEquals(log, "date", date4, remote.getDate());
		
		remote.setPrimitiveTypes(obj.primitiveTypes4);
		TestUtils.assertEquals(log,  "PrimitiveTypes", obj.primitiveTypes4, remote.getPrimitiveTypes());
		
		remote.setObject(object4);
		TestUtils.assertEquals(log,  "Object", object4, remote.getObject());
		
		log.info(")testRemoteArrayTypes4dim");
	});

});