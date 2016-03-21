package org.emfjson.jackson.common;

import com.fasterxml.jackson.databind.DeserializationContext;

public class ContextUtils {

	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> type, String key, DeserializationContext context) {
		Object value = context.getAttribute(key);

		return value != null && type.isAssignableFrom(value.getClass()) ? (T) value: null;
	}

}
