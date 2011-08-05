package org.eclipselabs.emfjson.junit.tests;

import org.eclipse.emf.common.util.URI;

public class TestJs {
	
	protected String baseTestFilesPath = "platform:/plugin/org.eclipselabs.emfjson.junit/tests/";
	
	protected URI uri(String fileName) {
		return URI.createURI(baseTestFilesPath+fileName, true);
	}
}
