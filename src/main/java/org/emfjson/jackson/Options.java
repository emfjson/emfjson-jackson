package org.emfjson.jackson;

import org.emfjson.jackson.handlers.BaseURIHandler;

public enum Options {

	OPTION_URI_HANDLER(new BaseURIHandler()),
	OPTION_SERIALIZE_DEFAULT_VALUE(false),
	OPTION_SERIALIZE_REF_TYPE(true),
	OPTION_SERIALIZE_TYPE(true),
	OPTION_ROOT_ELEMENT(null);

	private final Object defaultValue;

	Options(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

}
