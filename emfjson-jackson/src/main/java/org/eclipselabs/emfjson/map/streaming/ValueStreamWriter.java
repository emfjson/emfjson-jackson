package org.eclipselabs.emfjson.map.streaming;

import static org.eclipse.emf.ecore.util.EcoreUtil.convertToString;
import static org.eclipselabs.emfjson.map.Dates.dateValue;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import com.fasterxml.jackson.core.JsonGenerator;

public class ValueStreamWriter {

	public void serialize(JsonGenerator generator, String key, EAttribute attribute, Object value) {
		final EDataType type = attribute.getEAttributeType();
		if (attribute.isMany()) {
			serializeMany(generator, key, type, (Collection<?>) value);
		} else {
			serializeValue(generator, key, type, value);
		}
	}

	public void serializeMany(JsonGenerator generator, String key, EDataType type, Collection<?> values) {
		try {
			generator.writeFieldName(key);
			generator.writeStartArray();
			for (Object value: values) {
				if (value instanceof String) {
					generator.writeString((String) value);
				}
				else if (value instanceof Integer) {
					generator.writeNumber((Integer) value);
				}
				else if (value instanceof Boolean) {
					generator.writeBoolean((Boolean) value);
				}
				else if (value instanceof Date) {
					generator.writeString(dateValue((Date) value));
				}
				else if (value instanceof Double) {
					generator.writeNumber((Double) value);
				}
				else if (value instanceof Long) {
					generator.writeNumber((Long) value);
				}
				else if (value instanceof Short) {
					generator.writeNumber((Short) value);
				}
				else if (value instanceof Float) {
					generator.writeNumber((Float) value);
				}
				else {
					generator.writeString((String) convertToString(type, value));
				}
			}
			generator.writeEndArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serializeValue(JsonGenerator generator, String key, EDataType type, Object value) {
		try {
			if (value instanceof String) {
				generator.writeStringField(key, (String) value);
			}
			else if (value instanceof Integer) {
				generator.writeNumberField(key, (Integer) value);
			}
			else if (value instanceof Boolean) {
				generator.writeBooleanField(key, (Boolean) value);
			}
			else if (value instanceof Date) {
				generator.writeStringField(key, dateValue((Date) value));
			}
			else if (value instanceof Double) {
				generator.writeNumberField(key, (Double) value);
			}
			else if (value instanceof Long) {
				generator.writeNumberField(key, (Long) value);
			}
			else if (value instanceof Short) {
				generator.writeNumberField(key, (Short) value);
			}
			else if (value instanceof Float) {
				generator.writeNumberField(key, (Float) value);
			}
			else {
				generator.writeStringField(key, (String) convertToString(type, value));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
