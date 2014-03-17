package org.eclipselabs.emfjson.json.impl;


public class JStringImplCustom extends org.eclipselabs.emfjson.json.impl.JStringImpl {

	@Override
	public String asText() {
		return getStringValue();
	}

}
