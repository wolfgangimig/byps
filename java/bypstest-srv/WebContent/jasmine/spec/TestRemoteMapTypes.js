describe("Tests for sending and receiving map types.", function() {
   
	var remote = {};
	
	beforeEach(function() {
		remote = client.remoteMapTypes;
	});
	
	var MyMap = function() {
		this.add = function(key, value) {
			this[key] = value;
			return this;
		};
	};

	it("testRemoteMapTypes", function() {
		log.info("testRemoteMapTypes(");
		
		var obj = new byps.test.api.map.MapTypes();
		obj.boolean1 = new MyMap().add("bool1", true).add("bool2", false);
		obj.byte1 = new MyMap().add(1.1, -1).add(2.1, -2);
		obj.char1 = new MyMap().add(-1.1, 'a').add(1.1e-1, 'b');
		obj.double1 = new MyMap().add(3, -1.0e12);
		obj.float1 = new MyMap().add('A', 1.3).add('¶', 2.3).add('€', -1.2468e-3);
		obj.int1 = new MyMap().add(1,2).add(2, 3);
		obj.long1 = new MyMap().add(-99, "-33.").add(99, "33.");
		obj.primitiveTypes1 = new MyMap().add(1, TestUtils.createObjectPrimitiveTypes()).add(2, TestUtils.createObjectPrimitiveTypes());
		obj.short1 = new MyMap().add(-55, 1234).add(0x55, 5555);
		obj.string1 = new MyMap().add("A", "a").add("B","b");

		remote.setBoolean1(obj.boolean1);
		TestUtils.assertEquals(log, "boolean1", obj.boolean1, remote.getBoolean1());
		remote.setByte1(obj.byte1);
		TestUtils.assertEquals(log, "byte1", obj.byte1, remote.getByte1());
		remote.setChar1(obj.char1);
		TestUtils.assertEquals(log, "char1", obj.char1, remote.getChar1());
		remote.setDouble1(obj.double1);
		TestUtils.assertEquals(log, "double1", obj.double1, remote.getDouble1());
		remote.setFloat1(obj.float1);
		TestUtils.assertEquals(log, "float1", obj.float1, remote.getFloat1());
		remote.setInt1(obj.int1);
		TestUtils.assertEquals(log, "int1", obj.int1, remote.getInt1());
		remote.setLong1(obj.long1);
		TestUtils.assertEquals(log, "long1", obj.long1, remote.getLong1());
		remote.setPrimitiveTypes1(obj.primitiveTypes1);
		TestUtils.assertEquals(log, "primitiveTypes1", obj.primitiveTypes1, remote.getPrimitiveTypes1());
		remote.setShort1(obj.short1);
		TestUtils.assertEquals(log, "short1", obj.short1, remote.getShort1());
		remote.setString1(obj.string1);
		TestUtils.assertEquals(log, "string1", obj.string1, remote.getString1());
		
		log.info(")testRemoteMapTypes");
	});

	
});

