package resource;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/cars") 
public class CarResource {

	@Path("{car}-model")
	public CarFactory getCar(@PathParam("car")String car){
		return new CarFactory(car);
	}
	@GET
	@Path("/toycar/{name}-{year}")
	public ToyCar getToyCar(@PathParam("name")String name,@PathParam("year")String year){
		return new ToyCar(name,year);
	}
	
	@GET
	@Path("/show/{p1}/{p2}")
	@Produces({"application/xml","application/json","text/plain"})
	public String showInfo(@Context UriInfo info){
		String str="";
		MultivaluedMap<String, String> params = info.getPathParameters();
		str+="参数列表\n";
		for(Entry entry:params.entrySet()){
			str+=entry.getKey()+"---"+entry.getValue()+"\n";
		}
		str+="路径片段\n";
		List<PathSegment> segs = info.getPathSegments();
		for(PathSegment ps:segs){
			str+=ps.getPath()+"\n";
			 MultivaluedMap<String, String> mps = ps.getMatrixParameters();
			 for(Entry mp:mps.entrySet()){
				 str+="--------"+mp.getKey()+"++++"+mp.getValue()+"\n";
			 }
		}
		return str;
		
	}
	@POST
	public String testPost(@DefaultValue("dafault name")@FormParam("name")String name,@DefaultValue("0") @FormParam("age")int age){
		String info="my name is "+name+"\n";
		info+="i am "+age+"years old\n";
		return info;
	}
	
}
