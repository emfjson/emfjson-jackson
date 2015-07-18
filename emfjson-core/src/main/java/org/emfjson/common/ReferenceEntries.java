package org.emfjson.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.handlers.URIHandler;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ReferenceEntries {

	private final Set<ReferenceEntry> entries = new LinkedHashSet<>();
	private final Map<String, EObject> mapOfObjects = new HashMap<>();

	public void resolve(ResourceSet resourceSet, URIHandler handler) {
		for (ReferenceEntry entry: all()) {
			entry.resolve(resourceSet, handler, this);
		}
		mapOfObjects.clear();
	}

	public void add(ReferenceEntries.ReferenceEntry entry) {
		entries.add(entry);
	}

	public Iterable<ReferenceEntries.ReferenceEntry> all() {
		return entries;
	}

	public void store(Resource resource, EObject value) {
		String fragment = resource.getURIFragment(value);
		mapOfObjects.put(fragment, value);
	}

	public void store(String id, EObject value) {
		mapOfObjects.put(id, value);
	}

	public EObject get(String id) {
		return mapOfObjects.get(id);
	}

	public interface ReferenceEntry {

		void resolve(ResourceSet resourceSet, URIHandler handler, ReferenceEntries entries);

	}

}
