package com.jax.rs.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.sun.research.ws.wadl.Response;

public class TestClientREST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getbaseURI());
		
		String response = target.path("Test").request().accept(MediaType.TEXT_PLAIN)
				.get(String.class).toString();
		
		String htmlResponse = target.path("Test").request().accept(MediaType.TEXT_HTML)
				.get(String.class);
		
		String xmlResponse = target.path("Test").request().accept(MediaType.TEXT_XML)
				.get(String.class);
		
		System.out.println(response);
		System.out.println(htmlResponse);
		System.out.println(xmlResponse);
		
	}

	private static URI getbaseURI() {
		// TODO Auto-generated method stub
		
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTfulServiceProject").build();
		
		return uri;
	}

}
