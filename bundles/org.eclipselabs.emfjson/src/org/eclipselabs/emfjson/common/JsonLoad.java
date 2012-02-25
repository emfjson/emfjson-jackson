/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public interface JsonLoad {

	/**
	 * Populate the given Resource with a collection of EObjects created from a JSON Document.
	 * 
	 * @param resource
	 * @return the collection of EObject added to the resource.
	 */
	Collection<EObject> fillResource(Resource resource);
	
}
