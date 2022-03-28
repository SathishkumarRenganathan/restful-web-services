package com.cloudgun.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	Uservalidation userValidation;

	private static List<User> users = new ArrayList<>();
	private static Integer userCount = 3;
	static {
		users.add(new User(1, "Sathish", new Date()));
		users.add(new User(2, "Sujay", new Date()));
		users.add(new User(3, "Nandhini", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		userValidation.valiateUser(user);
		users.add(user);
		return user;
	}
	 
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUserById(int id) {
		Iterator<User> itrObj = users.iterator();
		while (itrObj.hasNext()) {
			User user = itrObj.next();
			if (user.getId() == id) {
				itrObj.remove();
				return user;
			}
		}
		return null;
	}
}