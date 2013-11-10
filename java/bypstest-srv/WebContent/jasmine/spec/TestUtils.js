var createCount = 0;

var log = {
	info : function() {},
	error : function() {}
};

var TestUtils = {
	assertEquals : function(log, msg, expectedValue, readValue) {
		
	    var nnull = function(v) {
    		if (typeof v === 'object') {
    			if (v["*nnull"]) return;
    			v["*nnull"] = true;
    	    	for (ename in v) {
    	    		var e = v[ename];
    	    		var t = typeof e;
    				if (e === undefined || e === null) {
    					delete v[ename];
    				}
    				else if (t === 'boolean' && !e) {
    					delete v[ename];
    				}
    				else if (t === 'function') {
    					delete v[ename];
    				}
    				else {
    					nnull(e);
    				}
    			}
    		}
    		return v;
	    };
	    
	    var removeNullTag = function(v) {
	   		if (typeof v === 'object') {
    			if (!v["*nnull"]) return;
    			delete v["*nnull"];
       	    	for (ename in v) {
       	    		var e = v[ename];
       	    		removeNullTag(e);
       	    	}
	   		}
	   		return v;
	    };
	    
	    var trimNulls = function(v) {
	    	v = nnull(v);
	    	v = removeNullTag(v);
	    	return v;
	    };
	    
	    expectedValue = trimNulls(expectedValue);
	    readValue = trimNulls(readValue);
	    
	    // So geht's nicht, weil die Objekte rekurive Referenzen enthalten können.
	    // Rekursionen können aber nicht mit JSON serialisiert werden.
//	    var strE = JSON.stringify(expectedValue);
//	    var strR = JSON.stringify(readValue);
//	    expectedValue = JSON.parse(strE);
//	    readValue = JSON.parse(strR);
	    
		expect(expectedValue).toEqual(readValue);
	},
	
	assertTrue : function(log, msg, val) {
		if (!val) {
			expect(val).toBe(true);
		}
	},
	
	fail : function(log, msg) {
		expect(msg).toBe(null);
	},
	
	createObjectPrimitiveTypes : function() {
		var p = new byps.test.api.prim.PrimitiveTypes();
		p.intVal = ++createCount;
		p.boolVal = (createCount & 1) != 0;
		p.byteVal = (createCount * 2) & 0x7F;
		p.shortVal = (createCount * 31);
		p.longVal = "" + (createCount * 129) + ".";
		p.floatVal = createCount + 0.2;
		p.doubleVal = createCount / 7.1;
		p.stringVal = "" + p.intVal;
		p.charVal = 'abcdefghijklmnopqrstuvwxyz'.charAt(createCount%26);
		p.dateVal = new Date();
		return p;
	}
};

