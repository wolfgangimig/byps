describe("Tests for serializing inline objects.", function() {
   
	var transport = {};
	
	beforeEach(function() {
		transport = client.transport;
	});

	it("testSerializeInlineInstance", function() {
		log.info("testSerializeInlineInstance(");
		
		var obj = new com.wilutions.byps.test.api.inl.Actor();
		obj.position = new com.wilutions.byps.test.api.inl.Matrix2D();
		obj.position._11 = 1.1;
		obj.position._22 = 2.2;
		obj.position._33 = 3.3;
		obj.shape = [];
		for (var i = 0; i < obj.shape.length; i++) {
			obj.shape[i] = new Point2D();
			obj.shape[i].x = i;
			obj.shape[i].y = (i*i);
		}
		
		internalTestSerializeInlineInstance(obj);

		log.info(")testSerializeInlineInstance");
	});
	
	var internalTestSerializeInlineInstance = function(obj) {
		log.info("internalTestSerializeInlineInstance(");
		
		var bout = transport.getOutput();
		var msg = bout.store(obj);
		
		var bin = transport.getInput(msg.jsonText);
		var objR = bin.load();
		
		TestUtils.assertEquals(log, "obj", obj, objR);
		
		log.info(")internalTestSerializeInlineInstance");
		return objR;
	};

	
});