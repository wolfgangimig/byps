describe("Tests for sending and receiving list types.", function() {
   
	var remote = {};
	
	beforeEach(function() {
		remote = client.remoteListTypes;
	});

    it("testRemoteListTypes", function() {
    	
		log.info("testRemoteListTypes(");
		
		var obj = new byps.test.api.list.ListTypes();
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
		obj.date1 = [new Date(), null, new Date()];
		
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
		remote.setObj1(obj.obj1);
		TestUtils.assertEquals(log, "obj1", obj.obj1, remote.getObj1());
		remote.setDate1(obj.date1);
		TestUtils.assertEquals(log, "date1", obj.date1, remote.getDate1());
		
		log.info(")testRemoteListTypes");
    });
   
	it("testRemoteListListInteger", function() {
		log.info("testRemoteListListInteger(");
		
		var obj = new byps.test.api.list.ListListTypes();
		var list = [];
		for (var i = 0; i < 3; i++) {
			var itemList = [];
			for (var j = 0; j < i+1; j++) {
				itemList.push(j);
			}
			list.push(itemList);
		}
		obj.int2 = list;
		
		remote.setInt3(obj.int2);
		TestUtils.assertEquals(log, "int3", obj.int2, remote.getInt3());
		
		log.info(")testRemoteListListInteger");
	});
    
	
	it("testRemoteListMapSetListInteger", function() {
		log.info("testRemoteListMapSetListInteger(");
		
		var obj = new byps.test.api.list.ListListTypes();
		var list = []; //new ArrayList<Map<Integer,List<Set<Integer>>>>();
		
		for (var i = 0; i < 2; i++) {
			var map = {}; // new HashMap<Integer,List<Set<Integer>>>();
			for (var j = 0; j < 3; j++) {
				var arr = []; // new ArrayList<Set<Integer>>();
				for (var k = 0; k < 4; k++) {
					var set = []; //new HashSet<Integer>();
					for (var n = 0; n < 5; n++) {
						var pt = (i+1) * (j+1) * (k+1) * (n+1);
						set.push(pt);
					}
					arr.push(set);
				}
				map[j] = arr;
			}
			list.push(map);
		}
		obj.int3 = list;
		
		remote.setInt4(obj.int3);
		TestUtils.assertEquals(log, "int4", obj.int3, remote.getInt4());
		
		log.info(")testRemoteListMapSetListInteger");
	});

	
});