package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import byps.BException;
import byps.BInput;
import byps.BOutput;
import byps.BTransport;
import byps.test.api.inherit.Class1;
import byps.test.api.inherit.Class1Collections;
import byps.test.api.inherit.Class2;
import byps.test.api.inherit.Class3;

/**
 *
 */
public class TestSerializerClassHierarchy {
	
	BTransport transport = TestUtils.createTransport();
	private Logger log = LoggerFactory.getLogger(TestSerializerClassHierarchy.class);
	
	
	@Test
	public void testDerivedClass() throws BException {
		log.info("testDerivedClass(");
		
		Class1 class1 = new Class1();
		class1.int1 = 111;
		internalTestDerivedClass(class1);
		
		Class2 class2 = new Class2();
		class2.int1 = 111;
		class2.int2 = 222;
		internalTestDerivedClass(class2);
		
		Class3 class3 = new Class3();
		class3.int1 = 111;
		class3.int2 = 222;
		class3.int3 = 333;
		internalTestDerivedClass(class3);

		log.info(")testDerivedClass");
	}

	private void internalTestDerivedClass(Class1 class1) throws BException {
		BOutput bout = transport.getOutput();
		
		bout.store(class1);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		Class1 classR = (Class1)bin.load();
	
		TestUtils.assertEquals(log, "class1.class", class1.getClass(), classR.getClass());
		TestUtils.assertEquals(log, "class1", class1, classR);
	}
	
	@Test
	public void testListOfDerivedClass() throws BException {
		log.info("testListOfDerivedClass(");

		List<Class1> list1 = new ArrayList<Class1>();

		Class1 class1 = new Class1();
		class1.int1 = 111;
		list1.add(class1);
		internalTestListOfDerivedClass(list1);
		
		Class2 class2 = new Class2();
		class2.int1 = 111;
		class2.int2 = 222;
		list1.add(class2);
		internalTestListOfDerivedClass(list1);
		
		Class3 class3 = new Class3();
		class3.int1 = 111;
		class3.int2 = 222;
		class3.int3 = 333;
		list1.add(class3);
		internalTestListOfDerivedClass(list1);

		log.info(")testListOfDerivedClass");
	}
	
	private void internalTestListOfDerivedClass(List<Class1> list1) throws BException {
		BOutput bout = transport.getOutput();
		
		Class1Collections obj = new Class1Collections();
		obj.list1 = list1;
		bout.store(obj);
		
		ByteBuffer buf = bout.toByteBuffer();
		TestUtils.printBuffer(log, buf);
		BInput bin = transport.getInput(null, buf);
		
		Class1Collections objR = (Class1Collections)bin.load();
	
		TestUtils.assertEquals(log, "obj", obj, objR);
	}

	@Test
	public void testReferenceToDerivedClass() throws BException {
		log.info("testReferenceToDerivedClass(");
		
		Class1 class1 = new Class1();
		class1.int1 = 1;
		class1.nextClass1 = new Class1();
		class1.nextClass1.int1 = 12;
		internalTestDerivedClass(class1);
		
		Class2 class2 = new Class2();
		class2.int1 = 111;
		class2.nextClass1 = new Class1();
		class2.nextClass1.int1 = 22;
		internalTestDerivedClass(class2);
		
		Class3 class3 = new Class3();
		class3.int1 = 111;
		class2.nextClass1 = new Class1();
		class2.nextClass1.int1 = 33;
		internalTestDerivedClass(class3);

		log.info(")testReferenceToDerivedClass");
	}

}
