/*******************************************************************************
 * Copyright (c) 2012 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.importer.ModelImporter;
import org.eclipselabs.emfjson.resource.JsResourceImpl;

public class EcoreJsonModelImporter extends ModelImporter {

	@Override
	public String getID() {
		return "org.eclipse.emf.importer.ecore";
	}
	
	@Override
	public void addToResource(EPackage ePackage, ResourceSet resourceSet) {
		if (ePackage.eResource() == null) {
			 EPackageImportInfo ePackageInfo = getEPackageImportInfo(ePackage);
		      String fileName = ePackageInfo.getEcoreFileName();
		      if (fileName != null)
		      {
		        String baseLocation = getGenModelPath().removeLastSegments(1).toString() + "/";
		        String ecoreFileName = baseLocation + fileName;
		        URI ecoreURI = createFileURI(ecoreFileName);
		        Resource resource = new JsResourceImpl(ecoreURI);
		        resource.getContents().add(ePackage);
		      }
		}
//		super.addToResource(ePackage, resourceSet);
	}
}
