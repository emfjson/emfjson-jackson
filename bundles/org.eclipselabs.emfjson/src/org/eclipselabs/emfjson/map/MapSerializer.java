/*******************************************************************************
 * Copyright (c) 2013 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.map;

import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipselabs.emfjson.common.ModelUtil;

class MapSerializer {
		
	void serialize(EObject eObject, ObjectNode node) {
		EClass eClass = eObject.eClass();
		EStructuralFeature eFeature = ModelUtil.getDynamicMapEntryFeature(eClass);
	
		if (eFeature != null) {
			@SuppressWarnings("unchecked")
			EList<EObject> values = (EList<EObject>) eObject.eGet(eFeature);
	
			for (EObject value: values) {
				Object key = value.eGet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY);
				Object val = value.eGet(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE);
	
				if (key instanceof String && val instanceof String) {
					node.put((String) key, (String) val);
				}
			}
		}
	}

}
