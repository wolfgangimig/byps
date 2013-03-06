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

	it("testRemoteInlineInstance", function() {
		log.info("testRemoteInlineInstance(");
		
		var actor = createActor();
		remote.setActor(actor);
		
		TestUtils.assertEquals(log, "actor", actor, remote.getActor());
		
		log.info(")testRemoteInlineInstance");
	});
	
	it("testRemoteInlineInstanceArray1dim", function() {
		log.info("testRemoteInlineInstanceArray1dim(");
		
		var actorArray = [createActor(), createActor()];
		remote.setActorArray1dim(actorArray);
		
		TestUtils.assertEquals(log, "actor", actorArray, remote.getActorArray1dim());
		
		log.info(")testRemoteInlineInstanceArray1dim");
	});

	it("testRemoteInlineInstanceArray4dim", function() {
		log.info("testRemoteInlineInstanceArray4dim(");
		
		var actorArray = [[[[createActor(), createActor()]]]];
		remote.setActorArray4dim(actorArray);
		
		TestUtils.assertEquals(log, "actor", actorArray, remote.getActorArray4dim());
		
		log.info(")testRemoteInlineInstanceArray4dim");
	});

	it("testRemoteInlineInstanceList", function() {
		log.info("testRemoteInlineInstanceList(");
		
		var actorList = [];
		actorList.push(createActor());
		actorList.push(createActor());
		remote.setActorList(actorList);
		
		TestUtils.assertEquals(log, "actor", actorList, remote.getActorList());
		
		log.info(")testRemoteInlineInstanceList");
	});

	it("testRemoteInlineInstanceListList", function() {
		log.info("testRemoteInlineInstanceListList(");
		
		var actorListList = [];
		var actorList = [];
		actorListList.push(actorList);
		actorList.push(createActor());
		actorList.push(createActor());
		remote.setActorListList(actorListList);
		
		TestUtils.assertEquals(log, "actor", actorListList, remote.getActorListList());
		
		log.info(")testRemoteInlineInstanceListList");
	});

	it("testRemoteInlineInstanceSet", function() {
		log.info("testRemoteInlineInstanceSet(");
		
		var actorSet = [];
		actorSet.push(createActor());
		actorSet.push(createActor());
		remote.setActorSet(actorSet);
		
		TestUtils.assertEquals(log, "actor", actorSet, remote.getActorSet());
		
		log.info(")testRemoteInlineInstanceSet");
	});

	it("testRemoteInlineInstanceMap", function() {
		log.info("testRemoteInlineInstanceMap(");
		
		var actorMap = {};
		actorMap[11] = createActor();
		actorMap[12] = createActor();
		remote.setActorMap(actorMap);
		
		TestUtils.assertEquals(log, "actor", actorMap, remote.getActorMap());
		
		log.info(")testRemoteInlineInstanceMap");
	});

    
});