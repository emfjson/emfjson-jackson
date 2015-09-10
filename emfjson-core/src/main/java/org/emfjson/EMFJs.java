/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson;

/**
 * Constants used as options during load/save operations on a Resource.
 */
public final class EMFJs {
	/**
	 * Sets the root element to be loaded from a JSON document without
	 * type field.
	 * <p>Value must be an object of type EClass.</p>
	 * <p>Default value is null.</p>
	 */
	public static final String OPTION_ROOT_ELEMENT = "OPTION_ROOT_ELEMENT";
	/**
	 * When value is true, the writer will include a type to each JSON objects.
	 * <p>Default value is true.</p>
	 */
	public static final String OPTION_SERIALIZE_TYPE = "OPTION_SERIALIZE_TYPE";
	/**
	 * When value is true, the writer will include a type to each reference JSON
	 * objects.
	 * <p>Default value is false</p>
	 */
	public static final String OPTION_SERIALIZE_REF_TYPE = "OPTION_SERIALIZE_REF_TYPE";
	/**
	 * When value is true, the writer will include default values for attributes.
	 * * <p>Default value is false.</p>
	 */
	public static final String OPTION_SERIALIZE_DEFAULT_VALUE = "OPTION_SERIALIZE_DEFAULT_VALUE";
	/**
	 * When value is true, the writer will indent the output JSON document.
	 * <p>Default value is true</p>
	 */
	public static final String OPTION_INDENT_OUTPUT = "OPTION_INDENT_OUTPUT";
	/**
	 * When value is true, the reader will load attributes of proxy objects.
	 * <p>Default value is false</p>
	 */
	public static final String OPTION_PROXY_ATTRIBUTES = "PROXY_ATTRIBUTES";
	/**
	 * When value is true, the writer will include an _id key to each json objects and
	 * sets as value the fragment identifier.
	 * <p>Default value is false</p>
	 */
	public static final String OPTION_USE_ID = "OPTION_USE_ID";
	/**
	 * Specify the URIHandler object to use during serialization of external
	 * references.
	 * <p>By default org.emfjson.jackson.handlers.BaseURIHandler will be use</p>
	 */
	public static final String OPTION_URI_HANDLER = "OPTION_URI_HANDLER";
	/**
	 * Specify the ReferenceSerializer object to use during serialization of
	 * references.
	 * <p>By default org.emfjson.jackson.databind.ser.references.ReferenceAsObjectSerializer will be use</p>
	 */
	public static final String OPTION_REF_SERIALIZER = "OPTION_REF_SERIALIZER";
	/**
	 * Specify the ReferenceDeserializer object to use during deserialization of
	 * references.
	 * <p>By default org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer will be use</p>
	 */
	public static final String OPTION_REF_DESERIALIZER = "OPTION_REF_DESERIALIZER";
	/**
	 * Specify the IdSerializer object to use during serialization of object's id.
	 * <p/>
	 * <p>By default org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer will be use</p>
	 */
	public static final String OPTION_ID_SERIALIZER = "OPTION_ID_SERIALIZER";
	/**
	 * Specify the IdDeserializer object to use during deserialization of object's id.
	 * <p/>
	 * <p>By default org.emfjson.jackson.databind.deser.references.ReferenceAsObjectDeserializer will be use</p>
	 */
	public static final String OPTION_ID_DESERIALIZER = "OPTION_ID_DESERIALIZER";
	/**
	 * Specify the TypeSerializer object to use during serialization of object's type.
	 * <p/>
	 * <p>By default org.emfjson.jackson.databind.deser.DefaultTypeSerializer will be use</p>
	 */
	public static final String OPTION_TYPE_SERIALIZER = "OPTION_TYPE_SERIALIZER";
	/**
	 * Specify the TypeDeserializer object to use during deserialization of object's type.
	 * <p/>
	 * <p>By default org.emfjson.jackson.databind.deser.DefaultTypeDeserializer will be use</p>
	 */
	public static final String OPTION_TYPE_DESERIALIZER = "OPTION_TYPE_DESERIALIZER";
	/**
	 * Specify the field name that will be use to denote the type of objects.
	 * <p>By default eClass will be use</p>
	 */
	public static final String OPTION_TYPE_FIELD = "OPTION_TYPE_FIELD";
	/**
	 * Specify the field name that will be use to denote a reference.
	 * This option is use when a reference is created as a json object.
	 * <p>By default $ref will be use</p>
	 */
	public static final String OPTION_REF_FIELD = "OPTION_REF_FIELD";
	/**
	 * Specify the field name that will be use to denote the id of objects.
	 * <p>By default _id will be use</p>
	 */
	public static final String OPTION_ID_FIELD = "OPTION_ID_FIELD";
	/**
	 * Specify the date format that will be use to parse and write dates.
	 * <p>By default the date format is yyyy-MM-dd'T'HH:mm:ss</p>
	 */
	public static final String OPTION_DATE_FORMAT = "OPTION_DATE_FORMAT";
	/**
	 * Can be use to pass an Option object.
	 */
	public static final String OPTIONS_OBJECT = "OPTIONS_OBJECT";

	private EMFJs() {}

}
