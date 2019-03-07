package org.onap.etcd.endpoint.registry.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.onap.etcd.endpoint.registry.model.GetPOJO;
import org.onap.etcd.endpoint.registry.model.Node;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.Silent.class)
public class EndpointControllerTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private EndpointController endpointController;

	@Test
	public void getEndpointTest() {
			
			Node n= new Node();
			n.setKey("/foo");
			n.setValue("bar");
			GetPOJO p= new GetPOJO();
			p.setNode(n);
			p.setAction("get");
			
	  
	        Mockito
	          .when(restTemplate.getForObject("http://127.0.0.1:2379/v2/keys/t1", GetPOJO.class))
	          .thenReturn(p);
	        GetPOJO returnedMockObject=endpointController.getEndpoint("t1");
	        assertEquals("bar",returnedMockObject.getNode().getValue());
	    }
	
	

}
