[EMF](http://www.eclipse.org/emf) Binding for JSON. [![Build Status](https://secure.travis-ci.org/ghillairet/emfjson.png)](http://travis-ci.org/ghillairet/emfjson)

JSON binding for EMF (Eclipse Modeling Framework) models, that allows serialization and deserialization of EMF Resources in a specific JSON format.

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
	<groupId>org.eclipselabs</groupId>
	<artifactId>org.eclipselabs.emfjson</artifactId>
	<version>0.7.0-SNAPSHOT</version>
</dependency>
```

### Eclipse Update Manager

- Update Site: http://ghillairet.github.com/p2 (composite site with Jackson 2.2.3)


### Jars

Browse the maven repositories for [emfjson](http://repository-ghillairet.forge.cloudbees.com/snapshot/org/eclipselabs/org.eclipselabs.emfjson/) and [jackson](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/).


## GWT Support

See [GWT edition](https://github.com/ghillairet/emfjson-gwt)

## Dependencies

* EMF 2.7.0 or later
* Jackson 2.3.0 or later

## How to hack (and contribute to) it

Note that you must `Help > Install` Jackson 2 if you clone the src to work on it, as your usual Eclipse PDE (nor Orbit) out-of-the-box target platform will not have that.

## License
This software is distributed under the terms of the Eclipse Public License 1.0 - http://www.eclipse.org/legal/epl-v10.
