describe("Tests for sending and receiving inline types.", function() {
   
	var remote = {};
	
	beforeEach(function() {
		remote = client.remoteInlineInstance;
	});

	createActor = function() {
		var obj = new com.wilutions.byps.test.api.inl.Actor();
		obj.position = new com.wilutions.byps.test.api.inl.Matrix2D();
		obj.shape = [];
		for (var i = 0; i < obj.shape.length; i++) {
			obj.shape[i] = new com.wilutions.byps.test.api.inl.Point2D();
			obj.shape[i].x = (short)(i + 1);
			obj.shape[i].y = (short)(obj.shape[i].x * obj.shape[i].x);
		}
		return obj;
	};
	
	var x = 0;
	createPoint2D = function() {
		var obj = new com.wilutions.byps.test.api.inl.Point2D(x++,x*x);
		return obj;
	};

	it("testRemoteInlineInstance", function() {
		log.info("testRemoteInlineInstance(");
		
		var actor = createActor();
		remote.setActor(actor);
		
		TestUtils.assertEquals(log, "actor", actor, remote.getActor());
		
		log.info(")testRemoteInlineInstance");
	});
	
	it("testRemoteInlineInstanceArray1dim", function() {
		log.info("testRemoteInlineInstanceArray1dim(");
		
		var point2DArray = [createPoint2D(), createPoint2D()];
		remote.setPoint2DArray1dim(point2DArray);
		
		TestUtils.assertEquals(log, "actor", point2DArray, remote.getPoint2DArray1dim());
		
		log.info(")testRemoteInlineInstanceArray1dim");
	});

	it("testRemoteInlineInstanceArray4dim", function() {
		log.info("testRemoteInlineInstanceArray4dim(");
		
		var point2DArray = [[[[createPoint2D(), createPoint2D()]]]];
		remote.setPoint2DArray4dim(point2DArray);
		
		TestUtils.assertEquals(log, "point2D", point2DArray, remote.getPoint2DArray4dim());

		log.info(")testRemoteInlineInstanceArray4dim");
	});

	it("testRemoteInlineInstanceList", function() {
		log.info("testRemoteInlineInstanceList(");
		
		var point2DList = [];
		point2DList.push(createPoint2D());
		point2DList.push(createPoint2D());
		remote.setPoint2DList(point2DList);
		
		TestUtils.assertEquals(log, "point2D", point2DList, remote.getPoint2DList());
		
		log.info(")testRemoteInlineInstanceList");
	});

	it("testRemoteInlineInstanceListList", function() {
		log.info("testRemoteInlineInstanceListList(");
		
		var point2DListList = [];
		var point2DList = [];
		point2DListList.push(point2DList);
		point2DList.push(createPoint2D());
		point2DList.push(createPoint2D());
		remote.setPoint2DListList(point2DListList);
		
		TestUtils.assertEquals(log, "point2D", point2DListList, remote.getPoint2DListList());
		
		log.info(")testRemoteInlineInstanceListList");
	});

	it("testRemoteInlineInstanceMap", function() {
		log.info("testRemoteInlineInstanceMap(");

		var point2DMap = {};
		point2DMap[11] = createPoint2D();
		point2DMap[12] = createPoint2D();
		remote.setPoint2DMap(point2DMap);
		
		TestUtils.assertEquals(log, "point2D", point2DMap, remote.getPoint2DMap());

		log.info(")testRemoteInlineInstanceMap");
	});

    
});