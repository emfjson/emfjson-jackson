package org.emfjson.common;

import static org.emfjson.EMFJs.OPTION_INDENT_OUTPUT;
import static org.emfjson.EMFJs.OPTION_PROXY_ATTRIBUTES;
import static org.emfjson.EMFJs.OPTION_RESOLVE_PROXY;
import static org.emfjson.EMFJs.OPTION_ROOT_ELEMENT;
import static org.emfjson.EMFJs.OPTION_SERIALIZE_REF_TYPE;
import static org.emfjson.EMFJs.OPTION_SERIALIZE_TYPE;
import static org.emfjson.EMFJs.OPTION_USE_UUID;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

public class Options {

	public final boolean indentOutput;
	public final boolean serializeTypes;
	public final boolean serializeRefTypes;
	public final boolean useProxyAttributes;
	public final boolean useUUID;
	public final boolean resolveProxy;
	public final EClass rootElement;

	Options(boolean serializeTypes,
			boolean serializeRefTypes,
			boolean useProxyAttributes,
			boolean useUUID,
			boolean indentOutput,
			boolean resolveProxy,
			EClass rootElement) {
		this.serializeRefTypes = serializeRefTypes;
		this.serializeTypes = serializeTypes;
		this.useProxyAttributes = useProxyAttributes;
		this.useUUID = useUUID;
		this.indentOutput = indentOutput;
		this.resolveProxy = resolveProxy;
		this.rootElement = rootElement;
	}

	public static Builder from(Map<?, ?> options) {
		return new Builder(options);
	}

	public static class Builder {
		private final Map<? extends Object, ? extends Object> options;

		public Builder() {
			this.options = Collections.emptyMap();
		}

		public Builder(Map<?, ?> options) {
			this.options = options == null ? Collections.emptyMap() : options;
		}

		private boolean booleanValue(Map<?, ?> options, String key, boolean _default) {
			if (options.containsKey(key)) {
				try {
					return (Boolean) options.get(key);
				} catch (ClassCastException e) {
					return _default;
				}
			}
			return _default;
		}

		private EClass objectValue(Map<?, ?> options, String key) {
			Object optionEClass = options.get(key);
			if (optionEClass instanceof EClass) {
				return (EClass) optionEClass;
			}

			return null;
		}

		/**
		 * @return Options setup with clients settings.
		 */
		public Options build() {
			return new Options(
					booleanValue(options, OPTION_SERIALIZE_TYPE, true), 
					booleanValue(options, OPTION_SERIALIZE_REF_TYPE, false), 
					booleanValue(options, OPTION_PROXY_ATTRIBUTES, false), 
					booleanValue(options, OPTION_USE_UUID, false), 
					booleanValue(options, OPTION_INDENT_OUTPUT, true),
					booleanValue(options, OPTION_RESOLVE_PROXY, true),
					objectValue(options, OPTION_ROOT_ELEMENT));
		}
	}
}
