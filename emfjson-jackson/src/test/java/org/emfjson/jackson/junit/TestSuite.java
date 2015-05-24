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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.emfjson.jackson.junit.tests.*;

@RunWith(Suite.class)
@SuiteClasses({
	ValueTest.class,
	ContainmentTest.class,
	ReaderTest.class,
	EnumTest.class,
	FeatureMapTest.class,
	AnnotationTest.class,
	PolymorphicTest.class,
	ReferenceTest.class,
	ProxyAttributeTest.class,
	UuidSaveTest.class,
	UuidLoadTest.class,
	ModuleTest.class,
	ExternalReferencesTest.class,
	NoTypeTest.class,
	DynamicPackageTest.class,
	DynamicInstanceTest.class
})
public class TestSuite {}
