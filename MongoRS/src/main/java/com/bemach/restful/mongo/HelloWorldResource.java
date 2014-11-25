package com.bemach.restful.mongo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

/**
 * helloWorld Root Resource
 */
@Path("helloWorld")
public class HelloWorldResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greet() {
		System.out.println("<>>>>>>>>>>>>>>>");
		return "Hello World!!!";
	}
}