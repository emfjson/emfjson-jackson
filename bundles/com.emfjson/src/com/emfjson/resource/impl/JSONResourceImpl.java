package com.emfjson.resource.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.emfjson.resource.JSONResource;

public class JSONResourceImpl 
extends ResourceImpl
implements JSONResource {

	public JSONResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			throw new IllegalArgumentException("Loading options must be set, and must contain the root EClass");
		}
		
		final JsonFactory jsonFactory = new JsonFactory();  
		final JsonParser jp = jsonFactory.createJsonParser(new URL(uri.toString()));
		final ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(jp, JsonNode.class);

		try {
			EClass rootClass = (EClass) options.get(OPTION_ROOT_ELEMENT);
			String path = getRootNode(options.get(OPTION_ROOT_ELEMENT));
			
			JsonNode root = rootNode.findPath(path);
			if (root != null) {
				EObject rootObject = EcoreUtil.create(rootClass);
				fillEAttribute(rootObject, rootClass, root);
				fillEReference(rootObject, rootClass, root);
				
				getContents().add(rootObject);
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	private void fillEReference(EObject rootObject, EClass rootClass, JsonNode root) {
		for (EReference reference: rootClass.getEAllReferences()) {
			if (reference.isMany()) {
				for (JsonNode node: root.findValues(getElementName(reference))) {
					if (node.isArray()) {
						for (Iterator<JsonNode> it = node.getElements(); it.hasNext();) {
							JsonNode n = it.next();
							EObject obj = createEObject(reference.getEReferenceType(), n);
							if (obj != null) {
								@SuppressWarnings("unchecked")
								EList<EObject> values = (EList<EObject>) rootObject.eGet(reference);
								values.add(obj);
							}
						}
					} else {
						EObject obj = createEObject(reference.getEReferenceType(), node);
						if (obj != null) {
							@SuppressWarnings("unchecked")
							EList<EObject> values = (EList<EObject>) rootObject.eGet(reference);
							values.add(obj);
						}
					}
				}
			}
		}
	}

	private EObject createEObject(EClass eClass, JsonNode node) {
		EObject obj = EcoreUtil.create(eClass);
		fillEAttribute(obj, eClass, node);

		return obj;
	}

	private void fillEAttribute(EObject obj, EClass eClass, JsonNode node) {
		for (EAttribute attribute: eClass.getEAllAttributes()) {
			if (!attribute.isMany() && attribute.isChangeable()) {
				fillUniqueEAttribute(obj, attribute, node);
			} else if (attribute.isChangeable()) {
				fillManyEAttribute(obj, attribute, node);
			}
		}
	}

	protected void fillManyEAttribute(EObject obj, EAttribute attribute, JsonNode node) {
		ArrayList<Object> values = new ArrayList<Object>();
		for (JsonNode n: node.findValues(getElementName(attribute))) {
			if (n.isArray()) {
				for (Iterator<JsonNode> it = n.getElements(); it.hasNext();) {
					String stringValue = it.next().getTextValue();
					if (stringValue != null) {
						Object newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
						values.add(newValue);
					}
				}
			} else {
				String stringValue = n.getValueAsText();
				if (stringValue != null) {
					Object newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
					values.add(newValue);
				}
			}
		}
		obj.eSet(attribute, values);
	}

	protected void fillUniqueEAttribute(EObject obj, EAttribute attribute, JsonNode node) {
		JsonNode value = node.findValue(getElementName(attribute));
		if (value != null) {
			String stringValue = value.getValueAsText();
			if (stringValue != null) {
				Object newValue = EcoreUtil.createFromString(attribute.getEAttributeType(), stringValue);
				obj.eSet(attribute, newValue);
			}
		}
	}

	protected String getElementName(EStructuralFeature feature) {
		EAnnotation annotation = feature.getEAnnotation("JSON");
		if (annotation != null && annotation.getDetails().containsKey("element")) {
			return annotation.getDetails().get("element");
		}
		return feature.getName();
	}

	protected String getRootNode(Object object) {
		if (object instanceof EClass) {
			EClass eClass = (EClass) object;
			if (eClass.getEAnnotation("JSON") != null) {
				EAnnotation annotation = eClass.getEAnnotation("JSON");
				if (annotation.getDetails().containsKey("root") && annotation.getDetails().containsKey("element")) {
					return annotation.getDetails().get("element");
				} else {
					throw new IllegalArgumentException("The root class @JSON annotation must contain root and element details.");
				}
			} else {
				throw new IllegalArgumentException("The root class must be annotated with @JSON annotation.");
			}
		} else {
			throw new IllegalArgumentException("Option must contain the root class.");
		}
	}

}
