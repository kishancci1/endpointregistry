package org.onap.etcd.endpoint.registry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPOJO {
	
	String action;
	Node node;
	
	
	public GetPOJO() {
		super();
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public Node getNode() {
		return node;
	}


	public void setNode(Node node) {
		this.node = node;
	}


	@Override
	public String toString() {
		return "GetPOJO [action=" + action + ", node=" + node + "]";
	}
	
	
	
	

}
