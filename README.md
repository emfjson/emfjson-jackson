[EMF](http://www.eclipse.org/emf) Binding for JSON. [![Build Status](https://secure.travis-ci.org/ghillairet/emfjson.png)](http://travis-ci.org/ghillairet/emfjson)

JSON binding for EMF (Eclipse Modeling Framework) models, that allows serialization and deserialization of EMF Resources in JSON.

This is how a model looks like in JSON format.

```javascript
{
    "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EPackage",
    "name" : "model",
    "nsPrefix" : "model",
    "nsURI" : "http://www.example.org/model",
    "eClassifiers" : [
        {
            "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
            "name" : "Library"
        }
    ]
}
```

## Documentation

[Here](http://emfjson.org)

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

Use this update site [http://ghillairet.github.io/p2](http://ghillairet.github.io/p2)

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
* EMF 2.10.1 or later
* Jackson 2.4.0 or later

## License
This software is distributed under the terms of the Eclipse Public License 1.0 - http://www.eclipse.org/legal/epl-v10.
