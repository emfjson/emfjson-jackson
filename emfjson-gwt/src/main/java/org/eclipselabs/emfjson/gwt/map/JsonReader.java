package org.eclipselabs.emfjson.gwt.map;

import static org.eclipselabs.emfjson.common.Constants.EJS_REF_KEYWORD;
import static org.eclipselabs.emfjson.common.Constants.EJS_TYPE_KEYWORD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.common.IDResolver;
import org.eclipselabs.emfjson.common.NamespaceHolder;
import org.eclipselabs.emfjson.common.Options;
import org.eclipselabs.emfjson.common.ReferenceEntry;
import org.eclipselabs.emfjson.gwt.common.AsyncCache;
import org.eclipselabs.emfjson.gwt.common.AsyncHelper;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class JsonReader {

	private final Resource resource;
	private final ResourceSet resourceSet;
	private final Options options;
	private final AsyncCache cache = new AsyncCache();
	private final Values values = new Values();
	private final List<ReferenceEntry> entries = new ArrayList<>();

	public JsonReader(Resource resource, Options options) {
		this.resource = resource;
		this.options = options;
		this.resourceSet = resource.getResourceSet();
	}

	public void parse(JSONValue value, final Callback<Resource> done) {
		final JSONObject object = value.isObject();
		if (object != null) {
			parseObject(object, new Callback<EObject>() {
				@Override public void onFailure(Throwable caught) {
					done.onFailure(caught);
				}
				@Override public void onSuccess(EObject result) {
					resource.getContents().add(result);
					resolveEntries();
					done.onSuccess(resource);
				}
			});
		}
		
		final JSONArray array = value.isArray();
		if (array != null) {
			parseArray(array, new Callback<Resource>() {
				@Override public void onFailure(Throwable caught) {
					done.onFailure(caught);
				}
				@Override public void onSuccess(Resource result) {
					resolveEntries();
					done.onSuccess(result);
				}
			});
		}
	}

	void parseArray(JSONArray array, Callback<Resource> done) {
		AsyncHelper.forEach(resource, 0, array, this, done);
	}

	public void parseObject(final JSONObject node, final Callback<EObject> done) {
		create(node, new Callback<EObject>() {
			@Override public void onSuccess(EObject result) {
				fillObject(node, result, new Callback<EObject>() {
					@Override public void onFailure(Throwable caught) {
						done.onFailure(caught);
					}
					@Override public void onSuccess(EObject result) {
						done.onSuccess(result);
					}
				});
			}
			@Override public void onFailure(Throwable caught) {
				done.onFailure(caught);
			}
		});
	}

	private void fillObject(JSONObject node, EObject object, final Callback<EObject> done) {
		if (node == null || object == null) return;
		
		final EClass eClass = object.eClass();
		final Map<EReference, JSONValue> containments = new HashMap<>();

		for (final String key: node.keySet()) {
			final EStructuralFeature feature = cache.getEStructuralFeature(eClass, key);
			final JSONValue value = node.get(key);

			if (feature instanceof EAttribute) {

				readAttribute((EAttribute) feature, object, value);

			} else if (feature instanceof EReference) {
				EReference reference = (EReference) feature;

				if (reference.isContainment()) {
					containments.put(reference, value);
				} else {
					addEntry(object, reference, value);
				}

			}
		}

		AsyncHelper.forEach(object, containments.keySet().iterator(), containments, new Callback<EObject>() {
			@Override public void onFailure(Throwable caught) {
				done.onFailure(caught);
			}
			@Override public void onSuccess(EObject result) {
				done.onSuccess(result);
			}
		}, this);
	}

	private void addEntry(EObject object, EReference reference, JSONValue value) {
		JSONArray array = value.isArray();
		if (array != null) {
			for (int i = 0; i < array.size(); i++) {
				String ref = getRef(array.get(i));
				if (ref != null) {
					entries.add(new ReferenceEntry(object, reference, ref));
				}
			}
		} else {
			String ref = getRef(value);
			if (ref != null) {
				entries.add(new ReferenceEntry(object, reference, ref));
			}
		}
	}

	private String getRef(JSONValue value) {
		final JSONObject refObject = value.isObject();
		if (refObject != null) {
			final JSONValue refValue = refObject.get(EJS_REF_KEYWORD);
			if (refValue != null) {
				final JSONString string = refValue.isString();
				if (string != null) {
					return string.stringValue();
				}
			}
		}
		return null;
	}

	private void create(final JSONObject node, final Callback<EObject> callback) {
		cache.getEClass(resourceSet, getType(node), new Callback<EClass>() {
			@Override public void onSuccess(EClass result) {
				EObject object = EcoreUtil.create(result);
				callback.onSuccess(object);
			}
			@Override public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
		});
	}

	private String getType(JSONObject node) {
		final JSONValue typeValue = node.get(EJS_TYPE_KEYWORD);
		if (typeValue != null) {
			final JSONString stringValue = typeValue.isString();
			if (stringValue != null) {
				return stringValue.stringValue();
			}
		}
		return null;
	}

	private void readAttribute(EAttribute attribute, EObject object, JSONValue value) {
		final JSONArray array = value.isArray();
		if (array != null) {
			for (int i = 0; i < array.size(); i++) {
				values.setOrAdd(object, attribute, array.get(i));
			}
		} else {
			values.setOrAdd(object, attribute, value);
		}
	}

	private void resolveEntries() {
		for (ReferenceEntry entry: entries) {
			entry.resolve(resource.getResourceSet(), new IDResolver(false, resource.getURI(), new NamespaceHolder() {
				@Override public Map<String, String> getNamespaces() {
					return Collections.emptyMap();
				}
			}));
		}
	}

}
