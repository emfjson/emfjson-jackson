EMFJson P2 Build
---

To build emfjson p2 repository from source, follow the following instructions.

```
git clone https://github.com/ghillairet/emfjson.git
```

```
cd emfjson/emfjson-p2-build
```

```
mvn clean verify
```

This builds a p2 repository in emfjson-repository/target/repository folder.
Add this folder to your eclipse plugin manager to install the bundles in your eclipse installation.

> If you are not using the eclipse Mars release (version 4.5), before trying to install the emfjson bundles, 
add the orbit p2 repository that contains the jackson bundles version 2.5 or superior 
(http://download.eclipse.org/tools/orbit/downloads/drops/R20150519210750/repository/).