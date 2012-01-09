EMFJSON is a JSON mapper for [EMF](http://www.eclipse.org/emf).

Current version is 0.3.2.

Eclipse Update Site (p2 repository): http://ghillairet.github.com/emfjson/releases/0.3.2/

# Dependencies

* EMF 2.7.0 or later
* Jackson 1.6.0 or later

# Installation

See [wiki](https://github.com/ghillairet/emfjson/wiki/Install)

# Usage

To serialize objects in json using emfjson, simply register the json extension to the resource factroy registry, as follow:

    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());

Then create an object and add it to a resource. Give the resource a URI that will be path to the resulting json file.

    User user = ModelFactory.eINSTANCE.createUser();
    user.setUserId("1");
    user.setName("John");

    ResourceSet resourceSet = new ResourceSetImpl();
    Resource resource = resourceSet.createResource(URI.createURI("file:/user.json"));
    resource.getContents().add(user);
    resource.save(null);

To load objects from json, you also need to register the correct resource factory, as previously described. You also 
need to indicate the type of the root objects you want to obtain from the json data. This is done via a Map.


    Map<String, Object> options = new HashMap<String, Object>();
    options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());

Then load the EMF resource with those options.
 
    Resource resource = resourceSet.createResource(uri("file:/user.json"));
    resource.load(options);

The resource should now contained the objects.

    User user = (User) resource.getContents().get(0);
