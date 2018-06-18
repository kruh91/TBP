package hr.foi.tbp.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.foi.tbp.hibernate.dao.EmployeeRepository;
import hr.foi.tbp.hibernate.model.Employee;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	/** The log. */
	private final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.debug("Authenticating {}", username);
		
		Employee user = employeeRepository.findByUsernameAndActiveTrueAndDeletedFalse(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database!");
		}
		
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
	}

}
