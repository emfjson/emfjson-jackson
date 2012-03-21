package org.eclipselabs.emfjson.gwt.internal;

import static org.eclipselabs.emfjson.gwt.common.Constants.EJS_REF_KEYWORD;
import static org.eclipselabs.emfjson.gwt.common.Constants.EJS_TYPE_KEYWORD;
import static org.eclipselabs.emfjson.gwt.common.ModelUtil.getElementName;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipselabs.emfjson.gwt.common.AbstractJSONSave;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JSONSave extends AbstractJSONSave {

	public JSONSave(Map<?,?> options) {
		super(options);
	}

	public void write(OutputStream outputStream, Resource resource) {
		JSONValue json = genJson(resource);
		String stringValue = json.toString();
		try {
			outputStream.write(stringValue.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public JSONValue genJson(Resource resource) {
		return genJson(resource, this.options);
	}


	public JSONValue genJson(Resource resource, Map<?,?> options) {
		final JSONValue rootNode;
		final EList<EObject> contents = resource.getContents();

		if (contents.size() == 1) {
			EObject rootObject = resource.getContents().get(0);
			rootNode = writeEObject(rootObject, resource);
		} else {
			rootNode = new JSONArray();

			for (int i=0; i<contents.size(); i++) {
				EObject obj = contents.get(i);
				JSONObject node = writeEObject(obj, resource);
				if (node != null) {
					((JSONArray)rootNode).set(i, node);
				}
			}

			//			((ArrayNode)rootNode).addAll(nodes);
		}

		return rootNode;
	}

	public void writeValue(OutputStream outputStream, Object value) {
		if (value instanceof JSONValue) {
			String stringValue = ((JSONValue)value).toString();
			try {
				outputStream.write(stringValue.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected JSONObject writeEObject(EObject object, Resource resource) {
		JSONObject node = new JSONObject();

		writeEObjectAttributes(object, node);
		writeEObjectReferences(object, node, resource);

		return node;
	}

	protected void writeEObjectAttributes(EObject object, JSONObject node) {
		final URI eClassURI = EcoreUtil.getURI(object.eClass());
		if (serializeTypes) {
			node.put(EJS_TYPE_KEYWORD, new JSONString(eClassURI.toString()));
		}

		for (EAttribute attribute: object.eClass().getEAllAttributes()) {

			if (object.eIsSet(attribute) && !attribute.isDerived() 
					&& !attribute.isTransient() && !attribute.isUnsettable()) {

				if (FeatureMapUtil.isFeatureMap(attribute)) {

					FeatureMap.Internal featureMap = (FeatureMap.Internal) object.eGet(attribute);
					Iterator<FeatureMap.Entry> iterator = featureMap.basicIterator();

					while (iterator.hasNext()) {

						FeatureMap.Entry entry = iterator.next();
						EStructuralFeature feature = entry.getEStructuralFeature();

						if (feature instanceof EAttribute) {
							setJsonValue(node, entry.getValue(), (EAttribute) feature);
						}

					}

				} else if (attribute.isMany()) {

					EList<?> rawValues = (EList<?>) object.eGet(attribute);

					if (!rawValues.isEmpty()) {
						JSONArray arrayNode = new JSONArray();
						node.put(getElementName(attribute), arrayNode);

						for (Object val: rawValues) {
							setJsonValue(arrayNode, val, attribute);
						}
					}

				} else {

					final Object value = object.eGet(attribute);
					setJsonValue(node, value, attribute);

				}
			}
		}
	}

	private void setJsonValue(JSONObject node, Object value, EAttribute attribute) {
		final EDataType dataType = attribute.getEAttributeType();

		if (value != null) {
			if (dataType.getName().contains("Int")) {
				int intValue = (Integer) value;
				node.put(getElementName(attribute), new JSONNumber(intValue));	
			} else if (dataType.getName().contains("Boolean")) {
				boolean booleanValue = (Boolean) value;
				node.put(getElementName(attribute), JSONBoolean.getInstance(booleanValue));
			} else if (dataType.getName().contains("Double")) {
				double doubleValue = (Double) value;
				node.put(getElementName(attribute), new JSONNumber(doubleValue));
				//			} else if (value instanceof Date) {
				//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				//		        String dateValue = sdf.format(value);
				//		        node.put(getElementName(attribute), dateValue);
			} else {
				node.put(getElementName(attribute), new JSONString(value.toString()));
			}
		}
	}

	private void setJsonValue(JSONArray node, Object value, EAttribute attribute) {
		final EDataType dataType = attribute.getEAttributeType();

		if (value != null) {
			if (dataType.getName().contains("Int")) {
				int intValue = (Integer) value;
				node.set(node.size()-1, new JSONNumber(intValue));
			} else if (dataType.getName().contains("Boolean")) {
				boolean booleanValue = (Boolean) value;
				node.set(node.size()-1, JSONBoolean.getInstance(booleanValue));
			} else if (dataType.getName().contains("Double")) {
				double doubleValue = (Double) value;
				node.set(node.size()-1, new JSONNumber(doubleValue));
				//			} else if (value instanceof Date) {
				//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				//		        String dateValue = sdf.format(value);
				//		        node.add(dateValue);
			} else {
				node.set(node.size()-1, new JSONString(value.toString()));
			}
		}
	}

	protected void writeEObjectReferences(EObject object, JSONObject node, Resource resource) {

		for (EReference reference: object.eClass().getEAllReferences()) {

			if (!reference.isTransient() && object.eIsSet(reference)) {

				if (reference.isContainment()) {

					writeEObjectContainments(object, reference, node, resource);

				} else {

					if (reference.isMany()) {

						@SuppressWarnings("unchecked")
						EList<EObject> values = (EList<EObject>) object.eGet(reference);

						if (!values.isEmpty()) {

							final JSONArray arrayNode = new JSONArray();
							node.put(getElementName(reference), arrayNode);

							for (int i=0; i<values.size(); i++) {
								EObject obj = values.get(i);
								JSONObject nodeRef = new JSONObject();
								nodeRef.put(EJS_REF_KEYWORD, new JSONString(getReference(obj, resource)));
								arrayNode.set(i, nodeRef);
							}
						}

					} else {
						Object value = object.eGet(reference);
						if (value != null) {
							JSONObject nodeRef = new JSONObject();
							nodeRef.put(EJS_REF_KEYWORD, new JSONString(getReference(((EObject)value), resource)));
							node.put(reference.getName(), nodeRef);
						}
					}
				}
			}
		}
	}

	// if reference is containment, then objects are put in an ArrayNode
	protected void writeEObjectContainments(EObject object, EReference reference, JSONObject node, Resource resource) {

		if (reference.isMany()) {

			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) object.eGet(reference);

			if (!values.isEmpty()) {
				final JSONArray arrayNode = new JSONArray();
				node.put(getElementName(reference), arrayNode);

				for (int i=0; i<values.size(); i++) {
					EObject obj = values.get(i);
					JSONObject subNode = new JSONObject();
					arrayNode.set(i, subNode);
					writeEObjectAttributes(obj, subNode);
					writeEObjectReferences(obj, subNode, resource);
				}
			}

		} else {

			final Object value = object.eGet(reference);

			if (value != null) {
				final JSONObject subNode = new JSONObject();

				node.put(getElementName(reference), subNode);
				writeEObjectAttributes((EObject) value, subNode);
				writeEObjectReferences((EObject) value, subNode, resource);
			}
		}

	}
}
