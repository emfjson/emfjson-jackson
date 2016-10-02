package org.emfjson.jackson.utils;

import com.fasterxml.jackson.databind.DeserializationContext;

public interface ValueReader<V, T> {
	T readValue(V value, DeserializationContext context);
}
