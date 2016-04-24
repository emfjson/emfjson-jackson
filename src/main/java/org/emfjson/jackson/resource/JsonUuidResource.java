package org.emfjson.jackson.resource;

import org.eclipse.emf.common.util.URI;

public class JsonUuidResource extends JsonResource {

	public JsonUuidResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {
		return true;
	}

}
