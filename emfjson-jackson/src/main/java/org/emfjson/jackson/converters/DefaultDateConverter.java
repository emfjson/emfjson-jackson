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
package org.emfjson.jackson.converters;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.converters.DateConverter;

public class DefaultDateConverter extends DateConverter {

	@Override
	public Date createFromValue(String value) {
		return (Date) EcoreUtil.createFromString(EcorePackage.Literals.EDATE, value);
	}

	@Override
	public String getValue(Object date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return sdf.format(date);
	}

}
