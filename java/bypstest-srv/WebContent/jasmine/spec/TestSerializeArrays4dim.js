describe("Tests for serializing 4-dim array types.", function() {
   
	var transport = {};
	
	beforeEach(function() {
		transport = client.transport;
	});

	/**
	 * Test with null values for all 1-dimensional Arrays.
	 */
    it("testArrayTypes4dimNull", function() {
		log.info("testArrayTypes4dimNull(");

		var bout = transport.getOutput();
		
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		var msg = bout.store(obj);
		
		var bin = transport.getInput(msg.jsonText);
		var objR = bin.load();
		
		TestUtils.assertEquals(log, "", obj, objR);
    	
		log.info(")testArrayTypes4dimNull");
    });
    
    
	/**
	 * Test with null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	it("testArrayTypes4dimEmpty", function() {
		log.info("testArrayTypes4dimEmpty(");
		
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.boolean4 = [[[[]]]];
		obj.byte4 = [[[[]]]];
		obj.char4 = [[[[]]]];
		obj.double4 = [[[[]]]];
		obj.float4 = [[[[]]]];
		obj.int4 = [[[[]]]];
		obj.long4 = [[[[]]]];
		obj.primitiveTypes4 = [[[[]]]];
		obj.short4 = [[[[]]]];
		obj.string4 = [[[[]]]];

		internalTestSerializeArrayTypes4dim(obj);
		
		log.info(")testArrayTypes4dimEmpty");
	});
	
	internalTestSerializeArrayTypes4dim = function(obj) {
		var bout = transport.getOutput();
		var msg = bout.store(obj);
		var bin = transport.getInput(msg.jsonText);
		var objR = bin.load();
		TestUtils.assertEquals(log, "", obj, objR);
	};
	
	/**
	 * Test with none-null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	it("testArrayTypes4dimNotNull", function() {
		log.info("testArrayTypes4dimNotNull(");
		
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.boolean4 = [[[[true]]]];
		obj.byte4 = [[[[1,2,3]]]];
		obj.char4 = [[[['a','b','c']]]];
		obj.double4 = [[[[2.2]]]];
		obj.float4 = [[[[3.3]]]];
		obj.int4 = [[[[1,2,3,4,5]]]];
		obj.long4 = [[[[1,2,3,4,5,6]]]];
		obj.primitiveTypes4 = [[[[ TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ]]]];
		obj.short4 = [[[[1,2,3,4,5,6,7]]]];
		obj.string4 = [[[["a", "b", "c"]]]];

		internalTestSerializeArrayTypes4dim(obj);
		
		log.info(")testArrayTypes4dimNotNull");
	});

	it("testArrayTypes4dimBoolean", function() {
		log.info("testArrayTypes4dimBoolean(");
		internalTestArrayTypes4dimBoolean(
			[
				 [[
						[false, false, false, false ],
						[false, false, false, true ],
						[false, false, true, false ],
						[false, false, true, true ],
					],[
						[false, true, false, false ],
						[false, true, false, true ],
						[false, true, true, false ],
						[false, true, true, true ],
				]],[[
						[true, false, false, false ],
						[true, false, false, true ],
						[true, false, true, false ],
						[true, false, true, true ],
					],[
						[true, true, false, false ],
						[true, true, false, true ],
						[true, true, true, false ],
						[true, true, true, true ],
				]]
			]);

		internalTestArrayTypes4dimBoolean([[[[]]]]);
		internalTestArrayTypes4dimBoolean([[[[true]]]]);
		internalTestArrayTypes4dimBoolean([[[[false]]]]);
		log.info(")testArrayTypes4dimBoolean");
	});

	internalTestArrayTypes4dimBoolean = function(arr) {
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.boolean4 = arr;
		internalTestSerializeArrayTypes4dim(obj);
	};

	it("testArrayTypes4dimChar", function() {
		log.info("testArrayTypes4dimChar(");
		internalTestArrayTypes4dimChar(
			[[[
						['a', 'a', 'a', 'a' ],
						['a', 'a', 'a', 'b' ],
						['a', 'a', 'b', 'a' ],
						['a', 'a', 'b', 'b' ],
					],[
						['a', 'b', 'a', 'a' ],
						['a', 'b', 'a', 'b' ],
						['a', 'b', 'b', 'a' ],
						['a', 'b', 'b', 'b' ],
				]],[[
						['b', 'a', 'a', 'a' ],
						['b', 'a', 'a', 'b' ],
						['b', 'a', 'b', 'a' ],
						['b', 'a', 'b', 'b' ],
					],[
						['b', 'b', 'a', 'a' ],
						['b', 'b', 'a', 'b' ],
						['b', 'b', 'b', 'a' ],
						['b', 'b', 'b', 'b' ],
			]]]);
		
		internalTestArrayTypes4dimChar([[[[]]]]);
		internalTestArrayTypes4dimChar([[[[0]]]]);
		internalTestArrayTypes4dimChar([[[[111]]]]);
		log.info(")testArrayTypes4dimChar");
	});

	internalTestArrayTypes4dimChar = function(arr) {
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.char4 = arr;
		internalTestSerializeArrayTypes4dim(obj);
	};

	it("testArrayTypes4dimInt", function() {
		log.info("testArrayTypes4dimInt(");
		internalTestArrayTypes4dimInt(
			 [[[
						[-1, -1, -1, -1 ],
						[-1, -1, -1, +1 ],
						[-1, -1, +1, -1 ],
						[-1, -1, +1, +1 ],
					],[
						[-1, +1, -1, -1 ],
						[-1, +1, -1, +1 ],
						[-1, +1, +1, -1 ],
						[-1, +1, +1, +1 ],
				]],[[
						[+1, -1, -1, -1 ],
						[+1, -1, -1, +1 ],
						[+1, -1, +1, -1 ],
						[+1, -1, +1, +1 ],
					],[
						[+1, +1, -1, -1 ],
						[+1, +1, -1, +1 ],
						[+1, +1, +1, -1 ],
						[+1, +1, +1, +1 ],
			]]]);
		
		internalTestArrayTypes4dimInt([[[[]]]]);
		internalTestArrayTypes4dimInt([[[[0]]]]);
		internalTestArrayTypes4dimInt([[[[111]]]]);
		log.info(")testArrayTypes4dimInt");
	});

	internalTestArrayTypes4dimInt = function(arr) {
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.int4 = arr;
		internalTestSerializeArrayTypes4dim(obj);
	};

	it("testArrayTypes4dimLong", function() {
		log.info("testArrayTypes4dimLong(");
		internalTestArrayTypes4dimLong(
				 [[[
							[-1, -1, -1, -1 ],
							[-1, -1, -1, +1 ],
							[-1, -1, +1, -1 ],
							[-1, -1, +1, +1 ],
						],[
							[-1, +1, -1, -1 ],
							[-1, +1, -1, +1 ],
							[-1, +1, +1, -1 ],
							[-1, +1, +1, +1 ],
					]],[[
							[+1, -1, -1, -1 ],
							[+1, -1, -1, +1 ],
							[+1, -1, +1, -1 ],
							[+1, -1, +1, +1 ],
						],[
							[+1, +1, -1, -1 ],
							[+1, +1, -1, +1 ],
							[+1, +1, +1, -1 ],
							[+1, +1, +1, +1 ],
			]]]);
			
		internalTestArrayTypes4dimLong([[[[]]]]);
		internalTestArrayTypes4dimLong([[[[0]]]]);
		internalTestArrayTypes4dimLong([[[[111]]]]);
		log.info(")testArrayTypes4dimLong");
	});

	internalTestArrayTypes4dimLong = function(arr) {
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.long4 = arr;
		internalTestSerializeArrayTypes4dim(obj);
	};

	it("testArrayTypes4dimString", function() {
		log.info("testArrayTypes4dimString(");
		internalTestArrayTypes4dimString(
			[[[
						["-1", "-1", "-1", "-1" ],
						["-1", "-1", "-1", "+1" ],
						["-1", "-1", "+1", "-1" ],
						["-1", "-1", "+1", "+1" ],
					],[
						["-1", "+1", "-1", "-1" ],
						["-1", "+1", "-1", "+1" ],
						["-1", "+1", "+1", "-1" ],
						["-1", "+1", "+1", "+1" ],
				],],[[
						["+1", "-1", "-1", "-1" ],
						["+1", "-1", "-1", "+1" ],
						["+1", "-1", "+1", "-1" ],
						["+1", "-1", "+1", "+1" ],
					],[
						["+1", "+1", "-1", "-1" ],
						["+1", "+1", "-1", "+1" ],
						["+1", "+1", "+1", "-1" ],
						["+1", "+1", "+1", "+1" ],
			],]]);
		
		internalTestArrayTypes4dimString([[[[]]]]);
		internalTestArrayTypes4dimString([[[[""]]]]);
		internalTestArrayTypes4dimString([[[["1"]]]]);
		log.info(")testArrayTypes4dimString");
	});

	internalTestArrayTypes4dimString = function(arr) {
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.string4 = arr;
		internalTestSerializeArrayTypes4dim(obj);
	};

	it("testArrayTypes4dimPimitiveTypes", function() {
		log.info("testArrayTypes4dimPimitiveTypes(");
		internalTestArrayTypes4dimPrimitiveTypes(
			[[[
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
				],[
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
			],],[[
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
				],[
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
					[TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ],
			],]]);
		
		internalTestArrayTypes4dimPrimitiveTypes([[[[]]]]);
		internalTestArrayTypes4dimPrimitiveTypes([[[[null]]]]);
		internalTestArrayTypes4dimPrimitiveTypes([[[[TestUtils.createObjectPrimitiveTypes()]]]]);
		log.info(")testArrayTypes4dimPimitiveTypes");
	});

	internalTestArrayTypes4dimPrimitiveTypes = function(arr) {
		var obj = new com.wilutions.byps.test.api.arr.ArrayTypes4dim();
		obj.primitiveTypes4 = arr;
		internalTestSerializeArrayTypes4dim(obj);
	};

});