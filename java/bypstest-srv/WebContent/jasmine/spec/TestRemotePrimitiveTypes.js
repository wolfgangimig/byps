describe("Tests for sending and receiving primitive types.", function() {
   
	var remote = {};
	
	beforeEach(function() {
		remote = client.remotePrimitiveTypes;
	});

    it("testOmitTransientMembers", function() {
    	
    	var obj = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
    	obj.temp = "transient member";
    	
    	remote.setObject(obj);
    	
    	var obj2 = remote.getObject();

        expect(obj2.temp).toBe(undefined);
    });
    
    it("testRemotePrimitiveTypes", function() {
		log.info("testRemotePrimitiveTypes(");
    	
		remote.setBool(true);
		TestUtils.assertEquals(log, "bool", true, remote.getBool());
		remote.setBool(false);
		TestUtils.assertEquals(log, "bool", false, remote.getBool());
		remote.setByte(11);
		TestUtils.assertEquals(log, "byte", 11, remote.getByte());
		remote.setChar('€');
		TestUtils.assertEquals(log, "char", '€', remote.getChar());
		remote.setShort(1234);
		TestUtils.assertEquals(log, "short", 1234, remote.getShort());
		remote.setInt(5678);
		TestUtils.assertEquals(log,  "int", 5678, remote.getInt());
		remote.setLong("890");
		TestUtils.assertEquals(log, "long", "890", remote.getLong());
		remote.setLong(890);
		TestUtils.assertEquals(log, "long", "890", remote.getLong());
		remote.setFloat(1.2);
		TestUtils.assertEquals(log,  "float", 1.2, remote.getFloat());
		remote.setDouble(1.8);
		TestUtils.assertEquals(log,  "double", 1.8, remote.getDouble());
		remote.setString("ABC");
		TestUtils.assertEquals(log,  "String", "ABC", remote.getString());
		
		var pt = TestUtils.createObjectPrimitiveTypes();
		remote.setObject(pt);
		TestUtils.assertEquals(log,  "Object", pt, remote.getObject());
		
		pt = TestUtils.createObjectPrimitiveTypes();
		remote.setPrimitiveTypes(pt);
		TestUtils.assertEquals(log,  "PrimitiveTypes", pt, remote.getPrimitiveTypes());

		log.info(")testRemotePrimitiveTypes");
    });

    it("testRemotePrimitiveTypesSendAll" , function() {
		log.info("testRemotePrimitiveTypesSendAll(");
		
		var pt = TestUtils.createObjectPrimitiveTypes();
		var pt2  =TestUtils.createObjectPrimitiveTypes();
		
		remote.sendAllTypes(true, 'Q', 34, 56, 45, 7.4, 9.8, "23", pt, pt2);
		
		TestUtils.assertEquals(log, "bool", true, remote.getBool());
		TestUtils.assertEquals(log, "char", 'Q', remote.getChar());
		TestUtils.assertEquals(log, "short", 34, remote.getShort());
		TestUtils.assertEquals(log,  "int", 56, remote.getInt());
		TestUtils.assertEquals(log, "long", "45", remote.getLong());
		TestUtils.assertEquals(log,  "float", 7.4, remote.getFloat());
		TestUtils.assertEquals(log,  "double", 9.8, remote.getDouble());
		TestUtils.assertEquals(log,  "String", "23", remote.getString());
		TestUtils.assertEquals(log,  "PrimtitiveTypes", pt, remote.getPrimitiveTypes());
		TestUtils.assertEquals(log,  "Object", pt2, remote.getObject());

		log.info(")testRemotePrimitiveTypesSendAll");
    });
    
    it("testPrimitiveTypesReferenceToOtherObject" , function() {
		log.info("testPrimitiveTypesReferenceToOtherObject(");

		var obj1 = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj1.intVal = 123;
		obj1.doubleVal = 0.0;
		obj1.objVal = obj1.objVal2 = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj1.objVal.intVal = 456;
		
		remote.setPrimitiveTypes(obj1);
		var objR = remote.getPrimitiveTypes();
		
		TestUtils.assertEquals(log,  "PrimitiveTypes", obj1, objR);
		TestUtils.assertTrue(log, "this.objVal != this.objVal2", objR.objVal === objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToOtherObject");
    });
    
    it("testPrimitiveTypesReferenceToSelf" , function() {
		log.info("testPrimitiveTypesReferenceToSelf(");

		var obj1 = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = obj1;
		
		remote.setPrimitiveTypes(obj1);
		var objR = remote.getPrimitiveTypes();
		
		TestUtils.assertTrue(log, "this != this.objVal", objR === objR.objVal);
		TestUtils.assertTrue(log, "this != this.objVal2", objR === objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToSelf");
    });

    
});