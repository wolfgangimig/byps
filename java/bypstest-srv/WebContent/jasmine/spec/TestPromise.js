describe("Tests using HTML5 Promise for asynchronous requests.", function() {

	beforeEach(function() {
		byps.initPromiseDefaultImpl();
	});

	afterEach(function() {
		byps.createPromise = null;
	});
	
	var client2 = null;
	var exceptionAsync = null;
	var receivedArray = null;
	var arr = [true,false,true,false];

	var createClient = function() {
		var url = "/bypstest-srv/bypsservlet";
		var wire = new byps.BWireClient(url);
		var transportFactory = new byps.BTransportFactory(
				byps.test.api.BApiDescriptor_Testser.instance(), wire, 1);
		client2 = new byps.test.api.BClient_Testser(transportFactory);
		var promise = client2.start();
		return promise;
	}
	
	var getsetBoolArrayAsync = function() {
		
		createClient().then(function(client2) {
			return client2.remoteArrayTypes1dim.setBool(arr);
			
		}).then(function(ignored) {
			return client2.remoteArrayTypes1dim.getBool();
			
		}).then(function(rarr) {
			receivedArray = rarr;
			
		}).catch(function(ex) {
			TestUtils.fail(ex);
			
		}).then(function() {
			client2.done();
		});
	}

	it("testPromise", function() {
		log.info("testPromise(");
		
		runs(function() {
			getsetBoolArrayAsync();
		}, "exec getsetBoolArrayAsync");
		
		waitsFor(function() {
			if (exceptionAsync) throw exceptionAsync;
			return receivedArray && arr.length == receivedArray.length;
		}, "Expected value must be " + arr.length, 5000);
			
		log.info(")testPromise");
	});

});