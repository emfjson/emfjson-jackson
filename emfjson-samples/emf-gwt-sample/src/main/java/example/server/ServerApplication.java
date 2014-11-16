package example.server;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import example.server.providers.JsonResourceBodyReader;
import example.server.providers.JsonResourceBodyWriter;
import example.server.resources.ModelResource;

@ApplicationPath("api")
public class ServerApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ModelResource.class);
		classes.add(JsonResourceBodyReader.class);
		classes.add(JsonResourceBodyWriter.class);
		return classes;
	}

}
