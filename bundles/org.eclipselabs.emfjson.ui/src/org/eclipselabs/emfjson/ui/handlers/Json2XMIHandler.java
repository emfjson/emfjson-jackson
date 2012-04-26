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
package org.eclipselabs.emfjson.ui.handlers;

import java.io.IOException;
import java.net.URI;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class Json2XMIHandler extends AbstractHandler {
	
	
	private ResourceSet resourceSet = new ResourceSetImpl();
	
	/**
	 * The constructor.
	 */
	public Json2XMIHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		Object firstElement = selection.getFirstElement();
		
		if (firstElement instanceof IResource) {
			URI locationURI = ((IResource) firstElement).getLocationURI();
			Resource json = resourceSet.createResource(org.eclipse.emf.common.util.URI.createURI(locationURI.toString()));
			try {
				json.load(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (json.isLoaded()) {
				Resource xmi = resourceSet.createResource(json.getURI().trimFileExtension().appendFileExtension("ecore"));
				xmi.getContents().addAll(json.getContents());
				try {
					xmi.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
		
				try {
					((IResource) firstElement).getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				
			}
		}
		return null;
	}
}
