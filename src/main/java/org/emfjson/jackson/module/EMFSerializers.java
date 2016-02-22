package org.emfjson.jackson.module;

import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.databind.ser.*;

import java.util.Map;

public class EMFSerializers extends SimpleSerializers {

	public EMFSerializers(JacksonOptions options) {
		addSerializer(EObject.class, new EObjectSerializer(options));
		addSerializer(Resource.class, new ResourceSerializer());
		addSerializer(Enumerator.class, new EnumeratorSerializer());
		addSerializer(EEnumLiteral.class, new EnumeratorSerializer());
		addSerializer(EMap.class, new EMapSerializer());
		addSerializer(Map.Entry.class, new EMapEntrySerializer());
	}

}
