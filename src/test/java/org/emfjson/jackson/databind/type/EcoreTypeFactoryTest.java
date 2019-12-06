/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */

package org.emfjson.jackson.databind.type;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.emfjson.jackson.junit.model.ModelPackage.Literals.PRIMARY_OBJECT;
import static org.emfjson.jackson.junit.model.ModelPackage.Literals.PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EcoreTypeFactoryTest {

	private EcoreTypeFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new EcoreTypeFactory();
	}

	@Test
	public void testReferenceTypes() {
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		DatabindContext context = mock(DatabindContext.class);
		when(context.getTypeFactory()).thenReturn(typeFactory);

		assertThat(factory.typeOf(context, ModelPackage.Literals.USER, ModelPackage.Literals.USER__UNIQUE_FRIEND))
				.isEqualTo(factory.constructReferenceType(typeFactory, ModelPackage.Literals.USER));

		assertThat(factory.typeOf(context, PRIMARY_OBJECT, PRIMARY_OBJECT__FEATURE_MAP_REFERENCE_TYPE1))
				.isInstanceOf(CollectionType.class);
	}

}