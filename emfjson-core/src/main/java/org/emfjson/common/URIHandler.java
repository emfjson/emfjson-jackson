package org.emfjson.common;

import org.eclipse.emf.common.util.URI;

public interface URIHandler {

	URI resolve(URI uri);

	URI dereseolve(URI uri);

}
