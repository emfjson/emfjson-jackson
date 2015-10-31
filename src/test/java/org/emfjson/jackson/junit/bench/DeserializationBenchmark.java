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
package org.emfjson.jackson.junit.bench;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.resource.JsonResourceFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DeserializationBenchmark {

	int times = 20;

	public static void main(String[] args) throws IOException {
		DeserializationBenchmark b = new DeserializationBenchmark();
		// first
		System.out.println("--- 1st benchmarck ---");
		b.benchmarkXmi(Benchmarks.first());
//		b.benchmarkBinary(Benchmarks.first());
		b.benchmarkJson(Benchmarks.first());
		// second
		System.out.println("--- 2nd benchmarck ---");
		b.benchmarkXmi(Benchmarks.second());
//		b.benchmarkBinary(Benchmarks.second());
		b.benchmarkJson(Benchmarks.second());
		// third
		System.out.println("--- 3rd benchmarck ---");
		b.benchmarkXmi(Benchmarks.third());
//		b.benchmarkBinary(Benchmarks.third());
		b.benchmarkJson(Benchmarks.third());
	}

	private String content(EObject content, ResourceSet rs) {
		Resource resource = rs.createResource(URI.createURI("save"));
		resource.getContents().add(content);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new String(outputStream.toByteArray());
	}

	private long load(Resource resource, String content) {
		long start = System.currentTimeMillis();
		try {
			resource.load(new ByteArrayInputStream(content.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis() - start;
	}

	public void benchmarkXmi(EObject content) throws IOException {
		long sum = 0;

		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(URI.createURI("test"));

			sum += load(resource, content(content, resourceSet));
		}

		long average = sum / times;
		System.out.println("XMI: " + average / 1000.);
	}

	public void benchmarkBinary(EObject content) throws IOException {
		long sum = 0;

		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ResourceFactoryImpl() {
				@Override
				public Resource createResource(URI uri) {
					return new BinaryResourceImpl(uri);
				}
			});
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(URI.createURI("test"));

			sum += load(resource, content(content, resourceSet));
		}

		long average = sum / times;
		System.out.println("Binary: " + average / 1000.);
	}

	public void benchmarkJson(EObject content) throws IOException {
		long sum = 0;

		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(URI.createURI("test"));

			sum += load(resource, content(content, resourceSet));
		}

		long average = sum / times;
		System.out.println("JSON: " + average / 1000.);
	}

}
