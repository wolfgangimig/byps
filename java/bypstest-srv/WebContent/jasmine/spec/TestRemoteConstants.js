describe("Tests for comparing constants.", function() {
   
	beforeEach(function() {
	});

	it("testCompareConstants", function() {
		log.info("testCompareConstants(");

		var remote = client.remoteConstants;

        remote.compare_HebrewC(
        		com.wilutions.byps.test.api.cons.HebrewC.ALEPH, 
        		com.wilutions.byps.test.api.cons.HebrewC.BETH);

        remote.compare_AllTypesC(
            com.wilutions.byps.test.api.cons.AllTypesC.bool1s,
            com.wilutions.byps.test.api.cons.AllTypesC.bool2s,
            com.wilutions.byps.test.api.cons.AllTypesC.char1s,
            com.wilutions.byps.test.api.cons.AllTypesC.stringNull,
            com.wilutions.byps.test.api.cons.AllTypesC.char2s,
            com.wilutions.byps.test.api.cons.AllTypesC.short1s,
            com.wilutions.byps.test.api.cons.AllTypesC.int1s,
            com.wilutions.byps.test.api.cons.AllTypesC.long1s,
            com.wilutions.byps.test.api.cons.AllTypesC.float1s,
            com.wilutions.byps.test.api.cons.AllTypesC.double1s,
            com.wilutions.byps.test.api.cons.AllTypesC.string1s,
            com.wilutions.byps.test.api.cons.AllTypesC.ALL,
            com.wilutions.byps.test.api.cons.AllTypesC.arrInt,
            com.wilutions.byps.test.api.cons.AllTypesC.arrInt4,
            com.wilutions.byps.test.api.cons.AllTypesC.arrStrings,
            com.wilutions.byps.test.api.cons.AllTypesC.arrStrings4,
            com.wilutions.byps.test.api.cons.AllTypesC.arrALL);
		
		log.info(")testCompareConstants");
	});

});