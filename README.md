[EMF](http://www.eclipse.org/emf) Binding for JSON. [![CircleCI](https://circleci.com/gh/emfjson/emfjson-jackson.svg?style=svg)](https://circleci.com/gh/emfjson/emfjson-jackson)

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

[Here](https://emfjson.github.io)

## Installation

Builds are available for Maven users and Eclipse Plugins users.

### Maven

Add the following dependency yo your POM file to use emfjson-jackson.

```xml
<dependency>
	<groupId>org.emfjson</groupId>
	<artifactId>emfjson-jackson</artifactId>
	<version>1.2.0</version>
</dependency>
```

### Eclipse Update Manager

Use this update site [http://ghillairet.github.io/p2](http://ghillairet.github.io/p2)

This update site contains the bundle and feature for emfjson-jackson and Jackson. 

### Jars

You can download the jars from [Maven Central](http://search.maven.org/#search|ga|1|emfjson).

## Dependencies

* Java 8
* EMF 2.19
* Jackson 2.10

## License

This software is distributed under the terms of the Eclipse Public License 1.0 - http://www.eclipse.org/legal/epl-v10.

# Development

Development can be done with any Java IDE (Eclipse, IntelliJ, etc...), it does not require any special tooling except Maven. 

> The tests require some code to be generated from a [Xcore](http://wiki.eclipse.org/Xcore) model. This generated code is not included in this repository, but 
is generated when the sources are first build locally, see next section for details.

## Building from sources

If you want to build from sources, you will need the Java 8 runtime installed on your system as well as Maven 3.
First start by cloning this repository.

```
git clone https://github.com/emfjson/emfjson-jackson.git
```

Inside the folder `emfjson-jackson`, run the following maven command to build and install the project locally.
 
```
mvn clean install
``` 

This command will call the `xtext:generate` action that will generate the code from the `Xcore` model for the tests. 

## Running tests

The tests can be run with the maven command:

```
mvn clean test
```

Or run the class `TestSuite` from your IDE.
