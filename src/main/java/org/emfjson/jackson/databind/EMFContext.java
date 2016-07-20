/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.jackson.databind;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.databind.deser.references.ReferenceEntries;
import org.emfjson.jackson.databind.type.EcoreTypeFactory;
import org.emfjson.jackson.utils.Cache;

import java.util.HashMap;
import java.util.Map;

public class EMFContext {

	public enum Attributes {
		//
		RESOURCE_SET,
		RESOURCE_URI,
		RESOURCE,
		ROOT_ELEMENT,
		//
		CACHE,
		TYPE_FACTORY,
		REFERENCE_ENTRIES,
		CURRENT_DATATYPE,
		CURRENT_FEATURE,
		CURRENT_REFERENCE,
		CURRENT_PARENT
	}

	public static void prepare(DatabindContext ctxt) {
		if (getResourceSet(ctxt) == null) {
			ctxt.setAttribute(Attributes.RESOURCE_SET, new ResourceSetImpl());
		}
		if (getEntries(ctxt) == null) {
			ctxt.setAttribute(Attributes.REFERENCE_ENTRIES, new ReferenceEntries());
		}
	}

	public static ContextAttributes from(Map<?, ?> options) {
		return ContextAttributes
				.getEmpty()
				.withSharedAttributes(options == null ? new HashMap<>(): new HashMap<>(options));
	}

	@Deprecated
	public static EcoreTypeFactory getEcoreType(DatabindContext context) {
		EcoreTypeFactory ecoreType = (EcoreTypeFactory) context.getAttribute(Attributes.TYPE_FACTORY);
		if (ecoreType == null) {
			context.setAttribute(Attributes.TYPE_FACTORY, ecoreType = new EcoreTypeFactory());
		}

		return ecoreType;
	}

	public static Cache getCache(DatabindContext context) {
		Cache cache = (Cache) context.getAttribute(Attributes.CACHE);
		if (cache == null) {
			context.setAttribute(Attributes.CACHE, cache = new Cache());
		}

		return cache;
	}

	public static ResourceSet getResourceSet(DatabindContext context) {
		try {
			return (ResourceSet) context.getAttribute(Attributes.RESOURCE_SET);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static Resource getResource(DatabindContext context) {
		try {
			return (Resource) context.getAttribute(Attributes.RESOURCE);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static URI getURI(DatabindContext context) {
		try {
			return (URI) context.getAttribute(Attributes.RESOURCE_URI);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static EClass getRoot(DatabindContext context) {
		try {
			return (EClass) context.getAttribute(Attributes.ROOT_ELEMENT);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static EObject getParent(DatabindContext ctxt) {
		try {
			return (EObject) ctxt.getAttribute(Attributes.CURRENT_PARENT);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static EReference getReference(DatabindContext ctxt) {
		try {
			return (EReference) ctxt.getAttribute(Attributes.CURRENT_REFERENCE);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static EStructuralFeature getFeature(DatabindContext ctxt) {
		try {
			return (EStructuralFeature) ctxt.getAttribute(Attributes.CURRENT_FEATURE);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static EDataType getDataType(DatabindContext ctxt) {
		try {
			return (EDataType) ctxt.getAttribute(Attributes.CURRENT_DATATYPE);
		} catch (ClassCastException e) {
			return null;
		}
	}

	public static ReferenceEntries getEntries(DatabindContext ctxt) {
		try {
			return (ReferenceEntries) ctxt.getAttribute(Attributes.REFERENCE_ENTRIES);
		} catch (ClassCastException e) {
			ReferenceEntries entries = new ReferenceEntries();
			ctxt.setAttribute(Attributes.REFERENCE_ENTRIES, entries);

			return entries;
		}
	}

}
