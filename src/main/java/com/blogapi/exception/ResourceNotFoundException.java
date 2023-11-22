package com.blogapi.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	 String resource;
	 String fieldname;
	 long fieldvalue;
	
	public ResourceNotFoundException(String resource, String fieldname, Long userid) {
		super(String.format("%s not found with %s : %s",resource,fieldname,userid));
		this.resource = resource;
		this.fieldname = fieldname;
		this.fieldvalue = userid;
	}


}
