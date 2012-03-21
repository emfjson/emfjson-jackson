package org.eclipselabs.emfjson.couchdb.ui.provider;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDatabase;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDocument;

public class CouchDBLabelProvider extends LabelProvider {

//	private Composite parent;

	public CouchDBLabelProvider(Composite parent) {
//		this.parent = parent;
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof CouchDatabase) {
			return ((CouchDatabase) element).getName() + " (" + ((CouchDatabase) element).getDocuments().size() + ")";
		}
		return ((CouchDocument) element).getId();
	}
	
	@Override
	public Image getImage(Object element) {
//		Image img = new Image(parent.getDisplay(), getClass().getResourceAsStream("glyphicons_144_folder_open.png"));
		if (element instanceof CouchDatabase) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
//			return img;
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
	}
	
}
