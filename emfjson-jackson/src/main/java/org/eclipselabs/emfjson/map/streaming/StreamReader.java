package org.eclipselabs.emfjson.map.streaming;

import static org.eclipselabs.emfjson.common.Constants.EJS_TYPE_KEYWORD;
import static org.eclipselabs.emfjson.common.Constants.EJS_UUID_ANNOTATION;
import static org.eclipselabs.emfjson.common.EObjects.createEntry;
import static org.eclipselabs.emfjson.common.EObjects.isMapEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.common.Cache;
import org.eclipselabs.emfjson.common.Constants;
import org.eclipselabs.emfjson.common.EObjects;
import org.eclipselabs.emfjson.common.IDResolver;
import org.eclipselabs.emfjson.common.Options;
import org.eclipselabs.emfjson.common.ReferenceEntry;
import org.eclipselabs.emfjson.common.resource.UuidResource;
import org.eclipselabs.emfjson.map.Namespaces;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class StreamReader {

	private final ResourceSet resourceSet;
	private final Resource resource;
	private final IDResolver idResolver;
	private final Namespaces namespaces;
	private final Options options;
	private final List<ReferenceEntry> entries = new ArrayList<>();
	private final Cache cache = new Cache();

	public StreamReader(Resource resource, Options options) {
		this.resource = resource;
		this.options = options;
		this.namespaces = new Namespaces();
		this.idResolver = new IDResolver(options.serializeNamespaces, resource.getURI(), namespaces);

		if (resource.getResourceSet() == null) {
			resourceSet = new ResourceSetImpl();
		} else {
			resourceSet = resource.getResourceSet();
		}
	}

	public void parse(JsonParser parser) {
		try {
			parser.nextToken();
		} catch (IOException e) {
			return;
		}

		switch (parser.getCurrentToken()) {
		case START_OBJECT:
			EObject result = parseObject(parser, null, null, options.rootElement);
			if (result != null) {
				resource.getContents().add(result);
			}
			break;
		case START_ARRAY:
			parseArray(parser);
			break;
		default:
			break;
		};

		resolve();
		entries.clear();
	}

	private void parseArray(JsonParser parser) {
		try {
			while (parser.nextToken() != JsonToken.END_ARRAY) {
				if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
					EObject result = parseObject(parser, null, null, options.rootElement);
					if (result != null) {
						resource.getContents().add(result);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private EObject parseObject(JsonParser parser, EReference containment, EObject owner, EClass currentClass) {
		EObject current = null;

		if (currentClass != null) {
			current = EcoreUtil.create(currentClass);
		}

		try {
			while (parser.nextToken() != JsonToken.END_OBJECT) {
				final String fieldname = parser.getCurrentName();

				switch (fieldname) {
				case EJS_TYPE_KEYWORD:
					current = create(parser.nextTextValue());
					break;
				case EJS_UUID_ANNOTATION:
					if (options.useUUID && resource instanceof UuidResource) {
						if (current != null) {
							((UuidResource) resource).setID(current, parser.nextTextValue());
						}
					}
					break;
				default:
					if (current == null && containment != null) {
						EClass defaultType = containment.getEReferenceType();
						if (!defaultType.isAbstract()) {
							current = EcoreUtil.create(defaultType);
						}
					}

					if (current != null) {
						final EClass eClass = current.eClass();
						final EStructuralFeature feature = cache.getEStructuralFeature(eClass, fieldname);

						if (feature != null) {
							if (feature instanceof EAttribute) {
								readAttribute(parser, (EAttribute) feature, current);
							} else {
								readReference(parser, (EReference) feature, current);
							}
						}
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (current != null && containment != null && owner != null) {
			EObjects.setOrAdd(owner, containment, current);
		}

		return current;
	}

	private void readAttribute(JsonParser parser, EAttribute attribute, EObject owner) 
			throws JsonParseException, IOException {

		final JsonToken token = parser.nextToken();

		if (token == JsonToken.START_ARRAY) {
			while (parser.nextToken() != JsonToken.END_ARRAY) {
				EObjects.setOrAdd(owner, attribute, parser.getText());
			}
		} else {
			EObjects.setOrAdd(owner, attribute, parser.getText());
		}
	}

	private void readReference(JsonParser parser, EReference reference, EObject owner) 
			throws JsonParseException, IOException {

		JsonToken token = parser.nextToken();

		if (reference.isContainment()) {

			if (isMapEntry(reference.getEReferenceType())) {
				if (token == JsonToken.START_OBJECT) {
					token = parseEntry(parser, reference, owner);
				}
			}

			if (token == JsonToken.START_ARRAY) {
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					parseObject(parser, reference, owner, null);
				}
			} else if (token == JsonToken.START_OBJECT) {
				parseObject(parser, reference, owner, null);
			}

		} else {

			if (token == JsonToken.START_ARRAY) {
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					addReferenceEntry(parser, reference, owner);
				}
			} else {
				addReferenceEntry(parser, reference, owner);
			}
		}

	}

	@SuppressWarnings("unchecked")
	private JsonToken parseEntry(JsonParser parser, EReference reference, EObject owner) 
			throws JsonParseException, IOException {

		EList<EObject> values = null;
		if (reference.isMany()) {
			values = (EList<EObject>) owner.eGet(reference);
		}

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			final String field = parser.getCurrentName();
			final String value = parser.nextTextValue();

			if (reference.isMany() && values != null) {
				values.add(createEntry(field, value));
			} else {
				owner.eSet(reference, createEntry(field, value));
			}
		}

		return parser.getCurrentToken();
	}

	private void addReferenceEntry(JsonParser parser, EReference reference, EObject owner) 
			throws JsonParseException, IOException {

		String id = null;

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String field = parser.getCurrentName();
			if (field == Constants.EJS_REF_KEYWORD) {
				id = parser.nextTextValue();
			}
		}
		entries.add(new ReferenceEntry(owner, reference, id));
	}

	private EObject create(String type) {
		EClass eClass = cache.getEClass(resourceSet, type);
		if (eClass != null) {
			return EcoreUtil.create(eClass);
		}
		return null;
	}

	private void resolve() {
		for (ReferenceEntry entry: entries) {
			entry.resolve(resourceSet, idResolver);
		}
	}

}
