package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.type.CollectionType;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.emfjson.jackson.junit.model.ModelPackage.Literals.PRIMARY_OBJECT;
import static org.emfjson.jackson.junit.model.ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1;

public class EcoreTypeFactoryTest {

	private EcoreTypeFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new EcoreTypeFactory();
	}

	@Test
	public void testReferenceTypes() {
		assertThat(factory.typeOf(ModelPackage.Literals.USER, ModelPackage.Literals.USER__UNIQUE_FRIEND))
				.isEqualTo(factory.constructReferenceType(ModelPackage.Literals.USER));

		assertThat(factory.typeOf(PRIMARY_OBJECT, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1))
				.isInstanceOf(CollectionType.class);
	}

}