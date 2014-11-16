package example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ContentView extends Composite {

	interface Binder extends UiBinder<Widget, ContentView> {}
	private static Binder uiBinder = GWT.create(Binder.class);

	@UiField Label resourceLabel;
	@UiField Button deleteButton;
	@UiField Button saveButton;
	@UiField TextBox nameTextBox;

	public ContentView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
