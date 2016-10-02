package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.junit.model.PrimaryObject;
import org.emfjson.jackson.junit.model.Value;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.emfjson.jackson.junit.model.ModelPackage.Literals.PRIMARY_OBJECT;
import static org.emfjson.jackson.junit.model.ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1;

public class EcoreTypeFactoryTest {

	private EcoreTypeFactory factory;
	private TypeFactory typeFactory = TypeFactory.defaultInstance();

	@Before
	public void setUp() throws Exception {
		factory = new EcoreTypeFactory();
	}

	@Test
	public void testPrimitiveTypes() {
//		assertThat(factory.typeOf(ModelPackage.Literals.ETYPES__ESTRING))
//				.isEqualTo(new EcoreSimpleType(EcorePackage.Literals.ESTRING, String.class));
//
//		assertThat(factory.typeOf(ModelPackage.Literals.ETYPES__EBOOLEAN))
//				.isEqualTo(new EcoreSimpleType(EcorePackage.Literals.EBOOLEAN, boolean.class));
//
//		assertThat(factory.typeOf(ModelPackage.Literals.ETYPES__EINT))
//				.isEqualTo(new EcoreSimpleType(EcorePackage.Literals.EINT, int.class));
	}

//	@Test
	public void testObjectTypes() {
		assertThat(factory.constructSimpleType(PRIMARY_OBJECT))
				.isEqualTo(new EcoreSimpleType(PRIMARY_OBJECT, PrimaryObject.class));
	}

	@Test
	public void testReferenceTypes() {
//		assertThat(factory.typeOf(ModelPackage.Literals.USER__UNIQUE_FRIEND))
//				.isEqualTo(factory.constructReferenceType(ModelPackage.Literals.USER));

		assertThat(factory.typeOf(PRIMARY_OBJECT, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1))
				.isInstanceOf(CollectionType.class);
	}

	@Test
	public void testContainmentTypes() {
//		assertThat(factory.typeOf(ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES))
//				.isEqualTo(factory.constructSimpleType(ModelPackage.Literals.TARGET_OBJECT));
	}

	@Test
	public void testMapTypes() {
//		assertThat(factory.typeOf(ModelPackage.Literals.ETYPES__VALUES))
//				.isEqualTo(factory.constructCollectionType(typeFactory.constructType(EObject.class)));
	}

	@Test
	public void testStringMapTypes() {
//		assertThat(factory.typeOf(ModelPackage.Literals.ETYPES__STRING_MAP_VALUES))
//				.isEqualTo(typeFactory.constructMapLikeType(EMap.class, String.class, Value.class));
	}

}