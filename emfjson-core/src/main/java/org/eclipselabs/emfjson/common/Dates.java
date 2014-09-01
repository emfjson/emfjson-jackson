package org.eclipselabs.emfjson.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {

	public static String dateValue(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return sdf.format(date);
	}

}
