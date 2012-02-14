package org.eclipselabs.resources;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.eclipse.emf.ecore.EObject;

@Path("/resources")
public class Resources {

	/**
	 * {
	 * 	"resources":"["
	 * 		""
	 *  "]"
	 * }
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getResources() {
		String listOfResources = ResourceAccess.getListOfResources();
		if (listOfResources != null){
			return Response.ok(listOfResources, MediaType.APPLICATION_JSON).build();
		}
		return Response.noContent().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public StreamingOutput getResourceById(@PathParam("id") String id) {
		final EObject root = ResourceAccess.getResourceById(id);
		if (root != null) {
			return new StreamingOutput() {
				@Override
				public void write(OutputStream arg0) throws IOException, WebApplicationException {
					root.eResource().save(arg0, null);
				}
			};
		}

		return null;
	}
}
