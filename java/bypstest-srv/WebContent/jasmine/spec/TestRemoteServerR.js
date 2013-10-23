describe("TestRemoteServerR", function() {
   
	/*
	 * How can I test function calls between tow clients?
	 * The clients must have different JSESSION IDs sent from the server as cookies.
	 * But the browser handles the cookies related to the web-page, so it's not possible
	 * to have multiple clients on the same web-page.
	 */
	
	var remote = {};
	
	beforeEach(function() {
		remote = client.serverIF;
	});

	// Implementation of ClientIF
	var ClientIFImpl = function() {

		this.incrementInt = function(a) {
			log.info("incrementInt(" + a + ")");
			return a+1;
		};
		
	};
	ClientIFImpl.prototype = new byps.test.api.srvr.BSkeleton_ClientIF();
	
	var incrResult = 0;
	var incrException = null;
	var asyncCallClientIncrementInt = function(value1) {
		log.info("asyncCallClientIncrementInt...");
		
		var asyncResult = function(result, exception) {
			incrResult = result;
			incrException = exception;
			log.info("asyncCallClientIncrementInt OK");
		};
		
		remote.callClientIncrementInt(value1, asyncResult);
	};

	/**
	 * The server tries to use a non-existing client interface implementation.
	 * This must cause an exception. The call must not hang.
	 * @throws BException
	 * @throws InterruptedException
	 */
	it("testCallClientFromServerNoRemoteImpl", function() {
		log.info("testCallClientFromServerNoRemoteImpl(");
		
		// Do not provide an implementation for the requested interface 
		// omit: client.addRemote(new BSkeleton_ClientIF() { ...
		
//		try {
//			remote.callClientIncrementInt(5);
//			TestUtils.fail(log, "Excpected exception.");
//		}
//		catch (ex) {
//			TestUtils.assertEquals(log, "ex", byps.BExceptionC.SERVICE_NOT_IMPLEMENTED, ex.code);
//		}
	
		runs(function() {
			asyncCallClientIncrementInt(5);
		}, "exec asyncCallClientIncrementInt");
		
		waitsFor(function() {
			return incrException && 
			incrException.code == byps.BExceptionC.SERVICE_NOT_IMPLEMENTED; 
		}, "expected exception=" + incrException, 5000);

		log.info(")testCallClientFromServerNoRemoteImpl");
	});

	/**
	 * Call a server function which in turn calls a client function.
	 * @throws BException
	 * @throws InterruptedException
	 */
	it("testCallClientFromServer", function() {
		log.info("testCallClientFromServer(");
		
		// (1) Provide implementation for interface ClientIF
		client.addRemote(new ClientIFImpl());
		
		// (2) Call server method. 
		// On the server, this method calls the client-side interface 
		// from step (1).
		// This must be an asynchronous request since JavaScript is single-threaded.
		runs(function() {
			asyncCallClientIncrementInt(5);
		}, "exec asyncCallClientIncrementInt");
		
		waitsFor(function() {
			return incrResult == 6; 
		}, "expected result == 6, exception=" + incrException, 5000);

		log.info(")testCallClientFromServer");
	});
	
	
	/**
	 * Call client1 interface from server-side of client1.
	 * This is another way to call the client-side from the server-side as 
	 * tested in testCallClientFromServer.
	 * It makes sure that all we can do with other client interfaces, we
	 * can do with the own client interface too.
	 * @throws BException
	 * @throws InterruptedException
	 * @see testCallClientFromServer
	 */
	it("testCallClient1FromServer1", function() {
		log.info("testCallClient1FromServer1(");
		
		// assign interface impl to client
		client.addRemote(new ClientIFImpl());
		
		// Pass the interface of the client to the server side 
		client.serverIF.setPartner(ClientIFImpl);
		
		// Invoke interface of client.
		runs(function() {
			asyncCallClientIncrementInt(7);
		}, "exec asyncCallClientIncrementInt");
		
		waitsFor(function() {
			return incrResult == 8; 
		}, "expected result == 8, exception=" + incrException, 5000);

		log.info(")testCallClient1FromServer1");
	});

});