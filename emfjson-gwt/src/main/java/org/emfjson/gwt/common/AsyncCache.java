package org.emfjson.gwt.common;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.common.Cache;

public class AsyncCache extends Cache {

	public void getEClass(final ResourceSet resourceSet, final String type, final Callback<EClass> callback) {
		if (type == null) {
			callback.onFailure(new IllegalArgumentException("Cannot get EClass from null identifier."));
		}

		final EClass eClass = mapOfClasses.get(type);
		if (eClass == null) {
			URI uri = mapOfURIs.get(type);
			if (uri == null) {
				uri = URI.createURI(type);
				mapOfURIs.put(type, uri);
			}
			resourceSet.getEObject(uri, new Callback<EObject>() {
				@Override
				public void onSuccess(EObject result) {
					if (result instanceof EClass) {
						final EClass resultEClass = (EClass) result;
						mapOfClasses.put(type, resultEClass);
						callback.onSuccess(resultEClass);
					} else {
						callback.onFailure(new ClassCastException("Cannot cast object " + result + " as EClass."));
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);	
				}
			});
		} else {
			callback.onSuccess(eClass);
		}
	}

}
