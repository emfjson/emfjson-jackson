/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.junit.suite;

import org.emfjson.jackson.junit.tests.AnnotationTest;
import org.emfjson.jackson.junit.tests.EnumTest;
import org.emfjson.jackson.junit.tests.FeatureMapTest;
import org.emfjson.jackson.junit.tests.ModuleTest;
import org.emfjson.jackson.junit.tests.PolymorphicTest;
import org.emfjson.jackson.junit.tests.ProxyAttributeTest;
import org.emfjson.jackson.junit.tests.ReferenceTest;
import org.emfjson.jackson.junit.tests.UpdateObjectTest;
import org.emfjson.jackson.junit.tests.UuidLoadTest;
import org.emfjson.jackson.junit.tests.UuidSaveTest;
import org.emfjson.jackson.junit.tests.ValueTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ValueTest.class,
	EnumTest.class,
	FeatureMapTest.class,
	AnnotationTest.class,
	PolymorphicTest.class, 
	ReferenceTest.class, 
	ProxyAttributeTest.class,
	UuidSaveTest.class,
	UuidLoadTest.class,
	ModuleTest.class,
	UpdateObjectTest.class
})
public class TestSuite {}
