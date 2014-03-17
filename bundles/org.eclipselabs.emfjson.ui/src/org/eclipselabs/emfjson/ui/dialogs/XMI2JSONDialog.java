package org.eclipselabs.emfjson.ui.dialogs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.internal.ide.misc.ContainerSelectionGroup;
import org.eclipselabs.emfjson.EMFJs;

@SuppressWarnings("restriction")
public class XMI2JSONDialog extends TitleAreaDialog {

	private boolean saveNamespaces = false;
	private boolean saveTypes = true;
	private boolean saveReferenceTypes = true;
	private boolean saveIndent = true;
	
	private final IContainer targetContainer;
	private String fileName;
	private IPath targetPath;

	public XMI2JSONDialog(IContainer container, String fileName, Shell activeShell) {
		super(activeShell);
		this.targetContainer = container;
		this.fileName = fileName;
		this.targetPath = targetContainer.getFullPath();
	}

	@Override
	public void create() {
		super.create();
		setTitle("EMF JSON");
		setMessage("Select options for the JSON conversion", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);

		Composite container = new Composite(area, SWT.NONE);
		{
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			GridLayout layout = new GridLayout(1, false);
			container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			container.setLayout(layout);
		}

		ContainerSelectionGroup group = new ContainerSelectionGroup(container, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Widget current = event.widget;
				if (current instanceof Text) {
					if (((Text) current).getParent() instanceof ContainerSelectionGroup) {
						ContainerSelectionGroup g = (ContainerSelectionGroup) ((Text) current).getParent();
						targetPath = g.getContainerFullPath();
					}
				}
			}
		}, true);
		{
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			group.setLayoutData(data);
		}

		group.setSelectedContainer(targetContainer);

	    Label fileNameLabel = new Label(container, SWT.NONE);
	    fileNameLabel.setText("File Name:");

	    final Text fileNameText = new Text(container, SWT.BORDER);
	    fileNameText.setText(fileName);
	    {
	    	GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	    	fileNameText.setLayoutData(data);
	    }
	    fileNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				fileName = fileNameText.getText();
			}
		});

		createOptionsGroup(container);

		return area;
	}

	private void createOptionsGroup(Composite container) {
		Group group = new Group(container, SWT.BORDER);
		group.setText("Options");
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(data);

		GridLayout layout = new GridLayout(2, true);
		group.setLayout(layout);

		createButton(group, "Use Namespaces", false, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				saveNamespaces = b.isEnabled();
			}
		});
		createButton(group, "Serialize Types", true, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				saveTypes = b.isEnabled();
			}
		});
		createButton(group, "Serialize Reference Types", true, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				saveReferenceTypes = b.isEnabled();
			}
		});
		createButton(group, "Indent Output", true, new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				saveIndent = b.isEnabled();
			}
		});
	}

	private Button createButton(Composite parent, String text, boolean checked, SelectionListener listener) {
		Button button = new Button(parent, SWT.CHECK);
		button.setText(text);
		button.setSelection(checked);
		button.addSelectionListener(listener);
		button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		return button;
	}

	public Map<String, Object> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, saveIndent);
		options.put(EMFJs.OPTION_SERIALIZE_NAMESPACES, saveNamespaces);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, saveTypes);
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, saveReferenceTypes);

		return options;
	}

	public URI getOutputURI() {
		IPath targetFile = targetPath.append(fileName);
		return URI.createPlatformResourceURI(targetFile.toString(), true);
	}

}
