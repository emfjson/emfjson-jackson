/*******************************************************************************
 * Copyright (c) 2013 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.emfjson.utils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.emfjson.common.Constants;

/**
 * @author bhunt
 * 
 */
public class EObjectJsonDocumentationBuilder
{
	private StringBuilder rep = new StringBuilder();

	public EObjectJsonDocumentationBuilder(EClass eClass)
	{
		appendEClass(eClass, "", new HashSet<EClass>());
		rep.append("\n");
	}

	public String toString()
	{
		return rep.toString();
	}

	private void appendEClass(EClass eClass, String indent, Set<EClass> eClassHistory)
	{
		rep.append("\n");
		rep.append(indent);
		rep.append("{\n");
		appendAttribute(Constants.EJS_TYPE_KEYWORD, "\"" + eClass.getEPackage().getNsURI() + "#//" + eClass.getName() + "\"", indent + "  ");

		if (!eClassHistory.contains(eClass))
		{
			eClassHistory.add(eClass);

			for (EAttribute attribute : eClass.getEAllAttributes())
				appendEAttribute(attribute, indent + "  ");

			for (EReference reference : eClass.getEAllReferences())
				appendEReference(reference, indent + "  ", eClassHistory);
		}

		rep.append("\n");
		rep.append(indent);
		rep.append("}");
	}

	private void appendEAttribute(EAttribute attribute, String indent)
	{
		rep.append(", ");
		rep.append("\n");
		appendAttribute(attribute.getName(), attribute.getEAttributeType().getInstanceClassName(), indent);
	}

	private void appendAttribute(String name, String value, String indent)
	{
		rep.append(indent);
		rep.append(name);
		rep.append(" : ");
		rep.append(value);
	}

	private void appendEReference(EReference reference, String indent, Set<EClass> eClassHistory)
	{
		rep.append(", ");
		rep.append("\n");
		rep.append(indent);
		rep.append(reference.getName());
		rep.append(" : ");

		if (reference.isContainment())
			appendEClass((EClass) reference.getEType(), indent, eClassHistory);
		else
			appendProxy((EClass) reference.getEType(), indent);
	}

	private void appendProxy(EClass eClass, String indent)
	{
		rep.append("\n");
		rep.append(indent);
		rep.append("{ ");
		rep.append("\n");
		appendAttribute("eClass", eClass.getEPackage().getNsURI() + "#//" + eClass.getName(), indent + "  ");
		rep.append(", ");
		rep.append("\n");
		appendAttribute(Constants.EJS_REF_KEYWORD, String.class.getName(), indent + "  ");
		rep.append("\n");
		rep.append(indent);
		rep.append("}");
	}
}
