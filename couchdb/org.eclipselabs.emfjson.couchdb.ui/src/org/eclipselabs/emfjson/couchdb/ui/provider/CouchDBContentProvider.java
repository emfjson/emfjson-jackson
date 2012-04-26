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

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDB;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDatabase;

public class CouchDBContentProvider implements ITreeContentProvider {

	private CouchDB model;
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.model = (CouchDB) newInput;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return model.getDataBases().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof CouchDatabase) {
			return ((CouchDatabase) parentElement).getDocuments().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof CouchDatabase) {
			return true;
		}
		return false;
	}

}
