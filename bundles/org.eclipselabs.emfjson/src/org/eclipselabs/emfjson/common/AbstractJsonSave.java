package org.eclipselabs.emfjson.common;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.EMFJs;

public abstract class AbstractJSONSave {

	protected boolean serializeTypes = true;
	protected boolean indent = true;
	protected Map<?, ?> options;
	
	public AbstractJSONSave(Map<?, ?> options) {
		this.options = options;
		configure();
	}
	
	private void configure() {
		if (options.containsKey(EMFJs.OPTION_INDENT_OUTPUT)) {
			try {
				indent = (Boolean) options.get(EMFJs.OPTION_INDENT_OUTPUT);
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}
		if (options.containsKey(EMFJs.OPTION_SERIALIZE_TYPE)) {
			try {
				serializeTypes = (Boolean) options.get(EMFJs.OPTION_SERIALIZE_TYPE);
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected String getReference(EObject obj, Resource resource) {
		if (obj.eIsProxy()) {
			return ((InternalEObject)obj).eProxyURI().toString();
		}
		URI eObjectURI = EcoreUtil.getURI(obj);
		if (eObjectURI.trimFragment().equals(resource.getURI())) {
			return eObjectURI.fragment();
		}
		return eObjectURI.toString();
	}
}
