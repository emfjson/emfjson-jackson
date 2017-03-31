package org.emfjson.jackson.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Utils {

	public static String uriOf(EObject object) {
		return EcoreUtil.getURI(object).toString();
	}

}
