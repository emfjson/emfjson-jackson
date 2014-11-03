package org.emfjson.converters;

import java.util.Date;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;

public abstract class DateConverter implements DataTypeConverter<Date, String> {

	public abstract String getValue(Object date);

	public abstract Date createFromValue(String value);

	@Override
	public EDataType getDataType() {
		return EcorePackage.Literals.EDATE;
	}

}
