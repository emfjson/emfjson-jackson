package org.emfjson.jackson.databind.ser.references;

import com.fasterxml.jackson.core.JsonGenerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.handlers.URIHandler;
import org.emfjson.jackson.internal.Cache;
import org.emfjson.jackson.resource.JsonResource;

import java.io.IOException;

public class AsObjectSerializer extends EReferenceSerializer {

	@Override
	public void serialize(EObject value, JsonGenerator jg, EObject parent, Cache cache, URIHandler handler) throws IOException {
		if (value == null) {
			jg.writeNull();
		} else {
			URI targetURI = cache.getURI(value);

			jg.writeStartObject();
			if (isExternal(parent, value)) {
				targetURI = deresolve(handler, targetURI, cache, parent);

				if (targetURI == null) {
					jg.writeNullField(getProperty());
				} else {
					jg.writeStringField(getPropertyType(), cache.getURI(value.eClass()).toString());
					jg.writeStringField(getProperty(), targetURI.toString());
				}
			} else {
				Resource resource = value.eResource();
				String id = null;
				if (resource instanceof JsonResource) {
					id = ((JsonResource) resource).getID(value);
				}
				if (id == null) {
					id = resource.getURIFragment(value);
				}

				jg.writeStringField(getProperty(), id);
			}
			jg.writeEndObject();
		}
	}

}
