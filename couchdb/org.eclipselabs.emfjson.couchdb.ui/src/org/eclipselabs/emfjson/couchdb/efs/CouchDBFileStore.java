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
package org.eclipselabs.emfjson.couchdb.efs;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.filesystem.provider.FileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class CouchDBFileStore extends FileStore {

	private URI uri;

	public CouchDBFileStore(URI uri) {
		this.uri = uri;
	}

	@Override
	public String[] childNames(int options, IProgressMonitor monitor) throws CoreException {
		return null;
	}

	@Override
	public IFileInfo fetchInfo(int options, IProgressMonitor monitor) throws CoreException {
		FileInfo fileInfo = new FileInfo(getName());
		fileInfo.setExists(true);
		fileInfo.setAttribute(EFS.ATTRIBUTE_OWNER_WRITE, true);
		
		return fileInfo;
	}

	@Override
	public IFileStore getChild(String name) {
		return null;
	}

	@Override
	public String getName() {
		return uri.getPath();
	}

	@Override
	public IFileStore getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream openInputStream(int options, IProgressMonitor monitor) throws CoreException {
//		org.eclipse.emf.common.util.URI eURI = org.eclipse.emf.common.util.URI.createURI(uri.toString());
//		ResourceSet resourceSet = new ResourceSetImpl();
//		Resource resource = resourceSet.createResource(eURI);
		
		InputStream inStream = null;
		try {
			 inStream = uri.toURL().openConnection().getInputStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inStream;
	}

	@Override
	public URI toURI() {
		return uri;
	}

}
