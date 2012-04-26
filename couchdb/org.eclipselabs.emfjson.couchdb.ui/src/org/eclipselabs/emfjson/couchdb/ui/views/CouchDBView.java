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
package org.eclipselabs.emfjson.couchdb.ui.views;

import java.net.URI;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.ViewPart;
import org.eclipselabs.emfjson.couchdb.efs.CouchDBFileSystem;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDB;
import org.eclipselabs.emfjson.couchdb.ui.model.CouchDocument;
import org.eclipselabs.emfjson.couchdb.ui.provider.CouchDBContentProvider;
import org.eclipselabs.emfjson.couchdb.ui.provider.CouchDBLabelProvider;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;

public class CouchDBView extends ViewPart {

	private TreeViewer viewer;
	
	public CouchDBView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put("http", new JsResourceFactoryImpl());
		
		Action action = new Action() {
			@Override
			public void addPropertyChangeListener(IPropertyChangeListener listener) {
				super.addPropertyChangeListener(listener);
			}
			@Override
			public void removePropertyChangeListener(IPropertyChangeListener listener) {
				super.removePropertyChangeListener(listener);
			}
			@Override
			public void run() {
				super.run();
			}
		};
		action.setText("Do Something");

		IActionBars actionBars = getViewSite().getActionBars();
		IMenuManager dropDownMenu = actionBars.getMenuManager();
		dropDownMenu.add(action);

		CouchDB cdb = new CouchDB(new ResourceSetImpl());
		cdb.getDataBases();

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new CouchDBContentProvider());
		viewer.setLabelProvider(new CouchDBLabelProvider(parent));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				TreeViewer src = (TreeViewer) event.getSource();
				
				if (src.getSelection() instanceof TreeSelection) {
					
					Object element = ((TreeSelection)src.getSelection()).getFirstElement();
				
					if (element instanceof CouchDocument) {
						CouchDocument doc = (CouchDocument) element;
						
						IEditorDescriptor[] editors = PlatformUI.getWorkbench()
								.getEditorRegistry().getEditors("_.ecore");
						
						IEditorDescriptor xmiEditor = null;
						for (IEditorDescriptor editor: editors){
							if (editor.getId().equals("org.eclipse.emf.ecore.presentation.EcoreEditorID")){
								xmiEditor = editor;
							}
						}

						if (xmiEditor!=null){
							IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
							
							CouchDBFileSystem fs = new CouchDBFileSystem();
							URI uri = URI.create(doc.getURL());
							IFileStore fileStore = fs.getStore(uri);
							IEditorInput input = new FileStoreEditorInput(fileStore);
							
							try {
								page.openEditor(input, xmiEditor.getId());
							} catch (PartInitException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
		viewer.setAutoExpandLevel(1);

		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				//				CouchDBView.this.fillContextMenu(manager);
			}
		});

		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);

		viewer.setInput(cdb);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}
