package example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class View extends Composite {

	interface Binder extends UiBinder<Widget, View> {}
	private static Binder uiBinder = GWT.create(Binder.class);

	@UiField Button createButton;
	@UiField HTMLPanel content;

	public View() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setContent(ContentView view) {
		content.add(view);
	}

	public void handleCreate(ClickHandler handler) {
		createButton.addClickHandler(handler);
	}

}
