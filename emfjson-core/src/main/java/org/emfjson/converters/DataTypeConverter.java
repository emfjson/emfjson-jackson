package org.emfjson.converters;

import org.eclipse.emf.ecore.EDataType;

public interface DataTypeConverter<I, O> {

	O getValue(Object value);

	I createFromValue(O value);

	EDataType getDataType();

}
