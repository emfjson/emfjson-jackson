/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.junit.suite;

import org.eclipselabs.emfjson.junit.tests.AnnotationTest;
import org.eclipselabs.emfjson.junit.tests.EnumTest;
import org.eclipselabs.emfjson.junit.tests.FeatureMapTest;
import org.eclipselabs.emfjson.junit.tests.PolymorphicTest;
import org.eclipselabs.emfjson.junit.tests.ReferenceTest;
import org.eclipselabs.emfjson.junit.tests.UuidLoadTest;
import org.eclipselabs.emfjson.junit.tests.UuidSaveTest;
import org.eclipselabs.emfjson.junit.tests.ValueTest;
import org.eclipselabs.emfjson.junit.tests.others.TestEmfJsAttributes;
import org.eclipselabs.emfjson.junit.tests.others.TestEmfJsReferences;
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
	TestEmfJsReferences.class, 
	TestEmfJsAttributes.class,
	UuidSaveTest.class,
	UuidLoadTest.class
	
	//	TestEmfJsNamespaces.class,
})
public class TestSuite {}
