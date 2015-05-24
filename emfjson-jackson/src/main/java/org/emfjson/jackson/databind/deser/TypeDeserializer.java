/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 */
package org.emfjson.jackson.databind.deser;

import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.core.JsonParser;

public interface TypeDeserializer {

	EClass deserialize(JsonParser jp);

}
