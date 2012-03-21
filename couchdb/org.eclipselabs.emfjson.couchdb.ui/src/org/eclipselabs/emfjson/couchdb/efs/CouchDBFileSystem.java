package org.eclipselabs.emfjson.couchdb.efs;

import java.net.URI;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileSystem;

public class CouchDBFileSystem extends FileSystem {

	public CouchDBFileSystem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IFileStore getStore(URI uri) {
		return new CouchDBFileStore(uri);
	}

}
