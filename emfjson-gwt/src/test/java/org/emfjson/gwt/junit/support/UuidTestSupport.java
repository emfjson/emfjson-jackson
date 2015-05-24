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
package org.emfjson.gwt.junit.support;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.junit.client.GWTTestCase;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.emfjson.EMFJs;
import org.emfjson.gwt.junit.model.ModelPackage;
import org.emfjson.gwt.map.JsonMapper;
import org.emfjson.gwt.resource.JsonResource;

import java.util.HashMap;
import java.util.Map;

import static org.eclipse.emf.ecore.util.EcoreUtil.getURI;

public class UuidTestSupport extends GWTTestCase {

	protected JsonMapper mapper;
	protected Map<String, Object> options = new HashMap<>();
	protected ResourceSet resourceSet = new ResourceSetImpl();

	protected String uuid(EObject object) {
		return getURI(object).fragment();
	}

	protected String uuid(JSONObject node) {
		return node.get("_id").isString().stringValue();
	}

	protected Resource createUuidResource(String name) {
		Resource resource = new JsonResource(URI.createURI(name)) {
			@Override
			protected boolean useUUIDs() {
				return true;
			}
		};
		resourceSet.getResources().add(resource);
		return resource;
	}

	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();

		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		mapper = new JsonMapper();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
	}

	@Override
	public String getModuleName() {
		return "org.emfjson.gwt.junit.Model";
	}

}
