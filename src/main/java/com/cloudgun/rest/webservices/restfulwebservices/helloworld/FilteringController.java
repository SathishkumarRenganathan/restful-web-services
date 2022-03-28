package com.cloudgun.rest.webservices.restfulwebservices.helloworld;

import java.util.Date;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudgun.rest.webservices.restfulwebservices.user.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filteredUser")
	public MappingJacksonValue retriveFilteredUser() {
		User userBean = new User(100,"Name1",new Date());
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(userBean);
		mapping.setFilters(filters);
		return mapping;
	}
}
