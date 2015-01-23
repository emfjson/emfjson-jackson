[EMF](http://www.eclipse.org/emf) Binding for JSON. [![Build Status](https://secure.travis-ci.org/ghillairet/emfjson.png)](http://travis-ci.org/ghillairet/emfjson)

EMFJson provides JSON binding for the Eclipse Modeling Framework, meaning it can read and write EMF Models from/to JSON. 

It is integrated with the EMF Resource API, the Jackson API and GWT, and can be used in standalone Java applications, Eclipse based plugins and GWT.

A Ecore model stored in JSON will look like this:

```json
{
    "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EPackage",
    "name" : "model",
    "nsPrefix" : "model",
    "nsURI" : "http://www.example.org/model",
    "eClassifiers" : [
        {
            "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
            "name" : "Library",
            "eStructuralFeatures": [ ... ]
        }
    ]
}
```

And it's instances can look like this:

```json
{
	"name": "My Library",
	"books": [ 
		{ 
			"title": "Wool",
			"author": 1
		},
		{
			"title": "Old Man's War",
			"author": 2
		}
	]
}
```

## Getting Started

### EMF Resource API

To use EMFJson with the EMF API, simply add the JsonResourceFactory to a ResourceSet Factory map.

```java
ResourceSet resourceSet = new ResourceSetImpl();
resourceSet.getResourceFactoryRegistry()
	.getExtensionToFactoryMap()
	.put("*", new JsonResourceFactory());
```

Create a Resource and add an object to it.

```java
Resource resource = resourceSet.createResource(URI.createURI("test"));
EPackage p = EcoreFactory.eINSTANCE.createEPackage();
resource.getContents().add(p);
```

Save it's content.

```java		
resource.save(System.out, null);
```

The output will be:

```json
{
  "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EPackage"
}
```

### Jackson API

EMFJson provides a Jackson Module that can be used to serialize and deserialize EMF 
Models as JSON with the Jackson API.

To use it, register the EMF module with a ObjectMapper.

```java
ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new EMFModule());
```

You can now convert a Resource into a JsonNode

```java
JsonNode node = mapper.valueToTree(resource)
```

Write the content of a resource

```java
mapper.writeValueAsString(resource);
```

Or read JSON data into an EObject or a Resource

```java
String data = "{\"eClass\":\"http://www.eclipse.org/emf/2002/Ecore#//EPackage\"}";

EPackage p = (EPackage) mapper.readValue(data, EObject.class);

Resource r = mapper.readValue(data, Resource.class);
```

## Installation

### Maven

```xml
<dependency>
	<groupId>org.emfjson</groupId>
	<artifactId>emfjson-jackson</artifactId>
	<version>0.10.0</version>
</dependency>
```

### Eclipse Update Manager

Update Site [http://ghillairet.github.com/p2](http://ghillairet.github.com/p2)

### Jars

You can download the jars from [Maven Central](http://search.maven.org/#search|ga|1|emfjson).


## GWT Support

GWT is supported through the module emfjson-gwt.

### Maven

```xml
<dependency>
	<groupId>org.emfjson</groupId>
	<artifactId>emfjson-gwt</artifactId>
	<version>0.10.0</version>
</dependency>
```

## Dependencies

* Java 7
* EMF 2.9.0 or later
* Jackson 2.3.0 or later


## License
This software is distributed under the terms of the Eclipse Public License 1.0 - http://www.eclipse.org/legal/epl-v10.
