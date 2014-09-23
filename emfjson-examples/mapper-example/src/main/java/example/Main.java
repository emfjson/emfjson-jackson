package example;

import java.util.HashMap;
import java.util.Map;

import model.Address;
import model.ModelFactory;
import model.ModelPackage;
import model.User;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.EMFJs;
import org.emfjson.jackson.map.JacksonObjectMapper;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Example shows how to use the {@link JacksonObjectMapper} to read and write 
 * from Jackson's ObjectNode and ArrayNode in/to EMF Resources.
 */
public class Main {

	public static void main(String[] args) {
		// First we create a JSON object 
		// using Jackson API
		ObjectMapper m = new ObjectMapper();
		ObjectNode userNode = m.createObjectNode();
		userNode.put("name","John Doe");

		// Create a JacksonObjectMapper to read the JSON Object into a Resource
		JacksonObjectMapper objectMapper = new JacksonObjectMapper();

		// Create the resource
		ResourceSet resourceSet = createResourceSet();
		Resource target = resourceSet.createResource(URI.createURI("user.json"));

		// Set as option the type of the object we want to read
		Map<String, Object> options = new HashMap<>();
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);

		// load the object into the resource
		objectMapper.fromObject(userNode, target, options );

		// resource now contains an object User
		User user = (User) target.getContents().get(0);
		
		// we add more information about the user
		user.setBirthDate(new DateTime(1975, 10, 5, 12, 0, 0, 0).toDate());

		Address address = ModelFactory.eINSTANCE.createAddress();
		address.setCity("Paris");
		address.setCountry("France");
		address.setNumber(12);
		address.setStreet("Montmartre");
		user.getAddresses().add(address);

		// write it back into a JSON Object
		userNode = objectMapper.toObject(user, options);

		System.out.println(userNode);
	}

	private static ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ModelPackage.eNS_URI, ModelPackage.eNS_URI);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());

		return resourceSet;
	}

}
