package hr.foi.tbp.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hr.foi.tbp.hibernate.dao.UserRepository;
import hr.foi.tbp.hibernate.model.User;
import hr.foi.tbp.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserById(Long id) {
		return userRepository.findByIdAndDeletedFalse(id);
	}

	@Override
	public void saveUser(User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		user.setModifiedByUsername(username);
		user.setModificationTime(new Timestamp(new Date().getTime()));
		userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		User user = userRepository.findOne(id);
		user.setModifiedByUsername(username);
		user.setModificationTime(new Timestamp(new Date().getTime()));
		user.setDeleted(true);
		
		userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
