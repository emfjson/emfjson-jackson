package org.eclipselabs.emfjson.junit.model.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.gwt.map.JsonMapper;
import org.eclipselabs.emfjson.junit.model.AbstractType;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeOne;
import org.eclipselabs.emfjson.junit.model.Container;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.support.UuidTestSupport;
import org.junit.Test;

import com.google.gwt.json.client.JSONValue;

public class UuidLoadTest extends UuidTestSupport {

	@Test
	public void testUuidBehavior() throws IOException {
		Resource in = createUuidResource("in.json");

		final Container root = ModelFactory.eINSTANCE.createContainer();
		in.getContents().add(root);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		in.save(outStream, options);

		delayTestFinish(100);
		InputStream inputStream = new ByteArrayInputStream(outStream.toByteArray());
		JsonMapper mapper = new JsonMapper();
		mapper.parse(createUuidResource("out.json"), inputStream, options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertEquals(1, result.getContents().size());
				EObject output = result.getContents().get(0);

				assertEquals(uuid(root), uuid(output));
				finishTest();
			}
			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
			}
		});
	}

	@Test
	public void testDeserializeOneObject() {
		Resource resource = createUuidResource("test.json");
		final Container root = ModelFactory.eINSTANCE.createContainer();
		resource.getContents().add(root);

		delayTestFinish(100);

		JSONValue node = mapper.write(resource, options);
		mapper.parse(createUuidResource("result.json"), node, options, new Callback<Resource>() {
			@Override
			public void onSuccess(Resource result) {
				assertNotNull(result);

				EObject first = result.getContents().get(0);
				assertEquals(uuid(root), uuid(first));

				finishTest();
			}
			@Override
			public void onFailure(Throwable caught) {
				assertNull(caught);
			}
		});
	}

	@Test
	public void testDeserializeOneObjectWithTwoChildHavingOneReference() {
		Resource resource = createUuidResource("test.json");
		final Container root = ModelFactory.eINSTANCE.createContainer();
		final ConcreteTypeOne one = ModelFactory.eINSTANCE.createConcreteTypeOne();
		final ConcreteTypeOne two = ModelFactory.eINSTANCE.createConcreteTypeOne();

		one.setName("one");
		two.setName("two");
		one.getRefProperty().add(two);
		root.getElements().add(one);
		root.getElements().add(two);

		resource.getContents().add(root);

		JSONValue node = mapper.write(resource, options);

		delayTestFinish(100);

		mapper.parse(createUuidResource("result.json"), node, options, new Callback<Resource>() {
			@Override public void onFailure(Throwable caught) {
				assertNull(caught);
			}
			@Override public void onSuccess(Resource result) {
				assertNotNull(result);

				EObject first = result.getContents().get(0);

				assertEquals(uuid(root), uuid(first));
				assertEquals(ModelPackage.Literals.CONTAINER, first.eClass());

				Container resultContainer = (Container) first;
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
				
				finishTest();
			}
		});
	}

}
