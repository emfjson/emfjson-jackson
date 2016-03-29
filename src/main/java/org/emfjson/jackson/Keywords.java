package org.emfjson.jackson;

public class Keywords {

	public final String _type;
	public final String _ref;
	public final String _id;

	Keywords(String _type, String _ref, String _id) {
		this._type = _type;
		this._ref = _ref;
		this._id = _id;
	}

	public static Keywords create() {
		return new Builder().build();
	}

	public static class Builder {
		public String keyType = "eClass";
		public String keyRef = "$ref";
		public String keyId = "_id";

		public Builder type(String key) {
			this.keyType = key;
			return this;
		}

		public Builder id(String key) {
			this.keyId = key;
			return this;
		}

		public Builder ref(String key) {
			this.keyRef = key;
			return this;
		}

		public Keywords build() {
			return new Keywords(keyType, keyRef, keyId);
		}
	}

}
