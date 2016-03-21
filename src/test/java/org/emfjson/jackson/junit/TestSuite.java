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
package org.emfjson.jackson.junit;

import org.emfjson.jackson.junit.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		AnnotationTest.class,
		ContainmentTest.class,
		CustomDeserializersTest.class,
		CustomSerializersTest.class,
		DynamicInstanceTest.class,
		DynamicMapTest.class,
		DynamicPackageTest.class,
		EnumTest.class,
		ExternalReferencesTest.class,
		FeatureMapTest.class,
		GenericTest.class,
		IdTest.class,
		JacksonOptionTest.class,
		MapTest.class,
		ModuleTest.class,
		NoTypeTest.class,
		PolymorphicTest.class,
		ProxyAttributeTest.class,
		ReaderTest.class,
		ReferenceTest.class,
		UuidLoadTest.class,
		UuidSaveTest.class,
		ValueTest.class
})
public class TestSuite {
}
