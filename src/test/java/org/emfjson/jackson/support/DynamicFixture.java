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

