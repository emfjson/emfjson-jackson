EMFJSON is a JSON mapper for [EMF](http://www.eclipse.org/emf)

---

[![Build Status](https://secure.travis-ci.org/ghillairet/emfjson.png)](http://travis-ci.org/ghillairet/emfjson)

<a href='http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=188636' title='Drag and drop into a running Eclipse Indigo workspace to install EMFJs'><img src='http://marketplace.eclipse.org/misc/installbutton.png'/></a>

## Installation
 - Update Site: http://ghillairet.github.com/emfjson/releases/0.3.3/
 - Eclipse Marketplace: http://marketplace.eclipse.org/content/emfjs
 - Downloads section: https://github.com/ghillairet/emfjson/downloads

## Goals
Provide a JSON syntax and associated tools for [EMF](http://www.eclipse.org/emf) Models.

## Features
 - JSON Syntax,
 - Support for JSON object referencing,
 - EMF Resource implementation,
 - Support for CouchDB

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

## Installation

See [wiki](https://github.com/ghillairet/emfjson/wiki/Install)

## User Guide

See [wiki](https://github.com/ghillairet/emfjson/wiki/Home)
