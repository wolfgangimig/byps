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

		this.getSession = function(client, typeId, asyncResult) {
			if (asyncResult) {
				asyncResult(this.sess, null);
			}
			return this.sess;
		};

	};
	
	var MyAuthenticationCausesRecursion = function() {
		
		this.authenticate = function(client, asyncResult) {

			var outerResult = function(result, ex) {
				asyncResult(null, ex);
			};

			client.remoteWithAuthentication.doit(1, outerResult);
		};

		this.isReloginException = function(client, ex, typeId) {
			return client.transport.isReloginException(ex, typeId);
		};

		this.getSession = function(client, typeId, asyncResult) {
			if (asyncResult) {
				asyncResult(null, null);
			}
			return null;
		};
		
	};

	var MyAuthenticationTooSlow = function(userName, pwd, waitMillis) {

		this.userName = userName;
		this.pwd = pwd;
		this.sess = null;
		this.waitMillis = waitMillis;

		this.authenticate = function(client, asyncResult) {

			var me = this;

			var callback = function() {
				
				var outerResult = function(result, ex) {
					me.sess = result;
					asyncResult(null, ex);
				};
				
				client.remoteWithAuthentication.login(me.userName, me.pwd, outerResult);
			};
			
			window.setTimeout(callback, waitMillis);

		};

		this.isReloginException = function(client, ex, typeId) {
			return client.transport.isReloginException(ex, typeId);
		};

		this.getSession = function(client, typeId, asyncResult) {
			if (asyncResult) {
				asyncResult(this.sess, null);
			}
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

    /**
     * Test with an authentication class that 
     * This must not cause an endless loop or a stack overflow.
     * @throws RemoteException
     */
	it("testAuthenticateBlocksRecursion", function() {
		log.info("testAuthenticateBlocksRecursion(");

		var exception = null;
		var result = null;

		runs(function() {
			
			client.done(function() {
				
				client.setAuthentication(new MyAuthenticationCausesRecursion());
				
				remote.doit(1, function(ret, ex) {
					result = ret;
					exception = ex;
				});
			});			
		});
		
		waitsFor(function() {
			if (result) throw "Excpected exception";
			var succ = exception && exception.code == byps.BExceptionC.FORBIDDEN;
			log.info(")testAuthenticateBlocksRecursion");
			return succ;
		}, "Expected exception 403", 10 * 1000);

	});

	  /**
	   * Test with an authentication class that performs too slow,
	   * so that the application server session gets invalid during
	   * authentication.
	   * This must not cause an endless loop or a stack overflow. 
	   * It results in a 403 error.
	   * @throws RemoteException
	   */
	it("testAuthenticationTooSlow", function() {
		log.info("testAuthenticationTooSlow(");

		var exception = null;
		var result = null;

		runs(function() {
			
			client.done(function() {
				
				var auth = new MyAuthenticationTooSlow("Fritz", "abc", 11 * 1000);
				client.setAuthentication(auth);
				
				remote.doit(1, function(ret, ex) {
					result = ret;
					exception = ex;
				});
			});			
		});
		
		waitsFor(function() {
			if (result) throw "Excpected exception";
			var succ= exception && exception.code == byps.BExceptionC.FORBIDDEN;
			log.info(")testAuthenticationTooSlow");
			return succ;
		}, "Expected exception 403", 20 * 1000);
		
	});

});