/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.modelgen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.node.ObjectNode; 
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.common.ModelUtil;
import org.eclipselabs.emfjson.internal.JSUtil;

/**
 * 
 * {@link JsModelGen} generates Ecore models (schema) from JSON files.  
 * 
 * 
 * @author guillaume
 *
 */
public class JsModelGen {

	public static EPackage genPackage(String nsURI, URI jsonURI) {
		URL url = null;
		try {
			url = ModelUtil.getURL(jsonURI, null);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		final JsonParser parser = JSUtil.getJsonParser(url);
		final JsonNode rootNode = JSUtil.getRootNode(parser);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(nsURI).appendFileExtension("json"));
		
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setNsURI(nsURI);
		
		ePackage.setName(URI.createURI(nsURI).lastSegment());
		ePackage.setNsPrefix(ePackage.getName().toLowerCase());
		
		resource.getContents().add(ePackage);
		createPackageContent(ePackage, rootNode);
		
		for (EClassifier eClass: ePackage.getEClassifiers()) {
			for (EReference eRef: ((EClass)eClass).getEReferences()) {
				EClass eType = (EClass) ePackage.eResource().getEObject("//"+getClassName(eRef.getName()));
				eRef.setEType(eType);
			}
		}
		
		return ePackage;
	}
	
	private static List<EClass> createPackageContent(EPackage ePackage, JsonNode rootNode) {
		mapOfClasses.clear();
		
		List<EClass> classifiers = new BasicEList<EClass>();
		if (rootNode.isArray()) {
			for (Iterator<JsonNode> it = rootNode.getElements(); it.hasNext();) {
				JsonNode current = it.next();
				createEClass(null, current);
			}
		} else {
			createEClass(null, rootNode);
		}
		
		for (String key: mapOfClasses.keySet()) {
			EClass eClass = createEClass(ePackage, key, mapOfClasses.get(key));
			ePackage.getEClassifiers().add(eClass);
			classifiers.add(eClass);
		}
		
		return classifiers;
	}
	
	private static EClass createEClass(EPackage ePackage, String name, Map<String, JsonNode> entries) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(getClassName(name));
		
		for (String key: entries.keySet()) {
			JsonNode node = entries.get(key);
			
			if (isObjectOrArray(node)) {
				EReference ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setName(key);
				ref.setContainment(true);
				if (node.isArray()) ref.setUpperBound(-1);
				eClass.getEStructuralFeatures().add(ref);
			} else {
				EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
				if (key.contains("-")) {
					String validName = key.replaceAll("-", "");
					EAnnotation ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource("JSON");
					ann.getDetails().put("element", key);
					attr.setName(validName);
					attr.getEAnnotations().add(ann);
				} else {
					attr.setName(key);
				}
				attr.setEType(getEDataType(node));
				if (node.isArray()) attr.setUpperBound(-1);
				eClass.getEStructuralFeatures().add(attr);
			}
		}
		
		return eClass;
	}
	
	private static void createEClass(String containmentReferenceName, JsonNode node) {
		String name = containmentReferenceName == null ? "Root" : containmentReferenceName;
		
		addClass(name, node);
	}
	
	private static Map<String, Map<String, JsonNode>> mapOfClasses = new HashMap<String, Map<String, JsonNode>>();
	
	private static void addClass(String name, JsonNode node) {
		if (mapOfClasses.containsKey(name)) {
			Map<String, JsonNode> entries = buildEntryMap(node);
			mapOfClasses.get(name).putAll(entries);
		} else {
			mapOfClasses.put(name, buildEntryMap(node));
		}
	}
	
	private static Map<String, JsonNode> buildEntryMap(JsonNode node) {
		Map<String, JsonNode> entries = new HashMap<String, JsonNode>();
		ObjectNode aNode = (ObjectNode) node;
		for (Iterator<Entry<String, JsonNode>> fields = aNode.getFields(); fields.hasNext();) {
			Entry<String, JsonNode> field = fields.next();
			String key = field.getKey();
			JsonNode value = field.getValue();
			
			if (entries.containsKey(key)) {
				System.out.println("already here");
			} else {
				entries.put(key, value);
				if (isObjectOrArray(value)) {
					addClass(key, value);
				}
			}
		}
		
		return entries;
	}
	
	private static String getClassName(String property) {
		return property.substring(0, 1).toUpperCase() + property.substring(1);
	}
	
	private static boolean isObjectOrArray(JsonNode node) {
		if (node.isObject()) {
			return true;
		} else if (node.isArray()) {
			if (node.getElements().hasNext()) {
				return node.getElements().next().isObject();
			} else {
				return false;
			}
		}
		return false;
	}
	
	private static EDataType getEDataType(JsonNode node) {
		if (node.isTextual()) {
			return EcorePackage.eINSTANCE.getEString();
		} else if (node.isInt()) {
			return EcorePackage.eINSTANCE.getEInt();
		} else if (node.isBoolean()) {
			return EcorePackage.eINSTANCE.getEBoolean();
		} else {
			return EcorePackage.eINSTANCE.getEString();
		}
	}
	
}