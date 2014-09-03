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
package org.eclipselabs.emfjson.junit.model.suite;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipselabs.emfjson.junit.model.tests.AnnotationTest;
import org.eclipselabs.emfjson.junit.model.tests.PolymorphicTest;
import org.eclipselabs.emfjson.junit.model.tests.ReferenceTest;
import org.eclipselabs.emfjson.junit.model.tests.SimpleTest;
import org.eclipselabs.emfjson.junit.model.tests.UuidLoadTest;
import org.eclipselabs.emfjson.junit.model.tests.UuidSaveTest;
import org.eclipselabs.emfjson.junit.model.tests.ValueTest;

import com.google.gwt.junit.tools.GWTTestSuite;

public class EMFJSTestSuite extends GWTTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("EMFJSON Tests");
	    suite.addTestSuite(ValueTest.class);
	    suite.addTestSuite(AnnotationTest.class);
		suite.addTestSuite(SimpleTest.class);
		suite.addTestSuite(UuidSaveTest.class);
		suite.addTestSuite(UuidLoadTest.class);
		suite.addTestSuite(PolymorphicTest.class);
		suite.addTestSuite(ReferenceTest.class);
	    return suite;
	}

}
