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
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.emfjson.ui.dialogs.JSON2XMIDialog;

public class JSON2XMIHandler extends AbstractResourceHandler {

	@Override
	protected Object executeOnResource(final ExecutionEvent event, final Resource resource, final IContainer container) {
		if (resource != null && container != null) {
			URI targetURI = resource.getURI();
			String fileName = targetURI.trimFileExtension().appendFileExtension("xmi").lastSegment();
			JSON2XMIDialog dialog = new JSON2XMIDialog(container, fileName, HandlerUtil.getActiveShell(event));
			dialog.create();

			if (Window.OK == dialog.open()) {
				final Map<String, Object> options = new HashMap<String, Object>();
				final URI outputURI = dialog.getOutputURI();

				try {
					HandlerUtil.getActiveWorkbenchWindow(event).run(true, false, new WorkspaceModifyOperation() {
						@Override
						protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
							if (!resource.isLoaded()) {
								try {
									resource.load(null);
								} catch (IOException e) {
									e.printStackTrace();
									MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error", e.getMessage());
									return;
								}
							}

							Resource output = resource.getResourceSet().createResource(outputURI);

							output.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));

							try {
								output.save(options);
							} catch (IOException e) {
								e.printStackTrace();
								MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error", e.getMessage());
							}
						}
					});
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error", e.getTargetException().getMessage());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
