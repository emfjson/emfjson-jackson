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
package com.emfjson.resource;

import org.eclipse.emf.ecore.resource.Resource;

public interface JSONResource
	extends Resource {

	final String APPLICATION_JSON = "application/json";
	
	final String OPTION_ROOT_ELEMENT = "OPTION_ROOT_ELEMENT";

	final String OPTION_URL_PARAMETERS = "OPTION_URL_PARAMETERS";
	
}
