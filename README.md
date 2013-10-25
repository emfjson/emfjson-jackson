EMFJSON is a JSON mapper for [EMF](http://www.eclipse.org/emf)

[![Build Status](https://secure.travis-ci.org/ghillairet/emfjson.png)](http://travis-ci.org/ghillairet/emfjson)

## Installation

### Eclipse Update Manager

- Update Site: http://ghillairet.github.com/p2 (composite site with Jackson 2.2.3)
- Eclipse Marketplace <a href='http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=188636' title='Drag and drop into a running Eclipse Indigo workspace to install EMFJs'><img src='http://marketplace.eclipse.org/misc/installbutton.png'/></a>


### Maven repository

A maven repository for emfjson is available, note that you should also include the denpendency and repository for Jackson in
your pom file. Please refer to the [Jackson](https://github.com/FasterXML/jackson-core) documentation for more information.

```xml
<repository>
	<id>emfjson-repository</id>
	<url>http://repository-ghillairet.forge.cloudbees.com/snapshot</url>
</repository>

<dependency>
	<groupId>org.eclipselabs</groupId>
	<artifactId>org.eclipselabs.emfjson</artifactId>
	<version>0.7.0-SNAPSHOT</version>
</dependency>
```

A sample maven based project is provided in the [examples](https://github.com/ghillairet/emfjson/tree/master/examples/maven-example) folder.

### You want the jars

There is two solutions to your problem:
1. Install the bundles through your eclipse update manager, go in your eclipse/plugins folder, you'll find the emfjson and jackson jars there.
2. Browse the maven repositories for [emfjson](http://repository-ghillairet.forge.cloudbees.com/snapshot/org/eclipselabs/org.eclipselabs.emfjson/) and [jackson](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/).


## Goals
Provide a JSON syntax and associated tools for [EMF](http://www.eclipse.org/emf) Models.

## Features
 - JSON Syntax,
 - Support for JSON object referencing,
 - EMF Resource implementation,
 - Support for CouchDB

## User Guide

See [wiki](https://github.com/ghillairet/emfjson/wiki/Home)

## JSON Syntax

```javascript
{
  "eClass" : "library.ecore#//Library",
  "name" : "SciFi Library",
  "writers" : [
    {
      "eClass" : "library.ecore#//Writer",
      "name" : "Isaac Asimov",
      "books" : [
        {"$ref" : "//@books.0"},
        {"$ref" : "//@books.1"}
      ]
    }
  ],
  "books" : [
    {
      "eClass" : "library.ecore#//Book",
      "title" : "Prelude to Foundation",
      "pages" : 505,
      "category" : "ScienceFiction",
      "author" : {"$ref" : "//@writers.0"}
    },
    {
      "eClass" : "library.ecore#//Book",
      "title" : "Forward the Foundation",
      "pages" : 464,
      "category" : "ScienceFiction",
      "author" : {"$ref" : "//@writers.0"}
    }
  ]
}
```

## GWT Support

See [GWT edition](https://github.com/ghillairet/emfjson-gwt)

## Dependencies

* EMF 2.7.0 or later
* Jackson 2.0.0 or later

## How to hack (and contribute to) it

Note that you must `Help > Install` Jackson 2 if you clone the src to work on it, as your usual Eclipse PDE (nor Orbit) out-of-the-box target platform will not have that.

## License
This software is distributed under the terms of the Eclipse Public License 1.0 - http://www.eclipse.org/legal/epl-v10.
