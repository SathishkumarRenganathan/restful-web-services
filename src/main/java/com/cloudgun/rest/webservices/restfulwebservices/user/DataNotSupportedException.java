package com.cloudgun.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class DataNotSupportedException extends RuntimeException {
	
	public DataNotSupportedException(String message) {
		super(message);
	}

}
