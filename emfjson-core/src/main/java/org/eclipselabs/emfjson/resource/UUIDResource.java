package org.eclipselabs.emfjson.resource;

import org.eclipse.emf.ecore.EObject;

public interface UUIDResource {

	/**
	 * Returns the ID that was assigned with {@link #setID(EObject, String)}; if there is
	 * no ID, it returns null.
	 */
	String getID(EObject eObject);

	/**
	 * Sets the ID for the given object. If you are storing the ID
	 * with the object itself, you should override this method.  You can remove the
	 * ID of a given eObject by using <code>null</code> as the id value.
	 */
	void setID(EObject eObject, String id);

}
