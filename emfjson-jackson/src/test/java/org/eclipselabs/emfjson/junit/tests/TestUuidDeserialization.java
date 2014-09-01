package org.eclipselabs.emfjson.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.AbstractType;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeOne;
import org.eclipselabs.emfjson.junit.model.Container;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.support.UuidSupport;
import org.eclipselabs.emfjson.map.JacksonObjectMapper;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestUuidDeserialization extends UuidSupport {

	private JacksonObjectMapper mapper;
	private Map<Object, Object> options = new HashMap<>();

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

		mapper = new JacksonObjectMapper();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_USE_UUID, true);
	}

	@Test
	public void testXmiUuidBehavior() throws IOException {
		Resource in = createUuidResource("in.xmi");
		Container root = ModelFactory.eINSTANCE.createContainer();
		in.getContents().add(root);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		in.save(outStream, null);

		ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
		Resource out = createUuidResource("out.xmi");
		out.load(inStream, null);

		assertEquals(1, out.getContents().size());
		EObject output = out.getContents().get(0);

		assertEquals(uuid(root), uuid(output));
	}

	@Test
	public void testDeserializeOneObject() {
		Resource resource = createUuidResource("test.xmi");
		Container root = ModelFactory.eINSTANCE.createContainer();
		resource.getContents().add(root);

		ObjectNode node = mapper.toObject(root, options);
		EObject result = mapper.fromObject(node, createUuidResource("result.xmi"), options);

		assertNotNull(result);
		assertEquals(uuid(root), uuid(result));
	}

	@Test
	public void testDeserializeOneObjectWithTwoChildHavingOneReference() {
		Resource resource = createUuidResource("test.xmi");
		Container root = ModelFactory.eINSTANCE.createContainer();
		ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		one.setName("one");
		ConcreteTypeOne two = ModelFactory.eINSTANCE.createConcreteTypeOne();
		two.setName("two");

		one.getRefProperty().add(two);
		root.getElements().add(one);
		root.getElements().add(two);
		resource.getContents().add(root);

		ObjectNode node = mapper.toObject(root, options);
		EObject result = mapper.fromObject(node, createUuidResource("result.xmi"), options);

		assertNotNull(result);
		assertEquals(uuid(root), uuid(result));
		assertEquals(ModelPackage.Literals.CONTAINER, result.eClass());

		Container resultContainer = (Container) result;
		assertEquals(2, resultContainer.getElements().size());

		AbstractType firstResult = resultContainer.getElements().get(0);
		AbstractType secondResult = resultContainer.getElements().get(1);

		assertEquals("one", firstResult.getName());
		assertEquals(uuid(one), uuid(firstResult));
		assertEquals("two", secondResult.getName());
		assertEquals(uuid(two), uuid(secondResult));

		assertEquals(1, firstResult.getRefProperty().size());
		assertEquals(uuid(secondResult), uuid(firstResult.getRefProperty().get(0)));
		assertEquals(secondResult, firstResult.getRefProperty().get(0));
	}

}
