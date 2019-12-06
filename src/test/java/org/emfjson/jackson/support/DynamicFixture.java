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

package org.emfjson.jackson.support;

import org.eclipse.emf.ecore.EPackage;

import static org.eclipse.emf.common.util.URI.createURI;

public class DynamicFixture extends StandardFixture {

	@Override
	protected void before() throws Throwable {
		super.before();

		getResourceSet().getURIConverter().getURIMap().put(
				createURI("http://emfjson/dynamic/model"),
				createURI("src/test/resources/model/dynamic/model.json"));

		EPackage ePackage = (EPackage) getResourceSet().getEObject(
				createURI("http://emfjson/dynamic/model#/"), true);

		getResourceSet().getPackageRegistry().put(ePackage.getNsURI(), ePackage);
	}

	@Override
	protected void after() {
		super.after();
	}
}

