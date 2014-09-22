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

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipselabs.emfjson.junit.tests.GwtTestAnnotation;
import org.eclipselabs.emfjson.junit.tests.GwtTestPolymorphic;
import org.eclipselabs.emfjson.junit.tests.GwtTestReference;
import org.eclipselabs.emfjson.junit.tests.GwtTestSimple;
import org.eclipselabs.emfjson.junit.tests.GwtTestUuidLoad;
import org.eclipselabs.emfjson.junit.tests.GwtTestUuidSave;
import org.eclipselabs.emfjson.junit.tests.GwtTestValue;

import com.google.gwt.junit.tools.GWTTestSuite;

public class GwtEMFJsSuite extends GWTTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("EMFJSON Tests");
	    suite.addTestSuite(GwtTestValue.class);
	    suite.addTestSuite(GwtTestAnnotation.class);
		suite.addTestSuite(GwtTestSimple.class);
		suite.addTestSuite(GwtTestUuidSave.class);
		suite.addTestSuite(GwtTestUuidLoad.class);
		suite.addTestSuite(GwtTestPolymorphic.class);
		suite.addTestSuite(GwtTestReference.class);
	    return suite;
	}

}
