describe("Tests for receiving exceptions.", function() {
   
	var remote = {};
	
	beforeEach(function() {
		remote = client.remoteException;
	});


	it("testThrowBException", function() {
		log.info("testThrowBException(");
		try {
			remote.throwBException(123, "teststring");
			TestUtils.assertTrue(log, "Exception expected", false);
		}
		catch (e) {
			TestUtils.assertEquals(log, "code", 123, e.code);
			TestUtils.assertEquals(log, "msg", "teststring", e.msg);
			TestUtils.assertEquals(log, "details", "java.io.IOException: Hello IOException", e.details);
		}
		log.info(")testThrowBException");
		
	});
	
	it("testThrowFirstException", function() {
		log.info("testThrowFirstException(");
		try {
			remote.throwFirstException();
			TestUtils.assertTrue(log, "Exception expected", false);
		}
		catch (e) {
			log.info("cause=" + e.cause);
			log.info("strings=" + e.listOfStrings);
			
			var expectedCause = new com.wilutions.byps.test.api.remote.SecondException("illegal state thrown from MyRemoteException");
			TestUtils.assertEquals(log, "cause", expectedCause, e.cause);
			
			TestUtils.assertEquals(log, "string", ["string1", "string2"], e.listOfStrings);
		}
		log.info(")testThrowFirstException");
	});
	
	it("testThrowException", function() {
		log.info("testThrowException(");
		try {
			remote.throwException(1);
			TestUtils.assertTrue(log, "Exception expected", false);
		}
		catch (e) {
			TestUtils.assertEquals(log, "ex", new com.wilutions.byps.test.api.remote.FirstException(), e);
		}
		
		try {
			remote.throwException(2);
			TestUtils.assertTrue(log, "Exception expected", false);
		}
		catch (e) {
			TestUtils.assertEquals(log, "ex", new com.wilutions.byps.test.api.remote.SecondException(""), e);
		}
		log.info(")testThrowException");
	});
	
	it("testThrowNPE", function() {
		log.info("testThrowNPE(");
		try {
			remote.throwNullPointerException();
			TestUtils.assertTrue(log, "Exception expected", false);
		}
		catch (e) {
			TestUtils.assertEquals(log, "code", com.wilutions.byps.BExceptionC.REMOTE_ERROR, e.code);
			TestUtils.assertEquals(log, "msg", "", e.msg);
			TestUtils.assertEquals(log, "details", "java.lang.NullPointerException", e.details);
		}
		log.info(")testThrowNPE");
		
	});

});