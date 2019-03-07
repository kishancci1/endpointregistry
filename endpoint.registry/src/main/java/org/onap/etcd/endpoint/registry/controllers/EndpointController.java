package org.onap.etcd.endpoint.registry.controllers;

import org.onap.etcd.endpoint.registry.model.GetPOJO;
import org.onap.etcd.endpoint.registry.model.Node;
import org.springframework.web.bind.annotation.DeleteMapping;

//import java.util.ArrayList;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

//import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

//import io.etcd.jetcd.ByteSequence;
//import io.etcd.jetcd.Client;
//import io.etcd.jetcd.KV;
//import io.etcd.jetcd.kv.GetResponse;


@RestController
public class EndpointController {

	@RequestMapping(value = "/getendpoint/{id}")
	public GetPOJO getEndpoint(@PathVariable("id") String key)
	{
		
		RestTemplate restTemplate = new RestTemplate();
		GetPOJO g=new GetPOJO();
		
		try 
		{
			
		 g= restTemplate.getForObject("http://127.0.0.1:2379/v2/keys/"+key, GetPOJO.class);	
			
		}
		catch(HttpClientErrorException  e)
		{
			System.out.println("Log: Key Not Found");
			Node n= new Node();
			n.setKey(key);
			n.setValue("KEY NOT FOUND");
			g.setNode(n);
			return g;
		}
		catch(HttpServerErrorException e)
		{
			System.out.println(" Network Error");
			Node n= new Node();
			n.setKey(key);
			n.setValue("NETWORK ERROR");
			g.setNode(n);
			return g;
		
		}
		
		
		return g;
		
	}
	
	/*@RequestMapping(value = "/getkeys")
	public ArrayList<GetPOJO> getValues()
	{
		RestTemplate restTemplate = new RestTemplate();
		GetPOJO g=new GetPOJO();
		
		try 
		{
			
		 g= restTemplate.getForObject("http://127.0.0.1:2379/v2/keys/"+key, GetPOJO.class);	
			
		}
		catch(HttpClientErrorException  e)
		{
			System.out.println("Log: Key Not Found");
			Node n= new Node();
			n.setKey(key);
			n.setValue("NOT FOUND");
			g.setNode(n);
			return g;
		}
		catch(HttpServerErrorException e)
		{
			System.out.println(" Network Error");
			Node n= new Node();
			n.setKey(key);
			n.setValue("NETWORK ERROR");
			g.setNode(n);
			return g;
		
		}
		
		
		return g;
		
	}*/
	
		
	@RequestMapping(value = "/getendpoint/all")	
	public GetPOJO getEndpointList()
	{
		RestTemplate restTemplate = new RestTemplate();
		GetPOJO g=new GetPOJO();
		
		try 
		{
			
		 g= restTemplate.getForObject("http://127.0.0.1:2379/v2/keys/?recursive=true", GetPOJO.class);	
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return g;
		
	}
	
	
			
	
	@PutMapping(value="/putendpoint/{key}/{value}")
	public void putEndpoint(@PathVariable("key") String key, @PathVariable("value") String value)
	{
		//@Autowired
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://127.0.0.1:2379/v2/keys/"+key+"?value="+value, null);
		
	}
	
	@DeleteMapping(value="/deleteendpoint/{key}")
	public void deleteEndpoint(@PathVariable("key") String key)
	{
		try
		{
			RestTemplate resttemplate = new RestTemplate();
			resttemplate.delete("http://127.0.0.1:2379/v2/keys/"+key);
		}
		catch(HttpClientErrorException  e)
		{
			System.out.println("The eneterd key value dosent exist");
			
		}
		
	}
	
}
