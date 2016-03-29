package org.emfjson.jackson.common;

import com.fasterxml.jackson.databind.DatabindContext;

public class ContextUtils {

	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> type, Object key, DatabindContext context) {
		Object value = context.getAttribute(key);

		return value != null && type.isAssignableFrom(value.getClass()) ? (T) value: null;
	}

}
