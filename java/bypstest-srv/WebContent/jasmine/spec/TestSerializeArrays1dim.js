describe("Tests for serializing 1-dimensional array types.", function() {
   
	var transport = {};
	
	beforeEach(function() {
		transport = client.transport;
	});

	/**
	 * Test with null values for all arrays.
	 */
    it("testArrayTypes1dimNull", function() {
		log.info("testArrayTypes1dimNull(");

		var bout = transport.getOutput();
		
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		var msg = bout.store(obj);
		
		var bin = transport.getInput(msg.jsonText);
		var objR = bin.load();
		
		TestUtils.assertEquals(log, "", obj, objR);
    	
		log.info(")testArrayTypes1dimNull");
    });
    
    
	/**
	 * Test with null values for all 1-dimensional Arrays.
	 * @throws BException
	 */
	it("testArrayTypes1dimEmpty", function() {
		log.info("testArrayTypes1dimEmpty(");
		
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.boolean1 = [];
		obj.byte1 = [];
		obj.char1 = [];
		obj.double1 = [];
		obj.float1 = [];
		obj.int1 = [];
		obj.long1 = [];
		obj.primitiveTypes1 = [];
		obj.short1 = [];
		obj.string1 = [];
		obj.date1 = [];

		internalTestSerializeArrayTypes(obj);
		
		log.info(")testArrayTypes1dimEmpty");
	});
	
	internalTestSerializeArrayTypes = function(obj) {
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
	it("testArrayTypes1dimNotNull", function() {
		log.info("testArrayTypes1dimNotNull(");
		
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.boolean1 = [true];
		obj.byte1 = Base64.encode("abc");
		obj.char1 = ['a','b','c'];
		obj.double1 = [2.2];
		obj.float1 = [3.3];
		obj.int1 = [1,2,3,4,5];
		obj.long1 = [1,2,3,4,5,6];
		obj.primitiveTypes1 = [ TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes() ];
		obj.short1 = [1,2,3,4,5,6,7];
		obj.string1 = ["a", "b", "c"];
		obj.date1 = [new Date(), 0, new Date()];

		internalTestSerializeArrayTypes(obj);
		
		log.info(")testArrayTypes1dimNotNull");
	});

	it("testArrayTypes1dimBoolean", function() {
		log.info("testArrayTypes1dimBoolean(");
		internalTestArrayTypes1dimBoolean([true, false, true, false, true]);
		internalTestArrayTypes1dimBoolean([]);
		internalTestArrayTypes1dimBoolean([true]);
		internalTestArrayTypes1dimBoolean([false]);
		log.info(")testArrayTypes1dimBoolean");
	});

	internalTestArrayTypes1dimBoolean = function(arr) {
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.boolean1 = arr;
		internalTestSerializeArrayTypes(obj);
	};

	it("testArrayTypes1dimChar", function() {
		log.info("testArrayTypes1dimChar(");
		internalTestArrayTypes1dimChar(['a', '¶', '€' ]);
		internalTestArrayTypes1dimChar([]);
		internalTestArrayTypes1dimChar(['a']);
		internalTestArrayTypes1dimChar(['¶']);
		internalTestArrayTypes1dimChar(['€']);
		log.info(")testArrayTypes1dimChar");
	});

	internalTestArrayTypes1dimChar = function(arr) {
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.char1 = arr;
		internalTestSerializeArrayTypes(obj);
	};

	it("testArrayTypes1dimInt", function() {
		log.info("testArrayTypes1dimInt(");
		internalTestArrayTypes1dimInt([1, -1, 123, -123, 0xCDCDCDCD ]);
		internalTestArrayTypes1dimInt([]);
		internalTestArrayTypes1dimInt([1]);
		internalTestArrayTypes1dimInt([0]);
		log.info(")testArrayTypes1dimInt");
	});

	internalTestArrayTypes1dimInt = function(arr) {
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.int1 = arr;
		internalTestSerializeArrayTypes(obj);
	};

	it("testArrayTypes1dimLong", function() {
		log.info("testArrayTypes1dimLong(");
		internalTestArrayTypes1dimLong([1, -1, "123", -123, "0xCDCDCDCDCDCDCDCD" ]);
		internalTestArrayTypes1dimLong([]);
		internalTestArrayTypes1dimLong([1]);
		internalTestArrayTypes1dimLong([0]);
		log.info(")testArrayTypes1dimLong");
	});

	internalTestArrayTypes1dimLong = function(arr) {
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.long1 = arr;
		internalTestSerializeArrayTypes(obj);
	};

	it("testArrayTypes1dimString", function() {
		log.info("testArrayTypes1dimString(");
		internalTestArrayTypes1dimString(["a", "bc", "def", "€", "€a", "a€", "a€b", "¶", "¶a", "a¶", "a¶b" ]);
		internalTestArrayTypes1dimString([]);
		internalTestArrayTypes1dimString(["a"]);
		internalTestArrayTypes1dimString(["¶"]);
		internalTestArrayTypes1dimString(["€"]);
		log.info(")testArrayTypes1dimString");
	});

	it("testArrayTypes1dimSpecialStrings", function() {
		log.info("testArrayTypes1dimSpecialStrings(");
		
		internalTestArrayTypes1dimString(["'"]);
		internalTestArrayTypes1dimString(["''"]);
		
		internalTestArrayTypes1dimString(["\""]);		
		internalTestArrayTypes1dimString(["\"\""]);
		
		var killstr = "<script>function() { alert(\"killed\"); }();</script>";
		internalTestArrayTypes1dimString([killstr]);		
		internalTestArrayTypes1dimString(["'" + killstr + "'"]);		
		
		internalTestArrayTypes1dimString(["<"]);		
		internalTestArrayTypes1dimString(["/>" + killstr + "<"]);			
		
		internalTestArrayTypes1dimString(["}," + killstr + ", {"]);			
		
		log.info(")testArrayTypes1dimSpecialStrings");
	});

	internalTestArrayTypes1dimString = function(arr) {
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.string1 = arr;
		internalTestSerializeArrayTypes(obj);
	};

	it("testArrayTypes1dimPimitiveTypes", function() {
		log.info("testArrayTypes1dimPimitiveTypes(");
		internalTestArrayTypes1dimPimitiveTypes([TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes(), TestUtils.createObjectPrimitiveTypes()]);
		internalTestArrayTypes1dimPimitiveTypes([TestUtils.createObjectPrimitiveTypes()]);
		internalTestArrayTypes1dimPimitiveTypes([]);
		internalTestArrayTypes1dimPimitiveTypes([null]);
		log.info(")testArrayTypes1dimPimitiveTypes");
	});

	internalTestArrayTypes1dimPimitiveTypes = function(arr) {
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.primitiveTypes1 = arr;
		internalTestSerializeArrayTypes(obj);
	};

	it("testArrayTypes1dimDate", function() {
		log.info("testArrayTypes1dimDate(");
		internalTestArrayTypes1dimDate([new Date(), new Date("1600-01-01 13:14:15.678")]);
		internalTestArrayTypes1dimDate([]);
		internalTestArrayTypes1dimDate([null]);
		log.info(")testArrayTypes1dimDate");
	});

	internalTestArrayTypes1dimDate = function(arr) {
		var obj = new byps.test.api.arr.ArrayTypes1dim();
		obj.date1 = arr;
		internalTestSerializeArrayTypes(obj);
	};


});