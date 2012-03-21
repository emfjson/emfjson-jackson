(function(){
	"use strict";
	if(!this.ecore){
		this.ecore = {};
	}

	var refAttribute = "$ref",
	indexAttribute = "_index";

	var Resource = function(){
		var content = {};
	};
	Resource.prototype.load = function(data){
		if (data) {
			var root = undefined;
			if (typeof(data) === "object") {
				root = data;
			} else {
				try {
					root = JSON.parse(data);
				} catch (e) {
					console.log(e.message);
				}
			}
			if (root) {
				root[indexAttribute] = "/";
				indexes["/"] = root;
				buildIndexes(root, getIndex);
				resolveReferences(root);
			}
			this.content = root;
		}
	};

	var ResourceSet = function(){
		var resources = [];
		var indexes = {};
	};
	ResourceSet.prototype.createResource = function(data){
		var res = new Resource();
		res.load(data);
		if (!this.resources) {this.resources = [];} 
		this.resources.push(res);
		return res;
	};

	ecore.resourceSet = new ResourceSet();

	/*
	 * returns index of object according to its parent and holding property.
	 */
	function getIndex(parent, property, position){
		var index = parent[indexAttribute] + "/@" + property;
		if (position >= 0) {
			index = index + "." + position;
		}
		return index;
	};

	var indexes = {};
	/**
	 * 
	 */
	function buildIndexes(object, func){
		var current, index, keys = _.without(_.keys(object), refAttribute, indexAttribute);

		_.each(keys, function(key){
			if (_.isArray(object[key])){
				for (var i = 0, l = object[key].length; i<l; i++){
					current = object[key][i];
					index = func.apply(this, [object, key, i]);
					current[indexAttribute] = index;
					indexes[index] = current;
					buildIndexes(current, func);
				}
			} else if (typeof(object[key]) === "object"){
				current = object[key];
				index = func.apply(this, [object, key]);
				current[indexAttribute] = index;
				indexes[index] = current;
				buildIndexes(object[key], func);
			}
		});
	}

	function resolveReferences(object){
		var keys = _.without(_.keys(object), indexAttribute);
		_.each(keys, function(key){
			if (!_.isUndefined(object[key])){ 
				if (_.has(object[key], refAttribute)){
					var ref = object[key][refAttribute];
					if (!_.isUndefined(ref)) {
						object[key] = indexes[ref];
					}
				}
			}
			if (typeof(object[key]) === "object"){
				resolveReferences(object[key]);	
			}
		});
	}

	var EObject = function(object){
		if (object){
			if (_.has(object, "eClass")) {
				return object;
			}
		};
	}

	EObject.prototype.eClass = function(){

	};

}).call(this);

