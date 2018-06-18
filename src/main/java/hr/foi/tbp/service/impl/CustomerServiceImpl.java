package hr.foi.tbp.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.foi.tbp.hibernate.dao.CustomerRepository;
import hr.foi.tbp.hibernate.dao.PermissionRepository;
import hr.foi.tbp.hibernate.model.Customer;
import hr.foi.tbp.hibernate.model.Permission;
import hr.foi.tbp.service.CustomerService;

@Component("customerSerice")
public class CustomerServiceImpl extends UserServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findByDeletedFalse();
	}

	@Override
	public void setPermissionsToCustomer(Long customerId, List<Long> permissionIds) {
		Customer user = customerRepository.findOne(customerId);
		Set<Permission> permissions = new HashSet<>();
		for (Long permissionId : permissionIds) {
			permissions.add(permissionRepository.findOne(permissionId));
		}
		
		user.setPermissions(permissions);
		customerRepository.save(user);
		
	}
}
