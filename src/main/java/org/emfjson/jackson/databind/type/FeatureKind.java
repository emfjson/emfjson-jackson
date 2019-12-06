/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */

package org.emfjson.jackson.databind.type;

import org.eclipse.emf.ecore.*;

public enum FeatureKind {
	SINGLE_ATTRIBUTE,
	MANY_ATTRIBUTE,
	SINGLE_REFERENCE,
	MANY_REFERENCE,
	SINGLE_CONTAINMENT,
	MANY_CONTAINMENT,
	MAP,
	UNKNOWN;

	public static FeatureKind get(ETypedElement feature) {
		if (feature == null) {
			return UNKNOWN;
		}

		if (isMap(feature.getEType())) {
			return MAP;
		}

		if (feature instanceof EAttribute) {
			return feature.isMany() ? MANY_ATTRIBUTE: SINGLE_ATTRIBUTE;
		} else if (feature instanceof EReference) {
			return ((EReference) feature).isContainment() ?
					feature.isMany() ?
							MANY_CONTAINMENT: SINGLE_CONTAINMENT:
					feature.isMany() ?
							MANY_REFERENCE: SINGLE_REFERENCE;
		} else if (feature instanceof EOperation) {
			return feature.isMany() ?
					MANY_ATTRIBUTE: SINGLE_ATTRIBUTE;
		}

		return UNKNOWN;
	}

	private static boolean isMap(EClassifier type) {
		return "java.util.Map$Entry".equals(type.getInstanceClassName()) ||
				"java.util.Map.Entry".equals(type.getInstanceClassName());
	}
}
