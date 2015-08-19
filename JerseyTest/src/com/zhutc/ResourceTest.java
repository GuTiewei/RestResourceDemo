package com.zhutc;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Consumes("*/*")
public class ResourceTest {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		
		return "hello";
	}
	
	
	@GET
	@Path("{id}/sub")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("*/*")
	public String test(@PathParam("id")String id, @QueryParam("name")String name){//,@QueryParam("name")String name
		System.out.println("id----------"+id);
		System.out.println("name---------"+name);
		return "test1"+id;
	}
}
