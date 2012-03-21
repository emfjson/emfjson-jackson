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
