package org.emfjson.jackson.module;

import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.deser.EObjectDeserializer;
import org.emfjson.jackson.databind.deser.ResourceDeserializer;

public class EMFDeserializers extends SimpleDeserializers {

	public EMFDeserializers(ResourceSet resourceSet, JacksonOptions options) {
		addDeserializer(EObject.class, new EObjectDeserializer(resourceSet, options));
		addDeserializer(Resource.class, new ResourceDeserializer(resourceSet, options));
	}

}
