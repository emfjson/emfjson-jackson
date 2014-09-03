package org.eclipselabs.emfjson.junit.model.support;

import static org.eclipse.emf.ecore.util.EcoreUtil.getURI;
import static org.eclipselabs.emfjson.common.Constants.EJS_UUID_ANNOTATION;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.gwt.map.JsonMapper;
import org.eclipselabs.emfjson.gwt.resource.JsonResource;
import org.eclipselabs.emfjson.junit.model.ModelPackage;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.junit.client.GWTTestCase;

public class UuidTestSupport extends GWTTestCase {

	protected JsonMapper mapper;
	protected Map<String, Object> options = new HashMap<>();
	protected ResourceSet resourceSet = new ResourceSetImpl();

	protected String uuid(EObject object) {
		return getURI(object).fragment();
	}

	protected String uuid(JSONObject node) {
		return node.get(EJS_UUID_ANNOTATION).isString().stringValue();
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
		options.put(EMFJs.OPTION_USE_UUID, true);
	}

	@Override
	public String getModuleName() {
		return "org.eclipselabs.emfjson.junit.model.Model";
	}

}
