EMFJSON is a JSON mapper for [EMF](http://www.eclipse.org/emf).

Current version is 0.3.0.

Eclipse Update Site (p2 repository): http://ghillairet.github.com/emfjson/releases/0.3.0/

# Usage

## Resource implementation

To serialize objects in json using emfjson, simply register the json extension to the resource factroy registry, as follow:

`Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());`

Then create an object and add it to a resource. Give the resource a URI that will be path to the resulting json file.

`ResourceSet resourceSet = new ResourceSetImpl();`

`User user = ModelFactory.eINSTANCE.createUser();`

`user.setUserId("1");`

`user.setName("John");`


<code>
Resource resource = resourceSet.createResource(URI.createURI("file:/out.json"));
resource.getContents().add(user);
resource.save(null);
</code>

To load objects from json, you also need to register the correct resource factory, as previously described. You also 
need to indicate the type of the root objects you want to obtain from the json data. This is done via a Map.

<code>
Map<String, Object> options = new HashMap<String, Object>();
options.put(JsURIHandlerImpl.OPTION_ROOT_ELEMENT, ModelPackage.eINSTANCE.getUser());
</code>

Then load the EMF resource with those options.
 
<code>
Resource resource = resourceSet.createResource(uri("file:/in.json"));
resource.load(options);
</code>

The resource should now contained the objects.

<code>
User user = (User)resource.getContents().get(0);
</code>

# News #

Version 0.3.0 2011/10/23

*    Add Resource implementation
*    <del>Issue 3</del> Add support for json referencing a la dojo
*    Add support for multi valued attributes

Version 0.2.0 2011/8/3

*    <del>Issue 1</del>: Implement URIHandlerImpl instead of cutom ResourceImpl,
*    Updated Twitter model,
*    Changed namespace from com.emfjson to org.eclipselabs.emfjson.

Version 0.1.0 2011/6/21

*    First implementation, provides JSON reader and writer for EMF models.

