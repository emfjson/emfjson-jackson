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
package org.emfjson.jackson.databind.ser.references;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractReferenceSerializer implements ReferenceSerializer {

	public boolean isExternal(EObject source, EObject target) {
		return !source.eResource().equals(target.eResource());
	}

}
