describe("Tests for serializing primitive types.", function() {
   
	var transport = {};
	
	beforeEach(function() {
		transport = client.transport;
	});

    it("testPrimitiveTypes", function() {
		log.info("testPrimitiveTypes(");
		
		var bout = transport.getOutput();
		
		var obj = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj.boolVal = true;
		obj.byteVal = 12;
		obj.charVal = 'D';
		obj.shortVal = 123;
		obj.intVal = -345;
		obj.longVal = 789;
		obj.floatVal = -1.23;
		obj.doubleVal = 3.45e-7;
		obj.stringVal = "abc€€def";
		
		var msg = bout.store(obj);
		
		var bin = client.transport.getInput(msg.jsonText);
		var objR = bin.load();
		
		TestUtils.assertEquals(log, "primitiveTypes", obj, objR);
		
		log.info(")testPrimitiveTypes");
    });
    
    
	var internalTestPrimitiveTypes = function(obj) {
		log.info("internalTestPrimitiveTypes(");
		
		var bout = transport.getOutput();
		var msg = bout.store(obj);
		
		var bin = transport.getInput(msg.jsonText);
		var objR = bin.load();
		
		TestUtils.assertEquals(log, "obj", obj, objR);
		
		log.info(")internalTestPrimitiveTypes");
		return objR;
	};

    it("testPrimitiveTypesReferenceToSelf", function() {
    	
		log.info("testPrimitiveTypesReferenceToSelf(");

		var obj1 = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = obj1;
		
		var objR = internalTestPrimitiveTypes(obj1);
		
		TestUtils.assertTrue(log, "this != this.objVal", objR == objR.objVal);
		TestUtils.assertTrue(log, "this != this.objVal2", objR == objR.objVal2);

		log.info(")testPrimitiveTypesReferenceToSelf");

    });
    
    it("testPrimitiveTypesReferenceToOtherObject", function() {
    	
		log.info("testPrimitiveTypesReferenceToOtherObject(");

		var obj1 = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj1.intVal = 123;
		obj1.objVal = obj1.objVal2 = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj1.objVal.intVal = 456;
		
		var objR = internalTestPrimitiveTypes(obj1);
		
		TestUtils.assertTrue(log, "this.objVal != this.objVal2", objR.objVal == objR.objVal2);
		
		log.info(")testPrimitiveTypesReferenceToOtherObject");

    });
    
    
    it("testSerializeDouble", function() {
		log.info("testSerializeDouble(");
		internalTestSerializeDouble(0.0); 
		internalTestSerializeDouble(1.0);
		internalTestSerializeDouble(-1.0);
		internalTestSerializeDouble(1.0e7);
		internalTestSerializeDouble(1.0e-7);
		internalTestSerializeDouble(2.0E5);
		
		// JSON does not support Infinity and NaN
//		internalTestSerializeDouble(Number.NEGATIVE_INFINITY); 
//		internalTestSerializeDouble(Number.POSITIVE_INFINITY); 
//		internalTestSerializeDouble(Number.NaN);
		
		log.info(")testSerializeDouble");
	});
	
	internalTestSerializeDouble = function(v) {
		log.info("internalTestSerializeDouble(" + v);
		var obj1 = new com.wilutions.byps.test.api.prim.PrimitiveTypes();
		obj1.doubleVal = v;
		internalTestPrimitiveTypes(obj1);
		log.info(")internalTestSerializeDouble");
	};

});