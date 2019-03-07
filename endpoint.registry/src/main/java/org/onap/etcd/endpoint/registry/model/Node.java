package org.onap.etcd.endpoint.registry.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {

	String key;
	String value;
	boolean dir;
	ArrayList<Node> nodes;
	//int modifiedIndex;
	//int createdIndex;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key.substring(1);
	}
	public Node() {
		super();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isDir() {
		return dir;
	}
	public void setDir(boolean dir) {
		this.dir = dir;
	}
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	/*public int getModifiedIndex() {
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
	
	@Override
	public String toString() {
		return "node [key=" + key + ", value=" + value + ", modifiedIndex=" + modifiedIndex + ", createdIndex="
				+ //createdIndex + "]";
	}*/
	
	
	
	
}
