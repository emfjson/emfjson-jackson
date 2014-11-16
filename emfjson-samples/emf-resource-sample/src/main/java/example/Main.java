package example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.EMFJs;
import org.emfjson.jackson.resource.JsonResourceFactory;

/**
 * Example shows how to configure a ResourceSet to read and write JSON files using 
 * the EMF Resource API.
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// setting up the resourceSet with resourceFactory for JSON
		//
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new JsonResourceFactory());

		// register ecore package for standalone (outside eclipse) execution
		//
		rs.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		// optional options
		//
		Map<String, Object> options = new HashMap<>();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);

		// create a model
		//
		EPackage fooPackage = EcoreFactory.eINSTANCE.createEPackage();
		fooPackage.setName("foo");
		fooPackage.setNsPrefix("foo");
		fooPackage.setNsURI("http://sample.org/foo");
		
		EClass fooClass = EcoreFactory.eINSTANCE.createEClass();
		fooClass.setName("Foo");
		
		EAttribute labelAttr = EcoreFactory.eINSTANCE.createEAttribute();
		labelAttr.setName("label");
		labelAttr.setEType(EcorePackage.Literals.ESTRING);
		
		fooClass.getEStructuralFeatures().add(labelAttr);
		fooPackage.getEClassifiers().add(fooClass);

		// register the model package
		//
		rs.getPackageRegistry().put(fooPackage.getNsURI(), fooPackage);
		
		// create instances
		//
		EObject fooInstance = EcoreUtil.create(fooClass);
		fooInstance.eSet(labelAttr, "I am a foo");

		// add package and instance in a resource
		//
		Resource res = rs.createResource(URI.createURI("model.json"));
		res.getContents().add(fooPackage);
		res.getContents().add(fooInstance);

		// save it as JSON
		//
		res.save(System.out, options);
	}

}
