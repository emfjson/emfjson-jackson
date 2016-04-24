package org.emfjson.jackson.internal;

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
