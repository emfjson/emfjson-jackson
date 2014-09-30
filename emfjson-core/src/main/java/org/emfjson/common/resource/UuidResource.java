/*
 * Copyright (c) 2011-2014 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.common.resource;

import org.eclipse.emf.ecore.EObject;

public interface UuidResource {

	/**
	 * Returns the ID that was assigned with #setID(EObject, String) if there is
	 * no ID, it returns null.
	 */
	String getID(EObject eObject);

	/**
	 * Sets the ID for the given object. If you are storing the ID
	 * with the object itself, you should override this method.  You can remove the
	 * ID of a given eObject by using <code>null</code> as the id value.
	 */
	void setID(EObject eObject, String id);

}
