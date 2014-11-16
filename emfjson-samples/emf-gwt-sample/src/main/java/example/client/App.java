package example.client;

import java.io.IOException;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.gwt.handlers.HttpHandler;
import org.emfjson.gwt.resource.JsonResourceFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import example.shared.model.ModelFactory;
import example.shared.model.ModelPackage;
import example.shared.model.User;

/**
 * GWT application demonstrating the use of the EMF GWT API
 * on top of a HTTP server delivering JSON data. The parsing 
 * and serialization of JSON is achieved with EMFJSON for GWT.
 * 
 */
public class App implements EntryPoint {

	private URI baseService = URI.createURI(GWT.getHostPageBaseURL() + "api/resources/");

	public void onModuleLoad() {
		final View view = new View();
		final ResourceSet resourceSet = createResourceSet();

		RootPanel.get().add(view);

		view.handleCreate(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				// HttpHandler.create method sends an empty POST request to the server. The 
				// server should handle the creation of the resource and assign it an id. The 
				// resource id is then returned by the server in the http header Location.
				// The method HttpHandler.create then creates an empty resource on the client and 
				// assign it the id given by the server.

				HttpHandler.create(resourceSet, baseService, new Callback<Resource>() {
					@Override
					public void onFailure(Throwable caught) {
						GWT.log(caught.getMessage());
					}

					@Override
					public void onSuccess(final Resource result) {
						
						// Once the resource created, we add it an element Entity.
						//

						User entity = ModelFactory.eINSTANCE.createUser();
						result.getContents().add(entity);

						final ContentView contentView = new ContentView();
						contentView.resourceLabel.setText(result.getURI().lastSegment());
						contentView.nameTextBox.addChangeHandler(new ChangeHandler() {
					
							@Override
							public void onChange(ChangeEvent event) {
								if (!result.getContents().isEmpty()) {
									User entity = (User) result.getContents().get(0);
									entity.setName(contentView.nameTextBox.getText());
								}
							}

						});

						contentView.saveButton.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {

								// Saving the resource sends a PUT request to the server containing 
								// the JSON representation of the resource. 
								//

								save(result, new Callback<Resource>() {
									@Override
									public void onFailure(Throwable caught) {
										GWT.log(caught.getMessage());
									}
									@Override
									public void onSuccess(Resource result) {
										Window.alert("Successfully saved resource");
									}
								});
							}
						});

						contentView.deleteButton.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								delete(result, new Callback<Resource>() {
									@Override
									public void onFailure(Throwable caught) {
										GWT.log(caught.getMessage());
									}
									@Override
									public void onSuccess(Resource result) {
										view.content.remove(contentView);
									}
								});
							}
						});

						view.content.add(contentView);
					}
				});
			}
		});
	}

	private ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getPackageRegistry().put(
				EcorePackage.eNS_URI, 
				EcorePackage.eINSTANCE);

		resourceSet.getPackageRegistry().put(
				ModelPackage.eNS_URI, 
				ModelPackage.eINSTANCE);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"*",
				new JsonResourceFactory());

		resourceSet.getURIConverter().getURIHandlers().add(new HttpHandler());
		resourceSet.getURIConverter().getURIMap().put(
				URI.createURI("http://resources/"), 
				baseService);

		return resourceSet;
	}

	private void save(Resource resource, Callback<Resource> callback) {
		try {
			resource.save(null, callback);
		} catch (IOException e) {
			callback.onFailure(e);
		}
	}

	private void delete(Resource resource, Callback<Resource> callback) {
		try {
			resource.delete(null, callback);
		} catch (IOException e) {
			callback.onFailure(e);
		}
	}

}

