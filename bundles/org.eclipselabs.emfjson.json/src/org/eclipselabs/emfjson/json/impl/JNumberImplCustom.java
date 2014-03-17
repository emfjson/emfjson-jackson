package org.eclipselabs.emfjson.json.impl;



public class JNumberImplCustom extends org.eclipselabs.emfjson.json.impl.JNumberImpl {

	@Override
	public String asText() {
		double d = getNumberValue();
		if (d % 1 == 0) {
			return Integer.toString((int) d);
		} else {
			return Double.toString(d);
		}
	}

}
