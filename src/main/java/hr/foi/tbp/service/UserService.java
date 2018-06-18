package hr.foi.tbp.service;

import hr.foi.tbp.hibernate.model.User;

public interface UserService {

	User getUserById(Long id);
	
	User getUserByUsername(String username);
	
	void saveUser(User user);
	
	void deleteUser(Long id);
}
