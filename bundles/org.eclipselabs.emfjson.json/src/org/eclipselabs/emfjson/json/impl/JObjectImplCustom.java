package org.eclipselabs.emfjson.json.impl;

import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.emfjson.json.JBoolean;
import org.eclipselabs.emfjson.json.JNode;
import org.eclipselabs.emfjson.json.JNumber;
import org.eclipselabs.emfjson.json.JSONFactory;
import org.eclipselabs.emfjson.json.JSONPackage;
import org.eclipselabs.emfjson.json.JString;


public class JObjectImplCustom extends org.eclipselabs.emfjson.json.impl.JObjectImpl {

	@SuppressWarnings("unchecked")
	@Override
	public void put(String key, JNode value) {
		Entry<String, JNode> entry = getEntry(key);
		if (entry != null) {
			entry.setValue(value);
		} else {
			EObject newEntry = EcoreUtil.create(JSONPackage.Literals.ENTRY);
			newEntry.eSet(JSONPackage.Literals.ENTRY__KEY, key);
			newEntry.eSet(JSONPackage.Literals.ENTRY__VALUE, value);
			getFields().add((Entry<String, JNode>) newEntry);
		}
	}

	@Override
	public void put(String key, boolean value) {
		JBoolean realValue = JSONFactory.eINSTANCE.createJBoolean();
		realValue.setBooleanValue(value);
		put(key, realValue);
	}
	
	@Override
	public void put(String key, double value) {
		JNumber realValue = JSONFactory.eINSTANCE.createJNumber();
		realValue.setNumberValue(value);
		put(key, realValue);
	}
	
	@Override
	public void put(String key, String value) {
		JString realValue = JSONFactory.eINSTANCE.createJString();
		realValue.setStringValue(value);
		put(key, realValue);
	}

	@Override
	public JNode get(String key) {
		Entry<String, JNode> entry = getEntry(key);
		return entry != null ? entry.getValue() : null;
	}

	@Override
	public boolean contains(String key) {
		return getEntry(key) != null;
	}

	protected Entry<String, JNode> getEntry(String key) {
		Iterator<Entry<String, JNode>> it = getFields().iterator();
		Entry<String, JNode> found = null;
		while (it.hasNext() && found == null) {
			Entry<String, JNode> entry = it.next();
			if (entry.getKey().equals(key)) {
				found = entry;
			}
		}

		return found;
	}

}
