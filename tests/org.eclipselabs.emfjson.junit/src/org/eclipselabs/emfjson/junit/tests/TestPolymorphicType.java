package org.eclipselabs.emfjson.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.EJs;
import org.eclipselabs.emfjson.junit.model.AbstractType;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeOne;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeTwo;
import org.eclipselabs.emfjson.junit.model.Container;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.support.TestSupport;
import org.junit.Test;

public class TestPolymorphicType extends TestSupport {
	
	@Test
	public void testSaveTwoObjectsWithTypeInformation() throws IOException {
		String expectedString = 
				"{" +
						"\"elements\":" +
						"[" +
							"{\"type\":\"ConcreteTypeOne\",\"name\":\"First\"}," +
							"{\"type\":\"ConcreteTypeTwo\",\"name\":\"Two\"}" +
							"]" +
				"}";
		
		Resource resource = resourceSet.createResource(URI.createURI("tests/test-save-types.json"));
		
		assertNotNull(resource);
		
		Container c = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		one.setName("First");
		ConcreteTypeTwo two = ModelFactory.eINSTANCE.createConcreteTypeTwo();
		two.setName("Two");
		c.getElements().add(one);
		c.getElements().add(two);
		
		resource.getContents().add(c);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		resource.save(outStream, null);
		
		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	public void testLoadTwoObjectsWithTypeInformation() throws IOException {
		Resource resource = resourceSet.createResource(
				URI.createURI("platform:/plugin/org.eclipselabs.emfjson.junit/tests/test-load-types.json"));
		assertNotNull(resource);
		options.put(EJs.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getContainer());
		
		resource.load(options);
		
		assertEquals(1, resource.getContents().size());
		
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof Container);
		
		Container container = (Container) root;
		
		assertEquals(2, container.getElements().size());
		AbstractType first = container.getElements().get(0);
		AbstractType second = container.getElements().get(1);
		
		assertTrue(first instanceof ConcreteTypeOne);
		assertTrue(second instanceof ConcreteTypeTwo);
		
		assertEquals("First", first.getName());
		assertEquals("one", ((ConcreteTypeOne)first).getPropTypeOne());
		assertEquals("Two", second.getName());
		assertEquals("two", ((ConcreteTypeTwo)second).getPropTypeTwo());
	}
	
	@Test
	public void testLoadTwoObjectsWithReferenceAndTypeInformation() {
		
	}
}
