package com.cloudgun.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	private UserDAOService service;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return service.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public User retriveSingleUser(@PathVariable int id) {
		User userObj = service.findOne(id);
		if(userObj == null) {
			//Implementing HATEOAS
			
			throw new UserNotFoundException("Not Found the Following ID: "+ id);
		}
		
		//Resource
		return userObj;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserid(@PathVariable int id) {
		User userObj = service.deleteUserById(id);
		if(userObj == null) {
			throw new UserNotFoundException("Not Found the Following ID: "+ id);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	 
}
