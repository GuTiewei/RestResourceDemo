package resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.sf.json.JSONObject;

import com.app.Customer;

@Path("/customers")

public class CustomerResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCoustomer2XML(@PathParam("id")int id){
		System.out.println(id);
		return new Customer(id, "gtw", 23);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCoustomer2JSON(@PathParam("id")int id){
		System.out.println(id);
	//	return  new Customer(id, "gtw", 22);
		return JSONObject.fromObject(new Customer(id, "gtw", 22)).toString();
		
	}
	
//	@GET
//	@Path("/response/{id}")
//	@Produces(MediaType.APPLICATION_XML)
//	public Response getResponse2XML(@PathParam("id")int id){
//		
//		return Response.status(Status.OK).entity(new Person(id, "qln", 21)).build();
//		
//	}
	@GET
	@Path("/response/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse2JSON(@PathParam("id")int id){
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("name","gtw");
		map.put("age", "23");
		return Response.status(Status.OK).entity(map).build();
		//return Response.status(Status.OK).entity(new Person(id, "qbs", 22)).build();
		
	}
	
}
