describe("Tests for receiving results and exceptions asynchonously.", function() {
   
	
	beforeEach(function() {
	});
	
	var valueR = null;
	var asyncSetGetInt = function() {
		
		var asyncResult = function(result, ex) {
			
			var asyncResult2 = function(result, ex) {
				if (result) {
					valueR = result;
				}
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
			return valueR == 1122;
		}, "Expected value must be 1122", 5000);
			
		log.info(")testRemotePrimitiveTypesAsync");
	});
	
    
	var asyncException = null;
	var asyncThrowException = function() {
		
		var asyncResult = function(result, exception) {
			asyncException = exception;
		};
		
		client.remoteException.throwBException(123, "teststring", asyncResult);
	};

	it("testThrowBExceptionAsync", function() {
		log.info("testThrowBExceptionAsync(");
		
		runs(function() {
			asyncThrowException();
		}, "exec asyncThrowException");
		
		waitsFor(function() {
			return asyncException && 
				asyncException.code == 123 &&
				asyncException.msg == "teststring" &&
				asyncException.details == "java.io.IOException: Hello IOException";
			
		}, "Expected exception", 5000);

		log.info(")testThrowBExceptionAsync");
		
	});

});