package org.emfjson.jackson.utils;

import com.fasterxml.jackson.databind.SerializerProvider;

public interface ValueWriter<T, V> {
	V writeValue(T value, SerializerProvider context);
}
