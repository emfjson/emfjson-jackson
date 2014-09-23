package org.emfjson.jackson.map;

import static org.emfjson.common.Constants.EJS_REF_KEYWORD;
import static org.emfjson.common.Constants.EJS_TYPE_KEYWORD;
import static org.emfjson.common.Constants.EJS_UUID_ANNOTATION;
import static org.emfjson.common.EObjects.setOrAdd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.common.Cache;
import org.emfjson.common.IDResolver;
import org.emfjson.common.Options;
import org.emfjson.common.ReferenceEntry;
import org.emfjson.common.resource.UuidResource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ObjectReader {

	private final ResourceSet resourceSet;
	private final Options options;

	private final IDResolver idResolver;

	private final Set<ReferenceEntry> resolveEntries = new HashSet<>();
	private final Cache cache = new Cache();
	private final Resource resource;

	public ObjectReader(Resource resource, ResourceSet resourceSet, Options options) {
		this.resource = resource;
		this.resourceSet = resourceSet;
		this.options = options;
		this.idResolver = new IDResolver(resource.getURI());
	}

	public EObject from(JsonNode node) {
		EObject result = create(node);

		if (result != null) {
			fillObject(result, node);
		}

		return result;
	}
	
	private EObject fillObject(EObject object, JsonNode node) {
		if (object == null) return null;

		final EClass eClass = object.eClass();

		if (options.useUUID && node.has(EJS_UUID_ANNOTATION) && resource instanceof UuidResource) {
			String _id = node.get(EJS_UUID_ANNOTATION).asText();
			((UuidResource) resource).setID(object, _id);
		}

		for (final Iterator<Entry<String, JsonNode>> it = node.fields(); it.hasNext();) {
			final Entry<String, JsonNode> entry = it.next();
			final String key = entry.getKey();
			final JsonNode value = entry.getValue();
			final EStructuralFeature feature = cache.getEStructuralFeature(eClass, key);

			if (key.equals(EJS_REF_KEYWORD)) {
				((InternalEObject) object).eSetProxyURI(URI.createURI(value.asText()));
			}

			if (feature != null) {
				if (feature instanceof EAttribute) {
					readAttribute((EAttribute) feature, object, value);
				} else {					
					readReference((EReference) feature, object, value);
				}
			}
		}

		return object;
	}

	private void readAttribute(EAttribute attribute, EObject target, JsonNode value) {
		if (value.isArray()) {
			ArrayNode array = (ArrayNode) value;
			for (Iterator<JsonNode> it = array.elements(); it.hasNext();) {
				setOrAdd(target, attribute, it.next().asText());
			}
		} else {
			setOrAdd(target, attribute, value.asText());
		}
	}

	private void readReference(EReference reference, EObject owner, JsonNode value) {
		if (reference.isContainment()) {

			if (value.isArray()) {

				final ArrayNode array = (ArrayNode) value;
				for (Iterator<JsonNode> it = array.elements(); it.hasNext();) {
					final JsonNode current = it.next();
					final EObject contained = fillObject(create(current, reference), current);

					setOrAdd(owner, reference, contained);
				}

			} else if (value.isObject()) {
				final EObject contained = fillObject(create(value, reference), value);

				setOrAdd(owner, reference, contained);
			}

		} else {
			if (value.isArray()) {
				for (Iterator<JsonNode> it = value.elements(); it.hasNext();) {
					JsonNode current = it.next();
					resolveEntries.add(new ReferenceEntry(
							owner, 
							reference, 
							current.get(EJS_REF_KEYWORD).asText()));
				}
			} else {
				resolveEntries.add(new ReferenceEntry(
						owner, 
						reference, 
						value.get(EJS_REF_KEYWORD).asText()));
			}
		}
	}

	private EObject create(JsonNode current, EReference reference) {
		EClass type = reference.getEReferenceType();
		if (type.isAbstract()) {
			return create(current);
		}

		return EcoreUtil.create(type);
	}

	private EObject create(JsonNode node) {
		final EClass eClass = getType(node);
		return eClass != null ? EcoreUtil.create(eClass) : null;
	}

	private EClass getType(JsonNode node) {
		if (node.has(EJS_TYPE_KEYWORD)) {
			return cache.getEClass(resourceSet, node.get(EJS_TYPE_KEYWORD).asText());
		} else if (options.rootElement != null) {
			return options.rootElement;
		}
		return null;
	}

	public void resolveEntries() {
		for (ReferenceEntry entry: resolveEntries) {
			entry.resolve(resourceSet, idResolver);
		}
	}

}
