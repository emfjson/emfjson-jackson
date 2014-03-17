package org.eclipselabs.emfjson.json.impl;


public class JBooleanImplCustom extends org.eclipselabs.emfjson.json.impl.JBooleanImpl {

	@Override
	public String asText() {
		return Boolean.toString(isBooleanValue());
	}

}
