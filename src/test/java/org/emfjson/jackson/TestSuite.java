/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.jackson;

import org.emfjson.jackson.databind.type.EcoreTypeTest;
import org.emfjson.jackson.tests.*;
import org.emfjson.jackson.tests.annotations.JsonPropertyTest;
import org.emfjson.jackson.tests.custom.CustomDeserializersTest;
import org.emfjson.jackson.tests.custom.CustomSerializersTest;
import org.emfjson.jackson.tests.dynamic.*;
import org.emfjson.jackson.tests.uuids.UuidLoadTest;
import org.emfjson.jackson.tests.uuids.UuidSaveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		// standard
		AnnotationTest.class,
		ContainmentTest.class,
		EnumTest.class,
		ExternalReferencesTest.class,
		FeatureMapTest.class,
		GenericTest.class,
		IdTest.class,
		MapTest.class,
		ModuleTest.class,
		NoTypeTest.class,
		PolymorphicTest.class,
		ReaderTest.class,
		ReferenceTest.class,
		ValueTest.class,

		// type factory
		EcoreTypeTest.class,

		// meta
		ModelTest.class,

		// annotations
		JsonPropertyTest.class,

		// uuid
		UuidLoadTest.class,
		UuidSaveTest.class,

		// dynamic tests
		DynamicContainmentTest.class,
		DynamicEnumTest.class,
		DynamicInstanceTest.class,
		DynamicMapTest.class,
		DynamicPackageTest.class,
		DynamicPolymorphicTest.class,
		DynamicValueTest.class,

		// custom
		CustomDeserializersTest.class,
		CustomSerializersTest.class
})
public class TestSuite {
}
