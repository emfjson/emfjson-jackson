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

Builds are available for Maven users and Eclipse Plugins users.

### Maven

Add the following dependency yo your POM file to use emfjson-jackson.

```xml
<dependency>
	<groupId>org.emfjson</groupId>
	<artifactId>emfjson-jackson</artifactId>
	<version>0.13.0</version>
</dependency>
```

### Eclipse Update Manager

Use this update site [http://ghillairet.github.io/p2](http://ghillairet.github.io/p2)

This update site contains the bundles emfjson-core and emfjson-jackson. 

> If you are using a version of eclipse inferior to Mars (< 4.5), please add the following orbit 
 repository, that contains jackson bundles, before trying to install emfjson.
 http://download.eclipse.org/tools/orbit/downloads/drops/R20150519210750/repository/

### Jars

You can download the jars from [Maven Central](http://search.maven.org/#search|ga|1|emfjson).

## GWT Support

GWT is supported through the module emfjson-gwt. We recommend to use the maven-gwt plugin. The GWT 
 version of emfjson is available in Maven central.

```xml
<dependency>
	<groupId>org.emfjson</groupId>
	<artifactId>emfjson-gwt</artifactId>
	<version>0.13.0</version>
</dependency>
```

## Dependencies

* Java 7
* EMF 2.8.0 or later
* Jackson 2.5.0 or later

## License
This software is distributed under the terms of the Eclipse Public License 1.0 - http://www.eclipse.org/legal/epl-v10.
