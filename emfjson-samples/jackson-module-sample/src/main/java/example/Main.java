package example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Address;
import model.ModelFactory;
import model.ModelPackage;
import model.User;

import org.eclipse.emf.ecore.EObject;
import org.emfjson.EMFJs;
import org.emfjson.jackson.module.EMFModule;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Example shows how to use the {@link JacksonObjectMapper} to read and write 
 * from Jackson's ObjectNode and ArrayNode in/to EMF Resources.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();

		// Set as option the type of the object we want to read
		final Map<String, Object> options = new HashMap<>();
		options.put(EMFJs.OPTION_ROOT_ELEMENT, ModelPackage.Literals.USER);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);

		// Register EMFModule to handle EObject and Resource types.
		mapper.registerModule(new EMFModule(options));

		// First we create a JSON object using Jackson API
		final ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("name","John Doe");

		String stringNode = mapper.writeValueAsString(objectNode);

		System.out.println(stringNode);

		// Convert object node to an EObject.

		User user = (User) mapper.readValue(stringNode, EObject.class);

		// We add more information about the user
		user.setBirthDate(new DateTime(1975, 10, 5, 12, 0, 0, 0).toDate());

		Address address = ModelFactory.eINSTANCE.createAddress();
		address.setCity("Paris");
		address.setCountry("France");
		address.setNumber(12);
		address.setStreet("Montmartre");
		user.getAddresses().add(address);

		// Write it back into a JSON Object

		System.out.println(mapper.writeValueAsString(user));
	}

}
