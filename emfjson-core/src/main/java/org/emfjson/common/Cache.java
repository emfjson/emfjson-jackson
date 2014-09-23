package org.emfjson.common;

import static org.emfjson.common.ModelUtil.getElementName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class Cache {

	protected  final Map<EClass, List<EReference>> mapOfReferences = new HashMap<>();
	protected final Map<EClass, List<EAttribute>> mapOfAttributes = new HashMap<>();
	protected final Map<EStructuralFeature, String> mapOfNames = new HashMap<>();
	protected final Map<String, EClass> mapOfClasses = new HashMap<>();
	protected final Map<String, URI> mapOfURIs = new HashMap<>();
	protected final Map<EClass, Map<String, EStructuralFeature>> mapOfFeatures = new HashMap<>();

	public String getKey(EStructuralFeature feature) {
		String key = mapOfNames.get(feature);
		if (key == null) {
			key = getElementName(feature);
			mapOfNames.put(feature, key);
		}		
		return key;
	}

	public List<EReference> getReferences(EClass eClass) {
		List<EReference> references = mapOfReferences.get(eClass);
		if (references == null) {
			references = eClass.getEAllReferences();
			mapOfReferences.put(eClass, references);
		}
		return references;
	}

	public List<EAttribute> getAttributes(EClass eClass) {
		List<EAttribute> attributes = mapOfAttributes.get(eClass);
		if (attributes == null) {
			attributes = eClass.getEAllAttributes();
			mapOfAttributes.put(eClass, attributes);
		}
		return attributes;
	}

	public EClass getEClass(ResourceSet resourceSet, String type) {
		EClass eClass = mapOfClasses.get(type);
		if (eClass == null) {
			URI uri = mapOfURIs.get(type);
			if (uri == null) {
				uri = URI.createURI(type);
				mapOfURIs.put(type, uri);
			}
			eClass = (EClass) resourceSet.getEObject(uri, true);
			if (eClass != null) {
				mapOfClasses.put(type, eClass);
			}
		}
		return eClass;
	}

	public EStructuralFeature getEStructuralFeature(EClass eClass, String key) {
		Map<String, EStructuralFeature> featureByKey = mapOfFeatures.get(eClass);

		if (featureByKey == null) {
			featureByKey = new HashMap<>();
			mapOfFeatures.put(eClass, featureByKey);
		}

		EStructuralFeature feature = featureByKey.get(key);
		if (feature == null) {
			feature = findEStructuralFeature(eClass, key);
			if (feature != null) {
				featureByKey.put(key, feature);
			}
		}

		return feature;
	}

    private EStructuralFeature findEStructuralFeature(EClass eClass, String key) {
        if (eClass == null || key == null)
            return null;

        EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(key);

        if (eStructuralFeature == null) {
            int i = 0;
            List<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
            while (i < features.size() && eStructuralFeature == null) {
                EStructuralFeature current = features.get(i);
                if (key.equals(getKey(current))) {
                    eStructuralFeature = current;
                }
                i++;
            }
        }

        return eStructuralFeature;
    }

}
