package com.write;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import net.sf.json.JSONObject;

import com.app.Person;
//@Provider
//@Produces({"application/xml","application/json"})
public class MyWriter implements MessageBodyWriter<Person> {

	@Override
	public long getSize(Person arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		// TODO Auto-generated method stub
		System.out.println("isWriteable");
		if(arg0==Person.class) return true;
		return false;
	}

	@Override
	public void writeTo(Person arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream arg6)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		System.out.println("writeTo");
		JAXBContext jct=null;
		try {
			 jct= JAXBContext.newInstance(arg0.getClass());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(arg4==MediaType.APPLICATION_XML_TYPE){
			if(jct!=null)
				try {
					jct.createMarshaller().marshal(arg0, arg6);
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(arg4==MediaType.APPLICATION_JSON_TYPE){
			JSONObject jo = JSONObject.fromObject(arg0);
			arg6.write(jo.toString().getBytes("UTF-8"));
				
		}
		
	}

	

}
