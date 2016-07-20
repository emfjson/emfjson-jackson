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
package org.emfjson.jackson.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

public class ELists {

	public static EObject getEObject(EList<?> list) {
		if (list instanceof EcoreEList) {
			return ((EcoreEList) list).getEObject();
		} else if (list instanceof EcoreEMap) {
			return ((EcoreEMap) list).getEObject();
		} else if (list instanceof FeatureMapUtil.FeatureEList) {
			return ((FeatureMapUtil.FeatureEList) list).getEObject();
		}
		return null;
	}

	public static EStructuralFeature getFeature(EList<?> list) {
		if (list instanceof EcoreEList) {
			return ((EcoreEList) list).getEStructuralFeature();
		} else if (list instanceof EcoreEMap) {
			return ((EcoreEMap) list).getEStructuralFeature();
		} else if (list instanceof FeatureMapUtil.FeatureEList) {
			return ((FeatureMapUtil.FeatureEList) list).getEStructuralFeature();
		}

		return null;
	}
}
