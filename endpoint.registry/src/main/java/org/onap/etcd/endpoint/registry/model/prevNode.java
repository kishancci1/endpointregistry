package org.onap.etcd.endpoint.registry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class prevNode {

	
	String key;
	String value;
	int modifiedIndex;
	public prevNode() {
		super();
	}
	@Override
	public String toString() {
		return "prevNode [key=" + key + ", value=" + value + ", modifiedIndex=" + modifiedIndex + ", createdIndex="
				+ createdIndex + "]";
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getModifiedIndex() {
		return modifiedIndex;
	}
	public void setModifiedIndex(int modifiedIndex) {
		this.modifiedIndex = modifiedIndex;
	}
	public int getCreatedIndex() {
		return createdIndex;
	}
	public void setCreatedIndex(int createdIndex) {
		this.createdIndex = createdIndex;
	}
	int createdIndex;
	
	
}
