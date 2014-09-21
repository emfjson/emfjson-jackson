package org.eclipselabs.emfjson.map;

import static org.eclipselabs.emfjson.common.Constants.EJS_REF_KEYWORD;
import static org.eclipselabs.emfjson.common.Constants.EJS_TYPE_KEYWORD;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.emfjson.common.IDResolver;
import org.eclipselabs.emfjson.common.Options;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ReferenceWriter {

	private Options options;
	private IDResolver ids;

	public ReferenceWriter(IDResolver idResolver, Options options) {
		this.ids = idResolver;
		this.options = options;
	}

	public void serialize(ObjectNode parent, String key, EReference reference, Object value) {
		if (reference.isMany()) {
			serializeMany(parent, key, (Collection<?>) value);
		} else {
			serializeOne(parent, key, (EObject) value);
		}
	}

	public void serializeMany(ObjectNode parent, String key, Collection<?> values) {
		if (values == null || values.isEmpty()) return;

		ArrayNode arrayNode = parent.arrayNode();
		parent.set(key, arrayNode);

		for (Object current: values) {
			if (current instanceof EObject) {
				EObject value = (EObject) current;
				String ref = ids.get(value);
				String type = ids.get(value.eClass());
				createObjectRef(arrayNode.addObject(), ref, type);
			}
		}
	}

	public void serializeOne(ObjectNode parent, String key, EObject value) {
		if (value != null) {
			final String ref = ids.get(value);
			final String type = ids.get(value.eClass());

			parent.set(key, createObjectRef(parent.objectNode(), ref, type));
		}
	}

	public ObjectNode createObjectRef(ObjectNode node, String ref, String type) {
		if (options.serializeRefTypes) {
			node.put(EJS_TYPE_KEYWORD, type);
		}
		node.put(EJS_REF_KEYWORD, ref);
		return node;
	}

	public ObjectNode createObjectRef(ObjectNode target, EObject object) {
		final String ref = ids.get(object);
		final String type = ids.get(object.eClass());

		return createObjectRef(target, ref, type);
	}

}
