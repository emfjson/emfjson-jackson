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
package org.eclipselabs.emfjson.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class EcoreModeljsonApiSettingsWizardPage extends WizardPage {
	
	private Text text;

	protected EcoreModeljsonApiSettingsWizardPage() {
		super("");
		setTitle("Ecore model");
		setDescription("API Settings information");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Group grpTt = new Group(container, SWT.NONE);
		GridData gd_grpTt = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_grpTt.widthHint = 581;
		grpTt.setLayoutData(gd_grpTt);
		grpTt.setText("API Settings");
		grpTt.setLayout(new FillLayout(SWT.VERTICAL));
		
		Composite composite = new Composite(grpTt, SWT.NONE);
		composite.setLayout(new GridLayout(17, false));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lblUrl = new Label(composite, SWT.HORIZONTAL | SWT.CENTER);
		lblUrl.setAlignment(SWT.LEFT);
		lblUrl.setText("URL:");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 11, 1);
		gd_text.widthHint = 250;
		gd_text.minimumWidth = 250;
		text.setLayoutData(gd_text);
		
		Button button = new Button(composite, SWT.FLAT);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setText("+");
	}
	
	public String getServiceURL() {
		return text.getText();
	}
}
