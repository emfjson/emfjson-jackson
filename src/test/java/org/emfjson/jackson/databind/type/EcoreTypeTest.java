package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.emfjson.jackson.junit.model.*;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class EcoreTypeTest {

	private final TypeFactory factory = TypeFactory.defaultInstance();
	private EcoreType ecoreType = new EcoreType();

	@Test
	public void testAttributeTypes() throws Exception {
		User u = ModelFactory.eINSTANCE.createUser();

		assertThat(ecoreType.construct(u, ModelPackage.Literals.USER__NAME))
				.isSameAs(factory.constructSimpleType(String.class, null));

		assertThat(ecoreType.construct(u, ModelPackage.Literals.USER__BIRTH_DATE))
				.isSameAs(factory.constructSimpleType(Date.class, null));

		assertThat(ecoreType.construct(u, ModelPackage.Literals.USER__SEX))
				.isSameAs(factory.constructSimpleType(Sex.class, null));

		assertThat(ecoreType.construct(u, ModelPackage.Literals.USER__ADDRESS))
				.isSameAs(factory.constructSimpleType(Address.class, null));
	}

	@Test
	public void testReferenceTypes() {
		User u = ModelFactory.eINSTANCE.createUser();

		assertThat(ecoreType.construct(u, ModelPackage.Literals.USER__FRIENDS))
				.isEqualTo(factory.constructCollectionType(EList.class,
						factory.constructReferenceType(User.class, factory.constructType(User.class))));

		assertThat(ecoreType.construct(u, ModelPackage.Literals.USER__UNIQUE_FRIEND))
				.isEqualTo(factory.constructReferenceType(User.class, factory.constructType(User.class)));
	}

	@Test
	public void testContainmentTypes() {
		PrimaryObject p = ModelFactory.eINSTANCE.createPrimaryObject();

		assertThat(ecoreType.construct(p, ModelPackage.Literals.PRIMARY_OBJECT__SINGLE_CONTAINMENT_REFERENCE_PROXIES))
				.isEqualTo(factory.constructType(TargetObject.class));
	}

	@Test
	public void testMapTypes() {
		ETypes obj = ModelFactory.eINSTANCE.createETypes();

		assertThat(ecoreType.construct(obj, ModelPackage.Literals.ETYPES__VALUES))
				.isEqualTo(factory.constructMapLikeType(EMap.class, Type.class, Value.class));
	}

}