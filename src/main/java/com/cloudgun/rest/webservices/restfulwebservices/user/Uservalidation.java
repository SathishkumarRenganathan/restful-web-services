package com.cloudgun.rest.webservices.restfulwebservices.user;

public class Uservalidation {
	
	public void valiateUser(User user) {
		
		if(user.getName().chars().allMatch(Character::isDigit))
			throw new DataNotSupportedException("Data Format Exception");
	}

}
