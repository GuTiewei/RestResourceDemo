package com.app;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub

		
	    Customer customer = new Customer(2,"gtw",22);  
	
	      
	    JAXBContext ctx = JAXBContext.newInstance(Customer.class);  
	    StringWriter writer = new StringWriter();  
	      
	    ctx.createMarshaller().marshal(customer, writer);  
	      System.out.println(writer.toString());
	    String custString = writer.toString();  
	    customer = (Customer) ctx.createUnmarshaller().unmarshal(new StringReader(custString));  
	    JSONObject jo = JSONObject.fromObject(customer);
	    System.out.println(jo.toString());
	}

}
