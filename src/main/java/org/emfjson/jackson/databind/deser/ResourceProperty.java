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
package org.emfjson.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.type.SimpleType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.common.ReferenceEntries;

public class ResourceProperty extends BeanProperty.Std {

	private final ResourceSet resourceSet;
	private final Resource resource;
	private final ReferenceEntries entries;

	private static final JavaType type = SimpleType.construct(EObject.class);
	private static final PropertyName propertyName = PropertyName.construct("contents", "org.emfjson.resource");

	public ResourceProperty(ResourceSet resourceSet, Resource resource, ReferenceEntries entries) {
		super(propertyName, type, propertyName, new AnnotationMap(), null, PropertyMetadata.STD_REQUIRED);

		this.resourceSet = resourceSet;
		this.resource = resource;
		this.entries = entries;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Resource getResource() {
		return resource;
	}

	public ReferenceEntries getEntries() {
		return entries;
	}

}
