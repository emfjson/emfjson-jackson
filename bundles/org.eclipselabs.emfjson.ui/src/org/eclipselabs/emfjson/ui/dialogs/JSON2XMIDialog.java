package org.eclipselabs.emfjson.ui.dialogs;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.internal.ide.misc.ContainerSelectionGroup;

@SuppressWarnings("restriction")
public class JSON2XMIDialog extends TitleAreaDialog {

	private final IContainer targetContainer;
	private String fileName;
	private IPath targetPath;

	public JSON2XMIDialog(IContainer container, String fileName, Shell activeShell) {
		super(activeShell);
		this.targetContainer = container;
		this.fileName = fileName;
		this.targetPath = targetContainer.getFullPath();
	}

	@Override
	public void create() {
		super.create();
		setTitle("EMF JSON");
	    setMessage("Select options for the XMI conversion", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);

		Composite container = new Composite(area, SWT.NONE);
	    GridLayout layout = new GridLayout(1, false);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    container.setLayout(layout);

	    final ContainerSelectionGroup group = new ContainerSelectionGroup(container, new Listener() {
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

	    group.setSelectedContainer(targetContainer);

	    Label fileNameLabel = new Label(container, SWT.NONE);
	    fileNameLabel.setText("File Name:");

	    final Text fileNameText = new Text(container, SWT.BORDER);
	    fileNameText.setText(fileName);
	    fileNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    fileNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				fileName = fileNameText.getText();
			}
		});

	    return area;
	}

	public URI getOutputURI() {
		IPath targetFile = targetPath.append(fileName);
		return URI.createPlatformResourceURI(targetFile.toString(), true);
	}

}
