package org.eclipselabs.emfjson.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class AbstractResourceHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		final Object firstElement = selection.getFirstElement();

		Resource selectedResource = null;
		IContainer container = null;

		if (firstElement instanceof IResource) {
			container = ((IResource) firstElement).getParent();
			IPath path = ((IResource) firstElement).getFullPath();
			selectedResource = resourceSet.createResource(URI.createPlatformResourceURI(path.toString(), true));
		}

		return executeOnResource(event, selectedResource, container);
	}

	protected abstract Object executeOnResource(ExecutionEvent event, Resource resource, IContainer container);

}
