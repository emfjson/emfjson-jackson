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
package org.eclipselabs.emfjson.ui.wizards;

import org.eclipse.emf.converter.ModelConverter;
import org.eclipse.emf.importer.ui.contribution.base.ModelImporterPackagePage;
import org.eclipse.emf.importer.ui.contribution.base.ModelImporterWizard;
import org.eclipselabs.emfjson.ui.EcoreJsonModelImporter;

public class EcoreJsonImporterWizard extends ModelImporterWizard {
	
	@Override
	protected ModelConverter createModelConverter() {
		return new EcoreJsonModelImporter();
	}

	@Override
	public void addPages() {
//		ModelImporterDetailPage detailPage = new ModelImporterDetailPage(getModelImporter(), "EcoreModel");
//		detailPage.setTitle("EMF Json Importer");
//		detailPage.setDescription(EcoreImporterPlugin.INSTANCE.getString(detailPage.showGenModel() ?
//				"_UI_EcoreImportNewProject_description" : "_UI_EcoreImportFile_description"));    
//		addPage(detailPage);

		ModelImporterPackagePage packagePage = new ModelImporterPackagePage(getModelImporter(), "EcorePackages");
		packagePage.setShowReferencedGenModels(true);
		addPage(packagePage);
	}

}
