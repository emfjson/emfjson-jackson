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

package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.emfjson.jackson.databind.type.EcoreTypeFactory;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.module.EMFModule;
import org.junit.Before;
import org.junit.Test;

public class EMFDeserializersTest {

	ObjectMapper mapper;
	EcoreTypeFactory factory = new EcoreTypeFactory();

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());
	}

	@Test
	public void test() throws JsonMappingException {
//		JavaType type = factory.typeOf(ModelPackage.Literals.USER__FRIENDS);
//		JsonDeserializer<Object> deserializer = mapper.getDeserializationContext()
//				.findRootValueDeserializer(type);
	}

}