describe("Tests with authentication.", function() {

	var remote = {};

	var MyAuthentication = function(userName, pwd) {

		this.userName = userName;
		this.pwd = pwd;
		this.sess = null;

		this.authenticate = function(client, asyncResult, processAsync) {
			
			var me = this;
			var outerResult = null;

			if (processAsync) {
				outerResult = function(result, ex) {
					log.info("authenticate sess=" + sess + ", ex="
							+ ex);
					me.sess = result;
					asyncResult(true, ex);
				};
			}

			var sess = null;
			var ex = null;
			try {
				sess = client.remoteWithAuthentication.login(me.userName, me.pwd, outerResult);
			}
			catch (e) {
				ex = e;
			}

			if (!processAsync) {
				me.sess = sess;
				log.info("authenticate: sess=" + sess + ", ex=" + ex);
				asyncResult(!ex, ex);
			}

		};

		this.isReloginException = function(client, ex, typeId) {
			return client.transport.isReloginException(ex, typeId);
		};

		this.getSession = function(client, typeId, asyncResult) {
			if (asyncResult) {
				asyncResult(this.sess, null);
			}
			log.info("getSession: sess=" + this.sess);
			return this.sess;
		};

	};
	
	beforeEach(function() {
		remote = client.remoteWithAuthentication;
		remote.setUseAuthentication(true);
	});
	
	afterEach(function() {
		client.setAuthentication(null);
		remote.setUseAuthentication(false);
		remote.expire();
	});

	/**
	 * Synchronous re-login test without BAuthentication object.
	 */
	it("testNoAuthObjectSupplied", function() {
		log.info("testNoAuthObjectSupplied(");

		client.setAuthentication(null);
		var sess = remote.login("Fritz", "abc");
		log.info("sess=" + sess);

		log.info(")testNoAuthObjectSupplied");
	});

	/**
	 * Asynchronous re-login test without BAuthentication object.
	 */
	it("testNoAuthObjectSuppliedAsync", function() {
		log.info("testNoAuthObjectSuppliedAsync(");

		client.setAuthentication(null);
		
		var sessAsync = null;
		var exceptionAsync = null;

		runs(function() {
			remote.login("Fritz", "abc", function(sess, ex) {
				sessAsync = sess;
				exceptionAsync = ex;

				remote.expire();
			});
		}, "exec login");

		waitsFor(function() {
			if (exceptionAsync)
				throw exceptionAsync;
			return !!sessAsync && sessAsync.sessionID == "123";
		}, "Expected value must be 123", 5000);

		log.info(")testNoAuthObjectSuppliedAsync");
	});

	/**
	 * Synchronous re-login test with BAuthentication object.
	 */
	it("testAuthenticate", function() {
		log.info("testAuthenticate(");

		client.setAuthentication(new MyAuthentication("Fritz", "abc"));
		
		// This method call will fail internally the first time with a
		// BExceptionC.AUTHENTICATION_REQUIRED.
		// Then, BTranpsport invokes MyAuthentication.authenticate and retries
		// the
		// method call.
		var ret = remote.doit(1);
		TestUtils.assertEquals(log, "ret", 2, ret);

		log.info(")testAuthenticate");
	});

	/**
	 * Asynchronous re-login test with BAuthentication object.
	 */
	it("testAuthenticateAsync", function() {
		log.info("testAuthenticateAsync(");

		client.setAuthentication(new MyAuthentication("Fritz", "abc"));

		var valueAsync = null;
		var exceptionAsync = null;

		runs(function() {
			remote.doit(1, function(ret, ex) {
				valueAsync = ret;
				exceptionAsync = ex;
			});
		}, "exec doit");

		waitsFor(function() {
			if (exceptionAsync)
				throw exceptionAsync;
			return !!valueAsync && valueAsync == 2;
		}, "Expected value must be 2", 5000);

		log.info(")testAuthenticateAsync");
	});

	/**
	 * Tests that a re-login is performed if the session was invalidated on the
	 * server.
	 * 
	 * @throws RemoteException
	 */
	it("testAuthenticateRelogin", function() {
		log.info("testAuthenticateRelogin(");

		client.setAuthentication(new MyAuthentication("Fritz", "abc"));

		// This method call will fail internally the first time with a
		// BExceptionO.AUTHENTICATION_REQUIRED.
		// Then, BTranpsport invokes MyAuthentication.authenticate and retries
		// the method call.
		var ret = remote.doit(1);
		TestUtils.assertEquals(log, "ret", 2, ret);

		// Invalidate session
		remote.expire();
		
		// Wait 1s
		var startTime = (new Date()).getTime();
		waitsFor(function() {

			var endTime = (new Date()).getTime();
			if (endTime - startTime >= 1000) {
				
				// Re-login
				ret = remote.doit(1);
				TestUtils.assertEquals(log, "ret", 2, ret);
				
				return true;
			}
			else {
				return false;
			}
		}, "wait 1s failed", 3000);


		log.info(")testAuthenticateRelogin");
	});

});