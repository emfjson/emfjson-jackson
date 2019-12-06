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
package org.emfjson.jackson.bench;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emfjson.jackson.junit.model.ModelPackage;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;

import java.io.IOException;
import java.util.Map;

public class SerializationBenchmark {

	int times = 20;

	public static void main(String[] args) {
		SerializationBenchmark b = new SerializationBenchmark();
		// first
		System.out.println("--- 1st benchmarck ---");
		b.benchmarkSerializeXmi(Benchmarks.first());
		b.benchmarkSerializeBinary(Benchmarks.first());
		b.benchmarkSerializeJson(Benchmarks.first());
		// second
		System.out.println("--- 2nd benchmarck ---");
		b.benchmarkSerializeXmi(Benchmarks.second());
		b.benchmarkSerializeBinary(Benchmarks.second());
		b.benchmarkSerializeJson(Benchmarks.second());
		// third
		System.out.println("--- 3rd benchmarck ---");
		b.benchmarkSerializeXmi(Benchmarks.third());
		b.benchmarkSerializeBinary(Benchmarks.third());
		b.benchmarkSerializeJson(Benchmarks.third());
	}

	private long performSave(Resource resource, Map<String, Object> options) {
		long start = System.currentTimeMillis();
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis() - start;
	}

	public void benchmarkSerializeXmi(EObject container) {
		long sum = 0;

		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(URI.createURI("bench1-model.xmi"));
			resource.getContents().add(container);

			sum += performSave(resource, null);
		}

		long average = sum / times;
		System.out.println("XMI: " + average / 1000.);
	}

	public void benchmarkSerializeBinary(EObject container) {
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
			Resource resource = resourceSet.createResource(URI.createURI("bench1-model.n"));
			resource.getContents().add(container);

			sum += performSave(resource, null);
		}

		long average = sum / times;
		System.out.println("Binary: " + average / 1000.);
	}

	ObjectMapper mapper = new ObjectMapper();

	{
		EMFModule module = new EMFModule();
		module.configure(EMFModule.Feature.OPTION_SERIALIZE_TYPE, false);
		mapper.registerModule(module);
	}

	public void benchmarkSerializeJson(EObject container) {
		long sum = 0;

		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();

			resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put("*", new JsonResourceFactory(mapper));

			resourceSet.getPackageRegistry()
					.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);

			Resource resource = resourceSet.createResource(URI.createURI("bench1-model.json"));
			resource.getContents().add(container);

			sum += performSave(resource, null);
		}

		long average = sum / times;
		System.out.println("JSON: " + average / 1000.);
	}

}

