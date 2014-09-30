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
package org.emfjson.jackson.junit.bench;

import java.io.IOException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.resource.JsonResourceFactory;

public class DeserializationBenchmark {

	int times = 10;
	protected final URL testURI = getClass().getResource("/tests");
	protected URI baseTestFilesFileDirectory = URI.createFileURI(testURI.getFile()).appendSegment("");

	public static void main(String[] args) throws IOException {
		DeserializationBenchmark b = new DeserializationBenchmark();
		b.benchmarkJson();
		b.benchmarkXmi();
//		b.test();
	}

	public void benchmarkXmi() throws IOException {
		System.out.println("Start xmi....");

		long[] all = new long[times];
		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(baseTestFilesFileDirectory.appendSegment("bench1-model.xmi"));

			long start = System.currentTimeMillis();
			resource.load(null);
			all[i] = System.currentTimeMillis() - start;
		}

		for (long a: all) {
			System.out.println("Time for XMI: " + a / 1000.);
		}
	}

	public void benchmarkJson() throws IOException {
		System.out.println("Start json....");

		long[] all = new long[times];
		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(baseTestFilesFileDirectory.appendSegment("bench1-model.json"));

			long start = System.currentTimeMillis();
			resource.load(null);
			all[i] = System.currentTimeMillis() - start;
		}

		for (long a: all) {
			System.out.println("Time for JSON: " + a / 1000.);
		}
	}

	public void test() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		Resource resource = resourceSet.createResource(baseTestFilesFileDirectory.appendSegment("nodes1.json"));
		resource.load(null);
		
		System.out.println(resource.getContents().get(0));
	}
}
