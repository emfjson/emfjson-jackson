package org.eclipselabs.emfjson.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.common.Constants;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeOne;
import org.eclipselabs.emfjson.junit.model.Container;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.support.UuidSupport;
import org.eclipselabs.emfjson.map.JacksonObjectMapper;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestUuidSerialization extends UuidSupport {

	private Resource resource;
	private JacksonObjectMapper mapper;
	private Map<Object, Object> options = new HashMap<>();

	@Before
	public void setUp() {
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		resource = createUuidResource("test.xmi");

		mapper = new JacksonObjectMapper();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_USE_UUID, true);
	}

	@Test
	public void testSerializeOneObjectWithUuid() {
		Container root = ModelFactory.eINSTANCE.createContainer();
		resource.getContents().add(root);

		// Make sure the fragment identifier is a UUID 
		assertTrue(EcoreUtil.getURI(root).fragment().startsWith("_"));

		ObjectNode node = mapper.toObject(root, options);

		assertNotNull(node);
		assertNotNull(node.get(Constants.EJS_UUID_ANNOTATION));
		assertEquals(uuid(root), uuid(node));
	}

	@Test
	public void testSerializeOneRootWithTwoChildHavingOneReference() throws IOException {
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

		assertNotNull(node);
		assertNotNull(node.get(Constants.EJS_UUID_ANNOTATION));
		assertEquals(uuid(root), uuid(node));

		assertTrue(node.get("elements").isArray());

		ArrayNode elements = (ArrayNode) node.get("elements"); 
		assertEquals(2, elements.size());
		JsonNode node1 = elements.get(0);
		JsonNode node2 = elements.get(1);

		assertNotNull(node1.get(Constants.EJS_UUID_ANNOTATION));
		assertEquals(uuid(one), uuid(node1));

		assertNotNull(node2.get(Constants.EJS_UUID_ANNOTATION));
		assertEquals(uuid(two), uuid(node2));

		assertNotNull(node1.get("refProperty"));
		assertNull(node2.get("refProperty"));
		assertTrue(node1.get("refProperty").isArray());

		ArrayNode refProperty = (ArrayNode) node1.get("refProperty");
		assertEquals(1, refProperty.size());

		JsonNode ref = refProperty.get(0);
		assertNotNull(ref.get(Constants.EJS_REF_KEYWORD));
		assertNotNull(ref.get(Constants.EJS_TYPE_KEYWORD));

		assertEquals(uuid(two), ref.get(Constants.EJS_REF_KEYWORD).asText());
	}

}
