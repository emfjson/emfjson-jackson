/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.EMFJs;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.module.EMFModule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static java.util.Collections.synchronizedMap;

/**
 * A Resource implementation that read and write it's content in JSON.
 */
public class JsonResource extends ResourceImpl {

	protected static final Map<EObject, String> DETACHED_EOBJECT_TO_ID_MAP = synchronizedMap(new WeakHashMap<EObject, String>());

	private final ObjectMapper mapper;

	private Map<String, EObject> idToEObjectMap;
	private Map<EObject, String> eObjectToIDMap;

	public JsonResource(URI uri, ObjectMapper mapper) {
		super(uri);

		this.mapper = mapper;
	}

//	@Deprecated
//	public JsonResource(URI uri) {
//		super(uri);
//	}

	@Override
	protected boolean isAttachedDetachedHelperRequired() {
		return useIDs() || super.isAttachedDetachedHelperRequired();
	}

	protected boolean useIDs() {
		return eObjectToIDMap != null || idToEObjectMap != null || useUUIDs();
	}

	protected boolean useIDAttributes() {
		return true;
	}

	protected boolean useUUIDs() {
		return false;
	}

	public String getID(EObject eObject) {
		if (eObjectToIDMap == null) {
			return null;
		} else {
			return eObjectToIDMap.get(eObject);
		}
	}

	@Override
	protected EObject getEObjectByID(String id) {
		if (idToEObjectMap != null) {
			EObject eObject = idToEObjectMap.get(id);

			if (eObject != null) {
				return eObject;
			}
		}
		return super.getEObjectByID(id);
	}

	@Override
	public String getURIFragment(EObject eObject) {
		String id = getID(eObject);

		if (id != null) {
			return id;
		} else {
			return super.getURIFragment(eObject);
		}
	}

	public void setID(EObject eObject, String id) {
		String oldID = id != null ? getEObjectToIDMap().put(eObject, id) :
				getEObjectToIDMap().remove(eObject);

		if (oldID != null) {
			getIDToEObjectMap().remove(oldID);
		}

		if (id != null) {
			getIDToEObjectMap().put(id, eObject);
		}
	}

	@Override
	protected void attachedHelper(EObject eObject) {
		super.attachedHelper(eObject);

		String id = getID(eObject);

		if (id == null) {
			if (!isLoading()) {
				id = DETACHED_EOBJECT_TO_ID_MAP.remove(eObject);
				if (id == null) {
					id = EcoreUtil.generateUUID();
				}
				setID(eObject, id);
			}
		} else {
			getIDToEObjectMap().put(id, eObject);
		}
	}

	public Map<String, EObject> getIDToEObjectMap() {
		if (idToEObjectMap == null) {
			idToEObjectMap = new HashMap<>();
		}
		return idToEObjectMap;
	}

	public Map<EObject, String> getEObjectToIDMap() {
		if (eObjectToIDMap == null) {
			eObjectToIDMap = new HashMap<>();
		}
		return eObjectToIDMap;
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (inputStream instanceof URIConverter.Loadable) {

			((URIConverter.Loadable) inputStream).loadResource(this);

		} else {

			ContextAttributes attributes = ContextAttributes
				.getEmpty()
					.withPerCallAttribute("resourceSet", getResourceSet())
					.withPerCallAttribute("resource", this);

			mapper.reader()
				.with(attributes)
				.forType(Resource.class)
				.readValue(inputStream);

		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (options == null) {
			options = Collections.<String, Object> emptyMap();
		}

		if (outputStream instanceof URIConverter.Saveable) {

			((URIConverter.Saveable) outputStream).saveResource(this);

		} else {

//			final ObjectMapper mapper = new ObjectMapper();
//			final JacksonOptions jacksonOptions = getOptions(options);
//			mapper.setDateFormat(jacksonOptions.dateFormat);
//			mapper.configure(SerializationFeature.INDENT_OUTPUT, jacksonOptions.indentOutput);
//			mapper.registerModule(new EMFModule(this.getResourceSet(), jacksonOptions));

			outputStream.write(mapper
					.writeValueAsBytes(this));
		}
	}

	private JacksonOptions getOptions(Map<?, ?> options) {
		if (options.containsKey(EMFJs.OPTIONS_OBJECT)) {
			Object value = options.get(EMFJs.OPTIONS_OBJECT);

			if (value instanceof JacksonOptions) {
				return (JacksonOptions) value;
			}
		}

		return JacksonOptions.from(options);
	}

}
