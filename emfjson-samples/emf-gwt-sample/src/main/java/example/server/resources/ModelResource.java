package example.server.resources;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.emf.ecore.resource.Resource;

import example.server.store.ModelStore;

@Path("resources")
public class ModelResource {

	private final ModelStore store = new ModelStore();

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getModel(@PathParam("id") final String id) {
		Resource resource = null;
		try {
			resource = store.get(id);
		} catch (IOException e) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(resource).build();
	}

	@POST
	public Response createEmptyModel() {
		URI uri = null;
		try {
			uri = store.create();
		} catch (IOException | URISyntaxException e) {
			return Response.serverError().build();
		}

		return Response.created(uri).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public Response createOrUpdateModel(@PathParam("id") final String id, Resource resource) {
		if (resource == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		URI location = null;
		try {
			location = store.save(id, resource);
		} catch (IOException | URISyntaxException e) {
			return Response.serverError().build();
		}


		return Response.created(location).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteModel(@PathParam("id") final String id) {
		try {
			store.delete(id);
		} catch (Exception e) {
			return Response.serverError().build();
		}

		return Response.noContent().build();
	}

}
