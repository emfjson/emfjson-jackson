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
package org.eclipselabs.emfjson.couchdb.ui.provider;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDatabase;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDocument;

public class CouchDBLabelProvider extends LabelProvider {
	
	public CouchDBLabelProvider(Composite parent) {
		
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
		if (element instanceof CouchDatabase) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
	}
	
}
