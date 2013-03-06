package com.wilutions.byps.test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.wilutions.byps.BException;
import com.wilutions.byps.BInput;
import com.wilutions.byps.BOutput;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.test.api.enu.EnumPlanets;
import com.wilutions.byps.test.api.enu.UsePlanets;

/**
 * Tests serialization of Enum types.
 * 
 *
 */
public class TestSerializeEnum {

	private Log log = LogFactory.getLog(TestSerializeEnum.class);
	BTransport transport = TestUtils.createTransport();

	/**
	 * Enum values might be null in Java. 
	 * This must not cause an error. Null values have to be replaced by the first enum constant.
	 * @throws BException
	 */
	@Test
	public void testEnumNullValues() throws BException {
		log.info("testEnumNullValues(");
		UsePlanets obj = new UsePlanets();
		internalTestEnumValues(obj);
		log.info(")testEnumNullValues");
		
	}

	private void internalTestEnumValues(UsePlanets obj) throws BException {
		BOutput bout = transport.getOutput();
		
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		
		BInput bin = transport.getInput(null, buf);
		UsePlanets objR = (UsePlanets)bin.load();
		
		if (obj.planet == null) obj.planet = EnumPlanets.Mercury;
		if (obj.getPlanet2() == null) obj.setPlanet2(EnumPlanets.Mercury);
		
		if (obj.arrayOfPlanets != null) {
			for (int i = 0; i < obj.arrayOfPlanets.length; i++) {
				if (obj.arrayOfPlanets[i] == null) {
					obj.arrayOfPlanets[i] = EnumPlanets.Mercury;
				}
			}
		}

		if (obj.listOfPlanets != null) {
			for (int i = 0; i < obj.listOfPlanets.size(); i++) {
				if (obj.listOfPlanets.get(i) == null) {
					obj.listOfPlanets.set(i, EnumPlanets.Mercury);
				}
			}
		}

		// JavaScript erlaubt nur Number und String als Key-Typen
//		if (obj.mapKeyPlanets != null) {
//			for (EnumPlanets en : obj.mapKeyPlanets.keySet()) {
//				if (en == null) {
//					String value = obj.mapKeyPlanets.remove(en);
//					obj.mapKeyPlanets.put(EnumPlanets.Mercury, value);
//					break;
//				}
//			}
//		}

		if (obj.mapOfPlanets != null) {
			for (String k : obj.mapOfPlanets.keySet()) {
				EnumPlanets value = obj.mapOfPlanets.get(k);
				if (value == null) {
					obj.mapOfPlanets.put(k, EnumPlanets.Mercury);
				}
			}
		}

		TestUtils.assertEquals(log, "", obj, objR);
	}
	
	/**
	 * Test with non-null values.
	 * @throws BException
	 */
	@Test
	public void testEnumValues() throws BException {
		log.info("testEnumValues(");
		UsePlanets obj = new UsePlanets();
		obj.planet = EnumPlanets.Earth;
		obj.setPlanet2(EnumPlanets.Venus);
		internalTestEnumValues(obj);
		log.info(")testEnumValues");
	}
	
	/**
	 * Test List<Enum>. 
	 * Check handling of null-values.
	 * @throws BException
	 */
	@Test
	public void testListOfEnums() throws BException {
		log.info("testListOfEnums(");
		UsePlanets obj = new UsePlanets();
		obj.listOfPlanets = new ArrayList<EnumPlanets>();
		obj.listOfPlanets.add(null);
		obj.listOfPlanets.add(EnumPlanets.Earth);
		obj.listOfPlanets.add(EnumPlanets.Mercury);
		obj.listOfPlanets.add(EnumPlanets.Venus);
		internalTestEnumValues(obj);
		log.info(")testListOfEnums");
	}
	
	/**
	 * Test Enum[]. 
	 * Check handling of null-values.
	 * @throws BException
	 */
	@Test
	public void testArrayOfEnums() throws BException {
		log.info("testArrayOfEnums(");
		UsePlanets obj = new UsePlanets();
		obj.arrayOfPlanets = new EnumPlanets[4];
		obj.arrayOfPlanets[0] = null;
		obj.arrayOfPlanets[1] = EnumPlanets.Earth;
		obj.arrayOfPlanets[2] = EnumPlanets.Mercury;
		obj.arrayOfPlanets[3] = EnumPlanets.Venus;
		internalTestEnumValues(obj);
		log.info(")testArrayOfEnums");
	}

	/**
	 * Test Map<Enum, String> and Map<String, Enum>. 
	 * Check handling of null-values.
	 * @throws BException
	 */
	@Test
	public void testMapOfEnums() throws BException {
		log.info("testMapOfEnums(");
		
		UsePlanets obj = new UsePlanets();
		obj.mapOfPlanets = new HashMap<String, EnumPlanets>();
		obj.mapOfPlanets.put("zero", null);
		obj.mapOfPlanets.put("1-Earth", EnumPlanets.Earth);
		obj.mapOfPlanets.put("2-Mercury", EnumPlanets.Mercury);
		obj.mapOfPlanets.put("3-Venus", EnumPlanets.Venus);
		internalTestEnumValues(obj);

		// JavaScript erlaubt nur Number und String als Key-Typen
//		obj = new UsePlanets();
//		obj.mapKeyPlanets = new HashMap<EnumPlanets, String>();
//		obj.mapKeyPlanets.put(EnumPlanets.Mercury, "2-Mercury");
//		obj.mapKeyPlanets.put(EnumPlanets.Earth, "1-Earth");
//		obj.mapKeyPlanets.put(EnumPlanets.Venus, "3-Venus");
//		internalTestEnumValues(obj);
//
//		obj = new UsePlanets();
//		obj.mapKeyPlanets = new HashMap<EnumPlanets, String>();
//		obj.mapKeyPlanets.put(null, "zero");
//		obj.mapKeyPlanets.put(EnumPlanets.Earth, "1-Earth");
//		obj.mapKeyPlanets.put(EnumPlanets.Venus, "3-Venus");
//		internalTestEnumValues(obj);
		
		log.info(")testMapOfEnums");
	}
	
}
