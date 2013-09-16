describe("Tests with authentication.", function() {

	var remote = {};

	var MyAuthentication = function(userName, pwd) {

		this.userName = userName;
		this.pwd = pwd;
		this.sess = null;

		this.authenticate = function(client, asyncResult) {

			var me = this;
			var processAsync = !!asyncResult;

			var outerResult = function(result, ex) {
				log.info("authenticate sess=" + sess + ", ex="
						+ ex);
				me.sess = result;
				if (asyncResult) {
					asyncResult(true, ex);
				}
			};

			var sess = client.remoteWithAuthentication.login(me.userName,
					me.pwd, processAsync ? outerResult : null);

			if (!processAsync) {
				this.sess = sess;
			}

			return sess;
		};

		this.isReloginException = function(client, ex, typeId) {
			return client.transport.isReloginException(ex, typeId);
		};

		this.getSession = function() {
			return this.sess;
		};

	};

	beforeEach(function() {
		remote = client.remoteWithAuthentication;
	});
	
	afterEach(function() {
		remote.expire();
	});

	/**
	 * Synchronous re-login test without BAuthentication object.
	 */
	it("testNoAuthObjectSupplied", function() {
		log.info("testNoAuthObjectSupplied(");

		var sess = remote.login("Fritz", "abc");
		log.info("sess=" + sess);

		log.info(")testNoAuthObjectSupplied");
	});

	/**
	 * Asynchronous re-login test without BAuthentication object.
	 */
	it("testNoAuthObjectSuppliedAsync", function() {
		log.info("testNoAuthObjectSuppliedAsync(");

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