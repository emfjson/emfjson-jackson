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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.emfjson.common.ReferenceEntry;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.type.SimpleType;

import java.lang.annotation.Annotation;
import java.util.List;

public class ResourceProperty implements BeanProperty {

	private final ResourceSet resourceSet;
	private final Resource resource;
	private final List<ReferenceEntry> entries;

	public ResourceProperty(ResourceSet resourceSet, Resource resource, List<ReferenceEntry> entries) {
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

	public List<ReferenceEntry> getEntries() {
		return entries;
	}

	@Override
	public String getName() {
		return "contents";
	}

	@Override
	public PropertyName getFullName() {
		return PropertyName.construct("contents", "org.emfjson.resource");
	}

	@Override
	public JavaType getType() {
		return SimpleType.construct(EObject.class);
	}

	@Override
	public PropertyName getWrapperName() {
		return null;
	}

	@Override
	public PropertyMetadata getMetadata() {
		return null;
	}

	@Override
	public boolean isRequired() {
		return false;
	}

	@Override
	public <A extends Annotation> A getAnnotation(Class<A> acls) {
		return null;
	}

	@Override
	public <A extends Annotation> A getContextAnnotation(Class<A> acls) {
		return null;
	}

	@Override
	public AnnotatedMember getMember() {
		return null;
	}

	@Override
	public void depositSchemaProperty(JsonObjectFormatVisitor objectVisitor) throws JsonMappingException {}

}
