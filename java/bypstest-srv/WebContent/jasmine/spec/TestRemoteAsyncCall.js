describe("Tests for receiving results and exceptions asynchonously.", function() {
   
	
	beforeEach(function() {
	});
	
	var valueAsync = null;
	var exceptionAsync = null;
	
	var asyncSetGetInt = function() {
		
		var asyncResult = function(result, ex) {
			
			var asyncResult2 = function(result, ex) {
				valueAsync = result;
				exceptionAsync = ex;
			};
			
			client.remotePrimitiveTypes.getInt(asyncResult2);
		};
		
		client.remotePrimitiveTypes.setInt(1122, asyncResult);
	};

	it("testRemotePrimitiveTypesAsync", function() {
		log.info("testRemotePrimitiveTypesAsync(");

		runs(function() {
			asyncSetGetInt();
		}, "exec asyncGetSetInt");
		
		waitsFor(function() {
			if (exceptionAsync) throw exceptionAsync;
			return valueAsync == 1122;
		}, "Expected value must be 1122", 5000);
			
		log.info(")testRemotePrimitiveTypesAsync");
	});
	
    

});