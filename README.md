EMFJSON is a JSON mapper for [EMF](http://www.eclipse.org/emf)

---

[![Build Status](https://secure.travis-ci.org/ghillairet/emfjson.png)](http://travis-ci.org/ghillairet/emfjson)

<a href='http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=188636' title='Drag and drop into a running Eclipse Indigo workspace to install EMFJs'><img src='http://marketplace.eclipse.org/misc/installbutton.png'/></a>

## Installation
See [wiki](https://github.com/ghillairet/emfjson/wiki/Install)

### Releases
 - Update Site:
    - http://ghillairet.github.com/p2/emfjson/releases/0.5.0 or
    - http://ghillairet.github.com/p2 (composite site with Jackson 1.9.5)
 - Eclipse Marketplace: http://marketplace.eclipse.org/content/emfjs
 - Downloads section: https://github.com/ghillairet/emfjson/downloads

### Snapshots
 - Update Site: http://ghillairet.github.com/p2/emfjson/snapshots

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

## Dependencies

* EMF 2.7.0 or later
* Jackson 1.6.0 or later

## License
This software is distributed under the terms of the Eclipse Public License 1.0 - http://www.eclipse.org/legal/epl-v10.html.

