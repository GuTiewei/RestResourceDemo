package resource;

import java.io.Serializable;

public class ToyCar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String model;
	public ToyCar(String name,String model){
		this.name=name;
		this.model=model;
	}
	@Override
	public String toString(){
		return name+model;
	}
}
