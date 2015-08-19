package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/simple")
@Produces("*/*")
public class SimpleResource {

	@GET
	@Produces("*/*")
	public String getResource(){
		return "resource";
	}
	
	@GET
	@Produces("*/*")
	@Path("{id}")
	public String test(@PathParam("id")String id, @QueryParam("name")String name){//,@QueryParam("name")String name
		System.out.println("id----------"+id);
		System.out.println("name---------"+name);
		return "test1"+id;
	}
	
	
}
