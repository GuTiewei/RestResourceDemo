package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public class CarFactory {
	private String carType;
	public  CarFactory(String carType){
		this.carType=carType;
	}
	@GET
	@Path("{year}")
	@Consumes("*/*")
	@Produces("*/*")
	public String getCar(@PathParam("year")String year){
		//year="1999";
		if("BCCar".equals(carType)) return "±¼³Û³µ"+year;
		else if("BMCar".equals(carType)) return "±¦Âí³µ"+year;
		else return "error";
	}
}
