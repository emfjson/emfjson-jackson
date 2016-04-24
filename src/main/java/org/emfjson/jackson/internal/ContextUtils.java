package org.emfjson.jackson.internal;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import org.emfjson.jackson.databind.type.EcoreType;
import org.emfjson.jackson.handlers.URIHandler;

import java.util.Map;

public class ContextUtils {

	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> type, Object key, DatabindContext context) {
		Object value = context.getAttribute(key);

		return value != null && type.isAssignableFrom(value.getClass()) ?
				(T) value:
				null;
	}

	public static ContextAttributes from(Map<?, ?> options) {
		return ContextAttributes.getEmpty()
				.withSharedAttributes(options);
	}

	public static EcoreType getEcoreType(DatabindContext context) {
		EcoreType ecoreType = (EcoreType) context.getAttribute("typeFactory");
		if (ecoreType == null) {
			context.setAttribute("typeFactory", ecoreType = new EcoreType());
		}

		return ecoreType;
	}

	public static Cache getCache(DatabindContext context) {
		Cache cache = (Cache) context.getAttribute("cache");
		if (cache == null) {
			context.setAttribute("cache", cache = new Cache());
		}

		return cache;
	}

	public static URIHandler getHandler(DatabindContext context) {
		Object handler = context.getAttribute("handler");

		return handler instanceof URIHandler ? (URIHandler) handler: null;
	}

}
