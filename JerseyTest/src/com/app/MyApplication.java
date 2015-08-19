package com.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import resource.CarResource;
import resource.CustomerResource;
import resource.SimpleResource;

public class MyApplication extends Application{

	private Set<Class<?>>calsses=new HashSet<Class<?>>();
	private Set<Object>singletons=new HashSet<Object>();
	
	public  MyApplication() {
		// TODO Auto-generated constructor stub
		this.singletons.add(new SimpleResource());
		this.singletons.add(new CarResource());
		this.singletons.add(new CustomerResource());
	}
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return this.calsses;
	}

	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return this.singletons;
	}

	
}
