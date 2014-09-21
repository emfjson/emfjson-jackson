package org.eclipselabs.emfjson.common;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class IDResolver {

	private final NamespaceHolder namespaces;
	private final URI resourceURI;
	private final boolean useNamespaces;
	
	private final Map<EObject, String> mapOfID = new HashMap<>();

	public IDResolver(boolean useNamespaces, URI resourceURI, NamespaceHolder namespaces) {
		this.useNamespaces = useNamespaces;
		this.resourceURI = resourceURI;
		this.namespaces = namespaces;
	}

	public IDResolver(URI resourceURI) {
		this(false, resourceURI, null);
	}

	public String get(EObject object) {
		String key = mapOfID.get(object);
		if (key != null) {
			return key;
		}

		final URI eObjectURI = EcoreUtil.getURI(object);
		final String fragment = eObjectURI.fragment();
		final URI baseURI = eObjectURI.trimFragment().trimQuery();

		if (useNamespaces && namespaces != null) {
			String prefix = baseURI.lastSegment();
			namespaces.getNamespaces().put(prefix, baseURI.toString());
			key = prefix + ":" + fragment;
		} 
		else if (baseURI.equals(resourceURI)) {
			key = fragment;
		} 
		else {
			key = eObjectURI.toString();
		}

		mapOfID.put(object, key);

		return key;
	}

	public URI get(String value) {
		if (value == null) {
			return null;
		}

		if (value.contains(":")) {
            String[] split = value.split(":");
            // is namespace prefix:fragment
            if (split.length == 2) {
            	String prefix = split[0];
            	String fragment = split[1];

                if (namespaces != null && namespaces.getNamespaces().keySet().contains(prefix)) {
                    return URI.createURI(namespaces.getNamespaces().get(prefix)).appendFragment(fragment);
                }
            }

            // is full
            return URI.createURI(value);
        } 
		else { // is fragment
            return resourceURI.appendFragment(value.startsWith("#") ? value.substring(1) : value);
        }
	}

}
