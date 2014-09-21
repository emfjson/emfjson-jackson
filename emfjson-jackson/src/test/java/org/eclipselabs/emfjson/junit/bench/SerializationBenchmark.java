package org.eclipselabs.emfjson.junit.bench;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.junit.model.ConcreteTypeOne;
import org.eclipselabs.emfjson.junit.model.Container;
import org.eclipselabs.emfjson.junit.model.ModelFactory;
import org.eclipselabs.emfjson.junit.model.ModelPackage;
import org.eclipselabs.emfjson.junit.model.Node;
import org.eclipselabs.emfjson.resource.JsonResourceFactory;

public class SerializationBenchmark {

	int times = 10;

	public static void main(String[] args) {
		SerializationBenchmark b =  new SerializationBenchmark();
		// first
		b.benchmarkSerializeXmi(b.setUpFirst());
		b.benchmarkSerializeBinary(b.setUpFirst());
		b.benchmarkSerializeJson(b.setUpFirst());
		// second
		b.benchmarkSerializeXmi(b.setUpSecond());
		b.benchmarkSerializeBinary(b.setUpSecond());
		b.benchmarkSerializeJson(b.setUpSecond());
	}

	private long performSave(Resource resource, Map<String, Object> options) {
		long start = System.nanoTime();
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return System.nanoTime() - start;
	}

	public EObject setUpFirst() {
		Container root = ModelFactory.eINSTANCE.createContainer();
		for (int i = 0; i < 100000; i++) {
			ConcreteTypeOne child = ModelFactory.eINSTANCE.createConcreteTypeOne();
			child.setName("Concrete" + i);
			root.getElements().add(child);
		}
		return root;
	}

	public EObject setUpSecond() {
		Node root = ModelFactory.eINSTANCE.createNode();
		
		for (int i = 0; i < 100; i++) {
			Node n1 = ModelFactory.eINSTANCE.createNode();
			n1.setLabel("first" + i);
			root.getChild().add(n1);

			for (int j = 0; j < 100; j++) {
				Node n2 = ModelFactory.eINSTANCE.createNode();
				n2.setLabel("second" + j);
				n1.getChild().add(n2);
				
				for (int k = 0; k < 100; k++) {
					Node n3 = ModelFactory.eINSTANCE.createNode();
					n3.setLabel("third" + k);
					n2.getChild().add(n3);
				}
			}
		}
		return root;
	}

	public void benchmarkSerializeXmi(EObject container) {
		long sum = 0;

		System.out.println("Start xmi....");
		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(URI.createURI("bench1-model.xmi"));
			resource.getContents().add(container);

			sum += performSave(resource, null);
		}

		long average = sum / times;
		System.out.println("Time for XMI: " + average);
	}

	public void benchmarkSerializeBinary(EObject container) {
		long sum = 0;

		System.out.println("Start Binary....");
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
		System.out.println("Time for Binary: " + average);
	}

	public void benchmarkSerializeJson(EObject container) {
		long sum = 0;
		Map<String, Object> options = new HashMap<>();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_SERIALIZE_NAMESPACES, false);
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);

		System.out.println("Start json....");
		for (int i = 0; i < times; i++) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());
			resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			Resource resource = resourceSet.createResource(URI.createURI("bench1-model.json"));
			resource.getContents().add(container);

			sum += performSave(resource, options);
		}

		long average = sum / times;
		System.out.println("Time for JSON: " + average);
	}

}

