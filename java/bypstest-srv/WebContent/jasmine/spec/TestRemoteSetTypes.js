describe("Tests for sending and receiving set types.", function() {
   
	var remote = {};
	
	beforeEach(function() {
		remote = client.remoteSetTypes;
	});
	
	var sortSet = function(set) {
		return set.sort();
	};

    it("testRemoteSetTypes", function() {
    	
		log.info("testRemoteSetTypes(");
		
		var obj = new com.wilutions.byps.test.api.set.SetTypes();
		obj.boolean1 = [true, false];
		obj.byte1 = [1,2,3];
		obj.char1 = ['a', 'b'];
		obj.double1 = [0.0, 0.1, 0.2];
		obj.float1 = [1, 2, 3, 4];
		obj.int1 = [1, 2, 3, 4, 5];
		obj.long1 = ["1.", "2.", "3.", "4.", "5.", "6."];
		obj.primitiveTypes1 = [TestUtils.createObjectPrimitiveTypes()];
		obj.short1 = [1];
		obj.string1 = ["a", "b", "c"];
		obj.obj1 = [TestUtils.createObjectPrimitiveTypes()];
		
		remote.setBoolean1(obj.boolean1);
		TestUtils.assertEquals(log, "boolean1", sortSet(obj.boolean1), sortSet(remote.getBoolean1()));
		remote.setByte1(obj.byte1);
		TestUtils.assertEquals(log, "byte1", sortSet(obj.byte1), sortSet(remote.getByte1()));
		remote.setChar1(obj.char1);
		TestUtils.assertEquals(log, "char1", sortSet(obj.char1), sortSet(remote.getChar1()));
		remote.setDouble1(obj.double1);
		TestUtils.assertEquals(log, "double1", sortSet(obj.double1), sortSet(remote.getDouble1()));
		remote.setFloat1(obj.float1);
		TestUtils.assertEquals(log, "float1", sortSet(obj.float1), sortSet(remote.getFloat1()));
		remote.setInt1(obj.int1);
		TestUtils.assertEquals(log, "int1", sortSet(obj.int1), sortSet(remote.getInt1()));
		remote.setLong1(obj.long1);
		TestUtils.assertEquals(log, "long1", sortSet(obj.long1), sortSet(remote.getLong1()));
		remote.setPrimitiveTypes1(obj.primitiveTypes1);
		TestUtils.assertEquals(log, "primitiveTypes1", sortSet(obj.primitiveTypes1), sortSet(remote.getPrimitiveTypes1()));
		remote.setShort1(obj.short1);
		TestUtils.assertEquals(log, "short1", sortSet(obj.short1), sortSet(remote.getShort1()));
		remote.setString1(obj.string1);
		TestUtils.assertEquals(log, "string1", sortSet(obj.string1), sortSet(remote.getString1()));
		remote.setObj1(obj.obj1);
		TestUtils.assertEquals(log, "obj1", sortSet(obj.obj1), sortSet(remote.getObj1()));
		
		log.info(")testRemoteSetTypes");
    });
   
	
});