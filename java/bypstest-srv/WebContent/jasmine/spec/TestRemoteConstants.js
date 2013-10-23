describe("Tests for comparing constants.", function() {
   
	beforeEach(function() {
	});

	it("testCompareConstants", function() {
		log.info("testCompareConstants(");

		var remote = client.remoteConstants;

        remote.compare_HebrewC(
        		byps.test.api.cons.HebrewC.ALEPH, 
        		byps.test.api.cons.HebrewC.BETH);

        remote.compare_AllTypesC(
            byps.test.api.cons.AllTypesC.bool1s,
            byps.test.api.cons.AllTypesC.bool2s,
            byps.test.api.cons.AllTypesC.char1s,
            byps.test.api.cons.AllTypesC.stringNull,
            byps.test.api.cons.AllTypesC.char2s,
            byps.test.api.cons.AllTypesC.short1s,
            byps.test.api.cons.AllTypesC.int1s,
            byps.test.api.cons.AllTypesC.long1s,
            byps.test.api.cons.AllTypesC.float1s,
            byps.test.api.cons.AllTypesC.double1s,
            byps.test.api.cons.AllTypesC.string1s,
            byps.test.api.cons.AllTypesC.ALL,
            byps.test.api.cons.AllTypesC.arrInt,
            byps.test.api.cons.AllTypesC.arrInt4,
            byps.test.api.cons.AllTypesC.arrStrings,
            byps.test.api.cons.AllTypesC.arrStrings4,
            byps.test.api.cons.AllTypesC.arrALL);
		
		log.info(")testCompareConstants");
	});

});